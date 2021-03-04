package com.HRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports_LeaveDetails 
{
WebDriver ldriver;

public Reports_LeaveDetails(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

	@FindBy(xpath="//span[contains(text(), 'Reports ')]")
	@CacheLookup
	WebElement reports;

	@FindBy(xpath="//a[contains(text(), 'Leave Details')]")
	@CacheLookup
	WebElement leaveDetails;

	@FindBy(xpath="//a[contains(text(), 'Holiday List')]")
	@CacheLookup
	WebElement holidaylist;
	
	@FindBy(xpath="//a[contains(text(), 'Staff Summary')]")
	@CacheLookup
	WebElement staffSummary;

public void clickonReport()
{
	reports.click();
}

public void clickOnLeaveDetails()
{
	leaveDetails.click();
}

public void clickonHolidayList()
{
	holidaylist.click();
}

public void ClickOnStaffSummary()
{
	staffSummary.click();
}

}
