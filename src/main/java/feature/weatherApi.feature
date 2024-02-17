Feature: Test the openweather api for different city and validate the response

  Scenario: Get the weather Info of mumbai city and validate status code
    Given Input for the weather api for mumbai
    When Trigger a get request
    Then Validate the status code and response