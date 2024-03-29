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

    public void clickLoginBtn() {
        clickBtn_custom(login);
    }


    public void superAdminLogin() {
        WebdriverWaits.waitUntilVisible(userNameField);
        sendKeys_withClear(userNameField, PropertiesUtil.getPropertyValue("super_userName"));
        sendKeys_withClear(PasswordField, PropertiesUtil.getPropertyValue("super_password"));
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();

    }

    public void director_Login() {
        sendKeys_withClear(userNameField, PropertiesUtil.getPropertyValue("director_userName"));
        sendKeys_withClear(PasswordField, PropertiesUtil.getPropertyValue("director_password"));
        clickBtn_custom(login);
        WebdriverWaits.waitForSpinner();

    }

    public void diagnostician_Login(String userNameText, String PasswordFieldText) {
        enterUsername(userNameText);
        enterPassword(PasswordFieldText);
        clickLoginBtn();
        WebdriverWaits.waitForSpinner();

    }

    public void adminLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
        WebdriverWaits.waitForSpinner();
    }

    public void directorLogin(String userNameFieldText, String PasswordFieldText) {
        enterUsername(userNameFieldText);
        enterPassword(PasswordFieldText);
        click_custom(login);


    }

}
