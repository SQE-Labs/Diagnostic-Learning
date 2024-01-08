package org.automation.utilities;

import org.automation.elements.Element;
import org.automation.logger.Log;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

import static org.automation.base.BaseTest.extentTest;
import static org.automation.base.BaseTest.getDriver;

public class Assertions {


    public static String getText_custom(By path) {
        String text = "";
        try {

            Element element = new Element("", path);
            text = element.getText();
            Log.info("Text for " + path + " is " + text);
            extentTest.log(PASS, "Text retrieved is: " + text);
            return text;
        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to get text due to exception : \n" + e);

        }
        return text;
    }

    public static void validate_text(By element, String expected) {
        WebdriverWaits.waitForSpinner();;
        SoftAssert softAssert = new SoftAssert();
        String actual = Assertions.getText_custom(element);
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
    }
    public static void validate_AttText(String actual, String expected) {
        WebdriverWaits.waitForSpinner();;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
    }
    public static void validate_SelectedOption(By element, String expected) {
        WebdriverWaits.waitUntilVisible(element);
        Select select= new Select(getDriver().findElement(element));
        String selectedOption = select.getFirstSelectedOption().getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(selectedOption, expected);
        softAssert.assertAll();

    }

    public static void validate_text_withTrim(By element, String expected) {
        WebdriverWaits.waitForSpinner();;
        SoftAssert softAssert = new SoftAssert();
        String actual = Assertions.getText_custom(element);
        softAssert.assertEquals(actual.trim(), expected.trim());
        softAssert.assertAll();
    }
    public  void validate_SuccessTXTByString(By element, String expected) throws InterruptedException {
//        SoftAssert softAssert = new SoftAssert();
//        String actual = Assertions.getText_custom();
//        softAssert.assertEquals(actual, expected);
//        softAssert.assertAll();
        WebElement strvalue = getDriver().findElement(element);
        String Expected = "Text to compare";
        String Actual = strvalue.getText();
        System.out.println(Actual);

        if(expected.equals(Actual)){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
    }


}