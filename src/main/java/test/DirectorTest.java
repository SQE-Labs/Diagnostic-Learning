package test;


import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.DateGenerator.getMonthAndYear;


public class DirectorTest extends BaseTest {
    DirectorPage director = new DirectorPage();
    DiagnosticianPage dashpage = new DiagnosticianPage();
    DashBoardPanelPage panelPage = new DashBoardPanelPage();
    LoginPage login = new LoginPage();

    @Test(priority = 1, enabled = true, description = "1 Verify Director is able to login with valid credentials")
    public void verify_Login_Director() {
        login.director_Login();
        validate_text(director.dashboardPage, "Dashboard");

    }

    @Test(priority = 2, enabled = true, description = " 4 Verify that 'Appointments' tab expands, on 'Dashboard' page.")
    public void verify_AppointmentsTabExpands() {
        panelPage.click_AppointmentsTab();
        validate_text(director.viewAll, "View All");

    }


    @Test(priority = 3, enabled = true, description = "12 and 13 Verify that 'Set Availability' page opens up and Year Picker appear")
    public void validate_SetAppointment_AND_YearPicker() throws InterruptedException {
        panelPage.click_Availability();
        validate_text(director.setAvailaibility, "Set Availability");
        String currentDate = getMonthAndYear();
        validate_text(director.monthHeader, currentDate.split(" ")[0]);
        validate_text(director.yearHeader, currentDate.split(" ")[1]);
        String expectedText = getText_custom(director.yearButton);
        director.click_MonthHeader();
        String yearTitleText = getText_custom(director.yearsTitle);

        // Split the string into words
        String[] words = yearTitleText.split(" ");

        // Get the first word
        String actualText = words[0];
        System.out.println(actualText);
        validate_AttText(actualText, expectedText);
        validate_text(director.yearTitleFromText, currentDate.split(" ")[1]);
    }


