package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.validate_text;


public class SuperAdminTest extends BaseTest {

    public String diagnosticianUserName;
    public String diagnosticianFirstName;
    public String diagnosticianEmailAddress;
    public String directorFirstName;
    public String directorLastName;
    public String directorEmailAddress;
    public String directorUserName;


    LoginPage login = new LoginPage();

    @Test(priority = 0, enabled = true, description = "SuperAdmin is able to create Diagnostician")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnosticianFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        String diagnosticianLastName = "Ward" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "Riley" + RandomStrings.requiredCharacters(2);

        //Login by using superAdmin credentials
        login.superAdminLogin();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568", diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");
    }

    @Test(priority = 1, enabled = true, description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        WebdriverWaits.WaitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 2, enabled = true, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician() throws InterruptedException {
        String diagnosticianEmailAddress1 = diagnosticianFirstName + "12@yopmail.com";
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        //In Edit-Diagnostician password also changed
        diagnostician.edit_Diagnostician("2456789548", diagnosticianEmailAddress1, "12345678", "12345678");
        WebdriverWaits.WaitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
        panelPage.click_LogOutLink();
    }

    @Test(priority = 6, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        // Login with Diagnostician new password
        login.diagnosticianLogin(diagnosticianUserName, "12345678");
        WebdriverWaits.WaitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }

    @Test(priority = 7, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void diagnostician_login_With_OldPassword() throws InterruptedException {
        SuperAdminTest sat = new SuperAdminTest();
        Diagnostician diagnostician = new Diagnostician();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        // Logging with Old password to get validation message.
        login.diagnosticianLogin(diagnosticianUserName, "123456");
        WebdriverWaits.WaitUntilVisible(diagnostician.validation_Msg);
        validate_text(diagnostician.validation_Msg, "Username or password is incorrect");
    }

    @Test(priority = 3, enabled = true, description = "verify that toggle is off or not")
    public void checking_Toggle_Off() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        //checking user is disable or not
        diagnostician.cheking_DisableUser();
        WebdriverWaits.WaitUntilVisible(diagnostician.disableUser);
        validate_text(diagnostician.disableUser, "Enable User");
    }

    @Test(priority = 4, enabled = true, description = "Verify that Superadmin is able to diable the user or not")
    public void enable_User() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.enable_DiagnosticianUser();
        // Enabling the user
        WebdriverWaits.WaitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
    }

    @Test(priority = 5, enabled = false, description = "verify that diagnostician is able to edit or not after clicking Dont save button")
    public void verify_Dia_DontSaveBtn() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnostician.verify_DontSave("5659865589", diagnosticianEmailAddress, "123456", "123456");
        validate_text(diagnostician.UserNameGetText, diagnosticianUserName);
    }


    //DIRECTOR-----------------------------------------------------------------------------------

    @Test(priority = 8, enabled = false, description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        directorFirstName = "director_Beau" + RandomStrings.requiredCharacters(2);
        directorLastName = "director_Ward" + RandomStrings.requiredCharacters(2);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "director_Riley" + RandomStrings.requiredCharacters(2);
        DirectorPage director = new DirectorPage();
        LoginPage login = new LoginPage();
        login.superAdminLogin();//login

        director.create_Director(directorFirstName, directorLastName, "5236458965", directorEmailAddress, directorUserName, "123456", "123456");
        validate_text(director.directorListPage, "Directors List");
    }

    @Test(priority = 9, enabled = false, description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Director() throws InterruptedException {
        String directorEmailAddress1 = directorFirstName + "12@yopmail.com";
        DirectorPage director = new DirectorPage();
        //director changing the password.
        director.edit_Director( directorEmailAddress1, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }

    @Test(priority = 13, enabled = false, description = "Verify Diagnostician is able to login with new password or not")
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        //Director trying to login with new password
        login.directorLogin(directorUserName, "12345678");
        validate_text(director.directorDashBoardPage, "Dashboard");
    }

    @Test(priority = 14, enabled = false, description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        //Director trying to login with old password
        login.directorLogin(directorUserName, "123456");
        validate_text(director.validation_Msg, "Username or password is incorrect");
    }

    @Test(priority = 10, enabled = false, description = "verify that superadmin is able to check toggle button is enable or disable")
    public void director_checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        validate_text(director.enableUser, "Enable User");
    }

    @Test(priority = 11, enabled = false, description = "Verify that Superadmin is able to Enable the user or not")
    public void director_enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }

    @Test(priority = 12, enabled = false, description = "verify that diagnostician is able to edit or not after clicking dont save button")
    public void Verify_Dir_DntSaveBtn() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.not_Edit_Director("5659865589", directorEmailAddress, "123456", "123456");
        validate_text(director.UserNameGetText, directorUserName);
    }

    //*********************Creating appointment page****************************
    @Test(priority = 15, enabled = true, description = "Verify that SuperAdmin is able to created appointments or not")
    public void Appointments_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        LoginPage login = new LoginPage();
        login.superAdminLogin();
        appointment.allAppointmentsPage("Hazel Rogers", "04-12-2023", "04-12-2023");
    }

    @Test(priority = 16, enabled = true, description = "Verify that 'Appointment Details' page opens up on clicking 'View Detail' link")
    public void view_Details_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.View_DetailsPage();
        WebdriverWaits.WaitUntilVisible(appointment.App_Text);
        validate_text(appointment.App_Text, "Hazel Rogers Details");
    }

    @Test(priority = 17, enabled = true, description = "Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'All Appointments' page")
    public void download_CSV_File() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.exportCSV_Button();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = appointment.validateDownloadedFile();
        Assert.assertTrue(appointment.isFileDownloaded(downloadFile));
    }

}
