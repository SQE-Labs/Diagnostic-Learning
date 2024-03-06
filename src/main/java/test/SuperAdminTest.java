package test;


import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import static org.automation.utilities.Assertions.*;
import static test.AdminTest.clientFirstName;
import static test.AdminTest.clientLastName;


public class SuperAdminTest extends BaseTest {


    //***********Admin Variables**********
    public static String adminUserName;
    public String adminFirstName;
    public String adminEmailAddress;
    public String adminLastName;
    public String admin_cell_Number;

    //***********Diagnostician Variables*****
    public  String diagnosticianUserName;
    public String diagnosticianFirstName;
    public String diagnosticianEmailAddress;
    public String diagnosticianLastName;
    public String dia_Cell_Number;


    @Test(priority = 0, enabled = true, description = "1.1 Verify that super superadmin is able to login into account using valid 'Username' & 'Password', on 'Sign in to your account' page.")
    public void verify_Superadmin_login() {
        LoginPage login = new LoginPage();
        //Login by using superAdmin credentials
        login.superAdminLogin();
    }

    @Test(priority = 1, enabled = true, description = "5.1 Verify that SuperAdmin is able to View AdminList page or not")
    public void verify_Dashboard_adminList() {
        AdminPage admin = new AdminPage();
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(admin.dashboardPage);
        validate_text(admin.dashboardPage, "Dashboard");
    }


    @Test(priority = 2, enabled = true, description = "5.5, Verify that SuperAdmin is able to create Admin or not")
    public void verify_Create_Admin() throws InterruptedException, IOException {
        AdminPage admin = new AdminPage();
        adminFirstName = "AU_Zoe" + RandomStrings.requiredCharacters(3);
        adminLastName = "AU_Gray" + RandomStrings.requiredCharacters(3);
        adminEmailAddress = adminFirstName + "@yopmail.com";
        adminUserName = "AU_Ryder" + RandomStrings.requiredCharacters(3);
        admin_cell_Number = RandomStrings.requiredDigits(10);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        WebdriverWaits.waitForSpinner();
        panelPage.click_AdminTab();
        WebdriverWaits.waitForSpinner();

        //*************Creating admin by superAdmin************

        admin.create_Admin(adminFirstName, adminLastName, admin_cell_Number, adminEmailAddress, adminUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(admin.succ_Msg);
        validate_text(admin.succ_Msg, "Admin Created Successfully");
        //   Thread.sleep(5000);
        //   PropertiesUtil.setPropertyValue("admin_userName", adminUserName);
    }

    @Test(priority = 3, enabled = true, description = "SuperAdmin is able to search created admin or not")
    public void validate_Search_Created_Admin() {
        AdminPage admin = new AdminPage();

        admin.search_CreatedAdmin(adminUserName);
        WebdriverWaits.waitUntilVisible(admin.actualText);
        String adminName = getText_custom(admin.actualText);
        validate_text(admin.actualText, adminName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 4, enabled = true, description = "5.6, 5.7 Super admin is able to edit the created admin or not -Bug raised")
    public void verify_Edit_Admin() throws InterruptedException {
        String adminEmailAddress1 = adminFirstName + "12@yopmail.com";
        AdminPage admin = new AdminPage();

        //In Edit-Diagnostician password also changed
        admin.edit_Admin(adminEmailAddress1, "12345678", "12345678");

        //  Verify that user is able to edit details of already created admin, on 'Edit User' popup, on 'Admins List' page.
        String succ_Msg = getText_custom(admin.Succ_Msg_Upd);
        validate_text(admin.Succ_Msg_Upd, succ_Msg);
    }

    @Test(priority = 5, enabled = true, description = "5.9 verify that toggle is off or not")
    public void validate_Toggle_OffIn_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();

        //checking user is disable or not
        admin.search_CreatedAdmin(adminUserName);
        admin.cheking_DisableUser();
    }

    @Test(priority = 6, enabled = true, description = "Verify that Superadmin is able to enable the Admin or not")
    public void verify_Enable_User_In_Admin() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        admin.enable_Admin();

        // Enabling the user
        validate_text(admin.Succ_Msg_Upd, "Admin details updated successfully.");


    }

