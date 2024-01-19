package test;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomStrings;


import org.automation.utilities.*;
import org.openqa.selenium.By;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.*;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;


import static org.automation.utilities.Assertions.*;
import static org.automation.utilities.WebdriverWaits.waitForSpinner;
import static test.SuperAdminTest.adminUserName;


public class AdminTest extends BaseTest {


SuperAdminTest Superadmin=new SuperAdminTest();
SuperAdminPage superAdmin=new SuperAdminPage();

      public static String clientLastName;
      public static String diagnosticianUserName;
    DashBoardPanelPage dashboard=new DashBoardPanelPage();
    String directorFirstName;
    String directorUserName;
    String dirCellNumber;
    String directorEmailAddress;
    String directorLastName;
    public static String clientFirstName;
    String clientEmail;
    String clientEmail2;
    String clientCellNumber;
     String diagnosticianFirstName;
     String diagnosticianLastName;
     String diagnosticianEmailAddress;
     List<WebElement>  diagList;
     String holdAppointmentname;
    String expectedTextforToayTitle="Today's Appointments";
    public By fullNameOfClient=By.xpath("//label[text()='Full Name']/following-sibling::p");

    @Test(priority = 0, enabled = true, description = "Verify admin is able to login with valid credentials")
     public void admin_login(){
    LoginPage login = new LoginPage();
    login.adminLogin(adminUserName,"12345678");
    AdminPage dasboard = new AdminPage();
    WebdriverWaits.waitForSpinner();
    validate_text(dasboard.adminDashboardText,"Dashboard");
    }

