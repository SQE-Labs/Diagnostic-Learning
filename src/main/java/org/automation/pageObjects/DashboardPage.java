package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.WebdriverWaits.moveToElement;

public class DashboardPage extends BasePage {

    public By scheduleAppointment = By.xpath("//li[@id='Schedule Appointment']");

    public By clientNameFromBCGForm=By.xpath("(//h6[@class='mb-3 text-purple'])[1]//following-sibling::div//td/a");

    public By clientNameFromFollowup=By.xpath("(//h6[@class='mb-3 text-purple'])[4]//following-sibling::div//td/a");
    public void clickScheduleAppointment()  {
        WebdriverWaits.waitUntilVisible(scheduleAppointment);
        WebdriverWaits.waitForSpinner();
        moveToElement(scheduleAppointment);
    }
}

