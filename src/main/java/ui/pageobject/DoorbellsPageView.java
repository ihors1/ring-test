package ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class DoorbellsPageView extends AbstractWebView<DoorbellsPageView> {

    @FindBy(xpath = "//a[contains(@class,'cflex grid-view')]/div/div[1]")
    private List<WebElement> doorbellsNames;

    @FindBy(xpath = "//span[contains(@class,'product')]")
    private List<WebElement> doorbellsPrices;

    @FindBy(xpath = "//div[contains(@class,'product')]//a[@class='plp_button']")
    private List<WebElement> buyNowButtons;

    public DoorbellsPageView(WebDriver driver) {
        super(driver);
    }

    public boolean isActive() {
        return buyNowButtons.get(0).isDisplayed();
    }

    public List<WebElement> getDoorbellPrices() {
        return doorbellsPrices;
    }

    public double getPriceByNumber(int number) {
        String price = getDoorbellPrices().get(number - 1).getText().replace("$", "");
        return Double.parseDouble(price);
    }

    public List<WebElement> getDoorbellsNames() {
        return doorbellsNames;
    }

    public String getNameByNumber(int number) {
        return getDoorbellsNames().get(number - 1).getText();
    }

    public List<WebElement> getAllBuyNowButtons() {
        return buyNowButtons;
    }

    public ProductPageView clickBuyNowButton(int number) {
        getAllBuyNowButtons().get(number - 1).click();
        return new ProductPageView(driver);
    }

}
