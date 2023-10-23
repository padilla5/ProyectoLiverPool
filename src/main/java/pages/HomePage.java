package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WaitHelper wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitHelper(driver);
        wait.waitForElementByBy(By.cssSelector("div.o-col.col-lg-auto.col-6.order-2.order-lg-1.text-center.min-width-logo"), 10, 2);
    }

    public void onClickMenuBuscador(){
        wait.waitForElementByWebElement(menuBuscadorObtener(), Duration.ofSeconds(10), Duration.ofSeconds(2)).click();
    }

    public void sendKeysMenuBuscador(String valor){
        menuBuscadorObtener().sendKeys(valor);
    }

    private WebElement menuBuscadorObtener(){
        return wait.waitForElementByBy(By.id("mainSearchbar"), 10, 2);
    }

    public SearchPage onClickMenuButtonBuscador(){
        wait.waitForElementByWebElement(buttonBuscadorObtener(), Duration.ofSeconds(10), Duration.ofSeconds(2)).click();
        return new SearchPage(driver);
    }

    private WebElement buttonBuscadorObtener(){
        return wait.waitForElementByBy(By.cssSelector("div.o-col.col-lg.order-4.order-lg-2.pt-3.pt-lg-0 > div > div > div > button"), 10, 2);
    }
}
