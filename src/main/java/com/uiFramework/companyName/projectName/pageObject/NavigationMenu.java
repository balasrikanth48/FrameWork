package com.uiFramework.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class NavigationMenu
{
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(NavigationMenu.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tShirtsMenu;
	
	public NavigationMenu(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(womenMenu, ObjectReader.reder.getExplicitWait());
		Testbase.logExtentReport("Navigation object created");
		new Testbase().getNavigationScreen(driver);	
	}
	
	public void mouseOver(String data)
	{
		log.info("moving Mouse Over "+ data);
		Testbase.logExtentReport("movining mouse over :"+data);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();	
	}
	public ProductCatogeryPage clickOnItem(String item)
	{
		log.info("Clicking on item "+ item);
		Testbase.logExtentReport("Clicking on item "+ item);
		driver.findElement(By.xpath("//*[contains(text(),'"+item+"')]")).click();
		return new ProductCatogeryPage(driver);
		
	}
	
	public ProductCatogeryPage clickOnMenu(WebElement element)
	{
		log.info("Clicking on   "+ element.getText());
		Testbase.logExtentReport("Clicking on "+ element.getText());
		element.click();
		return new ProductCatogeryPage(driver);
		
		
	}
	
}
