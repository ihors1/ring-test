package ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageView extends AbstractWebView<CartPageView> {

    @FindBy(xpath = "//div[@class='list-view-item__title']")
    private WebElement productName;

    @FindBy(xpath = "//input[@class='cart__qty-input']")
    private WebElement quantityValue;

    @FindBy(xpath = "//td[contains(@class,'cart__price')]")
    private WebElement productPrice;

    @FindBy(xpath = "//a[@class='add-btn']")
    private WebElement upQuantityButton;

    @FindBy(xpath = "//a[@class='minus-btn']")
    private WebElement downQuantityButton;

    @FindBy(xpath = "//span[@class='cart__subtotal']")
    private WebElement subtotalValue;

    @FindBy(xpath = "//td[@class='text-right small--hide']")
    private WebElement totalPrice;

    public CartPageView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isActive() {
        return productName.isDisplayed();
    }

    public String getProductName() {
        return productName.getText();
    }

    public int getQuantityValue() {
        String quantityText = quantityValue.getAttribute("value");
        return Integer.parseInt(quantityText);
    }

    public double getProductPrice() {
        String price = productPrice.getText().replace("$", "");
        return Double.parseDouble(price);
    }

    public double getSubtotalValue() {
        String price = subtotalValue.getText().replace("USD$", "");
        return Double.parseDouble(price);
    }

    public double getTotalValue() {
        String price = totalPrice.getText().replace("$", "");
        ;
        return Double.parseDouble(price);
    }

    public CartPageView clickUpQuantityButton() {
        if (upQuantityButton.isEnabled()) {
            upQuantityButton.click();
        }
        return this;
    }

    public CartPageView clickDownQuantityButton() {
        if (downQuantityButton.isEnabled()) {
            downQuantityButton.click();
        }
        return this;
    }
}
