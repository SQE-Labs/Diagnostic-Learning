package org.automation.pageObjects;

import org.apache.commons.collections.list.SynchronizedList;
import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static java.lang.Double.parseDouble;
import static org.automation.utilities.Assertions.validate_AttText;
import static org.automation.utilities.Assertions.validate_text;
import static org.automation.utilities.WebdriverWaits.moveToEleByWE;
import static org.automation.utilities.WebdriverWaits.moveToElement;
import static test.AdminTest.clientFirstName;
import static test.AdminTest.clientLastName;


public class DiagnosticianPage extends BasePage {

    public By createDiagnostician = By.xpath("//button[text()='Create Diagnostician']");
    public By diagListPageText = By.xpath("//h3[text()='Diagnosticians List']");

    public By avaActualText = By.xpath("//div[@class='ng-star-inserted']");
    public By diagnostician_FirstName = By.xpath("//input[@placeholder='First Name']");
    public By diagnostician_LastName = By.xpath("//input[@placeholder='Last Name']");
    public By diagnostician_MobileNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By diagnostician_Email = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By locationName = By.xpath("//option[text()='Plano']");
    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createDiagnosticianButton = By.xpath("//button[text()='Create Diagnostician']");
    public By validationMsg = By.cssSelector(".alert.alert-danger.ng-star-inserted");


    public By actualText=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(2)");
    public By backButton = By.xpath("//button[text()='Back']");
    public By diagnosticianDashBoardPage = By.xpath("(//h3)[1]");
    public By back_Button = By.xpath("//button[@class='theme-button grey float-md-right mr-md-4']");


    //**************Search created diagnostician*************

    public By filterButton = By.xpath("//a[@class='theme-button grey ml-auto mr-3']");
    public By searchField = By.xpath("//input[@placeholder='Type here to search']");

    public By viewClientDetailLink = By.xpath("(//td)[6]");
    public By clientDetailText = By.xpath("//div[contains(@class,'page-header align-items-lg-center')]");
    public  By clientNameText=By.xpath("//h3");
    public By fromDate = By.xpath("//input[@placeholder='From Date']");
    public By toDate = By.xpath("//input[@placeholder='To Date']");

