package com.HRM.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.PageObjects.ApplyLeaves;
import com.HRM.PageObjects.ChangePassword;
import com.HRM.PageObjects.GenerateRequest;
import com.HRM.PageObjects.LoginPage;
import com.HRM.PageObjects.MyAttendance;
import com.HRM.PageObjects.PersonalDetailsPage;
import com.HRM.PageObjects.Reports_LeaveDetails;
import com.HRM.PageObjects.TrainingSummary;



public class Final_TestCase_Run extends BaseClass
{
@Test(priority=1,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void loginTest() throws InterruptedException
{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	
	
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(username);
	lp.setpassword(password);
	lp.clickSubmit();
	logger.info("Logged-In successfully");
	Thread.sleep(3000);
	
	if(driver.getTitle().equals("Dashboard"))
	{
		Assert.assertTrue(true);
			logger.info("Dashboard Title verified successfully");
	}
	else
	{
		Assert.assertTrue(false);
			logger.info("Login failed");
	}	
}

@Test(priority=2,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void checkLoginHours() throws InterruptedException
{
	MyAttendance ma = new MyAttendance(driver);
	ma.clickPersonalInformationLink();
	Thread.sleep(2000);
	ma.clickOnMyAttendance();
	Thread.sleep(2000);	

	WebElement select=driver.findElement(By.xpath("//select[@name='empid']"));
	Select EmpId=new Select(select);
	EmpId.selectByVisibleText("Self");
    Thread.sleep(1000);
    
	//Select from and To date and click on submit button.
    driver.findElement(By.xpath("//input[@name='fromDateComp']")).clear();
	driver.findElement(By.xpath("//input[@name='fromDateComp']")).sendKeys("16-Apr-2020");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@name='toDateComp']")).clear();
	driver.findElement(By.xpath("//input[@name='toDateComp']")).sendKeys("16-Apr-2020");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
	 Thread.sleep(5000);
	 
	 /* not executing this block of code, verify later
	String Atcual=driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[3]/table/tbody/tr[1]/td[2]")).getText();
 	String Expected="Mahesh Jutti";
 	Assert.assertEquals(Atcual, Expected);	
 	*/
 	
	 driver.findElement(By.xpath("//span[contains(text(), 'incorrect punch')]")).click();
	 Thread.sleep(5000);
	 logger.info("My Attendance Details displayed successfully");
	 
	 //check punching details
	 driver.findElement(By.xpath("//button[contains(text(), 'Close')]")).click();
	 Thread.sleep(2000);
	 
	} 



@Test(priority=3,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void checkPersonalDetails() throws InterruptedException
{
	PersonalDetailsPage PDP = new PersonalDetailsPage(driver);
	//PDP.clickonPersonalInformation();
	PDP.clickonPersonalDetails();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[3]/span[1]/i")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='HAddress']")).clear();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='HAddress']")).sendKeys("Bangalore");
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[3]/span[2]/i")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[2]/div[3]/div/div[1]/table/tbody/tr[1]/td[4]/span[1]")).click();
	driver.findElement(By.xpath("//input[@id='txtMobile']")).clear();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='txtMobile']")).sendKeys("9739459767");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='ContactPhone']")).click();
	Thread.sleep(1000);
	

	driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[2]/div[3]/div/div[1]/table/tbody/tr[1]/td[4]/span[2]/i")).click();
	Thread.sleep(3000);
	
	String Atcual=driver.findElement(By.xpath("//span[contains(text(), 'Personal details Updated Successfully')]")).getText();
	String Expected="Personal details Updated Successfully";
	Assert.assertEquals(Atcual, Expected);
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
	Thread.sleep(3000);

}

