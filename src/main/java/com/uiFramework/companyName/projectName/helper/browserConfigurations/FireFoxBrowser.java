package com.uiFramework.companyName.projectName.helper.browserConfigurations;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class FireFoxBrowser 
{
	public FirefoxOptions getfirefoxOptions()
	{
		DesiredCapabilities firefox=DesiredCapabilities.firefox();
		FirefoxOptions profile=new FirefoxOptions();
		profile.setAcceptInsecureCerts(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("Marionetee", true);
		
		FirefoxOptions firefoxoptions=new FirefoxOptions(firefox);
		//linux
		if (System.getProperty("os.name").contains("Linux")) {
			
			firefoxoptions.addArguments("--Headless","window-size=1024,768","--nosandbox");
			
		}
		return firefoxoptions;
		
	}
	
	public FirefoxDriver getfirfoxDriver(FirefoxOptions cp)
	{
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.driver.chrome", ResourceHelper.getResourcePath(""));
			return new FirefoxDriver(cp);
		}else if(System.getProperty("os.name").contains("Windoes"))
		{
			System.setProperty("webdriver.driver.chrome", ResourceHelper.getResourcePath(""));
			return new FirefoxDriver(cp);
		}else if(System.getProperty("os.name").contains("Linux"))
		{
			System.setProperty("webdriver.driver.chrome", ResourceHelper.getResourcePath(""));
			return new FirefoxDriver(cp);
			
		}
		
		return null;
		
		
	}
}
