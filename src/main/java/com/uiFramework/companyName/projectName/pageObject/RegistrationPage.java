package com.uiFramework.companyName.projectName.pageObject;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.uiFramework.companyName.projectName.helper.browserConfigurations.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.select.DropDownHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testbase.Testbase;

public class RegistrationPage {
	private WebDriver driver;
	private Logger log=LoggerHelper.getlogger(LogInPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath="//*[@id='id_gender1']")
	public WebElement mrRadio;
	@FindBy(xpath="//*[@id='customer_firstname']")
	public WebElement firstName;
	@FindBy(xpath="//*[@id='customer_lastname']")
	public WebElement lastName;
	@FindBy(xpath="//*[@id='passwd']")
	public WebElement password;
	@FindBy(xpath="//*[@id='days']")
	public WebElement day ;
	@FindBy(xpath="//*[@id='months']")
	public WebElement month;
	@FindBy(xpath="//*[@id='years']")
	public WebElement year;
	@FindBy(xpath="//*[@id=\"firstname\"]")
	public WebElement addressFirstName;
	@FindBy(xpath="//*[@id='lastname']")
	public WebElement addressLastName;
	@FindBy(xpath="//*[@id='company']")
	public WebElement company;
	@FindBy(xpath="//*[@id='address1']")
	public WebElement addressLine1;
	@FindBy(xpath="//*[@id='address2']")
    public WebElement addressLine2;
	@FindBy(xpath="//*[@id='city']")
	public WebElement city;
	@FindBy(xpath="//*[@id='id_state']")
	public WebElement State;
	@FindBy(xpath="//*[@id='postcode']")
	public WebElement postalCode;
	@FindBy(xpath="//*[@id='id_country']")
	public WebElement  Country;
	@FindBy(xpath="//*[@id='other']")
	public WebElement additional;
	@FindBy(xpath="//*[@id='phone']")
	public WebElement homePhone;
	@FindBy(xpath="//*[@id='phone_mobile']")
	public WebElement mobilePhone;
	@FindBy(xpath="//*[@id='alias']")
	public WebElement alias;
	@FindBy(xpath="//*[@id='submitAccount']")
	public WebElement registerButton;
	
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(mrRadio, ObjectReader.reder.getExplicitWait());
		new Testbase().getNavigationScreen(driver);
		log.info("Registration page Object is created");
		Testbase.logExtentReport("Registration page Object is created");
	}
	
	public void setMrRadioButton()
	{
		log.info("Mr Radio Button is selecting");
		Testbase.logExtentReport("Mr Radio Button is selecting");
		this.mrRadio.click();
		
	}
	public void setFirstName(String fristname)
	{
		log.info("Entering FirstName is ::"+fristname);
		Testbase.logExtentReport("Entering FirstName is ::"+fristname);
		this.firstName.sendKeys(fristname);
	}
	public void setLastName(String lasstname)
	{
		log.info("Entering lastName is ::"+lasstname);
		Testbase.logExtentReport("Entering LastName is ::"+lasstname);
		this.lastName.sendKeys(lasstname);
	}
	public void setPassword(String password)
	{
		log.info("Entering password is ::"+password);
		Testbase.logExtentReport("Entering password is ::"+password);
		this.password.sendKeys(password);
	}
	
	public void setDay(String day)
	{
		log.info("Selecting the month is ::"+day);
		Testbase.logExtentReport("Selecting the month is::"+day);
		java.util.List<WebElement> Day=driver.findElements(By.xpath("//*[@id='days']/option"));
		Iterator<WebElement> itr=Day.iterator();
		while (itr.hasNext())
		{
			WebElement c = (WebElement) itr.next();
			String text=c.getText().trim().toString();
			if (text.equals(day))
			{
			System.out.println("day is:"+day);
			c.click();
			break;
			}
			
		}
	}
		public void setMonth(String month)
		{
			log.info("ESelecting the month is ::"+month);
			Testbase.logExtentReport("Selecting the month is ::"+month);
			java.util.List<WebElement> months=driver.findElements(By.xpath("//*[@id='months']/option"));
			Iterator<WebElement> itr=months.iterator();
			while (itr.hasNext())
			{
				WebElement c = (WebElement) itr.next();
				String text=c.getText().trim().toString();
				if (text.equals(month))
				{
				System.out.println("day is:"+month);
				c.click();
				break;
				}
				
			}
		}
			public void setYear(String year)
			{
				log.info("Selecting the year is ::"+year);
				Testbase.logExtentReport("Selecting the year is ::"+year);
				java.util.List<WebElement> years=driver.findElements(By.xpath("//*[@id='years']/option"));
				Iterator<WebElement> itr=years.iterator();
				while (itr.hasNext())
				{
					WebElement c = (WebElement) itr.next();
					String text=c.getText().trim().toString();
					if (text.equals(year))
					{
					System.out.println("year is:"+year);
					c.click();
					break;
					}
					
				}
			}

			public void setAddresFirstName(String addressFirstName)
			{
				
				log.info("Entering Address First Name::::"+addressFirstName);
				Testbase.logExtentReport("Entering Address FirstName"+addressFirstName);
				this.addressFirstName.sendKeys(addressFirstName);
			}
			public void setAddresLastName(String addressLastName)
			{
				
				log.info("Entering Address LastName::::"+addressLastName);
				Testbase.logExtentReport("Entering Address LastName"+addressLastName);
				this.addressLastName.sendKeys(addressLastName);
			}
			public void SetCompany(String company)
			{
				
				log.info("Entering Company Name::::"+company);
				Testbase.logExtentReport("Entering Company Name::::"+company);
				this.company.sendKeys(company);
			}
			public void SetAdressLine1(String Addresline1)
			{
				
				log.info("Entering Address Line1::::"+Addresline1);
				Testbase.logExtentReport("Entering Address Line1:::::"+Addresline1);
				this.addressLine1.sendKeys(Addresline1);
			}
			public void SetAdressLine2(String Addresline2)
			{
				
				log.info("Entering Address Lin2::::"+Addresline2);
				Testbase.logExtentReport("Entering Address Line2:::::"+Addresline2);
				this.addressLine2.sendKeys(Addresline2);
			}
			public void SetCity(String City)
			{
				
				log.info("Entering city name::::"+City);
				Testbase.logExtentReport("Entering City Name:::::"+City);
				this.city.sendKeys(City);
			}
			public void SetState(String state)
			{
				
				log.info("Selecting state ::::"+state);
				Testbase.logExtentReport("Selecting state :::::"+state);
				DropDownHelper dropdown= new DropDownHelper(driver);
				dropdown.selectUsingvisibletext(State, state);
				
			}
			public void SetPostal(String Postal)
			{
				
				log.info("Entering postal Code::::"+Postal);
				Testbase.logExtentReport("Entering postal code:::::"+Postal);
				this.postalCode.sendKeys(Postal);
			}
			public void SetCountry(String country)
			{
				
				log.info("Selecting country ::::"+country);
				Testbase.logExtentReport("Selecting country :::::"+country);
				DropDownHelper dropdown= new DropDownHelper(driver);
				dropdown.selectUsingvisibletext(Country, country);
				
			}
			public void SetAdditional(String additional)
			{
				
				log.info("Entering other info::::"+additional);
				Testbase.logExtentReport("Entering other info:::::"+additional);
				this.additional.sendKeys(additional);
			}
			public void SetHomePhone(String homephone)
			{
				
				log.info("Entering Home Phone Number::::"+homephone);
				Testbase.logExtentReport("Entering Home Phone Number:::::"+homephone);
				this.homePhone.sendKeys(homephone);
			}
			public void SetMobilePhone(String mobilephone)
			{
				
				log.info("Entering Home Phone Number::::"+mobilephone);
				Testbase.logExtentReport("Entering Home Phone Number:::::"+mobilephone);
				this.mobilePhone.sendKeys(mobilephone);
			}
			public void setAlias(String alias)
			{
				log.info("Entering alias name::::"+alias);
				Testbase.logExtentReport("Entering alias name::::"+alias);
				this.alias.sendKeys(alias);
			}
			public void  ClickRegistration()
			{
				
				log.info("Clicking Registration button");
				Testbase.logExtentReport("Clicking Registration button");
				this.registerButton.click();
			}
			
}
