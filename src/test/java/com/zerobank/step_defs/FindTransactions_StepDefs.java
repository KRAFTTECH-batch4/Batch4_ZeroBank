package com.zerobank.step_defs;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindTransactions_StepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();
    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

    @When("Click on Find Transactions")
    public void click_on_find_transactions() {
        accountActivityPage.tapOnFindTransactions();
    }

    @When("Enter dates from {string} to {string}")
    public void enter_dates_from_to(String string, String string2) {
        findTransactionsPage.sendDates(string,string2);
    }

    @Then("Validate that results is sorted by most recent date")
    public void validate_that_results_is_sorted_by_most_recent_date() {
        List<String> dates = findTransactionsPage.getDates();
        List<String> reversedDates = dates.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //check if both of are same
        Assert.assertEquals(dates, reversedDates);
    }

    @When("Tap on Find button")
    public void tapOnFindButton() {
        BrowserUtils.waitFor(2);
        findTransactionsPage.tapOnFindButton();
        BrowserUtils.waitFor(2);
    }

    @Then("Validate that results table only show transactions between {string} to {string}")
    public void validate_that_results_table_only_show_transactions_between_to(String string, String string2) {
        List<String> dates = findTransactionsPage.getDates();
        System.out.println("dates = " + dates);
        LocalDate date1 = LocalDate.parse(string);
        LocalDate date2 = LocalDate.parse(string2);
        //dates.stream().anyMatch(p -> LocalDate.parse(p).isAfter(date1) && LocalDate.parse(p).isBefore(date2));
        dates.forEach(p -> {
            System.out.println((LocalDate.parse(p).isAfter(date1) && LocalDate.parse(p).isBefore(date2)) || LocalDate.parse(p).isEqual(date1) || LocalDate.parse(p).isEqual(date2));
            Assert.assertTrue(((LocalDate.parse(p).isAfter(date1) && LocalDate.parse(p).isBefore(date2)) || LocalDate.parse(p).isEqual(date1) || LocalDate.parse(p).isEqual(date2)));
        });
    }

    @When("Enter {string} as description")
    public void enter_as_description(String string) {
        findTransactionsPage.sendDescription(string);
    }
    @Then("Validate that descriptions contain {string}")
    public void validate_that_descriptions_contain(String string) {
        findTransactionsPage.isListContainsGivenText(string);
    }

    @Then("Validate that results table should show at least {int} result under Deposit")
    public void validate_that_results_table_should_show_at_least_result_under_deposit(Integer int1) {
        List<String> elementsText = BrowserUtils.getElementsText(findTransactionsPage.getFilteredDeposits());
        Assert.assertTrue(elementsText.stream().anyMatch(n -> !n.isBlank()));
    }
    @Then("Validate that results table should show at least {int} result under Withdrawal")
    public void validate_that_results_table_should_show_at_least_result_under_withdrawal(Integer int1) {
        List<String> elementsText = BrowserUtils.getElementsText(findTransactionsPage.getFilteredWithdrawals());
        Assert.assertTrue(elementsText.stream().anyMatch(n -> !n.isBlank()));
    }



    @Then("Validate that results table should show at least one result under Deposit")
    public void validate_that_results_table_should_show_at_least_one_result_under_deposit() {
        Assert.assertTrue(BrowserUtils.getElementsText(findTransactionsPage.getFilteredDeposits()).stream().
                anyMatch(n -> !n.isBlank()));
    }

    @Then("Validate that results table should show no result under Withdrawal")
    public void validate_that_results_table_should_show_no_result_under_withdrawal() {
        Assert.assertTrue(BrowserUtils.getElementsText(findTransactionsPage.getFilteredWithdrawals()).
                stream().allMatch(String::isBlank));
    }

    @When("Select type {string}")
    public void selectType(String arg0) {
        findTransactionsPage.selectMenu(arg0);
        BrowserUtils.waitFor(2);
    }

    @Then("Validate that results table should show no result under Deposit")
    public void validate_that_results_table_should_show_no_result_under_deposit() {
        Assert.assertTrue(BrowserUtils.getElementsText(findTransactionsPage.getFilteredDeposits()).stream()
                .allMatch(String::isBlank));
    }
}
