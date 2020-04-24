Feature: Login

@Sanity
Scenario: Sucessful Login with Valid Credentials
  Given User Launch Chrome browser
  When User opens URL "https://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then Page Title should be as "Dashboard / nopCommerce administration"
  When User click on Log out link
  Then Page Title should be "Welcome, please sign in!"
  And close browser
  
  @regression
  Scenario Outline: Login Data Driven
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be as "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Welcome, please sign in!"
    And close browser  
  
  Examples:
        |email | password |
        | admin@yourstore.com | admin |
        | admin@yourstore.com | admin123 |
  