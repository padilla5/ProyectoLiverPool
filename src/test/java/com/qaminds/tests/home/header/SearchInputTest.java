package com.qaminds.tests.home.header;

import com.qaminds.tests.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchInputTest extends BaseTest {

    @Test(testName = "validar el filtro de LiverPool", description = "Usar el buscador de LiverPool, buscar un articulo y seleccionar algunos filtros")
    public void validaFiltro(){

        //Navega a liverpool
        navigateTo("www.liverpool.com.mx/tienda/home");


        //Carga la pagina principal
        HomePage hp = new HomePage(getDriver());

        //Click en el buscador del menu
        hp.onClickMenuBuscador();

        //Escribe en el buscador
        hp.sendKeysMenuBuscador("funda celular");


        //Clic boton buscar
        SearchPage sp = hp.onClickMenuButtonBuscador();


        //Clic descuento
        sp.onClickOptionDescuento();

    }
}
