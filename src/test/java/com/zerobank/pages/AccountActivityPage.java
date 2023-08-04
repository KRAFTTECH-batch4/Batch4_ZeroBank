package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(css = "#aa_accountId")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//thead//th")
    private List<WebElement> columnElements;

    public String getDefaultSelectedElementText(){
        Select select = new Select(dropDownMenu);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return BrowserUtils.getText(firstSelectedOption);
    }

    public List<String> getAllTextsInDropDownMenu(){
        Select select = new Select(dropDownMenu);
        List<WebElement> options = select.getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(options);
        return elementsText;
    }

    public List<String> getColumnNames(){
        List<String> elementsText = BrowserUtils.getElementsText(columnElements);
        return elementsText;
    }
}
