package com.HRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword 
{
WebDriver ldriver;

public ChangePassword(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(xpath="//span[contains(text(), 'Change Password ')]")
@CacheLookup
WebElement Changepassword;

@FindBy(xpath="//a[contains(text(), 'Change Password')]")
@CacheLookup
WebElement openChangepassword;


public void setPassword()
{
	Changepassword.click();
}

public void clickonChangepassword()
{
	openChangepassword.click();
}
}
