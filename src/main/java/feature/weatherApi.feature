@weatherAPI
Feature: Test the openweather api for different city and validate the response

  @mumbai
  Scenario: Get the weather Info of mumbai city and validate status code
    Given Input for the weather api for "Mumbai" and api key as "52a69caf0754d13344257e73e0f65666"
    When Trigger a get request
    Then Validate the status code should be 200 and response for "Mumbai" city

  @chennai
  Scenario: Get the weather Info of chennai city and validate status code
    Given Input for the weather api for "Chennai" and api key as "52a69caf0754d13344257e73e0f65666"
    When Trigger a get request
    Then Validate the status code should be 200 and response for "Chennai" city

