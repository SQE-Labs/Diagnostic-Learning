package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.elements.DropDown;
import org.automation.logger.Log;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.WebdriverWaits.moveToElement;
import static org.automation.utilities.WebdriverWaits.waitUntilVisible;
import static org.openqa.selenium.By.cssSelector;
import static test.AdminTest.clientFirstName;
import static test.AdminTest.clientLastName;

public class AdminPage extends BasePage {
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
    public By editParentName = By.xpath(" //input[@formcontrolname='parentName']");
    public By editDate = By.xpath(" //input[@formcontrolname='dateOfBirth']");
    public By editCellNumber = By.xpath(" //input[@placeholder='Cell Number']");

    //****************Search Created Admin****************
    public By filterButton = By.xpath("//a[@class='theme-button grey ml-auto mr-3']");
    public By searchField = By.xpath("//input[@aria-controls='appointmentTable']");

     public By actualText = By.xpath("(//td)[2]");
    public By viewStudentObservationButton = By.xpath("//a[@class='theme-button green ml-2 ng-star-inserted']");
    //*****************Edit Admin with valid credentials****************
    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By editSchoolType = By.xpath(" //input[@formcontrolname='schoolType']");
    public By editDistrict = By.xpath(" //input[@formcontrolname='school']");
    public By editReason = By.id("reasonForCall");
    public By editAddress2 = By.xpath(" //input[@formcontrolname='address2']");
    public By editCity = By.xpath(" //input[@formcontrolname='city']");

    public By editZipCode = By.xpath(" //input[@formcontrolname='zipCode']");
    public By editAdditionalComment = By.xpath(" //input[@formcontrolname='appointmentComments']");
    public By emailField = By.xpath("//input[@formcontrolname='email']");
    public By updateButton = By.xpath("//button[text()='Update']");
    public By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    public By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    public By Succ_Msg_Upd = By.xpath("//div[text()=' Admin details updated successfully. ']");
    public By enableUser = By.xpath("//label[@class='small ng-star-inserted']");
    public By toggle = By.xpath("//span[@class='slider round']");
    public By dontSaveButton = By.xpath("(//a[@class='theme-button grey'])[1]");
    public By editUserPop_Up = By.xpath("//h5[text()='Edit User']");
    public By userNameText = By.xpath("(//td[2])[1]");
    public By Error_Msg = cssSelector(".alert.alert-danger.ng-star-inserted");

    //***********DASH BOARD PAGE**********
    public By dashboard = By.xpath("(//h3)[1]");
    //*********** EDIT ASSESSMENT TYPE ********//
    public By editAss = By.xpath("(//a[contains(@class,'ml-auto mr-3 px-3 py-2 badge')])[2]");
    public By assType = By.xpath("(//h5[@class='border-bottom mb-3 pb-3 text-center text-green'])[2]");
    public By assestmentType = By.xpath("//select[@id='assesmentType']");
    public By updateBtn = By.xpath("//button[@class='theme-button mr-3']");
    public By clientAsses = By.xpath("//p[text()=' IQ']");
    public By gradeList = By.xpath("(//select[@id='schoolType'])[1]/option");
    //***********Re-assign appointment************//

    public By diag = By.id("diag");


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
    public By testsList=By.xpath("//h5[text()='Tests to be performed']/..//p");
    public By actualEditTest = By.xpath("//p[text()=' WRAML ']");
    public By closeButton = By.xpath("(//a[text()='Close'])[2]");
    public By editClientBtn = By.xpath("//a[text()='Edit Client']");
    public By editCllientActualText = By.xpath("//h5[text()='Edit Client Info']");
    public By editFirstName = By.xpath(" //input[@formcontrolname='studentFirstName']");
    public By editLastName = By.xpath(" //input[@formcontrolname='studentLastName']");
    public By editEmail = By.xpath(" //input[@formcontrolname='emailAddress']");
    public By editPhoneNumber = By.xpath(" //input[@formcontrolname='phoneNumber']");
    public By editEmail2 = By.xpath(" //input[@formcontrolname='secondaryEmailAddress']");
    public By editGrade = By.id("schoolType");
    public By locList = By.xpath("//select[@id='testingLocation']");
    public By dia_List = By.xpath("//select[@id='diag']");
    public By reAssignbtn = By.xpath("//a[text()='Re-assign Appointment']");

