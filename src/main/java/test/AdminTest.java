package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;
import org.automation.pageObjects.PaymentPage;


import org.automation.utilities.*;
import org.openqa.selenium.By;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.*;

import java.awt.*;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;




import static org.automation.utilities.Assertions.validate_text;
import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.WebdriverWaits.*;
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
    String expectedTextforToayTitle = "Today's Appointments";
    public float beforeAssessmentAmount;
    public float beforeAmountDue;
    public float beforeReceviedAmount;
    public float afterAssessmentAmount;
    public float afterAmountDue;
    public float afterRececiedAmount;
    public String dia_Cell_Number;
    public By fullNameOfClient = By.xpath("//label[text()='Full Name']/following-sibling::p");

    @Test(priority = 0, enabled = true, description = "Verify admin is able to login with valid credentials")
    public void verify_Adminlogin() {

        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        AdminPage dasboard = new AdminPage();
        WebdriverWaits.waitForSpinner();
        validate_text(dasboard.adminDashboardText, "Dashboard");
    }


    @Test(priority = 0, enabled = true, description = "Verify admin is able to login with valid credentials")
    public void admin_login() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        //Login by using superAdmin credentials
        login.superAdminLogin();
        panelPage.click_DiagnosticianTab();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");
        login.adminLogin(adminUserName, "12345678");
        AdminPage dasboard = new AdminPage();
        waitForSpinner();
        validate_text(dasboard.adminDashboardText, "Dashboard");

    }

    //********* Create Daignostician by admin
    @Test(priority = 1, enabled = true, description = "Create diagnostician by admin")
    public void verify_CreateDiagnostician() throws InterruptedException {
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
        validate_text(diagnostician.avaActualText, "Available");
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
    public void verify_ScheduleAppointment() throws InterruptedException {

        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        login.adminLogin("allen", "123456");
        login.adminLogin(adminUserName, "12345678");
        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Plano");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType("Adult ADHD Only");
        validate_SelectedOption(appPage.assestmentType, "Adult ADHD Only");
    }

    @Test(priority = 6, enabled = true, description = "Filling client details by admin.")
    public void verify_FillClientDetailsSection() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.selectAssesmentType("1");
        validate_SelectedOption(appPage.assestmentType, "Adult ADHD Only");
    }

    @Test(priority = 6, enabled = true, description = "Filling client details by admin.")
    public void fill_ClientDetailsSection() throws InterruptedException {
        AppointmentsPage fillClientDetails = new AppointmentsPage();
        clientFirstName = "Au_Theo" + RandomStrings.requiredCharacters(3);
        clientLastName = "Au_Finn" + RandomStrings.requiredCharacters(3);
        clientCellNumber = RandomStrings.requiredDigits(10);
        clientEmail = clientFirstName + "@yopmail.com";
        clientEmail2 = clientFirstName + "101@yopmail.com";
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
    }

    @Test(priority = 4, enabled = false, description = "Filling client details")
    public void fillClientDetails() throws InterruptedException {
        AppointmentsPage schedule = new AppointmentsPage();
        clientFirstName = RandomStrings.requiredCharacters(6);
        clientLastName = RandomStrings.requiredCharacters(6);
        clientCellNumber = RandomStrings.requiredDigits(10);
        clientEmail = clientFirstName + "@yopmail.com";
        clientEmail2 = clientFirstName + "101@yopmail.com";
        schedule.fill_clientDetailsSection(clientFirstName, clientLastName, 2, "19-11-1997", 2, clientCellNumber, clientEmail, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422");
        // validate_text(schedule.actualText,"Appointment Scheduled!!");
    }

    @Test(priority = 5, enabled = false, description = "Verify View client details button on Schedule Appointment popup")
    public void verifyViewDetails() throws InterruptedException {
        //  ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        //  schedule.clickOnviewLink();
        String expectedName = clientFirstName + " " + clientLastName;
        //    validate_text(schedule.fullName,expectedName);z
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

    @Test(priority = 9, enabled = false, description = "Appointment scheduled by admin for a client")
    public void verify_ReScheduleAppointment() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        AppointmentsPage fillClientDetails = new AppointmentsPage();
        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType("Adult ADHD Only");
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, "7654436788", clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
        appPage.selectAssesmentType("1");
        validate_SelectedOption(appPage.assestmentType, "Adult ADHD Only");
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
    }

    //********************** Create Follow Up For Client ***********************//


    @Test(priority = 10, enabled = true, description = "Create follow up for client by admin")
    public void create_FollowUp() {
        AdminPage followUp = new AdminPage();
        followUp.Create_FollowUp();
        WebdriverWaits.waitUntilVisible(followUp.validateScheduledFollowUp);
        WebdriverWaits.waitForSpinner();
        validate_text(followUp.validateScheduledFollowUp, "Follow Up Scheduled!!");
        followUp.click_BackBtn();
    }


    @Test(priority = 11, enabled = false, description = "Re-Assign Appointment for client by admin")
    public void verify_ReAssignAppointment() throws InterruptedException {
        AdminPage reAssign = new AdminPage();
        reAssign.click_ReAssignBn();
        WebdriverWaits.waitUntilVisible(reAssign.reAssignDiagList);
        List<WebElement> reassigList = reAssign.get_diagList(reAssign.diagList);
        boolean result = reAssign.compare_DiagAndReAssignDiagList(diagList, reassigList);
        Assert.assertTrue(result);

    }


    @Test(priority = 11, enabled = true, description = "Edit-Assign Appointment for client by admin")
    public void edit_AssessmentTypePopUp() throws InterruptedException {
        AdminPage editType = new AdminPage();
        editType.click_EditAssessment();
        validate_text(editType.assType, "Change Assessment Type");
    }


    @Test(priority = 12, enabled = true, description = "Verify Edit Assessment type button .")
    public void edit_AssessmentType() throws InterruptedException {

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
    public void edit_Testplan()
    {
        AdminPage testPlan = new AdminPage();
        testPlan.edit_TestPlan();
        validate_text(testPlan.actualEditTest, "WRAML");
    }


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


    @Test(priority = 21, enabled = false, description = "Verify Edit client details popup client page.")
    public void verify_UpdateBtn()
    {
        AdminPage editClient = new AdminPage();
        editClient.edit_ClientInfo("Zoi", "Smith", "401 Broadway E eastate g", "College");
        editClient.click_UpdateClientBtn();
        WebdriverWaits.waitUntilVisible(editClient.actualTextClient);
        validate_text(editClient.actualTextClient, "College");
    }

    @Test(priority = 22, enabled = false, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage()
    {
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.click_AppointmentTab();
        appPage.click_ViewAllTab();
        validate_text(appPage.viewAllActualText, "All Appointments");
    }


    @Test(priority = 19, enabled = true, description = "Verify Edit client Details button client page.")
    public void verify_EditClientBtn()
    {
        AdminPage EditClient = new AdminPage();
        EditClient.click_EditClientBtn();
        WebdriverWaits.waitUntilVisible(EditClient.editCllientActualText);
        validate_text(EditClient.editCllientActualText, "Edit Client Info");
    }



    @Test(priority = 21, enabled = true, description = "verify hold appointment button.")
    public void verify_HoldAppointmentBtn()
    {
        AdminPage hold = new AdminPage();
        hold.click_HoldAppointmentBtn();
        validate_text(hold.holdActualText, "Are you sure you want to hold this appointment?");
//        holdAppointmentname = hold.getText_custom(hold.fullName);
//        Log.info(holdAppointmentname);
    }

    @Test(priority = 22, enabled = true, description = "verify yes hold button on hold appointment button.")
    public void verify_yesHoldBtn()
    {
        AdminPage hold = new AdminPage();
        hold.click_yesHoldBtn();
        WebdriverWaits.waitUntilVisible(hold.allAppointmentsPage);
        WebdriverWaits.waitForSpinner();
        validate_text(hold.allAppointmentsPage, "All Appointments");
    }

    @Test(priority = 23, enabled = true, description = "verify yes hold button on hold appointment popup.")
    public void verify_HoldAppointment()
    {
        AdminPage hold = new AdminPage();

        hold.click_HoldTab();
        validate_text(hold.holdAppointmentText, "Hold Appointments");
    }

    @Test(priority = 24, enabled = true, description = "verify filter button on hold appointment page.")
    public void verify_holdfilterButton()
    {
        AdminPage admin = new AdminPage();
        admin.click_HoldFilterBtn();
        String searchPlaceHolder = admin.GetValueAttribute(admin.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.GetValueAttribute(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.GetValueAttribute(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");
    }

    @Test(priority = 25, enabled = true, description = "verify holded appointment .")
    public void verify_holdedAppointment()
    {
        AdminPage hold = new AdminPage();
        hold.send_textHoldSearchBox(clientFirstName);
        validate_text(hold.validateHoldClient, clientFirstName + "@yopmail.com");
        hold.click_unHoldBtn();
    }


    @Test(priority = 27, enabled = true, description = "Verify filter button and serarchtextbox textbox")
    public void search_CreatedAppointment() {
        AppointmentsPage appPage = new AppointmentsPage();

        AdminPage placeHolder = new AdminPage();
        appPage.click_FilterButton();
        String text = appPage.GetValueAttribute(appPage.searchTextBox, "placeholder");
        String fromDateplaceholder = placeHolder.GetValueAttribute(placeHolder.fromDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(text, "Type here to search");
    }


    @Test(priority = 28, enabled = true, description = "Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        AdminPage admin = new AdminPage();
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




    @Test(priority = 26, enabled = false, description = "verify yes hold button on hold appointment button.")
    public void verify_YesHoldBtn() {
        AdminPage hold = new AdminPage();
        hold.click_yesHoldBtn();
        WebdriverWaits.waitUntilVisible(hold.allAppointmentsPage);
        validate_text(hold.allAppointmentsPage, "All Appointments");
    }



    @Test(priority = 28, enabled = false, description = "verify filter button on hold appointment page.")
    public void verify_HoldFilterButton() {
        AdminPage hold = new AdminPage();
        hold.click_HoldFilterBtn();
        String searchPlaceHolder = hold.GetValueAttribute(hold.searchTextBox, "placeholder");
        String fromDateplaceholder = hold.GetValueAttribute(hold.fromDateText, "placeholder");
        String toDatePlaceholder = hold.GetValueAttribute(hold.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");
    }

    @Test(priority = 29, enabled = false, description = "verify holded appointment .")
    public void verify_HoldedAppointment() {
        AdminPage hold = new AdminPage();
        hold.send_textHoldSearchBox(holdAppointmentname);
        String name = getText_custom(hold.validateHoldClient);
        Log.info(name);
        validate_text(hold.validateHoldClient, holdAppointmentname);
    }

    @Test(priority = 30, enabled = true, description = "Admin is directed to 'Today's Appointment' page")
    public void verify_TodayAppointmentTab() throws InterruptedException
    {
        AdminPage admin = new AdminPage();
        DateGenerator datePage = new DateGenerator();
        admin.clickOn_TodayTab();
        validate_text(admin.todayAppointmentTitle, expectedTextforToayTitle);
        String expectedDate = datePage.getCurrentDateFromSystem();
        validate_text(admin.todayDateOnCard, expectedDate);

    }

    @Test(priority = 31, enabled = true, description = "Admin is directed to 'Client Details' page of Today's appointment card")
    public void verify_ClientDetailsPage() throws InterruptedException
    {
        AdminPage admin = new AdminPage();
        admin.clickOn_AppointmentTab();
        admin.clickOn_TodayTab();
        String actualText = getText_custom(admin.nameOnCard);
        admin.clickOn_Card();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText = null;
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

    @Test(priority = 32, enabled = false, description = "Admin is directed to 'Test Ready Appointment' page")
    public void verify_TestReadyTab() throws InterruptedException
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        String expectedTitle = "Test Ready Appointments";
        admin.clickOn_AppointmentTab();
        admin.clickOn_TestReadyTab();
        validate_text(admin.getTestReadyTitle, expectedTitle);
        admin.enterClientNameInSearchField();
        String expectedStatus = "Test Ready";
        validate_text(admin.getStatus, expectedStatus);

    }

    @Test(priority = 33, enabled = false, description = "Admin is directed to 'Client Details' page of Test ready card")
    public void verify_ClientPageTestReady() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOnAppointmentTab();
        admin.clickOn_TestReadyTab();
        String actualText = getText_custom(admin.nameOnCard);
        admin.clickOn_Card();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText = null;
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

    @Test(priority = 34, enabled = false, description = "Admin is directed to 'Upcoming Appointment' page")
    public void verify_UpcomingTab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        String expectedTitle = "Upcoming Appointments";
        admin.clickOnAppointmentTab();
        admin.clickOn_UpcomingTab();
        validate_text(admin.titleOfUpcomingPage, expectedTitle);
        admin.filter_ForUpcoming();
        String statusTestReady = "Test Ready";
        String statusUpcoming = "Upcoming";
        validate_text(admin.getStatus, statusUpcoming);
        admin.filter_ForTestReady();
        validate_text(admin.getStatus, statusTestReady);
    }

    @Test(priority = 35, enabled = false, description = "Admin is able to click on filter button")
    public void click_OnFilterBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.ClickOn_FilterBtn();

        //Search field
        String searchPlaceHolder = admin.getAttributevalue(admin.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");


    }

    @Test(priority = 36, enabled = false, description = "Admin is able to click on Export CSV button")
    public void click_OnExportCSVButton() throws InterruptedException, FileNotFoundException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DashBoardPanelPage dashboard=new DashBoardPanelPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));

    }

    @Test(priority = 37, enabled = true, description = "Admin is able to redirect on  client detail page after clicking on 'View Details' button")
    public void click_OnViewDetailsButton() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_UpcomingTab();
        waitUntilVisible(admin.getNameOfClient);
        String expectedText = getText_custom(admin.getNameOfClient);
        admin.clickOn_ViewDetailsBtn();
        String actualText = getText_custom(admin.clientNameDetail);
        validate_AttText(actualText, expectedText);

    }

    @Test(priority = 38, enabled = false, description = "Admin is able to click on 'Test Complete' subtab")
    public void click_OnTestCompleteSubtab() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        String expectedText = "Test Complete Appointments";
        String actualText = getText_custom(admin.getTitleOfTestComplete);
        validate_AttText(actualText, expectedText);

    }

    @Test(priority = 39, enabled = false, description = "Admin is able to click on 'View Details button of 'Test Complete' subtab")
    public void click_OnTestCompleteViewBtn() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        SuperAdminPage superAdmin=new SuperAdminPage();
        login.adminLogin("allen", "123456");
        String expectedTitle = "View Student Observation";
        admin.clickOn_TestCompleteTab();
        String actualText = getText_custom(admin.getNameOfClient);
        admin.clickOn_ViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);
        String[] words = clientName.split(" ");
        String expectedTitleText = null;
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
        validate_text(superAdmin.viewStudentObservationButton, expectedTitle);


    }

    @Test(priority = 40, enabled = false, description = "Admin is able to click on 'View Observation' button")
    public void click_OnViewObservationBtn() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        SuperAdminPage superAdmin=new SuperAdminPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        admin.clickOn_ViewDetailsBtn();
        admin.clickOn_ViewObservationBtn();
        String expectedText = "Client Observation";
        String actualText = getText_custom(superAdmin.clientObservation);
        validate_AttText(actualText, expectedText);

    }

    @Test(priority = 41, enabled = true, description = "20.4 Admin is able to click on 'View Document' button")
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
        String expectedFileName = getText_custom(admin.getTextFromViewDoc);
        System.out.println("expectedFileName= " + expectedFileName);
        admin.clickOn_CloseIcon();
        admin.clickOn_ViewObservationBtn();
        admin.clickOn_ViewDocumentBtn();
        String expectedText = "Attached Documents";
        validate_text(admin.getTitleOfAttachedDocument, expectedText);
        String FileName = getText_custom(admin.getTextFromViewDocTwo);
        // Split the input string into an array of words
        String[] words = FileName.split("\\s+");
        String actualFileName = null;
        // Check if there are at least two words in the array
        if (words.length >= 3) {
            // Remove the first and second words
            StringBuilder result = new StringBuilder();
            for (int i = 2; i < words.length; i++) {

                result.append(words[i]).append(" ");
            }


            actualFileName = result.toString().trim();

            // Print the result
            System.out.println("Result: " + result.toString().trim());
        } else {
            System.out.println("Input string does not have enough words.");
        }

        validate_AttText(actualFileName, expectedFileName);
    }

    @Test(priority = 42, enabled = true, description = "Admin is able to click on 'back' button")
    public void click_OnBackBtn() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_TestCompleteTab();
        admin.clickOn_ViewDetailsBtn();
        String expectedResult = getText_custom(admin.title);
        admin.clickOn_ViewObservationBtn();
        admin.clickOn_BackBtn();
        String actualResult = getText_custom(admin.title);
        validate_AttText(actualResult, expectedResult);

    }

    @Test(priority = 43, enabled = true, description = "Admin is able to click on 'Filter' button")
    public void click_OnFilterBtnOfTestComplete() {
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
    public void Verify_ClickOnCompletedTab() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        String expectedTitle = "Completed Appointments";
        validate_text(admin.title, expectedTitle);

    }

    @Test(priority = 46, enabled = true, description = "Admin is able to click on 'Filter' button")
    public void verify_ClickOnFilterBtnOfCompletedTab() {
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
    public void verify_SearchFiled() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        admin.clickOn_FilterBtn();
        String expectedResult = getText_custom(admin.clientNameCompleted);
        admin.enterClientNameInSearchFieldCompleted();
        String actualResult = getText_custom(admin.clientNameCompleted);
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
    public void verify_ClickOnViewDetailsCompleted() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        String expectedResult = getText_custom(admin.clientNameCompleted);
        admin.clickOn_ViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String actualText = null;

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
    public void verify_ClickOnCanceledBtn() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CanceledTab();
        String expectedTitle = "Canceled Appointments";
        admin.filter_ForCancel();
        String statusCancel = "Cancel";
        validate_text(admin.getStatus, statusCancel);
    }

    @Test(priority = 50, enabled = true, description = "Admin is able to click on 'Filter' button")
    public void verify_ClickOnFilterCanceled() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CanceledTab();
        admin.clickOn_FilterBtn();

        //Search field
        String actualSearchText = getDriver().findElement(By.xpath("//input[@id='filterSearch']")).getAttribute("placeholder");
        System.out.println(actualSearchText);
        String expectedSearchText = "Type here to search";
        validate_AttText(actualSearchText, expectedSearchText);

    }

    @Test(priority = 51, enabled = true, description = "Admin is able to click on 'Back' button")
    public void verify_ClickOnUnholdBackBtn() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_HoldTab();
        String expectedText = getText_custom(admin.title);
        admin.clickOn_UnHoldBtn();
        admin.clickOn_UnholdBackBtn();
        String actualText = getText_custom(admin.title);
        validate_AttText(actualText, expectedText);
    }

    @Test(priority = 52, enabled = true, description = "Admin is able to click on 'View Receipt' button")
    public void verify_ClickOnViewReceiptBtn() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        PaymentPage payment = new PaymentPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        admin.clickOn_ViewDetailsBtn();
        admin.scrollUptoVAmountDue();
        String expectedAmountDue = "$0.00";
        String actualAmountDue = getText_custom(payment.amountDue);

        if (actualAmountDue.equals(expectedAmountDue)) {
            admin.viewReceiptButtonDisplayed();
            String expectedText = "View Receipt";
            validate_text(admin.titleOfViewReceipt, expectedText);

        } else {
            String amountDue = getText_custom(payment.amountDue);
            String actualAmount = amountDue.replace("$", "");
            admin.viewReceiptButtonNotDisplayed();
            admin.send_AmountInEnterAmount(actualAmount);
            admin.clickOn_CollectBtn();
            admin.clickOn_CloseBtn();
            admin.viewReceiptButtonDisplayed();
            String expectedText = "View Receipt";
            validate_text(admin.titleOfViewReceipt, expectedText);

        }

    }

    @Test(priority = 53, enabled = true, description = "Admin is able to click on 'Close' button")
    public void verify_ClickOnViewReceiptCloseBtn() {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        PaymentPage payment = new PaymentPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_CompletedTab();
        admin.clickOn_ViewDetailsBtn();
        admin.scrollUptoVAmountDue();
        String expectedAmountDue = "$0.00";
        String actualAmountDue = getText_custom(payment.amountDue);
        if (actualAmountDue.equals(expectedAmountDue)) {
            String expectedText = getText_custom(admin.title);
            admin.viewReceiptButtonDisplayed();
            admin.clickOn_CloseBtn();
            String actualText = getText_custom(admin.title);
            validate_AttText(actualText, expectedText);

        } else {
            String amountDue = getText_custom(payment.amountDue);
            String actualAmount = amountDue.replace("$", "");
            admin.viewReceiptButtonNotDisplayed();
            admin.send_AmountInEnterAmount(actualAmount);
            admin.clickOn_CollectBtn();
            admin.clickOn_CloseBtn();
            String expectedText = getText_custom(admin.title);
            admin.viewReceiptButtonDisplayed();
            admin.clickOn_CloseBtn();
            String actualText = getText_custom(admin.title);
            validate_AttText(actualText, expectedText);

        }

    }


    @Test(priority = 54, enabled = true, description = "Admin is able to click on 'Export CSV' button")
    public void verify_ClickOnUnholdExportBtn() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DashBoardPanelPage dashboard=new DashBoardPanelPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_HoldTab();
        admin.clickOn_ExportCSVButtonOfUnhold();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }

    @Test(priority = 55, enabled = true, description = "Admin is able to click on 'Upcoming' subtab")
    public void verify_ClickOnUpcomingSubtab() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_UpcomingTab();
        String expectedText = "Upcoming Appointments";
        validate_text(admin.title, expectedText);
    }

    @Test(priority = 56, enabled = true, description = "Admin is able to click on 'Appointment' subtab")
    public void verify_ClickOnAppointmentTab() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        String expectedText = "View All";
        validate_text(admin.viewAllTab, expectedText);


    }

    @Test(priority = 57, enabled = true, description = "Admin is able to click on 'Director' tab")
    public void verify_ClickOnDirectorTab() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_DirectorTab();
        String expectedText = "Directors List";
        validate_text(admin.title, expectedText);


    }

    @Test(priority = 58, enabled = true, description = "Admin is able to click on 'Diagnonstician' tab")
    public void verify_ClickOnDiagnosticianTab() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_DiagonsticiansTab();
        String expectedText = "Diagnosticians List";
        validate_text(admin.title, expectedText);


    }

    @Test(priority = 59, enabled = true, description = "Admin is able to click on 'Appointment' tab ")
    public void verify_AppointmentTabGetClose() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.clickOn_AppointmentsTab();
        WebElement element = getDriver().findElement(admin.viewAllTab);
        waitUntilInvisible(admin.viewAllTab);
        Assert.assertFalse(element.isDisplayed());


    }

    @Test(priority = 60, enabled = true, description = "Admin is able to click on 'Client' from 'Background' section.")
    public void verify_ClickOnBackgroundSection() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DashboardPage dashPage=new DashboardPage();
        login.adminLogin("allen", "123456");
        waitUntilVisible(dashPage.clientNameFromBCGForm);
        String ExpectedName = getText_custom(dashPage.clientNameFromBCGForm);
        admin.clickOn_ClientNameBackgroundSection();
        String actualName = getText_custom(admin.clientNameDetail);
        validate_AttText(actualName, ExpectedName);


    }

    @Test(priority = 61, enabled = true, description = "Admin is able to click on 'Client' from 'Background' section.")
    public void verify_ClickOnFollowupSection() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DashboardPage dashPage=new DashboardPage();
        login.adminLogin("allen", "123456");
        waitUntilVisible(dashPage.clientNameFromFollowup);
        String ExpectedName = getText_custom(dashPage.clientNameFromFollowup);
        admin.clickOn_ClientNameFollowupSection();
        String actualName = getText_custom(admin.clientNameDetail);
        validate_AttText(actualName, ExpectedName);
    }

    @Test(priority = 62, enabled = true, description = "Admin is able to click on 'Cancel' button.")
    public void verify_ClickOnCancelBtn() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        DashboardPage dashboard = new DashboardPage();

        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Plano");
        appPage.click_AssessmentDate();
        String expectedText = getText_custom(appPage.saveBtnCalendar);
        appPage.getTotalColumnCount();
        appPage.clickOnCancelButton();
        List<WebElement> allSlots = appPage.getWebElements(appPage.slots);
        boolean result = true;
        for (int i = 0; i < allSlots.size(); i++) {
            String slotsClass = allSlots.get(i).getAttribute("class");
            if (!slotsClass.contains("mbsc-ios mbsc-schedule-event-background ng-star-inserted")) {
                result = false;

            }
        }
        String actualText = getText_custom(appPage.saveBtnCalendar);
        Assert.assertFalse(result);
        validate_AttText(actualText, expectedText);

    }


    @Test(priority = 63, enabled = true, description = "'Type here to search' field appeared director by admin.")
    public void verify_SearchFieldDirector() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_DirectorTab();
        admin.clickOn_FilterBtn();
        //Search field
        String searchPlaceHolder = admin.getAttributevalue(admin.searchTextBox, "placeholder");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");


    }

    @Test(priority = 64, enabled = true, description = "'Type here to search' field appeared director by admin.")
    public void verify_ValSearchFieldDirector() throws FileNotFoundException, InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_DirectorTab();
        admin.clickOn_FilterBtn();
        String expectedName = getText_custom(admin.directorName);
        admin.enter_ValidData(expectedName);
        validate_text(admin.directorName, expectedName);
    }

    @Test(priority = 65, enabled = true, description = "Disable toggle button Director from admin")
    public void verify_DirectorDisableUser() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        DirectorPage director = new DirectorPage();
        admin.clickOn_DirectorTab();
        admin.clickOn_FilterBtn();
        String status = "Active";
        admin.enter_ValidData(status);
        director.disable_Director();
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }

    @Test(priority = 66, enabled = true, description = "'Back' button of create Diagnos from admin")
    public void verify_BackBtnDiagons() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DiagnosticianPage diagnostic = new DiagnosticianPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_DiagonsticiansTab();
        diagnostic.click_createDiagnosticianButton();
        diagnostic.click_Back_Button();
        String expectedText = "Diagnosticians List";
        validate_text(admin.title, expectedText);
    }

    @Test(priority = 67, enabled = true, description = "'Reschedule Appointment' button appeared by Admin")
    public void verify_ClickOnRescheduleBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        DiagnosticianPage diagnostic = new DiagnosticianPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.click_OnViewAllTab();
        admin.clickOn_FilterBtn();
        String status = "Test Ready";
        admin.enter_ValidData(status);
        admin.clickOn_ViewDetailsBtn();
        admin.click_OnRescheduleBtn();
        String expectedTitle = "Reschedule Appointment";
        String title = getText_custom(admin.title);
        // Split the input string into an array of words
        String[] words = title.split("\\s+");
        String actualTitle = null;
        // Check if there are at least two words in the array
        if (words.length >= 3) {
            // Remove the first and second words
            StringBuilder result = new StringBuilder();
            for (int i = 2; i < words.length; i++) {

                result.append(words[i]).append(" ");
            }


            actualTitle = result.toString().trim();
            // Print the result
            System.out.println("Result: " + result.toString().trim());
        } else {
            System.out.println("Input string does not have enough words.");
        }

        validate_AttText(actualTitle, expectedTitle);
    }


    @Test(priority = 68, enabled = true, description = "'Diagnostician Name' field clicked by Admin")
    public void verify_ClickOnDiagNameField() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        AppointmentsPage appointment = new AppointmentsPage();
        ReschedulePage reschedule = new ReschedulePage();
        DiagnosticianPage diagnostic = new DiagnosticianPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.click_OnViewAllTab();
        admin.clickOn_FilterBtn();
        String status = "Test Ready";
        admin.enter_ValidData(status);
        admin.clickOn_ViewDetailsBtn();
        admin.click_OnRescheduleBtn();
        Thread.sleep(4000);
        String expectedDateData = admin.getAttributevalue(reschedule.dateField, "value");
        System.out.println(expectedDateData);
        Thread.sleep(4000);
        String expectedTimeData = admin.getAttributevalue(reschedule.timeField, "value");
        System.out.println(expectedTimeData);
        reschedule.click_OnDiagonsticianField();
        appointment.selectAppointmentSlot();
        Thread.sleep(4000);
        String actualDateData = admin.getAttributevalue(reschedule.dateField, "value");
        System.out.println(actualDateData);
        Thread.sleep(4000);
        String actualTimeData = admin.getAttributevalue(reschedule.timeField, "value");
        System.out.println(actualTimeData);
        Assert.assertFalse(expectedDateData.equals(actualDateData));
        Assert.assertFalse(expectedTimeData.equals(actualTimeData));

    }

    @Test(priority = 69, enabled = true, description = "Invalid email entered by Admin")
    public void verify_enterInvalidEmail() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        AppointmentsPage appointment = new AppointmentsPage();
        ReschedulePage reschedule = new ReschedulePage();
        DiagnosticianPage diagnostic = new DiagnosticianPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.click_OnViewAllTab();
        admin.clickOn_FilterBtn();
        String status = "Test Ready";
        admin.enter_ValidData(status);
        admin.clickOn_ViewDetailsBtn();
        admin.click_OnEditBtn();
        String expectedClassName = "border-danger";
        String invalidEmail = "test123";
        admin.enter_DataInEmailField(invalidEmail);
        String actualClassName = admin.getAttributevalue(admin.editEmail, "class");
        Assert.assertTrue(actualClassName.contains(expectedClassName));

    }

    @Test(priority = 70, enabled = true, description = "'Back' button clicked by Admin")
    public void verify_ClickOnCancelPopupBackBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        AppointmentsPage appointment = new AppointmentsPage();
        ReschedulePage reschedule = new ReschedulePage();
        DiagnosticianPage diagnostic = new DiagnosticianPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.click_OnViewAllTab();
        admin.clickOn_FilterBtn();
        String status = "Test Ready";
        admin.enter_ValidData(status);
        admin.clickOn_ViewDetailsBtn();
        String expectedName = getText_custom(admin.title);
        admin.click_OnCancelBtn();
        admin.clickOn_backBtnCancelPopup();
        String actualName = getText_custom(admin.title);
        validate_AttText(actualName, expectedName);

    }

    @Test(priority = 71, enabled = true, description = "'Cancel' radio button clicked by Admin")
    public void verify_ClickOnCancelRadioBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        AppointmentsPage appointment = new AppointmentsPage();
        ReschedulePage reschedule = new ReschedulePage();
        DiagnosticianPage diagnostic = new DiagnosticianPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.click_OnViewAllTab();
        admin.clickOn_FilterBtn();
        String status = "Test Ready";
        admin.enter_ValidData(status);
        admin.clickOn_ViewDetailsBtn();
        String nameOfClient = getText_custom(admin.nameOfClientDetailsPage);
        String expectedName = "Appointment is Canceled";
        admin.click_OnCancelBtn();
        admin.clickOn_CancelRadioBtn();
        admin.clickOn_FilterBtn();
        admin.enter_ValidData(nameOfClient);
        admin.clickOn_ViewDetailsBtn();
        String actualName = getText_custom(admin.cancelAppointmentValMsg);
        validate_AttText(actualName, expectedName);
    }

    @Test(priority = 72, enabled = true, description = "'Close' button of calendar clicked by Admin")
    public void verify_ClickOnCloseBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.click_OnViewAllTab();
        admin.clickOn_FilterBtn();
        String status = "Test Ready";
        admin.enter_ValidData(status);
        admin.clickOn_ViewDetailsBtn();
        String expectedTitle = getText_custom(admin.title);
        admin.click_CreateFollowUpBtn();
        admin.click_CloseFollowup();
        String actualTitle = getText_custom(admin.title);
        validate_AttText(actualTitle, expectedTitle);
    }

    @Test(priority = 73, enabled = true, description = "'Cancel' button of time slot clicked by Admin")
    public void verify_ClickOnCancelBtnTimeSlot() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        AppointmentsPage appPage = new AppointmentsPage();
        login.adminLogin("allen", "123456");
        admin.clickOn_AppointmentsTab();
        admin.click_OnViewAllTab();
        admin.clickOn_FilterBtn();
        String status = "Test Ready";
        admin.enter_ValidData(status);
        admin.clickOn_ViewDetailsBtn();
        admin.click_CreateFollowUpBtn();
        admin.click_FollowUpSlot();
        admin.click_CancelBtnTimeSlot();
        List<WebElement> allSlots = appPage.getWebElements(appPage.slots);
        boolean result = true;
        for (int i = 0; i < allSlots.size(); i++) {
            String slotsClass = allSlots.get(i).getAttribute("class");
            if (!slotsClass.contains("mbsc-ios mbsc-schedule-event-background ng-star-inserted")) {
                result = false;

            }
        }
        Assert.assertFalse(result);
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
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
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

   /* @Test( dependsOnMethods={ "download_CSV_File_For_completeAss"})
    public void verify_FullPayment() throws InterruptedException
    {
        LoginPage login=new LoginPage();
        AdminPage admin=new AdminPage();
=======
    @Test(dependsOnMethods = {"verify_Cancelled_Appointments"})
    // dependsOnMethods={ "download_CSV_File_For_completeAss"}
    public void verify_Full_Payment() throws InterruptedException, AWTException {
        LoginPage login = new LoginPage();
        AdminPage admin = new AdminPage();
>>>>>>> 765b2b04bb6f92094306d3bdb5d887261cded824
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        login.adminLogin(adminUserName, "12345678");  //"AU_GillGP"   "Au_Theodc"
        admin.paying_DueAmount(clientFirstName);
        WebdriverWaits.waitUntilVisible(admin.clientNameDetail);
        validate_text(admin.clientNameDetail, clientFirstName + ' ' + clientLastName + ' ' + "Details");
        admin.upload_FileAttachment();
        panelpage.click_LogOutLink();
    }*/

}

