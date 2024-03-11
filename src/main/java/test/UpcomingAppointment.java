package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.DateGenerator.getMonthAndYear;

class UpcomingAppointment extends BaseTest {

    public static String diagnosticianUserName;
    public static String directorUserName;
    public static String clientLastName;
    public static String clientFirstName;
    String clientEmail;
    String clientEmail2;
    String  clientCellNumber;
    String fullName;
    List<WebElement> diagList;

    @Test(priority = 0, enabled = true, description = "Verify that director is able to execute all before all methods")
    public  void verify_Create_Diagnostician_By_SuperAdmin() throws InterruptedException {
        //Login by using superAdmin credentials

        //create  diagnostician
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        AppointmentsPage appPage = new AppointmentsPage();
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage fillClientDetails = new AppointmentsPage();

        String diagnosticianFirstName = "AU_Sarah" + RandomStrings.requiredCharacters(3);
        String diagnosticianLastName = "AU_Hill" + RandomStrings.requiredCharacters(3);
        String diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "AU_Ward" + RandomStrings.requiredCharacters(3);
        String dia_Cell_Number = RandomStrings.requiredDigits(10);


        // Login into admin
        login.admin_Login();
        panelPage.click_DiagnosticianTab();
        diagnostician.click_createDiagnosticianButton();

        //**************Admin is creating diagnostician*************
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, "Austin", diagnosticianUserName, "123456", "123456");
        diagnostician.enter_InSearchField(diagnosticianUserName);

        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");

        //create  director
        String directorFirstName = "AU_Felix" + RandomStrings.requiredCharacters(3);
        String directorLastName = "AU_Tyler" + RandomStrings.requiredCharacters(3);
        String directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Lucy" + RandomStrings.requiredCharacters(3);
        String dir_Cell_Number = RandomStrings.requiredDigits(10);

        //Login with super Admin credentials
        panelPage.click_DirectorTab();
        director.create_Director(directorFirstName, directorLastName, dir_Cell_Number, directorEmailAddress, directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.directorListPage);
        validate_text(director.directorListPage, "Directors List");
        panelPage.click_LogOutLink();

        //Set Availbility Diag
        login.diagnosticianLogin(diagnosticianUserName, "123456");
        diagnostician.set_Availability();
        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
        panelPage.click_LogOutLink();

        //Set Availbility of Director
        login.directorLogin(directorUserName, "123456");
        panelPage.click_Availability();
        director.director_Availability(2);
        panelPage.click_LogOutLink();

