package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class ReschedulePage extends BasePage
{

    public By diagonsticianField = By.xpath("//input[@placeholder='Select Diagnostician']");
    public By dateField = By.xpath("//input[@placeholder='Date']");
    public By timeField=By.xpath("//input[@placeholder='Time']");



    public void click_OnDiagonsticianField()
    {
        WebdriverWaits.waitUntilVisible(diagonsticianField);
        WebdriverWaits.waitForSpinner();
        click_custom(diagonsticianField);
    }

    public void dateField()
    {
        WebdriverWaits.waitUntilVisible(diagonsticianField);
        WebdriverWaits.waitForSpinner();

    }




}
