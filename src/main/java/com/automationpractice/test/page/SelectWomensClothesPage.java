package com.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectWomensClothesPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    WebElement womenClothesFirst;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a")
    WebElement womenClothesSecond;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/h5/a")
    WebElement womenClothesThird;


    public WebElement getWomenClothesFirst() {
        return womenClothesFirst;
    }

    public WebElement getWomenClothesSecond() {
        return womenClothesSecond;
    }

    public WebElement getWomenClothesThird() {
        return womenClothesThird;
    }

    public SelectWomensClothesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
