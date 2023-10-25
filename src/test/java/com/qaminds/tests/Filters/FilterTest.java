package com.qaminds.tests.Filters;

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
public class FilterTest extends BaseTest {

    @Test(testName = "validar el filtro de descuento de un producto", description = "Usar el filtro de descuento y verificar que los precios conincidan con el descuento")
    public void validaFiltroDescuento() throws InterruptedException {

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

        //Valida si el descuento esta visible
        log.info("Step assert: Validar que el descuento este visible");
        assertThat(sp.isVisibleDescuento()).isTrue();
        ReporterManager.createLogTest().log(Status.PASS, MarkupHelper.createLabel("Step assert: Validar que el descuento este visible", ExtentColor.BLUE));

        //Clic descuento
        log.info("Step Five: Cliquea el filtro de descuento");
        sp.onClickOptionDescuento();
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step Five: Cliquea el filtro de descuento", ExtentColor.BLUE));

        Thread.sleep(3000);

        //validar el filtro de descuento
        log.info("Step assert: Validar el filtro de descuento");
        assert(sp.validaDescuento());
        ReporterManager.createLogTest().log(Status.PASS, MarkupHelper.createLabel("Step assert: Validar el filtro de descuento", ExtentColor.BLUE));
    }

    @Test(testName = "validar el filtro de descuento de un producto", description = "Usar el filtro de descuento y verificar que los precios conincidan con el descuento")
    public void validaFiltroColor() throws InterruptedException {

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

        //Valida si el color esta visible
        log.info("Step assert: Validar que el color este visible");
        assertThat(sp.isVisibleColor()).isTrue();
        ReporterManager.createLogTest().log(Status.PASS, MarkupHelper.createLabel("Step assert: Validar que el color este visible", ExtentColor.BLUE));

        //Clic descuento
        log.info("Step Five: Cliquea el filtro de color");
        sp.onClickOptionColor();
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step Five: Cliquea el filtro de color", ExtentColor.BLUE));

        Thread.sleep(3000);

        //validar el filtro de color
        log.info("Step assert: Validar el filtro de color");
        assertThat(sp.listColor()).contains(sp.textColor());
        ReporterManager.createLogTest().log(Status.PASS, MarkupHelper.createLabel("Step assert: Validar el filtro de color", ExtentColor.BLUE));
    }
}
