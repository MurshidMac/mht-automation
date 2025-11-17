package org.example.pages;

import org.example.core.UserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage extends BasePage {

    private By loggedInUser = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div[2]/div[1]");

    public MyProfilePage(WebDriver driver){
        super(driver);
    }



}