    @Test(priority = 4, enabled = true, description = "20 and 21 Verify that 'Available' card appears and click on Save button.")
    public void verify_AvailableCards_AND_SaveButtonEnabled() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        AdminPage admin = new AdminPage();
        panelPage.click_Availability();
        //todo
        director.director_AvailabilityWithoutSaveBtn();
        validate_text(director.validateAvailable, "Available");
        director.click_SaveButton();
        validate_text(admin.title, "Set Availability");


    }


    @Test(priority = 5, enabled = true, description = "24 Verify that '<Date>' popup closes, when director clicks on 'Cancel' button")
    public void verify_Closed_PopUp_OnCancel() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appPage = new AppointmentsPage();
        DirectorPage director = new DirectorPage();
        panelPage.click_Availability();
        dashpage.cancel_Availability();
        director.deleting_Availability();
        List<WebElement> allSlots = appPage.getWebElements(appPage.slots);
        boolean result = true;
        for (int i = 0; i < allSlots.size(); i++) {
            String slotsClass = allSlots.get(i).getAttribute("class");
            if (!slotsClass.contains("mbsc-ios mbsc-schedule-event-background ng-star-inserted")) {
                result = false;

            }
        }
        validate_text(director.today, "Today");
    }


    @Test(priority = 6, enabled = true, description = "23 Verify that director is able to delete already available marked slot")
    public void verify_DeleteSlots() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        verify_Login_Director();
        director.click_AvailaibleSlot();
        director.click_DeleteSlot();
        director.click_DeleteButton();
        //  validate_text(director.deletedSlot, " ");
        director.click_SaveButton();

    }

    @Test(priority = 7, enabled = true, description = "6 Verify that director is directed to 'Today's Appointments' page")
    public void verify_Today_AppointmentPage() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        panelPage.click_AppointmentsTab2();
        appointment.click_Today_AppointmentCard();
        validate_text(appointment.todaysAppointmentTXT, "Today's Appointments");

    }

    @Test(priority = 8, enabled = true, description = "8 Verify that director is directed to 'Today's Appointments' page")
    public void verify_Upcoming_AppointmentPage() throws InterruptedException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.click_UpcomingCard();
        validate_text(appointment.upcomingAppointmentTXT, "Upcoming Appointments");

    }

    @Test(priority = 9, enabled = true, description = "13 Verify that search textbox, 'From Date' and 'To Date' date picker appear")
    public void verify_SearchTextBox() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        String searchPlaceHolder = admin.getAttributevalue(appointment.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.getAttributevalue(appointment.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(appointment.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");
    }


    @Test(priority = 10, enabled = true, description = "14 Verify that relevant records appear after entering valid data in search textbox, on 'Upcoming Appointments' page")
    public void verify_RelevantRecords() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DashboardPage dashPage = new DashboardPage();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        dashPage.enter_DataSearhTextBox("Mark Henry");
        validate_text(appointment.firstSearchedRecord, "Mark Henry");
    }

    //TODO //After the fix we will added assertions//
    @Test(priority = 11, enabled = true, description = "16 Verify that date picker appears after clicking on calendar icon in 'From Date' field")
    public void verify_FromDatePickerAppear() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        appointment.click_FromDate();
    }

    //TODO //After the fix we will added assertions//
    @Test(priority = 12, enabled = false, description = "21 Verify that date picker appears after clicking on calendar icon in 'To Date' field")
    public void verify_ToDatePickerAppear() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        appointment.click_Filter();
        appointment.click_ToDate();
    }

    @Test(priority = 13, enabled = true, description = "28 Verify that CSV file gets downloaded after clicking on 'Export to CSV' button")
    public void verify_CSV_GetsDownloaded() throws InterruptedException, FileNotFoundException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_UpcomingCard();
        appointment.exportCSV_Button();
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));

    }

    @Test(priority = 14, enabled = true, description = "29 Verify that admin is directed to '<client Details>' page after clicking 'View Details'  button")
    public void verify_ViewDetailsPage() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();
        validate_text(appointment.getAppointmentDetails, "Appointment Details");

    }

    @Test(priority = 15, enabled = true, description = "Verify that 'Test Plan' pop up appears after clicking 'Test Plan' button")
    public void verify_TestPlan_PopupAppears() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();

    }

    @Test(priority = 16, enabled = true, description = " Verify that 'Test Plan' pop up appears after clicking 'Test Plan' button.")
    public void verify_TestPlan_AND_AddComments() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();
        appointment.click_EditTestPlan();
        appointment.select_Checkbox();
        appointment.enter_OtherComments("My Appointment");
        appointment.click_SaveButton();

    }

    @Test(priority = 17, enabled = true, description = "33 Verify that changes made by director on 'Test Plan' popup does not get saved, after clicking 'Close' button")
    public void verify_TestPlan_ChangesSaved() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();
        appointment.click_EditTestPlan();
        appointment.select_Checkbox();
        appointment.click_CloseButton();

    }

    @Test(priority = 18, enabled = true, description = "36 Verify that 'Collect Payment' popup opens up after clicking 'Payment' button")
    public void verify_CollectPayment_PopupOpenUp() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();
        appointment.click_PaymentButton();
        validate_text(appointment.collectPaymentTXT, "Collect Payment");

    }

    @Test(priority = 19, enabled = true, description = "37 Verify that 'Test Fee Adjustment' field accepts positive amount and that positive amount gets added to 'Assessment Amount' and 'Amount Due' values, on 'Collect Payment' pop up")
    public void verify_TestFeeAdjustment() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        PaymentPage payment = new PaymentPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();
        appointment.click_PaymentButton();
        payment.enter_TestFeeAdjustment("100");
        payment.click_CollectButton();
        payment.click_CloseBtn_PopUp();
    }

    @Test(priority = 20, enabled = true, description = "Verify that validation message appears after entering negative amount in 'Enter Amount' field, on 'Payment' popup")
    public void verify_NegativeValue_ValMsg() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        PaymentPage payment = new PaymentPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();
        appointment.click_PaymentButton();
        payment.enter_TestFeeAdjustment("-700");
        validate_text(payment.ValMsgAfterNegativeValueTXT, "Invalid adjustment or amount. Ensure the total due is not negative and the entered amount does not exceed the due balance.");

    }

    @Test(priority = 21, enabled = true, description = "Verify that validation message appears after entering negative amount in 'Enter Amount' field, on 'Payment' popup")
    public void verify_CollectButtonEnabled() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        PaymentPage payment = new PaymentPage();
        panelPage.click_AppointmentsTab();
        appointment.click_ViewAll();
        appointment.click_ViewDetailLink();
        appointment.click_PaymentButton();
        payment.enter_TestFeeAdjustment("-700");
        payment.enter_collectAmountAdjustment("20");

    }


    @Test(priority = 22, enabled = true, description = "25 Verify that director gets logged out after clicking 'Log Out' button")
    public void verify_DirectorLogOut() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.click_LogOutLink();
        validate_text(director.signInToYourAccountTxt, "Sign in to your account");

    }

    @Test(priority = 23, enabled = true, description = "67. 'Test Fee Adjustment' field accepts negative value")
    public void verify_EnterNegativeValueInTestFeeAdjustmentFee() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashboardPage dashPage = new DashboardPage();
        PaymentPage payment = new PaymentPage();
        appointment.click_AppoinptmentTab();
        appointment.click_ViewAllTab();
        String status = "Test Ready";
        dashPage.enter_DataSearhTextBox(status);
        appointment.click_ViewDetails();
        Float beforeAssementAmount = payment.retrieveAmount(payment.assessmentAmountInDisplay);
        Float beforeAmountDue = payment.retrieveAmount(payment.amountDue);
        payment.clickOn_PaymentBtn();
        payment.enter_TestFeeAdjustment("-200.00");
        payment.click_OnCollectAmountBtn();
        payment.click_CloseBtn();
        Float afterAssementAmount = payment.retrieveAmount(payment.assessmentAmountInDisplay);
        Float afterAmountDue = payment.retrieveAmount(payment.amountDue);
        Assert.assertEquals((afterAssementAmount - beforeAssementAmount), "-200.00");
        Assert.assertEquals((afterAmountDue - beforeAmountDue), "-200.00");

    }

    @Test(priority = 24, enabled = true, description = "68. 'Test Fee Adjustment' field accepts negative value")
    public void verify_EnterPositiveValueInTestFeeAdjustmentFee() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashboardPage dashPage = new DashboardPage();
        PaymentPage payment = new PaymentPage();
        appointment.click_AppoinptmentTab();
        appointment.click_ViewAllTab();
        String status = "Test Ready";
        dashPage.enter_DataSearhTextBox(status);
        appointment.click_ViewDetails();
        Float beforeReceviedAmount = payment.retrieveAmount(payment.receivedAmountOnDisplay);
        Float beforeAmountDue = payment.retrieveAmount(payment.amountDue);
        payment.clickOn_PaymentBtn();
        payment.enter_collectAmountAdjustment("200.00");
        payment.click_OnCollectAmountBtn();
        payment.click_CloseBtn();
        Float afterReceviedAmount = payment.retrieveAmount(payment.receivedAmountOnDisplay);
        Float afterAmountDue = payment.retrieveAmount(payment.amountDue);
        Assert.assertEquals((afterReceviedAmount - beforeReceviedAmount), "200.00");
        Assert.assertEquals((beforeAmountDue - afterAmountDue), "200.00");

    }

    @Test(priority = 25, enabled = true, description = "72. User is redirected to  'Marchant login' page")
    public void verify_MarchantLogin() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashboardPage dashPage = new DashboardPage();
        PaymentPage payment = new PaymentPage();
        DirectorPage director = new DirectorPage();
        appointment.click_UpcomingTab();
        String status = "Test Ready";
        dashPage.enter_DataSearhTextBox(status);
        director.click_EditBtnAfterSearch();
        payment.clickOn_PaymentBtn();
        payment.click_PaymentLinkButton();
        validate_text(payment.usernamePaymentMerchant, "Username");

    }

    @Test(priority = 26, enabled = true, description = "73. User is able to click on 'Cancel' button.")
    public void verify_ClickOnCanceBtn() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        DashboardPage dashPage = new DashboardPage();
        PaymentPage payment = new PaymentPage();
        DirectorPage director = new DirectorPage();
        appointment.click_UpcomingTab();
        String status = "Test Ready";
        dashPage.enter_DataSearhTextBox(status);
        director.click_EditBtnAfterSearch();
        String expecetedClientName = getText_custom(admin.title);
        payment.clickOn_PaymentBtn();
        payment.clickOn_CancelBtn();
        validate_text(admin.title, expecetedClientName);
    }

    @Test(priority = 27, enabled = true, description = "User is able to click on 'Upcoming' subtab.")
    public void verify_ClickOnUpcomingSubtab() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        DashboardPage dashPage = new DashboardPage();
        PaymentPage payment = new PaymentPage();
        DirectorPage director = new DirectorPage();
        appointment.click_UpcomingTab();
        validate_text(admin.titleOfUpcomingPage, "Upcoming Appointments");
        String status = "Upcoming";
        dashPage.enter_DataSearhTextBox(status);
        director.click_ViewDetailsBtn();
        String expecetedClientName = getText_custom(admin.title);
        payment.clickOn_PaymentBtn();
        payment.clickOn_CancelBtn();
        validate_text(admin.title, expecetedClientName);
    }

    @Test(priority = 28, enabled = true, description = "45., 52. User is able to click on 'Create Followup' for a client.")
    public void verify_ClickOnCreateFollowupBtn() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();
        DashboardPage dashPage = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();

        DirectorPage director = new DirectorPage();
        appointment.click_UpcomingTab();
        validate_text(admin.titleOfUpcomingPage, "Upcoming Appointments");
        dashPage.enter_DataSearhTextBox("Upcoming");
        director.click_ViewDetailsBtn();

        //Clicked on 'Close' button.
        String expectedName = getText_custom(director.nameOfClient);
        director.click_CreateFollowUpBtn();
        director.click_CloseBtn();
        String actualName = getText_custom(director.nameOfClient);
        validate_AttText(actualName, expectedName);
    }

    @Test(priority = 29, enabled = true, description = "58, 59 verify director is able to change follow up or not")
    public void verify_CancelFollowUp() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appPage = new AppointmentsPage();
        //Clicked on 'Cancel' button.
        director.click_CreateFollowUpBtn();
        director.CancelFollowupSlot(0);
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

    @Test(priority = 30, enabled = true, description = "60, 61, verify director is able to change follow up or not")
    public void verify_ResetFollowUp() {
        AdminPage admin = new AdminPage();
        AppointmentsPage appPage = new AppointmentsPage();
        //Clicked on 'Reset' button
        director.click_FollowUpSlot(0);
        director.click_FollowUpSlotSaveBtn();
        director.click_ResetBtnSlot();
        List<WebElement> allSlotsAfterReset = appPage.getWebElements(appPage.slots);
        boolean resultForReset = true;
        for (int i = 0; i < allSlotsAfterReset.size(); i++) {
            String slotsClass = allSlotsAfterReset.get(i).getAttribute("class");
            if (!slotsClass.contains("mbsc-ios mbsc-schedule-event-background ng-star-inserted")) {
                resultForReset = false;

            }
        }

        Assert.assertFalse(resultForReset);
    }

    @Test(priority = 31, enabled = true, description = "63., 64. & 65verify director is able to change follow up or not")
    public void verify_ChangeFollow() {
        AdminPage admin = new AdminPage();
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

    }

    @Test(priority = 32, enabled = true, description = "2. User is able to click on 'View All' subtab.")
    public void verify_ClickOnViewAllSubtab() throws InterruptedException {
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

    }

    @Test(priority = 33, enabled = true, description = "3. User is able to click on Today's subtab.")
    public void verify_ClickOnTodaySubtab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DateGenerator datePage = new DateGenerator();
        AppointmentsPage appPage = new AppointmentsPage();
        appPage.click_AppointmentsTab();
        admin.clickOn_TodayTab();
        validate_text(admin.todayAppointmentTitle, "Today's Appointments");
        String expectedDate = datePage.getCurrentDateFromSystem();
        validate_text(admin.todayDateOnCard, expectedDate);

    }

    @Test(priority = 34, enabled = true, description = "4. User is able to click on 'Test Ready' subtab.")
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
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;
        }
        validate_AttText(actualText, expectedTitleText);

    }


    @Test(priority = 35, enabled = true, description = "6., 20. & 35. User is able to click on 'Test complete' subtab.")
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
        String searchPlaceHolder = admin.getAttributevalue(admin.searchTextBox, "placeholder");
        String fromDateplaceholder = admin.getAttributevalue(admin.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(admin.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
        Assert.assertEquals(searchPlaceHolder, "Type here to search");

        //Click on Export CSV Btn
        dashboard.click_ExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));


    }

    @Test(priority = 36, enabled = true, description = "7. User is able to click on 'Completed' subtab.")
    public void verify_ClickOnCompletedSubtab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        dashboard.click_AppointmentsTab();
        dashboard.click_CompletedTab();
        WebdriverWaits.waitForSpinner();
        String expectedTitle = "Completed Appointments";
        validate_text(admin.title, expectedTitle);
    }

    @Test(priority = 37, enabled = true, description = "8. User is able to click on 'Canceled' subtab.")
    public void verify_ClickOnCanceledSubtab() throws InterruptedException {
        AdminPage admin = new AdminPage();
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage dashboard = new DashBoardPanelPage();
        appointment.click_CanceledTab();
        validate_text(admin.title, "Canceled Appointments");
        admin.filter_ForCancel();
        validate_text(admin.getStatus, "Cancel");
    }


}
