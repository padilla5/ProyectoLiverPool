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

    @Test(testName = "validar el filtro de LiverPool", description = "Usar el buscador de LiverPool, buscar un articulo y seleccionar algunos filtros")
    public void validateFilters() throws InterruptedException {

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

        //Clic descuento
        log.info("Step Five: Cliquea el filtro de descuento");
        sp.onClickOptionDescuento();
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step Five: Cliquea el filtro de descuento", ExtentColor.BLUE));

        Thread.sleep(3000);

        //Valida si la marca esta visible
        log.info("Step assert: Validar que la marca este visible");
        assertThat(sp.isVisibleMarca1()).isTrue();
        ReporterManager.createLogTest().log(Status.PASS, MarkupHelper.createLabel("Step assert: Validar que la marca este visible", ExtentColor.BLUE));

        //Clic en la marca
        log.info("Step Six: Cliquea la marca");
        sp.onClickOptionMarca1();
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step Six: Cliquea la marca", ExtentColor.BLUE));
    }
}
