package com.automationpractice.test.controllers.createaccountandopen;

import com.automationpractice.test.page.createaccountandlogin.MyAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static com.automationpractice.test.helpers.Dictionary.*;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerNombreDeNuevoUsuario(){
        String usuario = "";
        try{
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());

            usuario = webAction.getText(
                    myAccountPage.getCustomerName(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

        } catch (WebActionsException e) {
            Report.reportFailure(ERROR_VALIDATING, e);
        }

        return usuario;
    }
}
