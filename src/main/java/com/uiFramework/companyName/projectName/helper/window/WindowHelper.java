package com.uiFramework.companyName.projectName.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class WindowHelper {

	
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(WindowHelper.class);
	public WindowHelper(WebDriver driver)
	{
		this.driver=driver;
		
	}
	/**
	 * this method will switch to parent window
	 */
	public void switchToParentWindow()
	{
		driver.switchTo().defaultContent();
		log.info("The frame is switche to parent window");
	}
	
	/**
	 * This will switch to child window based on index
	 * @param index
	 */
	public void switchToWindow(int index)
	{
		Set<String> windows=driver.getWindowHandles();
		int i=1;
		
		for (String window : windows) {
			if(i==index)
			{
				driver.switchTo().window(window);
			}
			else
			{
				i++;
			}
			
		}
		
	}
	/**
	 * this will close all tabs and switch to main window
	 */
	public void closeAllTabsandSwitchToMainWindow()
	{
		Set<String> windows=driver.getWindowHandles();
		String mainwindow=driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}	
		}
		driver.switchTo().window(mainwindow);
	}
	/**
	 * this will naviagte to back
	 */
	public void naviaget()
	{
		driver.navigate().back();
	}
	
}
