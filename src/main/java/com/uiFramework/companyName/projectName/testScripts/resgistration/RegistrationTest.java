package com.uiFramework.companyName.projectName.testScripts.resgistration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.asserssions.AsserssionHelper;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.LogInPage;
import com.uiFramework.companyName.projectName.pageObject.MyAccountPage;
import com.uiFramework.companyName.projectName.pageObject.RegistrationPage;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class RegistrationTest extends Testbase
{
  private final Logger log=LoggerHelper.getlogger(RegistrationTest.class);
  LogInPage loginpage;
  MyAccountPage myaccount;
  RegistrationPage register;
  
  @Test
  public void testLoginToApplication()
  {
	  
	  log.info("Conducting Registration testcase");
	  getApplicationUrl(ObjectReader.reder.getUrl());
	  loginpage=new LogInPage(driver);
	  loginpage.clickOnSignLink();
	  loginpage.enterRegistrationEmail();
	  loginpage.clickOnCreateAccount();
	  // registration details
	  register=new RegistrationPage(driver);
	  register.setMrRadioButton();
	  register.setFirstName("firstname");
	  register.setLastName("lasstname");
	  register.setPassword("password");
	  register.setDay("7");
	  register.setMonth("September");
	  register.setYear("2020");
	  register.setAddresFirstName("address");
	  register.setAddresLastName("latname");
	  register.SetCompany("company");
	  register.SetAdressLine1("lne1");
	  register.SetAdressLine2("line2");
	  register.SetCity("hyd");
	  register.SetState("Alaska");
	  register.SetPostal("500019");
	  register.SetCountry("United States");
	  register.SetAdditional("other");
	  register.SetHomePhone("931231341");
	  register.SetMobilePhone("4674564654654");
	  register.setAlias("Alias");
	  register.ClickRegistration();
	  
	  // my account
	  myaccount =new MyAccountPage(driver);
	  boolean status=myaccount.yourAccountPageMessage();
	  
	  AsserssionHelper.upDateTestStaus(status);
	  
  }
  
	
	
	
	
}
