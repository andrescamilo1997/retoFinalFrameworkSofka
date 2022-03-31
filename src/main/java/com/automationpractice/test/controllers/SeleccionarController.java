package com.automationpractice.test.controllers;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.test.model.Customer;
import com.automationpractice.test.page.SelectWomensClothesPage;
import com.automationpractice.test.page.WomanPage;
import com.automationpractice.test.page.WomensClothesMessageContinueOrPayPage;
import com.automationpractice.test.page.WomensClothesMoreInfoPage;

import static com.automationpractice.test.helpers.Dictionary.*;
import static com.automationpractice.test.helpers.Helper.generateCustomer;

public class SeleccionarController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void seleccionarUnProducto(){
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
    public void irABuscarOtroProducto(){
        try{
            WomensClothesMessageContinueOrPayPage womensClothesMessage = new WomensClothesMessageContinueOrPayPage(webAction.getDriver());

            webAction.click(womensClothesMessage.getContinueShopping(), 10, true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }

    public void seleccionarOtroProducto(){
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

    public void noSeleccionarEIrAComprar(){
        try{
            WomensClothesMessageContinueOrPayPage womensClothesMessage = new WomensClothesMessageContinueOrPayPage(webAction.getDriver());
            webAction.click(womensClothesMessage.getProceedToCheckout(), 10, true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }
}
