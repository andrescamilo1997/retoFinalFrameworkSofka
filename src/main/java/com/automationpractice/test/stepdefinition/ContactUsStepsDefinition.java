package com.automationpractice.test.stepdefinition;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.test.controllers.contactus.ContactUsAlertController;
import com.automationpractice.test.controllers.contactus.ContactUsAlertNotController;
import com.automationpractice.test.controllers.contactus.ContactUsController;
import com.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import com.automationpractice.test.data.objects.TestInfo;
import com.automationpractice.test.model.Customer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static com.automationpractice.test.helpers.Dictionary.MSG_ALL_NOT_OK_MSG_CONTACT_US;
import static com.automationpractice.test.helpers.Dictionary.MSG_ALL_OKMSG_CONTACT_US;

public class ContactUsStepsDefinition extends Setup{
    private WebAction webAction;
    private Customer customer;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }
    //Sin Login

    @Dado("que el cliente busca alguna informacion en particular")
    public void queElClienteBuscaAlgunaInformacionEnParticular() {
        try{
            StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
            startBrowserWebController.setWebAction(webAction);
            startBrowserWebController.setBrowser(browser());
            startBrowserWebController.setFeatue(testInfo.getFeatureName());
            startBrowserWebController.abrirTiendaOnline();

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }

    }
    @Cuando("el cliente envia sus datos en linea y un mensaje para solicitar informacion")
    public void elClienteEnviaSusDatosEnLineaYUnMensajeParaSolicitarInformacion() {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);

        contactUsController.irAlMenuContactUs();
        contactUsController.contactUsIfNotHaveAccount();
        contactUsController.pressBtnSendContactUs();
    }
    @Entonces("como resultado el usuario recibirà un mensaje diciendole que el mensaje fue enviado con exito")
    public void comoResultadoElUsuarioRecibiràUnMensajeDiciendoleQueElMensajeFueEnviadoConExito() {

        ContactUsAlertController contactUsAlertController = new ContactUsAlertController();
        contactUsAlertController.setWebAction(webAction);
        String msgAllOk = contactUsAlertController.obternerMensajeDeConfirmacion();

        Assert
                .Hard
                .thatString(MSG_ALL_OKMSG_CONTACT_US)
                .isEqualTo(msgAllOk);

    }
    //sin email
    @Dado("que el cliente busca un canal de cominucacion")
    public void queElClienteBuscaUnCanalDeCominucacion() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

    }
    @Cuando("el cliente envia los datos necesarios pero no email")
    public void elClienteEnviaLosDatosNecesariosPeroNoEmail() {

        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);

        contactUsController.irAlMenuContactUs();
        contactUsController.siNoIngresaEmail();
        contactUsController.pressBtnSendContactUs();

    }
    @Entonces("como resultado el usuario recibirà There is 1 error Invalid email address.")
    public void comoResultadoElUsuarioRecibiràThereIs1ErrorInvalidEmailAddress() {
        ContactUsAlertNotController contactUsAlertNotController = new ContactUsAlertNotController();
        contactUsAlertNotController.setWebAction(webAction);
        String msgAllNotOk = contactUsAlertNotController.obternerMensajeDeConfirmacion();

        Assert
                .Hard
                .thatString(MSG_ALL_NOT_OK_MSG_CONTACT_US)
                .isEqualTo(msgAllNotOk);
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
