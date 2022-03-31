package com.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomensClothesMessageContinueOrPayPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    WebElement continueShopping;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckout;


    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public WomensClothesMessageContinueOrPayPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
