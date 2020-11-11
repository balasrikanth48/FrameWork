package com.uiFramework.companyName.projectName.helper.asserssions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class VerificationHelper 
{
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	/**
	 * this Method will display the element
	 * @param element
	 * @return 
	 */
	public boolean isDisplayed(WebElement element) 
	{
		
		try {
			element.isDisplayed();
			log.info("element is present"+element.getText());
			Testbase.logExtentReport("element is present"+element.getText());
			return true;
			
			
		} catch (Exception e) {
			e.getStackTrace();
			log.info("Element is not Present"+element.getText()+e.getCause());
			Testbase.logExtentReport("element is not  present"+e.getMessage());
			
			return false;
		}
			
		}
	/**
	 * this method shows element is Notpresent 
	 * @param element
	 * @return
	 */
		public boolean isNotDisplayed(WebElement element) 
		{
			
			try {
				element.isDisplayed();
				log.info("element is present"+element.getText());
				Testbase.logExtentReport("element is present"+element.getText());
				return false;
				
				
			} catch (Exception e) {
				log.info("Element is not Present");
				Testbase.logExtentReport("element is not  present"+e.getMessage());
				return true;
						}
	}
	
		
		public String readText(WebElement element1)
		{
			if (null==element1) 
			{
				log.info("element is nul::");
				return null;
			}
		boolean status=isDisplayed(element1);
		if (status) 
		{
			log.info("Element is :"+element1.getText());
			return element1.getText();
			
		}else
		{
			return null;
			
		}
		
		}
		/**
		 * this will show text present in the page
		 * @param element1
		 * @return
		 */
		public String getText(WebElement element1)
		{
			if (null==element1) 
			{
				log.info("element is nul::");
				return null;
			}
		boolean status=isDisplayed(element1);
		if (status) 
		{
			log.info("Element is :"+element1.getText());
			return element1.getText();
			
		}else
		{
			return null;
			
		}
		
		}
	
		/**
		 * This will SHow the title of the page
		 * @return
		 */
		public String getTitle()
	{
		log.info("page Title is"+driver.getTitle());
		return driver.getTitle();
	}
	
}
