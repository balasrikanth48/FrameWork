package com.uiFramework.companyName.projectName.helper.browserConfigurations.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.uiFramework.companyName.projectName.helper.browserConfigurations.BrowserType;
import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {
	public static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		try {
			String filepath = ResourceHelper.getResourcePath("\\src\\main\\Resource\\configfile\\config.properties");
			file = new FileInputStream(new File(filepath));
			OR = new Properties();

			OR.load(file);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public int getImplicitWait() 
	{
		return Integer.parseInt( OR.getProperty("implicitWait"));
		
	}

	public int getExplicitWait() {
		return Integer.parseInt( OR.getProperty("explicitWait"));
	}

	public int pageLoadOutTime() {
		return Integer.parseInt( OR.getProperty("pageLoadOutTime"));
	}

	public BrowserType getBrowserTpye() {
	return	BrowserType.valueOf(OR.getProperty("browserType"));
	}

	public String getUrl() {
		if (System.getProperty("url")!=null) {
			
			return System.getProperty("url");
		}
		
		System.out.println( OR.getProperty("applicationurl"));
	   return OR.getProperty("applicationurl");
	
	}

	public String getUserName() {
		return OR.getProperty("username");
	}

	public String getPassword() {
		return OR.getProperty("password");
	}
}
