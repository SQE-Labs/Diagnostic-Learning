package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.Diagnostician;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.testng.annotations.Test;
import static org.automation.pageObjects.Diagnostician.*;
import static org.automation.pageObjects.DirectorPage.*;
import static org.automation.pageObjects.DirectorPage.UserNameGetText;
import static org.automation.pageObjects.DirectorPage.disableUser;
import static org.automation.pageObjects.DirectorPage.validation_Msg;
import static org.automation.utilities.Assertions.validate_SuccessTXT;
import static test.DirectorTest.*;

public class SuperAdminTest extends BaseTest {
    public static String diagnosticianFirstName;
    public static String diagnosticianLastName;
    public static String diagnosticianEmailAddress;
    public static String diagnosticianEmailAddress1;
    public static String diagnosticianUserName;

    @Test(priority = 0, enabled = true,description = "SuperAdmin is able to create Diagnostician")
    public void create_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician = new Diagnostician();
        diagnosticianFirstName = "Beau" + RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "Ward" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName + "@yopmail.com";
        diagnosticianUserName = "Riley" + RandomStrings.requiredCharacters(2);
    LoginPage login = new LoginPage();
    login.validLogin();
    diagnostician.create_Diagnostician(diagnosticianFirstName, diagnosticianLastName, "8564234568", diagnosticianEmailAddress, diagnosticianUserName, "123456", "123456");
    Thread.sleep(5000);
    validate_SuccessTXT(actualText,diagnosticianUserName);
    System.out.println("Successfully SuperAdmin Created diagnostician");
}
    @Test(priority = 1,enabled = true,description = "SuperAdmin is able to search created diagnostician or not")
    public void search_Created_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        Thread.sleep(5000);
        validate_SuccessTXT(actualText,diagnosticianUserName);
        System.out.println("Created Diagnostician Displayed In The Diagnostician ListPage");
    }
    @Test(priority = 2,enabled = true,description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Diagnostician() throws InterruptedException {
        diagnosticianEmailAddress1 = diagnosticianFirstName + "12@yopmail.com";
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.edit_Diagnostician("2456789548",diagnosticianEmailAddress1,"12345678","12345678");
        validate_SuccessTXT(edit_Succ_Msg,"Diagnostician details updated successfully.");
        System.out.println("Successfully Edited the created diagnostician");
    }
    @Test(priority = 3,enabled = true,description = "verify that toggole is off or not")
    public void checking_Toggle_Off() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician. cheking_DisableUser();
        validate_SuccessTXT(disableUser,"Enable User");
    }
    @Test(priority = 4,enabled = true,description = "Verify that Superadmin is able to diable the user or not")
    public void enable_User() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.enable_DiagnosticianUser();
        validate_SuccessTXT(edit_Succ_Msg,"Diagnostician details updated successfully.");
        System.out.println("Successfully Edited the created diagnostician");
    }
    @Test(priority = 5,enabled = true,description="verify that diagnostician is able to edit or not after clicking dont save button")
    public void not_Creating_Diagnostician() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.not_Edit_Diagnostician("5659865589",diagnosticianEmailAddress,"123456","123456");
       validate_SuccessTXT(UserNameGetText,diagnosticianUserName);
    }
    @Test(priority = 6,enabled = true,description="Verify Diagnostician is able to login with new password or not")
    public void diagnostician_Relogin() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.Relogin_With_newPassword(diagnosticianUserName,"12345678");
        Thread.sleep(10000);
        validate_SuccessTXT(diagnosticianDashBoardPage,"Dashboard");
    }
    @Test(priority = 7,enabled = true,description = "Verify that diagnostician is able to login with old password or not")
    public void diagnostician_login_With_OldPassword() throws InterruptedException {
        Diagnostician diagnostician=new Diagnostician();
        diagnostician.Relogin_With_OldPassword(diagnosticianUserName,"123456");
        validate_SuccessTXT(validation_Msg,"Username or password is incorrect");
    }
    @Test(priority = 8,enabled =true,description = "verify that SuperAdmin is able to create Director or not")
    public void create_Directors() throws InterruptedException {
        directorFirstName = "director_Beau" + RandomStrings.requiredCharacters(2);
        directorLastName = "director_Ward" + RandomStrings.requiredCharacters(2);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "director_Riley" + RandomStrings.requiredCharacters(2);
        DirectorPage director=new DirectorPage();
        LoginPage login =new LoginPage();
        getDriver().navigate().refresh();
        login.validLogin();
        director.create_Director(directorFirstName,directorLastName,"5236458965",directorEmailAddress,directorUserName,"123456","123456");
        validate_SuccessTXT(directorListPage,"Directors List");
    }
    @Test(priority = 9,enabled = true,description = "Super admin is able to edit the created diagnostician or not")
    public void edit_Director() throws InterruptedException {
        directorEmailAddress1 = directorFirstName + "12@yopmail.com";
        DirectorPage director=new DirectorPage();
        director.edit_Director("2456789548",directorEmailAddress1,"12345678","12345678");
        validate_SuccessTXT(edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }
    @Test(priority = 10,enabled = true,description = "verify that toggole is off or not")
    public void director_checking_Toggle_Off() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.cheking_DisableUser();
        validate_SuccessTXT(enableUser, "Enable User");
    }
    @Test(priority = 11,enabled = true,description = "Verify that Superadmin is able to diable the user or not")
    public void director_enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_SuccessTXT(edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }
    @Test(priority = 12,enabled = true,description="verify that diagnostician is able to edit or not after clicking dont save button")
    public void not_Creating_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.not_Edit_Director("5659865589",directorEmailAddress,"123456","123456");
        validate_SuccessTXT(UserNameGetText,directorUserName);
    }
    @Test(priority = 13,enabled = true,description="Verify Diagnostician is able to login with new password or not")
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.Relogin_With_newPassword(directorUserName,"12345678");
        Thread.sleep(10000);
        validate_SuccessTXT(directorDashBoardPage,"Dashboard");
    }
    @Test(priority = 14,enabled = true,description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.directorRelogin_With_OldPassword(directorUserName,"123456");
        validate_SuccessTXT(validation_Msg,"Username or password is incorrect");
    }
}
