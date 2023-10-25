package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {
    private WebDriver driver;
    private WaitHelper wait;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitHelper(driver);
        wait.waitForElementByBy(By.cssSelector("aside > div > div > div:nth-child(19)"), 10, 2);
    }

    public void onClickOptionDescuento(){
        wait.waitForElementByWebElement(OptionDescuento(), Duration.ofSeconds(15), Duration.ofSeconds(2)).click();
    }

    private WebElement OptionDescuento(){
        return wait.waitForElementByBy(By.cssSelector("div.plp-filter-options.active > div:nth-child(4) > div.m-radio"), 15, 2);
    }

    public boolean isVisibleDescuento(){
        return wait.waitForElementByBy(By.cssSelector("div.plp-filter-options.active > div:nth-child(4) > div.m-radio"), 15, 2).isDisplayed();
    }

    public boolean isVisibleColor(){
        return wait.waitForElementByBy(By.cssSelector("#ColorcountViewMore5"), 15, 2).isDisplayed();
    }

    public void onClickOptionColor(){
        wait.waitForElementByWebElement(OptionColor(), Duration.ofSeconds(15), Duration.ofSeconds(2)).click();
    }

    private WebElement OptionColor(){
        return wait.waitForElementByBy(By.cssSelector("#ColorcountViewMore5"), 15, 2);
    }

    public String textColor(){
        return wait.waitForElementByBy(By.cssSelector("div.plp-filters-container.mt-3.mb-3 > div > div > div"), 15, 2).getText().trim();
    }

    public List<String> listColor(){
        WebElement coloresProd = wait.waitForElementByBy(By.cssSelector("li:nth-child(1) > a > div > figure > figcaption > div > div > div.a-plp-color"), 15, 2);

        List<String> listaColores = coloresProd.findElements(By.tagName("span")).stream()
                .map(WebElement->WebElement.getAttribute("title"))
                .collect(Collectors.toList());
        return listaColores;
    }

    private double precio(){
        String precio = wait.waitForElementByBy(By.cssSelector("li:nth-child(1) > a > div > figure > figcaption > div > div > p.a-card-price"), 15, 2).getText().trim();

        precio = precio.substring(1);

        String precioCentavos = precio.substring(precio.length() - 2);

        precio = precio.substring(0, precio.length() - 2);

        double precioD;

        return precioD = (Double.parseDouble(precio) + (Double.parseDouble(precioCentavos)/100));
    }

    private double precioDescuento(){
        String precio = wait.waitForElementByBy(By.cssSelector("li:nth-child(1) > a > div > figure > figcaption > div > div > p.a-card-discount"), 15, 2).getText().trim();

        precio = precio.substring(1);

        String precioCentavos = precio.substring(precio.length() - 2);

        precio = precio.substring(0, precio.length() - 2);

        double precioD;

        return precioD = (Double.parseDouble(precio) + (Double.parseDouble(precioCentavos)/100));
    }

    public boolean validaDescuento(){
        if(precioDescuento() <= (precio() / 2)){
            return true;
        }
        return false;
    }
}
