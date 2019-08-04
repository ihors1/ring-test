import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By upQuantityButton = xpath("//div[contains(@class,'qty_btn up')]");
    private By downQuantityButton = xpath("//div[contains(@class,'qty_btn down')]");
    private By addToCartButton = xpath("//button[contains(@id,'AddToCart-product-template')]");
    private By shoppingCartIcon = xpath("//span[contains(@class,'icon-shopping')]");
    private By viewCartButton = xpath("//a[contains(@class,'btn-viewcart')]");
    private By quantityValue = xpath("//input[@id='Quantity']");
    private By productName = xpath("//h1[@class='pdp_desktop product-single__title']");
    private By productPrice = xpath("//p[contains(@class,'pdp_desktop')]//span[@id='ProductPrice-product-template']");

    public CartPage clickViewCart() {
        Actions action = new Actions(driver);
        if (!driver.findElement(viewCartButton).isDisplayed()) {
            action.moveToElement(driver.findElement(shoppingCartIcon)).perform();
        }
        driver.findElement(viewCartButton).click();
        return new CartPage(driver);
    }

    public void clickUpQuantityButton() {
        if (driver.findElement(upQuantityButton).isEnabled()) {
            driver.findElement(upQuantityButton).click();
        }
    }

    public void clickDownQuantityButton() {
        if (driver.findElement(downQuantityButton).isEnabled()) {
            driver.findElement(downQuantityButton).click();
        }
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public int getQuantityValue() {
        String quantity = driver.findElement(quantityValue).getAttribute("value");
        return Integer.parseInt(quantity);
    }

    public Double getProductPrice() {
        String price = driver.findElement(productPrice).getText().replace("$", "");
        return Double.parseDouble(price);
    }
}
