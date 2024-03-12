@weatherAPIOutline
Feature: Test the openweather api for different city and validate the response

  Scenario Outline: Get the weather Info for multiple cities
    Given Input <cityName> and <apiKey> for a weatherAPI request
    When Trigger a get request using outline
    Then Validate the status code as 200 and response for <cityName> city

    Examples:
      | cityName | apiKey                             |
      | "Mumbai" | "52a69caf0754d13344257e73e0f65666" |
      | "Pune" | "52a69caf0754d13344257e73e0f65666" |
      | "Chennai" | "52a69caf0754d13344257e73e0f65666" |
      | "Delhi" | "52a69caf0754d13344257e73e0f65666" |




