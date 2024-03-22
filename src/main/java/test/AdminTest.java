package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.*;
import org.automation.pageObjects.PaymentPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;
import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.WebdriverWaits.*;
import static test.SuperAdminTest.*;

public class AdminTest extends BaseTest {
    String clientLastName;
    String clientFirstName;
    String diagnosticianUserName;
    String directorFirstName;
    String directorUserName;
    String dirCellNumber;
    String directorEmailAddress;
    String directorLastName;
    String clientEmail;
    String clientEmail2;
    String parentName;
    String clientCellNumber;
    String diagnosticianFirstName;
    String diagnosticianLastName;
    String diagnosticianEmailAddress;


    @Test(priority = 0, enabled = true, description = "1.1 Verify admin is able to login with valid credentials")
    public void admin_login() {
        LoginPage login = new LoginPage();

        //Login by using superAdmin credentials

        //Verify that admin is able to login into account using valid 'Username' and 'Password' on 'Sign in your account' page.
        login.admin_Login();
        AdminPage dasboard = new AdminPage();
        WebdriverWaits.waitUntilVisible(dasboard.adminDashboardText);
        waitForSpinner();
        validate_text(dasboard.adminDashboardText, "Dashboard");
    }

    @Test(priority = 1, enabled = true, description = "1.16 Verify that admin is directed to '<Client name> details' page after clicking on any client name under 'Background form not submitted' section, on 'Dashboard' page.")
    public void validate_ClientDetail() {
        AdminPage admin = new AdminPage();
        admin.click_ClientLink();
        WebdriverWaits.waitUntilVisible(admin.clientDetail);
        WebdriverWaits.waitForSpinner();

        //Verify that admin is directed to '<Client name> details' page after clicking on any client name under 'Background form not submitted' section, on 'Dashboard' page.
        String clientDetailPage = getText_custom(admin.clientDetail);
        validate_text(admin.clientDetail, clientDetailPage);
    }

    @Test(priority = 2, enabled = true, description = "1.17 Verify that admin is directed to '<Client name> details' page after clicking on any client name under 'Follow-Ups to be scheduled' under, on 'Dashboard' page.")
    public void validate_FollowUpScheduled_ClientDetail() {
        AdminPage admin = new AdminPage();
        admin.click_ScheduledClient();
        WebdriverWaits.waitUntilVisible(admin.clientNme);
        WebdriverWaits.waitForSpinner();

        //Verify that admin is directed to '<Client name> details' page after clicking on any client name under 'Follow-Ups to be scheduled' under, on 'Dashboard' page.
        String clientDetailPage = getText_custom(admin.clientNme);
        validate_text(admin.clientNme, clientDetailPage);
    }

    //********* Create Daignostician by admin
    @Test(priority = 3, enabled = true, description = "6.1, 5.7, 1.19, 5.6,5.3 Create diagnostician by admin")
    public void verify_CreateDiagnostician() throws InterruptedException, IOException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        //Login by using superAdmin credentials

        //Verify that admin is able to login into account using valid 'Username' and 'Password' on 'Sign in your account' page.

