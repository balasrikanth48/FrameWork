package com.uiFramework.companyName.projectName.testScripts;

import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.testbase.Testbase;

public class TestScreenShot extends Testbase
{
	@Test
	public void testScree()
	{
		driver.get("https://www.selenium.dev/downloads/");
		captureScree("firstScreen",driver);
	}
}
