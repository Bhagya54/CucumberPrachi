package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;

public class WeatherAPIStepDefinition {
    RequestSpecification weatherRequest;
    Response weatherResponse;
   //SoftAssertions assertions = new SoftAssertions();

    /*@Given("Input for the weather api for mumbai")
    public void input_for_the_weather_api_for_mumbai() {
        RestAssured.baseURI = "https://api.openweathermap.org/";
        HashMap<String, Object> weatherQueryParam = new HashMap<>();
        weatherQueryParam.put("q", "pune");
        weatherQueryParam.put("appid", "52a69caf0754d13344257e73e0f65666");
        weatherRequest = RestAssured.given();
        weatherRequest.queryParams(weatherQueryParam);
    }*/

    @When("Trigger a get request")
    public void trigger_a_get_request() {
        weatherResponse = weatherRequest.get("data/2.5/weather");
    }

    /*@Then("Validate the status code and response")
    public void validate_the_status_code_and_response() {
        assertions.assertThat(weatherResponse.statusCode()).isEqualTo(201);
        assertions.assertThat(weatherResponse.jsonPath().getString("name")).isEqualTo("pune");

        *//*Assert.assertEquals(200,weatherResponse.statusCode());
        Assert.assertEquals("pune",weatherResponse.jsonPath().getString("name"));*//*
        weatherResponse.prettyPrint();

        assertions.assertAll();
    }*/


    @Then("Validate the status code should be {int} and response for {string} city")
    public void validateTheStatusCodeShouldBeAndResponseForCity(int statusCode, String cityName) {
        Assert.assertEquals(statusCode, weatherResponse.statusCode());
        Assert.assertEquals(cityName, weatherResponse.jsonPath().getString("name"));

    }

    @Given("Input for the weather api for {string} and api key as {string}")
    public void inputForTheWeatherApiForAndApiKeyAs(String cityName, String apiKey) {
        RestAssured.baseURI = "https://api.openweathermap.org/";
        HashMap<String, Object> weatherQueryParam = new HashMap<>();
        weatherQueryParam.put("q", cityName);
        weatherQueryParam.put("appid", apiKey);
        weatherRequest = RestAssured.given();
        weatherRequest.queryParams(weatherQueryParam);
    }



}
