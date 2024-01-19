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
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;
import static test.AdminTest.*;


public class DiagnosticianTest extends BaseTest {




    @Test(priority = 0, enabled = true, description = "Login as a diagnostician and verify it is diagnostician dashboard page or not")
    public void diagnostician_Login() {
        LoginPage login = new LoginPage();

        login.diagnosticianLogin(diagnosticianUserName, "123456");
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        WebdriverWaits.waitUntilVisible(diagnostician.dashboard);
        validate_text(diagnostician.dashboard, "Dashboard");
    }

//    @Test(priority = 1, enabled = true, description = "diagnostician Scheduling availability")
//    public void diagnostician_Availability() throws InterruptedException {
//        DiagnosticianPage diagnostician = new DiagnosticianPage();
//        diagnostician.set_Availability();
//        diagnostician.cancel_Availability();
//        diagnostician.deleting_Availability();
//    }

    @Test(priority = 2, enabled = true, description = "Diagnostician is Verifying upcoming appointments")
    public void verify_UpcomingAppointments() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.clickOn_AppointmentTab();
        diagnostician.clickOn_upcomingTab();
        WebdriverWaits.waitUntilVisible(diagnostician.upcomingPageTitle);
        validate_text(diagnostician.upcomingPageTitle, "Upcoming Appointments");
    }

    @Test(priority = 3, enabled = true, description = "Verify diagnostian client details page")
    public void verify_ClientDetailsPage() {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        diagnostician.view_ClientDetail(clientLastName);
        WebdriverWaits.waitUntilVisible(diagnostician.clientDetailText);
        validate_text(diagnostician.clientDetailText, clientFirstName +' '+ clientLastName +' '+"Details");
    }

    @Test(priority = 4, enabled = true, description = "Diagnostician is verifying  that relevant records appear after selecting valid range of date, on 'Upcoming Appointments' page.")
    public void verify_FromAndTodate() throws InterruptedException {
        AppointmentsPage appPage = new AppointmentsPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.clickOn_upcomingTab();

        WebdriverWaits.waitForSpinner();
        // diagnostician.clickOn_upcomingTab();
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

    @Test(priority = 5, enabled = true, description = "Verify diagnostician is able to download csv file or not")
    public void download_CSV_File() throws InterruptedException, IOException, AWTException, CsvException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        ActionEngine action = new ActionEngine();
        action.navigate_Back();
        Thread.sleep(5000);
        WebdriverWaits.waitForSpinner();
        diagnostician.clickOn_upcomingTab();
        // diagnostician.clickOn_upcomingTab();
        appointment.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        // panelpage.readCSVFile();
    }

    @Test(priority = 6, enabled = true, description = "diagnostician is starting assessment")
    public void todays_Appointments() throws InterruptedException {
        ActionEngine action = new ActionEngine();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        action.navigate_Back();
        diagnostician.payment_NewPage();
        diagnostician.start_Assessment_ByPaying_LessAmount("I am doing Simple Testing");
        WebdriverWaits.waitUntilVisible(diagnostician.upcoming_App);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.upcoming_App,  "Upcoming Appointments");

    }

    @Test(priority = 7,enabled = true,description = "diagnostician is verifying completed assessments")
    public void verify_CompleteAssessment(){
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        diagnostician.verify_CompleteAss();
        diagnostician.click_filterButton();
        diagnostician.enter_ClientDetail(clientLastName);
        WebdriverWaits.waitUntilVisible(diagnostician.clientNameText);
        validate_text(diagnostician.clientNameText, clientFirstName +' '+ clientLastName +' '+ "Details");
        // panelPage.click_LogOutLink();
    }
    @Test(priority = 8, enabled = true, description = "Verify diagnostician is able to download csv file or not after completing the assessment")
    public void download_CSV_File_For_completeAss() throws InterruptedException, IOException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        ActionEngine action = new ActionEngine();
        diagnostician.verify_CompleteAss();
        diagnostician.search_CreatedDiagnostician(clientLastName);

        appointment.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        // panelpage.readCSVFile();
        action.navigate_Back();
        panelpage.click_LogOutLink();
    }
}

