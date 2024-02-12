package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;

import org.automation.pageObjects.DashBoardPanelPage;
import org.automation.pageObjects.DirectorPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.RandomStrings;
import org.automation.utilities.WebdriverWaits;
import org.bson.assertions.Assertions;
import org.testng.annotations.Test;

import static org.automation.utilities.Assertions.getText_custom;
import static org.automation.utilities.Assertions.validate_text;


public class DirectorTest extends BaseTest {

    @Test(priority = 23, enabled = true, description = "verify that Director is able to edit or not after clicking dont save button")
    public void verify_Dir_DntSaveBtn() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
    //    director.not_Edit_Director(directorEmailAddress, "123456", "123456");
      //  validate_text(director.UserNameGetText, directorUserName);
        director.click_LogOutLink();
    }
    @Test(priority=24,enabled = true,description = "Verify that Director is able to login with valid credentials or not")
    public void director_Availability() throws InterruptedException {
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        DirectorPage director=new DirectorPage();
      //  login.directorLogin(directorUserName,"12345678");
        WebdriverWaits.waitUntilVisible(director.dashboardPage);
        validate_text(director.dashboardPage, "Dashboard");
        panelPage.click_AppointmentsTab();
        validate_text(director.viewAll, "View All");
        panelPage.click_Availability();
      //  validate_text(director.monthHeader, "December");

        director.director_Availability();
        director.click_LogOutLink();
    }
    @Test(priority = 25, enabled = true, description = "Verify that diagnostician is able to login with old password or not")
    public void login_With_OldPassword() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        //Director trying to login with old password
     //   login.directorLogin(directorUserName, "123456");
        WebdriverWaits.waitUntilVisible(director.validation_Msg);
        validate_text(director.validation_Msg, "Username or password is incorrect");
        //panelPage.click_LogOutLink();
    }

    @Test(priority = 26, enabled = true, description = "Verify Diagnostician is able to login with new password or not")
    public void director_Relogin() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage panelPage = new DashBoardPanelPage();
        LoginPage login=new LoginPage();
        //Director trying to login with new password
      //  login.directorLogin(directorUserName, "12345678");
        WebdriverWaits.waitUntilVisible(director.directorDashBoardPage);
        validate_text(director.directorDashBoardPage, "Dashboard");
        panelPage.click_LogOutLink();
    }
}
