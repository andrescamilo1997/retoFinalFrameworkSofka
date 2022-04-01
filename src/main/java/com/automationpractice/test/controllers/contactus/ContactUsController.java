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

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irAlMenuContactUs(){
        try{
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            webAction.moveTo(contactUsMenuPage.getContactUsMenu(), 10, false);
            webAction.click(contactUsMenuPage.getContactUsMenu(), 10, true);


        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void contactUsIfNotHaveAccount(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            webAction.moveTo(contactUsMenuPage.getHeading(), 10, false);
            webAction.selectByValue(contactUsMenuPage.getHeading(), customer.getHeading(), true);

            webAction.moveTo(contactUsMenuPage.getEmail(), 10, false);
            webAction.sendText(contactUsMenuPage.getEmail(), customer.getEmail(), true);

            webAction.moveTo(contactUsMenuPage.getMessage(), 10, false);
            webAction.sendText(contactUsMenuPage.getMessage(), customer.getMessage(), true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void siNoIngresaEmail(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            webAction.moveTo(contactUsMenuPage.getHeading(), 10, false);
            webAction.selectByValue(contactUsMenuPage.getHeading(), customer.getHeading(), true);

            webAction.moveTo(contactUsMenuPage.getMessage(), 10, false);
            webAction.sendText(contactUsMenuPage.getMessage(), customer.getMessage(), true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void pressBtnSendContactUs(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            webAction.moveTo(contactUsMenuPage.getClickFinish(),10,false);
            webAction.click(contactUsMenuPage.getClickFinish(), 10,true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }


}
