package com.HRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingSummary 
{
WebDriver ldriver;

public TrainingSummary(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

	@FindBy(xpath="//span[contains(text(), 'Learning & Development ')]")
	@CacheLookup
	WebElement LearningDevelopment;

	@FindBy(xpath="//a[contains(text(), 'Training Summary')]")
	@CacheLookup
	WebElement ClickonTraining;


public void clickonLearningDevelopment()
{
	LearningDevelopment.click();
}

public void clickOnTraningSummary()
{
	ClickonTraining.click();
}

}
