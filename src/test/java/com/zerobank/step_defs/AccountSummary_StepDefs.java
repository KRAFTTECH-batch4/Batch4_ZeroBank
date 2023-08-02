package com.zerobank.step_defs;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class AccountSummary_StepDefs {

    LoginPage loginPage = new LoginPage();
    OnlineBankingPage onlineBankingPage = new OnlineBankingPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @When("Tap on {string} section")
    public void tap_on_section(String string) {
        loginPage.navigateToSection(string);
    }

    @When("Tap on {string} menu")
    public void tap_on_menu(String string) {
        onlineBankingPage.navigateToMenu(string);
    }

    @Then("Validate that title is correct")
    public void validate_that_title_is_correct() {
        String expected = "Zero - Account Summary";
        String actual = Driver.get().getTitle();
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate accounts types")
    public void validate_accounts_types(List<String> expected) {
        List<String> actual = accountSummaryPage.getAccountTypesTexts();
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate credit accounts columns")
    public void validate_credit_accounts_columns(List<String> expected) {
        List<String> actual = accountSummaryPage.getColumnNames();
        Assert.assertEquals(expected,actual);
    }
}
