package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashboardPage;
import org.automation.pageObjects.Diagnostician;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.ScheduleAppointmentPage;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;
import java.util.Set;

import static test.SuperAdminTest.*;


public class ScheduleAppointmentTest extends BaseTest {



    @Test(priority=0,enabled=true,description = "Create Diagnosticians")
    public void create_Diagnosticians() throws InterruptedException {
        LoginPage login = new LoginPage();
        Diagnostician diagnostician = new Diagnostician();
      //  login.validLogin();
        diagnostician.create_Diagnostician(CustomerFirstName,CustomerLastName,"8564234568",EmailAddress,UserName,"123456","123456");
    }
    @Test(priority = 1,enabled = true,description = "diagnostician Scheduling availability")
    public void diagnostician_Availability() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.login_As_Diagnostician(UserName,"123456");
        schedule.checking_Availability();
        schedule.cancel_Availability();
        schedule.deleting_Availability();
    }
    @Test(priority = 2, enabled = true, description = "To verify schedule appointment")
    public void scheduleAppointment_Admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        login.validLogin();
        Thread.sleep(10000);
        dashboard.clickScheduleAppointment();
        Thread.sleep(5000);
    }

    @Test(priority = 3, enabled = true, description = "selecting date for appointment")
    public void appointmentCalender() throws InterruptedException {
        LoginTest login = new LoginTest();
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
          login.ValidLogin();
        schedule.scheduleAppointment("Plano");
        schedule.appointmentDateSelecting(2);
    }

    @Test(priority = 4, enabled = true, description = "Filling client details")
    public void fillClientDetails() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.enteringClientDetails(CustomerFirstName, CustomerLastName, 2, "19-11-1997",2, "4567892658", EmailAddress, "Math", "NSW", " Tasmania", " Barkers Creek", "South Australia", "5422", "1200", "1000");
    }

    @Test(priority = 5, enabled = false, description = "filter and viewing created appointment in detail")
    public void filter_CreatedAppointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.search_ScheduledAppointment(CustomerFirstName);
    }

    @Test(priority = 6, enabled = true, description = "creating TestPlan for the created appointment")
    public void testPlanFor_scheduled_Appointment() throws InterruptedException {
        ScheduleAppointmentPage schedule = new ScheduleAppointmentPage();
        schedule.creatingTestPlanForTheAppointment();
    }

}