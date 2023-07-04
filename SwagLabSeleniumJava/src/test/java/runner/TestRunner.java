package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)                                                                                                                      
@CucumberOptions(features="src/test/resources/Features/SwagLabCheckoutStepTwo.feature", 
glue= {"stepDefinitions"},
monochrome=true,
plugin= {"html:target/HtmlReports/report.html",
		"json:target/JSONReports/report.json",
		"junit:target/JUnitReports/report.xml"},
tags= "@Functionality"
)
public class TestRunner {
	
}
