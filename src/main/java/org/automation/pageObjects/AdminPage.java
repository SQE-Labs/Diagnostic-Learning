package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.automation.utilities.Assertions.validate_AttText;
import static org.automation.utilities.Assertions.validate_text;
import static org.automation.utilities.WebdriverWaits.*;
import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.WebdriverWaits.moveToElement;
import static test.AdminTest.clientFirstName;

public class AdminPage extends BasePage {


    AppointmentsPage appointment = new AppointmentsPage();
    SuperAdminPage superAdmin = new SuperAdminPage();
    DashBoardPanelPage dashboardPanelPage = new DashBoardPanelPage();

    PaymentPage payment = new PaymentPage();


    public By adminDashboardText = By.xpath("//h3[text()='Dashboard']");
    public By createAdminButton = By.xpath("//button[@class='theme-button']");

    public By admin_FirstName = By.xpath("//input[@placeholder='First Name']");
    public By admin_LastName = By.xpath("//input[@placeholder='Last Name']");
    public By admin_MobileNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By admin_Email = By.xpath("//input[@placeholder='Email']");
    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password_Field = By.xpath("//input[@placeholder='Create Password']");
    public By diagList = By.xpath("(//span[text()='Active'])/../../td[text()='Plano']/../td[1]");
    public By confirm_PasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    public By createadminButton = By.xpath("//button[@class='theme-button float-md-right']");
    public By succ_Msg = By.xpath("//div[@class='alert alert-success ng-star-inserted']");
    public By dashboardPage = By.xpath("//h3");
    public By searchButton = By.xpath("//button[@class='theme-button']");

    //**************Search created Admin*************

