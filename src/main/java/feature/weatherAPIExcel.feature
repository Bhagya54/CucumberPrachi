@excel
Feature: Weather API data driven from excel
  Scenario: Test Weather data for Mumbai
    Given Input specification for a city
    When Get call is triggered
    Then Validate the response

  Scenario: Test Weather data for Chennai
    Given Input specification for a city
    When Get call is triggered
    Then Validate the response

  Scenario: Test Weather data for Delhi
    Given Input specification for a city
    When Get call is triggered
    Then Validate the response