package com.automationpractice.test.controllers.selectandshop;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.test.model.Customer;
import com.automationpractice.test.page.selectandshop.CompraPage;

import static com.automationpractice.test.helpers.Dictionary.*;
import static com.automationpractice.test.helpers.Helper.generateCustomer;

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
            webAction.moveTo(compraPage.getFirstProceedToChekout(),10,false);
            webAction.click(compraPage.getFirstProceedToChekout(),10,true);

            webAction.moveTo(compraPage.getSecondProceedToChekout(),10,false);
            webAction.click(compraPage.getSecondProceedToChekout(),10,true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void terminosyCondiciones(){
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());

            webAction.moveTo(compraPage.getCheckTermsOfService(),10,false);
            webAction.click(compraPage.getCheckTermsOfService(),10,true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    public void checkoutProcess(){
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());
            webAction.moveTo(compraPage.getThirdProceedToChekout(),10,false);
            webAction.click(compraPage.getThirdProceedToChekout(),10,true);
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }


    public void pago(){
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());

            webAction.moveTo(compraPage.getPayByBankWire(),10,false);
            webAction.click(compraPage.getPayByBankWire(),10,true);

            webAction.moveTo(compraPage.getBtnIConfirmMyOrder(), 10, true);
            webAction.click(compraPage.getBtnIConfirmMyOrder(), 10, true);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }


}
