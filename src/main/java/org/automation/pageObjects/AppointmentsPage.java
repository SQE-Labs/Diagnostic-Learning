package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.automation.utilities.Assertions.validate_text;
import static org.automation.utilities.WebdriverWaits.*;
import static test.AdminTest.clientFirstName;


public class AppointmentsPage extends BasePage {
    public By appointmentsTab = By.xpath("//a[@class='collapsed']");
    public By viewAllTab = By.xpath("//a[text()='View All']");
    public By dashBoardPage = By.xpath("//h3[text()='Dashboard']");
    public By allAppointmentsPage = By.xpath("//h3");
    public By searchedText = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By viewDetailsLink = By.xpath("(//tr[not(contains(@style,'display: none;'))])[2]//a");
    public By clickSlotSaveBtn = By.xpath("//mbsc-button[text()=' Save ']");
    public By clickCalSaveBtn = By.xpath("//a[@class='theme-button green float-right mr-2']");
    public By newSlotText = By.xpath("//div[@class='ng-star-inserted']");
    public By slots = By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']");

    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By dateFrom = By.xpath("//input[@placeholder='From Date']");
    public By toDate = By.xpath("//input[@placeholder='To Date']");
    public By exportCSVButton = By.xpath("//button[text()='Export to CSV']");
    public By assessmentDate = By.id("assessmentDate");
    public By viewDetails = By.xpath("//a[@class='theme-button grey']");
    public By App_Text = By.xpath("//h3");
    public By viewAllActualText = By.xpath("//h3[@class='mb-4 mb-md-0']");
    public By assestmentType = By.id("assestmentType");
    public By newEventText = By.xpath("//div[text()='New Event']");
    public By dateElements = By.xpath("//tr/td[4]");
    public By dateElement = By.xpath("//tr/td[3]");
    public By chooseTestingLocation = By.id("testingLocation");
    public By clientFirstName = By.xpath("//input[@placeholder='Client First Name']");
    public By clientLastName = By.xpath("//input[@placeholder='Client Last Name']");
    public By headerResource = By.xpath("//div[@class='header-resource-name']");
    public By dateOfBirth = By.xpath("//input[@placeholder='Date of Birth']");
    public By saveButton = By.xpath("//mbsc-button[text()=' Save ']");
    public By appointmentSaveButtonButton = By.xpath("//a[text()='Save']");
    public By grade = By.xpath("(//select[@id='schoolType'])[1]");
    public By SchoolType = By.xpath("(//select[@id='schoolType'])[2]");
    public By phoneNumber = By.xpath("(//input[@class='p-inputtext p-component p-element p-inputmask'])[2]");
    public By emailAddress = By.xpath("//input[@placeholder='Email Address']");
    public By reasonForCall = By.id("reasonForCall");
    public By continueToDeposit = By.id("intakeFormSubmit");
    public By testAmount = By.xpath("//input[@placeholder='Test Amount']");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By enterAmountField = By.xpath("//input[@placeholder='Enter Amount']");
    public By collectDeposit = By.xpath("//button[text()='Collect Deposit']");
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By actualText = By.xpath("//h4[text()='Appointment Scheduled!!']");
    public By cancelButton = By.xpath("//button[@class='theme-button danger m-2 ng-star-inserted']");
    public By radioBox = By.xpath("(//label[@class='custom-control-label'])[1]");
    public By yesButton = By.xpath("//button[@class='theme-button danger mx-2 ng-star-inserted']");
    public By searchTextBox = By.id("filterSearch");

    //******************Verifying cancelled appointments*****************


    public void enterFirstName(String cilentFirstNameText) {
        WebdriverWaits.waitUntilVisible(clientFirstName);
        sendKeys_withClear(clientFirstName, cilentFirstNameText);
    }

    public void enterLastName(String cilentLastNameText) {
        WebdriverWaits.waitUntilVisible(clientLastName);
        sendKeys_withClear(clientLastName, cilentLastNameText);
    }


