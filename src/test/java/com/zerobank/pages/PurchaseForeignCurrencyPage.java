package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Getter
public class PurchaseForeignCurrencyPage extends BasePage{

    @FindBy(css = "#pc_currency")
    private WebElement dropDownMenu;

    @FindBy(css = "#purchase_cash")
    private WebElement purchaseButton;

    public List<String> getAvailableCurrencyTypes() {
        return BrowserUtils.getElementsText(new Select(dropDownMenu).getOptions());
    }

    public boolean isErrorMessageAsExpected() {
        return Driver.get().switchTo().alert().getText().equals("Please, ensure that you have filled all the required fields with valid values.");
    }
}
