package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class SuperAdminPage extends BasePage {
    public By viewStudentObservationButton= By.xpath("//a[@class='theme-button green ml-2 ng-star-inserted']");

    public By viewDocumentsButton=By.xpath("//a[@class='ml-2 theme-button green ng-star-inserted']");
    public By clientObservation=By.xpath("//h4");
    public By backButton=By.xpath("//a[@class='grey ml-3 theme-button']");
    public By exportCSVButton = By.xpath("//button[text()='Export to CSV']");

    public void click_ViewStudentObservationButton(){
        WebdriverWaits.waitUntilVisible(viewStudentObservationButton);
        WebdriverWaits.waitForSpinner();
        click_custom(viewStudentObservationButton);
    }
    public void click_BackButton(){
        WebdriverWaits.waitUntilVisible(backButton);
        click_custom(backButton);
    }

    public void view_ClientObservation_Page(){
        click_ViewStudentObservationButton();
    }

    public void click_Export_CSV_Button(){
        WebdriverWaits.waitUntilVisible(exportCSVButton);
        WebdriverWaits.waitForSpinner();
        click_custom(exportCSVButton);
    }
}