    public void selectGradeType(int gradeType) {
        selectDropDownByIndex_custom(grade, gradeType);
    }

    public void selectSchoolType(int schoolTypeOption)   {
        // click_custom(SchoolType);
        selectDropDownByIndex_custom(SchoolType, schoolTypeOption);
    }

    public void enterCellNumber(String cellNumberText)   {
        WebdriverWaits.waitUntilVisible(cellNumber);
         click_custom(cellNumber);
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void enterPhoneNumber(String phoneNumberText) {
        sendKeys_withClear(phoneNumber, phoneNumberText);
    }

    public void enterEmialAddress(String emailAddressText) {
        sendKeys_withClear(emailAddress, emailAddressText);
    }

    public void reasonForCallDropDown(String reasonForCallText) {
        selectDropDownByVisibleText_custom(reasonForCall, reasonForCallText);
    }

    public void click_LogOutLink() {
        refresh_Page();
        WebdriverWaits.waitUntilVisible(logOutLink);
        WebdriverWaits.waitForSpinner();
        click_custom(logOutLink);
    }

    public void enterTestAmount(String testAmountText) {
        WebdriverWaits.waitUntilVisible(testAmount);
        sendKeys_withClear(testAmount, testAmountText);
    }

    public void clickContinueToDepositButton() {
        click_custom(continueToDeposit);
    }

    public void enterInDateField(String dateOfBirthText) throws InterruptedException {
        click_custom(dateOfBirth);
        WebdriverWaits.waitUntilVisible(dateOfBirth);
        sendKeys_withClear(dateOfBirth, dateOfBirthText);
    }

    public void clickOnSaveButton() {
        //  click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }

    public void clickOnAppSaveButton() {
        WebdriverWaits.waitUntilVisible(appointmentSaveButtonButton);
        click_custom(appointmentSaveButtonButton);
    }

    public void clickOnAssesmentType(int assestmentTypeTexts) {
        WebdriverWaits.waitUntilVisible(assestmentType);
        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType, assestmentTypeTexts);
    }

    public void selectTestinglocation(String chooseLocationText) {
        WebdriverWaits.waitUntilVisible(chooseTestingLocation);
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByVisibleText_custom(chooseTestingLocation, chooseLocationText, "ChooseLocation");
    }

    public void selectAssessmentDate() {
        WebdriverWaits.waitUntilVisible(assessmentDate);
        WebdriverWaits.waitForSpinner();
        clickBtn_custom(assessmentDate);
    }

    public void enterAmount(String enterAmountText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(enterAmountField);
        click_custom(enterAmountField);
        sendKeys_withClear(enterAmountField, enterAmountText);
    }

    public void clickCollectDepositButton() {
        click_custom(collectDeposit);
    }

    public void clickViewDetailsButton() {
        WebdriverWaits.waitUntilVisible(viewDetails);
        WebdriverWaits.waitForSpinner();
        click_custom(viewDetails);
    }


    public int getColumnCount() {
        List<WebElement> list = getWebElements(headerResource, "Heders");
        return list.size();
    }

    public void getTotalColumnCount() throws InterruptedException {
//        int colCount = getColumnCount();
//        int expLocatorPos = (colCount - 1) * 7 + 1;
//        System.out.println(expLocatorPos);

        Thread.sleep(7000);
        List<WebElement> list = getWebElements(slots, "AppointmentSlots");
        for (WebElement slot : list) {
            Thread.sleep(2000);
            click_custom(slot);

            if (getDriver().findElements(By.xpath("//div[@class='mbsc-ios mbsc-schedule-event-background ng-star-inserted']")).size() > 0) {
                break;
            }
        }
    }

    public void click_CancelButton() {
        refresh_Page();
        WebdriverWaits.waitUntilVisible(cancelButton);
        scrollIntoView(cancelButton);
        click_custom(cancelButton);
        WebdriverWaits.waitUntilVisible(radioBox);
        moveToElement(radioBox);
        click_custom(yesButton);
    }

    public void clickSlotSaveButton() {
        WebdriverWaits.waitUntilVisible(clickSlotSaveBtn);
        click_custom(clickSlotSaveBtn);
    }

    public void clickCalSaveButton() {
        click_custom(clickCalSaveBtn);
    }

    public void click_AssessmentDate() {
        WebdriverWaits.waitUntilVisible(assessmentDate);
        WebdriverWaits.waitForSpinner();
        click_custom(assessmentDate);
    }

    public void selectAppointmentSlot() throws InterruptedException {
        click_AssessmentDate();
        getTotalColumnCount();
        WebdriverWaits.waitUntilVisible(newEventText);
        validate_text(newEventText, "New Event");

        clickSlotSaveButton();
        WebdriverWaits.waitUntilVisible(newSlotText);
        validate_text(newSlotText, "New event");
        clickCalSaveButton();
    }


    public void selectAssesmentType(int assestmentTypeTexts) {
        WebdriverWaits.waitUntilVisible(assestmentType);
        WebdriverWaits.waitForSpinner();
        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType, assestmentTypeTexts);
    }
    public void fill_clientDetailsSection(String CustomerFirstName, String CustomerLastName, int gradeType, String dateOfBirthText, int schoolTypeOption, String cellNumber, String EmailAddress, String reasonForCallText, String cityText, String stateText, String zipCodeText, String testAmountText, String enterAmountText) throws InterruptedException {
        enterFirstName(CustomerFirstName);
        enterLastName(CustomerLastName);
        enterInDateField(dateOfBirthText);
        selectGradeType(gradeType);
        selectSchoolType(schoolTypeOption);
        enterCellNumber(cellNumber);
        enterEmialAddress(EmailAddress);
        reasonForCallDropDown(reasonForCallText);
        enterTestAmount(testAmountText);
        clickContinueToDepositButton();
        WebdriverWaits.waitForSpinner();
        enterAmount(enterAmountText);
        clickCollectDepositButton();
        WebdriverWaits.waitForSpinner();

        WebdriverWaits.waitUntilVisible(actualText);
        validate_text(actualText, "Appointment Scheduled!!");

        clickViewDetailsButton();
        WebdriverWaits.waitForSpinner();
    }

