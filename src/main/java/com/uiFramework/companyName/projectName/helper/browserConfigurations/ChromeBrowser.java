package com.uiFramework.companyName.projectName.helper.browserConfigurations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class ChromeBrowser 
{
	public ChromeOptions getChromeOptions()
	{
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("Disable pop-up-Blocking");
		DesiredCapabilities chrome=DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		options.setCapability(ChromeOptions.CAPABILITY, chrome);
		//linux
		if (System.getProperty("os.name").contains("Linux")) {
			options.addArguments("--Headless","window-size=1024,768","--no-sandbox");
			
		}
		return options;
		
	}
	
	public ChromeDriver getChromeDriver(ChromeOptions cp)
	{
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath(""));
			return new ChromeDriver(cp);
		}else if(System.getProperty("os.name").contains("Windows"))
		{
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("\\src\\main\\Resource\\Drivers\\chromedriver.exe"));
			return new ChromeDriver(cp);
		}else if(System.getProperty("os.name").contains("Linux"))
		{
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath(""));
			return new ChromeDriver(cp);
			
		}
		
		return null;
		
		
	}
	
}
