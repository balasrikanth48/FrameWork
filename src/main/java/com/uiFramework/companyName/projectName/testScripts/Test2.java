package com.uiFramework.companyName.projectName.testScripts;

import org.testng.annotations.Test;
import com.uiFramework.companyName.projectName.helper.asserssions.AsserssionHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class Test2  extends Testbase 
{
	@Test
	public void TestLogin() {
		
		AsserssionHelper.makeTrue();
	}
	@Test
	public void TestLogin1() {
		
		AsserssionHelper.makeFalse();
	}
	@Test
	public void TestLogin2() {
		
		AsserssionHelper.makeFalse();
		
	}
	@Test
	public void TestLogin3() {
		
		AsserssionHelper.makeTrue();
	}
}
