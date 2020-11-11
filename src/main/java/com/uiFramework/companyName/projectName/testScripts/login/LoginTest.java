package com.uiFramework.companyName.projectName.testScripts.login;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.asserssions.AsserssionHelper;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.LogInPage;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class LoginTest extends Testbase
{
	private final  Logger log=LoggerHelper.getlogger(LoginTest.class);
	@Test(description="Login with valid credentials")
	public void testLoginApplication()
	{
		getApplicationUrl(ObjectReader.reder.getUrl());
		LogInPage Lp=new LogInPage(driver);
		Lp.loginToApplication(ObjectReader.reder.getUserName(), ObjectReader.reder.getPassword());
		boolean status=Lp.verifySuccessLoginMsg();
		AsserssionHelper.upDateTestStaus(status);
		
		
	}
	
	
	
}
