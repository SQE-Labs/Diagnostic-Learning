package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {
    public By paymentTab= By.xpath("//a[text()='Payments']");
    public By paymentListPage=By.xpath("//h3[text()='Payments']");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@aria-controls='paymentTable']");
    public By cust_Name=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By getCust_Name =By.xpath("(//td)[1]");
    public By fromToDateField=By.xpath("//input[@placeholder='%s']");

    public By paymentButton=By.xpath("//button[@class='theme-button green m-2 ng-star-inserted']");
    public By amountDue=By.xpath("//p[@class='text-danger']");
    public By enterAmountField=By.xpath("//input[@placeholder='Enter Amount']");

    public By closeButton=By.xpath("(//a[text()='Close'])[2]");
    public By collectButton=By.xpath("//button[@class='theme-button mx-2']");
    public By viewReceiptButton=By.xpath("//button[text()=' View Receipt ']");

    public By testFeeAdjustment = By.xpath("//*[@id=\"paymentModal\"]/div/div/table/tbody/tr[3]/td[2]/input");

    public By closeButtonPopUp = By.xpath("(//a[text()='Close'])[2]");
    public By ValMsgAfterNegativeValueTXT = By.xpath("//div[@class='validation-message ng-star-inserted']");
    public By collectAmountAdjustment = By.xpath("//*[@id='paymentModal']/div/div/table/tbody/tr[4]/td[2]/input");


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
    public void click_filterButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
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

}
