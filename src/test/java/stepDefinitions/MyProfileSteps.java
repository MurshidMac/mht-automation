package stepDefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.MyProfilePage;

public class MyProfileSteps {
    MyProfilePage myProfilePage;

    @Then("Verify you're logged by Clicking on My Profile option in Admin")
    public void verifyLoggedUser(){
        myProfilePage = new MyProfilePage(TestHooks.driver);
        myProfilePage.clickOnLoggedInUser();
    }

    // Used by TGL.feature — verifies login succeeded by checking the user dropdown is visible
    @Then("Verify you're logged in successfully")
    public void verifyLoggedInSuccessfully(){
        myProfilePage = new MyProfilePage(TestHooks.driver);
        myProfilePage.verifyUserIsLoggedIn();
    }

    // Used by TGL.feature — clicks My Profile from the user dropdown
    @Then("Click on My Profile option in Admin")
    public void clickMyProfileOptionInAdmin(){
        myProfilePage.clickOnLoggedInUser();
    }

    @And("Click on My Profile Update")
    public void myProfileVisibility(){
        myProfilePage.clickOnMyProfileUpdate();
    }

    @And("My Profile Update Form should appear")
    public void myProfileUpdateForm(){
        myProfilePage.myProfileUpdateFormShouldDisplay();
    }

    @Then("Input the Id expiry {string} to update the form")
    public void inputTheIDExpiryDate(String idExpiry){
        myProfilePage.inputIDExpiryDate(idExpiry);
    }

}
