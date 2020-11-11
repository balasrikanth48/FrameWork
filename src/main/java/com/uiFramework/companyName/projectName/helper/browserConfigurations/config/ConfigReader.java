package com.uiFramework.companyName.projectName.helper.browserConfigurations.config;

import com.uiFramework.companyName.projectName.helper.browserConfigurations.BrowserType;

public interface ConfigReader 
{
	  public int getImplicitWait();
	  public int getExplicitWait();
	  public int pageLoadOutTime();
	  public BrowserType getBrowserTpye();
	  public String getUrl();
	  public String getUserName();
	  public String getPassword();
	  
	  
	  
	  
}
