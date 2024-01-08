package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.automation.utilities.Assertions.validate_text;



public class AppointmentsPage extends BasePage {
    public By appointmentsTab= By.xpath("//a[@data-toggle='collapse' and @href='#Appointments' and contains(@class, '')]");
    public By viewAllTab=By.xpath("//a[text()='View All']");
    public By dashBoardPage=By.xpath("//h3[text()='Dashboard']");
    public By allAppointmentsPage=By.xpath("//h3");
    public By searchedText=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By viewDetailsLink=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(7)");
    public By clickSlotSaveBtn= By.xpath("//mbsc-button[text()=' Save ']");
    public By clickSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[5]");
    public By clickCalSaveBtn = By.xpath("//a[@class='theme-button green float-right mr-2']");
    public By newSlotText =By.xpath("//div[@class='ng-star-inserted']");

    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField=By.xpath("//input[@id='filterSearch']");
    public By dateFrom=By.xpath("//input[@placeholder='From Date']");
    public By toDate=By.xpath("//input[@placeholder='To Date']");
    public By searchButton=By.xpath("//button[text()='Search']");
    public By exportCSVButton=By.xpath("//button[text()='Export to CSV']");
    public By assessmentDate = By.id("assessmentDate");
    public By viewDetails=By.xpath("//a[text()='View Detail']");
    public By App_Text=By.xpath("//h3");
    public By spinner= By.cssSelector("div.ngx-spinner-overlay");
    public By viewAllActualText= By.xpath("//h3[@class='mb-4 mb-md-0']");
    public By assestmentType = By.id("assestmentType");
    public By newEventText= By.xpath("//div[text()='New Event']");
    public By dateElements = By.xpath("//tr/td[4]");
    public By chooseTestingLocation = By.id("testingLocation");
    public By clientFirstName = By.xpath("//input[@placeholder='Client First Name']");
    public By clientLastName = By.xpath("//input[@placeholder='Client Last Name']");
    public By headerResource = By.xpath("//div[@class='header-resource-name']");
    public By dateOfBirth = By.xpath("//input[@placeholder='Date of Birth']");
    public By saveButton = By.xpath("//mbsc-button[text()=' Save ']");
    public By appointmentSaveButtonButton = By.xpath("//a[text()='Save']");
    public By grade = By.xpath("(//select[@id='schoolType'])[1]");
    public By SchoolType=By.xpath("(//select[@id='schoolType'])[2]");
    public By phoneNumber = By.xpath("(//input[@class='p-inputtext p-component p-element p-inputmask'])[2]");
    public By emailAddress = By.xpath("//input[@placeholder='Email Address']");
    public By reasonForCall = By.id("reasonForCall");
    public By address1 = By.xpath("//input[@placeholder='Address 1']");
    public By address2 = By.xpath("//input[@placeholder='Address 2']");
    public By city = By.xpath("//input[@placeholder='City']");
    public By state = By.xpath("//input[@placeholder='State']");
    public By zipCode = By.xpath("//input[@placeholder='Zip Code']");
    public By continueToDeposit = By.id("intakeFormSubmit");
    public By testAmount=By.xpath("//input[@placeholder='Test Amount']");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By enterAmountField=By.xpath("//input[@placeholder='Enter Amount']");
    public By collectDeposit=By.xpath("//button[text()='Collect Deposit']");
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By actualText=By.xpath("//h4[text()='Appointment Scheduled!!']");
    public By holdAppointmentBtn = By.xpath("(//h6[@class='mb-4 text-center'])[2]");
    public By holdActualText = By.xpath("(//h6[@class='mb-4 text-center'])[2]");
    public By holdButton = By.xpath("//button[@class='theme-button danger mx-2']");
    public By searchTextBox = By.id("filterSearch");
    public By fromDateText = By.xpath("//input[@formcontrolname='fromDate']");
    public By  fullName = By.xpath("//li[span[contains(text(), 'Client Name')]]/text()");





    public void enterFirstName(String cilentFirstNameText){
        WebdriverWaits.waitUntilVisible(clientFirstName);
        sendKeys_withClear(clientFirstName,cilentFirstNameText);
    }
    public void enterLastName(String cilentLastNameText){
        WebdriverWaits.waitUntilVisible(clientLastName);
        sendKeys_withClear(clientLastName,cilentLastNameText);
    }


