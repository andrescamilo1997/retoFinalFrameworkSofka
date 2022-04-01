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

            webAction.moveTo(womanPage.getWomen(), 10, false);
            webAction.click(womanPage.getWomen(), 10, true);
            webAction.moveTo(selectWomensClothesPage.getWomenClothesFirst(), 10, false);
            webAction.click(selectWomensClothesPage.getWomenClothesFirst(), 10, true);

            webAction.moveTo(womensClothesMoreInfoPage.getQuantityMore(), 10, false);
            for (int i = 0; i < 3; i++) {
                webAction.click(womensClothesMoreInfoPage.getQuantityMore(), 10, true);
            }
            webAction.moveTo(womensClothesMoreInfoPage.getSize(), 10, false);
            webAction.selectByValue(womensClothesMoreInfoPage.getSize(), customer.getSize(), true);

            webAction.moveTo(womensClothesMoreInfoPage.getAddToCart(), 10, false);
            webAction.click(womensClothesMoreInfoPage.getAddToCart(), 10, true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }

    public void continueShopping(){
        try{
            WomensClothesMessageContinueOrPayPage womensClothesMessage
                    = new WomensClothesMessageContinueOrPayPage(webAction.getDriver());

            webAction.click(womensClothesMessage.getContinueShopping(), 10, true);

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

            webAction.click(womanPage.getWomen(), 10, true);

            webAction.moveTo(selectWomensClothesPage.getWomenClothesSecond(), 10, false);
            webAction.click(selectWomensClothesPage.getWomenClothesSecond(), 10, true);

            webAction.moveTo(womensClothesMoreInfoPage.getQuantityMore(), 10, false);
            for (int i = 0; i < 3; i++) {
                webAction.click(womensClothesMoreInfoPage.getQuantityMore(), 10, true);
            }
            webAction.moveTo(womensClothesMoreInfoPage.getSize(), 10, false);
            webAction.selectByValue(womensClothesMoreInfoPage.getSize(), customer.getSize(), true);

            webAction.moveTo(womensClothesMoreInfoPage.getAddToCart(), 10, false);
            webAction.click(womensClothesMoreInfoPage.getAddToCart(), 10, true);
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void noSelectMoreAndGoToSummary(){
        try{
            WomensClothesMessageContinueOrPayPage womensClothesMessage
                    = new WomensClothesMessageContinueOrPayPage(webAction.getDriver());

            webAction.click(womensClothesMessage.getProceedToCheckout(), 10, true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }
}
