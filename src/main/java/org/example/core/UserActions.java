package org.example.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Small utility wrapper for common Selenium actions with waits.
 */
public class UserActions {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
    }

    // sometime wait until fail - keep it as second option
    public void click(By locator) {
        driver.findElement(locator).click();
        //wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForPageTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }
}
