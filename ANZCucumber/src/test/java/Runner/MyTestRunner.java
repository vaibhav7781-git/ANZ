package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="src/test/java/features/home.feature",
		glue ={"stepDefinitions"}
		,plugin = { "json:target/cucumber-reports/Cucumber.json" },
		monochrome = true
		)
public class MyTestRunner {

}
