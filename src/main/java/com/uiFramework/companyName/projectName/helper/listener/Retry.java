package com.uiFramework.companyName.projectName.helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
public class Retry implements IRetryAnalyzer
{
	private int retryCount=0;
	private int maxReTryCount=3;
			
	 
	private Logger log=LoggerHelper.getlogger(Retry.class);
	public boolean retry(ITestResult arg0) {	
		if (retryCount<maxReTryCount)
		{
			log.info("Retrying  test:"+arg0.getName()+":  with status--> "+getResultStatusName(arg0.getStatus())+"  For the "+(retryCount+1)+" times");
			retryCount++;
			return true;
			
			
		}
		return false;
	}

	
	public String getResultStatusName(int status)
	{
		String ResultName=null;
		if (status==1) {
			ResultName="Success";
		}
		if (status==2) {
			ResultName="Failure";
		}
		if (status==3) {
		ResultName="skip";	
		}
		return ResultName;
	}
}
