package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.WebdriverWaits.waitForSpinner;
import static test.SuperAdminTest.adminUserName;
public class AdminTest extends BaseTest {

    public static String clientLastName;
    public static String diagnosticianUserName;
    String directorFirstName;
    String directorUserName;
    String dirCellNumber;
    String directorEmailAddress;
    String directorLastName;
    public static String clientFirstName;
    String clientEmail;
    String clientEmail2;
    String clientCellNumber;
    String diagnosticianFirstName;
    String diagnosticianLastName;
    String diagnosticianEmailAddress;
    List<WebElement> diagList;
    String holdAppointmentname;


    @Test(priority = 0, enabled = true, description = "Verify admin is able to login with valid credentials")
    public void admin_login() {
        LoginPage login = new LoginPage();
        login.adminLogin(adminUserName, "12345678");
        AdminPage dasboard = new AdminPage();
        waitForSpinner();
        validate_text(dasboard.adminDashboardText, "Dashboard");
    }

    //********* Create Daignostician by admin
    @Test(priority = 1, enabled = true, description = "Create diagnostician by admin")
    public void create_Diagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
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
    public void diagnostician_Availability() throws InterruptedException {
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
    @Test(priority = 3, enabled = true, description = "Creating Director from admin")
    public void create_Director() throws InterruptedException {
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
        director.director_Availability();
        panelPage.click_LogOutLink();
    }

    @Test(priority = 5, enabled = true, description = "Appointment scheduled by admin for a client")
    public void schedule_Appointment() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        login.adminLogin(adminUserName, "12345678");
        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType(1);
        validate_SelectedOption(appPage.assestmentType, "Adult ADHD Only");
    }

    @Test(priority = 6, enabled = true, description = "Filling client details by admin.")
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
    public void cancel_Appointment() {
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.cancelAppointment();
    }

