package test;

import org.automation.base.BasePage;
import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPanelPage;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.automation.utilities.Assertions.validate_text;


public class DirectorTest extends BaseTest{

@Test(priority=0,enabled = true,description = "Verify that Director is able to login with valid credentials or not")
public void login_Director() throws InterruptedException {
       String  directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
    String  directorEmailAddress = directorFirstName + "@yopmail.com";
    String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Zoi","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
       Assertions.validate_text(director.dashboardPage, "Dashboard");
       // panelPage.clickOn_AppointmentsTab();
        //Assertions.validate_text(director.viewAll, "View All");
        panelPage.clickOn_AvailabilityTab();
    //Assertions.validate_text(director.monthHeader, "December");
   // Assertions.validate_text(director.yearHeader, "2023");
   // Assertions.validate_text(director.dateHeader, "13");
       // director.director_Availability();
      //  Assertions.validate_text(director.clickOnBox, "");
      director.click_On_CancelButton();
      Assertions.validate_text(director.availableText, "Available");
    //director.clickOn_DeleteButton();
        //panelPage.click_LogOutLink();

        }

    @Test(priority=1,enabled = true,description = "Verify that Director is able to delete the available slot")
    public void deleteAvailableSlot() throws InterruptedException {
        String  directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("AU_Hulkx","12345678");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AvailabilityTab();
        WebdriverWaits.WaitUntilVisible(director.monthHeader);
        Assertions.validate_text(director.monthHeader, "December");
        Assertions.validate_text(director.yearHeader, "2023");
       //Assertions.validate_text(director.dateHeader, "13");
         director.click_On_DeleteButton();
         Assertions.validate_text(director.clickOnBox, "");
        panelPage.click_LogOutLink();

    }

    @Test(priority=2,enabled = true,description = "Verify that Director is able to click on cancel button")
    public void clickOnCancelButton() throws InterruptedException {
        String  directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("AU_Hulkx","12345678");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AvailabilityTab();
        Assertions.validate_text(director.monthHeader, "December");
        Assertions.validate_text(director.yearHeader, "2023");
       // Assertions.validate_text(director.dateHeader, "13");
        director.click_On_CancelButton();
        Assertions.validate_text(director.availableText, "Available");
        panelPage.click_LogOutLink();
    }

    @Test(priority=3,enabled = true,description = "Verify that Director is able to logout")
    public void clickOnLogoutButton() throws InterruptedException {
        String  directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("AU_Hulkx","12345678");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.click_LogOutLink();
        Assertions.validate_text(director.titleofSignInPage, "Sign in to your account");
    }
    @Test(priority=4,enabled = true,description = "Verify that Director is able to view upcoming appointments")
    public void viewUpcomingAppointments() throws InterruptedException {
        String  directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("AU_Hulkx","12345678");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");

        panelPage.clickOn_AppointmentsTab();
        director.click_OnUpcomingSubtab();
        Assertions.validate_text(director.titleofUpcomingPage, "Upcoming Appointments");
        panelPage.click_LogOutLink();
    }

    @Test(priority=5,enabled = true,description = "Verify that Director is able to view today's appointments")
    public void viewTodayAppointments() throws InterruptedException {
        String  directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("AU_Hulkx","12345678");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        director.click_OnTodaySubtab();
        Assertions.validate_text(director.titleofTodayPage, "Today's Appointments");
        panelPage.click_LogOutLink();
    }

    @Test(priority=6,enabled = true,description = "Verify that Director is able to click on filter button")
    public void clickOnFilterButton() throws InterruptedException {
        String  directorFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("AU_Hulkx","12345678");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        director.click_OnFilterBtn();
       // String value =getPlaceholder();l
        //Assertions.validate_text(value, "Type here to search");
        Assertions.validate_text(director.getTextFromDateField, "From Date");
        Assertions.validate_text(director.getTextToDateField, "To Date");
        panelPage.click_LogOutLink();
    }