    public By todaysTab = By.xpath("//*[@id=\"Appointments\"]/li[2]/a");
    public By editAddress1 = By.xpath(" //input[@formcontrolname='address1']");
    public By editUpdateBtn = By.id("intakeFormSubmit");
    public By actualTextClient = By.xpath("//p[text()=' College']");
    public By followUp = By.xpath("//a[text()=' Create Follow Up ']");
    public By followUp_CloseBtn=By.xpath("//button[@class='theme-button grey float-right']");
    public By followUpSlot = By.xpath("(//div[@class='ng-star-inserted'])[2]");
    public By followUpPopUp=By.xpath("//div[@class='mbsc-ios mbsc-popup-header mbsc-popup-header-anchored ng-star-inserted']");
    public By followUpSlots = By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']");
    public By followUpCancelButton=By.xpath("//mbsc-button[contains(text(),' Cancel ')]");
    public By slotSaveBtn = By.xpath("//mbsc-button[text()=' Save ']");
    public By followUpText=By.xpath("//div[contains(text(),'Follow Up')]");
    public By followUpSaveBtn = By.xpath("//a[text()='Save']");
    public By confirmBtn = By.xpath("//a[text()='Confirm']");
    public By validateScheduledFollowUp = By.xpath("//h4[text()='Follow Up Scheduled!!']");
    public By followUpBackBtn = By.xpath("(//a[text()='Back'])[3]");
    public By viewAllTab = By.xpath("//a[text()='View All']");
    public By backButn = By.xpath("//a[@class='grey ml-3 theme-button']");
    //*************************** Payment PopUp **************************//
    public By paymentBtn = By.xpath("//button[text()=' Payment ']");
    public By collectPayActualText = By.xpath("//h4[text()='Collect Payment']");
    public By testFeeAdjustmentAmt = By.xpath("(//input[contains(@class,'custom-input my-1')])[1]");
    public By collectFeeAmt = By.xpath("(//input[contains(@class,'custom-input my-1')])[2]");
    public By enterAmt = By.id("bookingDeposit");
    public By closeBtn = By.xpath("(//a[text()='Close'])[4]");
    public By collectPayBtn = By.xpath("//button[@class='theme-button mx-2']");
    public By closebtn = By.xpath("(//a[text()='Close'])[3]");
    public By amountDue = By.xpath("//label[text()='Amount Due']//following-sibling::p");
    public By assessmentAmount = By.xpath("//label[text()='Assessment Amount']//following-sibling::p");
    public By receivedAmount = By.xpath("//label[text()='Received Amount']//following-sibling::p");
    public By holdButton = By.xpath("//button[text()=' Hold Appointment ']");
    public By holdActualText = By.xpath("(//h6[@class='mb-4 text-center'])[2]");
    public By allAppointmentsPage = By.xpath("//h3[text()='All Appointments']");
    public By holdAppointmentBtn = By.xpath("//button[text()='Yes, Hold']");
    public By holdtab = By.xpath("//a[text()='Hold']");
    public By holdAppointmentText = By.xpath("//h3[text()='Hold Appointments']");
    public By backBtn=By.xpath("//a[@class='theme-button grey mx-2']");
    public By holdfilterButton = By.xpath("//a[text()='Filter']");
    public By searchTextBox = By.xpath("//input[@aria-controls='appointmentTable']");
    public By toDateText = By.xpath("//input[@formcontrolname='toDate']");
    public By searchFieldName=By.xpath("//input[@id='filterSearch']");
    public By fromDateText = By.xpath("//input[@formcontrolname='fromDate']");
    public By validateHoldClient = cssSelector("tr:not([style='display: none;' ]) td:nth-child(3)");
    public By unHoldBtn = cssSelector("tr:not([style='display: none;' ]) td:nth-child(7)");
    public By yesUnholdButton = By.xpath("//button[@class='theme-button danger mx-2']");


