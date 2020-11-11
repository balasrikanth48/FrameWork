package com.uiFramework.companyName.projectName.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.javaScript.JavaScriptHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.select.DropDownHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class ProductCatogeryPage 
{

	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(ProductCatogeryPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='layered_block_left']/p")
	public WebElement CatologTextObj;
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
	public WebElement productAddedSuccesFully;
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]")
	public WebElement AddToCart;
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	public WebElement proccedToCheckOut;
	@FindBy(xpath="//*[@id='center_column']/ul/li")
	List<WebElement> totalProducts;
	@FindBy(xpath="//*[@id='selectProductSort']")
	public WebElement sortBy;
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[2]/div/span[1]")
	List<WebElement> allPriceElement;
	
	public ProductCatogeryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(CatologTextObj, ObjectReader.reder.getExplicitWait());
		log.info("Product Catogery is Intilisied");
		Testbase.logExtentReport("Product Catogery Object is created");
		new Testbase().getNavigationScreen(driver);
	}

	public void mouseOver(int Number)
	{
		String fPart="//*[@id='center_column']/ul/li[";
		String sPart="]/div/div[2]/div[2]/a";
		Actions action=new Actions(driver);
		log.info("Doing mouse over "+Number+"  Product");
		action.moveToElement(driver.findElement(By.xpath(fPart+Number+sPart))).build().perform();
	}
	public void clickOnAddToCart()
	{
		log.info("Clicking on Add to Cart");
		AddToCart.click();
	}
	public void clickOnProccedToCheckOut()
	{

		log.info("Clicking on Procced to CheckOut");
		proccedToCheckOut.click();
		
	}
	
	public void selectColor(String data)
	{
		new JavaScriptHelper(driver).scrollToView(driver.findElement(By.xpath("//a[contains(text() ,'"+data+"')]/parent::*//preceding-sibling::input[1]")));
		driver.findElement(By.xpath("//a[contains(text() ,'"+data+"')]/parent::*//preceding-sibling::input[1]")).click();
		try {
			Thread.sleep(2000);	
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}
	
	public void selectSmallSize()
	{
		log.info("Selecting smallsize..");
		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
		
	}
	
	public void selectMediumSize()
	{
		log.info("Selecting medium size");
		try {
			boolean selected=driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']")).isSelected();
					if (!selected) 
					{
						driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']")).click();
						log.info("CheckBox is chexked");
					}else
					{
						
						log.info("CheckBox is Already Selected");
					}	
		} catch (Exception e) 
		{
			e.printStackTrace();	
		}
	}
	public void selectLSize()
	{
		log.info("Selecting large size");
		try {
			boolean selected=driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).isSelected();
					if (!selected) 
					{
						driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();
						log.info("CheckBox is chexked");
					}else
					{
						
						log.info("CheckBox is Already Selected");
					}	
		} catch (Exception e) 
		{
			e.printStackTrace();	
		}
	}
	public void selectFirstProduct()
	{
		
		Actions obj=new Actions(driver);
		log.info("performing mouse over action on first product of the page");
		Testbase.logExtentReport("performing mouse over action on first product of the page");
		obj.moveToElement(totalProducts.get(0)).build().perform();
		log.info("Clicking on Add to Basket");
		Testbase.logExtentReport("Clicking on Add to Basket");
		AddToCart.click();	
	}
	
	public int getTotalProducts()
	{
		log.info("Total PRice of the Products ");
		Testbase.logExtentReport("Showing total Products");
		return totalProducts.size();
	}
	public List<WebElement> getAllProductPrice()
	{
		log.info("Showing Total Price ");
		Testbase.logExtentReport("Showing total Price");
		return allPriceElement;
		
	}
	public void selectSortByFilter(String dataToSelect)
	{
		log.info("Selecting Filter");
		Testbase.logExtentReport("Selecting Filter");
		DropDownHelper dropdown=new DropDownHelper(driver);
		dropdown.selectUsingvisibletext(sortBy, dataToSelect);
		
	}
	public boolean verifyArrayHasAssendingData(ArrayList<Integer> array)
	{
		for (int i = 0; i < array.size()-1; i++) 
		{
			if (array.get(i)<=array.get(i+1))
			{
				log.info("array.get(i)"+array.get(i));
				log.info("array.get(i+1)"+array.get(i+1));
			}else
			{
				log.info("Filter is not Working");
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Integer> getPriceMassgedData(Iterator<WebElement> itr)
	{
		ArrayList<Integer> array=new ArrayList<Integer>();
		while (itr.hasNext()) 
		{
			String p=itr.next().getText();
			if (p.contains("$"))
			{
				String actualdata=p.substring(1);
				log.info("actual data");
				double p1=Double.parseDouble(actualdata);
				int productPrice=(int) p1;
				array.add(productPrice);
			}
			
		}
		return array;
		
	}
	
	
}
