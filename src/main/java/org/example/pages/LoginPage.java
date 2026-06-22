package org.example.pages;

import org.example.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page object for the login interactions used in examples.
 */
public class LoginPage extends BasePage{

    //private By loginButton =  By.xpath("//a[@class='nav-link' and text()='Login']");
    private By loginButton =  By.xpath("//html/body/div[1]/div/div[3]/div[1]/div/div/a");
    private By mobilePKILogin = By.xpath("//a[@title='Login with the Mobile ID']");
    private By mobileNumber = By.name("mobileNumber");
    private By mobileLoginButton = By.cssSelector("button[name='button'][value='login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openWebsite() {
        driver.get(ConfigReader.get("base.url"));
    }

    public void clickLoginButton() {
        actions.click(loginButton);
    }

    public void clickLoginByPKI() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            // wait for next page element
            wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePKILogin));
            driver.findElement(mobilePKILogin).click();
        } catch (NoSuchElementException e) {
            System.err.println("PKI Element not found. Trying alternative...");
        }
    }

    public void waitUntilMobileLoginPageLoads(){
        try{
            // wait for next page element (Mobile Number input)
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));
        }catch (NoSuchElementException e){
            System.err.println(e.getMessage());
        }
    }

    public void mobileNumberInput(String pkid){
        // Locate the ID/mobileNumber input field
        WebElement idField = driver.findElement(mobileNumber);
        idField.clear();
        idField.sendKeys(pkid);
    }

    public void loginClickMobilePKI(){
        actions.click(mobileLoginButton);
    }

}
