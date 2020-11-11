package com.uiFramework.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.asserssions.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class MyAccountPage 
{
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(MyAccountPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='center_column']/p/text()")
	public WebElement yourAccountPageMessage;
	@FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[1]/a/i")
	public WebElement orderHistoryAndDetails;
	@FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[2]/a/i")
	public WebElement myCreditSlips;
	@FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[3]/a/i")
	public WebElement MyAddress;
	@FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[4]/a/i")
	public WebElement MyPersonalInformation;
	@FindBy(xpath="//*[@id='center_column']/div/div[2]/ul/li/a/i")
	public WebElement MyWishList;
	@FindBy(xpath="//*[@id='center_column']/h1")
	public WebElement myAccountText;
	
	
	public MyAccountPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(orderHistoryAndDetails, ObjectReader.reder.getExplicitWait());
		log.info("Showing OrderHistory");
		Testbase.test.log(Status.INFO, "MyAccount Object is created"); 
		new Testbase().getNavigationScreen(driver);
		
	}
	public void clickOnWishList()
	{
		log.info("Click on  "+MyWishList.getText());
		MyWishList.click();
		Testbase.test.log(Status.INFO, "clicked on "+MyWishList.getText());
	}
	
	public void clickOnOrderDeatils()
	{
	  	
		log.info("Click on  "+orderHistoryAndDetails.getText());
		orderHistoryAndDetails.click();
		Testbase.test.log(Status.INFO, "clicked on "+orderHistoryAndDetails.getText());
		
	}
	public boolean yourAccountPageMessage() {
		
		return new VerificationHelper(driver).isDisplayed(yourAccountPageMessage);
	}
}