        //schedule appt by admin
        login.admin_Login();
        dashboard.clickScheduleAppointment();
        WebdriverWaits.waitUntilVisible(appPage.titleText);
        appPage.locationName_Lists();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot(0);
        appPage.selectAssesmentType("Adult ADHD Only");
        clientFirstName = "Au_Theo" + RandomStrings.requiredCharacters(3);
        clientLastName = "Au_Finn" + RandomStrings.requiredCharacters(3);
        fullName = clientFirstName + " " + clientLastName;
        clientCellNumber = RandomStrings.requiredDigits(10);
        clientEmail = clientFirstName + "@yopmail.com";
        clientEmail2 = clientFirstName + "101@yopmail.com";
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
        panelPage.click_LogOutLink();
        Thread.sleep(5000);

    }


    @Test(priority = 1, enabled = true, description = "6. Verify that director is directed to 'Today's Appointments' page")
    public void verify_Today_AppointmentPage() throws InterruptedException
    {
        AppointmentsPage appointment = new AppointmentsPage();
        LoginPage login = new LoginPage();
        Thread.sleep(5000);
        login.directorLogin(directorUserName, "123456");
        appointment.click_AppointmentsTab();
        appointment.click_Today_AppointmentCard();
        validate_text(appointment.todaysAppointmentTXT, "Today's Appointments");
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");
    }

    @Test(priority = 2, enabled = true, description = "2. User is able to click on 'View All' subtab.")
    public void verify_ClickOnViewAllSubtab() throws InterruptedException
    {
        AdminPage admin = new AdminPage();
        DashboardPage dashPage = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        DirectorPage director = new DirectorPage();

        appPage.click_AppointmentsTab();
        appPage.click_ViewAllTab();
        validate_text(admin.allAppointmentsPage, "All Appointments");
        String expectedRecord = getText_custom(director.getNameOfClient);
        dashPage.enter_DataSearhTextBox(expectedRecord);
        validate_text(director.clientName, expectedRecord);
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");
    }

    @Test(priority = 3, enabled = true, description = "8.& 13. Verify that director is able to click on filter button")
    public void verify_UpcomingAppointmentPage() throws InterruptedException, FileNotFoundException
    {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();

        //Click on Upcoming tab
        appointment.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        validate_text(appointment.upcomingAppointmentTXT, "Upcoming Appointments");

        //click on filter button
        admin.click_HoldFilterBtn();
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
    }

    @Test(priority = 4, enabled = true, description = "14. Verify that director is able to search relevant records")
    public void verify_RelevantRecordsAppear() throws InterruptedException, FileNotFoundException
    {
        DirectorPage director=new DirectorPage();
        AdminPage admin=new AdminPage();
        String data=getText_custom(director.clientNameUpcomingPage);
        director.searchTextField(data);
        admin.click_ViewDetailsBtn();
        validate_text(director.fullNameOfClient, data);
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");

    }


    @Test(priority = 5, enabled = true, description = "28. Verify that director is able to click on Export CSV  button")
    public void verify_ExportBtn() throws FileNotFoundException, InterruptedException
    {

        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        //Click on Export CSV button
        appointment.click_ExportCSVButton();
        String downloadFile = panelPage.getDownloadFileName();
        Assert.assertTrue(panelPage.isFileDownloaded(downloadFile));
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");

    }

    @Test(priority = 6, enabled = true, description = "29, 30, 33 & 34 Verify that admin is directed to '<client Details>' page after clicking 'View Details'  button")
    public void verify_ViewDetailsPage() throws InterruptedException
    {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        AdminPage testPlan = new AdminPage();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingTab();
        director.searchTextField(fullName);
        appointment.click_ViewDetailLink();
        String expectedTitle=getText_custom(testPlan.title);
        //Verify that 'Test Plan' pop up appears after clicking 'Test Plan' button, on '<Client> Details page.
        appointment.click_EditTestPlan();
        validate_text(director.editTestPopupTitle, "Please choose tests.");
        director.click_CloseBtnEditPopup();
        validate_text(testPlan.title, expectedTitle);
        validate_text(appointment.getAppointmentDetails, "Appointment Details");
        //Verify that changes made by director on 'Test Plan' popup does not get saved, after clicking 'Close' button, on 'Test Plan' popup of '<Client Details>' page.
        appointment.click_EditTestPlan();
        appointment.select_Checkbox();
        //Verify that director is able to add comments in 'Other Comments' field, on 'Test Plan' popup of '<Client> Details' page.
        appointment.enter_OtherComments("My Appointment");
        appointment.click_SaveButton();
        validate_text(appointment.selectWISC, "WAIS");
        Thread.sleep(2000);
    }

    @Test(priority = 7, enabled = true, description = "45., 59. User is able to click on 'Create Followup' for a client.")
    public void verify_ClickOnCreateFollowupBtn() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        //Clicked on 'Close' button.
        String expectedName = getText_custom(director.nameOfClient);
        director.click_CreateFollowUpBtn();
        director.click_CloseBtn();
        String actualName = getText_custom(director.nameOfClient);
        validate_AttText(actualName, expectedName);
    }

    @Test(priority = 8, enabled = true, description = "58, 52 verify director is able to change follow up or not")
    public void verify_CancelFollowUp() throws InterruptedException {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        DashboardPage dashPage = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        DirectorPage director = new DirectorPage();
        //Clicked on 'Cancel' button.

       /* appointment.click_UpcomingTab();
        validate_text(admin.titleOfUpcomingPage, "Upcoming Appointments");
        dashPage.enter_DataSearhTextBox("Upcoming");
        director.click_ViewDetailsBtn();*/

        director.click_CreateFollowUpBtn();
        director.cancelFollowupSlot(0);
        List<WebElement> allSlots = appPage.getWebElements(appPage.slots);
        boolean result = true;
        for (int i = 0; i < allSlots.size(); i++)
        {
            String slotsClass = allSlots.get(i).getAttribute("class");
            if (!slotsClass.contains("mbsc-ios mbsc-schedule-event-background ng-star-inserted"))
            {
                result = false;

            }
        }

        Assert.assertFalse(result);
    }

    @Test(priority = 9, enabled = true, description = "60, 61, verify director is able to Reset follow up or not")
    public void verify_ResetFollowUp()
    {
        AdminPage admin = new AdminPage();
        AppointmentsPage appPage = new AppointmentsPage();
        DirectorPage director = new DirectorPage();

        //Clicked on 'Reset' button
        director.click_FollowUpSlot(0);
        director.click_FollowUpSlotSaveBtn();
        director.click_ResetBtnSlot();
        List<WebElement> allSlotsAfterReset = appPage.getWebElements(appPage.slots);
        boolean resultForReset = true;
        for (int i = 0; i < allSlotsAfterReset.size(); i++)
        {
            String slotsClass = allSlotsAfterReset.get(i).getAttribute("class");
            if (!slotsClass.contains("mbsc-ios mbsc-schedule-event-background ng-star-inserted"))
            {
                resultForReset = false;
            }
        }
        Assert.assertFalse(resultForReset);
    }

    @Test(priority = 10, enabled = true, description = "63., 64. & 65 verify director is able to change follow up or not")
    public void verify_ChangeFollow() {
        AdminPage admin = new AdminPage();
        DirectorPage director = new DirectorPage();
        //Clicked on  'Change' button
        director.click_FollowUpSlot(0);
        director.click_FollowUpSlotSaveBtn();
        director.click_FollowUpSaveBtn();
        director.click_ChangeBtn();
        String currentDate = getMonthAndYear();
        validate_text(director.monthHeader, currentDate.split(" ")[0]);

        //End to End Flow
        director.click_FollowUpSaveBtn();
        director.click_ConfirmFollowUpBtn();
        WebdriverWaits.waitUntilVisible(admin.validateScheduledFollowUp);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.validateScheduledFollowUp, "Follow Up Scheduled!!");
        admin.click_BackBtn();
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");

    }

    @Test(priority = 11, enabled = true, description = "3. User is able to click on Today's subtab.")
    public void verify_ClickOnTodaySubtab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DateGenerator datePage = new DateGenerator();
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.click_AppointmentsTab();
        admin.clickOn_TodayTab();
        validate_text(admin.todayAppointmentTitle, "Today's Appointments");
        String expectedDate = datePage.getCurrentDateFromSystem();
        validate_text(admin.todayDateOnCard, expectedDate);
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");
    }

    @Test(priority = 12, enabled = true, description = "4. User is able to click on 'Test Ready' subtab.")
    public void verify_ClickOnTestReadySubtab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_TestReadyTab();
        validate_text(admin.getTestReadyTitle, "Test Ready Appointments");
        String actualText = getText_custom(admin.nameOnCard);
        admin.click_Card();
        String clientName = getText_custom(admin.clientNameDetail);
        String[] words = clientName.split(" ");
        String expectedTitleText = null;
        if (words.length >= 2)
        {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;
        }
        validate_AttText(actualText, expectedTitleText);
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");
    }

    @Test(priority = 13, enabled = true, description = "5. 9., 10., 11., 14. User is able to click on 'Upload Document' button.")
    public void verify_ClickOnUploadDocBtn() throws InterruptedException, AWTException {
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        DashboardPage dashPage = new DashboardPage();
        DirectorPage director = new DirectorPage();
        ActionEngine action = new ActionEngine();
        appointment.click_UpcomingTab();
        dashPage.enter_DataSearhTextBox("Test Ready");
        director.click_ViewDetailsBtn();
        admin.click_UploadButton();
        director.click_CancelBtn();
        boolean result = action.isElementDisplay_custom(director.viewDocBtn, "ViewDoc");
        Assert.assertFalse(result);
        admin.click_UploadButton();
        validate_text(director.titleUploadDoc, "Upload Documents");
        admin.upload_FileAttachment();
        director.click_ViewDocBtn();
        String input = getText_custom(director.fileName);
        String[] words = input.split("\\s+");
        System.out.println(words);
        String trimmedString = "";
        if (words.length > 2) {
            trimmedString = String.join(" ", Arrays.copyOf(words, words.length - 2));
        } else {
            System.out.println("The input string does not have enough words to trim.");
        }
        validate_AttText(trimmedString, "file-sample_1MB (1).doc");
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");
    }

    @Test(priority = 14, enabled = true, description = "6., 20. & 35. User is able to click on 'Test complete' subtab.")
    public void verify_ClickOnTestCompleteSubtab() throws InterruptedException, FileNotFoundException {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        dashboard.click_AppointmentsTab();
        appointment.click_TestCompleteTab();
        WebdriverWaits.waitUntilVisible(admin.getTitleOfTestComplete);
        validate_text(admin.getTitleOfTestComplete, "Test Complete Appointments");

        // Click on Filter Btn
        admin.click_FilterBtn();

        //Search field
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");

        //Click on Export CSV Btn
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));
    }

    @Test(priority = 15, enabled = true, description = " 15., 16.,17.,36. User is able to click on 'View Observation' button.")
    public void verify_ClickOnViewObservationBtn() throws InterruptedException, AWTException {
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        DashboardPage dashPage = new DashboardPage();
        DirectorPage director = new DirectorPage();
        ActionEngine action = new ActionEngine();
        appointment.click_AppointmentsTab();
        appointment.click_TestCompleteTab();
        director.click_ViewDetailBtn();
        String expectedTitle = getText_custom(admin.title);
        director.click_ViewObservationBtn();
        validate_text(director.titleClientObservation, "Client Observation");
        director.click_BackBtn();
        validate_text(admin.title, expectedTitle);
    }
}


