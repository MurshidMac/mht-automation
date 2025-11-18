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

    @And("Click on My Profile Update")
    public void myProfileVisibility(){
        myProfilePage.clickOnMyProfileUpdate();
    }
}