    //*******************Paying full payment by client****************
    public By appointmentTab = By.xpath("//a[text()=' Appointments ']");
    public By testCompleteTab = By.xpath("//a[text()='Test complete']");
    public By clientDetailLink = cssSelector("tr:not([style='display: none;' ]) td:nth-child(7)");
    public By paymentButton = By.xpath("//button[@class='theme-button green m-2 ng-star-inserted']");
    public By collectPaymentTxt=By.xpath("//div[@class='modal-content light px-5 py-4']/h4[text()='Collect Payment']");
    public By inr = By.xpath("(//td)[10]");
    public By amountField = By.xpath("//input[@id='bookingDeposit']");
    public By collectButton = By.xpath("//button[@class='theme-button mx-2']");
    public By cancelButton = By.xpath("(//a[text()='Close'])[3]");
    public By clientNameDetail = By.xpath("//h3");
    public By cancelAppointmentBtn = By.xpath("//button[text()=' Cancel Appointment ']");
    public By cancelTab = By.xpath("//a[text()='Canceled']");
    public By clientName = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");

    public By todayAppointmentTitle = By.xpath("//div[@class='align-items-md-center d-flex flex-column flex-md-row page-header']/h3");
    public By card = By.xpath("(//td[@class='d-block ng-star-inserted'])[1]");
    public By nameOnCard = By.xpath("(//p[@class='text-purple mb-0'])[1]");
    public By todayDateOnCard = By.xpath("(//span[@class='text-grey'])[1]");
    public By getTestReadyTitle = By.xpath("//div[@class='align-items-md-center d-flex flex-column flex-md-row page-header']/h3");
    public By titleOfUpcomingPage = By.xpath("//div[@class='page-header align-items-lg-center d-flex flex-column flex-md-row']/h3");
    public By getStatus = By.xpath("(//tr[not(contains(@style,'display: none;'))])[2]//span");
    public By getViewDetails = By.xpath("(//tr[not(contains(@style,'display: none;'))])[2]//a");
    public By getNameOfClient = By.xpath("((//tr[not(contains(@style,'display: none;'))])[2]//td)[1]");
    public By getTitleOfTestComplete = By.xpath("//div[@class='page-header align-items-lg-center d-flex flex-column flex-md-row']/h3");
    public By getTitleOfAttachedDocument = By.xpath("//h5[@class='text-center mb-4']");
    public By uploadDocumentButton = By.xpath("//button[@class='theme-button m-2 ng-star-inserted']");
    public By uploadDocumentTitle=By.xpath("//h4[text()='Upload Documents']");
    public By chooseField = By.xpath("//input[@placeholder='select document to be uploaded']");
    public By cancelBtn=By.xpath("//button[text()='Cancel']");
    public By uploadButton = By.xpath("//button[@class='theme-button mx-2']");
    public By success_Msg=By.xpath("//h5[contains(text(),'Uploaded')]");
    public By closeIcon = By.xpath("//button[@aria-label='Close']/span");
    public By clientNameTextTitle = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(2)");

    public By backButton = By.xpath("//a[@class='grey ml-3 theme-button']");
    public By backBtnCancelPopup = By.xpath("(//a[@class='theme-button grey mx-2'])[1]");
    public By re_AssignBtn = By.xpath("//button[@class='theme-button green']");
    public By paymentRecievePopUp=By.xpath("//h4[text()='Payment Received!!']");
    public By title = By.xpath("//h3");
    public By clientNameCompleted = By.xpath("((//tr[not(contains(@style,'display: none;'))])[2]/td)[1]");
    public By unoldBackBtn = By.xpath("//a[@class='theme-button grey mx-2']");
    public By titleOfViewReceipt = By.xpath("//h4[@class='text-center ng-star-inserted']");
    public By rescheduleAppointmentBtn = By.xpath("//a[text()='Reschedule Appointment']");
    public By cancelRadioBtn = By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[1]");
    public By yesBtn = By.xpath("(//button[@type='submit'])[1]");
    public By cancelBtnOfTimeSlotPopup = By.xpath("(//mbsc-button[@role='button'])[5]");
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
    public By clientNameText = By.xpath("(//div[@class='col-lg-6']//tr)[2]");
    public By clientDetail = By.xpath("//h3");
    public By clientNme = By.xpath("(//h6[text()='Follow-Ups to be scheduled']/..//following-sibling::tr)[1]");
    public By viewDetails = By.xpath("//a[text()='View Details']");
    public By diagName=By.xpath("//label[text()='Diagnostician']/following-sibling::p");

