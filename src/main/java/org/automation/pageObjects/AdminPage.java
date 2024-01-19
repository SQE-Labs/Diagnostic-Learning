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

public class AdminPage extends BasePage {
    public By adminTab = By.xpath("//a[text()='Admins']");
    public By adminDashboardText = By.xpath("//h3[text()='Dashboard']");
    public By createAdminButton = By.xpath("//button[@class='theme-button']");
    public By loginLoading = By.cssSelector("div.ngx-spinner-overlay");
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

    //**************Search created Admin*************

    public By filterButton = By.xpath("//a[@class='theme-button grey ml-auto mr-3']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By actualText = By.xpath("(//td)[2]");

    //*****************Edit Admin with valid credentials****************
    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By enableToggle = By.xpath("//label[text()='Enable User']");

    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By Succ_Msg_Upd = By.xpath("//div[text()=' Admin details updated successfully. ']");
    public By UserNameGetText = By.xpath("(//td)[2]");
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
    public By assestmentType = By.xpath("//select[@id='assesmentType']");
    public By updateBtn = By.xpath("(//button[@class='theme-button mr-3 grey'])[2]");
    public By clientAsses = By.xpath("//p[text()=' IQ']");
    public By dontSaveAsses = By.xpath("//a[text()='Don’t Save']");

    //***********Re-assign appointment************//
    public By reAssignbtn = By.xpath("(//a[contains(@class,'ml-auto mr-3 px-3 py-2 badge')])[1]");
    public By diag = By.id("diag");
    public By diagLoc = By.id("testingLocation");
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

    public By docgList = By.xpath("//span[text()='Active']/../../td[5][text()='Plano']/../td[1]");
    public By editClientBtn = By.xpath("//a[text()='Edit Client']");
    public By editCllientActualText = By.xpath("//h5[text()='Edit Client Info']");
    public By editFirstName = By.xpath(" //input[@formcontrolname='studentFirstName']");
    public By editLastName = By.xpath(" //input[@formcontrolname='studentLastName']");
    public By editParentName = By.xpath(" //input[@formcontrolname='parentName']");
    public By editDate = By.xpath(" //input[@formcontrolname='dateOfBirth']");
    public By editPhoneNumber = By.xpath(" //input[@formcontrolname='phoneNumber']");
    public By editCellNumber = By.xpath(" //input[@placeholder='Cell Number']");
    public By editEmail = By.xpath(" //input[@formcontrolname='emailAddress']");
    public By editEmail2 = By.xpath(" //input[@formcontrolname='secondaryEmailAddress']");
    public By editGrade = By.id("schoolType");
    public By editSchoolType = By.xpath(" //input[@formcontrolname='schoolType']");
    public By editDistrict = By.xpath(" //input[@formcontrolname='school']");
    public By editReason = By.id("reasonForCall");
    public By editAddress1 = By.xpath(" //input[@formcontrolname='address1']");
    public By editAddress2 = By.xpath(" //input[@formcontrolname='address2']");
    public By editCity = By.xpath(" //input[@formcontrolname='city']");
    public By editState = By.xpath(" //input[@formcontrolname='state']");
    public By editZipCode = By.xpath(" //input[@formcontrolname='zipCode']");
    public By editAdditionalComment = By.xpath(" //input[@formcontrolname='appointmentComments']");
    public By editUpdateBtn = By.id("intakeFormSubmit");
    public By actualTextClient = By.xpath("//p[text()=' College']");
    public By followUp = By.xpath("//a[text()=' Create Follow Up ']");
    public By followUpSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[7]");
    public By followUpSlots=By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']");
    public By slotSaveBtn = By.xpath("//mbsc-button[text()=' Save ']");
    public By followUpSaveBtn = By.xpath("//a[text()='Save']");
    public By confirmBtn = By.xpath("//a[text()='Confirm']");
    public By validateScheduledFollowUp = By.xpath("//h4[text()='Follow Up Scheduled!!']");
    public By followUpBackBtn = By.xpath("(//a[text()='Back'])[3]");
    public By viewAllTab = By.xpath("//a[text()='View All']");
    //*************************** Payment PopUp **************************//
    public By paymentBtn = By.xpath("//button[text()=' Payment ']");
    public By reAssignDiagList = By.xpath("//select[@id='diag']//option[@class='ng-star-inserted']");
    public By collectPayActualText = By.xpath("//h4[text()='Collect Payment']");
    public By testFeeAdjustmentAmt = By.xpath("//input[@class='custom-input my-1 ng-pristine ng-valid ng-touched']");
    public By collectFeeAmt = By.xpath("//input[@class='custom-input my-1 ng-untouched ng-pristine ng-valid']");
    public By enterAmt = By.id("bookingDeposit");
    public By collectPayBtn = By.xpath("//button[@class='theme-button mx-2']");
    public By payRecievedActualText = By.xpath("//h4[text()='Payment Received!!']");
    public By closebtn = By.xpath("(//a[text()='Close'])[2]");
    public By amountDue = By.xpath("//label[text()='Amount Due']//following-sibling::p");
    public By assessmentAmount = By.xpath("//label[text()='Assessment Amount']//following-sibling::p");
    public By receivedAmount = By.xpath("//label[text()='Received Amount']//following-sibling::p");
    public By fullPayActualText = By.xpath("//span[@class='badge bg-warning float-right ng-star-inserted']");
    public By holdButton = By.xpath("//button[text()=' Hold Appointment ']");
    public By holdActualText = By.xpath("(//h6[@class='mb-4 text-center'])[2]");
    public By fullName = By.xpath("(//p)[9]");
    public By allAppointmentsPage = By.xpath("//h3[text()='All Appointments']");
    public By holdAppointmentBtn = By.xpath("//button[text()='Yes, Hold']");
    public By holdtab = By.xpath("//a[text()='Hold']");
    public By holdAppointmentText = By.xpath("//h3[text()='Hold Appointments']");
    public By holdfilterButton = By.xpath("//a[text()='Filter']");
    public By searchTextBox = By.id("filterSearch");
    public By toDateText = By.xpath("//input[@formcontrolname='toDate']");
    public By fromDateText = By.xpath("//input[@formcontrolname='fromDate']");
    public By validateHoldClient = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By unHoldBtn = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(7)");

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
    public By clientName=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By uploadDocumentButton=By.xpath("//button[@class='theme-button m-2 ng-star-inserted']");
    public By uploadButton=By.xpath("//button[@class='theme-button mx-2']");
    public By chooseField=By.xpath("//input[@placeholder='select document to be uploaded']");
    public By closeButton=By.xpath("//a[text()='Close']");


    public void clickOn_createAdminButton() {
        WebdriverWaits.waitUntilVisible(createAdminButton);
        WebdriverWaits.waitUntilInvisible(createAdminButton);
        click_custom(createAdminButton);
    }

    public void enter_admin_FirstName(String CustomerFirstName) {
        WebdriverWaits.waitUntilVisible(admin_FirstName);
        sendKeys_withClear(admin_FirstName, CustomerFirstName);
    }

    public void enter_admin_LastName(String CustomerLastName) {
        WebdriverWaits.waitUntilVisible(admin_LastName);
        sendKeys_withClear(admin_LastName, CustomerLastName);
    }

    public void enter_admin_MobileNumber(String diagnostician_MobileNumberText) {
        WebdriverWaits.waitUntilVisible(admin_MobileNumber);
        sendKeys_withClear(admin_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_admin_Email(String diagnostician_EmailText) {
        WebdriverWaits.waitUntilVisible(admin_Email);
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

    public void clickOn_createadminButton() {
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

    //+++++++++++++++++EDIT Admin++++++++++++++

    public void click_On_EditButton() {
        WebdriverWaits.waitUntilVisible(loginLoading);
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

    public void clickOn_PasswordField(String passwordTextFieldText) {
        WebdriverWaits.waitUntilVisible(passwordTextField);
        sendKeys_withClear(passwordTextField, passwordTextFieldText);
    }

    public void clickOn_confirmPasswordFieldField(String confirmPasswordFieldText) {
        WebdriverWaits.waitUntilVisible(confirmPasswordField);
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }

    public void clickOn_DontSave() {
        WebdriverWaits.waitUntilVisible(dontSaveButton);
        click_custom(dontSaveButton);
    }
    public void clickOn_UploadButton(){
        WebdriverWaits.waitUntilVisible(uploadDocumentButton);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(uploadDocumentButton);
        click_custom(uploadDocumentButton);
    }
    public void clickOn_UploadButtons(){
        click_custom(uploadButton);
    }
    public void clickOn_CloseButton(){
        waitUntilVisible(closeButton);
        click_custom(closeButton);
    }
    public void clickOn_ChooseFile(){
        WebdriverWaits.waitUntilVisible(chooseField);
        WebdriverWaits.waitForSpinner();
        moveToElement(chooseField);
    }

    public void clickOn_CancelTab() {
        WebdriverWaits.waitUntilVisible(cancelTab);
        WebdriverWaits.waitForSpinner();
        moveToElement(cancelTab);
    }
    public  void upload_FileAttachment() throws InterruptedException, AWTException {
        clickOn_UploadButton();
        clickOn_ChooseFile();
        Thread.sleep(4000);
        String filepath = "Downloads\\33200_1911.pdf";
        ChromeDownloads.uploadFileUsingRobot(filepath);
        clickOn_UploadButtons();
        clickOn_CloseButton();
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

    public void search_CreatedAdmin(String UserName)
    {
        click_filterButton();
        enterInSearchField(UserName);
    }

    //******************EDIT ADMIN****************

    public void edit_Admin(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        WebdriverWaits.waitUntilVisible(editUserPop_Up);
        validate_text(editUserPop_Up, "Edit User");

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

    public void verify_DontSave(String adminEmailAddress, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_On_EditButton();
        enter_Diagnostician_Email1(adminEmailAddress);
        clickOn_PasswordField(passwordTextFieldText);
        clickOn_confirmPasswordFieldField(confirmPasswordFieldText);
        clickOn_DontSave();
    }

    public void click_EditAssessment() throws InterruptedException {
        WebdriverWaits.waitUntilVisible(editAss);
        WebdriverWaits.waitForSpinner();
        click_custom(editAss);
    }

    public void click_UpdateBtn() {
        WebdriverWaits.waitUntilVisible(updateBtn);
        click_custom(updateBtn);
    }

    public void edit_AssessmentType(String assestmentTypeTexts) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(assestmentType);
        WebdriverWaits.waitForSpinner();
        click_custom(assestmentType);
        selectDropDownByVisibleText_custom(assestmentType, assestmentTypeTexts);

    }

    public void click_DontSave() {
        WebdriverWaits.waitUntilVisible(dontSaveAsses);
        click_custom(dontSaveAsses);

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

    public void enter_ParentName(String parentName) {
        WebdriverWaits.waitUntilVisible(editParentName);
        sendKeys_withClear(editParentName, parentName);
    }

    public void enter_Date(String birthDate) {
        WebdriverWaits.waitUntilVisible(editDate);
        sendKeys_withClear(editDate, birthDate);
    }

    public void enter_PhoneNumber(String phoneNuber) {
        WebdriverWaits.waitUntilVisible(editPhoneNumber);
        sendKeys_withClear(editPhoneNumber, phoneNuber);
    }

    public void enter_CellNumber(String cellNumber) {
        WebdriverWaits.waitUntilVisible(editCellNumber);
        sendKeys_withClear(editCellNumber, cellNumber);
    }

    public void enter_Email1(String email) {
        WebdriverWaits.waitUntilVisible(editEmail);
        sendKeys_withClear(editEmail, email);
    }

    public void enter_Email2(String email) {
        WebdriverWaits.waitUntilVisible(editEmail2);
        sendKeys_withClear(editEmail2, email);
    }

    public void enter_grade(String grade) {
        WebdriverWaits.waitUntilVisible(editGrade);
        WebdriverWaits.waitUntilVisible(editGrade);
        click_custom(editGrade);
        selectDropDownByVisibleText_custom(editGrade, grade);
    }

    public void enter_SchoolType(int schoolType) {
        WebdriverWaits.waitUntilVisible(editSchoolType);
        selectDropDownByIndex_custom(editSchoolType, schoolType);
    }

    public void enter_District(String district) {
        WebdriverWaits.waitUntilVisible(editDistrict);
        sendKeys_withClear(editDistrict, district);
    }

    public void enter_Reason(String reason) {
        WebdriverWaits.waitUntilVisible(editReason);
        selectDropDownByVisibleText_custom(editReason, reason);
    }

    public void enter_Address2(String address) {
        WebdriverWaits.waitUntilVisible(editAddress2);
        sendKeys_withClear(editAddress2, address);
    }

    public void enter_Address1(String address) {
        WebdriverWaits.waitUntilVisible(editAddress1);
        sendKeys_withClear(editAddress1, address);
    }

    public void enter_City(String city) {
        WebdriverWaits.waitUntilVisible(editCity);
        sendKeys_withClear(editCity, city);
    }

    public void enter_State(String state) {
        WebdriverWaits.waitUntilVisible(editCity);
        sendKeys_withClear(editCity, state);
    }

    public void enter_ZipCode(String zipCode) {
        WebdriverWaits.waitUntilVisible(editZipCode);
        sendKeys_withClear(editZipCode, zipCode);
    }

    public void enter_comment(String additionalComment) {
        WebdriverWaits.waitUntilVisible(editAdditionalComment);
        sendKeys_custom(editAdditionalComment, additionalComment);
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
        click_custom(holdtab);
    }

    public void click_HoldFilterBtn() {
        WebdriverWaits.waitUntilVisible(holdfilterButton);
        click_custom(holdfilterButton);
    }

    public void send_textHoldSearchBox(String name) {
        sendKeys_custom(searchTextBox, name);

    }

    public void click_unHoldBtn() {
        click_custom(unHoldBtn);
    }


    public String edit_ClientInfo(String firstName, String lastName, String address1, String grade) {
        String fullName = firstName + " " + lastName;
        enter_FirstName(firstName);
        enter_LastName(lastName);
        enter_Address1(address1);
        enter_grade(grade);
        return fullName;

    }

    public void click_ViewAll() {
        WebdriverWaits.waitUntilVisible(viewAllTab);
        click_custom(viewAllTab);
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
        List<WebElement> slots =getWebElements(followUpSlots,"followUpSlots");
        for(WebElement slot : slots){
            click_custom(slot);
            if(getDriver().findElements(By.xpath("(//div[@class='ng-star-inserted'])[2]")).size()>0){
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


    public void Create_FollowUp() {
       refresh_Page();
        click_CreateFollowUpBtn();
        click_FollowUpSlot();
        click_FollowUpSlotSaveBtn();
        click_FollowUpSaveBtn();
        click_ConfirmFollowUpBtn();
        validate_text(validateScheduledFollowUp, "Follow Up Scheduled!!");
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
//        scrollIntoView(paymentButton);
//        click_custom(paymentButton);
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


    //*****************Doing full payment by client********************


    public void paying_DueAmount(String clientText) throws InterruptedException {
        clickOn_AppointmentTab();
        enter_ClientName(clientText);
        Thread.sleep(2000);
        clickOn_ViewDetailLink();
//        enter_ValidAmount();
//        clickOn_CollectButton();
//        clickOn_CancelButton();
    }

    public void verify_CancelledApp(String clientName) {
        clickOn_CancelTab();
        verifySearchTextBox();
        enterInSearchField(clientName);
    }
}

