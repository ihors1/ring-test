import org.testng.Assert;
import org.testng.annotations.*;
import ui.pageobject.CartPageView;
import ui.pageobject.DoorbellsPageView;
import ui.pageobject.MainPageView;
import ui.pageobject.ProductPageView;

public class CartPageViewTest extends AbstractWebTest {

    @Test
    public void testPriceInProductAndCart() {
        MainPageView mainPageView = new MainPageView(driver);
        mainPageView.closeWelcomePopUp();
        DoorbellsPageView doorbellsPageView = mainPageView.clickDoorbellsCategory();
        ProductPageView productPageView = doorbellsPageView.clickBuyNowButton(3);

        productPageView.clickAddToCartButton();
        String productNameInPrPage = productPageView.getProductName();
        double productPriceInPrPage = productPageView.getProductPrice();
        Assert.assertEquals(productNameInPrPage, "Video Doorbell 2", "name of product isn't equal to expected");
        Assert.assertEquals(productPriceInPrPage, 199.00, "current price in Produce Page isn't equal to expected");

        CartPageView cartPageView = productPageView.clickViewCart();
        String productNameInCart = cartPageView.getProductName();
        double productPriceInCart = cartPageView.getProductPrice();
        Assert.assertEquals(productNameInCart, "Video Doorbell 2", "name of product in Cart Page isn't equal to expected");

        Assert.assertEquals(productPriceInCart, 199.00, "current price in Cart Page isn't equal to expected");
        Assert.assertEquals(productNameInPrPage, productNameInCart, "product name isn't match on product page and cart page");
        Assert.assertEquals(productPriceInPrPage, productPriceInCart, "price on Product page isn't equal to price in Cart");

        Assert.assertEquals(cartPageView.getTotalValue(), productPriceInCart, "total price isn't equal to product price");
        Assert.assertEquals(cartPageView.getSubtotalValue(), cartPageView.getTotalValue(), "total price of one product isn't equal to final amount");
        Assert.assertEquals(cartPageView.getSubtotalValue(), productPriceInCart, "final amount isn't equal to product price");
        Assert.assertEquals(cartPageView.getSubtotalValue(), 199.00, "final amount isn't equal to expected");
    }

    @Test
    public void testQuantityAndNameInCartPage() {
        MainPageView mainPageView = new MainPageView(driver);
        mainPageView.closeWelcomePopUp();
        DoorbellsPageView doorbellsPageView = mainPageView.clickDoorbellsCategory();
        ProductPageView productPageView = doorbellsPageView.clickBuyNowButton(4);

        Assert.assertEquals(productPageView.getQuantityValue(), 1, "current quantity of product isn't equal to expected");
        Assert.assertEquals(productPageView.getProductName(), "Video Doorbell Pro", "name of product isn't equal to expected");

        productPageView.clickAddToCartButton();
        cartPageViewSteps.checkProductsName("Video Doorbell Pro");
        cartPageViewSteps.checkQuantityValue(1);

        cartPageViewSteps.clickUpQuantityButton();
        cartPageViewSteps.checkQuantityValue(2);

        cartPageViewSteps.clickDownQuantityButton();
        cartPageViewSteps.checkQuantityValue(1);
        cartPageViewSteps.checkProductsName("Video Doorbell Pro");
    }

}