    //******************Verifying cancelled appointments*****************


    public void click_createAdminButton() {
        waitUntilVisible(createAdminButton);
        WebdriverWaits.waitUntilInvisible(createAdminButton);
        click_custom(createAdminButton);
    }

    public void enter_admin_FirstName(String CustomerFirstName) {
        waitUntilVisible(admin_FirstName);
        sendKeys_withClear(admin_FirstName, CustomerFirstName);
    }

    public void enter_admin_LastName(String CustomerLastName) {
        waitUntilVisible(admin_LastName);
        sendKeys_withClear(admin_LastName, CustomerLastName);
    }

    public void enter_admin_MobileNumber(String diagnostician_MobileNumberText) {
        waitUntilVisible(admin_MobileNumber);
        click_custom(admin_MobileNumber);
        sendKeys_withClear(admin_MobileNumber, diagnostician_MobileNumberText);
    }

    public void enter_admin_Email(String diagnostician_EmailText) {
        waitUntilVisible(admin_Email);
        sendKeys_withClear(admin_Email, diagnostician_EmailText);
    }

    public void userNameField(String userNameText) {
        waitUntilVisible(userName);
        sendKeys_withClear(userName, userNameText);
    }

    public void click_ClientLink() {
        WebdriverWaits.waitUntilVisible(clientNameText);
        WebdriverWaits.waitForSpinner();
        click_custom(clientNameText);
    }

    public void click_ScheduledClient() {
        WebdriverWaits.waitUntilVisible(clientNme);
        WebdriverWaits.waitForSpinner();
        click_custom(clientNme);
    }

    public void click_ViewDetailsLink() {
        click_custom(viewDetails);
    }

    public void create_passwordField(String passwordFieldText) {
        sendKeys_withClear(password_Field, passwordFieldText);
    }


    public void confirm_PasswordField(String confirmPasswordText) {
        sendKeys_withClear(confirm_PasswordField, confirmPasswordText);
    }

    public void click_TodayTab() {
        WebdriverWaits.waitUntilVisible(todaysTab);
        WebdriverWaits.waitForSpinner();
        moveToElement(todaysTab);
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

    public void clickCloseBtn() {
        WebdriverWaits.waitUntilVisible(closeBtn);
        click_custom(closeBtn);
    }

    //*******************SuperAdmin  searching created admin******************
    public void click_filterButton() {
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
    }

    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(searchField);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(searchField, searchFieldText);
    }

    public void enterTxt_InSearchField(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(searchTextBox);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(searchTextBox, searchFieldText);
    }

    public void click_SearchButton() {
        WebdriverWaits.waitUntilVisible(searchButton);
        click_custom(searchButton);
    }

    public void enter_ParentName(String parentName) {
        waitUntilVisible(editParentName);
        sendKeys_withClear(editParentName, parentName);
    }

    public void enter_Date(String birthDate) {
        waitUntilVisible(editDate);
        sendKeys_withClear(editDate, birthDate);
    }

    public void enter_PhoneNumber(String phoneNuber) {
        waitUntilVisible(editPhoneNumber);
        sendKeys_withClear(editPhoneNumber, phoneNuber);
    }

    public void enter_CellNumber(String cellNumber) {
        waitUntilVisible(editCellNumber);
        sendKeys_withClear(editCellNumber, cellNumber);
    }