    @Test(priority=7,enabled = true,description = "Verify that  relevant records appear after entering valid data in search textbox")
    public void validRecordAppearForUpcomingAppointments() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        director.valid_RecordsAppearForUpcoimnTab();
//        Thread.sleep(3000);
//        Assertions.validate_text(director.getTextFromDateField, director.expectedData);
//        panelPage.click_LogOutLink();
    }

    @Test(priority=8,enabled = true,description = "Verify that 'Test Plan' popup should appear after clicking 'Test Plan' button")
    public void editPopupAppear() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        director.click_OnEditTestPlan();
        Assertions.validate_text(director.getTextFromTestPlanEditPopup, "Please choose tests.");
        panelPage.click_LogOutLink();
    }
    @Test(priority=8,enabled = true,description = "Verify that 'Test Plan' popup should appear after clicking 'Test Plan' button")
    public void changeNotSaveOnClickCloseButton() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        Boolean finalresult = director.changesNotSaved_ClickOnCloseButton();
        Assert.assertTrue(finalresult);
        panelPage.click_LogOutLink();
    }
    @Test(priority=9,enabled = true,description = "Verify that CSV file gets downloaded after clicking on 'Export to CSV' button")
    public void csvFileGetsDownloaded() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        director.clickON_ExportCSVButton();
        String downloadFile =panelPage.getDownloadFileName();
        Assert.assertTrue(panelPage.isFileDownloaded(downloadFile));
        panelPage.click_LogOutLink();
    }

    @Test(priority=10,enabled = true,description = "Verify that CSV file gets downloaded after clicking on 'Export to CSV' button")
    public void otherCommentsSaved() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        director.clickON_ExportCSVButton();
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.click_LogOutLink();
    }

    @Test(priority=11,enabled = true,description = "Verify that  'Collect Payment' popup opens up after clicking 'Payment' button")
    public void collectPaymentPopupOpen() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        director.collectPayment();
        Assertions.validate_text(director.titleForCollectPaymentPopup, "Collect Payment");
        director.click_OnCancelBtn();
        panelPage.click_LogOutLink();
    }
    @Test(priority=12,enabled = true,description = "Verify that 'Test Fee Adjustment' field accepts negative amount and that negative amount gets added to 'Assessment Amount' and 'Amount Due' values")
    public void userEnter_NegativeValue_IntestAdjustmentFeeField() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        Boolean finalresult = director.userEnter_NegativeValue_IntestAdjustmentField();
        Assert.assertTrue(finalresult);
        panelPage.click_LogOutLink();
    }

    @Test(priority=13,enabled = true,description = "Verify that 'Test Fee Adjustment' field accepts positive amount and that positive amount gets added to 'Assessment Amount' and 'Amount Due' values")
    public void userEnters_PosititiveValue_IntestAdjustmentFeeField() throws InterruptedException {
        LoginPage login=new LoginPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        panelPage.clickOn_AppointmentsTab();
        Boolean finalresult = director.userEnter_PositiveValue_IntestAdjustmentField();
       Assert.assertTrue(finalresult);
        panelPage.click_LogOutLink();
    }

    @Test(priority=14,enabled = true,description = "Verify that 'Collect Amount Adjustment' field accepts negative amount and that positive amount gets added to 'Assessment Amount' and 'Amount Due' values")
    public void userEnter_NegativetivetiveValue_InCollectAdjustmentFeeField() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        Boolean finalresult = director.userEnter_NegativeValue_InCollectAdjustmentField();
        Assert.assertTrue(finalresult);
        panelPage.click_LogOutLink();
    }
    @Test(priority=15,enabled = true,description = "Verify that 'Collect Amount Adjustment' field accepts positive amount and that positive amount gets added to 'Assessment Amount' and 'Amount Due' values")
    public void userEnter_PositiveValue_InCollectAdjustmentFeeField() throws InterruptedException {
        String  directorFirstName = "AU" + "Beau" + RandomStrings.requiredCharacters(2);
        String directorLastName = "Ward" + RandomStrings.requiredCharacters(2);
        String  directorEmailAddress = directorFirstName + "@yopmail.com";
        String  directorUserName = "Riley" + RandomStrings.requiredCharacters(2);

        LoginPage login=new LoginPage();
        SuperAdminTest adminTest=new SuperAdminTest();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        DirectorPage director=new DirectorPage();
        login.directorLogin("Roman","123456");
        WebdriverWaits.WaitUntilVisible(director.dashboardPage);
        Assertions.validate_text(director.dashboardPage, "Dashboard");
        panelPage.clickOn_AppointmentsTab();
        Boolean finalresult = director.userEnter_PositiveValue_InCollectAdjustmentField();
        Assert.assertTrue(finalresult);
        panelPage.click_LogOutLink();
    }



}
