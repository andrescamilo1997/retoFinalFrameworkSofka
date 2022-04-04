package com.automationpractice.test.controllers.openwebpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static com.automationpractice.test.helpers.Dictionary.APP_URL_PROPERTY;
import static com.automationpractice.test.helpers.Dictionary.ERROR_VALIDATING;
import static com.automationpractice.test.helpers.Helper.getProperty;

public class StartBrowserWebController {
    private WebAction webAction;
    private String feature;
    private Browser browser;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void abrirTiendaOnline(){
        try{
            webAction.startWebApp(
                    browser,
                    getProperty(APP_URL_PROPERTY),
                    feature);
        } catch (WebActionsException e){
            Report.reportFailure(ERROR_VALIDATING, e);
        }
    }
}