        // Click on diagnostician tab from left panel.
        panelPage.click_DiagnosticianTab();
        WebdriverWaits.waitUntilVisible(diagnostician.diagListPageText);
        WebdriverWaits.waitForSpinner();
        //Verify that admin is directed to 'Diagnosticians List' page after clicking 'Diagnosticians' tab from left panel, on 'Dashboard' page.
        validate_text(diagnostician.diagListPageText, "Diagnosticians List");
        //Create Diagnostician.
        diagnosticianFirstName = "AU_Craig" + RandomStrings.requiredCharacters(3);
        diagnosticianLastName = "AU_Dixon" + RandomStrings.requiredCharacters(3);
        diagnosticianUserName = "AU_Colin" + RandomStrings.requiredCharacters(3);
        diagnosticianEmailAddress = "Tran" + "10@yopmail.com";
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);

        diagnostician.click_createDiagnosticianButton();

        //  Back to diagnostician list page
        diagnostician.click_BackBtn();
        WebdriverWaits.waitUntilVisible(diagnostician.diagnosticListText);
        WebdriverWaits.waitForSpinner();

        //Verify that admin is directed to 'Diagnosticians List' page after clicking 'Diagnosticians' tab from left panel, on 'Dashboard' page.
        validate_text(diagnostician.diagnosticListText, "Diagnosticians List");

        // Creating Diagnostician
        diagnostician.click_createDiagnosticianButton();

        //Verify that appropriate options appear after clicking 'Assign Location' dropdown list & selected options appear in 'Assign Location' field on 'Create Diagnostician' page
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, diagnosticianPhoneNumber, diagnosticianEmailAddress, "Woodlands", diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);

        //validate Diagnostician
        WebdriverWaits.waitForSpinner();
        PropertiesUtil.setpropertyValue("diagnostician_userName", diagnosticianUserName);
        diagnostician.enter_InSearchField(PropertiesUtil.getPropertyValue("diagnostician_userName"));
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }

    @Test(priority = 4, enabled = true, description = "22, 23, 24, 19, 20, 21, 18  availability for diagnostician by admin")
    public void verify_DiagnosticianAvailability() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        logout.click_LogOutLink();
        String diagnosticianUserName = PropertiesUtil.getPropertyValue("diagnostician_userName");
        String diagnosticianPassword = PropertiesUtil.getPropertyValue("diagnostician_oldpassword");
        login.diagnostician_LoginWithOldPassword(diagnosticianUserName, diagnosticianPassword);

        //Set availability
        diagnostician.set_Availability();

        //Cancel Availabilty
        diagnostician.cancel_Availability();

        //Delete Availabilty
        diagnostician.deleting_Availability();
        logout.click_LogOutLink();
    }


    @Test(priority = 5, enabled = true, description = "1.18, 3.1, 3.6, 4.1, 3.10, 3.9  Creating Director from admin")
    public void verify_createDirector() throws InterruptedException, IOException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        LoginPage login = new LoginPage();

        //  login.adminLogin(adminUserName, "12345678");
        directorFirstName = "AU_Felix" + RandomStrings.requiredCharacters(3);
        directorLastName = "AU_Cole" + RandomStrings.requiredCharacters(3);
        directorEmailAddress = "AU_Lee" + "@yopmail.com";
        directorUserName = "AU_Bell" + RandomStrings.requiredCharacters(3);
        dirCellNumber = RandomStrings.requiredDigits(10);
        login.admin_Login();

        //Verify that admin is directed to 'Directors List' page after clicking 'Directors' tab from left panel, on 'Dashboard' page.
        panelpage.click_DirectorTab();
        WebdriverWaits.waitUntilVisible(director.directorActualText);
        WebdriverWaits.waitForSpinner();
        validate_text(director.directorActualText, "Directors List");

        director.click_CreateDirectorsButton();

        //Verify that admin is directed back to 'Directors List' page after clicking 'Back' button on 'Create Director' page.
        director.click_BackBtn();
        WebdriverWaits.waitUntilVisible(director.directorActualText);
        WebdriverWaits.waitForSpinner();
        validate_text(director.directorActualText, "Directors List");

        //Verify that admin is able to enter valid data in all mandatory fields on 'Create Director' page.
        director.click_CreateDirectorsButton();
        director.create_Director(directorFirstName, directorLastName, dirCellNumber, directorEmailAddress, "Woodlands",directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.directorActualText);
        WebdriverWaits.waitForSpinner();
        validate_text(director.directorActualText, "Directors List");
        PropertiesUtil.setpropertyValue("directorFirstName", directorFirstName);
        PropertiesUtil.setpropertyValue("directorLastName", directorLastName);
        PropertiesUtil.setpropertyValue("director_userName", directorUserName);

        panelpage.click_LogOutLink();
    }

    @Test(priority = 6, enabled = true, description = "Set availability for director by admin.")
    public void director_Availability() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        String username = PropertiesUtil.getPropertyValue("director_userName");
        String password = PropertiesUtil.getPropertyValue("director_oldpassword");
        login.director_LoginWithOldPassword(username, password);
        DirectorPage director = new DirectorPage();
        panelPage.click_Availability();
        director.director_Availability(2);
        panelPage.click_LogOutLink();
    }

    @Test(priority = 7, enabled = true, description = "2.1, 2.2, 2.5, 2.10, 2.12,1.20, 2.14,2.13 Appointment scheduled by admin for a client")
    public void verify_ScheduleAppointment() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        login.admin_Login();

        //Verify that admin is directed to 'Create Appointment' page after clicking 'Schedule Appointment' button from left panel, on 'Dashboard 'page.
        dashboard.clickScheduleAppointment();
        WebdriverWaits.waitUntilVisible(appPage.titleText);
        validate_text(appPage.titleText, "Create Appointment");

        //Verify that appropriate dropdown list appears after clicking on 'Choose Testing Location' field, while scheduling an appointment, on 'Create Appointment' page.
        appPage.locationName_Lists();

        //Verify that admin is able to select any location from 'Choose Testing Location' dropdown list, while scheduling an appointment, on 'Create Appointment' page.
        appPage.selectTestinglocation("Woodlands");

        //Verify that calendar appears after admin clicks on 'Assessment Date' field  under 'Preferred Location & Date' section, on 'Create Appointment' page.
        appPage.selectAppointmentSlot(0);

        appPage.selectAssesmentType("Adult ADHD Only");
        validate_SelectedOption(appPage.assestmentType, "Adult ADHD Only");
    }

    @Test(priority = 8, enabled = true, description = "2.25, 2.26, 2.27, 2.28, 2.29,2.42, 2.43,  Filling client details by admin.")
    public void fill_clientDetailsSection() throws InterruptedException, IOException {
        AppointmentsPage fillClientDetails = new AppointmentsPage();
        clientFirstName = "AU_Dunn" + RandomStrings.requiredCharacters(3);
        clientLastName = "AU_Jade" + RandomStrings.requiredCharacters(3);
        clientCellNumber = RandomStrings.requiredDigits(10);
        clientEmail = "AU_Mia" + "@yopmail.com";
        clientEmail2 = "AU_Pipa" + "101@yopmail.com";
        parentName = "AU_Kerr" + RandomStrings.requiredCharacters(3);
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, parentName, "19-11-2000", "Grade 2", "Private", clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
        PropertiesUtil.setpropertyValue("clientFirstName", clientFirstName);
        PropertiesUtil.setpropertyValue("clientLastName", clientLastName);
        PropertiesUtil.setpropertyValue("clientEmail", clientEmail);
    }

    @Test(priority = 9, enabled = true, description = "11.1, 22.1, 22.2 Verify that admin is able to cancel the appointment or not")
    public void cancel_Appointment() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        //Verify that 'Cancel Appointment' popup appears after clicking 'Cancel Appointment' button, on '<Client> Details' page.
        //Verify that admin is directed to '<Client> Details' page, after clicking 'Back' button, on 'Cancel Appointment' popup of '<Client> Details' page.
        appPage.click_CancelAppointmentBackBtn();
        admin.scrolltoUp();
        validate_text(admin.clientNameDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + " Details");
       Thread.sleep(5000);
        appPage.click_CancelAppointmentButton();
        WebdriverWaits.waitUntilVisible(admin.dashboardPage);
        WebdriverWaits.waitForSpinner();
        //Verify that admin is directed to 'Canceled Appointments' page after clicking 'Canceled' sub tab from left panel.
        validate_text(admin.dashboardPage, "Canceled Appointments");
        admin.click_filterButton();

        //Verify that admin is directed to 'Canceled Appointments' page after clicking 'Canceled' sub tab from left panel.
        String searchPlaceholder = admin.getAttributevalue(admin.searchFieldName, "placeholder");
        Assert.assertEquals(searchPlaceholder, "Type here to search");
    }

    @Test(priority = 10, enabled = true, description = "Diagnostician is verifying cancelled appointments")
    public void verify_CancelledAppointment() {
        AdminPage admin = new AdminPage();
        admin.verify_CancelledApp(PropertiesUtil.getPropertyValue("clientFirstName"));
        WebdriverWaits.waitUntilVisible(admin.clientNameTextTitle);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientNameTextTitle, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName"));
    }

    @Test(priority = 11, enabled = true, description = "8.11, 8.19, 2.38/1, 2.39,9.18,9.19,9.21 Appointment scheduled by admin for a client")
    public void verify_ReScheduleAppointment() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        AppointmentsPage fillClientDetails = new AppointmentsPage();

        //Verify that admin is directed to 'Dashboard' page after clicking 'Go Back' button on 'Create Appointment' page.
        dashboard.clickScheduleAppointment();
        appPage.navigate_appointmentDashboardPage();
        validate_text(appPage.dashboardTitleText, "Dashboard");

        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Woodlands");
        appPage.selectAppointmentSlot(0);
        appPage.selectAssesmentType("Adult ADHD Only");

        //Verify that 'Booking payment' pop up appears after clicking 'Continue to Deposit' button, on 'Create Appointment' page.
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, parentName, "19-11-2000", "Grade 2", "Private", clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
        validate_text(admin.clientDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + " Details");
    }
    @Test(priority = 12, enabled = true, description = "19.18, Admin is able to click client detail page after clicking on 'View Details' button")
    public void click_ViewDetailsButton() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_UpcomingTab();
        //Verify that admin is directed to '<client Details>' page, after clicking 'View Details'  button on 'Upcoming Appointments' page.
        admin.filter_ForUpcoming(PropertiesUtil.getPropertyValue("clientLastName"));
        admin.click_ViewDetailsBtn();

        validate_text(admin.clientDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + " Details");
    }

    //********************** Create Follow Up For Client ***********************//

    @Test(priority = 13, enabled = true, description = "16.1, 16.7, 16.13, 16.14, 16.21  Creat follow up for client by admin")
    public void create_FollowUp() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.click_CreateFollowUpBtn();
        admin.click_FollowUpCloseBtn();
        WebdriverWaits.waitUntilVisible(admin.clientDetail);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + " Details");
        admin.click_CreateFollowUpBtn();
        admin.cancel_FollowUpSlot(0);

        //Verify that 'Follow Up' popup appears after clicking preferred slot, on 'Calander' popup of '<Client> Details' page.
        admin.create_FollowUp(0);
        WebdriverWaits.waitUntilVisible(admin.validateScheduledFollowUp);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.validateScheduledFollowUp, "Follow Up Scheduled!!");

        //Verify that admin is directed to '<Client> Details page after clicking 'Back' button, on  'Follow Up Scheduled!' success popup
        admin.click_BackBtn();
        WebdriverWaits.waitUntilVisible(admin.clientDetail);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + " Details");
    }

    //******To Do************
    @Test(priority = 14, enabled = true, description = "8.6,8.7, 8.8,8.10,8.9,2.43 Re-Assign Appointment for client by admin")
    public void re_AssignAppointment() {
        AdminPage admin = new AdminPage();
        admin.reAssign_Appointment("Austin");

//        List<WebElement> reassigList = reAssign.get_diagList(reAssign.diagList);
//        boolean result = reAssign.compare_DiagAndReAssignDiagList(diagList, reassigList);
//        Assert.assertTrue(result);
    }

    @Test(priority = 15, enabled = true, description = "8.2, Re-Assign Appointment for client by admin")
    public void verify_EditAssessmentTypePopUp() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.click_EditAssessment();
        //Verify that 'Change Assement Type' pop up appears on clicking 'Edit Assessment Type' button , on '<Client Details>' page.
        validate_text(admin.assType, "Change Assessment Type");
    }

    @Test(priority = 16, enabled = true, description = "8.3, Verify Edit Assessment type button .")
    public void verify_EditAssessmentType() throws InterruptedException {
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("IQ");
        editType.click_UpdateBtn();
        //Verify that appropriate option appears after clicking 'Assessment Type' field and admin is able to select any option from it, on 'Change Assessment Type' pop up of  '<Client Detail>' page.
        WebdriverWaits.waitUntilVisible(editType.clientAsses);
        validate_text(editType.clientAsses, "IQ");
    }

    @Test(priority = 17, enabled = true, description = "8.3,8.25 Verify Edit Assessment type button .")
    public void verify_ReScheduleApp() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.re_ScheduleApp();
    }


    @Test(priority = 18, enabled = true, description = "12.1, Verify Test plan button on <Client> details page.")
    public void verify_TestPlanBtn() {
        AdminPage admin = new AdminPage();
        WebdriverWaits.waitForSpinner();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_ViewAllTab();
        admin.enterInSearchField(PropertiesUtil.getPropertyValue("clientFirstName"));
        admin.click_ViewDetail();
        admin.click_TestPlan();
        //Verify that 'Test Plan' pop up appears after clicking 'Test Plan' button, on '<Client> Details page.
        validate_text(admin.testPlanText, "Please choose tests.");
    }

    @Test(priority = 19, enabled = true, description = "12.3, 12.2 Verify save Test plan button on <Client> details page.")
    public void verify_PlanTest() {
        AdminPage admin = new AdminPage();
        admin.select_TestPlan();
        admin.click_TestPlanSaveButton();
        WebdriverWaits.waitUntilVisible(admin.validateCheckBox);
        validate_text(admin.validateCheckBox, "WJ Achievement");
        //Verify that admin is able to choose all preferred tests and surveys under 'Please choose tests' & 'Please choose surveys' sections respectively, on 'Test Plan' popup of '<Client> Details' page.
        admin.validate_TestsList();
    }

    @Test(priority = 20, enabled = true, description = "8.5, Verify save Test plan button on <Client> details page.")
    public void verify_DontSaveAssessmentType() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.click_EditAssessment();
        admin.edit_AssessmentType("GT");
        //Verify that changes made by admin in 'Assessment Type' field does not get saved, after clicking 'Don't Save' button on 'Change Assessment Type' pop up, of '<Client Details>' page.
        admin.click_DontSave();
        WebdriverWaits.waitUntilVisible(admin.clientAsses);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientAsses, "IQ");
    }

    @Test(priority = 21, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void verify_EditTestPlan() {
        AdminPage testPlan = new AdminPage();
        testPlan.edit_TestPlan();
        validate_text(testPlan.actualEditTest, "WRAML");
    }

    //***************************** Collect Payment PopUp *************************//
    public float beforeAssessmentAmount;
    public float beforeAmountDue;
    public float beforeReceviedAmount;
    public float afterAssessmentAmount;
    public float afterAmountDue;
    public float afterRececiedAmount;


    @Test(priority = 22, enabled = true, description = "10.1,Verify payment button on <Client> details page.")
    public void verify_PaymentBtn() {
        AdminPage payment = new AdminPage();
        beforeAssessmentAmount = Float.parseFloat(payment.get_AssessmentAmount());
        beforeAmountDue = Float.parseFloat(payment.get_AmountDue());
        beforeReceviedAmount = Float.parseFloat(payment.get_ReceivedAmount());
        payment.click_PaymentBtn();
        //Verify that 'Collect Payment' popup opens up after clicking 'Payment' button, on '<Client> Details' page.
        WebdriverWaits.waitUntilVisible(payment.collectPayActualText);
        validate_text(payment.collectPayActualText, "Collect Payment");
    }

    @Test(priority = 23, enabled = true, description = "10.2,10.4 Verify payment button on <Client> details page.")
    public void verify_CollectTestFeeAdjustment() {
        AdminPage admin = new AdminPage();
        //Verify that 'Test Fee Adjustment' field accepts positive amount and that positive amount gets added to 'Assessment Amount' and 'Amount Due' values, on 'Collect Payment' pop up of'<Client> Details' page.
        admin.validate_FeeAdjustmentAmount("50");
        //Verify that 'Collect Amount Adjustment' field accepts positive amount and that amount gets added in 'Received Amount' value and substracted from  'Amount Due' value, on 'Payment' booking popup of '<Client> Details' page
        admin.validate_CollectAmountAdjustment("50");
        afterAssessmentAmount = Float.parseFloat(admin.get_AssessmentAmount());
        afterAmountDue = Float.parseFloat(admin.get_AmountDue());
        afterRececiedAmount = Float.parseFloat(admin.get_ReceivedAmount());
        String assessmentAmtDiff = Float.toString(afterAssessmentAmount - beforeAssessmentAmount).replace(".0", "");
        String recAmtDiff = Float.toString(afterRececiedAmount - beforeReceviedAmount).replace(".0", "");
        Assert.assertEquals(assessmentAmtDiff, "50");
        Assert.assertEquals(recAmtDiff, "100");
    }

    @Test(priority = 24, enabled = true, description = "9.1, Verify Edit client Details button client page.")
    public void verify_EditClientBtn() {
        AdminPage EditClient = new AdminPage();
        //Verify that 'Edit Client info' pop up appears after clicking 'Edit Client' button on '<Client> Details' page.
        EditClient.click_EditClientBtn();
        WebdriverWaits.waitUntilVisible(EditClient.editCllientActualText);
        validate_text(EditClient.editCllientActualText, "Edit Client Info");
    }

    @Test(priority = 25, enabled = true, description = "9.9, 9.10, 9.11, 9.12, 9.13, 9.16,9.17,9.18, 9.19, 9.23 Verify Edit client details popup client page.")
    public void verify_UpdateBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.edit_ClientInfo(clientFirstName, clientLastName, "401 Broadway E eastate g", "College", "Private", "Math", "Grade 2", "I am doing simple testing");

        //Verify that changes gets discarded after clicking 'Don't Save' button, on 'Edit Client info' pop up, of  '<Client> Details' page.
        admin.click_DontSaveBtn();

        admin.click_EditClientBtn();
        admin.edit_ClientInfo(clientFirstName, clientLastName, "401 Broadway E eastate g", "College", "Private", "Math", "Grade 2", "I am doing simple testing");
        admin.click_UpdateClientBtn();
       Thread.sleep(4000);
        WebdriverWaits.waitUntilVisible(admin.messageText);
        WebdriverWaits.waitForSpinner();
        admin.scrollIntoView(admin.messageText);
        String enteredTexts = "I am doing simple testing";
        validate_text( admin.messageText, enteredTexts);
    }

    @Test(priority = 26, enabled = true, description = "13.1, 23.1 verify hold appointment button.")
    public void verify_HoldAppointmentBtn() {
        AdminPage hold = new AdminPage();
        hold.click_HoldAppointmentBtn();
        validate_text(hold.holdActualText, "Are you sure you want to hold this appointment?");
    }

    @Test(priority = 27, enabled = true, description = "7.1, 13.2, verify yes hold button on hold appointment button.")
    public void verify_yesHoldBtn() {
        AdminPage admin = new AdminPage();
        //Verify that appointment gets on hold after clicking on 'Yes, Hold' button, on 'Hold Appointment' popup of '<Client> Details page.
        admin.click_yesHoldBtn();
        WebdriverWaits.waitUntilVisible(admin.allAppointmentsPage);
        WebdriverWaits.waitForSpinner();
        //Verify that admin is directed to ' All Appointments' page, after clicking 'View All' sub-tab on 'Dashboard' page.
        validate_text(admin.allAppointmentsPage, "All Appointments");
    }

    @Test(priority = 28, enabled = true, description = "13.3, 23.5,23.1,13.1 verify yes hold button on hold appointment popup.")
    public void verify_HoldAppointment() {
        AdminPage admin = new AdminPage();
        //Verify that 'Hold Appointment' pop up appears after clicking 'Hold' button on '<Client>Details'  page.
        admin.click_HoldTab();
        validate_text(admin.holdAppointmentText, "Hold Appointments");
    }

    @Test(priority = 29, enabled = true, description = "23.6 verify filter button on hold appointment page.")
    public void verify_holdfilterButton() {
        AdminPage admin = new AdminPage();
        admin.click_HoldFilterBtn();

        //Verify that search textbox, 'From Date' and 'To Date' date picker appears after clicking on 'Filter' button, on 'Hold Appointments' page.
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
    }

    @Test(priority = 30, enabled = true, description = "23.7, 23.21 verify holded appointment .")
    public void verify_holdedAppointment() throws InterruptedException, FileNotFoundException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        //Verify that relevant records appear after entering valid data in search textbox, on 'Hold Appointments' page.
        admin.send_TextHoldSearchBox(PropertiesUtil.getPropertyValue("clientFirstName"));
        validate_text(admin.validateHoldClient, PropertiesUtil.getPropertyValue("clientEmail"));
       // admin.click_HoldBackBtn();
        WebdriverWaits.waitUntilVisible(admin.holdAppointmentText);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.holdAppointmentText, "Hold Appointments");

        //Verify that CSV file gets downloaded, after clicking on 'Export to CSV' button on 'Hold Appointments' page.
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
        admin.navigate_Back();

        admin.send_TextHoldSearchBox(PropertiesUtil.getPropertyValue("clientFirstName"));
        admin.click_unHoldBtn();
        WebdriverWaits.waitForSpinner();
    }

    @Test(priority = 31, enabled = true, description = "7.1,  Verify All Appointment page.")
    public void verify_AllAppointmentsPage() {
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.click_ViewAllTab();
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(appPage.viewAllActualText);
        WebdriverWaits.waitForSpinner();
        validate_text(appPage.viewAllActualText, "All Appointments");
    }

    @Test(priority = 32, enabled = true, description = "Verify filter button and serarchtextbox textbox")
    public void search_CreatedAppointment() {

        AdminPage admin = new AdminPage();
        admin.enter_InSearchField(PropertiesUtil.getPropertyValue("clientFirstName"));
        WebdriverWaits.waitUntilVisible(admin.getStatus);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.getStatus, "Test Ready");
        admin.click_ViewDetailsLink();
        WebdriverWaits.waitUntilVisible(admin.clientNameDetail);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientNameDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + " Details");
    }

    @Test(priority = 33, enabled = true, description = "7.15, 7.17, 8.1,7.3 Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException, FileNotFoundException {

        //Verify that relevant records appear after selecting valid range of date, on 'All Appointments' page
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        appPage.click_ViewAllTab();

        //Verify that admin is directed to '<client Details>' page after clicking 'View Details'  button on 'All Appointments' page.
        //Verify that relevant records appear after entering valid data in search textbox, on 'All Appointments' page
        admin.enter_InSearchField(PropertiesUtil.getPropertyValue("clientFirstName"));

        String toDate = DateGenerator.getCurrentDate();

        //Verify that relevant records appear after selecting valid range of date, on 'All Appointments' page
        String FromDate = DateGenerator.getDateWithDays("dd-MM-yyyy", -2);
        admin.click_filterButton();
        appPage.enter_Dates(FromDate, toDate);
        admin.click_SearchButton();
        WebdriverWaits.waitUntilVisible(appPage.dateEle);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(4000);
        List<WebElement> my_list = admin.getWebElements(appPage.dateEle);
        HashSet<WebElement> dateSet = new HashSet<>(my_list);

        LocalDate toDateLocal = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fromDateLocal = LocalDate.parse(FromDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        boolean result = true;
        for (WebElement i : dateSet) {
            String date = i.getText();
            LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            if (!(DateGenerator.isDateWithinRange(fromDateLocal, toDateLocal, inputDate))) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);

        //Verify that CSV file gets downloaded after clicking on 'Export to CSV' button on 'All Appointments' page
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));

    }

    @Test(priority = 33, enabled = true, description = "Search created diagnostician by admin")
    public void verify_SearchDiagnostician() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        AdminPage admin = new AdminPage();
        DashBoardPanelPage clickDiagnosticianTab = new DashBoardPanelPage();
        admin.navigate_Back();
        clickDiagnosticianTab.click_DiagnosticianTab();
        diagnostician.enter_InSearchField(PropertiesUtil.getPropertyValue("diagnostician_userName"));
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }

    @Test(priority = 34, enabled = true, description = "6.14 verify that superAdmin is able to edit or not after clicking Dont save button")
    public void verify_Dia_DontSaveBtn() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.cheking_DisableUser();
        diagnostician.enter_InSearchField(PropertiesUtil.getPropertyValue("diagnostician_userName"));
        diagnostician.verify_DontSave("5659865589", diagnosticianEmailAddress, "123456", "123456");
        validate_text(diagnostician.UserNameGetText, PropertiesUtil.getPropertyValue("diagnostician_userName"));
    }

    @Test(priority = 35, enabled = true, description = "4.6 ,4.10,6.2, 6.11, Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        // Edit Diagnostician
        String diagnosticianUpdatedEmail = diagnosticianFirstName + "10@yopmail.com";
        diagnostician.enter_InSearchField(PropertiesUtil.getPropertyValue("diagnosticianFirstName"));
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail, "12345678", "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
      //  validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }

    @Test(priority = 36, enabled = true, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //Enable disabled Diagnostician
        diagnostician.enter_InSearchField(PropertiesUtil.getPropertyValue("diagnosticianFirstName"));
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }

    //******************* Edit Director ***************//

    @Test(priority = 37, enabled = true, description = "3.10, 4.6, 4.11, 4.13, 6.6,4.5 Creating Director from admin")
    public void verify_Edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage clickDirectorTab = new DashBoardPanelPage();
        clickDirectorTab.click_DirectorTab();

        //Verify that relevant records appears after entering valid data in search textbox, on 'Directors List' page
        director.search_CreatedDirector(directorUserName);
        WebdriverWaits.waitUntilVisible(director.clientName);
        validate_text(director.clientName, directorUserName);

        directorEmailAddress = directorFirstName + "010@yopmail.com";
        //Verify that 'Cell Number' field accepts ten digit number in defined format on 'Edit User' pop up, of 'Directors List' page
        director.edit_Director(directorEmailAddress, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
    }

    @Test(priority = 38, enabled = true, description = " 4.13, Verify that admin is able to Enable the user or not")
    public void verify_director_enable_User() {
        DirectorPage director = new DirectorPage();
        director.search_CreatedDirector(PropertiesUtil.getPropertyValue("director_userName"));
        //Verify that director's 'Status' change to 'Disabled', when admin disables 'Disable User' toggle button, on 'Edit User' pop up of 'Directors List' page.
        director.enable_Director();
        WebdriverWaits.waitUntilVisible(director.edit_SuccMsg);

    }

    @Test(priority = 39, enabled = true, description = "4.14 verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";

        director.search_CreatedDirector(PropertiesUtil.getPropertyValue("director_userName"));
        //Verify that changes made by admin gets cleared after clicking 'Don't Save' button, on 'Edit User' pop up of 'Directors List' page.
        director.not_Edit_Director(directorEmailAddressUpdated, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);
    }


    @Test(priority = 40, enabled = true, description = "17.1, 1.14,1.15 Admin is directed to 'Today's Appointment' page")
    public void verify_TodayAppointmentTab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DateGenerator datePage = new DateGenerator();

        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        // login.adminLogin("allen", "123456");

        //Verify that 'Appointments' accordion expands after clicking on 'Appointment' tab from left panel, on 'Dashboard' page.
        dashboard.click_AppointmentsTab();
        Thread.sleep(2000);
        dashboard.click_AppointmentsTab();

        //  Verify that 'Appointments' accordion collapses after clicking on 'Appointment' tab from left panel, on 'Dashboard' page.
        WebdriverWaits.waitUntilInvisible(admin.viewAllTab);
        Assert.assertFalse(dashboard.isElementDisplay_custom(admin.viewAllTab, "View All"));
        Thread.sleep(5000);
        dashboard.click_AppointmentsTab();
        Thread.sleep(5000);
        //Verify that follow up calendar appears after clicking 'Create Follow Up' button on '<Client> Details' page.
        admin.click_TodayTab();
        validate_text(admin.todayAppointmentTitle, "Today's Appointments");
        String expectedDate = datePage.getCurrentDateFromSystem();
        validate_text(admin.todayDateOnCard, expectedDate);
    }

    //***********TO DO *********************
    @Test(priority = 41, enabled = true, description = "17.2, Admin is directed to 'Client Details' page of Today's appointment card")
    public void verify_ClientDetailsPage() {
        AdminPage admin = new AdminPage();
        String actualText = getText_custom(admin.nameOnCard);
        //Verify that admin is directed to '<Client> Details' page after clicking '<Today' Appointment>' card on 'Today's Appointment' page.
        admin.click_Card();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText = null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;
        }
        validate_AttText(actualText, expectedTitleText);
    }

    @Test(priority = 42, enabled = true, description = "1.13, 19.1, 19.2, 19.17, Admin is directed to 'Upcoming Appointment' page")
    public void verify_UpcomingTab()   {
        ActionEngine action = new ActionEngine();
        AdminPage admin = new AdminPage();

        AppointmentsPage appointment = new AppointmentsPage();


        //Verify that user is directed to 'Upcoming Appointments' page after clicking 'Upcoming' subtab, on 'Dashboard'
        appointment.click_UpcomingTab();
        WebdriverWaits.waitUntilVisible(admin.titleOfUpcomingPage);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.titleOfUpcomingPage, "Upcoming Appointments");
        admin.click_FilterBtn();

