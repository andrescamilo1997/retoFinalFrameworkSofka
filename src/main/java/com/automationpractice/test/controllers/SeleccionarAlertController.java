package com.automationpractice.test.controllers;


import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.test.page.CompraPage;

public class SeleccionarAlertController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obternerMensajeDeConfirmacion(){
        String mensaje = "";
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());

            mensaje = webAction.getText(compraPage.getMsgAllOkInSelection(), 10, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return mensaje;
    }
}
