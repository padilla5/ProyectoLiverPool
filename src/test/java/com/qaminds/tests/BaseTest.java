package com.qaminds.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ScreenshotHelpers;

@Slf4j
public class BaseTest {
    WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new ScreenshotHelpers(getDriver());
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void navigateTo(String _url){
        String url = String.format("https://%s", _url);
        getDriver().get(url);

        if(!getDriver().getCurrentUrl().contains(url)){
            log.error(String.format("El navegador no pudo navegar a la pagina solicitada."));
            System.out.println(ScreenshotHelpers.screenshot());
            throw new RuntimeException("No se encontro : " + url);
        }
    }
}