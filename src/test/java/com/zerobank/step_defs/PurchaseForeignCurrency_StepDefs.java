package com.zerobank.step_defs;

import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignCurrency_StepDefs {

    PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();

    @Then("Validate that following currencies should be available")
    public void validate_that_following_currencies_should_be_available(List<String> expected) {
        List<String> actual = purchaseForeignCurrencyPage.getAvailableCurrencyTypes();
        Assert.assertTrue(actual.containsAll(expected));
    }

    @When("Tap on purchase button")
    public void tap_on_purchase_button() {
        BrowserUtils.clickWithJS(purchaseForeignCurrencyPage.getPurchaseButton());
    }

    @Then("Validate error popUp")
    public void validate_error_pop_up() {
        Assert.assertTrue(purchaseForeignCurrencyPage.isErrorMessageAsExpected());
    }

}
