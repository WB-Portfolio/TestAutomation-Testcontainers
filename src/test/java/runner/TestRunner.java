package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        plugin = {"json:target/reports/cucumber.json"},
        tags = {"@Test1"},
        monochrome = true,
        glue = {"steps"}
)


public class TestRunner {


}
