package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @FindBy(css = "#sp_amount")
    private WebElement amountInputBox;

    @FindBy(css = "#sp_date")
    private WebElement dateInputBox;

    @FindBy(css = "#sp_description")
    private WebElement descriptionBox;

    @FindBy(css = "#pay_saved_payees")
    private WebElement payButton;

    @FindBy(css = "div#alert_content > span")
    private WebElement successMessage;

    public void sendAmount(String str){
        BrowserUtils.sendKeys(amountInputBox, str);
    }

    public void sendDate(String str){
        BrowserUtils.sendKeys(dateInputBox, str);
    }

    public void sendDescription(String str){
        BrowserUtils.sendKeys(descriptionBox, str);
    }

    public void tapOnPayButton(){
        BrowserUtils.clickWithJS(payButton);
    }

    public String getSuccessMessageText(){
        return BrowserUtils.getText(successMessage);
    }

    public String getAmountErrorMessage(){
        return amountInputBox.getAttribute("validationMessage");
    }

    public String getDateErrorMessage(){
        return dateInputBox.getAttribute("validationMessage");
    }

    public boolean isDateBoxEmpty(){
        return dateInputBox.getAttribute("value").isEmpty();
    }

}
