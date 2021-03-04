package com.HRM.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.HRM.PageObjects.ApplyLeaves;
import com.HRM.PageObjects.LoginPage;

public class TC_ApplyLeaves_004 extends BaseClass
{
@Test
public void applyLeave() throws InterruptedException
{
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	Thread.sleep(1000);
	lp.setpassword(password);
	Thread.sleep(1000);
	lp.clickSubmit();
	Thread.sleep(1000);
	logger.info("Logged in successfully");
	
	ApplyLeaves al=new ApplyLeaves(driver);
	al.clickLeaveApplicationDetails();
	Thread.sleep(1000);
	al.clickonApplyLeave();
	Thread.sleep(2000);
	logger.info("Apply Leave page displayed");
	
	//Apply Casual Leave
	WebElement leaveType = driver.findElement(By.xpath("//select[@id='leavetype']"));
	Select select = new Select(leaveType);
	select.selectByVisibleText("Casual Leave");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@name='fromDate']")).sendKeys("14-Nov-2019");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='toDate']")).sendKeys("14-Nov-2019");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Borther In Law Marraige");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='reset']")).click();
	Thread.sleep(3000);
	logger.info("Tested Apply leave page");
	
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("SL");		//filter/search sick leave
	Thread.sleep(2000);
	
	
	//Apply Comp off leave
	driver.findElement(By.xpath("//a[contains(text(), 'Apply Comp Off')]")).click();
	Thread.sleep(2000);
	logger.info("Comp off page displayed");
	
	driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Appying My comp off leave");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
	Thread.sleep(2000);
}
}
