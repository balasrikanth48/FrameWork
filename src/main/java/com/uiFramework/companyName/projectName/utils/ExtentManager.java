package com.uiFramework.companyName.projectName.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{

	public static ExtentReports Extent;
	public static ExtentReports getInstance()
	{
		if (Extent==null) 
		{
			return createInstance("test-output/extent.html");
		}else
		{
			return Extent;
		}
		
	}
	 
	public static ExtentReports createInstance(String fileName)
	{
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(fileName);
		htmlReport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReport.config().setChartVisibilityOnOpen(true);
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setDocumentTitle(fileName);
		htmlReport.config().setEncoding("UTF-8");
		htmlReport.config().setReportName("Automation Report");
		
		Extent=new ExtentReports();
		Extent.attachReporter(htmlReport);
		
		return Extent;
	}
	
	
	
}
