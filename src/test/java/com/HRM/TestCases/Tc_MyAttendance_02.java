package com.HRM.TestCases;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.HRM.PageObjects.LoginPage;
import com.HRM.PageObjects.MyAttendance;

public class Tc_MyAttendance_02 extends BaseClass
{
@Test
public void checkLoginHours() throws InterruptedException
{
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("Username is Entered");
	lp.setpassword(password);
	logger.info("Password is Entered");
	lp.clickSubmit();
	logger.info("Logged in successfully and home page displayed");
	Thread.sleep(2000);
	
	
	MyAttendance ma = new MyAttendance(driver);
	ma.clickPersonalInformationLink();
	logger.info("Expaned Personal Information tab");
	Thread.sleep(2000);
	ma.clickOnMyAttendance();
	logger.info("My Attendance page opened");
	Thread.sleep(2000);	

	WebElement select=driver.findElement(By.xpath("//select[@name='empid']"));
	Select EmpId=new Select(select);
	EmpId.selectByVisibleText("Self");
    Thread.sleep(1000);
    
	//Select from and To date and click on submit button.
    driver.findElement(By.xpath("//input[@name='fromDateComp']")).clear();
	driver.findElement(By.xpath("//input[@name='fromDateComp']")).sendKeys("03-Dec-2019");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@name='toDateComp']")).clear();
	driver.findElement(By.xpath("//input[@name='toDateComp']")).sendKeys("03-Dec-2019");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
	 logger.info("Attendance Details displayed successfully");
	 Thread.sleep(5000);
	 
	 /* not executing this block of code, verify later
	String Atcual=driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[3]/table/tbody/tr[1]/td[2]")).getText();
 	String Expected="Mahesh Jutti";
 	Assert.assertEquals(Atcual, Expected);
 	
 	*/
 	
	 driver.findElement(By.xpath("//span[contains(text(), 'incorrect punch')]")).click();
	 logger.info("Opened Punching details");
	 Thread.sleep(5000);
	 
	 //check punching details
	 driver.findElement(By.xpath("//button[contains(text(), 'Close')]")).click();
	 Thread.sleep(5000);
	 
	 driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
	Thread.sleep(2000);
	 
	 driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
	Thread.sleep(4000);
	logger.info("Logout successfully");
	} 
}



