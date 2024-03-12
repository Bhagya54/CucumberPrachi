package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;

public class WeatherAPISDOutline {
    RequestSpecification weatherRequest;
    Response weatherResponse;
@Before
public void startUp(){
    System.out.println("Before the testcase");
}
    @After
    public void tearDown(){
        System.out.println("After the testcase");
    }
    @Given("Input {string} and {string} for a weatherAPI request")
    public void input_and_for_a_weather_api_request(String cityName, String apiKey) {
        RestAssured.baseURI = "https://api.openweathermap.org/";
        HashMap<String, Object> weatherQueryParam = new HashMap<>();
        weatherQueryParam.put("q", cityName);
        weatherQueryParam.put("appid", apiKey);
        weatherRequest = RestAssured.given();
        weatherRequest.queryParams(weatherQueryParam);
    }

    @When("Trigger a get request using outline")
    public void trigger_a_get_request() {
        weatherResponse = weatherRequest.get("data/2.5/weather");
    }

    @Then("Validate the status code as {int} and response for {string} city")
    public void validateTheStatusCodeShouldBeAndResponseForCity(int statusCode, String cityName) {
        Assert.assertEquals(statusCode, weatherResponse.statusCode());
        Assert.assertEquals(cityName, weatherResponse.jsonPath().getString("name"));
weatherResponse.prettyPrint();
    }
}
