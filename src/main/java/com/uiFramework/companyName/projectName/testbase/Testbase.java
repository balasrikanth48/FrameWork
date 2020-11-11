package com.uiFramework.companyName.projectName.testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.BrowserType;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.ChromeBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.FireFoxBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.PropertyReader;
import com.uiFramework.companyName.projectName.helper.javaScript.JavaScriptHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.utils.ExtentManager;

public class Testbase 
{
	public static ExtentReports Extent;
	public static ExtentTest test;
	public WebDriver driver;
	public Logger log=LoggerHelper.getlogger(Testbase.class);
	public static File reportDirectory;
	
	@BeforeSuite
	public void beforeSuite()
	{
		Extent=ExtentManager.getInstance();
		
	}
	@BeforeTest
	public void beforeTest() throws Exception
	{
		ObjectReader.reder=new PropertyReader();
		reportDirectory=new File(ResourceHelper.getResourcePath("\\src\\main\\Resource\\ScreenShots"));
		setUpDriver(ObjectReader.reder.getBrowserTpye());
	}
	
	
	@BeforeClass
	public void beforeClass()
	{
		test=Extent.createTest(getClass().getName());
		
	}
	@BeforeMethod
	public void beforeMethode(Method method)
	{
		test.log(Status.INFO, method.getName()+"   Test started");
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			
			test.log(Status.FAIL, result.getThrowable());
	        String 	imagepath=captureScree(result.getName(),driver);
	        test.addScreenCaptureFromPath(imagepath);
			
			
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
		test.log(Status.PASS, result.getName()+"-->is Pass");
		String 	imagepath=captureScree(result.getName(),driver);
        test.addScreenCaptureFromPath(imagepath);
		 
		
		
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
		test.log(Status.SKIP, result.getThrowable());
		}
		
		
		Extent.flush();
	}
	@AfterTest
	public void afterTest()
	{
		if (driver!=null) {
			driver.quit();
			
		}
	}
	public WebDriver getBrowserObject(BrowserType type) throws Exception
	{
	
		try {
			switch (type) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option=chrome.getChromeOptions();
				 return chrome.getChromeDriver(option);

			case Firefox:
				FireFoxBrowser firefox=FireFoxBrowser.class.newInstance();
				FirefoxOptions options=firefox.getfirefoxOptions();
				firefox.getfirfoxDriver(options);
			default:
				throw new Exception("Driver not Found"+type.name());
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			
			throw  e;
			
		}
	}
	public void setUpDriver(BrowserType Bytpe) throws Exception
	{
	driver=	getBrowserObject(Bytpe);
	log.info("Initilizing WebDriver"+driver.hashCode());
	WaitHelper wait=new WaitHelper(driver);
	wait.setImplicitWait(ObjectReader.reder.getImplicitWait(), TimeUnit.SECONDS);
	wait.PageLoadTime(ObjectReader.reder.pageLoadOutTime(), TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	}

	public String captureScree(String filename,WebDriver driver)
	{
		if (driver==null) {
			log.info("Driver is null");
			return null;
			
		}
		if(filename=="")
		{
			filename="blank";
			
		}
		File destfile=null;
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			destfile=new File(reportDirectory+"\\"+filename+"_"+formater.format(calender.getTime())+".png");
		   Files.copy(srcfile, destfile);
		Reporter.log("<a href='"+destfile.getAbsolutePath()+"'><img src='"+destfile.getAbsolutePath()+"'height='100' width='100'/></a>");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return destfile.toString();
	}
	public void getNavigationScreen(WebDriver driver)
	{
		log.info("Capturing screen....");
		new JavaScriptHelper(driver).zoomInBy60Percentage();		
		String screen=captureScree("", driver);
		new JavaScriptHelper(driver).zoomInBy100Percentage();
		try {
			test.addScreenCaptureFromPath(screen);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void  logExtentReport(String s1)
	{
		test.log(Status.INFO, s1);
	}
	public void getApplicationUrl(String url)
	{
		driver.get(url);
		log.info("Navigating to >>>>>>"+url);
	}
}
