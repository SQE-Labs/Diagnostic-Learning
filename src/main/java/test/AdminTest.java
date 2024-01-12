package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {


    @Test(priority = 1,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        AdminTest admin=new AdminTest();
        SuperAdminTest Superadmin = new SuperAdminTest();
        login.diagnosticianLogin(Superadmin.diagnosticianUserName,"12345678");
        schedule.checking_Availability();
        schedule.cancel_Availability();
        schedule.deleting_Availability();
    }
    @Test(priority = 2, enabled = true, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        //login.validLogin();
        Thread.sleep(5000);
        schedule.login_As_Diagnostician("addy","123456");
        Thread.sleep(5000);
        dashboard.clickScheduleAppointment();
        Thread.sleep(5000);
    }

    @Test(priority = 3, enabled = true, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginTest login = new LoginTest();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();

        // login.ValidLogin();
        schedule.createAppointment("Plano");
        schedule.appointmentDateSelecting(2);
    }

    @Test(priority = 4, enabled = true, description = "Filling client details")
    public void fillClientDetails() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        SuperAdminTest Superadmin = new SuperAdminTest();
        schedule.enteringClientDetails( Superadmin.diagnosticianFirstName, Superadmin.diagnosticianLastName, 2, "19-11-1997",2, "4567892658", Superadmin.diagnosticianEmailAddress, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422", "1200", "1000");
    }

    @Test(priority = 5, enabled = true, description = "filter and viewing created appointment in detail")
    public void filter_CreatedAppointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        SuperAdminTest Superadmin = new SuperAdminTest();
        schedule.search_ScheduledAppointment(Superadmin.diagnosticianFirstName);
    }

    @Test(priority = 6, enabled = true, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.creatingTestPlanForTheAppointment();
    }

}
