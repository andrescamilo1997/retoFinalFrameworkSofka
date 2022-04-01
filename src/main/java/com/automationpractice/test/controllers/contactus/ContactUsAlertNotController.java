package com.automationpractice.test.controllers.contactus;


import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.test.page.contactus.ContactUsMenuPage;

public class ContactUsAlertNotController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obternerMensajeDeConfirmacion(){
        String mensaje = "";
        try{
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            mensaje = webAction.getText(contactUsMenuPage.getMsgAllNotOk(), 10, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }
        return mensaje;
    }
}
