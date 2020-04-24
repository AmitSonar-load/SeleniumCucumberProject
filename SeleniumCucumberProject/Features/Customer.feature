Feature: Customers

  Background: Below are the common steps for each scenario
  Given User Launch Chrome browser
  When User opens URL "https://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then User can view Dashboard
  
@Sanity
Scenario: Add a new customer
  When User click on Customer Menu 
	And click on customer Menu Item 
	And click on Add new button 
	Then User can view Add new customer page 
	When User enter customer info 
	And click on Save button 
	And close browser 
  @regression
  Scenario: Search Customer byEmailID
       When User click on Customer Menu 
	And click on customer Menu Item 
	And Enter customer Email 
	When Click on Search button 
	Then User should found Email in the Search table 
	And close browser 
     @regression
     Scenario: Search Customer by Name
       When User click on Customer Menu
     And click on customer Menu Item
     And Enter customer FirstName
     And Enter customer LastName
     When Click on Search button
     Then User should found Name in the Search table
     And close browser