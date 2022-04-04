package com.automationpractice.test.controllers.selectandshop;


import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.test.page.selectandshop.CompraPage;

import static com.automationpractice.test.helpers.Dictionary.*;

public class SeleccionarAlertController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String confirmationMessage(){
        String msg = "";
        try{
            CompraPage compraPage = new CompraPage(webAction.getDriver());

            msg = webAction.getText(
                    compraPage.getMsgAllOkInSelection(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT);

        } catch (WebActionsException e) {
            Report.reportFailure(ERROR_VALIDATING, e);
        }

        return msg;
    }
}
