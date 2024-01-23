package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AddNewPayeePage extends BasePage{

    @FindBy(css = "#np_new_payee_name")
    private WebElement payeeName;

    @FindBy(css = "#np_new_payee_address")
    private WebElement payeeAddress;

    @FindBy(css = "#np_new_payee_account")
    private WebElement account;

    @FindBy(css = "#np_new_payee_details")
    private WebElement payeeDetails;

    @FindBy(css = "#add_new_payee")
    private WebElement addButton;

    public void tapOnAddButton() {
        BrowserUtils.clickWithJS(addButton);
    }

}
