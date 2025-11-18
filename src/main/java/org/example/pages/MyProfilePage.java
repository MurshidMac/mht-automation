package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfilePage extends BasePage {

    private By myProfileBtn = By.id("MenuItem_MyProfile");
    private By userDropdown = By.id("userDropdown");
    private By userProfile = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div[2]/div[2]/a[1]/span[2]");
    private By myProfileUpdateBtn = By.xpath("//button[normalize-space()='Update']");

    public MyProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickOnLoggedInUser() {
        if(actions.isDisplayed(userDropdown)){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Actions actions = new Actions(driver);

            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
            actions.moveToElement(dropdown).pause(Duration.ofMillis(300)).click().perform();
            driver.findElement(userProfile).click();
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

}
