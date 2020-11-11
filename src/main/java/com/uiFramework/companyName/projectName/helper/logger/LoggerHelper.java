package com.uiFramework.companyName.projectName.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class LoggerHelper 
{
	private static boolean root=false;
	public static Logger getlogger(Class cls)
	{
		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\src\\main\\Resource\\configfile\\log4j.properties"));
	    root=true;	
		return Logger.getLogger(cls);
		
		
	}
	
	public static void main(String[] args) {
	
		Logger log=LoggerHelper.getlogger(LoggerHelper.class);
		log.info("Login Passed");
		log.info("Welcome to the World");
		
	}
	
}
