package com.automationpractice.test.controllers.contactus;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.test.model.Customer;
import com.automationpractice.test.page.contactus.ContactUsMenuPage;

import static com.automationpractice.test.helpers.Dictionary.*;
import static com.automationpractice.test.helpers.Helper.generateCustomer;

public class ContactUsController {
    private WebAction webAction;
    private Customer customer;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }


    public void goToPageContactUs(){
        try{
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());
            webAction.moveTo(
                    contactUsMenuPage.getContactUsMenu(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    contactUsMenuPage.getContactUsMenu(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void contactUsSendAllTheRequiredFiles(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            webAction.moveTo        (
                    contactUsMenuPage.getHeading(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.selectByValue (
                    contactUsMenuPage.getHeading(),
                    customer.getHeading(),
                    SCREENSHOT
            );

            webAction.moveTo    (
                    contactUsMenuPage.getEmail(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.sendText  (
                    contactUsMenuPage.getEmail(),
                    customer.getEmail(),
                    SCREENSHOT
            );

            webAction.moveTo    (
                    contactUsMenuPage.getMessage(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.sendText  (
                    contactUsMenuPage.getMessage(),
                    customer.getMessage(),
                    SCREENSHOT
            );

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void contactUsButDoesNotSendEmail(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            webAction.moveTo        (
                    contactUsMenuPage.getHeading(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.selectByValue (
                    contactUsMenuPage.getHeading(),
                    customer.getHeading(),
                    SCREENSHOT
            );

            webAction.moveTo    (
                    contactUsMenuPage.getMessage(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT);
            webAction.sendText  (
                    contactUsMenuPage.getMessage(),
                    customer.getMessage(),
                    SCREENSHOT);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void pressBtnSendContactUs(){
        try{
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());
            webAction.moveTo(
                    contactUsMenuPage.getClickFinish(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT);
            webAction.click (
                    contactUsMenuPage.getClickFinish(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }


}
