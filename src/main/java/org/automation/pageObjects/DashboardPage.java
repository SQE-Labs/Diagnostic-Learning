package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.WebdriverWaits.moveToElement;

public class DashboardPage extends BasePage {

    public By scheduleAppointment = By.xpath("//a[text()='Schedule Appointment']");

    public By clientNameFromBCGForm=By.xpath("(//h6[@class='mb-3 text-purple'])[1]//following-sibling::div//td/a");

    public By clientNameFromFollowup=By.xpath("(//h6[@class='mb-3 text-purple'])[4]//following-sibling::div//td/a");

    public By searchTextBox = By.id("filterSearch");
    public void clickScheduleAppointment()  {
        WebdriverWaits.waitUntilVisible(scheduleAppointment);
        WebdriverWaits.waitForSpinner();
        click_custom(scheduleAppointment);
    }

    public void clickOn_ClientNameBackgroundSection()
    {
        WebdriverWaits.waitUntilVisible(clientNameFromBCGForm);
        WebdriverWaits.waitForSpinner();
        click_custom(clientNameFromBCGForm);

    }

    public void clickOn_ClientNameFollowupSection()
    {
        WebdriverWaits.waitUntilVisible(clientNameFromFollowup);
        WebdriverWaits.waitForSpinner();
        click_custom(clientNameFromFollowup);

    }

    public void enter_ValidData(String text)
    {
        WebdriverWaits.waitUntilVisible(clientNameFromFollowup);
        WebdriverWaits.waitForSpinner();
        sendKeys_withClear(searchTextBox,text );

    }
}

