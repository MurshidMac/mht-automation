package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.core.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Cucumber hooks: setup, per-step screenshots, and teardown.
 *
 * Screenshots are captured as raw PNG bytes and attached with MIME type "image/png".
 * The Extent Cucumber adapter Base64-encodes them and embeds them inline in the HTML —
 * no external files, no broken links.
 */
public class TestHooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    /**
     * Fires after every step.
     * Attaches a raw PNG screenshot so the Extent adapter can embed it correctly.
     */
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (driver == null) return;
        try {
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES); // raw PNG — adapter handles Base64 encoding

            String label = scenario.isFailed()
                    ? "FAILED - " + scenario.getName()
                    : "Step passed";

            scenario.attach(screenshot, "image/png", label);
        } catch (Exception e) {
            System.err.println("Could not capture step screenshot: " + e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Extra final screenshot showing browser's last state on failure
        if (scenario.isFailed() && driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png",
                        "Final state on failure: " + scenario.getName());
            } catch (Exception e) {
                System.err.println("Could not capture final screenshot: " + e.getMessage());
            }
        }
        DriverFactory.quitDriver();
    }
}
