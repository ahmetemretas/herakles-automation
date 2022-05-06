package com.herakles.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KicchiPage extends BasePage {

    @FindBy(xpath = "//*[@value='Generate random number']")
    public WebElement generateRandomNumber;

    @FindBy(id = "btnVerifyNumber")
    public WebElement verifyNumber;


}
