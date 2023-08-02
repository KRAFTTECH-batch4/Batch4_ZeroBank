package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "button#signin_button")
    private WebElement signInButton;

    @FindBy(css = "input#user_login")
    private WebElement loginBox;

    @FindBy(css = "input#user_password")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//form[@id='login_form']/div[1]")
    private WebElement warningMessage;

    public void tapOnSignInButton(){
        BrowserUtils.clickWithJS(signInButton);
    }

    public void login(){
        BrowserUtils.sendKeys(loginBox, ConfigurationReader.get("username"));
        BrowserUtils.sendKeys(passwordBox, ConfigurationReader.get("password"));
        BrowserUtils.clickWithJS(loginButton);
    }

    public void fillUsernameAndPassword(String s1, String s2){
        BrowserUtils.sendKeys(loginBox, s1);
        BrowserUtils.sendKeys(passwordBox, s2);
    }

    public void tapOnLoginButton(){
        BrowserUtils.clickWithJS(loginButton);
    }

    public String getWarningElementText(){
        return BrowserUtils.getText(warningMessage);
    }

}
