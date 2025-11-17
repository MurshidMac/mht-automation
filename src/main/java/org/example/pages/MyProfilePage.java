package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProfilePage extends BasePage {

    private By loggedInUser = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div[2]/div[1]/span");
    private By myProfileBtn = By.id("MenuItem_MyProfile");
    private By userDropdown = By.id("userDropdown");


    public MyProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickOnLoggedInUser() {
        if(actions.isDisplayed(userDropdown)){
            WebElement dropdown = actions.waitForElement(userDropdown);
            dropdown.click();
            //actions.click(loggedInUser);
        }else{
            try{
                actions.wait(10000);
            }catch (InterruptedException e){
                System.err.println("Interupted ");
            }
        }
    }

    public void clickOnMyProfile() {
        try{
        if(actions.isDisplayed(myProfileBtn)){
            driver.findElement(myProfileBtn).click();
        }else{
            actions.wait(10000);
        }
        }catch (InterruptedException e){
            System.err.println("Interupted ");
        }

    }

}
