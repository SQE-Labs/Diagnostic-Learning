package test;

import org.automation.base.BaseTest;

import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
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
    public void verify_CreateDiagnostician() throws InterruptedException
    {
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

    @Test(priority = 2,enabled = true,description = "Set availability for diagnostician by admin")
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
    @Test(priority = 3, enabled = true, description = "Creating Director from admin")
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
        director.director_Availability();
        panelPage.click_LogOutLink();

    }

    @Test(priority = 5, enabled = true, description = "Appointment scheduled by admin for a client")
    public void verify_ScheduleAppointment() throws InterruptedException
    {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        login.adminLogin(adminUserName, "12345678");
        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType("Adult ADHD Only");
        validate_SelectedOption(appPage.assestmentType,"Adult ADHD Only");
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
    public void verify_ReScheduleAppointment() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        AppointmentsPage fillClientDetails = new AppointmentsPage();

        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType("Adult ADHD Only");
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
    }
    @Test(priority = 10, enabled = true, description = "Admin is directed to 'Upcoming Appointment' page")
    public void verify_UpcomingTab()
    {
        AdminPage admin = new AdminPage();
        admin.clickOn_UpcomingTab();
        validate_text(admin.titleOfUpcomingPage,"Upcoming Appointments");
        admin.filter_ForUpcoming("Upcoming");
        validate_text(admin.getStatus,"Upcoming");
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
    @Test(priority = 11, enabled = false, description = "Re-Assign Appointment for client by admin")
    public void re_AssignAppointment()   {
        AdminPage reAssign = new AdminPage();
        reAssign.click_ReAssignBn();
        WebdriverWaits.waitUntilVisible(reAssign.diagList);
        List<WebElement> reassigList = reAssign.get_diagList(reAssign.diagList);
        boolean result = reAssign.compare_DiagAndReAssignDiagList(diagList, reassigList);
        Assert.assertTrue(result);
    }
    @Test(priority = 12, enabled = false, description = "Re-Assign Appointment for client by admin")
    public void verify_EditAssessmentTypePopUp() {
        AdminPage editType = new AdminPage();
        editType.click_EditAssessment();
        validate_text(editType.assType, "Change Assessment Type");
    }

    @Test(priority = 13, enabled = false, description = "Verify Edit Assessment type button .")
    public void verify_EditAssessmentType() throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("IQ");
        editType.click_UpdateBtn();
        WebdriverWaits.waitUntilVisible(editType.clientAsses);
        validate_text(editType.clientAsses, "IQ");
    }
    @Test(priority = 14, enabled = true, description = "Verify Test plan button on <Client> details page.")
    public void verify_TestPlanBtn()  throws InterruptedException{
        AdminPage testPlan = new AdminPage();
        WebdriverWaits.waitForSpinner();
        testPlan.click_TestPlan();
        validate_text(testPlan.testPlanText, "Please choose tests.");
    }
    @Test(priority = 15, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public  void verify_PlanTest()  {
        AdminPage testPlan = new AdminPage();
        testPlan.select_TestPlan();
        testPlan.click_TestPlanSaveButton();
        WebdriverWaits.waitUntilVisible(testPlan.validateCheckBox);
        validate_text(testPlan.validateCheckBox, "WJ Achievement");
    }
    @Test(priority = 16, enabled = false, description = "Verify save Test plan button on <Client> details page.")
    public void verify_DontSaveAssessmentType() throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("GT");
        editType.click_DontSave();
        WebdriverWaits.waitUntilVisible(editType.clientAsses);
        WebdriverWaits.waitForSpinner();
        validate_text(editType.clientAsses, "IQ");
    }
    @Test(priority = 17, enabled = false, description = "Verify save Test plan button on <Client> details page.")
    public void verify_EditTestPlan() throws InterruptedException{
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


    @Test(priority = 18, enabled = false, description = "Verify payment button on <Client> details page.")
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
//        holdAppointmentname = hold.getText_custom(hold.fullName);
//        Log.info(holdAppointmentname);
    }

    @Test(priority = 23, enabled = true, description = "verify yes hold button on hold appointment button.")
    public void verify_yesHoldBtn() {
        AdminPage hold = new AdminPage();
        hold.click_yesHoldBtn();
        WebdriverWaits.waitUntilVisible(hold.allAppointmentsPage);
        WebdriverWaits.waitForSpinner();
        validate_text(hold.allAppointmentsPage, "All Appointments");
    }

    @Test(priority = 24, enabled = true, description = "verify yes hold button on hold appointment popup.")
    public void verify_HoldAppointment() {
        AdminPage hold = new AdminPage();
        hold.click_HoldTab();
        validate_text(hold.holdAppointmentText, "Hold Appointments");
    }

    @Test(priority = 24, enabled = true, description = "verify filter button on hold appointment page.")
    public void verify_holdfilterButton() {
        AdminPage admin = new AdminPage();
        admin.click_HoldFilterBtn();
        String searchPlaceHolder = admin.getAttributevalue(admin.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
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
    public void verify_AllAppointmentsPage()   {
        AppointmentsPage appPage = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AdminPage admin=new AdminPage();
        panelPage.click_ViewAllTab();
        WebdriverWaits.waitUntilVisible(appPage.viewAllActualText);
        WebdriverWaits.waitForSpinner();
        validate_text(appPage.viewAllActualText, "All Appointments");

        admin. view_AllAppointmentPage();
    }


    @Test(priority = 27, enabled = true, description = "Verify filter button and serarchtextbox textbox")
    public void search_CreatedAppointment() {
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage placeHolder = new AdminPage();
        appPage.click_FilterButton();
        String text = appPage.getAttributevalue(appPage.searchTextBox, "placeholder");
        String fromDateplaceholder = placeHolder.getAttributevalue(placeHolder.fromDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(text, "Type here to search");
    }

    @Test(priority = 25, enabled = true, description = "Verify search fromDate and toDate")
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
    @Test(priority = 26, enabled = true, description = "Search created diagnostician by admin")
    public void verify_SearchDiagnostician() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage clickDiagnosticianTab = new DashBoardPanelPage();
        clickDiagnosticianTab.click_DiagnosticianTab();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }

    @Test(priority = 27, enabled = true, description = "Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        // Edit Diagnostician
        String diagnosticianUpdatedEmail = diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail, "12345678", "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        String succ_Msg=getText_custom(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, succ_Msg);
    }

    @Test(priority = 28, enabled = true, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }


    @Test(priority = 29, enabled = true, description = "Verify Don't save button diagnostician by admin")
    public void verify_Dnt_SaveButton() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail = diagnosticianFirstName + "10@yopmail.com";
        diagnostician.verify_DontSave(diagnosticianPhoneNumber, diagnosticianUpdatedEmail, "1234567", "1234567");
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }
    //******************* Edit Director ***************//


    @Test(priority = 30, enabled = true, description = "Creating Director from admin")
    public void verify_Edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage clickDirectorTab = new DashBoardPanelPage();
        clickDirectorTab.click_DirectorTab();
        directorEmailAddress = directorFirstName + "010@yopmail.com";
        director.edit_Director(directorEmailAddress, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
    }

    @Test(priority = 31, enabled = true, description = "Enable toggle button Director from admin")
    public void verify_Director_Enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }

    @Test(priority = 32, enabled = true, description = "verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);
    }

    @Test(priority = 33, enabled = true, description = "Admin is directed to 'Today's Appointment' page")
    public void verify_TodayAppointmentTab() throws InterruptedException
    {
         AdminPage admin= new AdminPage();
         DateGenerator datePage=new DateGenerator();
         DashBoardPanelPage dashboard=new DashBoardPanelPage();
         dashboard.click_AppointmentsTab();
         admin.clickOn_TodayTab();
         validate_text(admin.todayAppointmentTitle,"Today's Appointments");
         String expectedDate=datePage.getCurrentDateFromSystem();
         validate_text(admin.todayDateOnCard,expectedDate);

    }

    @Test(priority = 34, enabled = true, description = "Admin is directed to 'Client Details' page of Today's appointment card")
    public void verify_ClientDetailsPage()  {
        AdminPage admin = new AdminPage();
        String actualText = getText_custom(admin.nameOnCard);
        admin.clickOn_Card();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedTitleText);
    }

    @Test(priority = 35, enabled = true, description = "Admin is directed to 'Test Ready Appointment' page")
    public void verify_TestReadyTab()
    {
        AdminPage admin = new AdminPage();
        admin.clickOn_TestReadyTab();
        validate_text(admin.getTestReadyTitle,"Test Ready Appointments");
    }

    @Test(priority = 36, enabled = true, description = "Admin is directed to 'Client Details' page of Test ready card")
    public void verify_ClientPageTestReady() {
        AdminPage admin = new AdminPage();
        admin.clickOn_TestReadyTab();
        String actualText = getText_custom(admin.nameOnCard);
        admin.clickOn_Card();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println(expectedTitleText);
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedTitleText);
    }


    @Test(priority = 38, enabled = true, description = "Admin is able to click on Export CSV button")
    public void click_OnExportCSVButton() throws InterruptedException , FileNotFoundException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage dashboard=new DashBoardPanelPage();
        admin.clickOn_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }
    @Test(priority = 39, enabled = true, description = "Admin is able to click client detail page after clicking on 'View Details' button")
    public void click_OnViewDetailsButton()  {
        AdminPage admin = new AdminPage();
        ActionEngine action = new ActionEngine();
        action.navigate_Back();
        admin.clickOn_UpcomingTab();
        admin.enter_InSearchField(clientLastName);
        String actualText = getText_custom(admin.getNameOfClient);
        admin.clickOn_ViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println(expectedTitleText);
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }
        validate_AttText(actualText, expectedTitleText);
    }

    @Test(dependsOnMethods = {"verify_Cancelled_Appointments"}, description = "Admin is able to click on 'Test Ready' subtab")
    public void verify_TestComplete_AppointmentPage()
    {
        AdminPage admin = new AdminPage();
        admin.clickOn_TestCompleteTab();
        String actualText = getText_custom(admin.getTitleOfTestComplete);
        validate_AttText(actualText, "Test Complete Appointments");
    }

    @Test(dependsOnMethods = {"verify_TestComplete_AppointmentPage"}, description = "Admin is able to click on 'View Details button of 'Test Complete' subtab")
    public void click_OnTestCompleteViewBtn()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        SuperAdminPage superAdmin=new SuperAdminPage();
        login.adminLogin("allen", "123456");
        String expectedTitle="View Student Observation";
        admin.clickOn_TestCompleteTab();
        String actualText = getText_custom(admin.getNameOfClient);
        admin.clickOn_ViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println(expectedTitleText);
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedTitleText);
        validate_text(superAdmin.viewStudentObservationButton,expectedTitle );


    }

    @Test(priority = 40, enabled = false, description = "Admin is able to click on 'View Observation' button")
    public void click_OnViewObservationBtn()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        SuperAdminPage superAdmin=new SuperAdminPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        admin.clickOn_ViewDetailsBtn();
        admin.clickOn_ViewObservationBtn();
        String expectedText="Client Observation";
        String actualText = getText_custom(superAdmin.clientObservation);
        validate_AttText(actualText, expectedText);

    }

    @Test(priority = 41, enabled = true, description = "20.4 Admin is able to click on 'View Observation' button")
    public void click_OnViewDocumentBtn() throws AWTException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        admin.clickOn_ViewDetailsBtn();
        admin.clickOn_UploadButton();
        admin.clickOn_ChooseFile();
        String filepath = "Downloads\\file-sample_1MB.doc";
        ChromeDownloads.uploadFileUsingRobot(filepath);
        admin.clickOn_UploadButtons();
        admin.clickOn_ViewDocumentBtn();
        String expectedFileName=getText_custom(admin.getTextFromViewDoc);
        System.out.println("expectedFileName= "+expectedFileName);
        admin.clickOn_CloseIcon();
        admin.clickOn_ViewObservationBtn();
        admin.clickOn_ViewDocumentBtn();
        String expectedText="Attached Documents";
        validate_text(admin.getTitleOfAttachedDocument, expectedText);
        String FileName=getText_custom(admin.getTextFromViewDocTwo);
        // Split the input string into an array of words
        String[] words = FileName.split("\\s+");
        String actualFileName=null;
        // Check if there are at least two words in the array
        if (words.length >= 3) {
            // Remove the first and second words
            StringBuilder result = new StringBuilder();
            for (int i = 2; i < words.length; i++) {

               result.append(words[i]).append(" ");
            }
             actualFileName=result.toString().trim();

            // Print the result
            System.out.println("Result: " + result.toString().trim());
        }
        else
        {
            System.out.println("Input string does not have enough words.");
        }
        validate_AttText(actualFileName, expectedFileName);
    }

    @Test(priority = 42, enabled = true, description = "Admin is able to click on 'View Observation' button")
    public void click_OnBackBtn()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        admin.clickOn_ViewDetailsBtn();
        String expectedResult=getText_custom(admin.title);
        admin.clickOn_ViewObservationBtn();
        admin.clickOn_BackBtn();
        String actualResult=getText_custom(admin.title);
        validate_AttText(actualResult, expectedResult);

    }
    @Test(priority = 43, enabled = true, description = "Admin is able to click on 'View Observation' button")
    public void click_OnFilterBtnOfTestComplete()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        admin.clickOn_FilterBtn();

        //Search field
        String searchPlaceHolder = admin.getAttributevalue(admin.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");

    }

    @Test(priority = 44, enabled = true, description = "Admin is able to click on 'Export CSV' button")
    public void click_OnExportCSVBtnOfTestComplete() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DashBoardPanelPage dashboard=new DashBoardPanelPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        admin.clickOn_ExportCSVButtonOfTestComplete();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));

    }
    @Test(priority = 45, enabled = true, description = "Admin is able to click on 'Completed' tab")
    public void Verify_ClickOnCompletedTab()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        String expectedTitle="Completed Appointments";
        validate_text(admin.title,expectedTitle);

    }

    @Test(priority = 46, enabled = true, description = "Admin is able to click on 'Filter' button")
    public void verify_ClickOnFilterBtnOfCompletedTab()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        admin.clickOn_FilterBtn();

        //Search field
        String searchPlaceHolder = admin.getAttributevalue(admin.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");

    }
    @Test(priority = 47, enabled = true, description = "Admin is able to search valid data")
    public void verify_SearchFiled()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");

        String expectedResult=getText_custom(admin.clientNameCompleted);
        admin.enterClientNameInSearchFieldCompleted();
        String actualResult=getText_custom(admin.clientNameCompleted);
        validate_AttText(actualResult, expectedResult);
    }

    @Test(priority = 48, enabled = true, description = "Admin is able to click on 'Export CSV' button")
    public void verify_ClickOnExportCSVCompleted() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DashBoardPanelPage dashboard=new DashBoardPanelPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        admin.clickOn_ExportCSVButtonOfTestComplete();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }

    @Test(priority = 49, enabled = true, description = "Admin is able to click on 'View Details' button")
    public void verify_ClickOnViewDetailsCompleted()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        String expectedResult=getText_custom(admin.clientNameCompleted);
        admin.clickOn_ViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String actualText=null;

        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            actualText = firstWord + " " + secondWord;

            // Print the result
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedResult);


    }
    @Test(priority = 49, enabled = true, description = "Admin is able to click on 'Canceled' button")
    public void verify_ClickOnCanceledBtn()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CanceledTab();
        String expectedTitle="Canceled Appointments";
        admin.filter_ForCancel();
        String statusCancel="Cancel";
        validate_text(admin.getStatus,statusCancel);
    }

    @Test(priority = 50, enabled = true, description = "Admin is able to click on 'Filter' button")
    public void verify_ClickOnFilterCanceled()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CanceledTab();
        admin.clickOn_FilterBtn();

        //Search field
        String actualSearchText = getDriver().findElement(By.xpath("//input[@id='filterSearch']")).getAttribute("placeholder");
        System.out.println(actualSearchText);
        String expectedSearchText="Type here to search";
        validate_AttText(actualSearchText, expectedSearchText);

    }

    @Test(priority = 51, enabled = true, description = "Admin is able to click on 'Back' button")
    public void verify_ClickOnUnholdBackBtn()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin. clickOn_HoldTab();
        String expectedText =getText_custom(admin.title);
        admin.clickOn_UnHoldBtn();
        admin.clickOn_UnholdBackBtn();
        String actualText =getText_custom(admin.title);
        validate_AttText(actualText, expectedText);


    }

    @Test(priority = 52, enabled = true, description = "Admin is able to click on 'View Receipt' button")
    public void verify_ClickOnViewReceiptBtn()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        PaymentPage payment=new PaymentPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        admin.clickOn_ViewDetailsBtn();
        admin.scrollUptoVAmountDue();
        String expectedAmountDue="$0.00";
        String actualAmountDue=getText_custom(payment.amountDue);

        if(actualAmountDue.equals(expectedAmountDue))
        {
            admin.viewReceiptButtonDisplayed();
            String expectedText="View Receipt";
            validate_text(admin.titleOfViewReceipt,expectedText);

        }

        else
        {
            String amountDue=getText_custom(payment.amountDue);
            String actualAmount=amountDue.replace( "$","");
            admin.viewReceiptButtonNotDisplayed();
            admin.send_AmountInEnterAmount(actualAmount);
            admin.clickOn_CollectBtn();
            admin.clickOn_CloseBtn();
            admin.viewReceiptButtonDisplayed();
            String expectedText="View Receipt";
            validate_text(admin.titleOfViewReceipt,expectedText);

        }

    }

    @Test(priority = 52, enabled = true, description = "Admin is able to click on 'Close' button")
    public void verify_ClickOnViewReceiptCloseBtn()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        PaymentPage payment=new PaymentPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        admin.clickOn_ViewDetailsBtn();
        admin.scrollUptoVAmountDue();
        String expectedAmountDue="$0.00";
        String actualAmountDue=getText_custom(payment.amountDue);
        if(actualAmountDue.equals(expectedAmountDue))
        {
            String expectedText=getText_custom(admin.title);
            admin.viewReceiptButtonDisplayed();
            admin.clickOn_CloseBtn();
            String actualText=getText_custom(admin.title);
            validate_AttText(actualText, expectedText);

        }

        else
        {
            String amountDue=getText_custom(payment.amountDue);
            String actualAmount=amountDue.replace( "$","");
            admin.viewReceiptButtonNotDisplayed();
            admin.send_AmountInEnterAmount(actualAmount);
            admin.clickOn_CollectBtn();
            admin.clickOn_CloseBtn();
            String expectedText=getText_custom(admin.title);
            admin.viewReceiptButtonDisplayed();
            admin.clickOn_CloseBtn();
            String actualText=getText_custom(admin.title);
            validate_AttText(actualText, expectedText);

        }

    }


    @Test(priority = 53, enabled = true, description = "Admin is able to click on 'Export CSV' button")
    public void verify_ClickOnUnholdExportBtn() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DashBoardPanelPage dashboard=new DashBoardPanelPage();
        login.adminLogin("allen", "123456");
        admin. clickOn_HoldTab();
        admin.clickOn_ExportCSVButtonOfUnhold();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));


    }

    @Test(priority = 54, enabled = true, description = "Admin is able to click on 'Upcoming' subtab")
    public void verify_ClickOnUpcomingSubtab() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_UpcomingTab();
        String expectedText="Upcoming Appointments";
        validate_text(admin.title,expectedText);


    }

    @Test(priority = 55, enabled = true, description = "Admin is able to click on 'Appointment' subtab")
    public void verify_ClickOnAppointmentTab() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        String expectedText="View All";
        validate_text(admin.viewAllTab,expectedText);


    }



    @Test(priority = 57, enabled = true, description = "Admin is able to click on 'Appointment' tab ")
    public void verify_AppointmentTabGetClose() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.clickOn_AppointmentsTab();
        WebElement element=getDriver().findElement(admin.viewAllTab);
        WebdriverWaits.waitUntilInvisible(admin.viewAllTab);
        Assert.assertFalse(element.isDisplayed());
    }
    //************************ Edit Diagnostician *********************//

    //******************** Logout button **************//
    @Test(priority = 33, enabled = true, description = "Verify login button for admin.")
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


