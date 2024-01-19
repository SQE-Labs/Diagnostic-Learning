package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class SuperAdminPage extends BasePage {
    public By viewStudentObservationButton= By.xpath("//a[@class='theme-button green ml-2 ng-star-inserted']");
    public By viewDocumentButton=By.xpath("//a[@class='ml-2 theme-button green ng-star-inserted']");
    public By clientObservation=By.xpath("//h4");
    public By backButton=By.xpath("//a[@class='grey ml-3 theme-button']");

    public void clickOn_ViewStudentObservationButton(){
        WebdriverWaits.waitUntilVisible(viewStudentObservationButton);
        WebdriverWaits.waitForSpinner();
        click_custom(viewStudentObservationButton);
    }
    public void clickOn_BackButton(){
        WebdriverWaits.waitUntilVisible(backButton);
        click_custom(backButton);
    }

    public void view_ClientObservation_Page(){
        clickOn_ViewStudentObservationButton();
    }
}