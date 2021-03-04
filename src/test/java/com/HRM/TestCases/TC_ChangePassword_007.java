package com.HRM.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.HRM.PageObjects.ChangePassword;
import com.HRM.PageObjects.LoginPage;

public class TC_ChangePassword_007 extends BaseClass
{
@Test
public void changePassword() throws InterruptedException
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
	
	ChangePassword cp = new ChangePassword(driver);
	cp.setPassword();
	Thread.sleep(2000);
	logger.info("Change Password");
	cp.clickonChangepassword();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@name='newpassword']")).sendKeys("Testing123");
	Thread.sleep(1000);
	logger.info("Entered New Password");
	driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys("Testing123");
	logger.info("Entered Confirm Password");
	Thread.sleep(1000);
	
	//driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();		click on submit
	
	driver.findElement(By.xpath("//button[contains(text(), 'Cancel   ')]")).click();
	logger.info("Clicked on Submi button");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
	Thread.sleep(2000);
	
}

}

