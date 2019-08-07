import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;


public class DoorbellsPage {
    private WebDriver driver;

    public DoorbellsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By doorbellsNames = xpath("//a[contains(@class,'cflex grid-view')]//div[contains(text(),'Door')]");
    private By doorbellsPrices = xpath("//span[contains(@class,'product')]");
    private By buyNowButtons = xpath("//div[contains(@class,'product')]//a[@class='plp_button']");


    public List<WebElement> getDoorbellPrices() {
        return driver.findElements(doorbellsPrices);
    }

    public double getPriceByNumber(int number) {
        String price = getDoorbellPrices().get(number - 1).getText().replace("$", "");
        return Double.parseDouble(price);
    }

    public List<WebElement> getDoorbellsNames() {
        return driver.findElements(doorbellsNames);
    }

    public String getNameByNumber(int number) {
        return getDoorbellsNames().get(number - 1).getText();
    }

    public List<WebElement> getAllBuyNowButtons(){
        return driver.findElements(buyNowButtons);
    }

    public ProductPage clickBuyNowButton(int number) {
        getAllBuyNowButtons().get(number - 1).click();
        return new ProductPage(driver);
    }

}
