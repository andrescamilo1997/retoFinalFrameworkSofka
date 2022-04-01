package com.automationpractice.test.page.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUsMenuPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contact-link\"]")
     WebElement contactUsMenu;

    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement heading;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(id="submitMessage")
    WebElement clickFinish;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement msgAllOk;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    WebElement msgAllNotOk;

    public WebElement getMsgAllNotOk() {
        return msgAllNotOk;
    }

    public WebElement getClickFinish() {
        return clickFinish;
    }

    public WebElement getMsgAllOk() {
        return msgAllOk;
    }

    public WebElement getHeading() {
        return heading;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getContactUsMenu() {
        return contactUsMenu;
    }

    public ContactUsMenuPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
