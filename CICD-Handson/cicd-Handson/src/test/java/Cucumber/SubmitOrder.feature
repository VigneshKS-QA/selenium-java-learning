@tag
Feature: Purchase order from Ecommerce Website

Background:
Given I landed on Ecommerce Website
	
	@tag2
  Scenario Outline: Positive Test of Submit order
    Given Login wih username <username> and password <password>
    When Add the <productName> to Cart
    And Checkout <productName> and Submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples:
      | username  				 | password    | productName |
      | vigneshks@gmail.com      | Vignesh888@ |IPHONE 13 PRO |
     
