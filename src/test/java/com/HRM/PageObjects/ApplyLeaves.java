package com.HRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyLeaves 
{
 WebDriver ldriver;
 
 public ApplyLeaves(WebDriver rdriver)
 {
	 ldriver=rdriver;
	 PageFactory.initElements(rdriver, this);
	 
 } 
	 @FindBy(xpath="//span[contains(text(), 'Leave Application Details ')]")
	 @CacheLookup
	 WebElement LeaveApplicationDetails;
	 
	 @FindBy(xpath="//a[contains(text(), 'Apply Leaves')]")
	 @CacheLookup
	 WebElement ApplyLeave;
	 
	 
	 public void clickLeaveApplicationDetails()
	 {
		 LeaveApplicationDetails.click();
	 }
	 
	 public void clickonApplyLeave()
	 {
		 ApplyLeave.click();
	 }
	 
	 
	 
 }

