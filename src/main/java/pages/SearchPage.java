package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

import java.time.Duration;

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
        return wait.waitForElementByBy(By.cssSelector("div.plp-filter-options.active > div:nth-child(4) > div.m-radio"), 10, 2);
    }
}
