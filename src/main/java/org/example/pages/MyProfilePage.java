package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyProfilePage extends BasePage {

    private By userDropdown = By.id("userDropdown");
    //private By userProfile = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div[2]/div[2]/a[1]/span[2]");
    private By userProfile = By.xpath("//span[@class='user-full-name']");
    private By myProfileUpdateBtn = By.xpath("//button[normalize-space()='Update']");
    private By expiryDate =  By.xpath("//input[contains(@class,'form-control') and @type='text']");

    By myProfileBtn = By.id("MenuItem_MyProfile");


    public WebElement inputFieldElement;

    public MyProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickOnLoggedInUser(){
        if(actions.isDisplayed(userDropdown)){
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
                Thread.sleep(200);
                wait.until(ExpectedConditions.visibilityOfElementLocated(myProfileBtn));
                wait.until(ExpectedConditions.elementToBeClickable(myProfileBtn)).click();
            }catch(InterruptedException e){
                System.err.println("Thread is kept to sleep");
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
            inputFieldElement.clear();
            inputFieldElement.sendKeys(formattedDate);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send expiry date to input field.", e);
        }
    }

}
