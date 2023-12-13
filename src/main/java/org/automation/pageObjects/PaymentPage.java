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
    public By cust_Name=By.xpath("//td[text()='Guard Bittle ']");
    public By fromDateField=By.xpath("//input[@placeholder='From Date']");
    public By toDateField=By.xpath("//input[@placeholder='To Date']");

    public void clickOn_PaymentTab(){
        WebdriverWaits.WaitUntilVisible(paymentTab);
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

}
