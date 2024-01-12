package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {
    public By paymentTab= By.xpath("//a[text()='Payments']");
    public By paymentListPage=By.xpath("//h3[text()='Payments']");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By loginLoading=By.cssSelector("div.ngx-spinner-overlay");
    public By cust_Name=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public String cust_Names ="//table[@id='paymentTable']//tbody//td[contains(text(),'%s')]";

    public By paymentButton=By.xpath("//button[@data-target='#paymentModal']");
    public By titleForCollectPaymentPopup=By.xpath("//h4[text()='Collect Payment']");

    public By click_0nCanelButton= By.xpath("//a[text()='Cancel']");

    public By testFeeAdjustmentField= By.xpath("(//input[@type='text'])[1]");

    public By sendValueInCollectAmountAdjustmentField= By.xpath("(//input[@type='text'])[2]");

    public By sendValueInEnterAmountField= By.id("bookingDeposit");
    public By collectAmountButton= By.xpath("//div[@class='action border-top pt-4 text-center']/a//following-sibling::button");

    public By assessmentAmountInDisplay= By.xpath("//label[text()='Assessment Amount']//following-sibling::p");

    public By amountDueInDisplay= By.xpath("//label[text()='Amount Due']//following-sibling::p");
    public By receivedAmountInDisplay= By.xpath("//label[text()='Received Amount']//following-sibling::p");
    public By clickOnCloseButton= By.xpath("(//a[text()='Close'])[2]");
    public By clickCloseButton= By.xpath("(//a[text()='Close'])[2]");


    public By fromToDateField=By.xpath("//input[@placeholder='%s']");
//    public By toDateField=By.xpath("//input[@placeholder='To Date']");
  //  (//table[@id='appointmentTable']//td[contains(text(),'AU_Trent')]//following-sibling::td//a)[1]

    public void clickOn_PaymentTab(){
        WebdriverWaits.WaitUntilVisible(paymentTab);
        WebdriverWaits.WaitUntilInvisible(paymentTab);
        click_custom(paymentTab);
    }
    public void click_filterButton() {
        WebdriverWaits.WaitUntilInvisible(loginLoading);
        WebdriverWaits.WaitUntilVisible(filterButton);
        click_custom(filterButton);
    }
    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.WaitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }
    public void search_CreatedDiagnostician(String UserName) throws InterruptedException {
        click_filterButton();
        enterInSearchField(UserName);
    }

    public void enterFeeAdjustment(String value)
    {
        sendKeys_custom(testFeeAdjustmentField,value);

    }

    public void clickCollectAmountButton()
    {
        click_custom(collectAmountButton);
    }

    public void clickCloseButton()
    {
        click_custom(clickCloseButton);
    }

    public void clickPaymentButton()
    {
        scrollIntoView(paymentButton);
        click_custom(paymentButton);
    }



   // div:not([style='height: 99.5657%; top: 0%; width: 100%;']) [class='mbsc-ios mbsc-ltr mbsc-schedule-header-day mbsc-schedule-header-day-today mbsc-selected ng-star-inserted']

}
