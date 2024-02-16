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

    public By avaActualText = By.xpath("(//div[@class='ng-star-inserted'])[1]");
    public By diagnostician_FirstName = By.xpath("//input[@placeholder='First Name']");
    public By diagnostician_LastName = By.xpath("//input[@placeholder='Last Name']");
    public By diagnostician_MobileNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By diagnostician_Email = By.xpath("//input[@placeholder='Email']");
    public By assignLocation = By.xpath("//select[@id='testingLocation']");
    public By locationName = By.xpath("//option[text()='Austin']");
    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createDiagnosticianButton = By.xpath("//button[text()='Create Diagnostician']");
    public By validationMsg = By.cssSelector(".alert.alert-danger.ng-star-inserted");


    public By actualText = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(2)");
    public By backButton = By.xpath("//button[text()='Back']");
    public By diagnosticianDashBoardPage = By.xpath("(//h3)[1]");
    public By back_Button = By.xpath("//button[@class='theme-button grey float-md-right mr-md-4']");


    //**************Search created diagnostician*************

    public By filterButton = By.xpath("//a[@class='theme-button grey ml-auto mr-3']");
    public By searchField = By.xpath("//input[@aria-controls='DataTables_Table_5']");
    public By searchFld=By.xpath("//input[@placeholder='Type here to search']");
    public By viewClientDetailLink = By.xpath("(//td)[6]");
    public By clientDetailText = By.xpath("//div[contains(@class,'page-header align-items-lg-center')]");
    public By clientNameText = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By clientText=By.xpath("//h3");
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


    public By appointmentsTab = By.xpath("//a[text()=' Appointments ']");
    public By viewAllTab = By.xpath("(//a)[3]");
    public By dashboard = By.xpath("//h3[text()='Dashboard']");

    public By disableButton = By.xpath("//div[@class='actions']/button[@class='theme-button grey pointer-disable float-md-right']");
    public By enableSaveButton = By.xpath("//button[@class='theme-button float-md-right green']");
    public By shiftText = By.xpath("//div[@class='mbsc-ios mbsc-popup-header mbsc-popup-header-center ng-star-inserted']");
    public By availableText = By.xpath("(//div[@class='ng-star-inserted'])[7]");
    public By upcomingTab = By.xpath("//a[text()='Upcoming']");

    public By dia_AvailSlots = By.xpath("//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted']");
public By availableSlots=By.xpath("//div[@class='mbsc-ios mbsc-schedule-event-all-day-inner mbsc-schedule-event-inner ng-star-inserted']");

