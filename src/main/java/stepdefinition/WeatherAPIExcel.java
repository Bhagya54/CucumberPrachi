package stepdefinition;

import excelUtility.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


import java.io.IOException;
import java.util.HashMap;

public class WeatherAPIExcel {

    Scenario scenario;
    DataTable dt;
    RequestSpecification weatherRequest;
    Response weatherResponse;
    @Before
    public void initializeData(Scenario scenario) throws IOException {
        this.scenario = scenario;
        dt = new DataTable(".\\src\\main\\resources\\testData.xlsx");
        dt.createConnection();
    }

    @Given("Input specification for a city")
    public void input_specification_for_a_city() throws Exception {
        RestAssured.baseURI = "https://api.openweathermap.org/";
        HashMap<String, Object> weatherQueryParam = new HashMap<>();
        String cityName = dt.getData(scenario.getName(),"City");
        String apiKey = dt.getData(scenario.getName(),"Api Key");
        weatherQueryParam.put("q", cityName);
        weatherQueryParam.put("appid", apiKey);
        weatherRequest = RestAssured.given();
        weatherRequest.queryParams(weatherQueryParam);

    }
    @When("Get call is triggered")
    public void get_call_is_triggered() {
        weatherResponse = weatherRequest.get("data/2.5/weather");
    }
    @Then("Validate the response")
    public void validate_the_response() {
        weatherResponse.prettyPrint();
        Assert.assertEquals(200,weatherResponse.statusCode());
    }
    @After
    public void updateStatusOfTestcase() throws IOException {
        dt.updateStatus(scenario.getName(),!scenario.isFailed());
    }

}
