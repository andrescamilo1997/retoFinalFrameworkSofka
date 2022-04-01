package com.automationpractice.test.stepdefinition;

import co.com.sofka.test.actions.WebAction;
import com.automationpractice.test.controllers.createaccountandopen.CreateAnAccountWebController;
import com.automationpractice.test.controllers.createaccountandopen.LoginPageController;
import com.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import com.automationpractice.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfiguration = new Browser();
        browserConfiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfiguration.setIncognito(false);
        browserConfiguration.setAutoDriverDownload(true);
        browserConfiguration.setChromeOptions(chomeOptions());

        return browserConfiguration;
    }

    private ChromeOptions chomeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    protected static void openPageToTest(WebAction webAction, Browser browser, String featureName){
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser);
        startBrowserWebController.setFeature(featureName);
        startBrowserWebController.abrirTiendaOnline();
    }

    protected static void doRegisterAndLogin(WebAction webAction){
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
    }

}
