package hooks;

import com.qainterview.utils.DriverFactory;
import com.qainterview.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            String nombreEscenario = scenario.getName().replaceAll(" ", "-");
            String estado = scenario.isFailed() ? "FAIL" : "PASS";
            ScreenshotUtil.takeScreenshot(driver, nombreEscenario + "_" + estado);
        }

        DriverFactory.quitDriver();
    }
}