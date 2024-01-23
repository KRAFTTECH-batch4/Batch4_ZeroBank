package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

@Getter
public class FindTransactionsPage extends BasePage{

    @FindBy(css = "#aa_fromDate")
    private WebElement fromDateBox;

    @FindBy(css = "#aa_toDate")
    private WebElement toDateBox;

    @FindBy(xpath = "//button[.='Find']")
    private WebElement findButton;

    @FindBy(xpath = "(//table)[2]/tbody//tr//td[1]")
    private List<WebElement> dates;

    @FindBy(css = "#aa_description")
    private WebElement descriptionBox;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[2]")
    private List<WebElement> filteredDescriptions;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[3]")
    private List<WebElement> filteredDeposits;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[4]")
    private List<WebElement> filteredWithdrawals;

    @FindBy(css = "#aa_type")
    public WebElement dropDownMenu;

    public void sendDates(String fromDate, String toDate) {
        BrowserUtils.sendKeys(fromDateBox, fromDate);
        BrowserUtils.sendKeys(toDateBox,toDate);
    }

    public void tapOnFindButton() {
        BrowserUtils.clickWithJS(findButton);
    }

    public List<String> getDates() {
        return BrowserUtils.getElementsText(dates);
    }

    public void sendDescription(String desc) {
        BrowserUtils.sendKeys(descriptionBox, desc);
    }

    public void isListContainsGivenText(String str) {
        Assert.assertTrue(BrowserUtils.getElementsText(filteredDescriptions).stream().allMatch(n -> n.toLowerCase(Locale.ROOT).contains(str)));
    }

    public void selectMenu(String str) {
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText(str);
    }
}
