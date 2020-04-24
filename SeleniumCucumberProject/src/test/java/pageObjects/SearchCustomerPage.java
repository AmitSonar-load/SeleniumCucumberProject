package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelpher;

public class SearchCustomerPage
{
	public WebDriver ldriver;
	WaitHelpher waithelper;
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelpher(ldriver);
		

}
	@FindBy(how=How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtEmail; 
	
	@FindBy(how=How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID,using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how=How.ID,using="SearchIpAddress")
	@CacheLookup
	WebElement txtIPAddress;
	
	@FindBy(how=How.ID,using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	@FindBy(how=How.ID,using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.ID,using="//*[@id=\"customers-grid_wrapper\"]/div[1]/div/div/div[1]/div/table/thead/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.ID,using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecol;
	
	public void setEmail(String email)
	{
		waithelper.WaitForElement(txtEmail, 20);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setFirstName(String fname)
	{
		waithelper.WaitForElement(txtFirstName
		, 20);
		txtEmail.clear();
		txtEmail.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		waithelper.WaitForElement(txtLastName
		, 20);
		txtEmail.clear();
		txtEmail.sendKeys(lname);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
		waithelper.WaitForElement(btnSearch, 20);
	}
	
	public int getNoOfRows()
	{
		return(tableRows.size());
	}
	
	public int getNoOfColumns()
	{
		return(tablecol.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		for(int i=1;i<getNoOfRows();i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}
	public boolean searchCustomerByName(String Name)
	{
		boolean flag=false;
		for(int i=1;i<getNoOfRows();i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[4]")).getText();
			String names[]=name.split(" ");
			if(names[0].equals("Victoria")&& names[1].equals("Terces"))
			{
				flag=true;
			}
		}
		return flag;
	}
}
