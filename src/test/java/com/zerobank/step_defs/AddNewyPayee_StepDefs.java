package com.zerobank.step_defs;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Map;

public class AddNewyPayee_StepDefs {

    AddNewPayeePage addNewPayeePage = new AddNewPayeePage();
    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Create new payee using following information")
    public void create_new_payee_using_following_information(Map<String,String> map) {
        BrowserUtils.sendKeys(addNewPayeePage.getPayeeName(), map.get("Payee Name"));
        BrowserUtils.sendKeys(addNewPayeePage.getPayeeAddress(), map.get("Payee Address"));
        BrowserUtils.sendKeys(addNewPayeePage.getAccount(), map.get("Account"));
        BrowserUtils.sendKeys(addNewPayeePage.getPayeeDetails(), map.get("Payee Details"));
    }
    @Then("Message The new payee The Law Offices of Hyde, Price & Scharks was should successfully created. should be displayed")
    public void message_the_new_payee_the_law_offices_of_hyde_price_scharks_was_should_successfully_created_should_be_displayed() {
        String expected = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        String actual = payBillsPage.getNewPayeeSuccessMessage();
        Assert.assertEquals(expected,actual);
    }

    @And("Tap on Add button")
    public void tapOnAddButton() {
        addNewPayeePage.tapOnAddButton();
    }
}
