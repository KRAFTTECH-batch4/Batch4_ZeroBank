package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnlineBankingPage extends BasePage{

    public void navigateToMenu(String str){
        WebElement element = Driver.get().findElement(By.xpath("//span[.='" + str + "']"));
        BrowserUtils.clickWithJS(element);
    }

}