//Verify that search textbox, 'From Date' and 'To Date' date picker appears after clicking on 'Filter' button, on 'Upcoming Appointments' page.
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");

        //Verify that CSV file gets downloaded, after clicking on 'Export to CSV' button on 'Upcoming Appointments' page
//        dashboard.click_ExportCSVButton();
//        String downloadFile = dashboard.getDownloadFileName();
//        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
//        Thread.sleep(4000);
//        dashboard.navigate_Back();
    }

    @Test(priority = 43, enabled = true, description = "18.1, Admin is directed to 'Test Ready Appointment' page")
    public void verify_TestReadyTab() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_TestReadyTab();
        //Verify that admin is directed to 'Test Ready Appointments' page, after clicking 'Test Ready' sub tab under 'Appointments' tab.
        validate_text(admin.getTestReadyTitle, "Test Ready Appointments");
    }

    @Test(priority = 44, enabled = true, description = "18.2, Admin is directed to 'Client Details' page of Test ready card")
    public void verify_ClientPageTestReady() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_TestReadyTab();
        String actualText = getText_custom(admin.nameOnCard);
        admin.click_Card();
        //Verify that admin is directed to '<Client> Details' page after clicking '<Test Ready appointment>' card on 'Test Ready Appointments' page.
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText = null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;
        } else {
        }
        validate_AttText(actualText, expectedTitleText);
    }




    @Test(dependsOnMethods = {"download_CSV_File"}, description = " 20.1, 20.7, 20.22, 7.2, 7.17,14.2  Admin is able to View 'Test Complete' Appointments")
    public void verify_TestComplete_AppointmentPage() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        LoginPage login = new LoginPage();
        login.admin_Login();
        dashboard.click_AppointmentsTab();

        //***********Add assertion*******

        WebdriverWaits.waitUntilVisible(admin.viewAllTab);
        validate_text(admin.viewAllTab, "View All");
        appointment.click_TestCompleteTab();
        WebdriverWaits.waitUntilVisible(admin.getTitleOfTestComplete);
        //Verify that admin is directed to 'Test Complete Appointments' page, after clicking 'Test Complete' sub-tab from left panel.
        validate_text(admin.getTitleOfTestComplete, "Test Complete Appointments");
        admin.click_FilterBtn();
        //Search field

        //Verify that search textbox, 'From Date' and 'To Date' date picker appears after clicking on 'Filter' button, on 'Test Complete Appointments' page.
        //Verify that search textbox, 'From Date' and 'To Date' date picker appears after clicking on 'Filter' button.
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");

        admin.enterInSearchField(PropertiesUtil.getPropertyValue("clientFirstName"));
        // Verify that CSV file gets downloaded, after clicking on 'Export to CSV' button on 'Test Complete Appointments' page
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }

    @Test(dependsOnMethods = {"verify_TestComplete_AppointmentPage"}, description = "20.2, 20.3, Admin is able to click on 'View Details button of 'Test Complete' subtab")
    public void click_OnTestCompleteViewBtn() {
        AdminPage admin = new AdminPage();
        SuperAdminPage superAdmin = new SuperAdminPage();

        //login.adminLogin(adminUserName, "12345678");
        admin.navigate_Back();
        String expectedTitle = "View Student Observation";

        admin.enterInSearchField(PropertiesUtil.getPropertyValue("clientFirstName"));
        //Verify that admin is directed to '<Client>  Details' page after clicking 'View Details' button.
        admin.click_ViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText = null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;
        }
        validate_text(admin.clientNameDetail, clientName);
        validate_text(superAdmin.viewStudentObservationButton, expectedTitle);
    }

    @Test(dependsOnMethods = {"click_OnTestCompleteViewBtn"}, description = "20.6,20.3 Admin is able to click on 'View Observation' button")
    public void click_OnViewObservationBtn() {
        AdminPage admin = new AdminPage();
        SuperAdminPage superAdmin = new SuperAdminPage();

        admin.click_ViewObservationBtn();
        //Verify that admin is directed to 'Client Observation' page after clicking 'View Student Observation' button on '<Client> Details' page.
        String expectedText = "Client Observation";
        String actualText = getText_custom(superAdmin.clientObservation);
        validate_AttText(actualText, expectedText);

        //Verify that admin is directed to '<Client> Details' page after clicking 'Back' button, on 'Client Observation' page.
        admin.click_BackBtn();
        validate_text(admin.clientNameDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + " Details");

    }

    @Test(dependsOnMethods = {"click_OnViewObservationBtn"}, description = "20.4 Admin is able to click on 'View Observation' button")
    public void click_ViewDocumentBtn() {
        AdminPage admin = new AdminPage();

        admin.click_ViewDocumentsButton();
        //Verify that 'View Documents' popup appears after clicking 'View Documents' button, on 'Client Observation' page.
        String expectedText = "Attached Documents";
        validate_text(admin.getTitleOfAttachedDocument, expectedText);
        String documentName=getText_custom(admin.documentName);
        String[] stringParts = documentName.split("\n");
        String partA = stringParts[0];
        Log.info(partA);
        String partB = stringParts[1];
        Log.info(partB);
         admin.clickOn_CloseIcon();
        admin.click_BackButton();
        // String expectedFileName = getText_custom(admin.getTextFromViewDocTwo);
        // System.out.println("expectedFileName= " + expectedFileName);
        // validate_text(admin.getTextFromViewDocTwo, expectedFileName);
    }

    @Test(dependsOnMethods = {"click_ViewDocumentBtn"}, description = "verify admin is able to send recipt or not")
    public void send_Recipts() {
        AdminPage admin = new AdminPage();
        admin.click_SendReciptButton();
        WebdriverWaits.waitForSpinner();
    }

    @Test(dependsOnMethods = {"send_Recipts"}, description = "21.1, Admin is able to click on 'Completed' tab")
    public void Verify_ClickOnCompletedTab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        dashboard.click_CompletedTab();
        //Verify that admin is directed to 'Complete Appointments' page after clicking 'Completed' sub tab from left panel
        WebdriverWaits.waitForSpinner();
        String expectedTitle = "Completed Appointments";
        validate_text(admin.title, expectedTitle);
    }

    @Test(dependsOnMethods = {"Verify_ClickOnCompletedTab"}, description = "21.2, Admin is able to click on 'Filter' button")
    public void verify_ClickOnFilterBtnOfCompletedTab() {
        AdminPage admin = new AdminPage();
        admin.click_FilterBtn();

        //Search field
        //Verify that search textbox, 'From Date' and 'To Date' date picker appears after clicking on 'Filter' button, on 'Completed Appointments' page.
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
    }

    @Test(dependsOnMethods = {"verify_ClickOnFilterBtnOfCompletedTab"}, description = "21.3, Admin is able to search valid data")
    public void verify_SearchFiled() {
        AdminPage admin = new AdminPage();
        admin.enterClientNameInSearchFieldCompleted(PropertiesUtil.getPropertyValue("clientFirstName"));
        validate_text(admin.clientName, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName"));
    }

    @Test(dependsOnMethods = {"verify_SearchFiled"}, description = "21.17, Admin is able to click on 'Export CSV' button")
    public void verify_ClickOnExportCSVCompleted() throws FileNotFoundException, InterruptedException {
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        //Verify that CSV file gets downloaded, after clicking on 'Export to CSV' button on 'Completed Appointments' page.
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }

    @Test(dependsOnMethods = {"verify_ClickOnExportCSVCompleted"}, description = "21.18, Admin is able to click on 'View Details' button")
    public void verify_CompletedAppointments() {
        AdminPage admin = new AdminPage();
        admin.navigate_Back();
        admin.enterClientNameInSearchFieldCompleted(PropertiesUtil.getPropertyValue("clientFirstName"));
        String expectedResult = getText_custom(admin.clientNameCompleted);
        validate_text(admin.clientNameCompleted, expectedResult);
        admin.click_ViewDetailsBtn();
        //Verify that admin is directed to '<Client> Details' page after clicking 'View Details' button'
        String ExpectedClientName = getText_custom(admin.clientNameDetail);
        validate_text(admin.clientNameDetail, ExpectedClientName);
    }

    @Test(dependsOnMethods = {"verify_CompletedAppointments"}, description = "21.19, 21.10, 21.20 Admin is able to click on 'View Receipt' button")
    public void verify_ViewReceiptBtn() {
        AdminPage admin = new AdminPage();
        PaymentPage payment = new PaymentPage();
        payment.scrollUptoVAmountDue();
        String expectedAmountDue = "$0.00";
        String actualAmountDue = getText_custom(payment.amountDue);

        if (actualAmountDue.equals(expectedAmountDue)) {
            payment.viewReceiptButtonDisplayed();
            //Verify that 'View Receipt' popup appears after clicking 'View Receipt' button on '<Client> Details' page.
            validate_text(admin.titleOfViewReceipt, "View Receipt");
            //Verify that 'View Receipt' popup closes after clicking 'Close' button on '<Client> Details' page.
            admin.click_CloseBtn();
        } else {
            String amountDue = getText_custom(payment.amountDue);
            String actualAmount = amountDue.replace("$", "");
            payment.click_PaymentBtn();
            payment.send_AmountInEnterAmount(actualAmount);
            payment.click_CollectBtn();
            payment.click_CloseBtn();
            payment.viewReceiptButtonDisplayed();
            validate_text(admin.titleOfViewReceipt, "View Receipt");
        }
    }

    //******************** Logout button **************//
    @Test(priority = 45, enabled = true, description = "Verify login button for admin.")
    public void verify_Admin_LogOut() {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelpage.click_LogOutLink();
    }

    @Test(dependsOnMethods = {"verify_Cancelled_Appointments"}, description = " 10.10, 14.1, 14.3, 14.6,14.7 verify that admin is able to do full payment or not")
    public void verify_Full_Payment() throws InterruptedException, AWTException {
        LoginPage login = new LoginPage();
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        login.admin_Login();
        admin.paying_DueAmount(PropertiesUtil.getPropertyValue("clientFirstName"));
        WebdriverWaits.waitUntilVisible(admin.clientNameDetail);
        validate_text(admin.clientNameDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + ' ' + "Details");

        //Verify that admin is able to upload single document after clicking 'Upload' button on '<Client> Details' button.
        //Verify that 'Upload Documents' popup appears after clicking 'Upload Documents' button on '<Client> Details' page.
        admin.upload_FileAttachment();
        WebdriverWaits.waitUntilVisible(admin.clientNameDetail);
        WebdriverWaits.waitForSpinner();
        //Verify that admin is directed to '<Client> Details' page after Clicking 'Close' button on 'Doucument Uploaded Successfully!!'  popup, of '<Client> Details' page.
        validate_text(admin.clientNameDetail, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + ' ' + "Details");

        panelpage.click_LogOutLink();
    }
}
