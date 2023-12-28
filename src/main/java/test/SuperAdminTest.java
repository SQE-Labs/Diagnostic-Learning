package test;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

import static org.automation.utilities.Assertions.*;


public class SuperAdminTest extends BaseTest {


    //***********Admin Variables**********
    public String adminUserName;
    public String adminFirstName;
    public String adminEmailAddress;
    public String adminLastName;
    public String admin_cell_Number;
    //***********Diagnostician Variables*****
    public String diagnosticianUserName;
    public String diagnosticianFirstName;
    public String diagnosticianEmailAddress;
    public String diagnosticianLastName;
    public String dia_Cell_Number;



    @Test(priority = -2, enabled = true, description = "1.1 Verify that SuperAdmin is able to login")
    public void superadmin_login()  {

        LoginPage login = new LoginPage();
        //Login by using superAdmin credentials
        login.superAdminLogin();
    }
    @Test(priority = -1, enabled = false, description = "5.1 Verify that SuperAdmin is able to create Admin or not")
    public void verify_Dashboard_adminList()   {

        AdminPage admin = new AdminPage();
        WebdriverWaits.waitForSpinner();

        WebdriverWaits.waitUntilVisible(admin.dashboardPage);
        validate_text(admin.dashboardPage, "Dashboard");
        WebdriverWaits.waitForSpinner();

    }


    @Test(priority = 0, enabled = true, description = "5.5, Verify that SuperAdmin is able to create Admin or not")
    public void create_Admin() throws InterruptedException {

        AdminPage admin = new AdminPage();
        adminFirstName = "AU_Alexis" + RandomStrings.requiredCharacters(2);
        adminLastName = "AU_Magrath" + RandomStrings.requiredCharacters(2);
        adminEmailAddress = adminFirstName + "@yopmail.com";
        adminUserName = "AU_Paige" + RandomStrings.requiredCharacters(2);
        admin_cell_Number = RandomStrings.requiredDigits(10);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        WebdriverWaits.waitForSpinner();
        panelPage.click_On_AdminTab();
        WebdriverWaits.waitForSpinner();

        admin.create_Admin(adminFirstName, adminLastName, admin_cell_Number, adminEmailAddress, adminUserName, "123456", "123456");
      WebdriverWaits.waitUntilVisible(admin.succ_Msg);
        validate_text(admin.succ_Msg, "Admin Created Successfully");
      //  PropertiesUtil.setPropertyValue("useradmin",adminUserName);
    }

    @Test(priority = 1, enabled = true, description = "SuperAdmin is able to search created admin or not")
    public void search_Created_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.clickOn_BackButton();
        admin.search_CreatedAdmin(adminUserName);
        WebdriverWaits.waitUntilVisible(admin.actualText);
        validate_text(admin.actualText, adminUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 2, enabled = true, description = "5.6, 5.7 Super admin is able to edit the created admin or not")
    public void edit_Admin() throws InterruptedException {
        String adminEmailAddress1 = adminFirstName + "12@yopmail.com";
        AdminPage admin = new AdminPage();
        //In Edit-Diagnostician password also changed
        admin.edit_Admin(adminEmailAddress1, "12345678", "12345678");
        validate_text(admin.Succ_Msg_Upd, "Successfully Edited the created Admin");
    }

