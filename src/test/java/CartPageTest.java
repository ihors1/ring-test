import org.testng.Assert;
import org.testng.annotations.*;

public class CartPageTest extends BaseTest {

    @Test
    public void priceInProductAndCartTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        DoorbellsPage doorbellsPage = mainPage.clickDoorbellsCategory();
        ProductPage productPage = doorbellsPage.clickBuyNowButton(3);

        productPage.clickAddToCartButton();
        String productNameInPrPage = productPage.getProductName();
        double productPriceInPrPage = productPage.getProductPrice();
        Assert.assertEquals(productNameInPrPage, "Video Doorbell 2", "name of product isn't equal to expected");
        Assert.assertEquals(productPriceInPrPage, 199.00, "current price in Produce Page isn't equal to expected");

        CartPage cartPage = productPage.clickViewCart();
        String productNameInCart = cartPage.getProductName();
        double productPriceInCart = cartPage.getProductPrice();
        Assert.assertEquals(productNameInCart, "Video Doorbell 2", "name of product in Cart Page isn't equal to expected");

        Assert.assertEquals(productPriceInCart, 199.00, "current price in Cart Page isn't equal to expected");
        Assert.assertEquals(productNameInPrPage, productNameInCart, "product name isn't match on product page and cart page");
        Assert.assertEquals(productPriceInPrPage, productPriceInCart, "price on Product page isn't equal to price in Cart");

        Assert.assertEquals(cartPage.getTotalValue(), productPriceInCart, "total price isn't equal to product price");
        Assert.assertEquals(cartPage.getSubtotalValue(), cartPage.getTotalValue(), "total price of one product isn't equal to final amount");
        Assert.assertEquals(cartPage.getSubtotalValue(), productPriceInCart, "final amount isn't equal to product price");
        Assert.assertEquals(cartPage.getSubtotalValue(), 199.00, "final amount isn't equal to expected");
    }

    @Test
    public void quantityAndNameInCartPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        DoorbellsPage doorbellsPage = mainPage.clickDoorbellsCategory();
        ProductPage productPage = doorbellsPage.clickBuyNowButton(4);

        Assert.assertEquals(productPage.getQuantityValue(), 1, "current quantity of product isn't equal to expected");
        Assert.assertEquals(productPage.getProductName(), "Video Doorbell Pro", "name of product isn't equal to expected");

        productPage.clickAddToCartButton();
        CartPage cartPage = productPage.clickViewCart();
        Assert.assertEquals(cartPage.getQuantityValue(), 1, "current quantity of product isn't equal to expected");
        Assert.assertEquals(cartPage.getProductName(), "Video Doorbell Pro", "name of product isn't equal to expected");

        cartPage.clickUpQuantityButton();
        Assert.assertEquals(cartPage.getQuantityValue(), 2, "current quantity of product isn't equal to expected");

        cartPage.clickDownQuantityButton();
        Assert.assertEquals(cartPage.getQuantityValue(), 1, "current quantity of product isn't equal to expected");
        Assert.assertEquals(cartPage.getProductName(), "Video Doorbell Pro", "name of product isn't equal to expected");
    }

}
