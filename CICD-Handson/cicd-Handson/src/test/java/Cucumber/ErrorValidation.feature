@tag
Feature: Error Validation
	
	@ErrorValidation
  Scenario Outline: Error Validation
  	Given I landed on Application
    When Enter username <username> and password <password>
    Then "Incorrect email or password." Error message is displayed.

    Examples:
      | username  				 | password    | productName |
      | vigneshks@gmail.com      | Vignesh	   |IPHONE 13 PRO |
     
