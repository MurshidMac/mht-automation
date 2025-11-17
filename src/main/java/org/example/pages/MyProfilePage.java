package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage {
    WebDriver driver;

    private By loggedInUser = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div[2]/div[1]");


    public MyProfilePage(WebDriver driver){
        this.driver = driver;
    }
}
