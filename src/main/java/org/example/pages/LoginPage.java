package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By loginButton = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/a");
    private By loginByPKId = By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div[3]/div/div[1]/div/div/div[2]/a");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() {
        driver.get("https://mot.almadinagroup.net/");
        System.out.println("Page Title: " + driver.getTitle());
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLoginByPKI() {
        try {
            driver.findElement(loginByPKId).click();
        } catch (NoSuchElementException e) {
            System.err.println("PKI Element not found. Trying alternative...");
            driver.findElement(By.name("Mobile PKI Login")).click();
        }
    }
}
