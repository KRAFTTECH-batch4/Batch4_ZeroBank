package com.zerobank.step_defs;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class PayBills_StepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("Validate that user is on the pay bills page")
    public void validate_that_user_is_on_the_pay_bills_page() {
        String actual = Driver.get().getTitle();
        String expected = "Zero - Pay Bills";
        Assert.assertEquals(expected,actual);
    }

    @When("User sends {string} amount to input box")
    public void user_sends_amount_to_input_box(String string) {
        payBillsPage.sendAmount(string);
    }

    @When("User sends {string} date to input box")
    public void user_sends_date_to_input_box(String string) {
        payBillsPage.sendDate(string);
    }

    @When("User sends {string} data to input box")
    public void user_sends_data_to_input_box(String string) {
        payBillsPage.sendDescription(string);
    }

    @When("User taps on Pay button")
    public void user_taps_on_pay_button() {
        payBillsPage.tapOnPayButton();
    }

    @Then("Validate that success message is visible")
    public void validate_that_success_message_is_visible() {
        String actual = payBillsPage.getSuccessMessageText();
        String expected = "The payment was successfully submitted.";
        Assert.assertEquals(expected,actual);
    }
}
