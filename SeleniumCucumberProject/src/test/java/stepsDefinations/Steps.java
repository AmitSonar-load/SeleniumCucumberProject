package stepsDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.AddCustomer;
import pageObjects.LoginPgae;
import pageObjects.SearchCustomerPage;

public class Steps extends Baseclass

{
	@Before
	public void setUp() throws Exception
	{
		confgprop=new Properties();
		FileInputStream f=new FileInputStream("Config.properties");
		confgprop.load(f);
		logger =Logger.getLogger("nopComemrce");
		PropertyConfigurator.configure("Logj.properties");
		String br=confgprop.getProperty("browser");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",confgprop.getProperty("chromepath"));
			driver=new ChromeDriver();
			
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("geodriver",confgprop.getProperty("chromepath"));
			driver=new FirefoxDriver();
		}
		
		System.setProperty("webdriver.chrome.driver",confgprop.getProperty("chromepath"));
		driver=new ChromeDriver();
		logger.info("**Lauching browser**");
	}
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() 
	{
		
		lp=new LoginPgae(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url)
	{
		logger.info("Opening URL ");
		driver.get(url);
		driver.manage().window().maximize();
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) 
	{
		logger.info("Providing login deatils");
		lp.setUserName(email);
		lp.setPasword(password);
	    
	}

	@When("Click on Login")
	public void click_on_Login()
	{
		logger.info("Started login");
		lp.clickLogin();
	   
	}

	@Then("Page Title should be as {string}")
	public void page_Title_should_be_as(String title) 
	{
		if(driver.getPageSource().contains("Login was Unsuccessful."))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
	    
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException
	{
		
	logger.info("Login Out");
	    
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String string) throws InterruptedException
	{
		logger.info("Checking title");
		lp.clickLogout();
		Thread.sleep(2000);
	    
	}

	@Then("close browser")
	public void close_browser()
{
		logger.info("Browser close");
		driver.quit();
	   
	}
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() 
	{
		addcus=new AddCustomer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addcus.getPageTitle());
	    
	}

	@When("User click on Customer Menu")
	public void user_click_on_Customer_Menu() throws InterruptedException 
	{
		logger.info("Click on Customer menu");
		Thread.sleep(3000);
		addcus.clickonCustomer_menu();
	   
	}

	@When("click on customer Menu Item")
	public void click_on_customer_Menu_Item() throws InterruptedException
	{
		Thread.sleep(2000);
		addcus.clickonCustomer_menuitem();
	    
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException 
	{
		logger.info("Click on Add");
		addcus.clickonAddbtn();
		Thread.sleep(2000);
	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() 
	{
		Assert.assertEquals("Add a new customer / nopCommerce administration",addcus.getPageTitle());
	   
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException 
	{
		logger.info("Enter info");
	    String email=randomstring()+"@gamil.com";
	    addcus.setEmail(email);
	    addcus.setPassword("test@123");
	  //  addcus.setCustomerRole("Guest");
	    Thread.sleep(2000);
	    addcus.setGender("Male");
	    addcus.setFirstname("Amit");
	    addcus.setLatname("sonar");
	    addcus.setDOB("02/08/1991");
	    addcus.setCompanyname("chegus");
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException 
	{
		addcus.btnsave();
		Thread.sleep(2000);
	   
	}
	
	@When("Enter customer Email")
	public void enter_customer_Email() throws InterruptedException
	{
		cuspage=new SearchCustomerPage(driver);
		cuspage.setEmail("victoria_victoria@nopCommerce.com");
		Thread.sleep(2000);
	    
	}

	@When("Click on Search button")
	public void click_on_Search_button() throws InterruptedException 
	{
		cuspage.clickSearch();
		Thread.sleep(2000);
	   
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() 
	{
		boolean status=cuspage.searchCustomerByEmail("victoria_victoria@nopCommerce.comm");
		Assert.assertEquals(false,status);
	   
	}
	@When("Enter customer FirstName")
	public void enter_customer_FirstName()
	{
		cuspage=new SearchCustomerPage(driver);
		cuspage.setFirstName("Victoria");
	    
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName()
	{
		cuspage.setLastName("Terces");
	   
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() 
	{
		boolean status=cuspage.searchCustomerByName("Victoria Terces");
	    Assert.assertEquals(false, status);
	}




}
