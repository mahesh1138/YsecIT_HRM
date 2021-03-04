package com.HRM.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.HRM.PageObjects.GenerateRequest;
import com.HRM.PageObjects.LoginPage;

public class TC_GenerateRequest_005 extends BaseClass
{
	@Test
	public void GenerateRequest() throws InterruptedException
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
		
		GenerateRequest gr = new GenerateRequest(driver);
		gr.setPayRollInformation();
		Thread.sleep(2000);
		
		gr.setGenerateRequest();
		Thread.sleep(2000);
		logger.info("Generate Request page displayed");
		
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Please check my leave balance");
		Thread.sleep(3000);
		
		
		//driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		
		//Account Details
		driver.findElement(By.xpath("//a[contains(text(), 'Bank Account Details')]")).click();
		Thread.sleep(2000);
		logger.info("Sorry No Records found, message displayed on the screen");
		
		driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
		Thread.sleep(2000);
		
	}

}
