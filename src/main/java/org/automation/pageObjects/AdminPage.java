package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.Assertions.validate_text;

public class AdminPage extends BasePage
{
    public By adminTab= By.xpath("//a[text()='Admins']");
    public By createAdminButton=By.xpath("//button[text()='Create Admin']");
    public By loginLoading=By.cssSelector("div.ngx-spinner-overlay");
    public By admin_FirstName = By.xpath("//input[@placeholder='First Name']");
    public By admin_LastName = By.xpath("//input[@placeholder='Last Name']");
    public By admin_MobileNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By admin_Email = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By locationName = By.xpath("//option[text()='Plano']");
    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createadminButton = By.xpath("//button[text()=' Create Admin ']");
    public By succ_Msg=By.xpath("//div[text()='Admin Created Successfully']");
    public By dashboardPage=By.xpath("//h3[text()='Admins List']");

    //**************Search created Admin*************

    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public  By actualText = By.xpath("(//td)[2]");

//*****************Edit Admin with valid credentials****************
    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By enableToggle=By.xpath("//label[text()='Enable User']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public  By Succ_Msg_Upd = By.xpath("//div[text()=' Admin details updated successfully. ']");
    public  By UserNameGetText=By.xpath("(//td)[2]");
    public  By enableUser=By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton=By.xpath("//a[text()='Don’t Save']");
    public By editUserPop_Up=By.xpath("//h5[text()='Edit User']");
    public By userNameText=By.xpath("(//td[2])[1]");
    public By Error_Msg=By.xpath("//div[text()='An error occurred while creating the admin. Username already exists!']");



    //***********DASH BOARD PAGE**********
    public By dashboard=By.xpath("//h3[text()='Dashboard']");







    public void clickOn_createAdminButton(){
        WebdriverWaits.WaitUntilVisible(createAdminButton);
       // WebdriverWaits.WaitUntilInvisible(createAdminButton);
        click_custom(createAdminButton);
        }

    public void enter_admin_FirstName(String CustomerFirstName) throws InterruptedException {
        WebdriverWaits.WaitUntilVisible(admin_FirstName);
        sendKeys_withClear(admin_FirstName, CustomerFirstName);
    }

    public void enter_admin_LastName(String CustomerLastName) {
        WebdriverWaits.WaitUntilVisible(admin_LastName);
        sendKeys_withClear(admin_LastName, CustomerLastName);
    }

    public void enter_admin_MobileNumber(String diagnostician_MobileNumberText) {
        WebdriverWaits.WaitUntilVisible(admin_MobileNumber);
        sendKeys_withClear(admin_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_admin_Email(String diagnostician_EmailText) {
        WebdriverWaits. WaitUntilVisible(admin_Email);
        sendKeys_withClear(admin_Email, diagnostician_EmailText);
    }
    public void userNameField(String userNameText) {
        WebdriverWaits.WaitUntilVisible(userName);
        sendKeys_withClear(userName, userNameText);
    }

    public void create_passwordField(String passwordFieldText) {
        sendKeys_withClear(password_Field, passwordFieldText);
    }

    public void confirm_PasswordField(String confirmPasswordText) {
        sendKeys_withClear(confirm_PasswordField, confirmPasswordText);
    }

    public void clickOn_createadminButton() {
        click_custom(createadminButton);
    }

    //*******************SuperAdmin  searching created admin******************


    public void click_filterButton() {
        WebdriverWaits.WaitUntilVisible(filterButton);
        WebdriverWaits.WaitUntilInvisible(loginLoading);
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.WaitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }

    //+++++++++++++++++EDIT Admin++++++++++++++

    public void click_On_EditButton() {
        WebdriverWaits.WaitUntilVisible(editButton);
        WebdriverWaits.WaitUntilInvisible(loginLoading);
        click_custom(editButton);
    }
    public void enter_Admin_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }


    public void off_ToggleButton() {
        click_custom(toggle);
    }

    public void enter_Diagnostician_Email1(String diagnostician_EmailText1) {
        WebdriverWaits.WaitUntilVisible(emailField);
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void clickOn_PasswordField(String passwordTextFieldText) {
        WebdriverWaits.WaitUntilVisible(passwordTextField);
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordFieldField(String confirmPasswordFieldText) {
        WebdriverWaits.WaitUntilVisible(confirmPasswordField);
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }
    public void clickOn_DontSave()
    {
        WebdriverWaits.WaitUntilVisible(dontSaveButton);
        click_custom(dontSaveButton);
    }







    //****************SuperAdmin creating Admin***********************
    public void create_Admin(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
        clickOn_createAdminButton();
        enter_admin_FirstName(CustomerFirstName);
        enter_admin_LastName(CustomerLastName);
        enter_admin_MobileNumber(diagnostician_MobileNumberText);
        enter_admin_Email(EmailAddress);

        userNameField(UserName);
        create_passwordField(PasswordText);
        confirm_PasswordField(RePassword);
        clickOn_createadminButton();
    }
//*******************SuperAdmin  searching created admin******************

    public void search_CreatedAdmin(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    //******************EDIT ADMIN****************

    public void edit_Admin( String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        WebdriverWaits.WaitUntilVisible(editUserPop_Up);
        validate_text(editUserPop_Up, "Edit User");
        // enter_CellNumber(cellNumberText);
        enter_Admin_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }
    //************Checking toggle of or not*************

    public void cheking_DisableUser() throws InterruptedException {
        click_On_EditButton();
        clickOn_DontSave();
        click_On_EditButton();
        clickOn_DontSave();
    }

    //**********Enable user In Admin************
    public void enable_Admin() throws InterruptedException {
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();
    }

    //************Verify dontsave button******************

    public void verify_DontSave( String adminEmailAddress, String passwordTextFieldText,String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        enter_Diagnostician_Email1(adminEmailAddress);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        clickOn_DontSave();
    }


}
