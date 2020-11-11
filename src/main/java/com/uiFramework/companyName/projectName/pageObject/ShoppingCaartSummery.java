package com.uiFramework.companyName.projectName.pageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.asserssions.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class ShoppingCaartSummery 
{

	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(LogInPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//a[@title='Delete']")
	public List<WebElement> quantitydeleteItem;
	@FindBy(xpath="//*[@id=\"columns\"]/div[1]/span[2]")
	public WebElement yourShoopingcart;
	@FindBy(xpath="//*[@id=\"center_column\"]/p")
	public WebElement emptyCartMsg;

	
	public ShoppingCaartSummery(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(yourShoopingcart, ObjectReader.reder.getExplicitWait());
		new Testbase().getNavigationScreen(driver);
		log.info("Waiting for Loging page fully loaded");
	}
	public boolean VerifyProduct(String prod)
	{
		log.info("Selecting Product:"+prod);
		Testbase.logExtentReport("Selecting Product:"+prod);
		WebElement product=driver.findElement(By.xpath("//*[contains(text(),'"+prod+"')]"));
		return new VerificationHelper(driver).isDisplayed(product);
	}
	public void deleteProductFromShoppingcart() throws InterruptedException
	{
		log.info("Deleteing all the items");
		List<WebElement> deletes=quantitydeleteItem;
		Iterator<WebElement> itr=deletes.iterator();
		while (itr.hasNext()) {
			 itr.next().click();
			 Thread.sleep(2000);
			
		}
	}
	
	public boolean verifyEmptyShoppingcartMsg() 
	{
//		try {
//			log.info("Verifing empaty shopping cart msg");
//			emptyCartMsg.isDisplayed();
//			return true;
//	
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		return false;
		return new VerificationHelper(driver).isDisplayed(emptyCartMsg);
		
	}
	
}