package test;

import com.opencsv.exceptions.CsvException;
import org.automation.base.BaseTest;

import org.automation.pageObjects.*;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.WebdriverWaits;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import static org.automation.utilities.Assertions.validate_text;
import static test.AdminTest.*;
import static test.SuperAdminTest.diagnosticianUserName;

public class DiagnosticianTest extends BaseTest {


    @Test(priority = 0, enabled = true, description = "1, Login as a diagnostician and verify it is diagnostician dashboard page or not")
    public void verify_diagnostician_Login() {
        LoginPage login = new LoginPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();


        login.diagnostician_Login(diagnosticianUserName, "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.dashboard);
        validate_text(diagnostician.dashboard, "Dashboard");
    }
    @Test(priority = 1, enabled = true, description = "Set availability for diagnostician by admin")
    public void verify_DiagnosticianAvailability() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        diagnostician.set_Availability();
        // diagnostician.click_Availablity();
        diagnostician.cancel_Availability();
        diagnostician.deleting_Availability();
        panelpage.click_LogOutLink();
    }

    @Test(dependsOnMethods = {"verify_UpcomingTab"}, description = "31 Diagnostician is Verifying upcoming appointments")
    public void verify_UpcomingAppointments() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.click_AppointmentTab();
        diagnostician.click_upcomingTab();
        WebdriverWaits.waitUntilVisible(diagnostician.upcomingPageTitle);
        validate_text(diagnostician.upcomingPageTitle, "Upcoming Appointments");
    }

    @Test(dependsOnMethods = {"verify_UpcomingAppointments"} , description = "32 Verify diagnostian client details page")
    public void verify_ClientDetailsPage() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        diagnostician.click_ClientDetailLink(clientFirstName);
        WebdriverWaits.waitUntilVisible(diagnostician.clientDetailText);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.clientDetailText, clientFirstName + ' ' + clientLastName + ' ' + "Details");
    }

    @Test(dependsOnMethods = {"verify_ClientDetailsPage"}, description = "  44 Diagnostician is verifying  that relevant records appear after selecting valid range of date, on 'Upcoming Appointments' page.")
    public void verify_From_And_Todate() {
        AppointmentsPage appPage = new AppointmentsPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.click_upcomingTab();

        WebdriverWaits.waitForSpinner();
        diagnostician.click_filterButton();
        ActionEngine engine;
        engine = new ActionEngine();
        String toDate = DateGenerator.getCurrentDate();
        String FromDate = DateGenerator.getDateWithDays("dd-MM-yyyy", -2);
        appPage.enter_Dates(FromDate, toDate);
        WebdriverWaits.waitUntilVisible(appPage.dateElements);
        List<WebElement> my_list = engine.getWebElements(appPage.dateElements);
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

    @Test(dependsOnMethods = {"verify_From_And_Todate"}, description = "31, 32 ,44, 46 Verify diagnostician is able to download csv file or not")
    public void verify_download_CSV_File() throws InterruptedException, IOException, AWTException, CsvException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        ActionEngine action = new ActionEngine();
        action.navigate_Back();
        Thread.sleep(3000);
        WebdriverWaits.waitForSpinner();
        diagnostician.click_upcomingTab();
        appointment.click_ExportCSVButton();
        Thread.sleep(3000);
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
    }

    @Test(dependsOnMethods = {"verify_download_CSV_File"}, description = "26, 27, 28, 12, 13, 14, 16, 17, 18  diagnostician is starting assessment")
    public void verify_todays_Appointments() throws InterruptedException {
        ActionEngine action = new ActionEngine();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        action.navigate_Back();
        diagnostician.payment_NewPage();
        diagnostician.start_Assessment_ByPaying_LessAmount("I am doing Simple Testing");
        WebdriverWaits.waitUntilVisible(diagnostician.upcoming_App);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.upcoming_App, "Upcoming Appointments");
    }

    @Test(dependsOnMethods = {"verify_todays_Appointments"}, description = "73,74,86 diagnostician is verifying completed assessments")
    public void verify_Completed_Assessment() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        diagnostician.verify_CompleteAss();
        diagnostician.click_filterButton();
        diagnostician.enter_ClientDetail(clientFirstName);
        WebdriverWaits.waitUntilVisible(diagnostician.clientText);
        validate_text(diagnostician.clientText, clientFirstName + ' ' + clientLastName + ' ' + "Details");
    }

    @Test(dependsOnMethods = {"verify_Completed_Assessment"}, description = "24, 86, 88 Verify diagnostician is able to download csv file or not after completing the assessment")
    public void verify_completeAss() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.verify_CompleteAss();
        diagnostician.search_CreatedDiagnostician(clientFirstName);
        WebdriverWaits.waitUntilVisible(diagnostician.clientNameText);
        validate_text(diagnostician.clientNameText, clientFirstName + ' ' + clientLastName);
    }

    @Test(dependsOnMethods = {"verify_completeAss"}, description = "89, 90  Verify diagnostician is able to download csv file or not after completing the assessment")
    public void verify_Cancelled_Appointments() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        diagnostician.click_CancelTab();
        diagnostician.enter_InSearchField(clientLastName);
        WebdriverWaits.waitUntilVisible(diagnostician.clientNameText);
        validate_text(diagnostician.clientNameText, clientFirstName + ' ' + clientLastName);
        panelpage.click_LogOutLink();
    }
}

