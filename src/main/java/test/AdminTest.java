package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;
import org.automation.pageObjects.PaymentPage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;
import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.WebdriverWaits.*;
import static test.SuperAdminTest.*;

public class AdminTest extends BaseTest {

    public static String clientLastName;
    public static String clientFirstName;
    public static String diagnosticianUserName;
    String directorFirstName;
    String directorUserName;
    String dirCellNumber;
    String directorEmailAddress;
    String directorLastName;

    String clientEmail;
    String clientEmail2;
    String clientCellNumber;
    String diagnosticianFirstName;
    String diagnosticianLastName;
    String diagnosticianEmailAddress;

    List<WebElement> diagList;


    @Test(priority = 0, enabled = true, description = "1.1 Verify admin is able to login with valid credentials")
    public void admin_login() {
        LoginPage login = new LoginPage();

        //Login by using superAdmin credentials

        login.adminLogin(adminUserName, "12345678");
        AdminPage dasboard = new AdminPage();
        WebdriverWaits.waitUntilVisible(dasboard.adminDashboardText);
        waitForSpinner();
        validate_text(dasboard.adminDashboardText, "Dashboard");

    }

    //********* Create Daignostician by admin
    @Test(priority = 1, enabled = true, description = "6.1 Create diagnostician by admin")
    public void verify_CreateDiagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        DashBoardPanelPage tab = new DashBoardPanelPage();
        AdminPage reAssign = new AdminPage();
        // Click on diagnostician tab from left panel.
        tab.click_DiagnosticianTab();
        WebdriverWaits.waitUntilVisible(diagnostician.diagListPageText);
        validate_text(diagnostician.diagListPageText, "Diagnosticians List");
        //Create Diagnostician.
        diagnosticianFirstName = "AU_Hicks" + RandomStrings.requiredCharacters(3);
        diagnosticianLastName = "AU_Read" + RandomStrings.requiredCharacters(3);
        diagnosticianUserName = "Au_Quinn" + RandomStrings.requiredCharacters(3);
        diagnosticianEmailAddress = diagnosticianFirstName + "10@yopmail.com";
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);

        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, diagnosticianPhoneNumber, diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);

        //validate Diagnostician
        validate_text(diagnostician.actualText, diagnosticianUserName);
        diagList = reAssign.get_diagList(reAssign.diagList);
    }

    @Test(priority = 2, enabled = true, description = "Set availability for diagnostician by admin")
    public void verify_DiagnosticianAvailability() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
        logout.click_LogOutLink();
        diagnostician.login_As_Diagnostician(diagnosticianUserName, "123456");
        diagnostician.set_Availability();
        // diagnostician.click_Availablity();
        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
        logout.click_LogOutLink();

    }

    @Test(priority = 3, enabled = true, description = "3.1, 3.6, 4.1  Creating Director from admin")
    public void verify_createDirector() throws InterruptedException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        LoginPage login = new LoginPage();
        login.adminLogin(adminUserName, "12345678");
        directorFirstName = "AU_Arlo" + RandomStrings.requiredCharacters(3);
        directorLastName = "AU_Joel" + RandomStrings.requiredCharacters(3);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Koa" + RandomStrings.requiredCharacters(3);
        dirCellNumber = RandomStrings.requiredDigits(10);
        panelpage.click_DirectorTab();
        validate_text(director.directorActualText, "Directors List");
        director.create_Director(directorFirstName, directorLastName, dirCellNumber, directorEmailAddress, directorUserName, "123456", "123456");
        panelpage.click_LogOutLink();
    }

    @Test(priority = 4, enabled = true, description = "Set availability for director by admin.")
    public void director_Availability() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        login.directorLogin(directorUserName, "123456");
        DirectorPage director = new DirectorPage();
        panelPage.click_Availability();
        director.director_Availability(2);
        panelPage.click_LogOutLink();
    }

    @Test(priority = 5, enabled = true, description = "2.1, 2.2, 2.5, 2.10, 2.12, Appointment scheduled by admin for a client")
    public void verify_ScheduleAppointment() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();

        login.adminLogin(adminUserName, "12345678");
        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot(0);
        appPage.selectAssesmentType("Adult ADHD Only");
        validate_SelectedOption(appPage.assestmentType, "Adult ADHD Only");
    }

    @Test(priority = 6, enabled = true, description = "2.25, 2.26, 2.27, 2.28, 2.29 Filling client details by admin.")
    public void fill_clientDetailsSection() throws InterruptedException {
        AppointmentsPage fillClientDetails = new AppointmentsPage();
        clientFirstName = "Au_Theo" + RandomStrings.requiredCharacters(3);
        clientLastName = "Au_Finn" + RandomStrings.requiredCharacters(3);
        clientCellNumber = RandomStrings.requiredDigits(10);
        clientEmail = clientFirstName + "@yopmail.com";
        clientEmail2 = clientFirstName + "101@yopmail.com";
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
    }

    @Test(priority = 7, enabled = true, description = "Verify that admin is able to cancel the appointment or not")
    public void cancel_Appointment() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.click_CancelAppointmentButton();
    }

    @Test(priority = 8, enabled = true, description = "Diagnostician is verifying cancelled appointments")
    public void verify_CancelledAppointment() {
        AdminPage admin = new AdminPage();
        admin.verify_CancelledApp(clientLastName);
        WebdriverWaits.waitUntilVisible(admin.clientName);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientName, clientFirstName + ' ' + clientLastName);
    }

    @Test(priority = 9, enabled = true, description = "Appointment scheduled by admin for a client")
    public void verify_ReScheduleAppointment() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        AppointmentsPage fillClientDetails = new AppointmentsPage();

        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot(0);
        appPage.selectAssesmentType("Adult ADHD Only");
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
    }


    //********************** Create Follow Up For Client ***********************//

    @Test(priority = 10, enabled = true, description = "Creat follow up for client by admin")
    public void create_FollowUp() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.create_FollowUp(0);
        WebdriverWaits.waitUntilVisible(admin.validateScheduledFollowUp);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.validateScheduledFollowUp, "Follow Up Scheduled!!");
        admin.click_BackBtn();
    }

    @Test(priority = 11, enabled = true, description = "Re-Assign Appointment for client by admin")
    public void re_AssignAppointment() {
        AdminPage reAssign = new AdminPage();
        reAssign.click_ReAssignBn();
        WebdriverWaits.waitUntilVisible(reAssign.diagList);
        List<WebElement> reassigList = reAssign.get_diagList(reAssign.diagList);
        boolean result = reAssign.compare_DiagAndReAssignDiagList(diagList, reassigList);
        Assert.assertTrue(result);
    }

    @Test(priority = 12, enabled = true, description = "Re-Assign Appointment for client by admin")
    public void verify_EditAssessmentTypePopUp() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.click_EditAssessment();
        validate_text(admin.assType, "Change Assessment Type");
    }

    @Test(priority = 13, enabled = true, description = "Verify Edit Assessment type button .")
    public void verify_EditAssessmentType() throws InterruptedException {
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("IQ");
        editType.click_UpdateBtn();
        WebdriverWaits.waitUntilVisible(editType.clientAsses);
        validate_text(editType.clientAsses, "IQ");
    }

    @Test(priority = 14, enabled = true, description = "Verify Test plan button on <Client> details page.")
    public void verify_TestPlanBtn() throws InterruptedException {
        AdminPage testPlan = new AdminPage();
        WebdriverWaits.waitForSpinner();
        testPlan.click_TestPlan();
        validate_text(testPlan.testPlanText, "Please choose tests.");
    }

    @Test(priority = 15, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void verify_PlanTest() {
        AdminPage testPlan = new AdminPage();
        testPlan.select_TestPlan();
        testPlan.click_TestPlanSaveButton();
        WebdriverWaits.waitUntilVisible(testPlan.validateCheckBox);
        validate_text(testPlan.validateCheckBox, "WJ Achievement");
    }

    @Test(priority = 16, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void verify_DontSaveAssessmentType() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.click_EditAssessment();
        admin.edit_AssessmentType("GT");
        admin.click_DontSave();
        WebdriverWaits.waitUntilVisible(admin.clientAsses);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientAsses, "IQ");
    }

    @Test(priority = 17, enabled = true, description = "Verify save Test plan button on <Client> details page.")
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


    @Test(priority = 18, enabled = true, description = "Verify payment button on <Client> details page.")
    public void verify_PaymentBtn() {
        AdminPage payment = new AdminPage();
        beforeAssessmentAmount = Float.parseFloat(payment.get_AssessmentAmount());
        beforeAmountDue = Float.parseFloat(payment.get_AmountDue());
        beforeReceviedAmount = Float.parseFloat(payment.get_ReceivedAmount());
        payment.click_PaymentBtn();
        WebdriverWaits.waitUntilVisible(payment.collectPayActualText);
        validate_text(payment.collectPayActualText, "Collect Payment");
    }

    @Test(priority = 19, enabled = true, description = "Verify payment button on <Client> details page.")
    public void verify_CollectTestFeeAdjustment() {
        AdminPage payment = new AdminPage();
        payment.validate_FeeAdjustmentAmount("50");
        payment.validate_CollectAmountAdjustment("50");
        afterAssessmentAmount = Float.parseFloat(payment.get_AssessmentAmount());
        afterAmountDue = Float.parseFloat(payment.get_AmountDue());
        afterRececiedAmount = Float.parseFloat(payment.get_ReceivedAmount());
        String assessmentAmtDiff = Float.toString(afterAssessmentAmount - beforeAssessmentAmount).replace(".0", "");
        String recAmtDiff = Float.toString(afterRececiedAmount - beforeReceviedAmount).replace(".0", "");
        Assert.assertEquals(assessmentAmtDiff, "50");
        Assert.assertEquals(recAmtDiff, "100");
    }

    @Test(priority = 20, enabled = true, description = "Verify Edit client Details button client page.")
    public void verify_EditClientBtn() {
        AdminPage EditClient = new AdminPage();
        EditClient.click_EditClientBtn();
        WebdriverWaits.waitUntilVisible(EditClient.editCllientActualText);
        validate_text(EditClient.editCllientActualText, "Edit Client Info");
    }

    @Test(priority = 21, enabled = true, description = "Verify Edit client details popup client page.")
    public void verify_UpdateBtn() {
        AdminPage editClient = new AdminPage();
        editClient.edit_ClientInfo(clientFirstName, clientLastName, "401 Broadway E eastate g", "College");
        editClient.click_UpdateClientBtn();
        WebdriverWaits.waitUntilVisible(editClient.actualTextClient);
        validate_text(editClient.actualTextClient, "College");
    }

    @Test(priority = 22, enabled = true, description = "verify hold appointment button.")
    public void verify_HoldAppointmentBtn() {
        AdminPage hold = new AdminPage();
        hold.click_HoldAppointmentBtn();
        validate_text(hold.holdActualText, "Are you sure you want to hold this appointment?");

    }

    @Test(priority = 23, enabled = true, description = "verify yes hold button on hold appointment button.")
    public void verify_yesHoldBtn() {
        AdminPage admin = new AdminPage();
        admin.click_yesHoldBtn();
        WebdriverWaits.waitUntilVisible(admin.allAppointmentsPage);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.allAppointmentsPage, "All Appointments");

    }

    @Test(priority = 24, enabled = true, description = "verify yes hold button on hold appointment popup.")
    public void verify_HoldAppointment() {
        AdminPage admin = new AdminPage();

        admin.click_HoldTab();
        validate_text(admin.holdAppointmentText, "Hold Appointments");

    }

    @Test(priority = 25, enabled = true, description = "verify filter button on hold appointment page.")
    public void verify_holdfilterButton() {
        AdminPage admin = new AdminPage();
        admin.click_HoldFilterBtn();
        // String searchPlaceHolder = admin.getAttributevalue(admin.searchAttribute, "placeholder");
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        //  Assert.assertEquals(searchPlaceHolder, "type");
    }

    @Test(priority = 26, enabled = true, description = "verify holded appointment .")
    public void verify_holdedAppointment() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.send_TextHoldSearchBox(clientFirstName);
        validate_text(admin.validateHoldClient, clientFirstName + "@yopmail.com");
        admin.click_unHoldBtn();
        WebdriverWaits.waitForSpinner();
    }

    @Test(priority = 27, enabled = true, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage() {
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.click_ViewAllTab();
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(appPage.viewAllActualText);
        WebdriverWaits.waitForSpinner();
        validate_text(appPage.viewAllActualText, "All Appointments");
    }

    @Test(priority = 28, enabled = true, description = "Verify filter button and serarchtextbox textbox")
    public void search_CreatedAppointment() {

        AdminPage admin = new AdminPage();
        admin.enterSearchField(clientFirstName);
        WebdriverWaits.waitUntilVisible(admin.getStatus);
        validate_text(admin.getStatus, "Test Ready");

    }

    @Test(priority = 29, enabled = true, description = "Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        ActionEngine engine;
        engine = new ActionEngine();
        String toDate = DateGenerator.getCurrentDate();

        String FromDate = DateGenerator.getDateWithDays("dd-MM-yyyy", -2);
        admin.click_filterButton();
        appPage.enter_Dates(FromDate, toDate);
        admin.click_SearchButton();
        WebdriverWaits.waitUntilVisible(appPage.dateEle);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(4000);
        List<WebElement> my_list = engine.getWebElements(appPage.dateEle);
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
    }

    @Test(priority = 30, enabled = true, description = "Search created diagnostician by admin")
    public void verify_SearchDiagnostician() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage clickDiagnosticianTab = new DashBoardPanelPage();
        clickDiagnosticianTab.click_DiagnosticianTab();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }

    @Test(priority = 31, enabled = true, description = "4.6 ,4.10 Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        // Edit Diagnostician
        String diagnosticianUpdatedEmail = diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail, "12345678", "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        String succ_Msg = getText_custom(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, succ_Msg);
    }

    @Test(priority = 32, enabled = true, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }


    //******************* Edit Director ***************//


    @Test(priority = 34, enabled = true, description = "3.9, 3.10 Creating Director from admin")
    public void verify_Edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage clickDirectorTab = new DashBoardPanelPage();
        clickDirectorTab.click_DirectorTab();
        directorEmailAddress = directorFirstName + "010@yopmail.com";
        director.edit_Director(directorEmailAddress, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
    }

    @Test(priority = 35, enabled = true, description = "Verify that admin is able to Enable the user or not")
    public void verify_director_enable_User() {
        DirectorPage director = new DirectorPage();

        director.enable_Director();
        WebdriverWaits.waitUntilVisible(director.edit_SuccMsg);
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
    }

    @Test(priority = 36, enabled = true, description = "4.14 verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);
    }

    @Test(priority = 37, enabled = true, description = "Admin is directed to 'Today's Appointment' page")
    public void verify_TodayAppointmentTab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DateGenerator datePage = new DateGenerator();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        dashboard.click_AppointmentsTab();
        Thread.sleep(5000);
        admin.click_TodayTab();
        validate_text(admin.todayAppointmentTitle, "Today's Appointments");
        String expectedDate = datePage.getCurrentDateFromSystem();
        validate_text(admin.todayDateOnCard, expectedDate);

    }

    //***********TO DO *********************
    @Test(priority = 38, enabled = true, description = "Admin is directed to 'Client Details' page of Today's appointment card")
    public void verify_ClientDetailsPage() {
        AdminPage admin = new AdminPage();
        String actualText = getText_custom(admin.nameOnCard);
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

    @Test(priority = 39, enabled = true, description = "1.13, Admin is directed to 'Upcoming Appointment' page")
    public void verify_UpcomingTab() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_UpcomingTab();
        WebdriverWaits.waitUntilVisible(admin.titleOfUpcomingPage);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.titleOfUpcomingPage, "Upcoming Appointments");
        admin.filter_ForUpcoming();
        validate_text(admin.getStatus, "Upcoming");
    }

    @Test(priority = 40, enabled = true, description = "Admin is directed to 'Test Ready Appointment' page")
    public void verify_TestReadyTab() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_TestReadyTab();
        validate_text(admin.getTestReadyTitle, "Test Ready Appointments");
    }

    @Test(priority = 41, enabled = true, description = "Admin is directed to 'Client Details' page of Test ready card")
    public void verify_ClientPageTestReady() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_TestReadyTab();
        String actualText = getText_custom(admin.nameOnCard);
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

    @Test(priority = 42, enabled = true, description = "Admin is able to click client detail page after clicking on 'View Details' button")
    public void click_OnViewDetailsButton() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_UpcomingTab();
        admin.filter_ForUpcoming(clientLastName);
        String actualText = getText_custom(admin.getNameOfClient);
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
        validate_AttText(actualText, expectedTitleText);
    }

    @Test(dependsOnMethods = {"download_CSV_File"}, description = "Admin is able to View 'Test Complete' Appointments")
    public void verify_TestComplete_AppointmentPage() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        LoginPage login = new LoginPage();
        login.adminLogin(adminUserName, "12345678");
        dashboard.click_AppointmentsTab();
        appointment.click_TestCompleteTab();
        WebdriverWaits.waitUntilVisible(admin.getTitleOfTestComplete);
        validate_text(admin.getTitleOfTestComplete, "Test Complete Appointments");
        admin.click_FilterBtn();
        //Search field

        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");

        admin.enterInSearchField(clientFirstName);
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }

    @Test(dependsOnMethods = {"verify_TestComplete_AppointmentPage"}, description = "Admin is able to click on 'View Details button of 'Test Complete' subtab")
    public void click_OnTestCompleteViewBtn() {
        AdminPage admin = new AdminPage();
        ActionEngine action = new ActionEngine();
        SuperAdminPage superAdmin = new SuperAdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
//        login.adminLogin(adminUserName, "12345678");
        action.navigate_Back();
        String expectedTitle = "View Student Observation";

        admin.enterInSearchField(clientFirstName);
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

    @Test(dependsOnMethods = {"click_OnTestCompleteViewBtn"}, description = "Admin is able to click on 'View Observation' button")
    public void click_OnViewObservationBtn() {
        AdminPage admin = new AdminPage();
        SuperAdminPage superAdmin = new SuperAdminPage();

        admin.click_ViewObservationBtn();
        String expectedText = "Client Observation";
        String actualText = getText_custom(superAdmin.clientObservation);
        validate_AttText(actualText, expectedText);
    }

    @Test(dependsOnMethods = {"click_OnViewObservationBtn"}, description = "20.4 Admin is able to click on 'View Observation' button")
    public void click_ViewDocumentBtn() {
        AdminPage admin = new AdminPage();

        admin.click_ViewDocumentsButton();
        String expectedText = "Attached Documents";
        validate_text(admin.getTitleOfAttachedDocument, expectedText);
        admin.clickOn_CloseIcon();
        admin.click_BackButton();
//        String expectedFileName = getText_custom(admin.getTextFromViewDocTwo);
//        System.out.println("expectedFileName= " + expectedFileName);
//        validate_text(admin.getTextFromViewDocTwo, expectedFileName);
    }

    @Test(dependsOnMethods = {"click_ViewDocumentBtn"}, description = "verify admin is able to send recipt or not")
    public void send_Recipts() {
        AdminPage admin = new AdminPage();
        admin.click_SendReciptButton();
        WebdriverWaits.waitForSpinner();
    }

    @Test(dependsOnMethods = {"send_Recipts"}, description = "Admin is able to click on 'Completed' tab")
    public void Verify_ClickOnCompletedTab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        dashboard.click_CompletedTab();
        WebdriverWaits.waitForSpinner();
        String expectedTitle = "Completed Appointments";
        validate_text(admin.title, expectedTitle);
    }

    @Test(dependsOnMethods = {"Verify_ClickOnCompletedTab"}, description = "Admin is able to click on 'Filter' button")
    public void verify_ClickOnFilterBtnOfCompletedTab() {
        AdminPage admin = new AdminPage();
        admin.click_FilterBtn();

        //Search field
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
    }

    @Test(dependsOnMethods = {"verify_ClickOnFilterBtnOfCompletedTab"}, description = "Admin is able to search valid data")
    public void verify_SearchFiled() {
        AdminPage admin = new AdminPage();

        admin.enterClientNameInSearchFieldCompleted(clientFirstName);
        validate_text(admin.clientName, clientFirstName + ' ' + clientLastName);
    }

    @Test(dependsOnMethods = {"verify_SearchFiled"}, description = "Admin is able to click on 'Export CSV' button")
    public void verify_ClickOnExportCSVCompleted() throws FileNotFoundException, InterruptedException {

        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }

    @Test(dependsOnMethods = {"verify_ClickOnExportCSVCompleted"}, description = "Admin is able to click on 'View Details' button")
    public void verify_ClickOnViewDetailsCompleted() {
        AdminPage admin = new AdminPage();
        ActionEngine action = new ActionEngine();
        String expectedResult = getText_custom(admin.clientNameCompleted);
        action.navigate_Back();
        admin.enterClientNameInSearchFieldCompleted(clientFirstName);
        admin.click_ViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String actualText = null;

        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            actualText = firstWord + " " + secondWord;
        }
        validate_AttText(actualText, expectedResult);
    }


    @Test(dependsOnMethods = {"verify_ClickOnViewDetailsCompleted"}, description = "Admin is able to click on 'View Receipt' button")
    public void verify_ClickOnViewReceiptBtn() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        PaymentPage payment = new PaymentPage();

        payment.scrollUptoVAmountDue();
        String expectedAmountDue = "$0.00";
        String actualAmountDue = getText_custom(payment.amountDue);

        if (actualAmountDue.equals(expectedAmountDue)) {
            payment.viewReceiptButtonDisplayed();
            String expectedText = "View Receipt";
            validate_text(admin.titleOfViewReceipt, expectedText);

        } else {
            String amountDue = getText_custom(payment.amountDue);
            String actualAmount = amountDue.replace("$", "");
            payment.click_PaymentBtn();
            payment.send_AmountInEnterAmount(actualAmount);
            payment.click_CollectBtn();
            payment.click_CloseBtn();
            payment.viewReceiptButtonDisplayed();
            String expectedText = "View Receipt";
            validate_text(admin.titleOfViewReceipt, expectedText);
        }
    }

    @Test(dependsOnMethods = {"verify_ClickOnViewReceiptBtn"}, description = "Admin is able to click on 'Close' button")
    public void verify_ClickOnViewReceiptCloseBtn() {
        AdminPage admin = new AdminPage();
        PaymentPage payment = new PaymentPage();

        admin.scrollUptoVAmountDue();
        String expectedAmountDue = "$0.00";
        String actualAmountDue = getText_custom(payment.amountDue);
        if (actualAmountDue.equals(expectedAmountDue)) {
            String expectedText = getText_custom(admin.title);
            payment.viewReceiptButtonDisplayed();
            admin.click_CloseBtn();
            String actualText = getText_custom(admin.title);
            validate_AttText(actualText, expectedText);

        } else {
            String amountDue = getText_custom(payment.amountDue);
            String actualAmount = amountDue.replace("$", "");
            payment.viewReceiptButtonNotDisplayed();
            payment.send_AmountInEnterAmount(actualAmount);
            admin.click_CollectBtn();
            admin.click_CloseBtn();
            String expectedText = getText_custom(admin.title);
            payment.viewReceiptButtonDisplayed();
            admin.click_CloseBtn();
            String actualText = getText_custom(admin.title);
            validate_AttText(actualText, expectedText);
        }
    }

    //************************ Edit Diagnostician *********************//

    //******************** Logout button **************//
    @Test(priority = 43, enabled = true, description = "Verify login button for admin.")
    public void verify_Admin_LogOut() {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelpage.click_LogOutLink();
    }

    @Test(dependsOnMethods = {"verify_Cancelled_Appointments"})
    public void verify_Full_Payment() throws InterruptedException, AWTException {
        LoginPage login = new LoginPage();
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        login.adminLogin(adminUserName, "12345678");
        admin.paying_DueAmount(clientFirstName);
        WebdriverWaits.waitUntilVisible(admin.clientNameDetail);
        validate_text(admin.clientNameDetail, clientFirstName + ' ' + clientLastName + ' ' + "Details");
        admin.upload_FileAttachment();
        panelpage.click_LogOutLink();
    }
}


