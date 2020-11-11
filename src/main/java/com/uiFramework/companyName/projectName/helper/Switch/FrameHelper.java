package com.uiFramework.companyName.projectName.helper.Switch;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class FrameHelper 
{
	
	private WebDriver driver;
  private Logger log=LoggerHelper.getlogger(FrameHelper.class);
  
  public FrameHelper(WebDriver driver)
  {
	  this.driver=driver;
	  
  }
  /**
   * this method for switchToFrame based on index of the frame
   * @param index
   */
	public  void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
		log.info("Switched to:"+index+" -->Frame");
	} 
	
	/**
	 * This will Work on switchToFrame based on name
	 * @param name
	 */
	public void switchToFrame(String name)
	{
		driver.switchTo().frame(name);
		log.info("Switched to:"+name+" -->Frame");
		
	}
	/**
	 * This will work on switcheToFrame based on Element
	 * @param element
	 */
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("Switched to:"+element+" -->Frame");
		
	}
	
}
