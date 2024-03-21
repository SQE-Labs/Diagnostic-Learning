package test;

import com.opencsv.exceptions.CsvException;
import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;
import static test.AdminTest.*;

public class DiagnosticianTest extends BaseTest {


    @Test(priority = 0, enabled = true, description = "1, Login as a diagnostician and verify it is diagnostician dashboard page or not")
    public void verify_diagnostician_Login() {
        LoginPage login = new LoginPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        String diagnosticianUserName = PropertiesUtil.getPropertyValue("diagnostician_userName");
        String diagnosticianPassword = PropertiesUtil.getPropertyValue("diagnostician_oldpassword");
        login.diagnostician_LoginWithOldPassword(diagnosticianUserName, diagnosticianPassword);
        WebdriverWaits.waitUntilVisible(diagnostician.dashboard);
        validate_text(diagnostician.dashboard, "Dashboard");
    }


    @Test(priority = 2, enabled = true, description = "31 Diagnostician is Verifying upcoming appointments")
    public void verify_UpcomingAppointments() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        LoginPage login = new LoginPage();

        //   login.directorLogin(diagnosticianUserName, "12345678");
        diagnostician.click_AppointmentTab();
        diagnostician.click_upcomingTab();
        WebdriverWaits.waitUntilVisible(diagnostician.upcomingPageTitle);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.upcomingPageTitle, "Upcoming Appointments");
    }

    @Test(priority = 3, enabled = true, description = "32 Verify diagnostian client details page")
    public void verify_ClientDetailsPage() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        diagnostician.click_ClientDetailLink();
        WebdriverWaits.waitUntilVisible(diagnostician.clientText);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.clientText, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + ' ' + " Details");
    }

    @Test(priority = 4, enabled = true, description = "  44/70 Diagnostician is verifying  that relevant records appear after selecting valid range of date, on 'Upcoming Appointments' page.")
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

    @Test(priority = 5, enabled = true, description = "31, 32 ,44, 46/72 Verify diagnostician is able to download csv file or not")
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

    @Test(priority = 6, enabled = true, description = "7/31, 8/32, 9/33, 13/37, 13/39, 17/43, 18/44, 22/48, 26/52, 28/54 diagnostician is starting assessment")
    public void verify_todays_Appointments() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.navigate_Back();
        diagnostician.payment_NewPage();
        diagnostician.start_Assessment_ByPaying_LessAmount("I am doing Simple Testing");
        WebdriverWaits.waitUntilVisible(diagnostician.upcoming_App);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.upcoming_App, "Upcoming Appointments");
    }

    @Test(priority = 7, enabled = true, description = "73/75,74/76,86,28 diagnostician is verifying completed assessments")
    public void verify_Completed_Assessment() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        diagnostician.verify_CompleteAss();
        diagnostician.click_filterButton();
        diagnostician.enter_SearchField(PropertiesUtil.getPropertyValue("clientFirstName"));
        WebdriverWaits.waitUntilVisible(diagnostician.clientText);
        diagnostician.click_ClientDetailLink();
        validate_text(diagnostician.clientText, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName") + ' ' + "Details");
    }

    @Test(priority = 8, enabled = true, description = "24, 89/91, 88/90 Verify diagnostician is able to download csv file or not after completing the assessment")
    public void verify_completeAss() throws InterruptedException, FileNotFoundException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        diagnostician.verify_CompleteAss();
        diagnostician.enter_SearchField(PropertiesUtil.getPropertyValue("clientFirstName"));
        WebdriverWaits.waitUntilVisible(diagnostician.clientNameText);
        validate_text(diagnostician.clientNameText, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName"));
        appointment.click_ExportCSVButton();
        Thread.sleep(3000);
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
    }

    @Test(priority = 9, enabled = true, description = "89/91, 90/92  Verify diagnostician is able to download csv file or not after completing the assessment")
    public void verify_Cancelled_Appointments() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelpage.navigate_Back();
        diagnostician.click_CancelTab();
        diagnostician.enter_InSearchField(PropertiesUtil.getPropertyValue("clientLastName"));
        WebdriverWaits.waitUntilVisible(diagnostician.clientNameText);
        validate_text(diagnostician.clientNameText, PropertiesUtil.getPropertyValue("clientFirstName") + ' ' + PropertiesUtil.getPropertyValue("clientLastName"));
        panelpage.click_LogOutLink();
    }
}

