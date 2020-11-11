package com.uiFramework.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.asserssions.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.javaScript.JavaScriptHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class LogInPage
{

	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(LogInPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement emailAddress;
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]")
	WebElement signinButton;
	@FindBy(xpath="//*[@id='center_column']/p")
	WebElement successMessage;
	@FindBy(xpath="//*[@id=\"email_create\"]")
	WebElement registrationEmailAddress;
	@FindBy(xpath="//*[@id=\"SubmitCreate\"]")
	WebElement createAccount;
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement authentication;
	
	
	public LogInPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(signin, ObjectReader.reder.getExplicitWait());
		new Testbase().getNavigationScreen(driver);
		log.info("Waiting for Loging page fully loaded");
		
	}
	
	public void clickOnSignLink()
	{
		log.info("Clicking signin Buttton");
		signin.click();
		logExtentReport("Clicking sigin");
	}
	
	public void enterEmailAddress(String emailAddress)
	{
		
		log.info("Entering Email address...."+emailAddress);
		logExtentReport("Entering Email address...."+emailAddress);
		this.emailAddress.sendKeys(emailAddress);
		
	}
	public void enterPassword(String password)
	{
		
		log.info("Entering password   "+password);
		logExtentReport("Entering password   "+password);
		this.password.sendKeys(password);
	}
	public HomePage clickOnSubmitButton()
	{
		log.info("Clicking sginIn submit button");
		logExtentReport("Clicking sginIn submit button");
		new JavaScriptHelper(driver).scroolDownVertical();
		signinButton.click();
		
		return new  HomePage(driver);
		
	}
	
	public boolean verifySuccessLoginMsg() {
		return new VerificationHelper(driver).isDisplayed(successMessage);
	}
	
	public void enterRegistrationEmail()
	{
		String email=System.currentTimeMillis()+"@gmail.com";
		log.info("entering email id for registraion is "+ email);
		registrationEmailAddress.sendKeys(email);	
	}
	public RegistrationPage clickOnCreateAccount()
	{
		createAccount.click();
		log.info("Clicking New Registraion page");
		logExtentReport("Clicking New Registraion page");
		return new  RegistrationPage(driver);
	}
	public void loginToApplication(String emailAddress , String Password)
	{
		clickOnSignLink();
		enterEmailAddress(emailAddress);
		enterPassword(Password);
		clickOnSubmitButton();	
	}
	
	public void logExtentReport(String s1)
	{
		Testbase.test.log(Status.INFO, s1);
		
	}
	
}

