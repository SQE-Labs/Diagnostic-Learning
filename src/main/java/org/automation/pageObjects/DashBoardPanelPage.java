package org.automation.pageObjects;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import test.SuperAdminTest;

import java.io.*;
import java.util.List;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

public class DashBoardPanelPage extends BasePage {
    public By logOutLink = By.xpath("//a[text()='Log Out']");
    public By directorsTab = By.xpath("//li[@id='Directors']");
    public By diagnosticianLink = By.xpath("//a[text()='Diagnosticians']");
    public By adminButton = By.xpath("//a[text()='Admins']");
    public By paymentButton = By.xpath("//a[text()='Payments']");
    public By backButton = By.xpath("//button[text()='Back']");
    public By exportCSVButton = By.xpath("//button[text()='Export to CSV']");
    public By AppointmentsTab = By.xpath("//a[@class='collapsed']");
    public By availabilityTab = By.xpath("//a[text()='Availability']");
    public By editButton = By.xpath("(//a[text()='Edit'])[1]");
    public By viewAllTab = By.xpath("//a[text()='View All']");
    public By spinner = By.cssSelector("div.ngx-spinner-overlay");
    public By viewDetailLink = By.xpath("tr:not([style='display: none;' ]) td:nth-child(1)");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField = By.xpath("//input[@id='filterSearch']");



    public void click_LogOutLink() {
        WebdriverWaits.waitUntilVisible(logOutLink);
        click_custom(logOutLink);
    }


    public void click_ViewAllTab() {
        WebdriverWaits.waitUntilVisible(viewAllTab);
        WebdriverWaits.waitForSpinner();
        click_custom(viewAllTab);
    }

    public void click_DirectorTab() {
        WebdriverWaits.waitUntilVisible(directorsTab);
        WebdriverWaits.waitForSpinner();
        click_custom(directorsTab);
    }

    public void click_DiagnosticianTab() {
        WebdriverWaits.waitUntilVisible(diagnosticianLink);
        WebdriverWaits.waitForSpinner();
        click_custom(diagnosticianLink);
    }

    public void click_On_AdminTab() throws InterruptedException {

        WebdriverWaits.waitUntilVisible(adminButton);
        WebdriverWaits.waitForSpinner();
        Thread.sleep(5000);
        click_custom(adminButton);
    }

    public void click_On_PaymentTab() {
        WebdriverWaits.waitUntilInvisible(spinner);
        click_custom(paymentButton);
    }

    public void edit_Director() {
        click_custom(editButton);
    }

    public void clickOn_BackButton() {
        WebdriverWaits.waitUntilVisible(backButton);
        click_custom(backButton);
    }

    public boolean isFileDownloaded(String fileName) throws InterruptedException, FileNotFoundException {
        Thread.sleep(10000);
        String home = System.getProperty("user.home");
        String file_with_location = home + "/Downloads/" + fileName;
        File file = new File(file_with_location.trim());
       // String fileTest = file.getName();
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

    public void clickOn_ExportCSVButton() {
        click_custom(exportCSVButton);
    }

    public void clickOn_AppointmentsTab() {
        WebdriverWaits.waitForSpinner();
        click_custom(AppointmentsTab);
    }

    public void click_Availability() {
        WebdriverWaits.waitUntilVisible(availabilityTab);
        WebdriverWaits.waitForSpinner();
        click_custom(availabilityTab);
    }

    public  String RecentUser() throws InterruptedException {
        // driver.get(DataInterface.AdminURL);
        //click_custom(filterButton);
        Thread.sleep(4000);
        return getText_custom(DiagnosticianPage.userNameText);
    }


        public static void readCSVFile() throws IOException, CsvException {
        String path = "C:\\Users\\SQE Labs\\Downloads\\.csv(10)";
            Reader reader = new FileReader(path);
            CSVReader csvreader = new CSVReader(reader);
            List<String[]> data = csvreader.readAll();
            for(String[] d : data){
                for(String c : d ){
                    System.out.println(c);
                }
            }

        }

    }

