package com.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WomanPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]")
     WebElement women;

    public WebElement getWomen() {
        return women;
    }

    public WomanPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
