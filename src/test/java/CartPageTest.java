import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CartPageTest {
    private WebDriver driver;
    private DoorbellsPage doorbellsPage;
    private ProductPage productPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/igor/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ring.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        mainPage.clickDoorbellsCategory();
        doorbellsPage = new DoorbellsPage(driver);
    }

    @Test
    public void priceInProductAndCartTest() {
        doorbellsPage.clickBuyNowButton(3);
        productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        String productNameInPrPage = productPage.getProductName();
        double productPriceInPrPage = productPage.getProductPrice();
        Assert.assertEquals(productNameInPrPage, "Video Doorbell 2", "name of product doesn't equal to expected");
        Assert.assertEquals(productPriceInPrPage, 199.00, "current price in Produce Page doesn't equal to expected");

        CartPage cartPage = productPage.clickViewCart();
        String productNameInCart = cartPage.getProductName();
        double productPriceInCart = cartPage.getProductPrice();
        Assert.assertEquals(productNameInCart, "Video Doorbell 2", "name of product in Cart Page doesn't equal to expected");

        Assert.assertEquals(productPriceInCart, 199.00, "current price in Cart Page isn't equal to expected");
        Assert.assertEquals(productNameInPrPage, productNameInCart, "product name doesn't match on product page and cart page");
        Assert.assertEquals(productPriceInPrPage, productPriceInCart, "price on Product page doesn't equal to price in Cart");

        Assert.assertEquals(cartPage.getTotalValue(), productPriceInCart, "total price doesn't equal to product price");
        Assert.assertEquals(cartPage.getSubtotalValue(), cartPage.getTotalValue(), "total price of one product doesn't equal to final amount");
        Assert.assertEquals(cartPage.getSubtotalValue(), productPriceInCart, "final amount doesn't equal to product price");
        Assert.assertEquals(cartPage.getSubtotalValue(), 199.00, "final amount doesn't equal to expected");
    }

    @Test
    public void quantityAndNameInCartPageTest() {
        doorbellsPage.clickBuyNowButton(4);
        productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getQuantityValue(), 1, "current quantity of product doesn't equal to expected");
        Assert.assertEquals(productPage.getProductName(), "Video Doorbell Pro", "name of product doesn't equal to expected");

        productPage.clickAddToCartButton();
        CartPage cartPage = productPage.clickViewCart();
        Assert.assertEquals(cartPage.getQuantityValue(), 1, "current quantity of product doesn't equal to expected");
        Assert.assertEquals(cartPage.getProductName(), "Video Doorbell Pro", "name of product doesn't equal to expected");

        cartPage.clickUpQuantityButton();
        Assert.assertEquals(cartPage.getQuantityValue(), 2, "current quantity of product doesn't equal to expected");

        cartPage.clickDownQuantityButton();
        Assert.assertEquals(cartPage.getQuantityValue(), 1, "current quantity of product doesn't equal to expected");
        Assert.assertEquals(cartPage.getProductName(), "Video Doorbell Pro", "name of product doesn't equal to expected");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
