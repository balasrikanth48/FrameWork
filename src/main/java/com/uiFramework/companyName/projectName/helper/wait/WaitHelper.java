package com.uiFramework.companyName.projectName.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class WaitHelper {
	
	private Logger log=LoggerHelper.getlogger(WaitHelper.class);
	private WebDriver driver;
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("WaitHelper Object is instanced");
		
	}
	/**
	 * this is implicitwait method
	 * @param timeout
	 * @param unit
	 */
	 
	public void setImplicitWait(long timeout,TimeUnit unit)
	{
		log.info("Implicit wait is set to :"+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);	
	}
	/**
	 * This will to get webdriverwait object
	 * @param timeOutInSeconds
	 * @param PollingEveryInMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds,int PollingEveryInMiliSec)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(PollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return null;
		
	}	
	/**
	 * This method will wait for element is visible to you
	 * @param element
	 * @param timeOutInSeconds
	 * @param PollingEveryInMiliSec
	 */
	public void waitForElementVisibleWithPollingTime(WebElement element ,int timeOutInSeconds, int PollingEveryInMiliSec)
	{
		log.info("wait for:"+element+"for:"+timeOutInSeconds+"Seconds");
		WebDriverWait wait=getWait(timeOutInSeconds, PollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visivle now");
	}
	/**
	 * This is for element to be clickable
	 * @param element
	 * @param timeOutInSeconds
	 * @param PollingEveryInMiliSec
	 */
			
	public void waitForElementClikable(WebElement element ,int timeOutInSeconds, int PollingEveryInMiliSec)
	{
		log.info("wait for:"+element+"for:"+timeOutInSeconds+"Seconds");
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is visivle now");
	}
	/**
	 * This is for Element is not present
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitforElementNotPresent(WebElement element,long timeOutInSeconds)
	{
		log.info("wait for:"+element+"for:"+timeOutInSeconds+"Seconds");
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		boolean status=wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is invisible now");
		return status;
	}
	/**
	 * This is for frame available and switched
	 * @param element
	 * @param timeOutInSeconds
	 */	
	public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element,long timeOutInSeconds)
	{
		log.info("wait for:"+element+"for:"+timeOutInSeconds+"Seconds");
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is avalible now and switched");
		
	}
	/**
	 * This is for fluent wait
	 * @param timeOutInSeconds
	 * @param PollingEveryInMiliSec
	 * @return
	 */
	public Wait<WebDriver> getFluentWait(int timeOutInSeconds,int PollingEveryInMiliSec)
	{
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(timeOutInSeconds))
		.pollingEvery(Duration.ofMillis(PollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
		
	}
	
	public void PageLoadTime(long timeout,TimeUnit unit) 
	{
		log.info(" waiting for page to load for   "+unit+":Seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		
		log.info("Page is Loaded");
	}

	public void waitForElement(WebElement element,int timeOutInSeconds) 
	{
		
		log.info("Waiting for "+element.toString() +"  for  "+timeOutInSeconds +"Seconds");
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("elemnet is visible now");
	}
}
