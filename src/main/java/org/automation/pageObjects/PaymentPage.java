package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {


    public By paymentTab= By.xpath("//a[text()='Payments']");
    public By cancelBtn= By.xpath("//a[text()='Cancel']");
    public By collectAmountButton= By.xpath("//div[@class='action border-top pt-4 text-center']/a//following-sibling::button");
    public By amountDueInDisplay= By.xpath("//label[text()='Amount Due']//following-sibling::p");

    public By assessmentAmountInDisplay= By.xpath("//label[text()='Assessment Amount']//following-sibling::p");
    public By paymentListPage=By.xpath("//h3[text()='Payments']");

    public By receivedAmountOnDisplay=By.xpath("//label[text()='Received Amount']//following-sibling::p");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@aria-controls='paymentTable']");
    public By cust_Name=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By getCust_Name =By.xpath("(//td)[1]");
    public By paymentLinkButton=By.xpath("//a[text()='Payment Link']");
    public By fromToDateField=By.xpath("//input[@placeholder='%s']");

    public By paymentButton=By.xpath("//button[@class='theme-button green m-2 ng-star-inserted']");
    public By paymentBtn=By.xpath("//button[text()=' Payment ']");
    public By amountDue=By.xpath("//p[@class='text-danger']");
    public By enterAmountField=By.xpath("//input[@placeholder='Enter Amount']");

    public By closeButton=By.xpath("(//a[text()='Close'])[2]");
    public By collectButton=By.xpath("//button[@class='theme-button mx-2']");
    public By viewReceiptButton=By.xpath("//button[text()=' View Receipt ']");
    public By clickCloseButton= By.xpath("(//a[text()='Close'])[2]");
    public By testFeeAdjustment = By.xpath("//*[@id=\"paymentModal\"]/div/div/table/tbody/tr[3]/td[2]/input");

    public By closeButtonPopUp = By.xpath("(//a[text()='Close'])[2]");
    public By ValMsgAfterNegativeValueTXT = By.xpath("//div[@class='validation-message ng-star-inserted']");
    public By collectAmountAdjustment = By.xpath("//*[@id='paymentModal']/div/div/table/tbody/tr[4]/td[2]/input");
    public By usernamePaymentMerchant= By.xpath("(//form[@class='form']/fieldset/label)[1]");

    public void click_PaymentTab(){
        WebdriverWaits.waitUntilVisible(paymentTab);
        WebdriverWaits.waitForSpinner();
        click_custom(paymentTab);
    }

    public void click_CollectButton(){
        WebdriverWaits.waitUntilVisible(collectButton);
        WebdriverWaits.waitForSpinner();
        click_custom(collectButton);
    }

    public void click_PaymentLinkButton(){

        WebdriverWaits.waitUntilVisible(paymentLinkButton);
        WebdriverWaits.waitForSpinner();
        click_custom(paymentLinkButton);
        WebdriverWaits.waitForSpinner();
        switchToWindow("Child Window");
    }
    public void viewReceiptButtonDisplayed()
    {
        WebdriverWaits.waitUntilVisible(viewReceiptButton);
        WebdriverWaits.waitForSpinner();
        click_custom(viewReceiptButton);


    }

    public void clickOn_CollectBtn()
    {
        WebdriverWaits.waitUntilVisible(collectButton);
        WebdriverWaits.waitForSpinner();
        click_custom(collectButton);
    }
    public void click_PaymentBtn()
    {
        WebdriverWaits.waitUntilVisible(paymentButton);
        WebdriverWaits.waitForSpinner();
        click_custom(paymentButton);

    }
    public void viewReceiptButtonNotDisplayed() {
        WebdriverWaits.waitUntilVisible( paymentButton);
        WebdriverWaits.waitForSpinner();
        click_custom( paymentButton);
    }


    public void send_AmountInEnterAmount(String amount)
    {
        WebdriverWaits.waitUntilVisible(enterAmountField);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(enterAmountField,amount);
    }
    public void clickOn_CancelBtn()
    {
        WebdriverWaits.waitUntilVisible(cancelBtn);
        WebdriverWaits.waitForSpinner();
        click_custom(cancelBtn);
    }


    public void clickOn_CloseBtn()
    {
        WebdriverWaits.waitUntilVisible(closeButton);
        WebdriverWaits.waitForSpinner();
        click_custom(closeButton);
    }
    public void click_filterButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
    }


    public void scrollUptoVAmountDue()
    {
        WebdriverWaits.waitUntilVisible(amountDue);
        WebdriverWaits.waitForSpinner();
        scrollIntoView(amountDue);
    }
    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }
    public void click_CloseBtn_PopUp(){
        WebdriverWaits.waitUntilVisible(closeButtonPopUp);
        WebdriverWaits.waitForSpinner();
        click_custom(closeButtonPopUp);
    }




    public void enter_collectAmountAdjustment(String testFeeAdjustmentTXT){
        WebdriverWaits.waitUntilVisible(collectAmountAdjustment);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(collectAmountAdjustment,testFeeAdjustmentTXT);
    }

    public void enter_TestFeeAdjustment(String testFeeAdjustmentTXT){
        WebdriverWaits.waitUntilVisible(testFeeAdjustment);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(testFeeAdjustment,testFeeAdjustmentTXT);
    }

    public void search_CreatedDiagnostician(String UserName)  {
        click_filterButton();
        enterInSearchField(UserName);
        ActionEngine.getValueAttribute(searchField,"placeholder");
    }




    public void clickOn_PaymentBtn()
    {

        WebdriverWaits.waitForSpinner();
        WebdriverWaits.waitUntilVisible(paymentBtn);
        scrollIntoView(paymentBtn);

        click_custom(paymentBtn);
    }

    public void enter_ValueInTestFeeAdjustmentField(String value)
    {
        WebdriverWaits.waitUntilVisible(paymentBtn);
        sendKeys_withClear(paymentBtn, value);
    }

    public void click_OnCollectAmountBtn()
    {
        WebdriverWaits.waitUntilVisible(collectAmountButton);
        click_custom(collectAmountButton);
    }

    public void click_CloseBtn()
    {
        WebdriverWaits.waitUntilVisible(clickCloseButton);
        click_custom(clickCloseButton);
    }



    public float retrieveAmount(By locator)

    {

          scrollIntoView(locator);
          String getValue=getText(locator);
        // split
         String replaceValue=getValue.replace( "$","");
        //String to float value
        float floatValue=Float.valueOf(replaceValue);
        return floatValue;
    }



}