    public By filterButton = By.xpath("//a[@class='theme-button grey ml-auto mr-3']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By actualText = By.xpath("(//td)[2]");
    public By viewStudentObservationButton= By.xpath("//a[@class='theme-button green ml-2 ng-star-inserted']");


    //*****************Edit Admin with valid credentials****************
    public By editButton = By.xpath("(//a[text()='Edit'])[1]");

    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By Succ_Msg_Upd = By.xpath("//div[text()=' Admin details updated successfully. ']");

    public By enableUser = By.xpath("//label[text()='Enable User']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton = By.xpath("//a[@class='theme-button grey']");
    public By editUserPop_Up = By.xpath("//h5[text()='Edit User']");
    public By userNameText = By.xpath("(//td[2])[1]");
    public By Error_Msg = By.cssSelector(".alert.alert-danger.ng-star-inserted");

    //***********DASH BOARD PAGE**********
    public By dashboard = By.xpath("(//h3)[1]");
    //*********** EDIT ASSESSMENT TYPE ********//
    public By editAss = By.xpath("(//a[contains(@class,'ml-auto mr-3 px-3 py-2 badge')])[2]");
    public By assType = By.xpath("(//h5[@class='border-bottom mb-3 pb-3 text-center text-green'])[2]");
    public By editAssestmentButton = By.xpath("(//a[@class='ml-auto mr-3 px-3 py-2 badge bg-purple text-white float-md-right ng-star-inserted'])[2]");
    public By assesmentType = By.xpath("//select[@id='assesmentType']");
    public By updateBtn = By.xpath("//button[@class='theme-button mr-3']");
    public By clientAsses = By.xpath("//p[text()=' IQ']");


    //***********Re-assign appointment************//
    public By reAssignbtn = By.xpath("(//a[contains(@class,'ml-auto mr-3 px-3 py-2 badge')])[1]");
    public By diag = By.id("diag");

    public By rebtn = By.xpath("//button[@class='theme-button green']");

    //****************Edit Client**************//
    public By testPlan = By.xpath("(//button[@class='theme-button m-2 ng-star-inserted'])[1]");
    public By editTestPlan = By.xpath("//button[text()=' Edit Test Plan ']");
    public By testPlanText = By.xpath("//h6[text()='Please choose tests.']");
    public By checkBox = By.xpath("//label[text()='WJ Achievement']/..");
    public By validateCheckBox = By.xpath("//p[text()=' WJ Achievement ']");
    public By famCheckBox = By.xpath("//label[text()='FAM']/..");
    public By nepsyCheckBox = By.xpath("//label[text()='NEPSY']/..");
    public By ndCheckBox = By.xpath("//label[text()='ND']/..");
    public By wmsCheckBox = By.xpath("//label[text()='WMS']/..");
    public By warlCheckBox = By.xpath("//label[text()='WRAML']/..");
    public By bascSelfCheckBox = By.xpath("//label[text()='BASC Self']/..");
    public By cbrsSelfCheckBox = By.xpath("//label[text()='CBRS Self']/..");
    public By dlsDyslexiaCheckBox = By.xpath("//label[text()='DLS Dyslexia']/..");
    public By testPlanSaveButton = By.xpath("//button[text()='Save']");
    public By actualEditTest = By.xpath("//p[text()=' WRAML ']");
    public By editClientBtn = By.xpath("//a[text()='Edit Client']");
    public By editCllientActualText = By.xpath("//h5[text()='Edit Client Info']");
    public By editFirstName = By.xpath(" //input[@formcontrolname='studentFirstName']");
    public By editLastName = By.xpath(" //input[@formcontrolname='studentLastName']");


    public By editGrade = By.id("schoolType");

    public By editAddress1 = By.xpath(" //input[@formcontrolname='address1']");

    public By editUpdateBtn = By.id("intakeFormSubmit");
    public By actualTextClient = By.xpath("//p[text()=' College']");
    public By followUp = By.xpath("//a[text()=' Create Follow Up ']");
    public By followUpSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[7]");
    public By followUpSlots = By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']");
    public By slotSaveBtn = By.xpath("//mbsc-button[text()=' Save ']");
    public By followUpSaveBtn = By.xpath("//a[text()='Save']");
    public By confirmBtn = By.xpath("//a[text()='Confirm']");
    public By validateScheduledFollowUp = By.xpath("//h4[text()='Follow Up Scheduled!!']");
    public By followUpBackBtn = By.xpath("(//a[text()='Back'])[3]");

    public By backButn = By.xpath("//a[@class='grey ml-3 theme-button']");
    //*************************** Payment PopUp **************************//
    public By paymentBtn = By.xpath("//button[text()=' Payment ']");

    public By collectPayActualText = By.xpath("//h4[text()='Collect Payment']");
    public By testFeeAdjustmentAmt = By.xpath("(//input[@class='custom-input my-1 ng-untouched ng-pristine ng-valid'])[1]");
    public By collectFeeAmt = By.xpath("//input[@class='custom-input my-1 ng-untouched ng-pristine ng-valid']");
    public By enterAmt = By.id("bookingDeposit");
    public By collectPayBtn = By.xpath("//button[@class='theme-button mx-2']");

    public By closebtn = By.xpath("(//a[text()='Close'])[2]");
    public By amountDue = By.xpath("//label[text()='Amount Due']//following-sibling::p");
    public By assessmentAmount = By.xpath("//label[text()='Assessment Amount']//following-sibling::p");
    public By receivedAmount = By.xpath("//label[text()='Received Amount']//following-sibling::p");

    public By holdButton = By.xpath("//button[text()=' Hold Appointment ']");
    public By holdActualText = By.xpath("(//h6[@class='mb-4 text-center'])[2]");

    public By allAppointmentsPage = By.xpath("//h3[text()='All Appointments']");
    public By holdAppointmentBtn = By.xpath("//button[text()='Yes, Hold']");
    public By holdtab = By.xpath("//a[text()='Hold']");
    public By holdAppointmentText = By.xpath("//h3[text()='Hold Appointments']");
    public By holdfilterButton = By.xpath("//a[text()='Filter']");
    public By searchTextBox = By.id("filterSearch");
    public By toDateText = By.xpath("//input[@formcontrolname='toDate']");
    public By fromDateText = By.xpath("//input[@formcontrolname='fromDate']");
    public By validateHoldClient = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(3)");
    public By unHoldBtn = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(7)");
    public By yesUnholdButton = By.xpath("//button[@class='theme-button danger mx-2']");

    //*******************Paying full payment by client****************

    public By appointmentTab = By.xpath("//a[text()=' Appointments ']");
    public By testCompleteTab = By.xpath("//a[text()='Test complete']");
    public By clientDetailLink = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(7)");
    public By paymentButton = By.xpath("//button[@class='theme-button green m-2 ng-star-inserted']");
    public By inr = By.xpath("(//td)[10]");
    public By amountField = By.xpath("//input[@id='bookingDeposit']");
    public By collectButton = By.xpath("//button[@class='theme-button mx-2']");
    public By cancelButton = By.xpath("(//a[@class='theme-button grey'])[4]");
    public By clientNameDetail = By.xpath("//h3");


    public By cancelTab = By.xpath("//a[text()='Canceled']");
    public By clientName = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By uploadDocumentButton = By.xpath("//button[@class='theme-button m-2 ng-star-inserted']");
    public By uploadButton = By.xpath("//button[@class='theme-button mx-2']");
    public By chooseField = By.xpath("//input[@placeholder='select document to be uploaded']");
    public By closeButton = By.xpath("//a[text()='Close']");
    public By viewRecCloseButton = By.xpath("(//a[@class='theme-button grey mx-2'])[4]");

    public By todayAppointmentTitle = By.xpath("//div[@class='align-items-md-center d-flex flex-column flex-md-row page-header']/h3");
    public By card = By.xpath("(//td[@class='d-block ng-star-inserted'])[1]");
    public By nameOnCard = By.xpath("(//p[@class='text-purple mb-0'])[1]");


    public By todayDateOnCard = By.xpath("//span[@class='text-grey']");

    public By getTestReadyTitle = By.xpath("//div[@class='align-items-md-center d-flex flex-column flex-md-row page-header']/h3");


    public By titleOfUpcomingPage = By.xpath("//div[@class='page-header align-items-lg-center d-flex flex-column flex-md-row']/h3");


    public By getStatus = By.xpath("(//tr[not(contains(@style,'display: none;'))])[2]//span");

    public By getViewDetails = By.xpath("(//tr[not(contains(@style,'display: none;'))])[2]//a");

    public By getNameOfClient = By.xpath("((//tr[not(contains(@style,'display: none;'))])[2]//td)[1]");

    public By getTitleOfTestComplete = By.xpath("//div[@class='page-header align-items-lg-center d-flex flex-column flex-md-row']/h3");

    public By getTitleOfAttachedDocument = By.xpath("//h5[@class='text-center mb-4']");
    public By testReadyTab = By.xpath("//a[text()='Test Ready']");
    public By todaysTab = By.xpath("//a[text()='Today']");



    public By getTextFromViewDoc = By.xpath("//a[@class='d-block px-3 py-2 small text-dark']");

    public By getTextFromViewDocTwo = By.xpath("//a[@class='d-flex px-3 py-2 small text-dark text-left text-wrap']");

    public By closeIcon = By.xpath("//button[@aria-label='Close']/span");


    public By title = By.xpath("//h3");

    public By clientNameCompleted = By.xpath("((//tr[not(contains(@style,'display: none;'))])[2]/td)[1]");
    public By unoldBackBtn = By.xpath("//a[@class='theme-button grey mx-2']");

    public By titleOfViewReceipt = By.xpath("//h4[@class='text-center ng-star-inserted']");

    //**************************Send recipts****************************

    public By sendReciptButton = By.xpath("(//button[@class='theme-button green m-2 ng-star-inserted'])[1]");
    public By typesOfEvolution = By.xpath("(//select)[5]");
    public By dysgraphia = By.xpath("//option[@value='Dysgraphia']");
    public By secondaryProvider = By.xpath("(//select)[6]");
    public By name = By.xpath("//option[@value='AU_Ayladrr AU_AriQAz']");
    public By primaryDia = By.xpath("(//select)[7]");
    public By diaName = By.xpath("(//option[@value='DSM-V-314.01 - ADHD Combined ICD10-F90.2'])[1]");
    public By secondaryDia = By.xpath("(//select)[8]");
    public By secDiaName = By.xpath("(//option[@value='DSM-V-314.01 - ADHD Combined ICD10-F90.2'])[2]");
    public By tertiaryDia = By.xpath("(//select)[9]");
    public By terDiaName = By.xpath("(//option[@value='DSM-V-314.01 - ADHD Combined ICD10-F90.2'])[3]");
    public By sendButton = By.xpath("//button[@class='theme-button mx-2 ng-star-inserted']");
    public By viewDocumentsButton = By.xpath("//a[@class='ml-auto ml-2 theme-button green']");
    public By viewDocumentBtn = By.xpath("//a[@class='ml-2 theme-button green ng-star-inserted']");

    //******************Verifying cancelled appointments*****************


    public void click_createAdminButton() {
        WebdriverWaits.waitUntilVisible(createAdminButton);
        WebdriverWaits.waitForSpinner();
        click_custom(createAdminButton);
    }

    public void enter_admin_FirstName(String CustomerFirstName) {

        sendKeys_withClear(admin_FirstName, CustomerFirstName);
    }


    public void enter_admin_LastName(String CustomerLastName) {
        sendKeys_withClear(admin_LastName, CustomerLastName);
    }

    public void enter_admin_MobileNumber(String diagnostician_MobileNumberText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(admin_MobileNumber);
        click_custom(admin_MobileNumber);
        Thread.sleep(2000);
        sendKeys_withClear(admin_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_admin_Email(String diagnostician_EmailText) {
        sendKeys_withClear(admin_Email, diagnostician_EmailText);
    }

    public void userNameField(String userNameText) {
        WebdriverWaits.waitUntilVisible(userName);
        sendKeys_withClear(userName, userNameText);
    }

    public void create_passwordField(String passwordFieldText) {
        sendKeys_withClear(password_Field, passwordFieldText);
    }


    public void confirm_PasswordField(String confirmPasswordText) {
        sendKeys_withClear(confirm_PasswordField, confirmPasswordText);
    }

    public List<WebElement> get_diagList(By Path) {
        List<WebElement> list = getWebElements(Path);
        return list;
    }

    public boolean compare_DiagAndReAssignDiagList(List<WebElement> list1, List<WebElement> list2) {
        click_Re_AssigDropDown();
        if (list1.size() != list2.size()) {
            return false;
        }
        System.out.println(list1.size());
        System.out.println(list2.size());

        for (int i = 0; i < list1.size(); i++) {
            WebElement element1 = list1.get(i);
            System.out.println(list1.get(i));
            WebElement element2 = list2.get(i);
            System.out.println(list2.get(i));

            // Compare based on text, can be changed to any other attribute like element1.getAttribute("id")
            if (!element1.getText().equals(element2.getText())) {
                return false;
            }
        }
        return true;
    }

    public void click_createadminButton() {
        click_custom(createadminButton);
    }

    //*******************SuperAdmin  searching created admin******************


    public void click_filterButton() {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }

    public void click_SearchButton() {
        WebdriverWaits.waitUntilVisible(searchButton);
        click_custom(searchButton);
    }

    //+++++++++++++++++EDIT Admin++++++++++++++

    public void click_EditButton() {
        WebdriverWaits.waitUntilVisible(editButton);
        WebdriverWaits.waitForSpinner();
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
        WebdriverWaits.waitUntilVisible(emailField);
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void click_PasswordField(String passwordTextFieldText) {
        WebdriverWaits.waitUntilVisible(passwordTextField);
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordFieldField(String confirmPasswordFieldText) {
        WebdriverWaits.waitUntilVisible(confirmPasswordField);
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }

    public void click_DontSave() {
        WebdriverWaits.waitUntilVisible(dontSaveButton);
        WebdriverWaits.waitForSpinner();
        click_custom(dontSaveButton);
    }

    public void click_UploadButton() {
        WebdriverWaits.waitUntilVisible(uploadDocumentButton);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(uploadDocumentButton);
        click_custom(uploadDocumentButton);
    }

    public void click_UploadButtons() {
        click_custom(uploadButton);
    }

    public void click_CloseButton() {
        waitUntilVisible(closeButton);
        click_custom(closeButton);
    }

    public void click_ChooseFile() {
        WebdriverWaits.waitUntilVisible(chooseField);
        WebdriverWaits.waitForSpinner();
        moveToElement(chooseField);
    }

    public void enter_InSearchField(String clientName) {
        enterInSearchField(clientName);
        click_SearchButton();
    }

    public void click_CancelTab() {
        WebdriverWaits.waitUntilVisible(cancelTab);
        WebdriverWaits.waitForSpinner();
        moveToElement(cancelTab);
    }

    public void upload_FileAttachment() throws InterruptedException, AWTException {
        click_UploadButton();
        click_ChooseFile();
        Thread.sleep(5000);
        String filepath = "Downloads\\33200_1911.pdf";
        ChromeDownloads.uploadFileUsingRobot(filepath);
        click_UploadButtons();
        click_CloseButton();
    }

    public void verifySearchTextBox() {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
        String AttText = getDriver().findElement(By.xpath("//input[@id='filterSearch']")).getAttribute("placeholder");
        System.out.println(AttText);
        validate_AttText(AttText, "Type here to search");
    }


    //****************SuperAdmin creating Admin***********************
    public void create_Admin(String CustomerFirstName, String CustomerLastName, String diagnostician_MobileNumberText, String EmailAddress, String UserName, String PasswordText, String RePassword) throws InterruptedException {
        click_createAdminButton();
        enter_admin_FirstName(CustomerFirstName);
        enter_admin_LastName(CustomerLastName);
        enter_admin_MobileNumber(diagnostician_MobileNumberText);
        enter_admin_Email(EmailAddress);

        userNameField(UserName);
        create_passwordField(PasswordText);
        confirm_PasswordField(RePassword);
        click_createadminButton();
    }
//*******************SuperAdmin  searching created admin******************

    public void search_CreatedAdmin(String UserName) {
        click_filterButton();
        enterInSearchField(UserName);
    }

    //******************EDIT ADMIN****************

    public void edit_Admin(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_EditButton();
        WebdriverWaits.waitUntilVisible(editUserPop_Up);
        validate_text(editUserPop_Up, "Edit User");

        enter_Admin_Email1(EmailAddress1);
        click_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }
    //************Checking toggle of or not*************

    public void cheking_DisableUser() throws InterruptedException {
        click_EditButton();
        click_DontSave();
        Thread.sleep(2000);
        click_EditButton();
        click_DontSave();
    }

    //**********Enable user In Admin************
    public void enable_Admin() {
        click_EditButton();
        off_ToggleButton();
        click_UpdateButton();
    }

    //************Verify dontsave button******************

    public void verify_DontSave(String adminEmailAddress, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_EditButton();
        enter_Diagnostician_Email1(adminEmailAddress);
        click_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        click_DontSave();
    }

    public void click_EditAssessment() {
        WebdriverWaits.waitUntilVisible(editAss);
        WebdriverWaits.waitForSpinner();
        click_custom(editAss);
    }

    public void click_UpdateBtn() {
        WebdriverWaits.waitUntilVisible(updateBtn);
        click_custom(updateBtn);
    }

    public void edit_AssessmentType(String assestmentTypeTexts) {
        WebdriverWaits.waitUntilVisible(editAssestmentButton);
        WebdriverWaits.waitForSpinner();
        moveToElement(editAssestmentButton);
        WebdriverWaits.waitUntilVisible(assesmentType);
        click_custom(assesmentType);
        selectDropDownByVisibleText_custom(assesmentType, assestmentTypeTexts);
    }


    //********* Re-assign appointment page ******//
    public void click_ReAssignBtn() {
        WebdriverWaits.waitUntilVisible(reAssignbtn);
        click_custom(reAssignbtn);
    }

    public void re_AssignDiag(int chooseDiagnostician) {
        WebdriverWaits.waitUntilVisible(diag);
        WebdriverWaits.waitForSpinner();
        clickBtn_custom(diag, "chooseDiagnostician");
        selectDropDownByIndex_custom(diag, chooseDiagnostician, "Choose Diagnostician");
    }

    public void click_ReAssignBn() {
        WebdriverWaits.waitUntilVisible(rebtn);
        click_custom(rebtn);
    }

    public void click_TestPlan() {
        WebdriverWaits.waitUntilVisible(testPlan);
        click_custom(testPlan);
    }

    public void select_TestPlan() {
        click_custom(checkBox);
        click_custom(famCheckBox);
        click_custom(nepsyCheckBox);
        click_custom(ndCheckBox);
        click_custom(wmsCheckBox);
        click_custom(bascSelfCheckBox);
        click_custom(cbrsSelfCheckBox);
        click_custom(dlsDyslexiaCheckBox);
    }

    public void click_EditTestPlan() {
        click_custom(editTestPlan);
    }

    public void edit_TestPlan() {
        click_EditTestPlan();
        click_custom(warlCheckBox);
        click_TestPlanSaveButton();
    }

    public void click_TestPlanSaveButton() {
        click_custom(testPlanSaveButton);
    }

    public void click_EditClientBtn() {
        WebdriverWaits.waitUntilVisible(editClientBtn);
        scrollIntoView(editClientBtn);
        click_custom(editClientBtn);
    }

    //*********** Edit Client Info **********//
    public void enter_FirstName(String firstName) {
        WebdriverWaits.waitUntilVisible(editFirstName);
        sendKeys_withClear(editFirstName, firstName);
    }

    public void enter_LastName(String lastName) {
        WebdriverWaits.waitUntilVisible(editLastName);
        sendKeys_withClear(editLastName, lastName);
    }

    public void enter_grade(String grade) {
        WebdriverWaits.waitUntilVisible(editGrade);
        WebdriverWaits.waitUntilVisible(editGrade);
        click_custom(editGrade);
        selectDropDownByVisibleText_custom(editGrade, grade);
    }

    public void enter_Address1(String address) {
        WebdriverWaits.waitUntilVisible(editAddress1);
        sendKeys_withClear(editAddress1, address);
    }

    public void click_HoldAppointmentBtn() {
        WebdriverWaits.waitUntilVisible(holdButton);
        click_custom(holdButton);
    }

    public void click_yesHoldBtn() {
        WebdriverWaits.waitUntilVisible(holdAppointmentBtn);
        click_custom(holdAppointmentBtn);
    }

    public void click_HoldTab() {
        WebdriverWaits.waitUntilVisible(holdtab);
        WebdriverWaits.waitForSpinner();
        click_custom(holdtab);
    }

    public void click_HoldFilterBtn() {
        WebdriverWaits.waitUntilVisible(holdfilterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(holdfilterButton);
    }

    public void send_TextHoldSearchBox(String name) {
        sendKeys_custom(searchTextBox, name);
    }

    public void click_unHoldBtn() throws InterruptedException {
        WebdriverWaits.waitUntilVisible(unHoldBtn);
        click_custom(unHoldBtn);
        WebdriverWaits.waitUntilVisible(yesUnholdButton);
        click_custom(yesUnholdButton);
        Thread.sleep(4000);
    }

    public String edit_ClientInfo(String firstName, String lastName, String address1, String grade) {
        String fullName = firstName + " " + lastName;
        enter_FirstName(firstName);
        enter_LastName(lastName);
        enter_Address1(address1);
        enter_grade(grade);
        return fullName;
    }


    public void click_UpdateClientBtn() {
        click_custom(editUpdateBtn);
    }

    public void click_CreateFollowUpBtn() {
        WebdriverWaits.waitUntilVisible(followUp);
        WebdriverWaits.waitForSpinner();
        click_custom(followUp);
    }

    public void click_FollowUpSlot() {
        WebdriverWaits.waitUntilVisible(followUpSlot);
        WebdriverWaits.waitForSpinner();
        List<WebElement> slots = getWebElements(followUpSlots, "followUpSlots");
        for (WebElement slot : slots) {
            click_custom(slot);
            if (getDriver().findElements(By.xpath("(//div[@class='ng-star-inserted'])[2]")).size() > 0) {
                break;
            }
        }
    }

    public void click_FollowUpSlotSaveBtn() {
        WebdriverWaits.waitUntilVisible(slotSaveBtn);
        click_custom(slotSaveBtn);
    }

    public void click_FollowUpSaveBtn() {
        WebdriverWaits.waitUntilVisible(followUpSaveBtn);
        click_custom(followUpSaveBtn);
    }

    public void click_ConfirmFollowUpBtn() {
        WebdriverWaits.waitUntilVisible(confirmBtn);
        click_custom(confirmBtn);
    }

    public void click_BackBtn() {
        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(followUpBackBtn);
        click_custom(followUpBackBtn);
    }

    public void click_BackButton() {
        click_custom(backButn);
    }

    public void create_FollowUp() {
        click_CreateFollowUpBtn();
        click_FollowUpSlot();
        click_FollowUpSlotSaveBtn();
        click_FollowUpSaveBtn();
        click_ConfirmFollowUpBtn();
    }

    public void change_FollowUp() throws InterruptedException {
        click_CreateFollowUpBtn();
        click_FollowUpSlot();
        click_FollowUpSlotSaveBtn();
    }

    public void click_PaymentBtn() {
        WebdriverWaits.waitUntilVisible(paymentBtn);
        click_custom(paymentBtn);
    }

    public void click_CloseBtn() {
        WebdriverWaits.waitUntilVisible(closebtn);
        click_custom(closebtn);
    }

    public void click_CollectBtn() {
        click_custom(collectPayBtn);
    }

    public String get_AmountDue() {
        WebdriverWaits.waitUntilVisible(amountDue);
        return getText_custom(amountDue).replace("$", "");
    }

    public String get_AssessmentAmount() {
        WebdriverWaits.waitUntilVisible(assessmentAmount);
        return getText_custom(assessmentAmount).replace("$", "");
    }

    public String get_ReceivedAmount() {
        WebdriverWaits.waitUntilVisible(receivedAmount);
        return getText_custom(receivedAmount).replace("$", "");
    }

    public void enter_FeeAdjustmentAmount(String amount) {
        WebdriverWaits.waitUntilVisible(testFeeAdjustmentAmt);
        click_custom(testFeeAdjustmentAmt);
        sendKeys_custom(testFeeAdjustmentAmt, amount);
    }

    public void validate_FeeAdjustmentAmount(String amount) {
        enter_FeeAdjustmentAmount(amount);
    }

    public void enter_CollectAmiuntAdjustment(String amount) {
        WebdriverWaits.waitUntilVisible(collectFeeAmt);
        click_custom(collectFeeAmt);
        sendKeys_custom(collectFeeAmt, amount);
    }

    public void validate_CollectAmountAdjustment(String amount) {
        enter_CollectAmiuntAdjustment(amount);
        enter_Amount(amount);
        click_CollectBtn();
        click_CloseBtn();
    }

    public void enter_Amount(String amount) {
        WebdriverWaits.waitUntilVisible(enterAmt);
        sendKeys_custom(enterAmt, amount);
    }

    //*******************Paying full payment by client**************
    public void clickOn_AppointmentTab() {
        WebdriverWaits.waitUntilVisible(appointmentTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointmentTab);
        WebdriverWaits.waitUntilVisible(testCompleteTab);
        WebdriverWaits.waitForSpinner();
        click_custom(testCompleteTab);
    }

    public void clickOnAppointmentTab() {
        WebdriverWaits.waitUntilVisible(appointmentTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointmentTab);
    }

    public void filter_ForUpcoming(String upcomingText) {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
        sendKeys_withClear(searchField, upcomingText);
    }

    public void click_Re_AssigDropDown() {
        WebdriverWaits.waitUntilVisible(diag);
        click_custom(diag);
    }

    public void enter_ClientName(String clientText) {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
        sendKeys_withClear(searchField, clientText);
    }

    public void clickOn_ViewDetailLink() {
        click_custom(clientDetailLink);
        WebdriverWaits.waitUntilVisible(paymentButton);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(paymentButton);
        click_custom(paymentButton);
    }

    public void enter_ValidAmount() throws InterruptedException {
        String Inr = getText_custom(inr).replace("$", "");
        Thread.sleep(6000);
        sendKeys_withClear(amountField, Inr);
    }

    public void clickOn_CollectButton() {
        click_custom(collectButton);
    }

    public void clickOn_CancelButton() {
        WebdriverWaits.waitUntilVisible(cancelButton);
        click_custom(cancelButton);
    }


    //*************************send recipt******************

    public void click_SendReciptButton() {
        WebdriverWaits.waitForSpinner();
        scrollIntoView(sendReciptButton);
        click_custom(sendReciptButton);
        click_custom(typesOfEvolution);
        click_custom(dysgraphia);
        click_custom(secondaryProvider);
        click_custom(primaryDia);
        click_custom(diaName);
        click_custom(secondaryDia);
        click_custom(secDiaName);
        click_custom(tertiaryDia);
        click_custom(terDiaName);
        scrollIntoView(sendButton);
        click_custom(sendButton);
    }

    //*****************Doing full payment by client********************


    public void paying_DueAmount(String clientText) throws InterruptedException {
        Thread.sleep(4000);
        clickOn_AppointmentTab();
        enter_ClientName(clientText);
        Thread.sleep(2000);
        clickOn_ViewDetailLink();

        enter_ValidAmount();
        clickOn_CollectButton();
        clickOn_CancelButton();
    }

    public void verify_CancelledApp(String clientName) {
        click_CancelTab();
        verifySearchTextBox();
        enterInSearchField(clientName);
    }

    public void clickOn_TodayTab() {
        WebdriverWaits.waitUntilVisible( todaysTab);
        WebdriverWaits.waitForSpinner();
        click_custom( todaysTab);
    }

    public void clickOn_TestReadyTab() {
        WebdriverWaits.waitUntilVisible(testReadyTab);
        click_custom(testReadyTab);
    }

    public void clickOn_UpcomingTab() {
        WebdriverWaits.waitUntilVisible(appointment.upcomingTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointment.upcomingTab);
    }

    public void clickOn_Card() {
        WebdriverWaits.waitUntilVisible(card);
        click_custom(card);
    }

    public void enterClientNameInSearchField(String nameOfClients) {
        click_custom(filterButton);
        sendKeys_withClear(searchTextBox, nameOfClients);
    }

    public void enterClientNameInSearchFieldCompleted(String nameOfClient) {
        sendKeys_withClear(searchTextBox, nameOfClient);
    }

    public void clickOn_ExportCSVButtonOfTestComplete() {
        click_custom(dashboardPanelPage.exportCSVButton);
    }

    public void click_ViewDetailsBtn() {
        WebdriverWaits.waitUntilVisible(getViewDetails);
        click_custom(getViewDetails);
    }


    public void click_ViewDocumentsButton() {
        WebdriverWaits.waitUntilVisible(viewDocumentsButton);
        click_custom(viewDocumentsButton);
    }


    public void click_FilterBtn() {
        click_custom(filterButton);
    }
    public void click_ViewObservationBtn() {
        WebdriverWaits.waitUntilVisible(viewStudentObservationButton);
        click_custom(viewStudentObservationButton);
    }
    public void click_ViewDocumentButton() {
        WebdriverWaits.waitUntilVisible(viewDocumentBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(viewDocumentBtn);
    }


    public void clickOn_CloseIcon() {
        WebdriverWaits.waitUntilVisible(closeIcon);
        WebdriverWaits.waitForSpinner();
        click_custom(closeIcon);
    }

    public void viewReceiptButtonDisplayed() {
        WebdriverWaits.waitUntilVisible(payment.viewReceiptButton);
        WebdriverWaits.waitForSpinner();
        click_custom(payment.viewReceiptButton);
    }

    public void viewReceiptButtonNotDisplayed() {
        WebdriverWaits.waitUntilVisible(payment.paymentButton);
        WebdriverWaits.waitForSpinner();
        click_custom(payment.paymentButton);
    }

    public void clickOn_CloseBtn() {
        scrollIntoView(viewRecCloseButton);
        WebdriverWaits.waitUntilVisible(viewRecCloseButton);
        WebdriverWaits.waitForSpinner();
        click_custom(viewRecCloseButton);
    }

    public void clickOn_CollectBtn() {
        WebdriverWaits.waitUntilVisible(payment.collectButton);
        WebdriverWaits.waitForSpinner();
        click_custom(payment.collectButton);
    }


    public void send_AmountInEnterAmount(String amount) {
        WebdriverWaits.waitUntilVisible(payment.enterAmountField);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(payment.enterAmountField, amount);
    }

    public void scrollUptoVAmountDue() {
        WebdriverWaits.waitUntilVisible(payment.amountDue);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(payment.amountDue);
    }







    public void view_AllAppointmentPage() {
        enterClientNameInSearchField(clientFirstName);
    }
}

