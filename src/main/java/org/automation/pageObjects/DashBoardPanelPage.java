package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import test.SuperAdminTest;

import java.io.File;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

public class DashBoardPanelPage extends BasePage {
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By directorsTab= By.xpath("//li[@id='Directors']");
    public By diagnosticianLink = By.xpath("//a[text()='Diagnosticians']");
    public By adminButton=By.xpath("//a[text()='Admins']");
    public By paymentButton=By.xpath("//a[text()='Payments']");
    public By backButton=By.xpath("//button[text()='Back']");
    public By exportCSVButton=By.xpath("//button[text()='Export to CSV']");
    public By AppointmentsTab=By.xpath("//a[text()=' Appointments ']");
    public By availabilityTab=By.xpath("//a[text()='Availability']");



    public void click_LogOutLink() {
        //  WebdriverWaits.WaitUntilInvisible(logOutLink);
        WebdriverWaits.WaitUntilVisible(logOutLink);
        click_custom(logOutLink);
    }

    public void click_DirectorTab()     {
        WebdriverWaits.WaitUntilVisible(directorsTab);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(directorsTab);
    }

    public void click_DiagnosticianTab() {
        WebdriverWaits.WaitUntilVisible(diagnosticianLink);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(diagnosticianLink);
    }
    public void click_On_AdminTab(){
        WebdriverWaits.WaitUntilVisible(adminButton);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(adminButton);
    }
    public void click_On_PaymentTab(){
        WebdriverWaits.WaitUntilVisible(paymentButton);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(paymentButton);
    }
    public void clickOn_BackButton(){
        WebdriverWaits.WaitUntilVisible(backButton);
        click_custom(backButton);
    }
    public boolean isFileDownloaded(String fileName) throws InterruptedException {
        Thread.sleep(10000);
        String home = System.getProperty("user.home");
        String file_with_location = home + "/Downloads/" + fileName;
        File file = new File(file_with_location.trim());
        String fileTest = file.getName();
        if (file.exists() && file.length() != 0) {
            System.out.println(file_with_location + " is present with size greater than 0 ");
            extentTest.log(PASS, file_with_location + " is present  with size greater than 0");
            return true;
        } else {
            System.out.println(file_with_location + " is not present");
            extentTest.log(FAIL, file_with_location + " is not  present ");

            return false;
        }
    }
    public String getDownloadFileName() {

        ChromeDownloads download = new ChromeDownloads();
        String downloadedFile = download.getFileName();
        return downloadedFile;
    }
    public void clickOn_ExportCSVButton(){
        WebdriverWaits.WaitUntilVisible(exportCSVButton);
        click_custom(exportCSVButton);
    }
    public void clickOn_AppointmentsTab(){
        WebdriverWaits.WaitUntilVisible(AppointmentsTab);
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        click_custom(AppointmentsTab);
    }
    public void clickOn_AvailabilityTab(){
        WebdriverWaits.WaitUntilVisible(availabilityTab);
        click_custom(availabilityTab);
    }
}