    public void selectGradeType(int gradeType){
        selectDropDownByIndex_custom(grade,gradeType);
    }
    public void selectSchoolType(int schoolTypeOption) throws InterruptedException {
        // click_custom(SchoolType);
        selectDropDownByIndex_custom(SchoolType,schoolTypeOption);
    }
    public void enterCellNumber(String cellNumberText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(cellNumber);
        Thread.sleep(4000);
        sendKeys_withClear(cellNumber,cellNumberText);
    }
    public void enterPhoneNumber(String phoneNumberText){
        sendKeys_withClear(phoneNumber,phoneNumberText);
    }
    public void enterEmialAddress(String emailAddressText){
        sendKeys_withClear(emailAddress,emailAddressText);
    }
    public void reasonForCallDropDown(String reasonForCallText){
        selectDropDownByVisibleText_custom(reasonForCall,reasonForCallText);
    }


    public void enterAdress1(String address1Text){
        sendKeys_withClear(address1,address1Text);
    }
    public void enterAdress2(String address2Text){
        sendKeys_withClear(address2,address2Text);
    }
    public void enterCity(String cityText){
        sendKeys_withClear(city,cityText);
    }
    public void enterState(String stateText){
        sendKeys_withClear(state,stateText);
    }
    public void enterZipCode(String zipCodeText){
        sendKeys_withClear(zipCode,zipCodeText);
    }
    public void click_LogOutLink() {
        refresh_Page();
        WebdriverWaits.waitUntilVisible(logOutLink);
        WebdriverWaits.waitForSpinner();
        click_custom(logOutLink);

    }

