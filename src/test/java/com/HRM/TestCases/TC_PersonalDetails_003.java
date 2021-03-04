package com.HRM.TestCases;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.HRM.PageObjects.LoginPage;
import com.HRM.PageObjects.PersonalDetailsPage;

import junit.framework.Assert;

public class TC_PersonalDetails_003 extends BaseClass
{
@Test
public void checkPersonalDetails() throws InterruptedException
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
	
	PersonalDetailsPage PDP = new PersonalDetailsPage(driver);
	PDP.clickonPersonalInformation();
	logger.info("Expand the Personal Information tab");
	Thread.sleep(2000);
	PDP.clickonPersonalDetails();
	logger.info("Personal Details page opened successfully");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[3]/span[1]/i")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='HAddress']")).clear();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='HAddress']")).sendKeys("Bangalore");
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("/html/body/div[2]/div/section[2]/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[3]/span[2]/i")).click();
	logger.info("Updated Address");
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
	logger.info("Updated mobile Number");
	
	String Atcual=driver.findElement(By.xpath("//span[contains(text(), 'Personal details Updated Successfully')]")).getText();
	String Expected="Personal details Updated Successfully";
	Assert.assertEquals(Atcual, Expected);
	Thread.sleep(2000);
	
	 driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
		Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
	Thread.sleep(2000);
	
	
}




}
