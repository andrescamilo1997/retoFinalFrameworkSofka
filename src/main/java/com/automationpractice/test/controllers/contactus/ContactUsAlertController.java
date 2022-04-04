package com.automationpractice.test.controllers.contactus;


import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.test.page.contactus.ContactUsMenuPage;

import static com.automationpractice.test.helpers.Dictionary.*;

public class ContactUsAlertController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String confirmationMessage(){
        String msg = "";
        try{
            ContactUsMenuPage contactUsMenuPage = new ContactUsMenuPage(webAction.getDriver());

            msg = webAction.getText(
                    contactUsMenuPage.getMsgAllOk(),
                    SECONDS_TO_TIME_OUT,
                    SCREENSHOT
            );

        } catch (WebActionsException e) {
            Report.reportFailure(ERROR_VALIDATING, e);
        }
        return msg;
    }
}
