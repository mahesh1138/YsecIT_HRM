package com.HRM.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.PageObjects.LoginPage;

//import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass
{
	
@Test
public void loginTest() throws InterruptedException
{
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	
	logger.info("ULR opened succesfully");
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(username);
	logger.info("Entered username");
	lp.setpassword(password);
	logger.info("Entered password");
	lp.clickSubmit();

	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
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
	
	logger.info("Login Test passed successfully");
		
		
driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
Thread.sleep(2000);
	
}
}