package org.example.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Reusable singleton WebDriver factory.
 * Update the CHROME_DRIVER_PATH constant to point to your local chromedriver executable.
 */
public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            // Selenium Manager (built into Selenium 4.6+) automatically downloads
            // the correct chromedriver if it is not present on PATH — no manual setup needed.
            ChromeOptions options = new ChromeOptions();

            // Run headless in CI (CHROME_HEADLESS env var is set in the GitHub Actions workflow)
            if ("true".equalsIgnoreCase(System.getenv("CHROME_HEADLESS"))) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
