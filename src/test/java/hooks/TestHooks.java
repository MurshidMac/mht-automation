package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.DriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Cucumber hooks: setup and teardown.
 */
public class TestHooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