    public void enter_Email1(String email) {
        waitUntilVisible(editEmail);
        sendKeys_withClear(editEmail, email);
    }

    public void enter_Email2(String email) {
        waitUntilVisible(editEmail2);
        sendKeys_withClear(editEmail2, email);
    }

    //+++++++++++++++++EDIT Admin++++++++++++++
    public void click_EditButton() {
        WebdriverWaits.waitUntilVisible(editButton);
        WebdriverWaits.waitForSpinner();
        click_custom(editButton);
    }

    public void enter_SchoolType(int schoolType) {
        waitUntilVisible(editSchoolType);
        selectDropDownByIndex_custom(editSchoolType, schoolType);
    }

    public void enter_District(String district) {
        waitUntilVisible(editDistrict);
        sendKeys_withClear(editDistrict, district);
    }

    public void click_ReAssignBn() {
        WebdriverWaits.waitUntilVisible(reAssignbtn);
        WebdriverWaits.waitForSpinner();
        click_custom(reAssignbtn);
    }

    public void re_Assign_Location_Lists(String locName) {
        dropdownListsRemoveValues(locList, "Re_Assign_Location lists", "Choose Testing Location");
        //Verify that appropriate 'Choose dignostician' dropdown list appears after selecting preferred testing location from 'Choose Testing Location' dropdown list, on '<Client> Re-assign Appointment' page
        selectDropDownByVisibleText_custom(locList, locName);
        //Verify that appropriate dropdown list appears & admin is able to select any option from it, after clicking  'Choose Testing Location' field, on '<Client> Re-assign Appointment' page.
        System.out.println(DropDown.getSelectedOption(locList));
    }
    public void click_ReAssignBtn(){
        click_custom(re_AssignBtn);
    }

    public void re_Assign_Diagnostician_Lists() {
        dropdownListsRemoveValues(dia_List, "Re_Assign Diagnostician lists", "Choose Diagnostician");
        //Verify that admin is able to select any option from 'Choose Diagnostician' dropdown list and selected option appears in 'Choose Diagnostician' field, on '<Client> Re-assign Appointment' page
        System.out.println(DropDown.getSelectedOption(locList));
    }


    public void enter_Address2(String address) {
        waitUntilVisible(editAddress2);
        sendKeys_withClear(editAddress2, address);
    }

    public void enter_City(String city) {
        waitUntilVisible(editCity);
        sendKeys_withClear(editCity, city);
    }

    public void enter_State(String state) {
        waitUntilVisible(editCity);
        sendKeys_withClear(editCity, state);
    }

    public void enter_ZipCode(String zipCode) {
        waitUntilVisible(editZipCode);
        sendKeys_withClear(editZipCode, zipCode);
    }

    public void enter_comment(String additionalComment) {
        waitUntilVisible(editAdditionalComment);
        sendKeys_custom(editAdditionalComment, additionalComment);
    }

    public void enter_Admin_Email1(String diagnostician_EmailText1) {
        sendKeys_withClear(emailField, diagnostician_EmailText1);
    }

    public void click_UpdateButton() {
        click_custom(updateButton);
    }

