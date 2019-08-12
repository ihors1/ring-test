import org.testng.Assert;
import org.testng.annotations.*;

public class ProductPageTest extends BaseTest {

    @Test
    public void changeQuantityTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        DoorbellsPage doorbellsPage = mainPage.clickDoorbellsCategory();
        ProductPage productPage = doorbellsPage.clickBuyNowButton(1);

        Assert.assertEquals(productPage.getQuantityValue(), 1, "quantity isn't equal to expected");

        productPage.clickUpQuantityButton();
        Assert.assertEquals(productPage.getQuantityValue(), 2, "quantity isn't equal to expected");

        productPage.clickDownQuantityButton();
        Assert.assertEquals(productPage.getQuantityValue(), 1, "quantity isn't equal to expected");
    }

    @Test
    public void priceNameOfDoorViewCamTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        DoorbellsPage doorbellsPage = mainPage.clickDoorbellsCategory();
        ProductPage productPage = doorbellsPage.clickBuyNowButton(1);

        Assert.assertEquals(productPage.getProductName(), "Door View Cam", "name of product isn't equal to expected");
        Assert.assertEquals(productPage.getProductPrice(), 199.00, "current price isn't equal to expected");
    }

    @Test
    public void priceNameOfVideoDoorbellTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        DoorbellsPage doorbellsPage = mainPage.clickDoorbellsCategory();
        ProductPage productPage = doorbellsPage.clickBuyNowButton(2);

        Assert.assertEquals(productPage.getProductName(), "Video Doorbell", "name of product isn't equal to expected");
        Assert.assertEquals(productPage.getProductPrice(), 99.99, "current price isn't equal to expected");
    }

}
