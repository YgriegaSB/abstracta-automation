package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/Feature"
                },
        glue = {
                "StepDefinition"
                },
        plugin = {"pretty","junit:target/cucumber-reports/report.html","json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true
)
public class TestRunner {
}
