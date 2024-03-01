package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

import static org.automation.utilities.Assertions.validate_text;
import static org.automation.utilities.DateGenerator.getMonthAndYear;
import static org.automation.utilities.WebdriverWaits.moveToEleByWE;
import static org.automation.utilities.WebdriverWaits.moveToElement;


public class AppointmentsPage extends BasePage {
    public By appointmentsTab = By.xpath("//a[@class='collapsed']");

    public By popupCancelBtn = By.xpath("//mbsc-button[text()=' Cancel ']");

    public By directorTab = By.xpath("//a[text()='Directors']");
    public By upcomingTab = By.xpath("//a[text()='Upcoming']");
    public By testReadyTab = By.xpath("//a[text()='Test Ready']");
    public By testCompleteTab = By.xpath("//a[text()='Test complete']");
    public By canceledTab = By.xpath("//li[@class='ng-star-inserted active']/a");
    public By completedTab = By.xpath("//a[text()='Completed ']");
    public By viewAllTab = By.xpath("//a[text()='View All']");
    public By paymentButton = By.xpath("//button[@class='theme-button green m-2 ng-star-inserted']");
    public By dashBoardPage = By.xpath("//h3[text()='Dashboard']");
    public By allAppointmentsPage = By.xpath("//h3");
    public By searchedText = By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(2)");
    public By viewDetailsLink = By.xpath("(//tr[not(contains(@style,'display: none;'))])[2]//a");
    public By clickSlotSaveBtn = By.xpath("//mbsc-button[text()=' Save ']");
    public By holdtab = By.xpath("//a[text()='Hold']");


    public By app_Text = By.xpath("//h3");

    public By clickSlot = By.xpath("(//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted'])[9]");

    public By clickCalSaveBtn = By.xpath("//a[@class='theme-button green float-right mr-2']");
    public By newSlotText = By.xpath("//div[@class='ng-star-inserted']");
    public By slots = By.xpath("//div[@class='mbsc-flex-1-0 mbsc-ios mbsc-schedule-item ng-star-inserted']");
    public By totalSlots = By.xpath("//div[@class='mbsc-ios mbsc-schedule-event-background ng-star-inserted']");

