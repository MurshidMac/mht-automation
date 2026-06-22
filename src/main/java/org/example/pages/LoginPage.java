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
    private By formAuthentication = By.xpath("//div[contains(@class,'btn-title') and normalize-space()='Form Authentication']");
    private By formUsername = By.id("Input_Username");
    private By formPassword = By.id("Input_Password");
    private By formSignInButton = By.cssSelector("button.btn-submit[type='submit']");


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
            wait.until(ExpectedConditions.visibilityOfElementLocated(formAuthentication));
            driver.findElement(formAuthentication).click();
        } catch (NoSuchElementException e) {
            System.err.println("PKI Element not found. Trying alternative...");
        }
    }

    public void waitUntilMobileLoginPageLoads() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
    }

    public void mobileNumberInput(String pkid) {
        WebElement idField = driver.findElement(mobileNumber);
        idField.clear();
        idField.sendKeys(pkid);
    }

    public void loginClickMobilePKI() {
        actions.click(mobileLoginButton);
    }

    public void clickFormAuthentication() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(formAuthentication));
        actions.click(formAuthentication);
    }

    public void fillFormUsername(String username) {
        WebElement usernameField = driver.findElement(formUsername);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void fillFormPassword(String password) {
        WebElement passwordField = driver.findElement(formPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(formSignInButton));
        actions.click(formSignInButton);
    }

}
