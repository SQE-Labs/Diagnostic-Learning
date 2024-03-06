package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.automation.base.BaseTest.getDriver;
import static org.automation.utilities.Assertions.validate_SelectedOption;
import static org.automation.utilities.Assertions.validate_text;
class UpcomingAppointment extends BaseTest {

    public  String diagnosticianUserName;
    public   String directorUserName;
    public  String clientLastName;
    public  String clientFirstName;

    String directorFirstName;

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
    @BeforeMethod()
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
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress,"Plano", diagnosticianUserName, "123456", "123456");
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
        login.diagnostician_Login();
        diagnostician.set_Availability();
        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
        panelPage.click_LogOutLink();

       //Set Availbility of Director
        login.directorLogin();
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
        clientCellNumber = RandomStrings.requiredDigits(10);
        clientEmail = clientFirstName + "@yopmail.com";
        clientEmail2 = clientFirstName + "101@yopmail.com";
        fillClientDetails.fill_clientDetailsSection(clientFirstName, clientLastName, 1, "19-11-2000", 1, clientCellNumber, clientEmail, "Other", "New York", "Texas", "30052", "1000", "900");
    }


        //use existing admin from config
        //schedule appt by admin
        //create test plan and folloup by admin

    @Test(priority = 0, enabled = true, description = "8. & 28. Verify that director is directed to 'Today's Appointments' page")
    public void verify_Upcoming_AppointmentPage_Diagnostician() throws InterruptedException, FileNotFoundException {
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AppointmentsPage appointment = new AppointmentsPage();
        AdminPage admin = new AdminPage();

        appointment.click_UpcomingCard();
        validate_text(appointment.upcomingAppointmentTXT, "Upcoming Appointments");
       /* appointment.click_Filter();
        String fromDateplaceholder = admin.getAttributevalue(appointment.fromDateText, "placeholder");
        String toDatePlaceholder = admin.getAttributevalue(appointment.toDateText, "placeholder");
        Assert.assertEquals(fromDateplaceholder, "From Date");
        Assert.assertEquals(toDatePlaceholder, "To Date");
*/
        appointment.click_ExportCSVButton();
        String downloadFile = panelPage.getDownloadFileName();
        Assert.assertTrue(panelPage.isFileDownloaded(downloadFile));
        getDriver().navigate().to("https://topuptalent.com/Diagnosticlearning/");
    }

}


