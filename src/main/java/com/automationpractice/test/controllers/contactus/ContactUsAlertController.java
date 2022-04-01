package com.automationpractice.test.controllers.contactus;


import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.test.page.contactus.ContactUsMenuPage;

public class ContactUsAlertController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String confirmationMessage(){
        String msg = "";
        try{
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            msg = webAction.getText(contactUsMenuPage.getMsgAllOk(), 10, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }
        return msg;
    }
}
