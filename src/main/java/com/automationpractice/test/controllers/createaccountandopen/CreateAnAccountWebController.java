package com.automationpractice.test.controllers.createaccountandopen;

import com.automationpractice.test.model.Customer;
import com.automationpractice.test.page.createaccountandlogin.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static com.automationpractice.test.helpers.Dictionary.*;
import static com.automationpractice.test.helpers.Helper.generateCustomer;

public class CreateAnAccountWebController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText           (
                    createAnAccountPage.getEmailAddress(),
                    customer.getEmail(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);
            webAction.click              (
                    createAnAccountPage.getCreateAnAccount(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);
            webAction.click              (
                    createAnAccountPage.getMr(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);
            webAction.sendText           (
                    createAnAccountPage.getFirstName(),
                    customer.getFirstName(),
                    SCREENSHOT);
            webAction.sendText           (
                    createAnAccountPage.getLastName(),
                    customer.getLastName(),
                    SCREENSHOT);
            webAction.sendText           (
                    createAnAccountPage.getPassword(),
                    customer.getPassword(),
                    SCREENSHOT);
            webAction.selectByPartialText(
                    createAnAccountPage.getDay(),
                    customer.getDayBirth(),
                    SCREENSHOT);
            webAction.selectByValue      (
                    createAnAccountPage.getMonth(),
                    customer.getMonthBirth(),
                    SCREENSHOT);
            webAction.selectByPartialText(
                    createAnAccountPage.getYear(),
                    customer.getYearBirth(),
                    SCREENSHOT);
            webAction.sendText           (
                    createAnAccountPage.getAddress1(),
                    customer.getAddress(),
                    SCREENSHOT);
            webAction.sendText           (
                    createAnAccountPage.getCity(),
                    customer.getCity(),
                    SCREENSHOT);
            webAction.selectByText       (
                    createAnAccountPage.getState(),
                    customer.getState(),
                    SCREENSHOT);
            webAction.sendText           (
                    createAnAccountPage.getPostCode(),
                    customer.getPostalCode(),
                    SCREENSHOT);
            webAction.sendText           (
                    createAnAccountPage.getPhoneMobile(),
                    customer.getMobilePhone(),
                    SCREENSHOT);
            webAction.click              (
                    createAnAccountPage.getRegister(),
                    SCREENSHOT);


        } catch (WebActionsException e) {
            Report.reportFailure(ERROR_VALIDATING, e);
        }
    }
}
