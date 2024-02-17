package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Hello world!
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/main/java/feature",glue="stepdefinition")
public class App 
{


}
