package com.qaminds.tests.home.header;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qaminds.tests.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import utils.Reporter.ReporterManager;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SearchInputTest extends BaseTest {

    @Test(testName = "validar el buscador de LiverPool", description = "Usar el buscador de LiverPool, buscar un articulo")
    public void validarBuscador() throws InterruptedException {

        //Navega a liverpool
        log.info("Step One: Navega a liverpool");
        navigateTo("www.liverpool.com.mx/tienda/home");
        //Carga la pagina principal
        HomePage hp = new HomePage(getDriver());
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step One: Navega a liverpool", ExtentColor.BLUE));

        //Click en el buscador del menu
        log.info("Step Two: Cliquea el buscador");
        hp.onClickMenuBuscador();
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step Two: Cliquea el buscador", ExtentColor.BLUE));

        //Escribe en el buscador
        log.info("Step Three: Escribir en el buscador");
        hp.sendKeysMenuBuscador("funda celular");
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step Three: Escribir en el buscador", ExtentColor.BLUE));


        //Clic boton buscar
        log.info("Step Four: Cliquea el boton buscar");
        SearchPage sp = hp.onClickMenuButtonBuscador();
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step Four: Cliquea el boton buscar", ExtentColor.BLUE));
    }
}
