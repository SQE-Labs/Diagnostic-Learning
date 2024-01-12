package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    public By scheduleAppointment = By.xpath("//li[@id='Schedule Appointment']");


    public void clickScheduleAppointment()  {
        WebdriverWaits.WaitUntilVisible(scheduleAppointment);
        WebdriverWaits.WaitUntilInvisible(scheduleAppointment);
        clickBtn_custom(scheduleAppointment);
    }
}
