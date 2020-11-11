package com.uiFramework.companyName.projectName.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class DropDownHelper 
{
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver) 
	{
		this.driver=driver;
		log.info("DropDownHelper Object is created");
	}

	public void selectUsingValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
		log.info("DropDown value is:"+value+"selected");
	}
	public void selectUsingIndex(WebElement element,String index)
	{
		Select select=new Select(element);
		select.selectByValue(index);
		log.info("DropDown value is:"+index+"selected");
	}
	
	public void selectUsingvisibletext(WebElement element,String visibletext)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
		log.info("DropDown value is:"+visibletext+"selected");
	}
	
	public void deselectUsingValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.deselectByValue(value);
		log.info("DropDown value is:"+value+"deselected");
	}
	public void deselectUsingIndex(WebElement element,String index)
	{
		Select select=new Select(element);
		select.deselectByValue(index);
		log.info("DropDown value is:"+index+"deselected");
	}
	public void deselectUsingVisibletext(WebElement element,String visibletext)
	{
		Select select=new Select(element);
		select.deselectByValue(visibletext);
		log.info("DropDown value is:"+visibletext+"deselected");
	}
	
	
	public LinkedList<String> getAllDropDownData(WebElement element)
	{
		Select select=new Select(element);
		List<WebElement> elementlist = select.getOptions();
		LinkedList<String> valueList = new LinkedList<String>();
		for (WebElement ele : elementlist) 
		{
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}
	
}
