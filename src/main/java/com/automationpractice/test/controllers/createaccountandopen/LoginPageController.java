package com.automationpractice.test.controllers.createaccountandopen;

import com.automationpractice.test.page.utilpage.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static com.automationpractice.test.helpers.Dictionary.*;

public class LoginPageController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaLoginPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());

            webAction.click(
                    landingPage.getSignIn(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

        } catch (WebActionsException e) {
            Report.reportFailure(ERROR_VALIDATING, e);
        }
    }
}
