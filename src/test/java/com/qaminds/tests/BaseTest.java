package com.qaminds.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.Reporter.ReporterManager;
import utils.Reporter.ReporterTestListener;
import utils.ScreenshotHelpers;
import java.lang.reflect.Method;

@Slf4j
@Getter
@Setter
@Listeners(ReporterTestListener.class)
public class BaseTest {
    WebDriver driver;
    private boolean isSuite = false;

    @BeforeSuite
    public void beforeSuite(){
        setSuite(true);
        log.debug("Create the report html in the before Suite");
        ReporterManager.createReportHTML();
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        if(!isSuite()){
            log.debug("Create the report html in the before Suite");
            ReporterManager.createReportHTML();
        }
        ReporterManager.createTest(method.getName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new ScreenshotHelpers(getDriver());
    }

    @AfterMethod
    public void afterMethod(){
        if(!isSuite()){
            ReporterManager.createReportHTML();
        }
        log.info("Close browser");
        getDriver().quit();
    }

    @AfterSuite
    public void afterSuite(){
        ReporterManager.extentFlush();
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