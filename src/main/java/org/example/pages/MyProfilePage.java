package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyProfilePage extends BasePage {

    private By userDropdown = By.id("userDropdown");
    private By myProfileUpdateBtn = By.xpath("//button[normalize-space()='Update']");
    private By expiryDate =  By.xpath("//input[contains(@class,'form-control') and @type='text']");
    private By myProfileBtn = By.id("MenuItem_MyProfile");


    public WebElement inputFieldElement;

    public MyProfilePage(WebDriver driver){
        super(driver);
    }

    public void verifyUserIsLoggedIn() {
        if (!actions.isDisplayed(userDropdown)) {
            throw new RuntimeException("Login verification failed: user dropdown is not visible. User may not be logged in.");
        }
    }

    public void clickOnLoggedInUser(){
        if(actions.isDisplayed(userDropdown)) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement dropdownTrigger = wait.until(ExpectedConditions
                        .elementToBeClickable(userDropdown));
                dropdownTrigger.click();
                Thread.sleep(500);
                WebElement element = driver.findElements(myProfileBtn).get(0);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } catch (InterruptedException e) {
                System.err.println("Error with thread");
            }
        }
    }

    public void clickOnMyProfileUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement updateBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        myProfileUpdateBtn
                )
        );

        updateBtn.click();
    }

    public void myProfileUpdateFormShouldDisplay(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            inputFieldElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(expiryDate)
            );
        } catch (TimeoutException e) {
            throw new RuntimeException("Expiry date input field is NOT visible.", e);
        }

    }

    public void inputIDExpiryDate(String idExpiry){
        if (idExpiry == null || idExpiry.isEmpty()) {
            throw new IllegalArgumentException("idExpiry parameter is NULL or EMPTY");
        }

        DateTimeFormatter inputFormat =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS");
        DateTimeFormatter outputFormat =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate;

        try {
            LocalDateTime dateTime = LocalDateTime.parse(idExpiry, inputFormat);
            formattedDate = dateTime.toLocalDate().format(outputFormat);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse date: " + idExpiry, e);
        }

        if (inputFieldElement == null) {
            throw new IllegalStateException(
                    "inputFieldElement is NULL. You MUST call myProfileUpdateFormShouldDisplay() before inputIDExpiryDate()."
            );
        }

        try {
            // Use JavaScript to set the value — handles read-only and date-picker inputs
            // that reject direct clear()/sendKeys() interactions
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].removeAttribute('readonly');" +
                    "arguments[0].value = arguments[1];",
                    inputFieldElement, formattedDate
            );
            // Fire change/input events so the app's JS picks up the new value
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                    inputFieldElement
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to send expiry date to input field.", e);
        }
    }

}
