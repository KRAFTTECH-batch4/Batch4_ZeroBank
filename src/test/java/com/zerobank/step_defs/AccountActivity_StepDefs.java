package com.zerobank.step_defs;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountActivity_StepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("Validate that user is on the account activity page")
    public void validate_that_user_is_on_the_account_activity_page() {
        String actual = Driver.get().getTitle();
        String expected = "Zero - Account Activity";
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate that the default option in dropdown menu is Savings")
    public void validate_that_the_default_option_in_dropdown_menu_is_savings() {
        String actual = accountActivityPage.getDefaultSelectedElementText();
        String expected = "Savings";
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate that the dropdown menu has followings")
    public void validate_that_the_dropdown_menu_has_followings(List<String> expected) {
        List<String> actual = accountActivityPage.getAllTextsInDropDownMenu();
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate that columns have followings")
    public void validate_that_columns_have_followings(List<String> expected) {
        List<String> actual = accountActivityPage.getColumnNames();
        Assert.assertEquals(expected,actual);
    }

    @When("Go to {string}")
    public void go_to(String string) {
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//a[.='"+ string + "']")));
    }

    @Then("Validate that user is on the {string} is as expected")
    public void validate_that_user_is_on_the_is_as_expected(String url) {
        Assert.assertEquals(url, Driver.get().getCurrentUrl());
    }

    @Then("Validate that {string} is as expected")
    public void validate_that_is_as_expected(String selectedMenu) {
        Assert.assertEquals(selectedMenu, accountActivityPage.getDefaultSelectedElementText());
    }
}
