package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {
    public By paymentTab= By.xpath("//a[text()='Payments']");
    public By paymentListPage=By.xpath("//h3[text()='Payments']");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");
    public By cust_Name=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By getCust_Name =By.xpath("(//td)[1]");
    public By fromToDateField=By.xpath("//input[@placeholder='%s']");


    public void clickOn_PaymentTab(){
        WebdriverWaits.waitUntilVisible(paymentTab);
        WebdriverWaits.waitForSpinner();
        click_custom(paymentTab);
    }
    public void click_filterButton() {
        WebdriverWaits.waitForSpinner();
        click_custom(filterButton);
    }
    public void enterInSearchField(String searchFieldText) {
        WebdriverWaits.waitUntilVisible(searchField);
        sendKeys_withClear(searchField, searchFieldText);
    }
    public void search_CreatedDiagnostician(String UserName)  {
        click_filterButton();
        enterInSearchField(UserName);
        ActionEngine.GetValueAttribute(searchField,"placeholder");
    }

}
