package com.uiFramework.companyName.projectName.testScripts.productDetailsPage;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.asserssions.AsserssionHelper;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.NavigationMenu;
import com.uiFramework.companyName.projectName.pageObject.ProductCatogeryPage;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class VerifyLowestPriceFilterTest extends Testbase
{
	private Logger log=LoggerHelper.getlogger(VerifyLowestPriceFilterTest.class);
	
	@Test
	public void verifyLowestFirstPriceInProduct_deatsilsPage() throws InterruptedException
	{
		getApplicationUrl(ObjectReader.reder.getUrl());
		NavigationMenu navigationmenu=new NavigationMenu(driver);
		
		ProductCatogeryPage pcatogerypage=navigationmenu.clickOnMenu(navigationmenu.womenMenu);
		pcatogerypage.selectSortByFilter("Price: Lowest first");
		 Thread.sleep(8000);
		 
		 List<WebElement> price=pcatogerypage.getAllProductPrice();
		 ArrayList<Integer>  array= new ArrayList<Integer>();
		 
		Iterator<WebElement> itr= price.iterator();
		ArrayList<Integer> data = pcatogerypage.getPriceMassgedData(itr);
	    boolean status = pcatogerypage.verifyArrayHasAssendingData(data);
	    AsserssionHelper.upDateTestStaus(status);
		
		/*
		while (itr.hasNext())
		{
			
			String p=itr.next().getText();
			if (p.contains("$"))
			{
				String actualData=p.substring(1);
				log.info("Actual data is::"+actualData);
				double p1=Double.parseDouble(actualData);
				int productPrice=(int) p1;
				array.add(productPrice);
			}
			
		}
		log.info("prices are==="+array);
		
		for (int i = 0; i < array.size()-1; i++) 
		{
			if (array.get(i)<array.get(i+1))
			{
				log.info("array.get(i)="+array.get(i));
				log.info("array.get(i+1)="+ array.get(i+1));
			}else
			{
				Assert.assertTrue(false,"price filter not working");
				log.info("Filter is not working");
			}
			
			
			
		}
		*/
		
	}
	
	
	
}
