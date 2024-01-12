package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.WebdriverWaits;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.validate_text;


public class SuperAdminAppointmentTest extends BaseTest {

    //*********************Creating appointment page****************************
    @Test(priority = 23, enabled = true, description = "Verify that SuperAdmin is able to view appointments or not")
    public void Appointments_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        SuperAdminTest admintest=new SuperAdminTest();
        LoginPage login = new LoginPage();
        login.superAdminLogin();
        appointment.viewAllAppointmentsPage(admintest.diagnosticianFirstName, admintest.diagnosticianLastName);
    }

    @Test(priority = 24, enabled = true, description = "Verify that 'Appointment Details' page opens up on clicking 'View Detail' link")
    public void view_Details_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.View_DetailsPage();
        WebdriverWaits.WaitUntilVisible(appointment.App_Text);
        validate_text(appointment.App_Text, "Keymen Sloting Details");
        WebdriverWaits.WaitUntilVisible(appointment.viewStudentObservationButton);
        validate_text(appointment.viewStudentObservationButton, "View Student Observation");
        WebdriverWaits.WaitUntilVisible(appointment.viewDocumentsButton);
        validate_text(appointment.viewDocumentsButton, "View Documents");
    }

    @Test(priority = 25, enabled = true, description = "Verify that superAdmin is able to view ClientObservation Page or not")
    public void view_ClientObservation_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.view_ClientObservation_Page();
    }

    @Test(priority = 26, enabled = true, description = "Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'All Appointments' page")
    public void download_CSV_File() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        appointment.exportCSV_Button();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
    }

    //**********************SuperAdmin is viewing Payments page********************
    @Test(priority = 27, enabled = true, description = "Verify that superAdmin is able to view payment page or not")
    public void view_Payments_Page() throws InterruptedException {
        WebdriverWaits wait = new WebdriverWaits();
        PaymentPage payment = new PaymentPage();
        wait.Back_To_Page();
        payment.clickOn_PaymentTab();
        WebdriverWaits.WaitUntilVisible(payment.paymentListPage);
        validate_text(payment.paymentListPage, "Payments List");
    }

    @Test(priority = 28, enabled = true, description = "Verify that superAdmin is able to search perticular payment or not")
    public void search_Payment() throws InterruptedException {
        PaymentPage payment = new PaymentPage();
        payment.click_filterButton();
        payment.enterInSearchField("Guard");
        WebdriverWaits.WaitUntilVisible(payment.cust_Name);
        validate_text(payment.cust_Name, "Guard Bittle");
    }

    @Test(priority = 29, enabled = true, description = "Verify admin is able to download csv file or not")
    public void download_ExportCSV_File() throws InterruptedException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        WebdriverWaits wait = new WebdriverWaits();
        panelpage.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        wait.Back_To_Page();
        panelpage.click_LogOutLink();
    }



}