    @Test(priority = 3, enabled = true, description = "5.9 verify that toggle is off or not")
    public void checking_Toggle_OffIn_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        //checking user is disable or not
        admin.cheking_DisableUser();
        WebdriverWaits.waitUntilVisible(admin.enableUser);
        validate_text(admin.enableUser, "Enable User");
    }

    @Test(priority = 4, enabled = true, description = "Verify that Superadmin is able to enable the user or not")
    public void enable_User_In_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        admin.enable_Admin();
        // Enabling the user
        validate_text(admin.Succ_Msg_Upd, "Admin details updated successfully.");

    }

    @Test(priority = 5, enabled = true, description = "6 Verify Admin is able to login with new password or not")
    public void admin_Relogin()   {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_LogOutLink();
        LoginPage login = new LoginPage();
        // Login with Admin new password
        login.adminLogin(adminUserName, "12345678");
        WebdriverWaits.waitUntilVisible(admin.dashboard);
        validate_text(admin.dashboard, "Dashboard");
        panelPage.click_LogOutLink();
    }

    @Test(priority = 6, enabled = true, description = "5.8 verify that superadmin is able to edit or not after clicking Dont save button")
    public void verify_Adm_DontSaveBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();

        LoginPage login = new LoginPage();
        // Login with Admin new password
        login.superAdminLogin();
        panelPage.click_On_AdminTab();
        admin.verify_DontSave(adminEmailAddress, "123456", "123456");
        WebdriverWaits.waitUntilVisible(admin.userNameText);
        validate_text(admin.userNameText, adminUserName);
    }

    @Test(priority = 7, enabled = true, description = "6.2 Verify that superadmin is not  able create admin with duplicate username or not")
    public void verify_Duplicate_UserName() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        admin.create_Admin(adminFirstName, adminLastName, admin_cell_Number, adminEmailAddress, adminUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(admin.Error_Msg);
        validate_text(admin.Error_Msg, "An error occurred while creating the admin. Username already exists!");
        panelPage.click_LogOutLink();
    }

    //Testcase for Diagnostician ********************************************
    @Test(priority = 8, enabled = true, description = "4.1, 4.17 SuperAdmin is able to create Diagnostician")
    public void create_Diagnostician_By_SuperAdmin()   {
        //Login by using superAdmin credentials
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnosticianFirstName = "AU_Ariana" + RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "AU_Morris" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "AU_Zahra" + RandomStrings.requiredCharacters(2);
        dia_Cell_Number = RandomStrings.requiredDigits(10);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        //Login by using superAdmin credentials
        //navigating  to base url
        String url = PropertiesUtil.getPropertyValue("url");
        getDriver().navigate().to(url);
        login.superAdminLogin();
        panelPage.click_DiagnosticianTab();
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");


       //creating duplicate name diagnostistician

        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568", diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.validationMsg);
        validate_text(diagnostician.validationMsg, "An error occurred while creating the user. Username already exists!");

    }

    @Test(priority = 9, enabled = true, description = "4.2, 4.3, 4.5 SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician_In_SuperAdmin()   {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.clickOn_BackButton();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 10, enabled = true, description = "4.6, 4.11 Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician_By_SuperAdmin()   {
        String diagnosticianEmailAddress1 = diagnosticianFirstName + "12@yopmail.com";
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        //In Edit-Diagnostician password also changed
        diagnostician.edit_Diagnostician(diagnosticianEmailAddress1, "12345678", "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
    }

    @Test(priority = 11, enabled = true, description = "4.13 verify that toggle is off or not for diagnostician by superadmin")
    public void verifying_Toggle_Off_diag_By_SuperAdmin()   {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //checking user is disable or not
        diagnostician.cheking_DisableUser();
        WebdriverWaits.waitUntilVisible(diagnostician.enableUser);
        validate_text(diagnostician.enableUser, "Enable User");
    }

    @Test(priority = 12, enabled = true, description = "Verify that Superadmin is able to disable the user or not")
    public void enable_ToggleOfDia_By_SuperAdmin()   {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        diagnostician.enable_DiagnosticianUser();
        // Enabling the user
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
        // panelPage.click_LogOutLink();
    }

    @Test(priority = 13, enabled = true, description = "4.14 verify that superAdmin is able to edit or not after clicking Dont save button")
    public void verify_Dia_DontSaveBtn()   {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.verify_DontSave("5659865589", diagnosticianEmailAddress, "123456", "123456");
        validate_text(diagnostician.UserNameGetText, diagnosticianUserName);
    }

    @Test(priority = 14, enabled = true, description = "4.15 Verify diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        panelPage.click_LogOutLink();
        // Login with Diagnostician new password
        login.diagnosticianLogin(diagnosticianUserName, "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }



    @Test(priority = 16, enabled = true, description = "4.16 Verify that diagnostician is able to login with old password or not")
    public void verify_Dia_IsAbleToLoginWithOldPassword_InSuperAdmin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        LoginPage login = new LoginPage();
        //  panelPage.click_LogOutLink();
        // Logging with Old password to get validation message.
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelpage.click_LogOutLink();
        login.diagnosticianLogin(diagnosticianUserName, "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.validation_Msg);
        validate_text(diagnostician.validation_Msg, "Username or password is incorrect");
    }




    //TC for DIRECTOR-----------------------------------------------------------------------------------
    public String directorLastName;
    public String dir_Cell_Number;
    public String directorFirstName;
    public String directorEmailAddress;
    public String directorUserName;

    @Test(priority = 21, enabled = true, description = "3.1, 3.5, 3.9, 3.36 verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        directorFirstName = "AU_Daisy" + RandomStrings.requiredCharacters(2);
        directorLastName = "AU_Baker" + RandomStrings.requiredCharacters(2);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Beck" + RandomStrings.requiredCharacters(3);
        dir_Cell_Number = RandomStrings.requiredDigits(10);
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        //Login with super Admin credentials
        login.superAdminLogin();//login
        panelPage.click_DirectorTab();
        director.create_Director(directorFirstName, directorLastName, dir_Cell_Number, directorEmailAddress, directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.directorListPage);
        validate_text(director.directorListPage, "Directors List");


    }

    @Test(priority = 22, enabled = true, description = "3.1, 3.5, 3.9, 3.36 verify that duplicate Directorthrows error")
    public void create_duplicate_Directors() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();

        director.Verify_Duplicate_Director(directorFirstName, directorLastName, dir_Cell_Number, directorEmailAddress, directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.validationMsg);
        validate_text(director.validationMsg, "An error occurred while creating the user. Username already exists!");
        panelPage.clickOn_BackButton();
    }
    @Test(priority = 23, enabled = true, description = "3.2, 3.3, 3.15, 3.17 Super admin is able to edit the created diagnostician or not")
    public void edit_Director() throws InterruptedException {
        String directorEmailAddress1 = directorFirstName + "12@yopmail.com";
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        //director changing the password.
        director.edit_Director(directorEmailAddress1, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }

    @Test(priority = 24, enabled = true, description = "3.19, 3.20 verify that superadmin is able to check toggle button is enable or disable")
    public void director_checking_Toggle_Off()   {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        WebdriverWaits.waitUntilVisible(director.enableUser);
        validate_text(director.enableUser, "Enable User");
    }

    @Test(priority = 25, enabled = true, description = "Verify that Superadmin is able to Enable the user or not")
    public void director_enable_User()   {
        DirectorPage director = new DirectorPage();

        director.enable_Director();
        WebdriverWaits.waitUntilVisible(director.edit_SuccMsg);
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");

    }


    @Test(priority = 26, enabled = true, description = "verify that superadmin is able to edit or not after clicking dont save button")
    public void verify_Dir_DntSaveBtn() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.not_Edit_Director(directorEmailAddress, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);
        director.click_LogOutLink();
    }


    @Test(priority = 28, enabled = true, description = "Verify that director is able to login with old password or not")
    public void login_With_OldPassword()   {
        DirectorPage director = new DirectorPage();
        LoginPage login = new LoginPage();
        //Director trying to login with old password
        login.directorLogin(directorUserName, "123456");
        WebdriverWaits.waitUntilVisible(director.validation_Msg);
        validate_text(director.validation_Msg, "Username or password is incorrect");
    }

    @Test(priority = 29, enabled = true, description = "3.34 Verify director is able to login with new password or not")
    public void director_Relogin_By_SuperAdmin()     {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        //Director trying to login with new password
        login.directorLogin(directorUserName, "12345678");
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
        panelPage.click_LogOutLink();
    }

    //************Appointments page******************

    @Test(priority = 30, enabled = true, description = "2.1 Verify that SuperAdmin is able to view appointments or not")
    public void Appointments_Page()   {
        AppointmentsPage appointment = new AppointmentsPage();
        LoginPage login = new LoginPage();
        login.adminLogin(adminUserName, "12345678");
        appointment.view_allAppointmentsPage(diagnosticianFirstName, diagnosticianLastName);
    }


    //*************This testcase also has defect*********************
    @Test(priority = 31, enabled = true, description = "2.5, 2.7 Verify that 'Appointment Details' page opens up on clicking 'View Detail' link")
    public void view_Details_Page()   {
        AppointmentsPage appointment = new AppointmentsPage();
        appointment.clickOn_ViewDetails();
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(appointment.App_Text);
        validate_text(appointment.App_Text, diagnosticianFirstName +' '+diagnosticianLastName+' '+"Details");
        appointment.click_ViewAllTab();

//        WebdriverWaits.WaitUntilVisible(appointment.viewStudentObservationButton);
//        validate_text(appointment.viewStudentObservationButton, "View Student Observation");
//        WebdriverWaits.WaitUntilVisible(appointment.viewDocumentsButton);
//        validate_text(appointment.viewDocumentsButton, "View Documents");
    }

    //********After completion of complete appointment this test case will be valid********************

//To-do
    @Test(priority = 32, enabled = false, description = "Verify that superAdmin is able to view ClientObservation Page or not")
    public void view_ClientObservation_Page()  {
        AppointmentsPage appointment = new AppointmentsPage();
        // appointment.view_ClientObservation_Page();
    }

    @Test(priority = 33, enabled = true, description = "2.6 Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'All Appointments' page")
    public void download_CSV_File() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        WebdriverWaits.waitForSpinner();
        appointment.exportCSV_Button();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
    }

    //**********************SuperAdmin is viewing Payments page********************
    @Test(priority = 34, enabled = true, description = "6.1, Verify that superAdmin is able to view payment page or not")
    public void view_Payments_Page()  {
        PaymentPage payment = new PaymentPage();
        ActionEngine action = new ActionEngine();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        action.navigate_Back();
        panelpage.click_LogOutLink();

        login.superAdminLogin();
        payment.clickOn_PaymentTab();
        WebdriverWaits.waitUntilVisible(payment.paymentListPage);
        validate_text(payment.paymentListPage, "Payments");
    }

    @Test(priority = 35, enabled = true, description = "6.2, 6.3,  Verify that superAdmin is able to search perticular payment or not")
    public void search_Payment()   {
        PaymentPage payment = new PaymentPage();
        payment.click_filterButton();
        payment.enterInSearchField(diagnosticianFirstName);
        WebdriverWaits.waitUntilVisible(payment.cust_Name);
        validate_text(payment.cust_Name, diagnosticianFirstName +' '+diagnosticianLastName);
    }

    @Test(priority = 36, enabled = true, description = "6.5 Verify admin is able to download csv file or not")
    public void download_ExportCSV_File() throws InterruptedException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        ActionEngine action = new ActionEngine();
        panelpage.clickOn_ExportCSVButton();
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        action.navigate_Back();
        panelpage.click_LogOutLink();
    }

    @Test(priority = 37, enabled = true, description = "SuperAdmin is able to disable the diagnostician")
    public void disablediagnostician() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.superAdminLogin();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_DiagnosticianTab();
        diagnostician.disable_Diagnostician(diagnosticianUserName);
        diagnostician.click_UpdateButton();
    }
    //logout superadmin
    @Test(priority = 38, enabled = true, description = "34 Verify that SuperAdmin is able to login")
    public void superadmin_logout()   {
        AppointmentsPage page = new AppointmentsPage();
        page.click_LogOutLink();
    }
}