    public By appointmentsToday = By.xpath("//*[@id=\"Appointments\"]/li[2]/a");
    public By todaysAppointmentTXT = By.xpath("//div[@class='align-items-md-center d-flex flex-column flex-md-row page-header']");
    public By upcomingCard = By.xpath("//a[text()='Upcoming']");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@aria-controls='appointmentTable']");
    public By dateFrom = By.xpath("//input[@placeholder='From Date']");
    public By toDate = By.xpath("//input[@placeholder='To Date']");
    public By exportCSVButton = By.xpath("//button[text()='Export to CSV']");
    public By assessmentDate = By.id("assessmentDate");
    public By diagnosticianTab = By.xpath("//a[text()='Diagnosticians']");
    public By selectWISC = By.xpath("(//div[@class='col-md-3 ng-star-inserted'])[6]");
    public By editTestPlanButton = By.xpath("(//button[@class='theme-button m-2 ng-star-inserted'])[1]");
    public By viewDetails = By.xpath("//a[@class='theme-button grey']");
    public By dashboardTitleText = By.xpath("(//div/h3)[1]");

    public By upcomingAppointmentTXT = By.xpath("//h3[@class='mb-4 mb-md-0']");
    public By viewAllActualText = By.xpath("//h3[@class='mb-4 mb-md-0']");
    public By assestmentType = By.id("assestmentType");
    public By newEventText = By.xpath("//div[text()='New Event']");
    public By dateElements = By.xpath("//tr/td[4]");
    public By dateElement = By.xpath("(//tr/td[5])[1]");
    public By dateEle = By.xpath("((//tr[not(contains(@style,'display: none;'))])[2]//td)[4]");
    public By chooseTestingLocation = By.id("testingLocation");
    public By locationLists=By.xpath("//select[@id='testingLocation']/option");
    public By titleText=By.xpath("//h3");

    public By clientFirstName = By.xpath("//input[@placeholder='Client First Name']");
    public By clientLastName = By.xpath("//input[@placeholder='Client Last Name']");
    public By headerResource = By.xpath("//div[@class='header-resource-name']");
    public By dateOfBirth = By.xpath("//input[@placeholder='Date of Birth']");

    public By grade = By.xpath("(//select[@id='schoolType'])[1]");
    public By SchoolType = By.xpath("(//select[@id='schoolType'])[2]");


    public By continueToDeposit = By.id("intakeFormSubmit");
    public By testAmount = By.xpath("//input[@placeholder='Test Amount']");
    public By cellNumber = By.xpath("//input[@placeholder='Cell Number']");
    public By phoneNumber = By.xpath("(//input[@class='p-inputtext p-component p-element p-inputmask'])[2]");
    public By enterAmountField = By.xpath("//input[@placeholder='Enter Amount']");
    public By collectDeposit = By.xpath("//button[text()='Collect Deposit']");
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By reasonForCall = By.id("reasonForCall");
    public By paymentPopUp=By.xpath("(//div/h4)[1]");
    public By actualText = By.xpath("//h4[text()='Appointment Scheduled!!']");
    public By cancelButton = By.xpath("//button[@class='theme-button danger m-2 ng-star-inserted']");
    public By radioBox = By.xpath("(//label[@class='custom-control-label'])[1]");
    public By nameOfTestReadyCard = By.xpath("(//div[@class='client-diagno d-flex align-items-center justify-content-between']/p)[1]");
    public By yesButton = By.xpath("//button[@class='theme-button danger mx-2 ng-star-inserted']");
    public By searchTextBox = By.id("filterSearch");
    public By directorFilter = By.xpath("//a[text()='Filter']");
    public By yearButton = By.xpath("//span[@class='mbsc-calendar-title mbsc-calendar-year mbsc-ios ng-star-inserted']");
    public By monthHeader = By.xpath("//span[contains(@class,'mbsc-calendar-month')]");
    public By yearHeader = By.xpath("//span[contains(@class,'mbsc-calendar-title mbsc-calendar-yea')]");
    //span[contains(@class,'mbsc-calendar-month')]
    //******************************************
    public By firstSearchedRecord = By.xpath("(//td[@class='tablewidth'])[4]");
    public By afterClickFromDate = By.xpath("//*[@id=\"filterShow\"]/div/div[2]/input");
    public By getAppointmentDetails = By.xpath("(//h5[@class='mb-0 text-purple'])[1]");
    public By saveBtnEditPlan = By.xpath("//button[@class='theme-button green mr-2']");
    public By otherComment = By.xpath("//textarea[@name='testSurveyComment']");
    public By collectPaymentTXT = By.xpath("(//h4[@class='text-center'])[1]");
    public By toDateText = By.xpath("//input[@formcontrolname='toDate']");
    public By fromDateText = By.xpath("//input[@formcontrolname='fromDate']");
    public By emailAddress = By.xpath("//input[@placeholder='Email Address']");
    public By saveBtnCalendar = By.xpath("//a[@class='theme-button green float-right mr-2']");

    public By goBackBtn=By.xpath("//a[@class='ml-auto grey theme-button']");
    //******************Verifying cancelled appointments*****************

    public void clickOn_TodayTab() {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        click_custom(appointmentsTab);

    }

    public void click_TestCompleteTab() {
        WebdriverWaits.waitUntilVisible(testCompleteTab);
        WebdriverWaits.waitForSpinner();
        click_custom(testCompleteTab);
    }

    public void click_TestReadyTab() {
        WebdriverWaits.waitUntilVisible(testReadyTab);
        WebdriverWaits.waitForSpinner();
        click_custom(testReadyTab);
    }


    public void click_UpcomingTab() {
        WebdriverWaits.waitUntilVisible(upcomingTab);
        WebdriverWaits.waitForSpinner();
        click_custom(upcomingTab);
    }


    public void enterFirstName(String cilentFirstNameText) {
        WebdriverWaits.waitUntilVisible(clientFirstName);
        sendKeys_withClear(clientFirstName, cilentFirstNameText);
    }


    public void enterLastName(String cilentLastNameText) {
        WebdriverWaits.waitUntilVisible(clientLastName);
        sendKeys_withClear(clientLastName, cilentLastNameText);
    }

    public void click_CloseButton() {
        WebdriverWaits.waitUntilVisible(saveBtnEditPlan);
        scrollIntoView(saveBtnEditPlan);
        clickBtn_custom(saveBtnEditPlan);
    }

    public void click_ToDate() {
        WebdriverWaits.waitUntilVisible(toDateText);
        clickBtn_custom(toDateText);
    }

    public void enter_OtherComments(String otherCommentText) {
        scrollIntoView(editTestPlanButton);
        WebdriverWaits.waitUntilVisible(otherComment);
        sendKeys_withClear(otherComment, otherCommentText);
    }


    public void click_Filter() {
        WebdriverWaits.waitUntilVisible(directorFilter);
        clickBtn_custom(directorFilter);
    }
    public void click_goBackBtn(){
        WebdriverWaits.waitUntilVisible(goBackBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(goBackBtn);
    }

    public void selectGradeType(int gradeType) {
        selectDropDownByIndex_custom(grade, gradeType);
    }

    public void selectSchoolType(int schoolTypeOption) {
        // click_custom(SchoolType);
        selectDropDownByIndex_custom(SchoolType, schoolTypeOption);
    }

    public void enterCellNumber(String cellNumberText) throws InterruptedException {
        WebdriverWaits.waitUntilVisible(cellNumber);
        click_custom(cellNumber);
        Thread.sleep(1000);
        sendKeys_withClear(cellNumber, cellNumberText);
    }

    public void click_UpcomingCard() {
        WebdriverWaits.waitUntilVisible(upcomingCard);
        clickBtn_custom(upcomingCard);
    }

    public void click_ExportCSVButton() {
        WebdriverWaits.waitUntilVisible(exportCSVButton);
        WebdriverWaits.waitForSpinner();
        click_custom(exportCSVButton);
    }

    public void click_LogOutLink() {
        WebdriverWaits.waitUntilVisible(logOutLink);
        WebdriverWaits.waitForSpinner();
        click_custom(logOutLink);
    }


    public void reasonForCallDropDown(String reasonForCallText) {
        selectDropDownByVisibleText_custom(reasonForCall, reasonForCallText);
    }

    public void enterTestAmount(String testAmountText) {
        WebdriverWaits.waitUntilVisible(testAmount);
        sendKeys_withClear(testAmount, testAmountText);
    }

    public void enterEmialAddress(String emailAddressText) {
        sendKeys_withClear(emailAddress, emailAddressText);
    }


    public void clickContinueToDepositButton() {
        click_custom(continueToDeposit);
    }
    public void enterInDateField(String dateOfBirthText) {
        click_custom(dateOfBirth);
        WebdriverWaits.waitUntilVisible(dateOfBirth);
        sendKeys_withClear(dateOfBirth, dateOfBirthText);
    }
    public void selectTestinglocation(String chooseLocationText) {
        WebdriverWaits.waitUntilVisible(chooseTestingLocation);
        clickBtn_custom(chooseTestingLocation, "ChooseLocation");
        selectDropDownByVisibleText_custom(chooseTestingLocation, chooseLocationText, "ChooseLocation");

    }
    public void locationName_Lists(){
        List<WebElement> locNames=getWebElements(locationLists,"Location List");
        ArrayList<String> dropdownValues = new ArrayList<>();
            for (WebElement option : locNames) {
                dropdownValues.add(option.getText());
                dropdownValues.remove("Choose Testing Location");
            }
        System.out.println(dropdownValues);
        }

    public void enterAmount(String enterAmountText) throws InterruptedException {
        WebdriverWaits.waitUntilInvisible(enterAmountField);
        WebdriverWaits.waitUntilVisible(enterAmountField);
        click_custom(enterAmountField);
        sendKeys_withClear(enterAmountField, enterAmountText);
    }
    public void clickCollectDepositButton() {
        WebdriverWaits.waitUntilVisible(collectDeposit);
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
    public void getTotalColumnCount(int count) throws InterruptedException {
        int colCount = getColumnCount();
        int expLocatorPos = (colCount - 1) * 7 + 1;
        System.out.println(expLocatorPos);

        Thread.sleep(7000);
        List<WebElement> list = getWebElements(slots, "AppointmentSlots");
        System.out.println(list.size());
        for (WebElement slot : list) {
            Thread.sleep(1000);
            scrolltoHorizontal();
            click_custom(slot);

            if (getWebElements(totalSlots).size() > count) {
                break;
            }
        }
    }
    public void click_CancelAppointmentButton() throws InterruptedException {
        refresh_Page();
        WebdriverWaits.waitUntilVisible(cancelButton);
        scrollIntoView(cancelButton);
        click_custom(cancelButton);
        WebdriverWaits.waitUntilVisible(radioBox);
        moveToElement(radioBox);
        click_custom(yesButton);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(4000);
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
    public void selectAppointmentSlot(int count) throws InterruptedException {
        click_AssessmentDate();
        String currentDate = getMonthAndYear();
        //validate_text(monthHeader, currentDate.split(" ")[0]);
        //validate_text(yearHeader, currentDate.split(" ")[1]);

        getTotalColumnCount(count);
        WebdriverWaits.waitUntilVisible(newEventText);
        validate_text(newEventText, "New Event");

        clickSlotSaveButton();
        WebdriverWaits.waitUntilVisible(newSlotText);
        validate_text(newSlotText, "New event");

        clickCalSaveButton();
    }
    public void selectAssesmentType(String assestmentTypeTexts) {
        WebdriverWaits.waitUntilVisible(assestmentType);
        WebdriverWaits.waitForSpinner();
        click_custom(assestmentType);
        selectDropDownByVisibleText_custom(assestmentType, assestmentTypeTexts);
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
        WebdriverWaits.waitUntilVisible(paymentPopUp);
        validate_text(paymentPopUp, "Booking Payment");

        enterAmount(enterAmountText);
        clickCollectDepositButton();
        WebdriverWaits.waitUntilVisible(actualText);
        validate_text(actualText, "Appointment Scheduled!!");
        clickViewDetailsButton();
        WebdriverWaits.waitForSpinner();
        Thread.sleep(5000);
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
        WebdriverWaits.waitUntilVisible(filterButton);
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
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
        WebdriverWaits.waitForSpinner();
    }


    public void exportCSV_Button() {
        click_AppointmentTab();
        click_ViewAllTab();
        click_ExportCSVButton();
    }


    public void filterRecords(String clientFirstName) {
        click_FilterButton();
        click_SearchField(clientFirstName);
        exportCSV_Button();
    }

    public void enterClientNameInSearchField(String nameOfClient) {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        click_custom(appointmentsTab);
        click_custom(viewAllTab);
        click_custom(filterButton);
        sendKeys_withClear(searchTextBox, nameOfClient);

    }

    public void ClickOn_FilterBtn() {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        click_custom(appointmentsTab);
        click_custom(upcomingTab);
        click_custom(filterButton);

    }


    public void click_AppointmentsTab() {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        click_custom(appointmentsTab);

    }

    public void click_CompletedTab() {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointmentsTab);
        WebdriverWaits.waitUntilVisible(completedTab);
        WebdriverWaits.waitForSpinner();
        click_custom(completedTab);
    }

    public void click_CanceledTab() {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointmentsTab);
        WebdriverWaits.waitUntilVisible(canceledTab);
        WebdriverWaits.waitForSpinner();
        click_custom(canceledTab);
    }

    public void click_HoldTab() {
        WebdriverWaits.waitUntilVisible(appointmentsTab);
        WebdriverWaits.waitForSpinner();
        click_custom(appointmentsTab);
        WebdriverWaits.waitUntilVisible(holdtab);
        WebdriverWaits.waitForSpinner();
        click_custom(holdtab);
    }
    public void navigate_appointmentDashboardPage(){
        click_goBackBtn();
      }
}