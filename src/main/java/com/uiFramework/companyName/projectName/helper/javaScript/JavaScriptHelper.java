package com.uiFramework.companyName.projectName.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(JavaScriptHelper.class);
	public JavaScriptHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("javascript executer is initialised");
		
	}
	/**
	 * this will execute the javaScript
	 * @param script
	 * @return
	 */
	public Object excuteScript(String script)
	{	
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	/**
	 * this will execute with multiple arguments
	 * @param script
	 * @param args
	 * @return
	 */
	public Object excuteScript(String script,Object...args)
	{	
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	/**
	 * this will scroll the page into a element
	 * @param element
	 */
	public void scrollToElement(WebElement element)
	{
		log.info("Scrolling to :"+element);
		excuteScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}

	/**
	 * this will scroll to element and  clicks the element
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element)
	{
		scrollToElement(element);
		element.click();
		log.info("element is clicked:"+element.toString());
		
	}
	
	/**
	 * this will scroll to view the  element
	 * @param element
	 */
	public void scrollToView(WebElement element)
	{
		excuteScript("arguments[0].scrollIntoView()",element);
		log.info("element is clicked:"+element.toString());
		
	}
	/**
	 * this will scroll to element and  clicks the element
	 * @param element
	 */
	public void scrollToViewAndClick(WebElement element)
	{
		scrollToView(element);
		element.click();
		log.info("element is clicked:"+element.toString());
		
	}
	/**
	 * this will scroll dwon vertically
	 */
	public void scroolDownVertical()
	{
		excuteScript("window.scrollTo(0,document.body.scrollHeight)");
		log.info("Scrolling dwon verticallly");
	}
	/**
	 * this will scrolls up
	 */
	public void scroolUpVertical()
	{
		excuteScript("window.scrollTo(0,-document.body.scrollHeight)");
		log.info("scrolling up vertically");
	}
	 
	/**
	 * this will scroll down till given pixel (eg=1500)
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel)
	{
		excuteScript("window.scrollBy(0,"+pixel+")");
	}
	/**
	 * this method will scrolls up by pixel
	 * 
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel)
	{
		excuteScript("window.scrollBy(0,-"+pixel+")");
	}
	/**
	 * this will zoom screen by 100%
	 */
	public void zoomInBy100Percentage()
	{
		excuteScript("document.body.style.zoom='100%'");
	}
	/**
	 * this will zoom screen to 60%
	 */
	public void zoomInBy60Percentage()
	{
		excuteScript("document.body.style.zoom='40%'");
	}
	/**
	 * this click the element
	 * @param element
	 */
	public void clickElement(WebElement element)
	{
		excuteScript("arguments[0].click()",element);
		
	}
	
	
	
	
}
