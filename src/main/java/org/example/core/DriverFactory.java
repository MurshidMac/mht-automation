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
            // add options as needed, e.g. headless, disable-gpu, etc.
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