    public void click_AppointmentTab() {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointmentsTab);
    }

    public void click_ViewAllTab() {
        WebdriverWaits.waitUntilVisible(viewAllTab);
        WebdriverWaits.waitForSpinner();
        moveToElement(viewAllTab);
    }

    public void click_FilterButton() {
        waitUntilVisible(filterButton);
        waitForSpinner();
        click_custom(filterButton);
    }

    public void click_ExportCSVButton() {
        WebdriverWaits.waitUntilVisible(exportCSVButton);
        WebdriverWaits.waitForSpinner();
        click_custom(exportCSVButton);
    }

    public void click_SearchField(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }

    public void enter_Dates(String dateFromText, String toDateText) {
        WebdriverWaits.waitUntilVisible(dateFrom);
        click_custom(dateFrom);
        sendKeys_withClear(dateFrom, dateFromText);
        WebdriverWaits.waitUntilVisible(toDate);
        click_custom(toDate);
        sendKeys_withClear(toDate, toDateText);
//        WebdriverWaits.waitUntilVisible(searchButton);
//        click_custom(searchButton);
    }

    public void click_ViewDetails() {
        WebdriverWaits.waitUntilVisible(viewDetailsLink);
        click_custom(viewDetailsLink);
    }


    public void exportCSV_Button() {
        click_AppointmentTab();
        click_ViewAllTab();
        click_ExportCSVButton();
    }

    public void cancelAppointment() {
        click_CancelButton();
    }

    public void filterRecords(String clientFirstName) {
        click_FilterButton();
         click_SearchField(clientFirstName);
        exportCSV_Button();
    }
}