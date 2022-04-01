package com.automationpractice.test.stepdefinition;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;

import com.automationpractice.test.controllers.contactus.ContactUsAlertController;
import com.automationpractice.test.controllers.contactus.ContactUsAlertNotController;
import com.automationpractice.test.controllers.contactus.ContactUsController;
import com.automationpractice.test.data.objects.TestInfo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static com.automationpractice.test.helpers.Dictionary.MSG_AFTER_SEND_FORM_NO_EMAIL;
import static com.automationpractice.test.helpers.Dictionary.MSG_AFTER_SEND_ALL_THE_FIELDS;

public class ContactUsStepsDefinition extends Setup{
    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo    = new TestInfo  (scenario);
        webAction   = new WebAction (testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    //First Scenario

    @Dado("que el cliente busca alguna informacion en particular")
    public void queElClienteBuscaAlgunaInformacionEnParticular() {
        try{
            openPageToTest(webAction, browser(), testInfo.getFeatureName());
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }
    @Cuando("el cliente envia sus datos en linea y un mensaje para solicitar informacion")
    public void elClienteEnviaSusDatosEnLineaYUnMensajeParaSolicitarInformacion() {
        try{
            ContactUsController contactUsController = new ContactUsController();
            contactUsController.setWebAction(webAction);

            contactUsController.goToPageContactUs                   ();
            contactUsController.contactUsSendAllTheRequiredFiles    ();
            contactUsController.pressBtnSendContactUs               ();
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
    @Entonces("como resultado el usuario recibirà un mensaje diciendole que el mensaje fue enviado con exito")
    public void comoResultadoElUsuarioRecibiraUnMensajeDiciendoleQueElMensajeFueEnviadoConExito() {

        try{
            ContactUsAlertController contactUsAlertController = new ContactUsAlertController();
            contactUsAlertController.setWebAction(webAction);
            String msgAfterSendAllTheFields = contactUsAlertController.confirmationMessage();

            Assert
                    .Hard
                    .thatString(MSG_AFTER_SEND_ALL_THE_FIELDS)
                    .isEqualTo(msgAfterSendAllTheFields);
            
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }

    //Second Scenario

    @Dado("que el cliente busca un canal de cominucacion")
    public void queElClienteBuscaUnCanalDeCominucacion() {
        try{
            openPageToTest(webAction, browser(), testInfo.getFeatureName());
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
    @Cuando("el cliente envia los datos necesarios pero no email")
    public void elClienteEnviaLosDatosNecesariosPeroNoEmail() {

        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);

        contactUsController.goToPageContactUs               ();
        contactUsController.contactUsButDoesNotSendEmail    ();
        contactUsController.pressBtnSendContactUs           ();

    }
    @Entonces("como resultado el usuario recibirà There is 1 error Invalid email address.")
    public void comoResultadoElUsuarioRecibiraThereIs1ErrorInvalidEmailAddress() {
        ContactUsAlertNotController contactUsAlertNotController = new ContactUsAlertNotController();
        contactUsAlertNotController.setWebAction(webAction);
        String msgSendFormButNotSendEmail = contactUsAlertNotController.confirmationMessage();

        Assert
                .Hard
                .thatString(MSG_AFTER_SEND_FORM_NO_EMAIL)
                .isEqualTo(msgSendFormButNotSendEmail);
    }

@After
public void cerrarDriver() throws InterruptedException {

    Thread.sleep(5000);

    if (webAction != null && webAction.getDriver() != null)
        webAction.closeBrowser();

    Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
            .concat(testInfo.getFeatureName())
            .concat("-")
            .concat(testInfo.getScenarioName()));
}
}