    public void enterTestAmount(String testAmountText){
        WebdriverWaits.waitUntilVisible(testAmount);
        sendKeys_withClear(testAmount,testAmountText);
    }
    public void clickOnContinueToDepositButton(){
        click_custom(continueToDeposit);
    }
    public void enterInDateField(String dateOfBirthText) throws InterruptedException {
        click_custom(dateOfBirth);
        WebdriverWaits.waitUntilVisible(dateOfBirth);
        sendKeys_withClear(dateOfBirth,dateOfBirthText);
    }
    public void clickOnSaveButton() {
        //  click_custom(afternoonToggleButton);
        click_custom(saveButton);
    }
    public void clickOnAppSaveButton() {
        WebdriverWaits.waitUntilVisible(appointmentSaveButtonButton);
        click_custom(appointmentSaveButtonButton);
    }
    public void clickOnAssesmentType(int assestmentTypeTexts){
        WebdriverWaits.waitUntilVisible(assestmentType);
        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType,assestmentTypeTexts);
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
        WebdriverWaits.waitUntilInvisible(enterAmountField);
        WebdriverWaits.waitUntilVisible(enterAmountField);
        click_custom(enterAmountField);
        sendKeys_withClear(enterAmountField,enterAmountText);
    }
    public void clickOnCollectDepositButton(){
        click_custom(collectDeposit);
    }
    public void clickOnViewDetailsButton(){
        WebdriverWaits.waitUntilVisible(viewDetails);
        click_custom(viewDetails);
    }
    public void selectTestinglocation(int chooseLocationText) {
        WebdriverWaits.waitUntilVisible(chooseTestingLocation);
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByIndex_custom(chooseTestingLocation, chooseLocationText);
    }
    public int getColumnCount() {
        List<WebElement> list = getWebElements(headerResource, "Heders");
        return list.size();
    }
    public  void getTotalColumnCount() {
        int colCount = getColumnCount();
        int expLocatorPos = (colCount - 1) * 7 + 1;
        System.out.println(expLocatorPos);
        WebdriverWaits.waitUntilVisible(clickSlot);
        click_custom(clickSlot);
    }

    public void clickSlotSaveButton(){
        WebdriverWaits.waitUntilVisible(clickSlotSaveBtn);
        click_custom(clickSlotSaveBtn);
    }
    public void clickCalSaveButton(){
        click_custom(clickCalSaveBtn);
    }
    public void click_AssessmentDate(){
        WebdriverWaits.waitUntilVisible(assessmentDate);
        WebdriverWaits.waitForSpinner();
        click_custom(assessmentDate);
    }

    public void selectAppointmentSlot() throws InterruptedException {
        click_AssessmentDate();
        //String date = getDate();
        //WebdriverWaits.waitUntilVisible(calendarTitle);
        //validate_text(calendarTitle,date);
        getTotalColumnCount();
        WebdriverWaits.waitUntilVisible(newEventText);
        validate_text(newEventText,"New Event");
        clickSlotSaveButton();
        WebdriverWaits.waitUntilVisible(newSlotText);
        validate_text(newSlotText,"New event");
        clickCalSaveButton();
    }




    public void selectAssesmentType(int assestmentTypeTexts){
        WebdriverWaits.waitUntilVisible(assestmentType);
         WebdriverWaits.waitForSpinner();
        click_custom(assestmentType);
        selectDropDownByIndex_custom(assestmentType,assestmentTypeTexts);
    }

    public void fill_clientDetailsSection(String CustomerFirstName, String CustomerLastName, int gradeType, String dateOfBirthText,int schoolTypeOption, String cellNumber , String EmailAddress, String reasonForCallText, String cityText, String stateText, String zipCodeText, String testAmountText, String enterAmountText) throws InterruptedException {
        enterFirstName(CustomerFirstName);
        enterLastName(CustomerLastName);
        enterInDateField( dateOfBirthText);
        selectGradeType(gradeType);
        selectSchoolType(schoolTypeOption);
        enterCellNumber(cellNumber);
        enterEmialAddress(EmailAddress);
        reasonForCallDropDown(reasonForCallText);
        enterTestAmount(testAmountText);
        clickOnContinueToDepositButton();
        WebdriverWaits.waitUntilInvisible(spinner);
        enterAmount(enterAmountText);
        WebdriverWaits.waitUntilInvisible(spinner);
        clickOnCollectDepositButton();
        WebdriverWaits.waitUntilVisible(actualText);
        validate_text(actualText,"Appointment Scheduled!!");
        clickOnViewDetailsButton();
        WebdriverWaits.waitForSpinner();
    }
    public void click_AppointmentTab(){
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        WebdriverWaits.waitUntilInvisible(spinner);
        click_custom(appointmentsTab);
    }
    public void appointmentDateSelecting(int Type) throws InterruptedException {
        Thread.sleep(5000);
        getTotalColumnCount();
        Thread.sleep(3000);
        clickOnSaveButton();
        Thread.sleep(3000);
        clickOnAppSaveButton();
        Thread.sleep(3000);
        clickOnAssesmentType(Type);
    }
    public void click_ViewAllTab(){
        WebdriverWaits.waitUntilVisible(viewAllTab);
        click_custom(viewAllTab);
        WebdriverWaits.waitForSpinner();;
        WebdriverWaits.waitUntilVisible(By.xpath("//a[text()='View Detail'])[1]"));
        click_custom(By.xpath("//a[text()='View Detail'])[1]"));
    }
    public void click_FilterButton(){
         click_custom(filterButton);
    }
    public void clickOn_ExportCSVButton(){
        WebdriverWaits.waitUntilVisible(exportCSVButton);
        click_custom(exportCSVButton);
    }
    public void scheduleAppointment(String chooseLocationText) throws InterruptedException {
        selectTestinglocation(chooseLocationText);
        selectAssessmentDate();
    }
    public void click_SearchField(String searchFieldText){
        WebdriverWaits.waitUntilVisible(searchField);
        sendKeys_withClear(searchField,searchFieldText);
    }
    public void enter_Dates(String dateFromText,String toDateText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(dateFrom);
        click_custom(dateFrom);
        sendKeys_withClear(dateFrom,dateFromText);
        WebdriverWaits.waitUntilVisible(toDate);
        click_custom(toDate);
        sendKeys_withClear(toDate,toDateText);
//        WebdriverWaits.waitUntilVisible(searchButton);
//        click_custom(searchButton);
    }
    public void clickOn_ViewDetails(){
        WebdriverWaits.waitUntilVisible(viewDetailsLink);
        click_custom(viewDetailsLink);
    }


    public void exportCSV_Button(){
        click_AppointmentTab();
        click_ViewAllTab();
        clickOn_ExportCSVButton();
    }







}
