package stepsDefinations;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomer;
import pageObjects.LoginPgae;
import pageObjects.SearchCustomerPage;

public class Baseclass 
{
	public WebDriver driver;
	public LoginPgae lp;
	public AddCustomer addcus;
	public SearchCustomerPage cuspage;
	public static Logger logger;
	public Properties confgprop;
	
	public static String randomstring()
	{
		String genearteString1=RandomStringUtils.randomAlphabetic(5);
		return (genearteString1);
	}

}
