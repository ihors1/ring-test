package ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPageView extends AbstractWebView<ProductPageView> {

    @FindBy(xpath = "//div[contains(@class,'qty_btn up')]")
    private WebElement upQuantityButton;

    @FindBy(xpath = "//div[contains(@class,'qty_btn down')]")
    private WebElement downQuantityButton;

    @FindBy(xpath = "//button[contains(@id,'AddToCart-product-template')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(@class,'icon-shopping')]")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//a[contains(@class,'btn-viewcart')]")
    private WebElement viewCartButton;

    @FindBy(xpath = "//input[@id='Quantity']")
    private WebElement quantityValue;

    @FindBy(xpath = "//h1[@class='pdp_desktop product-single__title']")
    private WebElement productName;

    @FindBy(xpath = "//p[contains(@class,'pdp_desktop')]//span[@id='ProductPrice-product-template']")
    private WebElement productPrice;

    public ProductPageView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isActive() {
        return productPrice.isDisplayed();
    }

    public CartPageView clickViewCart() {
        Actions action = new Actions(driver);
        if (!viewCartButton.isDisplayed()) {
            action.moveToElement(shoppingCartIcon).perform();
        }
        viewCartButton.click();
        return new CartPageView(driver);
    }

    public ProductPageView clickUpQuantityButton() {
        if (upQuantityButton.isEnabled()) {
            upQuantityButton.click();
        }
        return this;
    }

    public ProductPageView clickDownQuantityButton() {
        if (downQuantityButton.isEnabled()) {
            downQuantityButton.click();
        }
        return this;
    }

    public ProductPageView clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public String getProductName() {
        return productName.getText();
    }

    public int getQuantityValue() {
        String quantity = quantityValue.getAttribute("value");
        return Integer.parseInt(quantity);
    }

    public Double getProductPrice() {
        String price = productPrice.getText().replace("$", "");
        return Double.parseDouble(price);
    }
}
