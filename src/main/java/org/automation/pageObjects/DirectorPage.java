package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.automation.utilities.Assertions.validate_text;


public class DirectorPage extends BasePage {
    WebdriverWaits wait = new WebdriverWaits();

    public String expectedData;
    public Boolean result;
    public By directorsTab = By.xpath("//li[@id='Directors']");
    public By createDirectorButton = By.xpath("//button[text()='Create Director']");
    public By directorsFirstName = By.xpath("//input[@placeholder='First Name']");
    public By directorsLastName = By.xpath("//input[@placeholder='Last Name']");
    public By directorsMobileNumber = By.xpath("//input[@placeholder='(999) 999-9999']");
    public By directorsEmail = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By directorsLocationName = By.xpath("//option[text()='Plano']");
    public By directorsUserName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createDirectorsButton = By.xpath("//button[text()='Create Director']");
    public By validationMsg = By.xpath("//div[text()=' An error occurred. Please try again. ']");

    //**************Search created director***************
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By actualText = By.xpath("(//td)[2]");

    //****************edit created director**************

    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By enableToggle = By.xpath("//label[text()='Enable User']");
    public By directorListPage = By.xpath("//h3[text()='Directors List']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By edit_SuccMsg = By.xpath("//div[text()=' Director details updated successfully. ']");
    public By UserNameGetText = By.xpath("(//td)[2]");
    public By disableUser = By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton = By.xpath("//a[text()='Don’t Save']");
    public By edit_Popup = By.xpath("//h5[text()='Edit User']");
    public By enableUser = By.xpath("//label[text()='Enable User']");
    public By dashboardPage = By.xpath("//h3[text()='Dashboard']");
    public By viewAll = By.xpath("//a[text()='View All']");
    public By setAvailability = By.xpath("//h3[text()='Set Availability']");
    public By monthHeader = By.xpath("//span[text()=' December ']");
    public By yearHeader = By.xpath("//span[text()=' 2023 ']");
    public By dateHeader = By.xpath("//div[@class='mbsc-ios mbsc-ltr mbsc-schedule-header-day mbsc-schedule-header-day-today mbsc-selected ng-star-inserted']");
    public By yearsCalender = By.xpath("//mbsc-button[text()=' 2023 - 2034 ']");
    public By hihglihgtedYear = By.xpath("(//div[@class='mbsc-calendar-cell-text mbsc-calendar-year-text mbsc-ios ng-star-inserted'])[13]");
    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[21]");
    public By clickOnBox1 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[22]");
    public By clickOnBox2 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[23]");
    public By clickOnBox3 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[24]");
    public By clickOnBox4 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[25]");
    public By clickOnBox5 = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[26]");
    public By availableSlot1 = By.xpath("//mbsc-schedule-event[@data-id='mbsc_5']");
    public By deleteBtn = By.xpath("//mbsc-button[text()=' Delete ']");
    public By cancelBtn = By.xpath("//mbsc-button[text()=' Cancel ']");
    public By upcomingSubtab = By.xpath("//a[text()='Upcoming']");
    public By todaySubtab = By.xpath("//a[contains(text(),'Today')]");

    // public By clickOnBox6=By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[21]");
    public By availableText = By.xpath("//div[text()='Available']");
    public By saveButton = By.xpath("//button[text()='Save']");
    public By titleofSignInPage = By.xpath("//h3[text()='Sign in to your account']");
    public By titleofTodayPage = By.xpath("//h3[text()=\"Today's Appointments\"]");
    public By titleofUpcomingPage = By.xpath("//h3[contains(text(),'Upcoming Appointments')]");
    //**************relogin with new password***********

    public By userNameField = By.xpath("//input[@placeholder='Username']");
    public By PasswordField = By.xpath("//input[@placeholder='Password']");
    public By login = By.id("loginFormSubmit");
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By directorDashBoardPage = By.xpath("//h3[text()='Dashboard']");
    public By validation_Msg = By.xpath("//small[text()='Username or password is incorrect']");
    public By loginLoading = By.cssSelector("div.ngx-spinner-overlay");
    public By viewAllSubtab = By.xpath("//a[text()='View All']");
    public By clickOnFilterButton = By.xpath("//a[text()='Filter']");
    public By getTextFromSearchField = By.xpath("#filterSearch");
    public By getTextFromDateField = By.xpath("//input[@placeholder=\"From Date\"]");
    public By getTextToDateField = By.xpath("//input[@placeholder='To Date']");

    public By getTextOfTopRecord = By.xpath("(//td[@class='tablewidth'])[1]");
    public By exportCSVButton = By.xpath("//button[@onclick='exportCSV()']");

    public By viewDetailsButton=By.xpath("(//a[text()='View Detail'])[1]");

    public By editTestPlan=By.xpath("//button[@data-target='#selectSurveys']");

   public By getTextFromTestPlanEditPopup=By.xpath("//h6[text()='Please choose tests.']");
   public By closeButton=By.xpath("//div[@class='action']/a");
    public By tocCheckbox=By.xpath("//label[text()='KABC']/..");
    public By listOfWebelementsUnderTestPlan=By.xpath("//p[@class='badge badge-pill bg-purple-light mr-2 px-3 py-2 ng-star-inserted']");

    public By otherCommentsTextField=By.xpath("//textarea[@class='custom-input ng-pristine ng-valid ng-touched']");

    String expectedDataIncomments="This Data is enetered for testing purpose.";
    public By titleOfTestingNotes=By.xpath("//h5[text()='Testing Notes']");
    public By paymentButton=By.xpath("//button[@data-target='#paymentModal']");
    public By titleForCollectPaymentPopup=By.xpath("//h4[text()='Collect Payment']");

    public By click_0nCanelButton= By.xpath("//a[text()='Cancel']");

    public By sendValueInTestFeeAdjustmentField= By.xpath("(//input[@type='text'])[1]");

    public By sendValueInCollectAmountAdjustmentField= By.xpath("(//input[@type='text'])[2]");

    public By sendValueInEnterAmountField= By.id("bookingDeposit");
    public By collectAmountButton= By.xpath("//div[@class='action border-top pt-4 text-center']/a//following-sibling::button");

    public By assessmentAmountInDisplay= By.xpath("//label[text()='Assessment Amount']//following-sibling::p");

    public By amountDueInDisplay= By.xpath("//label[text()='Amount Due']//following-sibling::p");
    public By receivedAmountInDisplay= By.xpath("//label[text()='Received Amount']//following-sibling::p");
    public By clickOnCloseButton= By.xpath("(//a[text()='Close'])[2]");
    String positiveTestFeeAdjustment="200";
    String negativeTestFeeAdjustment="-200";
    String positiveCollectAmountAdjustment="200";
    String negativeCollectAmountAdjustment="-200";

    String negativeEnterAmountValue="-200";

    String greaterEnterAmountValue="9999";

   public String comparisionForPositiveTestFeeValue;
    public Boolean comparisionForNegativeTestFeeValue;
    public Boolean comparisionForPositiveCollectFeeValue;
    public Boolean comparisionForNegativeCollectFeeValue;
   public By clickCloseButton= By.xpath("(//a[text()='Close'])[2]");



    public void click_OnEditTestPlan()
    {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        wait.WaitUntilVisible(viewDetailsButton);
        click_custom(viewDetailsButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(editTestPlan);
        click_custom(editTestPlan);
        wait.WaitUntilVisible(closeButton);
        click_custom(closeButton);

    }

    public boolean changesNotSaved_ClickOnCloseButton()
    {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        wait.WaitUntilVisible(viewDetailsButton);
        click_custom(viewDetailsButton);
        wait.WaitUntilVisible(listOfWebelementsUnderTestPlan);
        int beforeCount=getDriver().findElements(listOfWebelementsUnderTestPlan).size();
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(editTestPlan);
        click_custom(editTestPlan);
        wait.WaitUntilVisible(tocCheckbox);
        selectCheckBox(tocCheckbox);
        wait.WaitUntilVisible(closeButton);
        click_custom(closeButton);
        ScrollThePage(0, -1000);
        int  afterCount=getDriver().findElements(listOfWebelementsUnderTestPlan).size();
        return result=beforeCount==(afterCount);

    }
public void click_OnCancelBtn()
{
    wait.WaitUntilVisible(click_0nCanelButton);
    click_custom(closeButton);
}
    public void dataEnteredINOtherCommentsTextField()
    {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        wait.WaitUntilVisible(viewDetailsButton);
        click_custom(viewDetailsButton);
        int beforeCount=getDriver().findElements(listOfWebelementsUnderTestPlan).size();
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(editTestPlan);
        click_custom(editTestPlan);
        sendKeys_withClear(otherCommentsTextField, expectedDataIncomments);

    }
    public String getTextOfTopRecord() throws InterruptedException
    {
        wait.WaitUntilVisible(upcomingSubtab);
        click_custom(upcomingSubtab);
        WebdriverWaits.WaitUntilVisible(clickOnFilterButton);
        click_custom(clickOnFilterButton);
        wait.WaitUntilVisible(getTextOfTopRecord);
        expectedData=getText_custom(getTextOfTopRecord);
        click_custom(clickOnFilterButton);
        WebdriverWaits.WaitUntilVisible(getTextFromSearchField);
        sendKeys_withClear(getTextFromSearchField, expectedData);
        return expectedData;

    }

    public void collectPayment()
    {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        wait.WaitUntilVisible(viewDetailsButton);
        click_custom(viewDetailsButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(paymentButton);
        click_custom(paymentButton);

    }

    public void fromDateCalendarIconAppear()
    {
        wait.WaitUntilVisible(upcomingSubtab);
        click_custom(upcomingSubtab);
        WebdriverWaits.WaitUntilVisible(clickOnFilterButton);
        click_custom(clickOnFilterButton);
        wait.WaitUntilVisible(getTextFromDateField);
        click_custom(getTextFromDateField);
        click_custom(getTextFromDateField);

    }

    public void toDateCalendarIconAppear()
    {
        wait.WaitUntilVisible(upcomingSubtab);
        click_custom(upcomingSubtab);
        WebdriverWaits.WaitUntilVisible(clickOnFilterButton);
        click_custom(clickOnFilterButton);
        wait.WaitUntilVisible(getTextToDateField);
        click_custom(getTextToDateField);
        click_custom(getTextToDateField);

    }

    public void clickON_ExportCSVButton() {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        WebdriverWaits.WaitUntilVisible(exportCSVButton);
        click_custom(exportCSVButton);

    }


/*
public String userEnter_PositiveValue_IntestAdjustmentField()
{
*/



    /*app.click_ViewAllTab();
    app.clickOn_ViewDetails();
    ScrollThePage(0, 1000);
    wait.WaitUntilVisible(payment.assessmentAmountInDisplay);
    String beforeReceivedamount=getDriver().findElement(payment.assessmentAmountInDisplay).getText();
    wait.WaitUntilVisible(payment.amountDueInDisplay);
    String BeforeAmountDueInDisplay=getDriver().findElement(payment.amountDueInDisplay).getText();
    wait.WaitUntilVisible(payment.paymentButton);
    click_custom(payment.paymentButton);
    sendKeys_custom(payment.sendValueInTestFeeAdjustmentField,positiveTestFeeAdjustment);
    wait.WaitUntilVisible(payment.collectAmountButton);
    click_custom(payment.collectAmountButton);
    wait.WaitUntilVisible(payment.clickCloseButton);
    click_custom(payment.clickCloseButton);
    ScrollThePage(0, 1000);
    wait.WaitUntilVisible(payment.assessmentAmountInDisplay);
    String afterReceivedamount=getDriver().findElement(assessmentAmountInDisplay).getText();
    wait.WaitUntilVisible(payment.amountDueInDisplay);
    String afterAmountDueInDisplay=getDriver().findElement(payment.amountDueInDisplay).getText();
    System.out.println(beforeReceivedamount);*/
   /* String numberOnlyOne=beforeReceivedamount.replace( "$","");
    String numberOnlyTwo=BeforeAmountDueInDisplay.replace( "$","");
    String numberOnlyThree = afterReceivedamount.replace( "$","");
    String numberOnlyFour=afterAmountDueInDisplay.replace( "$","");
*/

    /*float valueOfBeforReceivedAmount=Float.parseFloat(numberOnlyOne);
    float valueOfAfterReceivedAmount=Float.parseFloat(numberOnlyTwo);
    float valueOfBeforeAmountDue=Float.parseFloat(numberOnlyThree);
    float valueOfAfterAmountDue=Float.parseFloat(numberOnlyFour);

    float calculationOne= valueOfBeforReceivedAmount-valueOfAfterReceivedAmount;
    float calculationTwo= valueOfBeforeAmountDue-valueOfAfterAmountDue;

    String CountForReceivedAmount = Float.toString(calculationOne);
    String CountForAmountDue = Float.toString(calculationTwo);

    String finalCountForReceivedAmount=CountForReceivedAmount.replace( ".0","");
    String finalCountForAmountDue=CountForReceivedAmount.replace( ".0","");
*/





    public Boolean userEnter_NegativeValue_IntestAdjustmentField()
    {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        wait.WaitUntilVisible(viewDetailsButton);
        click_custom(viewDetailsButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(assessmentAmountInDisplay);
        String beforeReceivedamount=getDriver().findElement(assessmentAmountInDisplay).getText();
        wait.WaitUntilVisible(amountDueInDisplay);
        String BeforeAmountDueInDisplay=getDriver().findElement(amountDueInDisplay).getText();
        wait.WaitUntilVisible(paymentButton);
        click_custom(paymentButton);
        sendKeys_custom(sendValueInTestFeeAdjustmentField,negativeTestFeeAdjustment);
        wait.WaitUntilVisible(collectAmountButton);
        click_custom(collectAmountButton);
        wait.WaitUntilVisible(clickCloseButton);
        click_custom(clickCloseButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(assessmentAmountInDisplay);
        String afterReceivedamount=getDriver().findElement(assessmentAmountInDisplay).getText();
        wait.WaitUntilVisible(amountDueInDisplay);
        String afterAmountDueInDisplay=getDriver().findElement(amountDueInDisplay).getText();
        wait.WaitUntilVisible(paymentButton);
        comparisionForNegativeTestFeeValue= !(beforeReceivedamount.equals(afterReceivedamount)) && !(BeforeAmountDueInDisplay.equals(afterAmountDueInDisplay));
        return comparisionForNegativeTestFeeValue;


    }

    public Boolean userEnter_PositiveValue_InCollectAdjustmentField()
    {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        wait.WaitUntilVisible(viewDetailsButton);
        click_custom(viewDetailsButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(assessmentAmountInDisplay);
        String beforeReceivedamount=getDriver().findElement(receivedAmountInDisplay).getText();
        wait.WaitUntilVisible(receivedAmountInDisplay);
        String BeforeAmountDueInDisplay=getDriver().findElement(amountDueInDisplay).getText();
        wait.WaitUntilVisible(paymentButton);
        click_custom(paymentButton);
        sendKeys_custom(sendValueInCollectAmountAdjustmentField,positiveCollectAmountAdjustment);
        wait.WaitUntilVisible(collectAmountButton);
        click_custom(collectAmountButton);
        wait.WaitUntilVisible(clickCloseButton);
        click_custom(clickCloseButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(assessmentAmountInDisplay);
        String afterReceivedamount=getDriver().findElement(receivedAmountInDisplay).getText();
        wait.WaitUntilVisible(receivedAmountInDisplay);
        String afterAmountDueInDisplay=getDriver().findElement(amountDueInDisplay).getText();
        wait.WaitUntilVisible(paymentButton);
        comparisionForPositiveCollectFeeValue= !(beforeReceivedamount.equals(afterReceivedamount)) && !(BeforeAmountDueInDisplay.equals(afterAmountDueInDisplay));
        return comparisionForPositiveCollectFeeValue;


    }



    public Boolean userEnter_NegativeValue_InCollectAdjustmentField()
    {
        wait.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        wait.WaitUntilVisible(viewDetailsButton);
        click_custom(viewDetailsButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(receivedAmountInDisplay);
        String beforeReceivedamount=getDriver().findElement(receivedAmountInDisplay).getText();
        wait.WaitUntilVisible(amountDueInDisplay);
        String BeforeAmountDueInDisplay=getDriver().findElement(amountDueInDisplay).getText();
        wait.WaitUntilVisible(paymentButton);
        click_custom(paymentButton);
        sendKeys_custom(sendValueInCollectAmountAdjustmentField,negativeCollectAmountAdjustment);
        wait.WaitUntilVisible(collectAmountButton);
        click_custom(collectAmountButton);
        wait.WaitUntilVisible(clickCloseButton);
        click_custom(clickCloseButton);
        ScrollThePage(0, 1000);
        wait.WaitUntilVisible(receivedAmountInDisplay);
        String afterReceivedamount=getDriver().findElement(receivedAmountInDisplay).getText();
        wait.WaitUntilVisible(amountDueInDisplay);
        String afterAmountDueInDisplay=getDriver().findElement(amountDueInDisplay).getText();


        wait.WaitUntilVisible(paymentButton);
        comparisionForNegativeCollectFeeValue= !(beforeReceivedamount.equals(afterReceivedamount)) && !(BeforeAmountDueInDisplay.equals(afterAmountDueInDisplay));
        return comparisionForNegativeCollectFeeValue;


    }

public void userEnter_NegativeValueInEnterAmount()
{
    wait.WaitUntilVisible(viewAllSubtab);
    click_custom(viewAllSubtab);
    wait.WaitUntilVisible(viewDetailsButton);
    click_custom(viewDetailsButton);
    ScrollThePage(0, 1000);
    click_custom(paymentButton);
    sendKeys_custom(sendValueInCollectAmountAdjustmentField,negativeCollectAmountAdjustment);
    wait.WaitUntilVisible(collectAmountButton);
    click_custom(collectAmountButton);
}

    public void click_DirectorTab() throws InterruptedException {
        WebdriverWaits.SwitchToNewTab();
        wait.WaitUntilVisible(directorsTab);
        wait.WaitUntilInvisible(loginLoading);

        click_custom(directorsTab);
    }

    public void click_CreateDirectorsButton() {
        wait.WaitUntilVisible(createDirectorButton);
        wait.WaitUntilInvisible(loginLoading);
        //  wait.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));

        click_custom(createDirectorButton);
    }

    public void click_directorsFirstNameField(String directorsFirstNameText) {
        wait.WaitUntilVisible(directorsFirstName);
        sendKeys_withClear(directorsFirstName, directorsFirstNameText);
    }

    public void click_directorsLastNameField(String directorsLastNameText) {
        wait.WaitUntilVisible(directorsLastName);
        sendKeys_withClear(directorsLastName, directorsLastNameText);
    }

    public void click_directorsMobileNumberField(String directorsMobileNumberText) {
        wait.WaitUntilVisible(directorsMobileNumber);
        sendKeys_withClear(directorsMobileNumber, directorsMobileNumberText);
    }

    public void click_directorsdirectorsEmailField(String directorsEmailText) {
        wait.WaitUntilVisible(directorsEmail);
        sendKeys_withClear(directorsEmail, directorsEmailText);
    }

    public void click_directorsassignLocationField() {
        wait.WaitUntilVisible(assignLocation);
        click_custom(assignLocation);
        wait.WaitUntilVisible(directorsLocationName);
        click_custom(directorsLocationName);
    }

    public void click_directorsUserNameField(String directorsUserNameText) {
        wait.WaitUntilVisible(directorsUserName);
        sendKeys_withClear(directorsUserName, directorsUserNameText);
    }

    public void click_passwordField(String password_FieldText) {
        wait.WaitUntilVisible(password_Field);
        sendKeys_withClear(password_Field, password_FieldText);
    }

    public void click_confirmPasswordField(String confirmPasswordFieldText) {
        sendKeys_withClear(confirm_PasswordField, confirmPasswordFieldText);
    }

    public void click_createDirectorButton() {
        click_custom(createDirectorsButton);
    }

    //***************search created diagnostician******************

    public void click_filterButton() {
        wait.WaitUntilVisible(filterButton);
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        sendKeys_withClear(searchField, searchFieldText);
    }

    //***************edit created director*****************
    public void click_On_EditButton() {
        wait.WaitUntilVisible(editButton);
        click_custom(editButton);
    }

    public void enter_CellNumber(String cellNumberText) {
        wait.WaitUntilVisible(cellNumber);
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }


    public void off_ToggleButton() {
        click_custom(toggle);
    }

    public void enter_Director_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void clickOn_PasswordField(String passwordTextFieldText) {
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordField(String confirmPasswordFieldText) {
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }

    public void clickOn_DontSave() {
        wait.WaitUntilVisible(dontSaveButton);
        click_custom(dontSaveButton);
    }


    //**********DIAGNOSTICIAN LOGGING IN WITH NEW PASSWORD************
    public void clickOn_Login_UsernameField(String userNameFieldText) {
        sendKeys_withClear(userNameField, userNameFieldText);
    }

    public void clickOn_Login_PasswordField(String PasswordFieldText) {
        sendKeys_withClear(PasswordField, PasswordFieldText);
    }

    public void clickOn_Login_Button() {
        click_custom(login);
    }

    public void click_LogOutLink() {
        wait.WaitUntilVisible(logOutLink);
        click_custom(logOutLink);
    }

    public void clickOn_YearHeader() {
        wait.WaitUntilVisible(yearHeader);
        click_custom(yearHeader);
    }

    public void clickOn_availableBox() {
        WebdriverWaits.WaitUntilVisible(clickOnBox);
        click_custom(clickOnBox);
        click_custom(clickOnBox1);
        click_custom(clickOnBox2);
        click_custom(clickOnBox3);
        click_custom(clickOnBox4);
        click_custom(clickOnBox5);
        // click_custom(clickOnBox6);
    }

    public void clickOn_SaveButton() {
        WebdriverWaits.WaitUntilVisible(saveButton);
        click_custom(saveButton);
    }


    public void clickOn_DeleteButton() {
        WebdriverWaits.WaitUntilVisible(availableSlot1);
        click_custom(availableSlot1);
        WebdriverWaits.WaitUntilVisible(deleteBtn);
        click_custom(deleteBtn);


    }

    public void clickOn_CancelButton() {
        WebdriverWaits.WaitUntilVisible(availableSlot1);
        click_custom(availableSlot1);
        WebdriverWaits.WaitUntilVisible(cancelBtn);
        click_custom(cancelBtn);

    }

    public void clickOn_UpcomingSubtab() {
        WebdriverWaits.WaitUntilVisible(upcomingSubtab);
        click_custom(upcomingSubtab);

    }
    public void clickOn_TodaySubtab() {
        WebdriverWaits.WaitUntilVisible(todaySubtab);
        click_custom(todaySubtab);

    }

    public void clickOn_FilterButton()
    {
        WebdriverWaits.WaitUntilVisible(viewAllSubtab);
        click_custom(viewAllSubtab);
        WebdriverWaits.WaitUntilVisible(clickOnFilterButton);
        click_custom(clickOnFilterButton);


    }

    //*********Create director**************
    public void create_Director(String directorsFirstNameText, String directorsLastNameText, String directorsMobileNumberText, String directorsEmailText, String directorsUserNameText, String password_FieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_CreateDirectorsButton();
        click_directorsFirstNameField(directorsFirstNameText);
        click_directorsLastNameField(directorsLastNameText);
        click_directorsMobileNumberField(directorsMobileNumberText);
        click_directorsdirectorsEmailField(directorsEmailText);
        click_directorsassignLocationField();
        click_directorsUserNameField(directorsUserNameText);
        click_passwordField(password_FieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        click_createDirectorButton();
    }

    public void Verify_Duplicate_Director(String directorsFirstNameText, String directorsLastNameText, String directorsMobileNumberText, String directorsEmailText, String directorsUserNameText, String password_FieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_CreateDirectorsButton();
        click_directorsFirstNameField(directorsFirstNameText);
        click_directorsLastNameField(directorsLastNameText);
        click_directorsMobileNumberField(directorsMobileNumberText);
        click_directorsdirectorsEmailField(directorsEmailText);
        click_directorsassignLocationField();
        click_directorsUserNameField(directorsUserNameText);
        click_passwordField(password_FieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        click_createDirectorButton();
    }


    //**************Search created director*************
    public void search_CreatedDirector(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    //***********edit created director*************
    public void edit_Director(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        // test case number ( 4.6 ).
        Assertions.validate_text(edit_Popup, "Edit User");
        Log.info("Successfully Edit popUp opens");
        // enter_CellNumber(cellNumberText);
        enter_Director_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }

    //********Cheking toggole off of directore*************

    public void cheking_DisableUser() throws InterruptedException {
        click_On_EditButton();
        clickOn_DontSave();
        click_On_EditButton();
        clickOn_DontSave();
    }
    public void click_() throws InterruptedException {
        click_On_EditButton();
        clickOn_DontSave();
        click_On_EditButton();
        clickOn_DontSave();
    }

    //********Enable user of director************
    public void enable_Director() throws InterruptedException {
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();
    }
    //**************Not Editing created director**************

    public void not_Edit_Director(String cellNumberText, String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        enter_CellNumber(cellNumberText);
        enter_Director_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordField(confirmPasswordFieldText);
        clickOn_DontSave();
        Thread.sleep(6000);
    }

    //***********Relogin using new password*************

    public void Relogin_With_newPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        click_LogOutLink();
        clickOn_Login_UsernameField(userNameFieldText);
        clickOn_Login_PasswordField(PasswordFieldText);
        clickOn_Login_Button();
    }

    //************director login with old Password***********
    public void directorRelogin_With_OldPassword(String userNameFieldText, String PasswordFieldText) throws InterruptedException {
        click_LogOutLink();
        clickOn_Login_UsernameField(userNameFieldText);
        clickOn_Login_PasswordField(PasswordFieldText);
        clickOn_Login_Button();
    }

    public void director_Availability() throws InterruptedException {
        clickOn_YearHeader();
        WebdriverWaits.WaitUntilVisible(yearsCalender);
        validate_text(yearsCalender, "2023 - 2034");
        WebdriverWaits.WaitUntilVisible(hihglihgtedYear);
        validate_text(hihglihgtedYear, "2023");
        clickOn_YearHeader();
        clickOn_availableBox();
        WebdriverWaits.WaitUntilVisible(availableText);
        validate_text(availableText, "Available");
        clickOn_SaveButton();
    }

    public void click_On_DeleteButton() throws InterruptedException {
        clickOn_YearHeader();
        WebdriverWaits.WaitUntilVisible(yearsCalender);
        validate_text(yearsCalender, "2023 - 2034");
        WebdriverWaits.WaitUntilVisible(hihglihgtedYear);
        validate_text(hihglihgtedYear, "2023");
        clickOn_YearHeader();
        clickOn_availableBox();
        WebdriverWaits.WaitUntilVisible(availableText);
        validate_text(availableText, "Available");
        clickOn_SaveButton();
        clickOn_DeleteButton();
        WebdriverWaits.WaitUntilVisible(clickOnBox);
        validate_text(clickOnBox, "");
        clickOn_SaveButton();

    }


    public void click_On_CancelButton() throws InterruptedException {

        clickOn_YearHeader();
        WebdriverWaits.WaitUntilVisible(yearsCalender);
        validate_text(yearsCalender, "2023 - 2034");
        WebdriverWaits.WaitUntilVisible(hihglihgtedYear);
        validate_text(hihglihgtedYear, "2023");
        clickOn_YearHeader();
        clickOn_availableBox();
        clickOn_CancelButton();
        WebdriverWaits.WaitUntilVisible(availableText);
        validate_text(availableText, "Available");
    }

    public void click_On_LogoutButton() throws InterruptedException
    {
        WebdriverWaits.WaitUntilVisible(titleofSignInPage);
        validate_text(titleofSignInPage, "Sign in to your account");

    }

    public void click_OnUpcomingSubtab() throws InterruptedException
    {
        clickOn_UpcomingSubtab();
        WebdriverWaits.WaitUntilVisible(titleofUpcomingPage);
        validate_text(titleofUpcomingPage, "Upcoming Appointments");
    }

    public void click_OnTodaySubtab() throws InterruptedException
    {
        clickOn_TodaySubtab();
        WebdriverWaits.WaitUntilVisible(titleofTodayPage);
        validate_text(titleofTodayPage, "Today's Appointments");
    }

    public void click_OnFilterBtn() throws InterruptedException
    {
        clickOn_FilterButton();
        WebdriverWaits.WaitUntilVisible(getTextFromSearchField);

        String value=getAttributevalue(getTextFromSearchField,"placeholder");
//        validate_text(value, "Type here to search");
//        WebdriverWaits.WaitUntilVisible(getTextFromSearchField);
//        validate_text(getTextFromDateField, "To Date");
//        WebdriverWaits.WaitUntilVisible(getTextFromSearchField);
//        validate_text(getTextToDateField, "From Date");
    }
    //new method getPlceholdrvalue


    public void valid_RecordsAppearForUpcoimnTab() throws InterruptedException
    {
        getTextOfTopRecord();

    }
}