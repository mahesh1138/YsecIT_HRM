package com.HRM.TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.HRM.Utilities.ReadConfig;

public class BaseClass 
{
	
ReadConfig readconfig = new ReadConfig();	

public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();
public static WebDriver driver;

public static Logger logger;


@Parameters("browser")
@BeforeClass
public void setUP(String br)
{
	
	logger=Logger.getLogger("HRM");
	PropertyConfigurator.configure("Log4j.properties");
	
	if(br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver=new ChromeDriver();
		logger.info("Chrome Browser opened");
	}
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		driver=new FirefoxDriver();
	}
	
	driver.get(baseURL);
	logger.info("Login page Displayed successfully");
}


@AfterClass
public void tearDown()
{
	driver.quit();
	logger.info("Closed the browser");
}
}

