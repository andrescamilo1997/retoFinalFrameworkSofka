package com.automationpractice.test.controllers.selectandshop;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.test.model.Customer;
import com.automationpractice.test.page.selectandshop.CompraPage;

import static com.automationpractice.test.helpers.Dictionary.*;

public class ShopProductsController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void confirmarPedido(){
        try{

            CompraPage compraPage = new CompraPage(webAction.getDriver());
            webAction.moveTo(
                    compraPage.getFirstProceedToChekout(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    compraPage.getFirstProceedToChekout(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

            webAction.moveTo(
                    compraPage.getSecondProceedToChekout(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    compraPage.getSecondProceedToChekout(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void terminosyCondiciones(){
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());

            webAction.moveTo(
                    compraPage.getCheckTermsOfService(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    compraPage.getCheckTermsOfService(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void checkoutProcess(){
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());

            webAction.moveTo(
                    compraPage.getThirdProceedToChekout(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    compraPage.getThirdProceedToChekout(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }


    public void procedToPay(){
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());

            webAction.moveTo(
                    compraPage.getPayByBankWire(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    compraPage.getPayByBankWire(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

            webAction.moveTo(
                    compraPage.getBtnIConfirmMyOrder(),
                    SECONDS_TO_TIME_OUT,
                    NOT_SCREENSHOT
            );
            webAction.click (
                    compraPage.getBtnIConfirmMyOrder(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }


}
