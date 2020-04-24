package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer 
{
	public WebDriver ldriver;
	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	By InkCustomers_menu=By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a");
	By InkCustomer_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	By btnAddnew=By.xpath("//a[@class='btn bg-blue']");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtFirstname=By.xpath("//input[@id='FirstName']");
	By txtLastname=By.xpath("//input[@id='LastName']");
	By txtGenderM=By.xpath("//input[@id='Gender_Male']");
	By txtGenderF=By.xpath("//input[@id='Gender_Female']");
	By txtDOB=By.xpath("//input[@id='DateOfBirth']");
	By txtTax=By.xpath("//input[@id='IsTaxExempt']");
	By listitemcustomerRole =By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By listitemadmin=By.xpath("//li[contains(text(),'Administrators']");
	By listitemguests=By.xpath("//li[contains(text(),'Guests']");
	By listitemvendor=By.xpath("//li[contains(text(),'Vendors']");
	By txtcompanyname=By.xpath("//input[@id='Company']");
	By btnsave=By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]");
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickonCustomer_menu()
	{
		ldriver.findElement(InkCustomers_menu).click();
	}
	public void clickonCustomer_menuitem()
	{
		ldriver.findElement(InkCustomer_menuitem).click();
		
	}
	public void clickonAddbtn()
	{
		ldriver.findElement(btnAddnew).click();
		
	}
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
		
	}
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
		
	}
	public void setCustomerRoles(String role) throws InterruptedException 
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
		ldriver.findElement(listitemcustomerRole).click();
					
		WebElement listitem;
		
		Thread.sleep(3000);
					
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(listitemadmin); 
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(listitemguests);
		}
		
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(listitemvendor);
		}
		else
		{
			listitem=ldriver.findElement(listitemguests);
		}
					
		listitem.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(txtGenderM).click();
		}
		else if(gender.equals("Feamle"))
		{
			ldriver.findElement(txtGenderF).click();
		}
		else 
		{
			ldriver.findElement(txtGenderM).click();
		}
	}
	
   public void  setFirstname(String fname)
   {
	   ldriver.findElement(txtFirstname).sendKeys(fname);
   }
   public void setLatname(String lname)
   {
	   ldriver.findElement(txtLastname).sendKeys(lname);
   }
   public void setDOB(String dob)
   {
	   ldriver.findElement(txtDOB).sendKeys(dob);
	   
   }
   public void setCompanyname(String cmpname)
   {
	   ldriver.findElement(txtcompanyname).sendKeys(cmpname);
   }
   public void btnsave()
   {
	   ldriver.findElement(btnsave).click();
   }
}

