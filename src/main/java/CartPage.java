import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productName = xpath("//div[@class='list-view-item__title']");
    private By quantityValue = xpath("//input[@class='cart__qty-input']");
    private By productPrice = xpath("//td[contains(@class,'cart__price')]");
    private By upQuantityButton = xpath("//a[@class='add-btn']");
    private By downQuantityButton = xpath("//a[@class='minus-btn']");
    private By subtotalValue = xpath("//span[@class='cart__subtotal']");
    private By totalPrice = xpath("//td[@class='text-right small--hide']");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public int getQuantityValue() {
        String quantityText = driver.findElement(quantityValue).getAttribute("value");
        return Integer.parseInt(quantityText);
    }

    public double getProductPrice() {
        String price = driver.findElement(productPrice).getText().replace("$","");
        return Double.parseDouble(price);
    }

    public double getSubtotalValue() {
        String price = driver.findElement(subtotalValue).getText().replace("USD$", "");
        return Double.parseDouble(price);
    }

    public double getTotalValue() {
        String price = driver.findElement(totalPrice).getText().replace("$","");;
        return Double.parseDouble(price);
    }

    public CartPage clickUpQuantityButton() {
        if (driver.findElement(upQuantityButton).isEnabled()){
            driver.findElement(upQuantityButton).click();
        }
        return new CartPage(driver);
    }

    public CartPage clickDownQuantityButton() {
        if (driver.findElement(downQuantityButton).isEnabled()) {
            driver.findElement(downQuantityButton).click();
        }
        return new CartPage(driver);
    }
}
