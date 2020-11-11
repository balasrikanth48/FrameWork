package com.uiFramework.companyName.projectName.helper.asserssions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class AsserssionHelper 
{
	private static Logger log=LoggerHelper.getlogger(AsserssionHelper.class);
	
	public static void verifyText(String str1,String str2)
	{
		log.info("Verify test:"+str1+"with"+str2);
		Assert.assertEquals(str1, str2);
	}
	public static void makeTrue()
	{
		log.info("making script Pass");
		Assert.assertTrue(true);
	}
	public static void makeTrue(String massage)
	{
		log.info("making script Pass "+ massage);
		Assert.assertTrue(true, massage);
	}
	public static void makeFalse()
	{
		log.info("making script Fail");
		Assert.assertTrue(false);
	}
	public static void makeFalse(String massage)
	{
		log.info("making script Fail"+massage);
		Assert.assertTrue(false, massage);
	}
	
	public static void verifyTrue(boolean status)
	{
		
		Assert.assertTrue(status);
	}
	public static void verifyFalse(boolean status)
	{
		Assert.assertFalse(status);
	}
	
	public static void verifiyNullObject(String s1)
	{
		log.info("Verifiying Object is null");
		Assert.assertNull(s1);
	}
	public static void verifiyNotNullObject(String s1)
	{
		log.info("Verify Object is not null");
		Assert.assertNotNull(s1);
	}
	public static void pass()
	{
		Assert.assertTrue(true);
	}
	
	public static void fail()
	{
		Assert.assertTrue(false);
	}

	public static void upDateTestStaus(boolean status )
	{
		if (status) 
		{
			 pass();
		}else
		{
			fail();
			
		}
	}
}
