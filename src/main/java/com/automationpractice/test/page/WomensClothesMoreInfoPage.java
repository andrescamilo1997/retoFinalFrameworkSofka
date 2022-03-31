package com.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomensClothesMoreInfoPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"quantity_wanted_p\"]/a[2]/span")
    WebElement quantityMore;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"quantity_wanted_p\"]/a[1]/span")
    WebElement quantityLess;


    @CacheLookup
    @FindBy(id = "group_1")
    WebElement size;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCart;


    public WebElement getQuantityMore() {
        return quantityMore;
    }

    public WebElement getSize() {
        return size;
    }

    public WebElement getQuantityLess() {
        return quantityLess;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }


    public WomensClothesMoreInfoPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
