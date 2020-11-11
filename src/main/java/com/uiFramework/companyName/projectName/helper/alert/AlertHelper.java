package com.uiFramework.companyName.projectName.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class AlertHelper 
{
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(AlertHelper.class);
	/**
	 * this will Create object for AlertHelper
	 * @param driver
	 */
	public AlertHelper(WebDriver driver) 
	{
		this.driver=driver;
		log.info("AlertHelper object is created");
		
	}
	 public Alert getAlert()
	 {
		 log.info("Alert Text:"+driver.switchTo().alert().getText());
		 return driver.switchTo().alert();
	 }
	 
	 public void acceptAlert()
	 {
		getAlert().accept();
		log.info("Alerrt is accpected");
	 }
	 public void dismissAlert()
	 {
		getAlert().dismiss();
		log.info("Alerrt is Dismissed");
	 }
	 public String  getAlertText()
	 {
		String text=getAlert().getText();
		log.info("Alerrt text is:"+text);
		return text;
	 }
	 /**
	  * This method is works for alert is present or not
	  * @return
	  */
	 public boolean isAlertPresent()
	 {
		 try {
			 driver.switchTo().alert();
			 log.info("Alert is Present");
			 return true;
			
		} catch (NoAlertPresentException e) {
			log.info(e.getCause());
			
		}
		return false; 
	 }
	 public void acceptAlertIfPresent()
	 {
		 if (isAlertPresent()) 
		 {
			acceptAlert();
		}else
		{
			log.info("alert is not Present");
		}
	 }
	 public void dismissAlertIfPresent()
	 {
		 if (isAlertPresent()) 
		 {
			dismissAlert();
		}else
		{
			log.info("alert is not Present");
		}
	 }
	 public void acceptPromt(String text)
	 {
		 if (isAlertPresent()) 
		 {
			Alert alert=getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert Text is enterd");
			
		}
		 
		 
	 }
	
}
