package stepDefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.*;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSteps {

    LoginPage loginPage;

    @Given("the user opens the MOT website")
    public void the_user_opens_the_mot_website() {
        loginPage = new LoginPage(TestHooks.driver);
        loginPage.openWebsite();
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("the user chooses to log in with PKI")
    public void the_user_chooses_to_log_in_with_pki() {
        loginPage.clickLoginByPKI();
    }

    @Then("the login page should display successfully")
    public void the_login_page_should_display_successfully() {
        System.out.println("Login page displayed successfully.");
    }

    @Then("Wait till mobile numberPage loads")
    public void wait_till_mobile_numberPage_loads(){
        loginPage.waitUntilMobileLoginPageLoads();
    }

    @And("Input the mobile number {string}")
    public void inputMobileNumberAndExpiry(String pkid) {
        loginPage.mobileNumberInput(pkid);
    }

    @Then("Click on the Login in Mobile PKI Option")
    public void clickOnLoginInMobilePKI(){
        loginPage.loginClickMobilePKI();
    }

}
