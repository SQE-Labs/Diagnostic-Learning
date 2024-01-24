package org.automation.pageObjects;


import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.automation.base.BaseTest.getDriver;

public class ChromeDownloads extends ActionEngine {
    public By fileLink = By.cssSelector("a[id='file-link']");
    public By shadowRoot = By.cssSelector("#shadow-root");


    public String getFileName() {
        getDriver().navigate().to("chrome://downloads/");
        WebdriverWaits.waitUntilVisible(By.cssSelector("downloads-manager"));
        WebElement shadowHost1 = getDriver().findElement(By.cssSelector("downloads-manager"));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
        WebElement shadowHost3 = shadowRoot1.findElement(By.cssSelector("downloads-item"));
        SearchContext shadowRoot3 = shadowHost3.getShadowRoot();
        WebElement element = shadowRoot3.findElement(By.cssSelector("#title-area"));
        return element.getText();
    }

    public static void uploadFileUsingRobot(String filepath) throws AWTException {
        // creating object of Robot class
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

}
