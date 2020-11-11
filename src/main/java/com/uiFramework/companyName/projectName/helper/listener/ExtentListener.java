package com.uiFramework.companyName.projectName.helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.utils.ExtentManager;

public class ExtentListener implements  ITestListener

{
    private Logger log=LoggerHelper.getlogger(ExtentListener.class);
	
	public static ExtentReports Extent;
	public static ExtentTest test;
	public void onFinish(ITestContext arg0) 
	{
		Reporter.log(arg0.getName()+"this test finished");
//		Extent.flush();
		log.info(arg0.getName()+"  Test is finished.");
	}
	public void onStart(ITestContext arg0) 
	{
		Extent=ExtentManager.getInstance();
//		test=Extent.createTest(arg0.getName());
//		test=Extent.createTest(arg0.getCurrentXmlTest().getName());
		Reporter.log(( arg0).getCurrentXmlTest().getName()+"  Class started");
//		Reporter.log("String test.......");
		log.info(( arg0).getCurrentXmlTest().getName()+"   Class started");	
	}
	
	public void onTestFailure(ITestResult arg0) {
//		test.log(Status.FAIL, arg0.getThrowable());	
		Reporter.log(arg0.getMethod().getMethodName()+"this test Failed.."+arg0.getThrowable());
		log.error(arg0.getMethod().getMethodName()+"  Test is failed"+arg0.getThrowable());
		
	}
	public void onTestSkipped(ITestResult arg0) {
//		test.log(Status.SKIP, arg0.getThrowable());
		Reporter.log(arg0.getMethod().getMethodName()+"this test Skippped.."+arg0.getThrowable());
		log.warn(arg0.getMethod().getMethodName()+"  Test is Skipped");
	}
	
	public void onTestStart(ITestResult arg0) 
	{
//		test.log(Status.INFO, arg0.getName()+"  Test started");
		Reporter.log(arg0.getMethod().getMethodName()+" Test started..");
		log.info(arg0.getMethod().getMethodName()+"  Test strted..");
		
		
	}
	public void onTestSuccess(ITestResult arg0)
	{
		
//		test.log(Status.INFO, arg0.getName()+"  Test Passed");
		Reporter.log(arg0.getMethod().getMethodName()+" Test Passed..");
		log.info(arg0.getMethod().getMethodName()+" Test Passed..");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}
	
	
	
	
	
}