    //+++++++++++++EDIT Diagnostician+++++++++++++++

    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[@class='theme-button mr-3']");
    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By edit_Succ_Msg = By.xpath("//div[@class='alert alert-success ng-star-inserted']");
    public By UserNameGetText = By.xpath("(//td)[2]");
    public By enableUser = By.xpath("//label[@class='small ng-star-inserted']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton = By.xpath("//a[@class='theme-button grey']");

    //**************DIAGNOSTICIAN LOOGING IN WITH NEW PASSWORD*************

    public By userNameField = By.xpath("//input[@placeholder='Username']");


    public By validation_Msg = By.xpath("//p[@class='text-danger']");

    //*****************Verify diagnostician is viewing appointments page***************

    public By today_appointments = By.xpath("(//h6[@class='card-heading'])[1]");
    public By view_DetailApp = By.xpath("//a[text()='View Details']");
    public By start_Assesment = By.xpath("//a[text()='Start Assessment']");
    public By no_Payment = By.xpath("//a[text()='No Payment']");
    public By bouncing_Leg = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
    public By humming = By.xpath("(//div[@class='custom-control custom-checkbox'])[5]");
    public By playing_with_pencil = By.xpath("(//div[@class='custom-control custom-checkbox'])[8]");
    public By difficulty_Sitting = By.xpath("(//div[@class='custom-control custom-checkbox'])[14]");
    public By Playing_with_hair = By.xpath("(//div[@class='custom-control custom-checkbox'])[13]");
    public By excessive_Talking = By.xpath("(//div[@class='custom-control custom-checkbox'])[16]");

    public By appointmentsTab = By.xpath("//a[text()=' Appointments ']");
    public By viewAllTab = By.xpath("(//a)[3]");
    public By dashboard = By.xpath("//h3[text()='Dashboard']");

    public By disableButton = By.xpath("//div[@class='actions']/button[@class='theme-button grey pointer-disable float-md-right']");
    public By enableSaveButton = By.xpath("//button[@class='theme-button float-md-right green']");
    public By shiftText = By.xpath("//div[text()='Afternoon Shift']");
    public By availableText = By.xpath("(//div[@class='ng-star-inserted'])[7]");
    public By upcomingTab = By.xpath("//a[text()='Upcoming']");
    public By searchTextButton = By.xpath("//button[@class='theme-button']");
    public By dia_AvailSlots=By.xpath("//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted']");


//*****************Set Availability for diagnostician ****************

    public By chooseTestingLocation = By.id("testingLocation");
    public By assessmentDate = By.xpath("//input[@placeholder='Assessment Date']");

    public By assestmentType = By.xpath("//select[@id='assestmentType']");

    public By headerResource = By.xpath("//div[@class='header-resource-name']");


    public By clickOnBox = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[29]");
    public By saveButton = By.xpath("//mbsc-button[text()=' Save ']");
    public By appointmentSaveButtonButton = By.xpath("//a[text()='Save']");


    //****************Adding TestPlan for the appointment****************

    public By testPlan = By.xpath("//button[text()=' Test Plan ']");
    public By checkBox = By.xpath("//label[text()='WJ Achievement']/..");
    public By famCheckBox = By.xpath("//label[text()='FAM']/..");
    public By nepsyCheckBox = By.xpath("//label[text()='NEPSY']/..");
    public By ndCheckBox = By.xpath("//label[text()='ND']/..");
    public By wmsCheckBox = By.xpath("//label[text()='WMS']/..");

    public By bascSelfCheckBox = By.xpath("//label[text()='BASC Self']/..");
    public By cbrsSelfCheckBox = By.xpath("//label[text()='CBRS Self']/..");
    public By dlsDyslexiaCheckBox = By.xpath("//label[text()='DLS Dyslexia']/..");
    public By testPlanSaveButton = By.xpath("//button[text()='Save']");

    //+++++++++++++++CREATE DIAGNOSTICS++++++++++++++


    public By passwordField = By.xpath("//input[@placeholder='Password']");

    public By loginButton = By.xpath("//button[text()=' Log In ']");

    //********CHECKING AVAILABILITY******************


    public By availability = By.xpath("//a[text()='Availability']");

    public By slot3 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[4]");
    public By slot4 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[5]");

    public By slot6 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[7]");
    public By slot7 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[8]");
    public By slot8 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[9]");
    public By slot9 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[10]");
    public By slot10 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[11]");
    public By slot11 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[12]");

    public By diagnosticianSaveButton = By.xpath("//button[text()='Save']");
    public By todayLink = By.xpath("//mbsc-button[text()=' Today ']");
    public By delete = By.xpath("//mbsc-button[text()=' Delete ']");
    public By cancel = By.xpath("//mbsc-button[text()=' Cancel ']");
    public static By userNameText = By.xpath("(//td)[2]");

    //********************Upcoming appointments********************
    public By upcomingPageTitle = By.xpath("//h3[@class='mb-4 mb-md-0']");

    //*******************Diagnostician started assessment********************
    public By todaysTab = By.xpath("(//li[@class='ng-star-inserted'])[2]");
    public By viewDetails = By.xpath("//a[contains(@class,'theme-button green')]");
    public By startAssButtn = By.xpath("//a[contains(@class,'theme-button ng-star-inserted')]");
    public By inr = By.xpath("(//td)[6]");
    public By amountField = By.xpath("//input[@id='bookingDeposit']");
    public By collectButton = By.xpath("//button[@class='theme-button mx-2']");
    public By textArea = By.xpath("//textarea[contains(@class,'custom-input border border-danger')]");
    public By bouncingLegCheckBox = By.xpath("//label[text()='Bouncing leg']");
    public By clickingOfToungueCheckBox = By.xpath("//input[@formcontrolname='clickingOfTongue']");
    public By impulsiveResponsesCheckBox = By.xpath("//input[@formcontrolname='impulsiveResponses']");
    public By playingWithHairCheckBox = By.xpath("//input[@formcontrolname='playingWithHair']");
    public By pickingIPadCheckBox = By.xpath("//input[@formcontrolname='pickingIPad']");
    public By shufflingFeetCheckBox = By.xpath("//input[@formcontrolname='shufflingFeet']");
    public By checkBoxList = By.xpath("//div[@class='custom-control custom-radio custom-control-inline']");
    public By textField = By.xpath("//textarea[contains(@class,'ng-pristine ng-invalid')]");
    public By completeAssButton = By.xpath("(//button[@class='theme-button green mr-3'])[1]");
    public By yesCompleteAssButton = By.xpath("(//button[@class='theme-button green mr-2'])[1]");
    public By paymentDetailTitle = By.xpath("//h4[@class='text-center']");
    public By paymentLinkButton = By.xpath("//a[@class='theme-button green mx-2']");
    public By merchantLoginPage = By.xpath("//h1[@class='merch_login']");
    public By pageTitle = By.xpath("//h3");
    public By highAmount = By.xpath("//button[@class='theme-button mx-2 grey']");
    public By collectButn = By.xpath("//button[@class='theme-button mx-2']");
    public By saveDraftObservationButton = By.xpath("(//button[@class='theme-button green mr-3'])[2]");
    public By completeAssPopUp = By.xpath("(//h6[@class='text-purple mb-3'])[1]");
    public By noButton = By.xpath("(//button[@class='theme-button grey'])[1]");
    public By upcoming_App = By.xpath("//h3[@class='mb-4 mb-md-0']");

    //****************Complete Assessment*******************

    public By testComTab = By.xpath("//a[text()='Test complete']");



    DashBoardPanelPage panelPage = new DashBoardPanelPage();

    public void click_createDiagnosticianButton() {
        WebdriverWaits.waitUntilVisible(createDiagnostician);
        WebdriverWaits.waitForSpinner();
        click_custom(createDiagnostician);
    }

    public void enter_diagnostician_FirstName(String CustomerFirstName) {
        sendKeys_withClear(diagnostician_FirstName, CustomerFirstName);
    }

    public void enter_diagnostician_LastName(String CustomerLastName) {
        sendKeys_withClear(diagnostician_LastName, CustomerLastName);
    }

    public void enter_Diagnostician_MobileNumber(String diagnostician_MobileNumberText) {
        WebdriverWaits.waitUntilVisible(diagnostician_MobileNumber);
        sendKeys_withClear(diagnostician_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_Diagnostician_Email(String diagnostician_EmailText) {
        sendKeys_withClear(diagnostician_Email, diagnostician_EmailText);
    }

    public void click_AssignLocation() {
        click_custom(assignLocation);
        click_custom(locationName);
    }

    public void userNameField(String userNameText) {
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
    public void clickOn_FilterButton(){
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
    }


    public void click_Back_Button() {
        click_custom(backButton);
    }


    //*************search created diagnostician***************

    public void click_filterButton() {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
        String AttText=getDriver().findElement(By.xpath("//input[@id='filterSearch']")).getAttribute("placeholder");
        System.out.println(AttText);
        validate_AttText(AttText, "Type here to search");

        String fromDateText=getDriver().findElement(By.xpath("//input[@placeholder='From Date']")).getAttribute("placeholder");
        getAttributevalue(fromDate, "placeholder");
        validate_AttText(fromDateText, "From Date");

        String toDateText=getDriver().findElement(By.xpath("//input[@placeholder='To Date']")).getAttribute("placeholder");
        WebdriverWaits.waitUntilVisible(toDate);
        validate_AttText(toDateText, "To Date");
    }

    public void enterInSearchField(String searchFieldText) {
        sendKeys_withClear(searchField, searchFieldText);
    }

    public void clickOn_ViewDetailLink() {
        click_custom(viewClientDetailLink);
    }

    //+++++++++++++++++EDIT DIAGNOSTICIAN++++++++++++++

    public void click_On_EditButton() throws InterruptedException {
        WebdriverWaits.waitUntilVisible(editButton);
        Thread.sleep(3000);
        click_custom(editButton);
    }

    public void enter_CellNumber(String cellNumberText) {
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

    public void clickOn_DontSave() {
        WebdriverWaits.waitUntilVisible(dontSaveButton);
        click_custom(dontSaveButton);
    }

    //**********Diagnostician is viewing appointments************
    public void clickOn_AppointmentTab() {
        moveToElement(appointmentsTab);


    }

    public void clickOn_upcomingTab() {
        WebdriverWaits.waitUntilVisible(upcomingTab);
        moveToElement(upcomingTab);
    }


    public String create_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
        WebdriverWaits.waitForSpinner();
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
        String UserNameTexts = panelPage.RecentUser();
        return UserNameTexts;
    }

    public void search_CreatedDiagnostician(String UserName) {
        click_filterButton();
        enterInSearchField(UserName);
    }
    public void serach_Dia(String diaName){
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
        enterInSearchField(diaName);
    }

    public void edit_Diagnostician(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
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

    public void disable_Diagnostician(String userNameText) throws InterruptedException {
        clickOn_FilterButton();
        enterInSearchField(userNameText);
        Thread.sleep(2000);
        click_On_EditButton();
        off_ToggleButton();
    }

    public void enable_DiagnosticianUser() throws InterruptedException {
        click_On_EditButton();
        off_ToggleButton();
        click_UpdateButton();

    }

    public void verify_DontSave(String cellNumberText, String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        clickOn_DontSave();
    }


    //****************Diagnostician is checking todays appointments**************


    public void selectAssessmentDate() {
        WebdriverWaits.waitUntilVisible(assessmentDate);
        click_custom(assessmentDate);
    }

    public void selectTestinglocation(String chooseLocationText) {
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByVisibleText_custom(chooseTestingLocation, chooseLocationText);
    }

    public int getColumnCount() {
        List<WebElement> list = getWebElements(headerResource, "Heders");
        return list.size();
    }

    public void clickOnSaveButton() {
        //  click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }

    public void clickOnAppSaveButton() {
        click_custom(appointmentSaveButtonButton);
    }

    public void getTotalColumnCount() {
        int colCount = getColumnCount();
        int expLocatorPos = (colCount - 1) * 7 + 1;
        System.out.println(expLocatorPos);

        click_custom(clickOnBox);
    }

    public void clickOnAssesmentType(int assestmentTypeTexts) {

        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType, assestmentTypeTexts);
    }

    //******************Adding TestPlan for the Appointment**************

    public void click_TestPlanButton() {
        WebdriverWaits.waitUntilVisible(testPlan);
        scrollIntoView(testPlan);
        click_custom(testPlan);
    }

    public void clickOnCheckBox() {
        click_custom(checkBox);
        click_custom(famCheckBox);
        click_custom(nepsyCheckBox);
        click_custom(ndCheckBox);
        click_custom(wmsCheckBox);
        click_custom(bascSelfCheckBox);
        click_custom(cbrsSelfCheckBox);
        click_custom(dlsDyslexiaCheckBox);
    }

    public void clickOnTestPlanSaveButton() {
        click_custom(testPlanSaveButton);
    }

//******************Logging as diagnostician************

    public void enter_UserName(String CustomerFirstName) {
        WebdriverWaits.waitUntilVisible(userNameField);
        sendKeys_withClear(userNameField, CustomerFirstName);
    }

    public void enter_Password(String PasswordText) {
        sendKeys_withClear(passwordField, PasswordText);
    }

    public void click_LoginButton() {
        click_custom(loginButton);
    }

    //******************checking availability*************
    public void click_On_Availablity() {
        WebdriverWaits.waitUntilVisible(availability);
        WebdriverWaits.waitForSpinner();
        click_custom(availability);
        validate_text(disableButton, "Save");
    }

    public void click_On_Slot() throws InterruptedException {
        // use logic??
//        WebdriverWaits.waitUntilVisible(slot10);
//        click_custom(slot3);
////       click_custom(slot4);
//          click_custom(slot5);
//        click_custom(slot6);
//        click_custom(slot7);
//        click_custom(slot8);
//        click_custom(slot9);
//        click_custom(slot10);
//        click_custom(slot11);
//        click_custom(slot12);
//        click_custom(slot13);
        Thread.sleep(5000);
        List<WebElement> slots=getWebElements(dia_AvailSlots,"Diagnostician Available slots");
        System.out.println(slots.size());
        for(WebElement slot : slots){
            Thread.sleep(2000);
            moveToEleByWE(slot);
            if(getDriver().findElements(By.xpath("//div[@class='ng-star-inserted']")).size()>6){
                break;
            }
        }

        WebdriverWaits.waitUntilVisible(enableSaveButton);
        validate_text(enableSaveButton, "Save");

        click_custom(diagnosticianSaveButton);
        // click_custom(logOutLink);
    }

    public void click_On_Delete() {
        click_custom(delete);
    }

    public void set_Availability() throws InterruptedException {
        click_On_Availablity();
        click_On_Slot();
    }

    //**************Diagnostician Started Assessment***************
    public void clickOn_TodasTab() {
        WebdriverWaits.waitForSpinner();
        click_custom(todaysTab);
    }

    public void clickOn_ViewDetails() {
        WebdriverWaits.waitForSpinner();
        click_custom(viewDetails);
    }

    public void clickOn_StartAssButtn() {
        WebdriverWaits.waitUntilVisible(startAssButtn);
        scrollIntoView(startAssButtn);
        click_custom(startAssButtn);
    }

    public void enter_LowAmount() throws InterruptedException {
        String Inr = getText_custom(inr).replace("$", "");
        double amount = parseDouble(Inr);
        double value = amount - 50;
        Thread.sleep(4000);
        sendKeys_withClear(amountField, String.valueOf(value));
    }

    public void enter_ValidAmount() throws InterruptedException {
        String Inr = getText_custom(inr).replace("$", "");
        Thread.sleep(6000);
        sendKeys_withClear(amountField, Inr);
    }

    public void enter_HighAmount() throws InterruptedException {
        String Inr = getText_custom(inr).replace("$", "");
        double amount = parseDouble(Inr);
        double value = amount + 40;
        Thread.sleep(6000);
        sendKeys_withClear(amountField, String.valueOf(value));
    }

    public void clickOn_CollectButton() {
        click_custom(collectButton);
    }

    public void enter_InTextArea(String textAreaText) {
        WebdriverWaits.waitUntilVisible(textArea);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(textArea);
        sendKeys_withClear(textArea, textAreaText);
        //textarea[contains(@class,'ng-pristine ng-invalid')]
        List<WebElement> list = getWebElements(textField, "TotalTextFields");
        for (WebElement fields : list) {
            fields.sendKeys("simple testing completed nothing to worry");
        }
    }

    public void clickOn_CheckBox() {
        WebdriverWaits.waitUntilVisible(bouncingLegCheckBox);
        WebdriverWaits.waitForSpinner();
        moveToElement(bouncingLegCheckBox);
        moveToElement(clickingOfToungueCheckBox);
        moveToElement(impulsiveResponsesCheckBox);
        moveToElement(playingWithHairCheckBox);
        moveToElement(pickingIPadCheckBox);
        moveToElement(shufflingFeetCheckBox);
        List<WebElement> list = getWebElements(checkBoxList, "TotalCheckBoxes");
        for (WebElement checkbox : list) {
            checkbox.click();
        }
    }

    public void clickOn_Complete_AssButton() {
        WebdriverWaits.waitUntilVisible(completeAssButton);
        validate_text(completeAssButton, "Complete Assessment");


        click_custom(completeAssButton);
        WebdriverWaits.waitUntilVisible(completeAssPopUp);
        validate_text(completeAssPopUp, "Are you sure you want to Complete this assessment?");

        click_custom(noButton);
        scrolltoUp();
        WebdriverWaits.waitUntilVisible(pageTitle);
        validate_text(pageTitle, clientFirstName + ' ' + clientLastName + ' ' + "Assessment");

        click_custom(completeAssButton);
        click_custom(yesCompleteAssButton);
    }

    public void clickOn_PaymentLinkButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(paymentLinkButton);
        switchToWindow();
    }

    //************diagnostician verifying complete assessment*************

    public void clickOn_CompleteAssTab() {
        click_custom(testComTab);
    }


    //================///////////=========================


    public void appointmentDateSelecting(int Type) {
        getTotalColumnCount();
        clickOnSaveButton();
        clickOnAppSaveButton();
        clickOnAssesmentType(Type);
    }

    public void login_As_Diagnostician(String UserName, String PasswordText) {
        enter_UserName(UserName);
        enter_Password(PasswordText);
        click_LoginButton();
    }

    public void deleting_Availability() {
        WebdriverWaits.waitUntilVisible(slot11);
        moveToElement(slot11);
        WebdriverWaits.waitUntilVisible(enableSaveButton);
        validate_text(enableSaveButton, "Save");
        click_On_Delete();
        WebdriverWaits.waitForElementInteractable(diagnosticianSaveButton);
        click_custom(diagnosticianSaveButton);
        WebdriverWaits.waitUntilVisible(slot7);
        validate_text(slot7, "");
    }

    public void cancel_Availability() {
        WebdriverWaits.waitUntilVisible(slot11);
        moveToElement(slot11);
        String getText = getText_custom(shiftText);
        WebdriverWaits.waitUntilVisible(shiftText);
        validate_text(shiftText, getText);
        WebdriverWaits.waitUntilVisible(cancel);
        click_custom(cancel);
        WebdriverWaits.waitUntilVisible(availableText);
        validate_text(availableText, "Available");
        click_custom(diagnosticianSaveButton);
    }

    public void view_ClientDetail(String clientLastName) {
        click_custom(filterButton);
          WebdriverWaits.waitUntilVisible(searchTextButton);
        validate_text(searchTextButton, "Search");
        enterInSearchField(clientLastName);
        clickOn_ViewDetailLink();
    }
    public void enter_ClientDetail(String clientLastName){
        enterInSearchField(clientLastName);
        clickOn_ViewDetailLink();
    }

//**************Diagnostician Started Assessment***************

    public void payment_NewPage() {
        clickOn_TodasTab();
        clickOn_ViewDetails();
        clickOn_StartAssButtn();
        clickOn_PaymentLinkButton();
        WebdriverWaits.waitUntilVisible(merchantLoginPage);
        validate_text(merchantLoginPage, "Merchant" + ' ' + "Login");
        switchToParentWindow();
    }

    public void start_Assessment_ByPaying_LessAmount(String textAreaText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(paymentDetailTitle);
        validate_text(paymentDetailTitle, "Payment Details");

        enter_LowAmount();
        WebdriverWaits.waitUntilVisible(collectButn);
        validate_text(collectButn, "Collect");

        clickOn_CollectButton();
        WebdriverWaits.waitUntilVisible(pageTitle);
        validate_text(pageTitle, clientFirstName + ' ' + clientLastName + ' ' + "Assessment");

        clickOn_CheckBox();

        enter_InTextArea(textAreaText);
        WebdriverWaits.waitUntilVisible(saveDraftObservationButton);
        validate_text(saveDraftObservationButton, "Save Draft Observation");

        clickOn_Complete_AssButton();
    }

    public void verify_CompleteAss() {
        clickOn_CompleteAssTab();
    }


}

