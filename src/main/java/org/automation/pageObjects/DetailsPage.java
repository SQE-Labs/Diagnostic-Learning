package org.automation.pageObjects;


import org.automation.base.BasePage;
import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
public class DetailsPage extends BasePage
{
    public By paymentButton=By.xpath("//button[@data-target='#paymentModal']");
    public By titleForCollectPaymentPopup=By.xpath("//h4[text()='Collect Payment']");

    public By click_0nCanelButton= By.xpath("//a[text()='Cancel']");

    public By sendValueInTestFeeAdjustmentField= By.xpath("(//input[@type='text'])[1]");

    public By sendValueInCollectAmountAdjustmentField= By.xpath("(//input[@type='text'])[2]");

    public By sendValueInEnterAmountField= By.id("bookingDeposit");
    public By collectAmountButton= By.xpath("//div[@class='action border-top pt-4 text-center']/a//following-sibling::button");

    public By assessmentAmountInDisplay= By.xpath("//label[text()='Assessment Amount']//following-sibling::p");

    public By amountDueInDisplay= By.xpath("//label[text()='Amount Due']//following-sibling::p");
    public By receivedAmountInDisplay= By.xpath("//label[text()='Received Amount']//following-sibling::p");
    public By clickOnCloseButton= By.xpath("(//a[text()='Close'])[2]");
    public By clickCloseButton= By.xpath("(//a[text()='Close'])[2]");


    public void click_PaymentButton()
    {
        click_custom(paymentButton);
    }
    //Payment Section

    public String getAssessmentAmount()
    {
        return getText_custom(assessmentAmountInDisplay);

    }

    public String getAmountDue()
    {
        return getText_custom(amountDueInDisplay);

    }

    public String getReceivedAmount()
    {
        return getText_custom(receivedAmountInDisplay);

    }

}
