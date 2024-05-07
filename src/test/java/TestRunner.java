import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = "StepDefinitions",
		features = "src/test/java/Features",
		plugin= {"pretty", "html:testReport.html"},
		publish = true)
public class TestRunner {

}
