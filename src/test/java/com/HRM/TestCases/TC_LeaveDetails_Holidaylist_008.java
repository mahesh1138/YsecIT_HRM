package com.HRM.TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.HRM.PageObjects.LoginPage;
import com.HRM.PageObjects.Reports_LeaveDetails;


public class TC_LeaveDetails_Holidaylist_008 extends BaseClass
{
@Test
public void leaveDetails() throws InterruptedException
{
	
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			Thread.sleep(1000);
			lp.setpassword(password);
			Thread.sleep(1000);
			lp.clickSubmit();
			Thread.sleep(5000);
			logger.info("Logged in successfully");
			
			Reports_LeaveDetails leavedetails=new Reports_LeaveDetails(driver);
			leavedetails.clickonReport();
			
			leavedetails.clickOnLeaveDetails();
			Thread.sleep(2000);
			logger.info("Leave Details Page opened");
			
			//From date selected by Javascript Executor 
			WebElement date=driver.findElement(By.xpath("//input[@name='fromDateLR']"));
	  	    String dateVal="01-Jan-2019";
	  	    selectDateByJS(driver, date, dateVal);
	  	    
			//driver.findElement(By.xpath("//input[@name='fromDateLR']")).sendKeys("01-Jan-2019");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@name='toDateLR']")).sendKeys("02-Dec-2019");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(), ' Submit ')]")).click();
			Thread.sleep(2000);
			logger.info("Entered From date, To date and clicked on submit button ");
			
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
			sel.selectByVisibleText("2019");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath("//button[contains(text(), ' Submit ')]")).click();
			Thread.sleep(4000);
			logger.info("Displayed Holiday List successfully");
			
			driver.findElement(By.xpath("//span[contains(text(), 'Employee')]")).click();
			Thread.sleep(2000);
			logger.info("Navigate to Home page");
			
			leavedetails.ClickOnStaffSummary();
			Thread.sleep(2000);
			logger.info("Staff Summary Page opened");
			
			WebElement salaryPeriod = driver.findElement(By.xpath("//select[@name='SalaryPeriod']"));
			Select selMonth = new Select(salaryPeriod);
			selMonth.selectByVisibleText("November-2019");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[contains(text(), ' Submit ')]")).click();
			Thread.sleep(15000);   
			
			
			driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();		//Click on Logout
			Thread.sleep(2000);
			logger.info("Logged out the application successfully");
		}

//Date picker
  

  public static void selectDateByJS(WebDriver driver, WebElement element,String dateVal)
  {
  	JavascriptExecutor js = ((JavascriptExecutor) driver);
  	js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
  	

  }
	

	

}