//*****************Set Availability for diagnostician ****************

   public By deleteSlot =  By.xpath("//div[@class='mbsc-ios mbsc-popup-header mbsc-popup-header-center ng-star-inserted']");

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

    public By totalSlots=By.xpath("//div[@class='ng-star-inserted']");
    public By slot7 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[8]");

    public By slot11 = By.xpath("(//div[@class='mbsc-flex-1-1 mbsc-ios mbsc-ltr mbsc-timeline-column ng-star-inserted'])[12]");

    public By diagnosticianSaveButton = By.xpath("//button[text()='Save']");

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
    public By cancelTab = By.xpath("//a[text()='Canceled']");


    DashBoardPanelPage panelPage = new DashBoardPanelPage();

    public void click_createDiagnosticianButton() {
        WebdriverWaits.waitUntilVisible(createDiagnostician);
        WebdriverWaits.waitForSpinner();
        click_custom(createDiagnostician);
    }
    public void click_Back_Button() {
        click_custom(backButton);
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
    public void click_FilterButton() {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);

    }


    public void search_ClientPage(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
        String AttText = getDriver().findElement(By.xpath("//input[@id='filterSearch']")).getAttribute("placeholder");
        System.out.println(AttText);
        validate_AttText(AttText, "Type here to search");
        sendKeys_withClear(searchField, searchFieldText);
    }


    //*************search created diagnostician***************

    public void click_filterButton() {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);

        String fromDateText = getDriver().findElement(By.xpath("//input[@placeholder='From Date']")).getAttribute("placeholder");
        getAttributevalue(fromDate, "placeholder");
        validate_AttText(fromDateText, "From Date");

        String toDateText = getDriver().findElement(By.xpath("//input[@placeholder='To Date']")).getAttribute("placeholder");
        WebdriverWaits.waitUntilVisible(toDate);
        validate_AttText(toDateText, "To Date");
    }

    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(searchFld);
        sendKeys_withClear(searchFld, searchFieldText);
    }

    public void click_ViewDetailLink() {
        click_custom(viewClientDetailLink);
    }

    //+++++++++++++++++EDIT DIAGNOSTICIAN++++++++++++++

    public void click_EditButton() throws InterruptedException {
        WebdriverWaits.waitUntilVisible(editButton);
        Thread.sleep(3000);
        moveToElement(editButton);
    }

    public void enter_CellNumber(String cellNumberText) {
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void click_UpdateButton() {
        WebdriverWaits.waitUntilVisible(updateButton);
        click_custom(updateButton);
    }


    public void off_ToggleButton() throws InterruptedException {
        WebdriverWaits.waitUntilVisible(toggle);
        Thread.sleep(2000);
        click_custom(toggle);
    }

    public void enter_Diagnostician_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void click_PasswordField(String passwordTextFieldText) {
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void click_confirmPasswordFieldField(String confirmPasswordFieldText) {
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }

    public void click_DontSave() {
        WebdriverWaits.waitUntilVisible(dontSaveButton);
        click_custom(dontSaveButton);
    }

    //**********Diagnostician is viewing appointments************
    public void click_AppointmentTab() {
        moveToElement(appointmentsTab);
    }

    public void click_upcomingTab() {
        WebdriverWaits.waitUntilVisible(upcomingTab);
        moveToElement(upcomingTab);
    }


    public void create_Diagnostician(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
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
        click_createDiagnosticianButton();
    }

    public void search_CreatedDiagnostician(String UserName) {
        click_FilterButton();
        enterInSearchField(UserName);
    }

    public void serach_Dia(String diaName) {
        enterInSearchField(diaName);
    }

    public void edit_Diagnostician(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_EditButton();
        // enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        click_PasswordField(passwordTextFieldText);
        click_confirmPasswordFieldField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }

    public void cheking_DisableUser() throws InterruptedException {
        click_EditButton();
        WebdriverWaits.waitUntilVisible( enableUser);
        WebdriverWaits.waitForSpinner();
        validate_text(enableUser, "Enable User");
        click_DontSave();
        click_EditButton();
        click_DontSave();
    }

    public void disable_Diagnostician(String userNameText) throws InterruptedException {
        click_FilterButton();
        enterInSearchField(userNameText);
        Thread.sleep(2000);
        click_EditButton();
        off_ToggleButton();
    }

    public void enable_DiagnosticianUser() throws InterruptedException {
        click_EditButton();
        off_ToggleButton();
        click_UpdateButton();

    }

    public void verify_DontSave(String cellNumberText, String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_EditButton();
        enter_CellNumber(cellNumberText);
        enter_Diagnostician_Email1(EmailAddress1);
        click_PasswordField(passwordTextFieldText);
        click_confirmPasswordFieldField(confirmPasswordFieldText);
        click_DontSave();
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

    public void click_SaveButton() {
        //  click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }

    public void click_AppSaveButton() {
        click_custom(appointmentSaveButtonButton);
    }

    public void getTotalColumnCount() {
        int colCount = getColumnCount();
        int expLocatorPos = (colCount - 1) * 7 + 1;
        System.out.println(expLocatorPos);

        click_custom(clickOnBox);
    }

    public void click_AssesmentType(int assestmentTypeTexts) {

        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType, assestmentTypeTexts);
    }

    //******************Adding TestPlan for the Appointment**************

    public void click_TestPlanButton() {
        WebdriverWaits.waitUntilVisible(testPlan);
        scrollIntoView(testPlan);
        click_custom(testPlan);
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
    public void click_Availablity() {
        WebdriverWaits.waitUntilVisible(availability);
        WebdriverWaits.waitForSpinner();
        click_custom(availability);
      //  validate_text(disableButton, "Save");
    }

    public void click_Slot(int count) throws InterruptedException {
        // use logic??

        Thread.sleep(5000);
        List<WebElement> slots = getWebElements(dia_AvailSlots, "Diagnostician Available slots");
        System.out.println(slots.size());
        for (WebElement slot : slots) {
            Thread.sleep(2000);
            moveToEleByWE(slot);
            if (getWebElements(totalSlots).size() > count) {
                break;
            }
        }

        WebdriverWaits.waitUntilVisible(enableSaveButton);
        validate_text(enableSaveButton, "Save");

        click_custom(diagnosticianSaveButton);
        // click_custom(logOutLink);
    }

    public void click_Delete() {
        click_custom(delete);
    }

    public void set_Availability() throws InterruptedException {
        click_Availablity();
        click_Slot(3);
    }

    //**************Diagnostician Started Assessment***************
    public void click_TodasTab() {
        WebdriverWaits.waitForSpinner();
        click_custom(todaysTab);
    }

    public void click_ViewDetails() {
        WebdriverWaits.waitForSpinner();
        click_custom(viewDetails);
    }

    public void click_StartAssButtn() {
        WebdriverWaits.waitUntilVisible(startAssButtn);
        scrollIntoView(startAssButtn);
        click_custom(startAssButtn);
    }

    public void enter_LowAmount() throws InterruptedException {
        String Inr = getText_custom(inr).replace("$", "");
        double amount = parseDouble(Inr);
        double value = amount - 20;
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

    public void click_CollectButton() {
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

    public void click_CheckBox() {
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

    public void click_Complete_AssButton() {
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

    //************diagnostician verifying complete assessment*************

    public void click_CompleteAssTab() {
        click_custom(testComTab);
    }


    //================///////////=========================


    public void appointmentDateSelecting(int Type) {
        getTotalColumnCount();
        click_SaveButton();
        click_AppSaveButton();
        click_AssesmentType(Type);
    }

    public void login_As_Diagnostician(String UserName, String PasswordText) {
        enter_UserName(UserName);
        enter_Password(PasswordText);
        click_LoginButton();
    }

    public void deleting_Availability() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> slots = getWebElements(availableSlots, "Diagnostician Available slots");
        System.out.println(slots.size());
        for (WebElement slot : slots) {
            Thread.sleep(2000);
            moveToEleByWE(slot);

            if (isElementDisplay_custom(deleteSlot,"Slots Name")) {
                Thread.sleep(4000);
                String getText = getText_custom(shiftText);
                WebdriverWaits.waitUntilVisible(shiftText);
                validate_text(shiftText, getText);
                break;
            }
        }
        click_Delete();
        WebdriverWaits.waitUntilVisible(diagnosticianSaveButton);
        click_custom(diagnosticianSaveButton);
    }

    public void cancel_Availability() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> slots = getWebElements(availableSlots, "Diagnostician Available slots");
        System.out.println(slots.size());
        for (WebElement slot : slots) {
            Thread.sleep(2000);
            moveToEleByWE(slot);
            WebElement cancelSlot=getDriver().findElement(By.xpath("//div[@class='mbsc-ios mbsc-popup-header mbsc-popup-header-center ng-star-inserted']"));
            if (cancelSlot.isDisplayed()) {
                Thread.sleep(4000);
                String getText = getText_custom(shiftText);
                WebdriverWaits.waitUntilVisible(shiftText);
                validate_text(shiftText, getText);
                WebdriverWaits.waitUntilVisible(cancel);
                click_custom(cancel);
                break;
            }
        }
        click_custom(diagnosticianSaveButton);
    }

    public void view_ClientDetail(String clientLastName) {

        enterInSearchField(clientLastName);
        click_ViewDetailLink();
    }

    public void enter_ClientDetail(String clientLastName) {
        enterInSearchField(clientLastName);
        click_ViewDetailLink();
    }

//**************Diagnostician Started Assessment***************

    public void payment_NewPage() {
        click_TodasTab();
        click_ViewDetails();
        click_StartAssButtn();
    }
        //****************This Test case is removed *************



    public void start_Assessment_ByPaying_LessAmount(String textAreaText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(paymentDetailTitle);
        validate_text(paymentDetailTitle, "Payment Details");

        enter_LowAmount();
        WebdriverWaits.waitUntilVisible(collectButn);
        validate_text(collectButn, "Collect");

        click_CollectButton();
        WebdriverWaits.waitUntilVisible(pageTitle);
        validate_text(pageTitle, clientFirstName + ' ' + clientLastName + ' ' + "Assessment");

        click_CheckBox();

        enter_InTextArea(textAreaText);
        WebdriverWaits.waitUntilVisible(saveDraftObservationButton);
        validate_text(saveDraftObservationButton, "Save Draft Observation");

        click_Complete_AssButton();
    }

    public void verify_CompleteAss() {
        click_CompleteAssTab();
    }

    public void click_CancelTab() {
        WebdriverWaits.waitUntilVisible(cancelTab);
        WebdriverWaits.waitForSpinner();
        moveToElement(cancelTab);
    }


}

