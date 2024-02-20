package org.automation.utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.automation.base.BaseTest;
import org.automation.elements.Element;
import org.automation.logger.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

public class WebdriverWaits extends BaseTest {

    //  public static WebDriverWait wait = new WebDriverWait((WebDriver) driver,Duration.ofSeconds(2));

    /**
     * Waits for a given element to be selected
     *
     * @param waitTime  WebDriver instance
     * @param locator By of the element to wait for
     */


    /**
     * Waits for a given element to be clickable
     *
     * @param waitTime  WebDriver instance
     * @param locator By to locate element to wait for
     */

    /**
     * Waits for the page to have a given title
     * <p>
     * This method is an attempt to address a problem where Chrome/IE drivers
     * are trying to check the page title on page load before the title has
     * changed to that of the new page.
     *
     * @param waitTime WebDriver instance
     * @param title  title the page should have
     */


    /**
     * Sleep script for the specified length
     * (generally not an ideal solution)
     *
     * @param length
     */
    public static void sleep(long length) {
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            /*
             * Log.error("Sleep Interrupted"); e.printStackTrace();
             */
        }
    }


    public static void SwitchToNewTab() throws InterruptedException {
        String originalHandle = getDriver().getWindowHandle();
        Set<String> tabs = getDriver().getWindowHandles();

        for (String handle : tabs) {
            if (!handle.equals(originalHandle)) {
                getDriver().switchTo().window(handle);
            }
        }

        Thread.sleep(3000);
    }

    public static void waitUntilInvisible(By element) {
        try {
            Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtil.getPropertyValue("waitTime")))).pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtil.getPropertyValue("pollingTime")))).ignoring(NoSuchElementException.class);
            fluentWait1.until(ExpectedConditions.invisibilityOf(getDriver().findElement(element)));

        } catch (WebDriverException e) {
        }
    }


    public static void byToWebelement(By element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ele = driver.get().findElement(element);
        js.executeScript(String.valueOf(ele));
    }


    public String getText_custom(By path) {
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

    public Boolean waitUntilVisibleAllElements(List<WebElement> element) {
        try {
            Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtil.getPropertyValue("waitTime"))))
                    .pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtil.getPropertyValue("pollingTime"))))
                    .ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
            fluentWait1.until(ExpectedConditions.visibilityOfAllElements(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilPresent(By element) {
        Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtil.getPropertyValue("waitTime"))))
                .pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtil.getPropertyValue("pollingTime"))))
                .ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
        fluentWait1.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void WaitUntilElementPresent(By locator, int tries) {

        for (int i = 0; i < tries; i++) {
            try {
                Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(getDriver())
                        .withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtil.getPropertyValue("waitTime"))))
                        .pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtil.getPropertyValue("pollingTime"))))
                        .ignoring(NoSuchElementException.class);
                fluentWait1.until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (Exception e) {
                // throw new RuntimeException (e);
            }
        }
    }

    public static void waitUntilVisible(By element) {
        try {

            Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtil.getPropertyValue("waitTime"))))
                    .pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtil.getPropertyValue("pollingTime"))))
                    .ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
            fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {

        }
    }

    public static Boolean waitForElementInteractable(By element) {

        try {
            Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtil.getPropertyValue("waitTime"))))
                    .pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtil.getPropertyValue("pollingTime"))))
                    .ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
            fluentWait1.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    public static void clickByJsExecuter(By element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement ele = getDriver().findElement(element);
        try {
            jse.executeScript("arguments[0].click();", ele);
            extentTest.log(LogStatus.PASS, "Clicked on the : " + element);
        } catch (Exception E) {
            extentTest.log(LogStatus.FAIL, "Clicked failed on the : " + element);
            throw new RuntimeException(E);
        }
    }

    public static void moveToElement(By element) {
        WebElement ele = getDriver().findElement(element);
        Actions act = new Actions(getDriver());
        act.moveToElement(ele).click().build().perform();
    }

    public static void moveToEleByWE(WebElement element) {
        Actions act = new Actions(getDriver());
        act.moveToElement(element).click().build().perform();
    }

    public static void waitForSpinner() {
        By loginLoading = By.cssSelector("div.ngx-spinner-overlay");
        try {
            Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtil.getPropertyValue("waitTime"))))
                    .pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtil.getPropertyValue("pollingTime"))))
                    .ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
            fluentWait1.until(ExpectedConditions.invisibilityOfElementLocated(loginLoading));
        } catch (WebDriverException e) {
        }
    }


}







