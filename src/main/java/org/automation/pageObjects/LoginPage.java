package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import test.SuperAdminTest;


public class LoginPage extends BasePage {

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");

    public void enterUsername(String userNameText) {
        WebdriverWaits.waitUntilVisible(userNameField);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(userNameField, userNameText);
    }

    public void enterPassword(String passNameText) {
        WebdriverWaits.waitUntilVisible(PasswordField);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(PasswordField, passNameText);
    }

    public void superAdminLogin(String superAdminUserName,String superAdminPassword) {
        WebdriverWaits.waitUntilVisible(userNameField);
        sendKeys_withClear(userNameField, superAdminUserName);
        sendKeys_withClear(PasswordField,  superAdminPassword);
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();

    }

    public void director_Login(String directorUserName, String directorPassword) {
        sendKeys_withClear(userNameField, directorUserName );
        sendKeys_withClear(PasswordField, directorPassword );
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();

    }

    public void diagnostician_Login() {
        WebdriverWaits.waitUntilVisible(userNameField);
        sendKeys_withClear(userNameField, PropertiesUtil.getPropertyValue("diagnostician_userName"));
        sendKeys_withClear(PasswordField, PropertiesUtil.getPropertyValue("diagnostician_password"));
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();
    }

    public void diagnostician_LoginWithOldPassword(String diagnosticianUserName,String diagnosticianPassword) {
        WebdriverWaits.waitUntilVisible(userNameField);
        sendKeys_withClear(userNameField, diagnosticianUserName );
        sendKeys_withClear(PasswordField, diagnosticianPassword );
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();
    }

    public void admin_Login() {
        sendKeys_withClear(userNameField, PropertiesUtil.getPropertyValue("admin_userName"));
        sendKeys_withClear(PasswordField, PropertiesUtil.getPropertyValue("admin_password"));
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();

    }
    public void adminLoginWith_OldPassword() {
        sendKeys_withClear(userNameField, PropertiesUtil.getPropertyValue("admin_userName"));
        sendKeys_withClear(PasswordField, PropertiesUtil.getPropertyValue("admin_oldpassword"));
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();
    }

    public void director_LoginWithOldPassword(String userName , String pass) {
        sendKeys_withClear(userNameField,userName);
        sendKeys_withClear(PasswordField,pass);
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();


    }

}
