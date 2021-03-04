package com.HRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAttendance 
{
	WebDriver ldriver;
	
	public MyAttendance(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//span[contains(@class,'ng-binding')]  [contains(text(),'Personal Information')]")
	@CacheLookup
	WebElement PersonalInformation;
	
	@FindBy(xpath="/html/body/div[2]/div/section[1]/div[2]/div[2]/ul/li[1]/a")
	@CacheLookup
	WebElement ClickONMyAttendance;
	
	
	public void clickPersonalInformationLink()
	{
		PersonalInformation.click();
	}
	
	public void clickOnMyAttendance()
	{
		ClickONMyAttendance.click();
	}
}
