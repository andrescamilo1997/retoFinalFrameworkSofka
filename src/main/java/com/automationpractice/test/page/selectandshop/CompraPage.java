package com.automationpractice.test.page.selectandshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"order_step\"]/li[1]/span")
    WebElement msgAllOkInSelection;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement firstProceedToChekout;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement secondProceedToChekout;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form\"]/div/p[2]/label")
    WebElement checkTermsOfService;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement thirdProceedToChekout;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p")
    WebElement payByBankWire;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement btnIConfirmMyOrder;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
    WebElement msgAllOkInPay;

    public WebElement getMsgAllOkInSelection() {
        return msgAllOkInSelection;
    }

    public WebElement getFirstProceedToChekout() {
        return firstProceedToChekout;
    }

    public WebElement getSecondProceedToChekout() {
        return secondProceedToChekout;
    }

    public WebElement getCheckTermsOfService() {
        return checkTermsOfService;
    }

    public WebElement getThirdProceedToChekout() {
        return thirdProceedToChekout;
    }

    public WebElement getPayByBankWire() {
        return payByBankWire;
    }

    public WebElement getBtnIConfirmMyOrder() {
        return btnIConfirmMyOrder;
    }

    public WebElement getMsgAllOkInPay() {
        return msgAllOkInPay;
    }

    public CompraPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
