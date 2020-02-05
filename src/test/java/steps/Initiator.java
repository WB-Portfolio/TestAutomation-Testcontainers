package steps;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.lifecycle.TestDescription;

import java.io.File;
import java.util.Optional;

public class Initiator {

    private final Logger logger = Logger.getLogger(Initiator.class);
    public static BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("./target"));

    @Before
    public void beforeScenario() {
        logger.info("Starting container");
        chrome.start();

    }

    @After
    public void afterScenario(Scenario scenario) {
        chrome.afterTest(new TestDescription() {
            @Override
            public String getTestId() {
                return scenario.getId();
            }

            @Override
            public String getFilesystemFriendlyName() {
                return scenario.getName();
            }
        }, Optional.of(scenario).filter(Scenario::isFailed).map(__ -> new RuntimeException()));
    }


}
