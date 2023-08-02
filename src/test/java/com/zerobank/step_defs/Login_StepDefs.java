package com.zerobank.step_defs;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the zeroBank page")
    public void user_is_on_the_zero_bank_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("Tap on signIn button")
    public void tap_on_sign_in_button() {
        loginPage.tapOnSignInButton();
    }

    @When("Enter valid credentials and tap on signIn button")
    public void enter_valid_credentials_and_tap_on_sign_in_button() {
        loginPage.login();
    }

    @When("Tap on back button")
    public void tap_on_back_button() {
        Driver.get().navigate().back();
    }

    @Then("Validate that user is on the home page")
    public void validate_that_user_is_on_the_home_page() {
        String expected = "http://zero.webappsecurity.com/index.html";
        String actual = Driver.get().getCurrentUrl();
        Assert.assertEquals(expected,actual);
    }

    @When("Enter {string} AND {string}")
    public void enter_and(String string, String string2) {
        loginPage.fillUsernameAndPassword(string,string2);
    }

    @When("Tap on login button")
    public void tap_on_login_button() {
        loginPage.tapOnLoginButton();
    }

    @Then("Validate that warning message appears")
    public void validate_that_warning_message_appears() {
        String expected = "Login and/or password are wrong.";
        String actual = loginPage.getWarningElementText();
        Assert.assertEquals(expected,actual);
    }

}