@Test(priority=4,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void applyLeave() throws InterruptedException
{	
	ApplyLeaves al=new ApplyLeaves(driver);
	al.clickLeaveApplicationDetails();
	Thread.sleep(1000);
	al.clickonApplyLeave();
	Thread.sleep(2000);
	
	
	//Apply Casual Leave
	WebElement leaveType = driver.findElement(By.xpath("//select[@id='leavetype']"));
	Select select = new Select(leaveType);
	select.selectByVisibleText("Loss Of Pay");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//input[@name='fromDate']")).sendKeys("27-Apr-2020");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='toDate']")).sendKeys("27-Apr-2019");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Automation Testing");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='reset']")).click();
	Thread.sleep(3000);
	logger.info("Leave Applied Successfully");
	
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("SL");		//filter/search sick leave
	Thread.sleep(2000);

}


@Test(priority=5,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void GenerateRequest() throws InterruptedException
{	
	GenerateRequest gr = new GenerateRequest(driver);
	gr.setPayRollInformation();
	Thread.sleep(2000);
	
	gr.setGenerateRequest();
	Thread.sleep(2000);

	
	driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Automation Testng, Please ignore this message");
	Thread.sleep(3000);
	logger.info("Generate Request message successfully");
	
	//driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
	
	//Account Details
	driver.findElement(By.xpath("//a[contains(text(), 'Bank Account Details')]")).click();
	Thread.sleep(2000);
	logger.info("Opened Bank Account Details Successfully");
	
	
	driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
	Thread.sleep(2000);

}


@Test(priority=6,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void traningSummary() throws InterruptedException
{
	TrainingSummary ts = new TrainingSummary(driver);
	ts.clickonLearningDevelopment();
	Thread.sleep(2000);
	
	ts.clickOnTraningSummary();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[contains(text(), 'Add Training Summary')]")).click();
	Thread.sleep(2000);

	
	
	WebElement courseName=driver.findElement(By.xpath("//select[@id='ddlCourseName']"));
	Select select = new Select(courseName);
	select.selectByVisibleText("Artificial Intelligence");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@name='AddStartDate']")).sendKeys("01-Apr-2020");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='AddEndDate']")).sendKeys("30-Apr-2020");
	Thread.sleep(2000);
	
	
	WebElement status=driver.findElement(By.xpath("//select[@id='ddlStatus']"));
	Select select1 = new Select(status);
	select1.selectByVisibleText("Enroll");
	Thread.sleep(2000);	
	
	//driver.findElement(By.xpath("//*[@id="addDetailsForm"]/div[2]/button[2]")).click(); //save training summary
	
	driver.findElement(By.xpath("//button[contains(text(), 'Close') and @type='reset']")).click();		
	logger.info("Training Sumamry added successfully");
	Thread.sleep(3000);

	
	driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
	Thread.sleep(2000);

}


@Test(priority=7,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void changePassword() throws InterruptedException
{
	ChangePassword cp = new ChangePassword(driver);
	cp.setPassword();
	Thread.sleep(2000);

	cp.clickonChangepassword();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@name='newpassword']")).sendKeys("Testing123");
	Thread.sleep(1000);

	driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys("Testing123");
	Thread.sleep(1000);
	
	//driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();		click on submit
	
	driver.findElement(By.xpath("//button[contains(text(), 'Cancel   ')]")).click();
	logger.info("Password Changed Successfully");
	Thread.sleep(3000);
	
	
	driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
	Thread.sleep(2000);
	
	
}

@Test(priority=8,description = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
public void leaveDetails() throws InterruptedException
{			
	Reports_LeaveDetails leavedetails=new Reports_LeaveDetails(driver);
	leavedetails.clickonReport();
	
	leavedetails.clickOnLeaveDetails();
	Thread.sleep(2000);
	
	//From date selected by Javascript Executor 
	WebElement date=driver.findElement(By.xpath("//input[@name='fromDateLR']"));
	    String dateVal="01-Jan-2019";
	    selectDateByJS(driver, date, dateVal);
	    
	//driver.findElement(By.xpath("//input[@name='fromDateLR']")).sendKeys("01-Jan-2019");
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//input[@name='toDateLR']")).sendKeys("04-Dec-2019");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(text(), ' Submit ')]")).click();
	Thread.sleep(2000);
	logger.info("Leave Details opened successfully");
	
	/*
	driver.findElement(By.xpath("//input[@value='Export']")).click();    //Export the leave details
	Thread.sleep(3000);
	logger.info("Leave details Export to excel successfully");
	*/
	
	//Check Holiday List
	leavedetails.clickonHolidayList();
	Thread.sleep(2000);
	
	
	WebElement year = driver.findElement(By.xpath("//select[@name='finacialyear']"));
	Select sel = new Select(year);
	sel.selectByVisibleText("2020");
	Thread.sleep(2000);

	driver.findElement(By.xpath("//button[contains(text(), ' Submit ')]")).click();
	Thread.sleep(4000);
	logger.info("Holiday List Displayed successfully");
	
	driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
	Thread.sleep(2000);

	
	leavedetails.ClickOnStaffSummary();
	Thread.sleep(2000);
	
	
	WebElement salaryPeriod = driver.findElement(By.xpath("//select[@name='SalaryPeriod']"));
	Select selMonth = new Select(salaryPeriod);
	selMonth.selectByVisibleText("April-2019");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[contains(text(), ' Submit ')]")).click();
	Thread.sleep(16000); 
	logger.info("Staff Summary Report Displayed Successfully");
	
	driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
	Thread.sleep(2000);
	logger.info("Navigate to Home page");
	
	
	driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
	Thread.sleep(3000);
	logger.info("Logged out the application successfully");
	
	if(driver.getTitle().equals("login"))
	{
		Assert.assertTrue(true);
			logger.info("Logout page verified & welcome back to login page successfully");
	}
	else
	{
		Assert.assertTrue(false);
			logger.info("Logout Failed");
	}
}

//Date picker
public static void selectDateByJS(WebDriver driver, WebElement element,String dateVal)
{
JavascriptExecutor js = ((JavascriptExecutor) driver);
js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);


}


}



