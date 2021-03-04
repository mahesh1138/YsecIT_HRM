package com.HRM.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.HRM.PageObjects.LoginPage;
import com.HRM.PageObjects.TrainingSummary;

public class TC_TraningSummary_06 extends BaseClass
{
@Test
public void traningSummary() throws InterruptedException
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
	
	
	TrainingSummary ts = new TrainingSummary(driver);
	ts.clickonLearningDevelopment();
	Thread.sleep(2000);
	
	ts.clickOnTraningSummary();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[contains(text(), 'Add Training Summary')]")).click();
	Thread.sleep(2000);
	logger.info("Add Traning Summary page opened");
	
	
	WebElement courseName=driver.findElement(By.xpath("//select[@id='ddlCourseName']"));
	Select select = new Select(courseName);
	select.selectByVisibleText("Artificial Intelligence");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@name='AddStartDate']")).sendKeys("01-Dec-2019");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='AddEndDate']")).sendKeys("31-Dec-2019");
	Thread.sleep(2000);
	
	
	WebElement status=driver.findElement(By.xpath("//select[@id='ddlStatus']"));
	Select select1 = new Select(status);
	select1.selectByVisibleText("Enroll");
	Thread.sleep(2000);	
	
	//driver.findElement(By.xpath("//*[@id="addDetailsForm"]/div[2]/button[2]")).click(); //save training summary
	
	driver.findElement(By.xpath("//button[contains(text(), 'Close') and @type='reset']")).click();		
	logger.info("Entered Training Sumamry Details and clicked on close button successfully");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
	Thread.sleep(2000);

		
}
}