   //********* Create Daignostician by admin
    @Test(priority = 1, enabled = true, description = "Create diagnostician by admin")
    public void create_Diagnostician() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
        DashBoardPanelPage tab = new DashBoardPanelPage();
        AdminPage reAssign= new AdminPage();
        // Click on diagnostician tab from left panel.
        tab.click_DiagnosticianTab();
        WebdriverWaits.waitUntilVisible(diagnostician.diagListPageText);
        validate_text(diagnostician.diagListPageText,"Diagnosticians List");
        //Create Diagnostician.
        diagnosticianFirstName = "AU_Amy"+ RandomStrings.requiredCharacters(2);
        diagnosticianLastName = "AU_Katie"+ RandomStrings.requiredCharacters(2);
        diagnosticianUserName= "Au_Tran" + RandomStrings.requiredCharacters(2);
        diagnosticianEmailAddress = diagnosticianFirstName+ "10@yopmail.com";
        String diagnosticianPhoneNumber = RandomStrings.requiredDigits(10);
        diagnostician.create_Diagnostician(diagnosticianFirstName,diagnosticianLastName,diagnosticianPhoneNumber,diagnosticianEmailAddress,diagnosticianUserName,"123456","123456");
        WebdriverWaits.waitUntilVisible(diagnostician.actualText);
        //validate Diagnostician
        validate_text(diagnostician.actualText,diagnosticianUserName);
        diagList= reAssign.get_diagList(reAssign.diagList);

    }
    @Test(priority = 2,enabled = true,description = "Set availability for diagnostician by admin")
    public void diagnostician_Availability() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage logout = new DashBoardPanelPage();
        logout.click_LogOutLink();
        diagnostician.login_As_Diagnostician(diagnosticianUserName,"123456");
        diagnostician.set_Availability();
        validate_text(diagnostician.avaActualText,"Available");
        logout.click_LogOutLink();

    }

    @Test(priority = 3, enabled = false, description = "Creating Director from admin" )
    public void create_Director() throws InterruptedException {
        DashBoardPanelPage panelpage=new DashBoardPanelPage();
        DirectorPage director = new DirectorPage();
        LoginPage login = new LoginPage();
        login.adminLogin( adminUserName,"12345678");
        directorFirstName = "AU_Arlo" + RandomStrings.requiredCharacters(2);
        directorLastName = "AU_Joel" + RandomStrings.requiredCharacters(2);
        directorEmailAddress = directorFirstName + "@yopmail.com";
        directorUserName = "AU_Koa" + RandomStrings.requiredCharacters(2);
        dirCellNumber=RandomStrings.requiredDigits(10);
        panelpage.click_DirectorTab();
        validate_text(director.directorActualText,"Directors List");
        director.create_Director(directorFirstName, directorLastName, dirCellNumber, directorEmailAddress, directorUserName, "123456", "123456");
        panelpage.click_LogOutLink();

    }


    @Test(priority= 4,enabled = false,description = "Set availability for director by admin.")
    public void director_Availability() throws InterruptedException {
        LoginPage login=new LoginPage();
        DashBoardPanelPage panelPage=new DashBoardPanelPage();
        login.directorLogin(directorUserName,"123456");
        DirectorPage director=new DirectorPage();
        panelPage.click_Availability();
        director.director_Availability();
        panelPage.click_LogOutLink();

    }

    @Test(priority = 5, enabled = true, description = "Appointment scheduled by admin for a client")
    public void schedule_Appointment() throws InterruptedException {
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        login.adminLogin( adminUserName,"12345678");
        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation(1);
        validate_SelectedOption(appPage.chooseTestingLocation,"Plano");
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType(1);
        validate_SelectedOption(appPage.assestmentType,"Adult ADHD Only");
    }

    @Test(priority = 6, enabled = true, description = "Filling client details by admin.")
     public void fill_clientDetailsSection() throws InterruptedException {
        AppointmentsPage fillClientDetails = new AppointmentsPage();
        clientFirstName="Au_Theo"+RandomStrings.requiredCharacters(2);
        clientLastName="Au_Finn"+RandomStrings.requiredCharacters(2);
        clientCellNumber=RandomStrings.requiredDigits(10);
        clientEmail=clientFirstName+ "@yopmail.com";
        clientEmail2= clientFirstName+"101@yopmail.com";
        fillClientDetails.fill_clientDetailsSection( clientFirstName, clientLastName, 1,"19-11-2000",1, clientCellNumber, clientEmail, "Other","New York","Texas","30052" ,"1000","900");
    }



    @Test(priority = 7, enabled = false, description = "Verify that admin is able to cancel the appointment or not")
    public void cancel_Appointment() {
        AppointmentsPage appPage=new AppointmentsPage();
        appPage.cancelAppointment();
    }
    @Test(priority = 8,enabled = false,description = "Diagnostician is verifying cancelled appointments")
    public void verify_CancelledAppointment(){
        AdminPage admin=new AdminPage();
        admin.verify_CancelledApp(clientFirstName);
        WebdriverWaits.waitUntilVisible(admin.clientName);
        WebdriverWaits.waitForSpinner();
        validate_text(admin.clientName,clientFirstName+' '+clientLastName);
    }

    @Test(priority = 9, enabled = false, description = "Appointment scheduled by admin for a client")
    public void reSchedule_Appointment() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        AppointmentsPage appPage = new AppointmentsPage();
        AppointmentsPage fillClientDetails = new AppointmentsPage();

        dashboard.clickScheduleAppointment();
        appPage.selectTestinglocation("Austin");
        appPage.selectAppointmentSlot();
        appPage.selectAssesmentType(1);
        validate_SelectedOption(appPage.assestmentType,"Adult ADHD Only");
        fillClientDetails.fill_clientDetailsSection( clientFirstName, clientLastName, 1,"19-11-2000",1, "7654436788", clientEmail, "Other","New York","Texas","30052" ,"1000","900");
    }

    //********************** Create Follow Up For Client ***********************//


    @Test(priority = 10, enabled = true, description = "Creat follow up for client by admin")
    public void create_FollowUp()  {
      AdminPage followUp= new AdminPage();
        followUp.Create_FollowUp();
        validate_text(followUp.validateScheduledFollowUp,"Follow Up Scheduled!!");
        followUp.click_BackBtn();
    }
    @Test(priority = 11, enabled = false, description = "Re-Assign Appointment for client by admin")
    public void re_AssignAppointment() throws InterruptedException {
        AdminPage reAssign = new AdminPage();
        reAssign.click_ReAssignBn();
        WebdriverWaits.waitUntilVisible(reAssign.reAssignDiagList);
        List<WebElement> reassigList= reAssign.get_diagList(reAssign.diagList);
        boolean result = reAssign.compare_DiagAndReAssignDiagList(diagList,reassigList);
        Assert.assertTrue(result);

    }
    @Test(priority = 11, enabled = false, description = "Re-Assign Appointment for client by admin")
    public void edit_AssessmentTypePopUp()throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.click_EditAssessment();
        validate_text(editType.assType,"Change Assement Type");

    }
    @Test(priority = 12, enabled = false, description = "Verify Edit Assessment type button .")
    public void edit_AssessmentType() throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("IQ");
        editType.click_UpdateBtn();
        WebdriverWaits.waitUntilVisible(editType.clientAsses);
        validate_text(editType.clientAsses,"IQ");

    }
    @Test(priority = 13, enabled = true, description = "Verify Test plan button on <Client> details page.")
    public void verify_TestPlanBtn()  throws InterruptedException{
        AdminPage testPlan = new AdminPage();
        WebdriverWaits.waitForSpinner();
        testPlan.click_TestPlan();
        validate_text(testPlan.testPlanText,"Please choose tests.");
    }
    @Test(priority = 14, enabled = true, description = "Verify save Test plan button on <Client> details page.")
    public  void plan_Test() throws InterruptedException{
        AdminPage testPlan = new AdminPage();
        testPlan.select_TestPlan();
        testPlan.click_TestPlanSaveButton();
        WebdriverWaits.waitUntilVisible(testPlan.validateCheckBox);
        validate_text(testPlan.validateCheckBox,"WJ Achievement");
    }
    @Test(priority = 15, enabled = false, description = "Verify save Test plan button on <Client> details page.")
    public void dont_SaveAssessmentType() throws InterruptedException{
        AdminPage editType = new AdminPage();
        editType.edit_AssessmentType("GT");
        editType.click_DontSave();
        validate_text(editType.clientAsses,"IQ");
    }
    @Test(priority = 16, enabled = false, description = "Verify save Test plan button on <Client> details page.")
    public void edit_Testplan() throws InterruptedException{
        AdminPage testPlan = new AdminPage();
        testPlan.edit_TestPlan();
        validate_text(testPlan.actualEditTest,"WRAML");

    }
    //***************************** Collect Payment PopUp *************************//
    public float beforeAssessmentAmount;
    public float beforeAmountDue;
    public float beforeReceviedAmount;
    public float afterAssessmentAmount;
    public float afterAmountDue;
    public float afterRececiedAmount;
    @Test(priority = 17, enabled = false, description = "Verify payment button on <Client> details page.")
    public void verify_PaymentBtn() {
        AdminPage payment = new AdminPage();
        beforeAssessmentAmount= Float.parseFloat(payment.get_AssessmentAmount());
        beforeAmountDue= Float.parseFloat(payment.get_AmountDue());
        beforeReceviedAmount = Float.parseFloat(payment.get_ReceivedAmount());
        payment.click_PaymentBtn();
        WebdriverWaits.waitUntilVisible(payment.collectPayActualText);
        validate_text(payment.collectPayActualText,"Collect Payment");
    }

    @Test(priority = 18, enabled = false, description = "Verify payment button on <Client> details page.")
    public void verify_CollectTestFeeAdjustment()  {
        AdminPage payment = new AdminPage();
        payment.validate_FeeAdjustmentAmount("100");
        payment.validate_CollectAmountAdjustment("100");
        afterAssessmentAmount= Float.parseFloat(payment.get_AssessmentAmount());
        afterAmountDue= Float.parseFloat(payment.get_AmountDue());
        afterRececiedAmount= Float.parseFloat(payment.get_ReceivedAmount());
        String assessmentAmtDiff = Float.toString (afterAssessmentAmount-beforeAssessmentAmount).replace(".0","");
        String recAmtDiff = Float.toString (afterRececiedAmount-beforeReceviedAmount).replace(".0","");
        Assert.assertEquals(assessmentAmtDiff,"100");
        Assert.assertEquals(recAmtDiff,"200");
        WebdriverWaits.waitUntilVisible(payment.fullPayActualText);
        validate_text(payment.fullPayActualText,"Full Paid");
    }


    @Test(priority = 18, enabled = false, description = "Verify Edit client Details button client page.")
    public void verify_EditClientBtn()  {
        AdminPage EditClient = new AdminPage();
        EditClient.click_EditClientBtn();
        WebdriverWaits.waitUntilVisible(EditClient.editCllientActualText);
        validate_text(EditClient.editCllientActualText,"Edit Client Info");
    }
    @Test(priority = 19, enabled = false, description = "Verify Edit client details popup client page.")
    public void verify_UpdateBtn()  {
        AdminPage editClient= new AdminPage();
        editClient.edit_ClientInfo("Zoi","Smith","401 Broadway E eastate g","College");
        editClient. click_UpdateClientBtn();
        WebdriverWaits.waitUntilVisible(editClient.actualTextClient);
        validate_text(editClient.actualTextClient,"College");
    }

    @Test(priority = 20, enabled = false, description = "Verify All Appointment page.")
    public void verify_AllAppointmentsPage()   {
        AppointmentsPage appPage= new AppointmentsPage();
        appPage.click_AppointmentTab();
        appPage.click_ViewAllTab();
        validate_text(appPage.viewAllActualText,"All Appointments");
    }
    @Test(priority = 21, enabled = false, description = "Verify filter button and serarchtextbox textbox")
    public void search_CreatedAppointment()  {
        AppointmentsPage appPage= new AppointmentsPage();
        AdminPage placeHolder = new AdminPage();
        appPage.click_FilterButton();
        String text = appPage.GetValueAttribute(appPage.searchTextBox,"placeholder");
        String fromDateplaceholder = placeHolder.GetValueAttribute(placeHolder.fromDateText,"placeholder");
        Assert.assertEquals(fromDateplaceholder,"From Date");
        Assert.assertEquals(text,"Type here to search");
    }
    @Test(priority = 22, enabled = false, description = "Verify search fromDate and toDate")
    public void verify_FromAndToDate() throws InterruptedException{
        AppointmentsPage appPage= new AppointmentsPage();
        ActionEngine engine;
        engine = new ActionEngine();
        String toDate= DateGenerator.getCurrentDate();
        String FromDate= DateGenerator.getDateWithDays("yyyy-MM-dd",-2);
        appPage.enter_Dates(FromDate,toDate);
        WebdriverWaits.waitUntilVisible(appPage.dateElements);
        List<WebElement> my_list = engine.getWebElements(appPage.dateElements);
        HashSet<WebElement> dateSet = new HashSet<>(my_list);
        LocalDate toDateLocal= LocalDate.parse(toDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fromDateLocal= LocalDate.parse(FromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean result = true;
        for (WebElement i:dateSet){
            String date =i.getText();
            LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            System.out.println(inputDate);
            if( !(DateGenerator.isDateWithinRange(fromDateLocal,toDateLocal,inputDate))){
                result=false;
                break;
            }
        }
        Assert.assertTrue(result);
    }
    @Test(priority = 23,enabled = false,description="verify hold appointment button.")
    public void verify_HoldAppointmentBtn()   {
        AdminPage hold = new AdminPage();
        hold.click_HoldAppointmentBtn();
        validate_text(hold.holdActualText, "Are you sure you want to hold this appointment?");
        holdAppointmentname= hold.getText_custom(hold.fullName);
        Log.info(holdAppointmentname);
    }
    @Test(priority = 24,enabled = false,description="verify yes hold button on hold appointment button.")
    public void verify_yesHoldBtn()  {
        AdminPage hold = new AdminPage();
        hold.click_yesHoldBtn();
        WebdriverWaits.waitUntilVisible(hold.allAppointmentsPage);
        validate_text(hold.allAppointmentsPage,"All Appointments");
    }
    @Test(priority = 25,enabled = false,description="verify yes hold button on hold appointment popup.")
    public void verify_HoldAppointment()  {
        AdminPage hold = new AdminPage();
        hold.click_HoldTab();
        validate_text(hold.holdAppointmentText,"Hold Appointments");
    }
    @Test(priority = 26,enabled = false,description="verify filter button on hold appointment page.")
    public void verify_holdfilterButton()  {
        AdminPage hold = new AdminPage();
        hold.click_HoldFilterBtn();
        String searchPlaceHolder = hold.GetValueAttribute(hold.searchTextBox,"placeholder");
        String fromDateplaceholder = hold.GetValueAttribute(hold.fromDateText,"placeholder");
        String toDatePlaceholder = hold.GetValueAttribute(hold.toDateText,"placeholder");
        Assert.assertEquals(fromDateplaceholder,"From Date");
        Assert.assertEquals(toDatePlaceholder,"To Date");
        Assert.assertEquals(searchPlaceHolder,"Type here to search");
    }
    @Test(priority = 27,enabled = false,description="verify holded appointment .")
    public void verify_holdedAppointment() {
        AdminPage hold = new AdminPage();
        hold.send_textHoldSearchBox(holdAppointmentname);
        String name = getText_custom(hold.validateHoldClient);
        Log.info(name);
        validate_text(hold.validateHoldClient,holdAppointmentname);
    }

    @Test(priority = 30, enabled = true, description = "Admin is directed to 'Today's Appointment' page")
    public void todayAppointment_Tab() throws InterruptedException

    {
         AdminPage admin= new AdminPage();
         DateGenerator datePage=new DateGenerator();
         LoginPage login = new LoginPage();
         login.adminLogin( "allen","123456");
         admin.clickOn_AppointmentTab();
         admin.click_TodayTab();
         validate_text(admin.todayAppointmentTitle,expectedTextforToayTitle);
         String expectedDate=datePage.getCurrentDateFromSystem();
         validate_text(admin.todayDateOnCard,expectedDate);

    }

    @Test(priority = 30, enabled = true, description = "Admin is directed to 'Client Details' page of Today's appointment card")
    public void clientDetails_Page() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin( "allen","123456");
        admin.clickOn_AppointmentTab();
        admin.click_TodayTab();
        String actualText = getText_custom(admin.nameOnCard);
        admin.click_OnCard();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedTitleText);
    }

    @Test(priority = 30, enabled = true, description = "Admin is directed to 'Test Ready Appointment' page")
    public void testReady_Tab() throws InterruptedException
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        String expectedTitle="Test Ready Appointments";
        admin.clickOn_AppointmentTab();
        admin.click_TestReadyTab();
        validate_text(admin.getTestReadyTitle,expectedTitle);
        admin.testReadyCardDetails();
        String expectedStatus="Test Ready";
        validate_text(admin.getStatus,expectedStatus);

    }

    @Test(priority = 30, enabled = true, description = "Admin is directed to 'Client Details' page of Test ready card")
    public void clientDetailsPage_OfTestReady() throws InterruptedException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin( "allen","123456");
        admin.clickOnAppointmentTab();
        admin.click_TestReadyTab();
        String actualText = getText_custom(admin.nameOnCard);
        admin.click_OnCard();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println(expectedTitleText);
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedTitleText);
    }

    @Test(priority = 30, enabled = true, description = "Admin is directed to 'Upcoming Appointment' page")
    public void upcoming_Tab() throws InterruptedException
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        String expectedTitle="Upcoming Appointments";
        admin.clickOnAppointmentTab();
        admin.click_UpcomingTab();
        validate_text(admin.titleOfUpcomingPage,expectedTitle);
        admin.filter_ForUpcoming();
        String statusTestReady="Test Ready";
        String statusUpcoming="Upcoming";
        validate_text(admin.getStatus,statusUpcoming);
        admin.filter_ForTestReady();
        validate_text(admin.getStatus,statusTestReady);
    }

    @Test(priority = 30, enabled = true, description = "Admin is able to click on filter button")
    public void click_OnFilterBtn() throws InterruptedException
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.verify_UserClick_OnFilterBtn();

       //Search field
        String actualSearchText = getDriver().findElement(By.xpath("//input[@id='filterSearch']")).getAttribute("placeholder");
        System.out.println(actualSearchText);
        String expectedSearchText="Type here to search";
        validate_AttText(actualSearchText, expectedSearchText);

        //From Date
        String actualFromDateText = getDriver().findElement(By.xpath("//input[@placeholder='From Date']")).getAttribute("placeholder");
        System.out.println(actualFromDateText);
        String expectedFromDateText="From Date";
        validate_AttText(actualFromDateText, expectedFromDateText);

        //To Date
        String actualToDateText = getDriver().findElement(By.xpath("//input[@placeholder='To Date']")).getAttribute("placeholder");
        System.out.println(actualToDateText);
        String expectedToDateText="To Date";
        validate_AttText(actualToDateText, expectedToDateText);


    }

    @Test(priority = 30, enabled = true, description = "Admin is able to click on Export CSV button")
    public void click_OnExportCSVButton() throws InterruptedException, FileNotFoundException {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.click_OnExportCSVButton();
        String downloadFile = dashboard.getDownloadFileName();
        Assert.assertTrue(dashboard.isFileDownloaded(downloadFile));

    }
    @Test(priority = 30, enabled = true, description = "Admin is able to click client detail page after clicking on 'View Details' button")
    public void click_OnViewDetailsButton()  {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.click_OnAppointmentsTab();
        String actualText = getText_custom(admin.getNameOfClient);
        admin.click_OnViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println(expectedTitleText);
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedTitleText);


    }

    @Test(priority = 30, enabled = true, description = "Admin is able to click on 'Test Ready' subtab")
    public void click_OnTestCompleteSubtab()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.click_OnTestCompleteTab();
        String expectedText="Test Complete Appointments";
        String actualText = getText_custom(admin.getTitleOfTestComplete);
        validate_AttText(actualText, expectedText);

    }

    @Test(priority = 30, enabled = true, description = "Admin is able to click on 'View Details button of 'Test Complete' subtab")
    public void click_OnTestCompleteViewBtn()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        String expectedTitle="View Student Observation";
        admin.click_OnTestCompleteTab();
        String actualText = getText_custom(admin.getNameOfClient);
        admin.click_OnViewDetailsBtn();
        String clientName = getText_custom(admin.clientNameDetail);

        String[] words = clientName.split(" ");
        String expectedTitleText=null;
        if (words.length >= 2) {
            // Fetch the first two words
            String firstWord = words[0];
            String secondWord = words[1];
            expectedTitleText = firstWord + " " + secondWord;

            // Print the result
            System.out.println(expectedTitleText);
            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
        } else {
            // Handle the case where there are not enough words
            System.out.println("The input string does not contain at least two words.");
        }

        validate_AttText(actualText, expectedTitleText);
        validate_text(superAdmin.viewStudentObservationButton,expectedTitle );


    }

    @Test(priority = 30, enabled = true, description = "Admin is able to click on 'View Observation' button")
    public void click_OnViewObservationBtn()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.click_OnTestCompleteTab();
        admin.click_OnViewDetailsBtn();
        admin.click_OnViewObservationBtn();
        String expectedText="Client Observation";
        String actualText = getText_custom(superAdmin.clientObservation);
        validate_AttText(actualText, expectedText);

    }

    @Test(priority = 30, enabled = true, description = "Admin is able to click on 'View Observation' button")
    public void click_OnViewDocumentBtn()
    {
        AdminPage admin = new AdminPage();
        LoginPage login = new LoginPage();
        login.adminLogin("allen", "123456");
        admin.click_OnTestCompleteTab();
        admin.click_OnViewDetailsBtn();
        admin.click_OnViewObservationBtn();
        admin.click_OnViewDocumentBtn();
        String expectedText="Attached Documents";
        validate_text(admin.getTitleOfAttachedDocument, expectedText);



    }

    //************************ Edit Diagnostician *********************//
    @Test(priority = 23,enabled = false, description = "Search created diagnostician by admin")
    public void search_Diagnostician()  {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        DashBoardPanelPage clickDiagnosticianTab = new DashBoardPanelPage();
        clickDiagnosticianTab.click_DiagnosticianTab();
        diagnostician.search_CreatedDiagnostician(diagnosticianUserName);
        validate_text(diagnostician.actualText, diagnosticianUserName);
    }
    @Test(priority = 24,enabled = false, description = "Edit created diagnostician by admin")
    public void Edit_Diagnostician() throws InterruptedException{
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        // Edit Diagnostician
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.edit_Diagnostician(diagnosticianUpdatedEmail,"1234567","1234567");
        WebdriverWaits.waitUntilVisible(diagnostician.edit_Succ_Msg);
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }
    @Test(priority = 24,enabled = false, description = "Enable created diagnostician by admin")
    public void Enable_CreateDiagnostician()throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        //Enable disabled Diagnostician
        diagnostician.enable_DiagnosticianUser();
        validate_text(diagnostician.edit_Succ_Msg, "Diagnostician details updated successfully.");
    }


    @Test(priority = 25,enabled = false, description = "Verify Don't save button diagnostician by admin")
    public void verify_Dnt_SaveButton() throws InterruptedException {
        DiagnosticianPage diagnostician = new DiagnosticianPage();
        String diagnosticianPhoneNumber= RandomStrings.requiredDigits(10);
        String diagnosticianUpdatedEmail= diagnosticianFirstName + "10@yopmail.com";
        diagnostician.verify_DontSave(diagnosticianPhoneNumber,diagnosticianUpdatedEmail,"1234567","1234567");
        validate_text(diagnostician.actualText,diagnosticianUserName);
    }
    //******************* Edit Director ***************//


    @Test(priority = 26, enabled = false, description = "Creating Director from admin" )
    public void edit_Director() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        DashBoardPanelPage clickDirectorTab = new DashBoardPanelPage();
        clickDirectorTab.click_DirectorTab();
        directorEmailAddress = directorFirstName + "010@yopmail.com";
        director.edit_Director(directorEmailAddress,"12345678","12345678");
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
    }

    @Test(priority = 27, enabled = false, description = "Enable toggle button Director from admin" )
    public void director_Enable_User() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        director.enable_Director();
        validate_text(director.edit_SuccMsg,"Director details updated successfully.");
        System.out.println("Successfully Edited the created director");
    }

    @Test(priority = 28,enabled = false,description="verify that director is able to edit or not after clicking dont save button")
    public void Verify_DntSave_Button() throws InterruptedException {
        DirectorPage director = new DirectorPage();
        String  directorEmailAddressUpdated = directorFirstName + "101@yopmail.com";
        director.not_Edit_Director(directorEmailAddressUpdated,"123456","123456");
        WebdriverWaits.waitUntilVisible(director.UserNameGetText);
        validate_text(director.UserNameGetText, directorUserName);
    }

    //******************** Logout button **************//
    @Test(priority = 29, enabled = true, description = "Verify login button for admin.")
    public void admin_LogOut()  {
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        panelpage.click_LogOutLink();
    }

    @Test( dependsOnMethods={ "download_CSV_File_For_completeAss"})
    public void full_Payment() throws InterruptedException {
        LoginPage login=new LoginPage();
        AdminPage admin=new AdminPage();
        DashBoardPanelPage panelpage = new DashBoardPanelPage();
        login.adminLogin(adminUserName, "12345678");
        admin.paying_DueAmount(clientFirstName);
        WebdriverWaits.waitUntilVisible(admin.clientNameDetail);
        validate_text(admin.clientNameDetail,clientFirstName +' '+ clientLastName +' '+ "Details");
        panelpage.click_LogOutLink();
    }
}


