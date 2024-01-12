package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.Assertions.validate_text;


public class Diagnostician extends BasePage {
    public By diagnosticianLink = By.xpath("//a[text()='Diagnosticians']");
    public By createDiagnostician = By.xpath("//button[text()='Create Diagnostician']");
    public By loginLoading=By.cssSelector("div.ngx-spinner-overlay");
    public By diagnostician_FirstName = By.xpath("//input[@placeholder='First Name']");
    public By diagnostician_LastName = By.xpath("//input[@placeholder='Last Name']");
    public By diagnostician_MobileNumber = By.xpath("//input[@placeholder='(999) 999-9999']");
    public By diagnostician_Email = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By locationName = By.xpath("//option[text()='Plano']");
    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createDiagnosticianButton = By.xpath("//button[text()='Create Diagnostician']");
    public By validationMsg=By.xpath("//div[text()=' An error occurred while creating the admin. Username already exists! ']");

    public  By actualText = By.xpath("(//td)[2]");
    public By backButton = By.xpath("//button[text()='Back']");
    public  By diagnosticianDashBoardPage = By.xpath("//h3[text()='Dashboard']");
    public By back_Button=By.xpath("//a[text()='Back']");



    //**************Search created diagnostician*************

    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");

    //+++++++++++++EDIT Diagnostician+++++++++++++++

    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By enableToggle=By.xpath("//label[text()='Enable User']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public  By edit_Succ_Msg = By.xpath("//div[text()=' Diagnostician details updated successfully. ']");
    public  By UserNameGetText=By.xpath("(//td)[2]");
    public  By enableUser=By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton=By.xpath("//a[text()='Don’t Save']");

    //**************DIAGNOSTICIAN LOOGING IN WITH NEW PASSWORD*************

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");
    public  By validation_Msg=By.xpath("//small[text()='Username or password is incorrect']");

    //*****************Verify diagnostician is viewing appointments page***************

    public By today_appointments=By.xpath("(//h6[@class='card-heading'])[1]");
    public By view_DetailApp=By.xpath("//a[text()='View Details']");
    public By start_Assesment=By.xpath("//a[text()='Start Assessment']");
    public By no_Payment=By.xpath("//a[text()='No Payment']");
    public By bouncing_Leg=By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
    public By humming=By.xpath("(//div[@class='custom-control custom-checkbox'])[5]");
    public By playing_with_pencil=By.xpath("(//div[@class='custom-control custom-checkbox'])[8]");
    public By difficulty_Sitting=By.xpath("(//div[@class='custom-control custom-checkbox'])[14]");
    public By Playing_with_hair=By.xpath("(//div[@class='custom-control custom-checkbox'])[13]");
    public By excessive_Talking=By.xpath("(//div[@class='custom-control custom-checkbox'])[16]");
    public By summary=By.xpath("//textarea[@class='custom-input border border-danger ng-untouched ng-pristine ng-valid']");
    public By dashboard=By.xpath("//h3[text()='Dashboard']");
    public By appointmentUserName=By.xpath("//h3[text()=' Randy Walker ']");
    public By appointmentsTab= By.xpath("//a[text()=' Appointments ']");
    public By viewAllTab=By.xpath("(//a)[3]");
    public By appointmentDetail=By.xpath("//h3[text()='Krillin Dash Details']");
    public By paymentDetails=By.xpath("//h4[text()='Payment Details']");
    public By userAssesment=By.xpath("//h3[text()='Krillin Dash Assessment']");






WebdriverWaits waits=new WebdriverWaits();


    public void click_createDiagnosticianButton() {
        waits.WaitUntilVisible(createDiagnostician);
       // WebdriverWaits.WaitForPageLoadTime(10);
        waits.WaitUntilInvisible(loginLoading);
        click_custom(createDiagnostician);
    }

    public void enter_diagnostician_FirstName(String CustomerFirstName) throws InterruptedException {
        WebdriverWaits.WaitUntilVisible(diagnostician_FirstName);
        sendKeys_withClear(diagnostician_FirstName, CustomerFirstName);
    }

    public void enter_diagnostician_LastName(String CustomerLastName) {
        WebdriverWaits.WaitUntilVisible(diagnostician_LastName);
        sendKeys_withClear(diagnostician_LastName, CustomerLastName);
    }

    public void enter_Diagnostician_MobileNumber(String diagnostician_MobileNumberText) {
        WebdriverWaits.WaitUntilVisible(diagnostician_MobileNumber);
        sendKeys_withClear(diagnostician_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_Diagnostician_Email(String diagnostician_EmailText) {
        WebdriverWaits. WaitUntilVisible(diagnostician_Email);
        sendKeys_withClear(diagnostician_Email, diagnostician_EmailText);
    }
    public void click_AssignLocation() {
        WebdriverWaits.WaitUntilVisible(assignLocation);
        click_custom(assignLocation);
        WebdriverWaits.WaitUntilVisible(locationName);
        click_custom(locationName);
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

    public void clickOn_createDiagnosticianButton() {
        click_custom(createDiagnosticianButton);
    }



    public void click_Back_Button() {
        waits.WaitUntilPresent(backButton);
        click_custom(backButton);
    }


    //*************search created diagnostician***************

    public void click_filterButton() {
        WebdriverWaits.WaitUntilVisible(filterButton);
        WebdriverWaits.WaitUntilInvisible(loginLoading);

        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.WaitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }

    //+++++++++++++++++EDIT DIAGNOSTICIAN++++++++++++++

    public void click_On_EditButton() {
        WebdriverWaits.WaitUntilVisible(editButton);
        click_custom(editButton);
    }

    public void enter_CellNumber(String cellNumberText) {
        waits.WaitUntilVisible(cellNumber);
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }


    public void off_ToggleButton() {
        click_custom(toggle);
    }

    public void enter_Diagnostician_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void clickOn_PasswordField(String passwordTextFieldText) {
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordFieldField(String confirmPasswordFieldText) {
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }
    public void clickOn_DontSave()
    {
        WebdriverWaits.WaitUntilVisible(dontSaveButton);
        click_custom(dontSaveButton);
    }

    //**********Diagnostician is viewing appointments************
    public void clickOn_Today_Appointment(){
        WebdriverWaits.WaitUntilInvisible(loginLoading);
        WebdriverWaits.WaitUntilVisible(appointmentsTab);
        click_custom(appointmentsTab);
        WebdriverWaits.WaitUntilVisible(viewAllTab);
        click_custom(viewAllTab);

    }
    public void clickOn_ViewDetail(){
        WebdriverWaits.WaitUntilVisible(view_DetailApp);
        click_custom(view_DetailApp);
    }
    public void clickOn_StartAssesment(){
        WebdriverWaits.WaitUntilVisible(start_Assesment);
        scrollIntoView(start_Assesment);
        click_custom(start_Assesment);
    }
    public void clickOn_NoPaymentButton(){
        WebdriverWaits.WaitUntilVisible(no_Payment);
        click_custom(no_Payment);
    }
    public void clickOn_CheckBox(){
        WebdriverWaits.WaitUntilVisible(bouncing_Leg);
        click_custom(bouncing_Leg);
        WebdriverWaits.WaitUntilVisible(humming);
        click_custom(humming);
        WebdriverWaits.WaitUntilVisible(playing_with_pencil);
        click_custom(playing_with_pencil);
        WebdriverWaits.WaitUntilVisible(difficulty_Sitting);
        click_custom(difficulty_Sitting);
        WebdriverWaits.WaitUntilVisible(Playing_with_hair);
        click_custom(Playing_with_hair);
        WebdriverWaits.WaitUntilVisible(excessive_Talking);
        click_custom(excessive_Talking);
    }
    public void writing_Summary(String summaryText){
        scrollIntoView(summary);
        WebdriverWaits.WaitUntilVisible(summary);
        sendKeys_withClear(summary,summaryText);
    }
    public void clickOn_BackButton(){
        scrolltoUp();
        WebdriverWaits.WaitUntilVisible(back_Button);
        click_custom(back_Button);
    }




    public void create_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
        click_createDiagnosticianButton();
        enter_diagnostician_FirstName(CustomerFirstName);
        enter_diagnostician_LastName(CustomerLastName);
        enter_Diagnostician_MobileNumber(diagnostician_MobileNumberText);
        enter_Diagnostician_Email(EmailAddress);
        click_AssignLocation();
        userNameField(UserName);
        create_passwordField(PasswordText);
        confirm_PasswordField(RePassword);
        clickOn_createDiagnosticianButton();
    }
    public void Verify_Duplicate_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName,String PasswordText,String RePassword) throws InterruptedException {
        click_createDiagnosticianButton();
        enter_diagnostician_FirstName(CustomerFirstName);
        enter_diagnostician_LastName(CustomerLastName);
        enter_Diagnostician_MobileNumber(diagnostician_MobileNumberText);
        enter_Diagnostician_Email(EmailAddress);
        click_AssignLocation();
        userNameField(UserName);
        create_passwordField(PasswordText);
        confirm_PasswordField(RePassword);
        clickOn_createDiagnosticianButton();
    }


    public void diagnostician_ListPage() throws InterruptedException {
        click_createDiagnosticianButton();
        click_Back_Button();
    }

    public void search_CreatedDiagnostician(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    public void edit_Diagnostician( String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
       // enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }

    public void cheking_DisableUser() throws InterruptedException {
        click_On_EditButton();
        clickOn_DontSave();
        click_On_EditButton();
        clickOn_DontSave();
    }
    public void enable_DiagnosticianUser() throws InterruptedException {
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();

    }
    public void verify_DontSave(String cellNumberText, String EmailAddress1, String passwordTextFieldText,String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        clickOn_DontSave();
    }
    //****************Diagnostician is checking todays appointments**************
    public void today_Appointment(String summaryText) throws InterruptedException {
        WebdriverWaits.WaitUntilVisible(dashboard);
        validate_text(dashboard, "Dashboard");

        clickOn_Today_Appointment();

        clickOn_ViewDetail();
        WebdriverWaits.WaitUntilVisible(appointmentDetail);
       validate_text(appointmentDetail, "Krillin Dash Details");

        clickOn_StartAssesment();
        WebdriverWaits.WaitUntilVisible(paymentDetails);
        validate_text(paymentDetails, "Payment Details");

        clickOn_NoPaymentButton();
        WebdriverWaits.WaitUntilVisible(userAssesment);
        validate_text(userAssesment, "Krillin Dash Assessment");

        clickOn_CheckBox();
        writing_Summary(summaryText);
    }
}
