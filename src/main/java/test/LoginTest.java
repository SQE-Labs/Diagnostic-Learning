package test;

import org.automation.base.BaseTest;

import org.automation.pageObjects.LoginPage;
import org.automation.utilities.PropertiesUtil;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

//negative  testcases
    //faliure login testcase
    @Test(priority = 0, enabled = true, description = "To verify login functionality")
    public void superAdmin() throws InterruptedException {
        LoginPage login = new LoginPage();
//        login.enterUsername(PropertiesUtil.getPropertyValue("userName"));
//        login.enterPassword(PropertiesUtil.getPropertyValue("password"));
 //   login.clickLoginBtn();
    }
    @Test(priority = 0, enabled = true, description = "To verify login functionality")
    public void s() throws InterruptedException {
        LoginPage login = new LoginPage();
        //login.enterUsername(PropertiesUtil.getPropertyValue("adminUserName"));
       //login.enterPassword(PropertiesUtil.getPropertyValue("adminPassword"));
       //login.clickLoginBtn();
    }


}
