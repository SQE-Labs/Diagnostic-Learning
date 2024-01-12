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
        WebdriverWaits.WaitUntilVisible(userNameField);
        sendKeys_withClear(userNameField, userNameText);
    }

    public void enterPassword(String passNameText) {
        WebdriverWaits.WaitUntilVisible(PasswordField);
        sendKeys_withClear(PasswordField, passNameText);
    }

    public void clickLoginBtn() {
        WebdriverWaits.WaitUntilVisible(login);
        clickBtn_custom(login);
    }


    public void superAdminLogin()   {
        WebdriverWaits.WaitUntilVisible(userNameField);
        sendKeys_withClear(userNameField, PropertiesUtil.getPropertyValue("userName"));
        WebdriverWaits.WaitUntilVisible(PasswordField);
        sendKeys_withClear(PasswordField, PropertiesUtil.getPropertyValue("password"));
        clickBtn_custom(login);
    }
    public void diagnosticianLogin( String username,String PasswordFieldText ) throws InterruptedException {
        enterUsername(username);
        enterPassword(PasswordFieldText);
        click_custom(login);
    }
    public void adminLogin(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }
    public void directorLogin(String userNameFieldText, String PasswordFieldText){

        enterUsername(userNameFieldText);
        enterPassword(PasswordFieldText);
        click_custom(login);
    }
    public void re_Login(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        enterUsername(userNameFieldText);
        enterPassword(PasswordFieldText);
        click_custom(login);
    }
}
