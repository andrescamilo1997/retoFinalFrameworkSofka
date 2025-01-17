package com.automationpractice.test.stepdefinition;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.evidence.reports.Assert;

import com.automationpractice.test.controllers.selectandshop.AlertShopController;
import com.automationpractice.test.controllers.selectandshop.SeleccionarAlertController;
import com.automationpractice.test.controllers.selectandshop.SeleccionarController;
import com.automationpractice.test.controllers.selectandshop.ShopProductsController;
import com.automationpractice.test.data.objects.TestInfo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static com.automationpractice.test.helpers.Dictionary.*;

public class SelectAndBuyStepDefinition extends Setup{
    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    //First Scenario
    @Dado("el cliente despues despues de haberse registrado")
    public void elClienteDespuesDespuesDeHaberseRegistrado() {
        try{
            openPageToTest(webAction, browser(), testInfo.getFeatureName());
            doRegisterAndLogin(webAction);
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
    @Cuando("el cliente compra selecciona un vestido de la seccion Women escoje un vestido, cantidad, colo y agrega al carrito.")
    public void elClienteCompraSeleccionaUnVestidoDeLaSeccionWomenEscojeUnVestidoCantidadColoYAgregaAlCarrito() {
        try{
            SeleccionarController seleccionarController = new SeleccionarController();
            seleccionarController.setWebAction(webAction);

            seleccionarController.selectOneProduct();
            seleccionarController.continueShopping();
            seleccionarController.selectOtherProduct();
            seleccionarController.noSelectMoreAndGoToSummary();
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
    @Entonces("redirije a la seccion de SHOPPING-CART SUMMARY")
    public void redirijeALaSeccionDeSHOPPINGCARTSUMMARY() {
        try{

            SeleccionarAlertController seleccionarAlertController = new SeleccionarAlertController();
            seleccionarAlertController.setWebAction(webAction);
            String message = seleccionarAlertController.confirmationMessage();

            Assert
                    .Hard
                    .thatString(message)
                    .isEqualTo(MSG_ALL_OK_INSELECTION);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    //Second Scenario

    @Dado("el cliente hizo la seleccion de su vestido")
    public void elClienteHizoLaSeleccionDeSuVestido() {
        try{
            openPageToTest(webAction, browser(), testInfo.getFeatureName());
            doRegisterAndLogin(webAction);
        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
    @Cuando("se ubica en comprar el articulo, verifica su descripcion de compra, verfica su direccion, acepta terminos y condiciones")
    public void seUbicaEnComprarElArticuloVerificaSuDescripcionDeCompraVerficaSuDireccionAceptaTerminosYCondiciones() {
        try{
            SeleccionarController seleccionarController = new SeleccionarController();
            seleccionarController.setWebAction(webAction);

            seleccionarController.selectOneProduct();
            seleccionarController.noSelectMoreAndGoToSummary();

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
    @Cuando("Escoge una forma de pago, confirma su orden")
    public void escogeUnaFormaDePagoConfirmaSuOrden() {
        try{
            ShopProductsController shopProductsController = new ShopProductsController();
            shopProductsController.setWebAction(webAction);

            shopProductsController.confirmarPedido();
            shopProductsController.terminosyCondiciones();
            shopProductsController.checkoutProcess();
            shopProductsController.procedToPay();

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }
    @Entonces("se redirige a una seccion donde lee un mensaje, sobre su orden esta completa.")
    public void seRedirigeAUnaSeccionDondeLeeUnMensajeSobreSuOrdenEstaCompleta() {
        try{
            AlertShopController alertShopController = new AlertShopController();
            alertShopController.setWebAction(webAction);
            String mensage = alertShopController.confirmationMessage();

            Assert
                    .Hard
                    .thatString(mensage)
                    .isEqualTo(MSG_ALL_OK_INSSHOP);

        }catch (Exception exception){
            Report.reportFailure(exception.getMessage());
        }
    }

    @After
    public void cerrarDriver() throws InterruptedException {

        Thread.sleep(5000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo(REPORT_INFO
                .concat(testInfo.getFeatureName())
                .concat(TO_CONCAT)
                .concat(testInfo.getScenarioName()));
    }


}