    @Test(priority = 8, enabled = true, description = "Diagnostician is verifying cancelled appointments")
    public void verify_CancelledAppointment() {
        AdminPage admin = new AdminPage();
        admin.verify_CancelledApp(clientFirstName);
        WebdriverWaits.waitUntilVisible(admin.clientName);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientName, clientFirstName + ' ' + clientLastName);
    }

    @Test(priority = 9, enabled = true, description = "Appointment scheduled by admin for a client")
    public void reSchedule_Appointment() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        AppointmentsPage fillClientDetails = new AppointmentsPage();

        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType(1);
        validate_SelectedOption(appPage.assestmentType, "Adult ADHD Only");
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
    }

    //********************** Create Follow Up For Client ***********************//

    @Test(priority = 10, enabled = true, description = "Creat follow up for client by admin")
    public void create_FollowUp() {
        AdminPage followUp = new AdminPage();
        followUp.Create_FollowUp();
        WebdriverWaits.waitUntilVisible(followUp.validateScheduledFollowUp);
        WebdriverWaits.waitForSpinner();
        validate_text(followUp.validateScheduledFollowUp, "Follow Up Scheduled!!");
        followUp.click_BackBtn();
    }

    @Test(priority = 11, enabled = true, description = "Edit-Assign Appointment for client by admin")
    public void edit_AssessmentTypePopUp() throws InterruptedException {
        AdminPage editType = new AdminPage();
        editType.click_EditAssessment();
        validate_text(editType.assType, "Change Assessment Type");
    }

    @Test(priority = 12, enabled = true, description = "Verify Edit Assessment type button .")
    public void edit_AssessmentType()  {
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("IQ");
        editType.click_UpdateBtn();
        WebdriverWaits.waitUntilVisible(editType.clientAsses);
        validate_text(editType.clientAsses, "IQ");
    }

    @Test(priority = 13, enabled = true, description = "Verify Test plan button on <Client> details page.")
    public void verify_TestPlanBtn() throws InterruptedException {
        AdminPage testPlan = new AdminPage();
        WebdriverWaits.waitForSpinner();
        testPlan.click_TestPlan();
        validate_text(testPlan.testPlanText, "Please choose tests.");
    }

    @Test(priority = 14, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void plan_Test() throws InterruptedException {
        AdminPage testPlan = new AdminPage();
        testPlan.select_TestPlan();
        testPlan.click_TestPlanSaveButton();
        WebdriverWaits.waitUntilVisible(testPlan.validateCheckBox);
        validate_text(testPlan.validateCheckBox, "WJ Achievement");
    }

    @Test(priority = 15, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void dont_SaveAssessmentType() throws InterruptedException {
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("GT");
        editType.click_DontSave();
        WebdriverWaits.waitUntilVisible(editType.clientAsses);
        WebdriverWaits.waitForSpinner();
        validate_text(editType.clientAsses, "IQ");
    }

    @Test(priority = 16, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public void edit_Testplan()   {
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

    @Test(priority = 17, enabled = true, description = "Verify payment button on <Client> details page.")
    public void verify_PaymentBtn() {
        AdminPage payment = new AdminPage();
        beforeAssessmentAmount = Float.parseFloat(payment.get_AssessmentAmount());
        beforeAmountDue = Float.parseFloat(payment.get_AmountDue());
        beforeReceviedAmount = Float.parseFloat(payment.get_ReceivedAmount());
        payment.click_PaymentBtn();
        WebdriverWaits.waitUntilVisible(payment.collectPayActualText);
        validate_text(payment.collectPayActualText, "Collect Payment");
    }

    @Test(priority = 18, enabled = true, description = "Verify payment button on <Client> details page.")
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

    @Test(priority = 19, enabled = true, description = "Verify Edit client Details button client page.")
    public void verify_EditClientBtn() {
        AdminPage EditClient = new AdminPage();
        EditClient.click_EditClientBtn();
        WebdriverWaits.waitUntilVisible(EditClient.editCllientActualText);
        validate_text(EditClient.editCllientActualText, "Edit Client Info");
    }

    @Test(priority = 20, enabled = true, description = "Verify Edit client details popup client page.")
    public void verify_UpdateBtn() {
        AdminPage editClient = new AdminPage();
        editClient.edit_ClientInfo(clientFirstName, clientLastName, "401 Broadway E eastate g", "College");
        editClient.click_UpdateClientBtn();
        WebdriverWaits.waitUntilVisible(editClient.actualTextClient);
        validate_text(editClient.actualTextClient, "College");
    }
    @Test(priority = 21, enabled = true, description = "verify hold appointment button.")
    public void verify_HoldAppointmentBtn() {
        AdminPage hold = new AdminPage();
        hold.click_HoldAppointmentBtn();
        validate_text(hold.holdActualText, "Are you sure you want to hold this appointment?");
//        holdAppointmentname = hold.getText_custom(hold.fullName);
//        Log.info(holdAppointmentname);
    }

    @Test(priority = 22, enabled = true, description = "verify yes hold button on hold appointment button.")
    public void verify_yesHoldBtn() {
        AdminPage hold = new AdminPage();
        hold.click_yesHoldBtn();
        WebdriverWaits.waitUntilVisible(hold.allAppointmentsPage);
        WebdriverWaits.waitForSpinner();
        validate_text(hold.allAppointmentsPage, "All Appointments");
    }

    @Test(priority = 23, enabled = true, description = "verify yes hold button on hold appointment popup.")
    public void verify_HoldAppointment() {
        AdminPage hold = new AdminPage();
        hold.click_HoldTab();
        validate_text(hold.holdAppointmentText, "Hold Appointments");
    }

    @Test(priority = 24, enabled = true, description = "verify filter button on hold appointment page.")
    public void verify_holdfilterButton() {
        AdminPage admin = new AdminPage();
        admin.click_HoldFilterBtn();
        String searchPlaceHolder = admin.getValueAttribute(admin.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.getValueAttribute(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getValueAttribute(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");
    }
    @Test(priority = 25, enabled = true, description = "verify holded appointment .")
    public void verify_holdedAppointment() {
        AdminPage hold = new AdminPage();
        hold.send_textHoldSearchBox(clientFirstName);
        validate_text(hold.validateHoldClient, clientFirstName+"@yopmail.com");
        hold.click_unHoldBtn();
    }
    @Test(priority = 26, enabled = true, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();

//        LoginPage login = new LoginPage();
//        login.adminLogin("allen", "123456");
//        panelPage.click_AppointmentsTab();
        Thread.sleep(3000);
        panelPage.click_ViewAllTab();
        WebdriverWaits.waitUntilVisible(appPage.viewAllActualText);
        WebdriverWaits.waitForSpinner();
        validate_text(appPage.viewAllActualText, "All Appointments");
    }

    @Test(priority = 27, enabled = true, description = "Verify filter button and serarchtextbox textbox")
    public void search_CreatedAppointment() {
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage placeHolder = new AdminPage();
        appPage.click_FilterButton();
        String text = appPage.getValueAttribute(appPage.searchTextBox, "placeholder");
        String fromDateplaceholder = placeHolder.getValueAttribute(placeHolder.fromDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(text, "Type here to search");
    }

    @Test(priority = 28, enabled = true, description = "Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage admin=new AdminPage();
        ActionEngine engine;
        engine = new ActionEngine();
        String toDate = DateGenerator.getCurrentDate();
        String FromDate = DateGenerator.getDateWithDays("dd-MM-yyyy", -2);
        appPage.enter_Dates(FromDate, toDate);
        admin.click_SearchButton();
        WebdriverWaits.waitUntilVisible(appPage.dateElement);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(4000);
        List<WebElement> my_list = engine.getWebElements(appPage.dateElement);
        HashSet<WebElement> dateSet = new HashSet<>(my_list);

        LocalDate toDateLocal = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fromDateLocal = LocalDate.parse(FromDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        boolean result = true;
        for (WebElement i : dateSet) {
            String date = i.getText();
            LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            System.out.println(inputDate);

            if (!(DateGenerator.isDateWithinRange(fromDateLocal, toDateLocal, inputDate))) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }


    //************************ Edit Diagnostician *********************//
    @Test(priority = 29, enabled = true, description = "Search created diagnostician by admin")
    public void search_Diagnostician() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage clickDiagnosticianTab = new DashBoardPanelPage();
        clickDiagnosticianTab.click_DiagnosticianTab();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }

    @Test(priority = 30, enabled = true, description = "Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        // Edit Diagnostician
        String diagnosticianUpdatedEmail = diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail, "12345678", "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        String succ_Msg=getText_custom(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, succ_Msg);
    }

    @Test(priority = 31, enabled = true, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }


    @Test(priority = 32, enabled = true, description = "Verify Don't save button diagnostician by admin")
    public void verify_Dnt_SaveButton() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail = diagnosticianFirstName + "10@yopmail.com";
        diagnostician.verify_DontSave(diagnosticianPhoneNumber, diagnosticianUpdatedEmail, "1234567", "1234567");
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }
    //******************* Edit Director ***************//


    @Test(priority = 33, enabled = true, description = "Creating Director from admin")
    public void verify_Edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage clickDirectorTab = new DashBoardPanelPage();
        clickDirectorTab.click_DirectorTab();
        directorEmailAddress = directorFirstName + "010@yopmail.com";
        director.edit_Director(directorEmailAddress, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
    }

    @Test(priority = 34, enabled = true, description = "Enable toggle button Director from admin")
    public void verify_Director_Enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }

    @Test(priority = 35, enabled = true, description = "verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);
    }

    //******************** Logout button **************//
    @Test(priority = 36, enabled = true, description = "Verify login button for admin.")
    public void verify_Admin_LogOut() {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelpage.click_LogOutLink();
    }
    @Test(dependsOnMethods={ "verify_Cancelled_Appointments"})    // dependsOnMethods={ "download_CSV_File_For_completeAss"}
    public void verify_Full_Payment() throws InterruptedException, AWTException {
        LoginPage login=new LoginPage();
        AdminPage admin=new AdminPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        login.adminLogin(adminUserName, "12345678");  //"AU_GillGP"   "Au_Theodc"
        admin.paying_DueAmount(clientFirstName);
        WebdriverWaits.waitUntilVisible(admin.clientNameDetail);
        validate_text(admin.clientNameDetail,clientFirstName +' '+ clientLastName +' '+ "Details");
        admin.upload_FileAttachment();
        panelpage.click_LogOutLink();
}
}


