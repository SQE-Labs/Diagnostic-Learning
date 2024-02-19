package org.automation.pageObjects;


import org.automation.base.BasePage;
import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DetailsPage extends BasePage {
    public By paymentButton = By.xpath("//button[@data-target='#paymentModal']");
    public By assessmentAmountInDisplay = By.xpath("//label[text()='Assessment Amount']//following-sibling::p");

    public By amountDueInDisplay = By.xpath("//label[text()='Amount Due']//following-sibling::p");
    public By receivedAmountInDisplay = By.xpath("//label[text()='Received Amount']//following-sibling::p");


    public String getAssessmentAmount() {
        return getText_custom(assessmentAmountInDisplay);

    }

    public String getAmountDue() {
        return getText_custom(amountDueInDisplay);

    }

    public String getReceivedAmount() {
        return getText_custom(receivedAmountInDisplay);

    }

}