    @Test(priority = 7, enabled = true, description = "5.10 Verify Admin is able to login with new password or not")
    public void verify_admin_Relogin() {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        panelPage.click_LogOutLink();


        // Login with Admin new password
        login.admin_Login();

        WebdriverWaits.waitUntilVisible(admin.dashboard);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.dashboard, "Dashboard");

        panelPage.click_LogOutLink();
    }

    @Test(priority = 8, enabled = true, description = "5.8 verify that superadmin is able to edit or not after clicking Dont save button")
    public void verify_Adm_DontSaveBtn() throws InterruptedException {
        AdminPage admin = new AdminPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();

        LoginPage login = new LoginPage();
        // Login with Admin new password
        login.superAdminLogin();
        panelPage.click_AdminTab();
        admin.search_CreatedAdmin(adminUserName);
        admin.verify_DontSave(adminEmailAddress, "123456", "123456");
        WebdriverWaits.waitUntilVisible(admin.userNameText);
        validate_text(admin.userNameText, adminUserName);
    }

    @Test(priority = 9, enabled = true, description = "5.12 Verify that superadmin is not  able create admin with duplicate username or not")
    public void verify_Duplicate_UserName() throws InterruptedException {
        AdminPage admin = new AdminPage();

       // Verify that validation message appears after clicking on 'Create Admin' button, when user enter same username in 'username' field, on 'Create Admin ' page.
        admin.create_Admin(adminFirstName, adminLastName, admin_cell_Number, adminEmailAddress, adminUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(admin.Error_Msg);
        validate_text(admin.Error_Msg, "An error occurred while creating the admin. Username already exists!");
    }

    //Testcase for Diagnostician ********************************************
    @Test(priority = 10, enabled = true, description = "4.1 SuperAdmin is able to create Diagnostician")
    public void verify_Create_Diagnostician_By_SuperAdmin() throws InterruptedException {
        //Login by using superAdmin credentials
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnosticianFirstName = "AU_Sarah" + RandomStrings.requiredCharacters(3);
        diagnosticianLastName = "AU_Hill" + RandomStrings.requiredCharacters(3);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "AU_Ward" + RandomStrings.requiredCharacters(3);
        dia_Cell_Number = RandomStrings.requiredDigits(10);
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        //navigating  to base url

        //Verify that superadmin is directed to 'Diagnosticians List' page after clicking on 'Diagnosticians' tab, on 'Dashboard' page.
        panelPage.click_DiagnosticianTab();
        WebdriverWaits.waitUntilVisible(diagnostician.diagnosticListText);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.diagnosticListText, "Diagnosticians List");


        //**************SuperAdmin is creating diagnostician*************


        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, dia_Cell_Number, diagnosticianEmailAddress, "Austin",diagnosticianUserName, "123456", "123456");
        diagnostician.enter_InSearchField(diagnosticianUserName);
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Successfully SuperAdmin Created diagnostician");
        // panelPage.click_LogOutLink();
    }

    @Test(priority = 11, enabled = true, description = " 4.17 Verify that validtion message appears after clicking on 'Create Diagnostician' button, when user enter same username in 'username' field, on 'Create Diagnostician' page.")
    public void create_Duplicate_Diagnostician_By_SuperAdmin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //creating duplicate name diagnostistician

        //Verify that validtion message appears after clicking on 'Create Diagnostician' button, when user enter same username in 'username' field, on 'Create Diagnostician' page.
        diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568", diagnosticianEmailAddress, "Austin",diagnosticianUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(diagnostician.validationMsg);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.validationMsg, "An error occurred while creating the user. Username already exists!");
    }


    //*******************Functionality has been changed*********************
    @Test(priority = 12, enabled = true, description = "4.2, 4.3, 4.5 SuperAdmin is able to search created diagnostician or not")
    public void validate_Created_Diagnostician_In_SuperAdmin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        AdminPage admin = new AdminPage();
        Thread.sleep(4000);
        panelPage.click_BackButton();

        // Verify that search text box appears after clicking 'Filter' button on 'Diagnosticians List' page.
        //admin.click_filterButton();

        // Verify that relevant records appears after entering valid data in search textbox, on 'Diagnosticians List' page
        diagnostician.enter_InSearchField(diagnosticianUserName);

        //Verify that newly created Diagnostician appears on top of  'Diagnosticians List' page.
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        validate_text(diagnostician.actualText, diagnosticianUserName);
        Log.info("Created Diagnostician Displayed In The Diagnostician ListPage");
    }

    @Test(priority = 13, enabled = true, description = "4.6, 4.11 Super admin is able to edit the created diagnostician or not")
    public void verify_edit_Diagnostician_By_SuperAdmin() throws InterruptedException {
        String diagnosticianEmailAddress1 = diagnosticianFirstName + "12@yopmail.com";
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        //In Edit-Diagnostician password also changed

        // Verify that  'Edit User' pop up appears after clicking 'Edit' button of any director, on 'Diagnosticians List' page
        //Verify that 'Cell Number' field accepts ten digit number in defined format on 'Edit User' pop up, of 'Diagnosticians List' page
        diagnostician.edit_Diagnostician(diagnosticianEmailAddress1, "12345678", "12345678");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
        Log.info("Successfully Edited the created diagnostician");
    }

    @Test(priority = 14, enabled = true, description = "4.13 verify that toggle is off or not for diagnostician by superadmin")
    public void verify_Toggle_Off_diag_By_SuperAdmin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();

        //checking user is disable or not
        //Verify that diagnostician's 'Status' change to 'Disabled', when admin disables 'Disable User' toggle button, on 'Edit User' pop up of 'Diagnosticians List' page.
        diagnostician.enter_InSearchField(diagnosticianFirstName);
        diagnostician.cheking_DisableUser();

    }

    @Test(priority = 15, enabled = true, description = "Verify that Superadmin is able to disable the user or not")
    public void validate_Enable_ToggleOf_Dia_By_SuperAdmin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        diagnostician.cheking_DisableUser();
        diagnostician.enter_InSearchField(diagnosticianFirstName);
        diagnostician.enable_DiagnosticianUser();

        // Enabling the user
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        WebdriverWaits.waitForSpinner();
        String edit_Succ_Msg = getText_custom(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, edit_Succ_Msg);
        Log.info("Successfully Edited the created diagnostician");
        // panelPage.click_LogOutLink();
    }

    @Test(priority = 16, enabled = true, description = "4.14 verify that superAdmin is able to edit or not after clicking Dont save button")
    public void verify_Dia_DontSaveBtn() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        diagnostician.cheking_DisableUser();
        diagnostician.enter_InSearchField(diagnosticianFirstName);
        diagnostician.verify_DontSave("5659865589", diagnosticianEmailAddress, "123456", "123456");
        validate_text(diagnostician.UserNameGetText, diagnosticianUserName);
    }

    @Test(priority = 17, enabled = true, description = "4.15 Verify diagnostician is able to login with new password or not")
    public void verify_diagnostician_Relogin() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();
        panelPage.click_LogOutLink();

        // Login with Diagnostician new password
        login.diagnostician_Login();
        WebdriverWaits.waitUntilVisible(diagnostician.diagnosticianDashBoardPage);
        WebdriverWaits.waitForSpinner();
        validate_text(diagnostician.diagnosticianDashBoardPage, "Dashboard");
    }


    @Test(priority = 18, enabled = true, description = "4.16 Verify that diagnostician is able to login with old password or not")
    public void validate_diagnostician_relogin_old_pwd() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        LoginPage login = new LoginPage();
        // Logging with Old password to get validation message.
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelpage.click_LogOutLink();
        login.diagnostician_Login();
        WebdriverWaits.waitUntilVisible(diagnostician.validation_Msg);
        Thread.sleep(2000);
        validate_text(diagnostician.validation_Msg, "Username or password is incorrect");
    }


    //******************TC for DIRECTOR*************************
    public String directorLastName;
    public String dir_Cell_Number;
    public String directorFirstName;
    public String directorEmailAddress;
    public static String directorUserName;

    @Test(priority = 19, enabled = true, description = "3.1, 3.5, 3.9, verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        directorFirstName = "AU_Elix" + RandomStrings.requiredCharacters(3);
        directorLastName = "AU_Tyk" + RandomStrings.requiredCharacters(3);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Spar" + RandomStrings.requiredCharacters(3);
        dir_Cell_Number = RandomStrings.requiredDigits(10);
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();

        //Login with super Admin credentials
        login.superAdminLogin();//login

        //Verify that list of director appears after clicking 'Director' tab, on 'Dashboard' page.
        panelPage.click_DirectorTab();
        WebdriverWaits.waitUntilVisible(director.directorListPage);
        WebdriverWaits.waitForSpinner();
        validate_text(director.directorListPage, "Directors List");

        //Verify that user is able to create director with valid data after clicking 'Create Director' button, on 'Directors List' page
        director.create_Director(directorFirstName, directorLastName, dir_Cell_Number, directorEmailAddress, directorUserName, "123456", "123456");

        // Verify that superadmin is directed to 'Directors List' page after clicking on 'Create Director' button, on 'Create Director' page.
        WebdriverWaits.waitUntilVisible(director.directorListPage);
        WebdriverWaits.waitForSpinner();
        validate_text(director.directorListPage, "Directors List");
    }

    @Test(priority = 20, enabled = true, description = "3.8, 3.36 verify that duplicate Director throws error")
    public void create_duplicate_Directors() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();

        // Verify that validation message appears after clicking on 'Create Director' button, when user enter same username in 'username' field, on 'Create Director' page.
        director.create_Director(directorFirstName, directorLastName, dir_Cell_Number, directorEmailAddress, directorUserName, "123456", "123456");
        WebdriverWaits.waitUntilVisible(director.validationMsg);
        validate_text(director.validationMsg, "An error occurred while creating the user. Username already exists!");
        panelPage.click_BackButton();

        //Verify that no director gets created when user clicks on 'back' button, after enter any data on 'Create Director' page
    }


    //************Functionality has been changed***********************
    @Test(priority = 21, enabled = true, description = "3.2, 3.3, 3.15, 3.17,  Super admin is able to edit the created director or not")
    public void edit_Director() throws InterruptedException {
        String directorEmailAddress1 = directorFirstName + "12@yopmail.com";
        DirectorPage director = new DirectorPage();

        //director changing the password.
        //Verify that search text box appears after clicking 'Filter' button on 'Directors List' page.
        //Verify that result appears, when user searches for valid data, on 'Directors List' page
        director.enterInSearchField(directorUserName);

        //Verify that  'Edit User' pop up appears after clicking 'Edit' button of any director, on 'Directors List' page
        // Verify that 'Cell Number' field accepts ten digit number in defined format on 'Edit User' pop up, of 'Directors List' page
        director.edit_Director(directorEmailAddress1, "12345678", "12345678");
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }


    @Test(priority = 22, enabled = true, description = "3.19, 3.20 verify that superadmin is able to enable Director")
    public void validate_director_Toggle_Off() throws InterruptedException {

        DirectorPage director = new DirectorPage();
        director.enterInSearchField(directorUserName);
        // Verify that director's 'Status' change to 'Disabled', when admin disables 'Disable User' toggle button, on 'Edit User' pop up of 'Directors List' page.
        // Verify that changes made by superadmin gets cleared after clicking 'Don't Save' button, on 'Edit User' pop up of 'Directors List' page.
        director.cheking_DisableUser();
    }

    @Test(priority = 23, enabled = true, description = "Verify that Superadmin is able to Enable the user or not")
    public void verify_director_enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enterInSearchField(directorFirstName);
        director.enable_Director();
        WebdriverWaits.waitUntilVisible(director.edit_SuccMsg);
        validate_text(director.edit_SuccMsg, "Director details updated successfully.");
        Log.info("Successfully Edited the created director");
    }

    @Test(priority = 24, enabled = true, description = "verify that superadmin is able to edit or not after clicking dont save button")
    public void verify_Dir_DntSaveBtn() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enterInSearchField(directorFirstName);
        director.not_Edit_Director(directorEmailAddress, "123456", "123456");
        director.enterInSearchField(directorFirstName);
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);
        director.click_LogOutLink();
    }


    @Test(priority = 25, enabled = true, description = "Verify that director is able to login with old password or not")
    public void verify_login_With_OldPassword() {
        DirectorPage director = new DirectorPage();
        LoginPage login = new LoginPage();
        //Director trying to login with old password
        login.directorLogin();
        WebdriverWaits.waitUntilVisible(director.validation_Msg);
        validate_text(director.validation_Msg, "Username or password is incorrect");
    }

    @Test(priority = 26, enabled = true, description = "3.34 Verify director is able to login with new password or not")
    public void director_Relogin_By_SuperAdmin() {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login = new LoginPage();

        //Director trying to login with new password
        // Verify that user is able to login using new password after editing the password on 'Edit' popup, on 'Directors List' page.
        login.directorLogin();
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
         panelPage.click_LogOutLink();
    }


    //************Appointments page******************

    @Test(dependsOnMethods = {"verify_Full_Payment"}, description = "2.1, 2.3,2.5,2.8, 4 Verify that 'Appointments' accordion expands after clicking on 'Appointment' accordion from left panel, on 'Dashboard' page.")
    public void verify_Appointments_Page() throws InterruptedException {
        AppointmentsPage appointment = new AppointmentsPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        SuperAdminPage superAdmin=new SuperAdminPage();
        LoginPage login = new LoginPage();
        login.superAdminLogin();
        WebdriverWaits.waitUntilVisible(appointment.dashBoardPage);
        WebdriverWaits.waitForSpinner();
        validate_text(appointment.dashBoardPage, "Dashboard");

        //Verify that 'Appointments' accordion expands after clicking on 'Appointment' accordion from left panel, on 'Dashboard' page.
        panelPage.click_AppointmentsTab();
        validate_text(appointment.viewAllTab, "View All");
        Log.info("View all details tab successfully displayed");

        appointment.click_ViewAllTab();
        WebdriverWaits.waitUntilVisible(appointment.allAppointmentsPage);
        WebdriverWaits.waitForSpinner();
        validate_text(appointment.allAppointmentsPage, "All Appointments");

        //Verify that appropriate result appears, when user searches using valid data, on 'All Appointments' page
        //Verify that search text box appears after clicking 'Filter' button on 'All Appointments' page.
        appointment.click_SearchField(clientFirstName);
        WebdriverWaits.waitUntilVisible(appointment.searchedText);
        validate_text(appointment.searchedText, clientFirstName + ' ' + clientLastName);

        //**********Verifying Todate and from********************
        String toDate = DateGenerator.getCurrentDate();

        String FromDate = DateGenerator.getDateWithDays("dd-MM-yyyy", -2);
        superAdmin.click_filterButton();
        appointment.enter_Dates(FromDate, toDate);
        WebdriverWaits.waitUntilVisible(superAdmin.dateEle);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(4000);
        List<WebElement> my_list = superAdmin.getWebElements(superAdmin.dateEle);
        HashSet<WebElement> dateSet = new HashSet<>(my_list);

        LocalDate toDateLocal = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fromDateLocal = LocalDate.parse(FromDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        boolean result = true;
        for (WebElement i : dateSet) {
            String date = i.getText();
            LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            if (!(DateGenerator.isDateWithinRange(fromDateLocal, toDateLocal, inputDate))) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }

    //*************This testcase also has defect*********************
    @Test(dependsOnMethods = {"verify_Appointments_Page"}, description = " 2.7,  2.91Verify that 'Appointment Details' page opens up on clicking 'View Detail' link")
    public void verify_view_Details_Page() {
        AppointmentsPage appointment = new AppointmentsPage();
        SuperAdminPage superAdmin = new SuperAdminPage();

        //Verify that 'Appointment Details' page opens up on clicking 'View Detail' link of any existing appointment, on  'All Appointments' page
        appointment.click_ViewDetails();
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(appointment.app_Text);
        validate_text(appointment.app_Text, clientFirstName + ' ' + clientLastName + ' ' + "Details");
        // appointment.click_ViewAllTab();

        //Verify that 'View Document' button appears on top of the '<Client Name>Details' page, after clicking on 'View Details' link under 'Actions' column only for Completed Appointments, on 'All Appointments' page.
        WebdriverWaits.waitUntilVisible(superAdmin.viewStudentObservationButton);
        validate_text(superAdmin.viewStudentObservationButton, "View Student Observation");
        WebdriverWaits.waitUntilVisible(superAdmin.viewDocumentsButton);
        validate_text(superAdmin.viewDocumentsButton, "View Documents");
    }

    //********After completion of complete appointment this test case will be valid********************

    //To-do
    @Test(dependsOnMethods = {"verify_view_Details_Page"}, description = "2.9, Verify that superAdmin is able to view ClientObservation Page or not")
    public void view_ClientObservation_Page() {
        SuperAdminPage superAdmin = new SuperAdminPage();

        //Verify that 'Client Observation' page opens up, after clicking on 'View Student Observation' button, on top of the '<Client Name>Details' page.
        superAdmin.view_ClientObservation_Page();
        WebdriverWaits.waitUntilVisible(superAdmin.clientObservation);
        validate_text(superAdmin.clientObservation, "Client Observation");
        superAdmin.click_BackButton();
    }

    @Test(dependsOnMethods = {"view_ClientObservation_Page"}, description = "2.6, SuperAdmin is able to download CSV File or not")
    public void download_CSV_File() throws InterruptedException, FileNotFoundException {
        AppointmentsPage appointment = new AppointmentsPage();
        SuperAdminPage admin = new SuperAdminPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();


        appointment.click_ViewAllTab();
        admin.click_Export_CSV_Button();

//Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'All Appointments' page
        //Download exportCSV File and Check file is downloaded or not
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        panelpage.navigate_Back();
        panelpage.click_LogOutLink();
    }

    //**********************SuperAdmin is viewing Payments page********************
    @Test(dependsOnMethods = {"verify_Cancelled_Appointments"}, description = "6.1, Verify that list of payments appears after clicking 'Payments' tab, on 'Dashboard' page.")
    public void view_Payments_Page() {
        PaymentPage payment = new PaymentPage();
        LoginPage login = new LoginPage();
        login.navigate_Back();
        login.superAdminLogin();

        //******************** SuperAdmin viewing payments page**********

        payment.click_PaymentTab();

        //Verify that list of payments appears after clicking 'Payments' tab, on 'Dashboard' page.
        WebdriverWaits.waitUntilVisible(payment.paymentListPage);
        validate_text(payment.paymentListPage, "Payments");
    }

    //****************Admin while do the payment after creating the appointments.
    @Test(dependsOnMethods = {"view_Payments_Page"}, description = "6.2, 6.3,6.4 Verify that search text box appears after clicking 'Filter' button on 'Payments' page.")
    public void verify_Search_Payment() throws InterruptedException {
        PaymentPage payment = new PaymentPage();
        //  String getText = getText_custom(payment.getCust_Name);

        //Verify that search text box appears after clicking 'Filter' button on 'Payments' page.
        //  payment.click_filterButton();

        //"Verify that result appears, when user searches relevant text, on 'Paymentspage "
        payment.enterInSearchField(clientFirstName);
        AppointmentsPage appPage = new AppointmentsPage();
        SuperAdminPage admin = new SuperAdminPage();

        String toDate = DateGenerator.getCurrentDate();

        String FromDate = DateGenerator.getDateWithDays("dd-MM-yyyy", -2);
        admin.click_filterButton();
        appPage.enter_Dates(FromDate, toDate);
        WebdriverWaits.waitUntilVisible(admin.dateEle);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(4000);
        List<WebElement> my_list = admin.getWebElements(admin.dateEle);
        HashSet<WebElement> dateSet = new HashSet<>(my_list);

        LocalDate toDateLocal = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fromDateLocal = LocalDate.parse(FromDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        boolean result = true;
        for (WebElement i : dateSet) {
            String date = i.getText();
            LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            if (!(DateGenerator.isDateWithinRange(fromDateLocal, toDateLocal, inputDate))) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }


    @Test(dependsOnMethods = {"verify_Search_Payment"}, description = "6.5, Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'Payments' page")
    public void download_ExportCSV_File() throws InterruptedException, FileNotFoundException {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();

        panelpage.click_ExportCSVButton();

        //Download exportCSV File and Check file is downloaded or not
        //Verify that CSV file gets downloaded after clicking 'Export to CSV' button, on 'Payments' page
        String downloadFile = panelpage.getDownloadFileName();
        Assert.assertTrue(panelpage.isFileDownloaded(downloadFile));
        panelpage.navigate_Back();
         panelpage.click_LogOutLink();
    }
    @Test(priority = 29, enabled = true, description = "SuperAdmin is able to disable the diagnostician")
    public void verify_disable_diagnostician() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.superAdminLogin();
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        panelPage.click_DiagnosticianTab();
        diagnostician.disable_Diagnostician(diagnosticianUserName);
        diagnostician.click_UpdateButton();
    }


    //logout superadmin
    @Test(priority = 30, enabled = true, description = "34 Verify that SuperAdmin is able to logout")
    public void verify_superadmin_logout() {
        AppointmentsPage page = new AppointmentsPage();
        //Verify that super admin gets logs out on clicking 'Log Out' link from the left pannel
        page.click_LogOutLink();
    }
}



