package stepDefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.*;
import org.example.pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Given("the user opens the MHT Eportal website")
    public void the_user_opens_the_mot_website() {
        loginPage = new LoginPage(TestHooks.driver);
        loginPage.openWebsite();
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @And("the user chooses to log in with PKI")
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

    @When("the user chooses to log in with Form Authentication")
    public void   the_user_chooses_to_log_in_with_Form_Authentication() {
        loginPage.clickFormAuthentication();
    }

    @And("Input the form username {string}")
    public void inputFormUsername(String username) {
        loginPage.fillFormUsername(username);
    }
    //
    @And("Input the form password {string}")
    public void inputFormPassword(String password) {
        loginPage.fillFormPassword(password);
    }

}
