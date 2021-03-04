package com.HRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage 
{
	WebDriver ldriver;
	
	public PersonalDetailsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//span[contains(@class,'ng-binding')]  [contains(text(),'Personal Information')]")
	@CacheLookup
	WebElement PersonalInformation;
	
	@FindBy(xpath="//a[contains(text(), 'Personal Details')]")
	@CacheLookup
	WebElement PersonalDetails;
	
	
	public void clickonPersonalInformation()
	{
		PersonalInformation.click();
	}
	
	public void clickonPersonalDetails()
	{
		PersonalDetails.click();
	}
	
	
}
