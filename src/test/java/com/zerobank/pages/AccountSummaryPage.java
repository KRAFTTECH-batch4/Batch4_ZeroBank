package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(css = ".board-header")
    private List<WebElement> accountTypes;

    @FindBy(xpath = "(//table[@class='table'])[3]//th")
    private List<WebElement> columns;

    public List<String> getAccountTypesTexts(){
        return BrowserUtils.getElementsText(accountTypes);
    }

    public List<String> getColumnNames(){
        return BrowserUtils.getElementsText(columns);
    }

}
