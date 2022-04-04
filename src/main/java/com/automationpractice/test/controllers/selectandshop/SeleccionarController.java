package com.automationpractice.test.controllers.selectandshop;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.test.model.Customer;
import com.automationpractice.test.page.selectandshop.SelectWomensClothesPage;
import com.automationpractice.test.page.selectandshop.WomanPage;
import com.automationpractice.test.page.selectandshop.WomensClothesMessageContinueOrPayPage;
import com.automationpractice.test.page.selectandshop.WomensClothesMoreInfoPage;

import static com.automationpractice.test.helpers.Dictionary.*;
import static com.automationpractice.test.helpers.Helper.generateCustomer;

public class SeleccionarController {
    private WebAction webAction;
    private Customer customer;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void selectOneProduct(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            WomanPage womanPage = new WomanPage(webAction.getDriver());
            SelectWomensClothesPage selectWomensClothesPage = new SelectWomensClothesPage(webAction.getDriver());
            WomensClothesMoreInfoPage womensClothesMoreInfoPage = new WomensClothesMoreInfoPage(webAction.getDriver());

            webAction.moveTo(
                    womanPage.getWomen(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    womanPage.getWomen(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

            webAction.moveTo(
                    selectWomensClothesPage.getWomenClothesFirst(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT);
            webAction.click (
                    selectWomensClothesPage.getWomenClothesFirst(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);

            webAction.moveTo(
                    womensClothesMoreInfoPage.getQuantityMore(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);
            for (int i = 0; i < 3; i++) {
                webAction.click(
                        womensClothesMoreInfoPage.getQuantityMore(),
                        SECONDS_TO_TIME_OUT,
                        SCREENSHOT);
            }

            webAction.moveTo        (
                    womensClothesMoreInfoPage.getSize(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT);
            webAction.selectByValue (
                    womensClothesMoreInfoPage.getSize(),
                    customer.getSize(),
                    SCREENSHOT);

            webAction.moveTo(
                    womensClothesMoreInfoPage.getAddToCart(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);
            webAction.click (
                    womensClothesMoreInfoPage.getAddToCart(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }

    public void continueShopping(){
        try{
            WomensClothesMessageContinueOrPayPage womensClothesMessage
                    = new WomensClothesMessageContinueOrPayPage(webAction.getDriver());

            webAction.click(
                    womensClothesMessage.getContinueShopping(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }

    public void selectOtherProduct(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            WomanPage womanPage = new WomanPage(webAction.getDriver());
            SelectWomensClothesPage selectWomensClothesPage = new SelectWomensClothesPage(webAction.getDriver());
            WomensClothesMoreInfoPage womensClothesMoreInfoPage = new WomensClothesMoreInfoPage(webAction.getDriver());

            webAction.click(
                    womanPage.getWomen(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);

            webAction.moveTo(
                    selectWomensClothesPage.getWomenClothesSecond(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    selectWomensClothesPage.getWomenClothesSecond(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

            webAction.moveTo(
                    womensClothesMoreInfoPage.getQuantityMore(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            for (int i = 0; i < 3; i++) {
                webAction.click(
                        womensClothesMoreInfoPage.getQuantityMore(),
                        SECONDS_TO_TIME_OUT,
                        SCREENSHOT
                );
            }
            webAction.moveTo        (
                    womensClothesMoreInfoPage.getSize(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.selectByValue (
                    womensClothesMoreInfoPage.getSize(),
                    customer.getSize(),
                    SCREENSHOT
            );

            webAction.moveTo(
                    womensClothesMoreInfoPage.getAddToCart(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    womensClothesMoreInfoPage.getAddToCart(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void noSelectMoreAndGoToSummary(){
        try{
            WomensClothesMessageContinueOrPayPage womensClothesMessage
                    = new WomensClothesMessageContinueOrPayPage(webAction.getDriver());

            webAction.click(
                    womensClothesMessage.getProceedToCheckout(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
}
