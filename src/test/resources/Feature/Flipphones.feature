Feature: Mobile Phones feature
Background: 
		Given User quit the button 

  Scenario: Phones scenario
    When User enters the phone name
    Then User prints the phone name

  Scenario Outline: Multiple phones scenario
    When User enters the multiple phones names "<Phones>"
    Then User Validates the multiple phone names

    Examples: 
      | Phones  |
      | SAMSUNG |
      | OPPO    |
      | LG      |
