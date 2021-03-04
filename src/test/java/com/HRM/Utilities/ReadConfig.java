package com.HRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
Properties pro;

public ReadConfig()
{
	
	File src = new File("./Configuration/config.properties");
	
	try
	{
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}
		catch(Exception e)
		{
		System.out.println("File is not able to laod>>"+e.getMessage());
		}
	
}



public String getApplicationURL()
{
	
	String Url=pro.getProperty("baseURL");
	return Url;
}
	
	public String getUsername()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	public String getChromepath()
	{									
		String path=pro.getProperty("chromepath");
		return path;
	}
	
	public String getFirefoxPath()
	{									
		String path=pro.getProperty("firefoxpath");
		return path;
	}
	}
	
	



//Note: if add any new variable and path in properties file, correspondingly, you need to create method in Readconfig.java file