    public void off_ToggleButton() {
        WebdriverWaits.waitUntilVisible(toggle);
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

    public void click_confirmPasswordField(String confirmPasswordFieldText) {
        WebdriverWaits.waitUntilVisible(confirmPasswordField);
        sendKeys_withClear(confirmPasswordField, confirmPasswordFieldText);
    }

    public void click_DontSave() {
        WebdriverWaits.waitUntilVisible(dontSaveButton);
        WebdriverWaits.waitForSpinner();
        click_custom(dontSaveButton);
    }

    public void click_CloseButton() {
        waitUntilVisible(closeButton);
        click_custom(closeButton);
    }

    public void click_CancelTab() {
        WebdriverWaits.waitUntilVisible(cancelTab);
        WebdriverWaits.waitForSpinner();
        moveToElement(cancelTab);
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
        //  click_filterButton();
        enterTxt_InSearchField(UserName);
    }
    //******************EDIT ADMIN****************

    public void edit_Admin(String EmailAddress1, String passwordTextFieldText, String confirmPasswordFieldText) throws InterruptedException {
        click_EditButton();
        WebdriverWaits.waitUntilVisible(editUserPop_Up);
        validate_text(editUserPop_Up, "Edit User");
        enter_Admin_Email1(EmailAddress1);
        click_PasswordField(passwordTextFieldText);
        click_confirmPasswordField(confirmPasswordFieldText);
        off_ToggleButton();
        click_UpdateButton();
    }
    //************Checking toggle of or not*************

    public void cheking_DisableUser() {
        click_EditButton();
        WebdriverWaits.waitUntilVisible(enableUser);
        validate_text(enableUser, "Enable User");
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
        click_confirmPasswordField(confirmPasswordFieldText);
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

    public void edit_AssessmentType(String assestmentTypeTexts) throws InterruptedException {
        waitUntilVisible(assestmentType);
        WebdriverWaits.waitForSpinner();
        click_custom(assestmentType);
        selectDropDownByVisibleText_custom(assestmentType, assestmentTypeTexts);
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
    public void validate_TestsList(){
        scrolltoUp();
        WebdriverWaits.waitUntilVisible(testsList);
        WebdriverWaits.waitForSpinner();
        int count=0;
        //Verify that selected test & surveys appear under 'Tests to be performed' & 'Surveys to be performed' section after clicking 'Save' button on '<Client> Details' page.
        List<WebElement> testLists=getWebElements(testsList, "Get Lists");
        for(WebElement list :testLists) {
            if (list.isDisplayed()) {
                count++;
                Log.info(list.getText());
                Log.info(String.valueOf(count));
            } else {
            Log.info("There is not test values to print");
            }
        }
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
        WebdriverWaits.waitForSpinner();
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

    public void click_BackButton() {
        WebdriverWaits.waitUntilVisible(backButn);
        WebdriverWaits.waitForSpinner();
        click_custom(backButn);
    }

    public void click_UpdateClientBtn() {
        click_custom(editUpdateBtn);
    }

    public void click_CreateFollowUpBtn() {
        WebdriverWaits.waitUntilVisible(followUp);
        WebdriverWaits.waitForSpinner();
        click_custom(followUp);
    }
    public void click_FollowUpCloseBtn() throws InterruptedException {
        WebdriverWaits.waitUntilVisible(followUp_CloseBtn);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(4000);
        click_custom(followUp_CloseBtn);
    }

    public void click_FollowUpSlot(int count) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(followUpSlots);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(15000);
        List<WebElement> slots = getWebElements(followUpSlots, "followUpSlots");
        System.out.println(slots.size());
        for (WebElement slot : slots) {
            Thread.sleep(1000);
            click_custom(slot);
            Thread.sleep(2000);

            if (getWebElements(followUpSlot).size() > count) {
                validate_text(followUpPopUp,"Follow Up");
                break;
            }
        }
        click_FollowUpSlotSaveBtn();
    }
    //div[contains(text(),'Follow Up')]
    public void cancel_FollowUpSlot(int count) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(followUpSlots);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(15000);
        List<WebElement> slots = getWebElements(followUpSlots, "followUpSlots");
        System.out.println(slots.size());
        for (WebElement slot : slots) {
            Thread.sleep(2000);

            click_custom(slot);
            if (getWebElements(followUpSlot).size() > count) {
                WebdriverWaits.waitUntilVisible(followUpCancelButton);
                WebdriverWaits.waitForSpinner();
                click_custom(followUpCancelButton);
                WebdriverWaits.waitUntilInvisible(followUpText);
                Assert.assertFalse(isElementDisplay_custom(followUpText, "Follow Up"));
                break;
            }
        }
//        boolean result = true;
//        for (int i = 0; i < slots.size(); i++)
//        {
//            String slotsClass = slots.get(i).getAttribute("class");
//            if (!slotsClass.contains("mbsc-ios mbsc-schedule-event-background ng-star-inserted"))
//            {
//                result = false;
//
//            }
//        }
//        Assert.assertFalse(result);
//    }

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

    public void create_FollowUp(int count) throws InterruptedException {
//        click_CreateFollowUpBtn();
        click_FollowUpSlot(count);
        click_FollowUpSaveBtn();
        click_ConfirmFollowUpBtn();
        validate_text(validateScheduledFollowUp, "Follow Up Scheduled!!");
    }

    public void click_PaymentBtn() {
        WebdriverWaits.waitUntilVisible(paymentBtn);
        click_custom(paymentBtn);
    }

    public void click_CloseBtn() {
        scrollIntoView(closebtn);
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
        clickCloseBtn();
    }

    public void enter_Amount(String amount) {
        WebdriverWaits.waitUntilVisible(enterAmt);
        sendKeys_custom(enterAmt, amount);
    }

    //*******************Paying full payment by client**************
    public void click_AppointmentTab() {
        WebdriverWaits.waitUntilVisible(appointmentTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointmentTab);
        WebdriverWaits.waitUntilVisible(testCompleteTab);
        WebdriverWaits.waitForSpinner();
        click_custom(testCompleteTab);
    }

    public void filter_ForUpcoming(String clientText) {
        waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        // click_custom(filterButton);
        sendKeys_withClear(searchField, clientText);
    }

    public void enter_InSearchField(String ClientName) {
        WebdriverWaits.waitUntilVisible(searchField);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(searchField, ClientName);
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

    public void click_ViewDetailLink() {
        click_custom(clientDetailLink);
        WebdriverWaits.waitUntilVisible(paymentButton);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(paymentButton);
        click_custom(paymentButton);
        validate_text(collectPaymentTxt,"Collect Payment");
    }

    public void enter_ValidAmount() throws InterruptedException {
        String Inr = getText_custom(inr).replace("$", "");
        Thread.sleep(6000);
        sendKeys_withClear(amountField, Inr);
    }

    public void click_CollectButton() {
        click_custom(collectButton);
    }

    public void click_CancelButton() {
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

    public void reAssign_Appointment(String location) {
        click_ReAssignBn();
        re_Assign_Location_Lists(location);
        //Verify that admin is able to select any option from 'Choose Diagnostician' dropdown list and selected option appears in 'Choose Diagnostician' field, on '<Client> Re-assign Appointment' page
        re_Assign_Diagnostician_Lists();
        click_ReAssignBtn();
    }

    //*****************Doing full payment by client********************


    public void paying_DueAmount(String clientText) throws InterruptedException {
        Thread.sleep(4000);
        click_AppointmentTab();
        enter_ClientName(clientText);
        Thread.sleep(2000);
        click_ViewDetailLink();
        enter_ValidAmount();
        click_CollectButton();
        //Verify that information message appears after completeing full payment on '<client> Details' page.
        validate_text(paymentRecievePopUp, "Payment Received!!");
        click_CancelButton();
    }

    public void verify_CancelledApp(String clientName) {
        click_CancelTab();
        enterInSearchField(clientName);
    }

    public void click_Card() {
        waitUntilVisible(card);
        click_custom(card);
    }

    public void enterClientNameInSearchFieldCompleted(String nameOfClient) {
        WebdriverWaits.waitUntilVisible(searchTextBox);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(searchTextBox, nameOfClient);
    }

    public void click_ViewDetailsBtn() {
        WebdriverWaits.waitUntilVisible(getViewDetails);
        WebdriverWaits.waitForSpinner();
        click_custom(getViewDetails);
    }

    public void scrollUptoVAmountDue() {
        WebdriverWaits.waitUntilVisible(amountDue);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(amountDue);
    }

    public void click_ViewDocumentsButton() {
        WebdriverWaits.waitUntilVisible(viewDocumentsButton);
        click_custom(viewDocumentsButton);
    }


    public void click_HoldBackBtn() {
        waitUntilVisible(backBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(backBtn);
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

    public void clickOn_UploadButtons() {
        click_custom(uploadButton);
    }

    public void clickOn_CloseIcon() {
        WebdriverWaits.waitUntilVisible(closeIcon);
        WebdriverWaits.waitForSpinner();
        click_custom(closeIcon);
    }

    public void filter_ForCancel() {
        waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
        String clientText = "Cancel";
        sendKeys_withClear(searchField, clientText);
    }

    public void click_ChooseFile() {
        waitUntilVisible(chooseField);
        WebdriverWaits.waitForSpinner();
        moveToElement(chooseField);
    }

    public void clickOn_UnHoldBtn() {
        waitUntilVisible(unHoldBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(unHoldBtn);
    }

    public void clickOn_UnholdBackBtn() {
        waitUntilVisible(unoldBackBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(unoldBackBtn);
    }

    public void click_FilterBtn() {
        click_custom(filterButton);
    }

    public void click_UploadButton() {
        waitUntilVisible(uploadDocumentButton);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(uploadDocumentButton);
        click_custom(uploadDocumentButton);
    }
    public void click_Cancel_Button(){
        click_custom(cancelBtn);
    }

    public void click_UploadButtons() {
        click_custom(uploadButton);
    }


    public void click_RescheduleBtn() {
        waitUntilVisible(rescheduleAppointmentBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(rescheduleAppointmentBtn);

    }

    public void click_EditBtn() {
        waitUntilVisible(editClientBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(editClientBtn);

    }


    public void enter_DataInEmailField(String email) {
        waitUntilVisible(editEmail);
        WebdriverWaits.waitForSpinner();
        click_custom(editEmail);
        sendKeys_withClear(editEmail, email);
    }

    public void enter_DataInEmailSecField(String email) {
        waitUntilVisible(editEmail2);
        WebdriverWaits.waitForSpinner();
        click_custom(editEmail2);
        sendKeys_withClear(editEmail2, email);
    }


    public void click_CancelBtn() {
        waitUntilVisible(cancelAppointmentBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(cancelAppointmentBtn);

    }

    public void click_backBtnCancelPopup() {
        waitUntilVisible(backBtnCancelPopup);
        WebdriverWaits.waitForSpinner();
        click_custom(backBtnCancelPopup);
    }

    public void click_CancelRadioBtn() {
        waitUntilVisible(cancelRadioBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(cancelRadioBtn);
        click_custom(yesBtn);
        WebdriverWaits.waitForSpinner();
    }

    public void clickOn_CancelBtnNewSlotPopup() {
        waitUntilVisible(cancelBtnOfTimeSlotPopup);
        WebdriverWaits.waitForSpinner();
        click_custom(cancelBtnOfTimeSlotPopup);

    }
    public void upload_FileAttachment() throws InterruptedException, AWTException {
        click_UploadButton();
        validate_text(uploadDocumentTitle,"Upload Documents");
        //Verify that admin is directed back to '<Client> Details' page after Clicking 'Cancel' button on 'Upload Documents' popup, of '<Client> Details' page.
        click_Cancel_Button();
         scrolltoUp();
         WebdriverWaits.waitUntilVisible(clientNameDetail);
         WebdriverWaits.waitForSpinner();
        validate_text(clientNameDetail, clientFirstName +' '+ clientLastName +' '+ "Details");
        click_UploadButton();
        //Verify that '<choose file window>' opens up after clicking 'Choose files' button, on 'Upload Documents' popup of '<Client> Details' page.
        click_ChooseFile();
        Thread.sleep(6000);
        String filepath = "Downloads\\33200_1911.pdf";
        ChromeDownloads.uploadFileUsingRobot(filepath);
        //Verify that admin is able to upload single document after clicking 'Upload' button on '<Client> Details' button.
        click_UploadButtons();
        WebdriverWaits.waitUntilVisible(success_Msg);
        WebdriverWaits.waitForSpinner();
        validate_text(success_Msg,"Document Uploaded Successfully!!");
        click_CloseButton();
    }


}

