package utils.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReporterManager {

    private static ExtentReports extent;  // Objeto principal de ExtentReports
    private static ExtentSparkReporter reporter;  // Reporter para la salida HTML
    private static ExtentTest extentTest;  // Representa una entrada de prueba en el reporte
    private static String reportHTMLPath;  // Ruta del archivo de reporte HTML

    public static void createReportHTML(){
        if (extent == null) {
            try {
                createReportName();
                reporter = new ExtentSparkReporter(getReportHTMLPath())
                        .viewConfigurer()
                        .viewOrder()
                        .as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST })
                        .apply();
                configureReporter(reporter);
                extent = new ExtentReports();
                extent.attachReporter(reporter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createTest(String nameTest){
        extentTest = extent.createTest(nameTest);
    }

    public static ExtentTest createLogTest(){
        return extentTest;
    }

    public static void createReportName() {
        // Obtener una marca de tiempo para hacer el nombre del archivo único
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        // Crear la ruta del reporte y el nombre del archivo
        String reportPath = "target/Reports/extentReport_" + timestamp + ".html";
        setReportHTMLPath(reportPath);
    }

    private static void configureReporter(ExtentSparkReporter spark) throws IOException {
        // Cargar el archivo XML de configuración desde la carpeta de recursos
        URL configURL = ReporterManager.class.getClassLoader().getResource("spark-config.xml");
        if (configURL == null) {
            throw new RuntimeException("No se pudo encontrar spark-config.xml");
        }

        // Convertir la URL a una ruta de archivo y cargar la configuración
        File config = new File(configURL.getPath());
        spark.loadXMLConfig(config);
    }

    public static void extentFlush(){
        extent.flush();
    }

    private static void setReportHTMLPath(String reportHTML){
        reportHTMLPath = reportHTML;
    }

    public static String getReportHTMLPath(){
        return reportHTMLPath;
    }
}