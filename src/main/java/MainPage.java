import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By closeButtonWelcomePopUp = xpath("//a[@class='close']");
    private By productCategory = xpath("//a[@class='nav-link'][@data-metric='Products']");
    private By doorbellsCategory = xpath("//div[contains(@class,'products')]//a[contains(@title,'Doorbells')]");


    public void closeWelcomePopUp() {
        if (driver.findElement(closeButtonWelcomePopUp).isDisplayed()) {
            driver.findElement(closeButtonWelcomePopUp).click();
        }
    }

    public DoorbellsPage clickDoorbellsCategory() {
        Actions action = new Actions(driver);
        if (!driver.findElement(doorbellsCategory).isDisplayed()) {
            action.moveToElement(driver.findElement(productCategory)).perform();
        }
        driver.findElement(doorbellsCategory).click();
        return new DoorbellsPage(driver);
    }
}
