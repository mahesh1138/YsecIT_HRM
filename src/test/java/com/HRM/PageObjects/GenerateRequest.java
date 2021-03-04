package com.HRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateRequest 
{
	WebDriver ldriver;
	
	public GenerateRequest(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[contains(text(), 'Payroll and Compensation ')]")
	@CacheLookup
	WebElement PayRollInfomration;
	

	@FindBy(xpath="//a[contains(text(), 'Generate Request')]")
	@CacheLookup
	WebElement ClickonGenerateRequest;
	
	public void setPayRollInformation()
	{
		PayRollInfomration.click();
	}
	
	
	public void setGenerateRequest()
	{
		ClickonGenerateRequest.click();
	}
}