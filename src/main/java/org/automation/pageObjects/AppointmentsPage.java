package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import java.io.File;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static org.automation.utilities.Assertions.validate_text;


public class AppointmentsPage extends BasePage {
    public By appointmentsTab= By.xpath("//a[text()=' Appointments ']");
    public By viewAllTab=By.xpath("//a[text()='View All']");
    public By upcomingTab=By.xpath("//a[text()='Upcoming']");
    public By completeTab=By.xpath("//a[text()='Completed ']");
    public By dashBoardPage=By.xpath("//h3[text()='Dashboard']");
    public By allAppointmentsPage=By.xpath("//h3[text()='All Appointments']");
    public By searchedText=By.cssSelector("tr:not([style='display: none;' ]) td:nth-child(1)");
    public String searchedTexts ="//table[@id='appointmentTable']//tbody//td[contains(text(),'%s')]";

    public By searchByDate=By.xpath("//td[text()='(//td)[1]']");
    public By filterButton = By.xpath("//a[text()='Filter']");
    public By searchField=By.xpath("//input[@id='filterSearch']");
    public By dateFrom=By.xpath("//input[@placeholder='From Date']");
    public By toDate=By.xpath("//input[@placeholder='To Date']");
    public By searchButton=By.xpath("//button[text()='Search']");
    public By exportCSVButton=By.xpath("//button[text()='Export to CSV']");
    public By viewDetails=By.xpath("(//a[text()='View Detail'])[1]");
    public By App_Text=By.xpath("//h3");
    public By viewStudentObservationButton=By.xpath("//a[text()='View Student Observation']");
    public By viewDocumentsButton=By.xpath("//a[text()='View Documents']");
    public By clientObservation=By.xpath("//h4[text()='Client Observation']");
    public By attachedDocument=By.xpath("//h5[text()='Attached Documents']");
    public By backButton=By.xpath("//a[text()='Back']");
    WebdriverWaits wait=new WebdriverWaits();

    public void click_AppointmentTab(){
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("ngx-spinner-overlay"));
        WebdriverWaits.WaitUntilVisible(appointmentsTab);
        click_custom(appointmentsTab);
    }
    public void click_ViewAllTab(){
        WebdriverWaits.WaitUntilVisible(viewAllTab);
        click_custom(viewAllTab);
    }
    public void click_CompleteTab(){
        WebdriverWaits.WaitUntilVisible(completeTab);
        click_custom(completeTab);
    }
    public void click_FilterButton(){
        wait.WaitUntilVisible(filterButton);
         click_custom(filterButton);
    }
    public void clickOn_ExportCSVButton(){
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("ngx-spinner-overlay"));
        WebdriverWaits.WaitUntilVisible(exportCSVButton);
        click_custom(exportCSVButton);
    }
    public void click_SearchField(String searchFieldText){
        sendKeys_withClear(searchField,searchFieldText);
    }
    public void enter_Dates(String dateFromText,String toDateText) throws InterruptedException {
        click_custom(dateFrom);
        sendKeys_withClear(dateFrom,dateFromText);
         wait. WaitUntilVisible(toDate);
        click_custom(toDate);
        sendKeys_withClear(toDate,toDateText);
        wait.WaitUntilVisible(searchButton);
        click_custom(searchButton);
    }
    public void clickOn_ViewDetails(){
        click_custom(viewDetails);
    }
    public void clickOn_viewStudentObservationButton(){
        click_custom(viewStudentObservationButton);
    }
    public void clickOn_viewDocumentsButton(){
        click_custom(viewDocumentsButton);
    }
    public void clickOn_BackButton(){
        WebdriverWaits.WaitUntilInvisible(By.cssSelector("div.ngx-spinner-overlay"));
        WebdriverWaits.WaitUntilVisible(backButton);
        click_custom(backButton);
    }

    public void viewAllAppointmentsPage(String diagnosticianFirstName,String diagnosticianLastName) throws InterruptedException {
         WebdriverWaits.WaitUntilVisible(dashBoardPage);
          validate_text(dashBoardPage,"Dashboard");
        Log.info("DashBoard page appear after superAdmin logged in");

        click_AppointmentTab();
        validate_text(viewAllTab,"View All");
        Log.info("View all details tab successfully displayed");



        click_ViewAllTab();
        WebdriverWaits.WaitUntilVisible(allAppointmentsPage);
        validate_text(allAppointmentsPage,"All Appointments");
        Log.info("Successfully All appointments page displayed");

//        click_FilterButton();
//        WebdriverWaits.WaitUntilVisible(searchByDate);
//       // enter_Dates(dateFromText, toDateText);
//        validate_text(searchByDate,diagnosticianFirstName);
//        Log.info("Successfully searched created appointment By entering dates");

       // getDriver().navigate().refresh();// To-DO

        click_FilterButton();
        click_SearchField(diagnosticianFirstName);
        WebdriverWaits.WaitUntilVisible(searchedText);
        validate_text(searchedText,diagnosticianFirstName+' '+diagnosticianLastName);
        Log.info("Successfully searched created appointment");

    }
    public void exportCSV_Button(){
        click_AppointmentTab();
        click_ViewAllTab();
        clickOn_ExportCSVButton();
    }

    public void View_DetailsPage(){
        click_AppointmentTab();
        click_ViewAllTab();
       // clickOn_ViewDetails();
    }
    public void View_CompleteTab(){
        click_AppointmentTab();
        click_CompleteTab();
        clickOn_ViewDetails();
    }
    public void view_ClientObservation_Page() throws InterruptedException {
        clickOn_viewStudentObservationButton();
        WebdriverWaits.WaitUntilVisible(clientObservation);
        validate_text(clientObservation,"Client Observation");
        clickOn_viewDocumentsButton();
        WebdriverWaits.WaitUntilVisible(attachedDocument);
        validate_text(attachedDocument,"Attached Documents");
        WebdriverWaits.Refresh_Page();
        clickOn_BackButton();
    }
}
