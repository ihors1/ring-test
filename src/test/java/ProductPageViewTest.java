import org.testng.Assert;
import org.testng.annotations.*;
import ui.pageobject.DoorbellsPageView;
import ui.pageobject.MainPageView;
import ui.pageobject.ProductPageView;

public class ProductPageViewTest extends BaseTest {

    @Test
    public void testChangeQuantity() {
        MainPageView mainPageView = new MainPageView(driver);
        mainPageView.closeWelcomePopUp();
        DoorbellsPageView doorbellsPageView = mainPageView.clickDoorbellsCategory();
        ProductPageView productPageView = doorbellsPageView.clickBuyNowButton(1);

        Assert.assertEquals(productPageView.getQuantityValue(), 1, "quantity isn't equal to expected");

        productPageView.clickUpQuantityButton();
        Assert.assertEquals(productPageView.getQuantityValue(), 2, "quantity isn't equal to expected");

        productPageView.clickDownQuantityButton();
        Assert.assertEquals(productPageView.getQuantityValue(), 1, "quantity isn't equal to expected");
    }

    @Test
    public void testPiceNameOfDoorViewCam() {
        MainPageView mainPageView = new MainPageView(driver);
        mainPageView.closeWelcomePopUp();
        DoorbellsPageView doorbellsPageView = mainPageView.clickDoorbellsCategory();
        ProductPageView productPageView = doorbellsPageView.clickBuyNowButton(1);

        Assert.assertEquals(productPageView.getProductName(), "Door View Cam", "name of product isn't equal to expected");
        Assert.assertEquals(productPageView.getProductPrice(), 199.00, "current price isn't equal to expected");
    }

    @Test
    public void testPriceNameOfVideoDoorbell() {
        MainPageView mainPageView = new MainPageView(driver);
        mainPageView.closeWelcomePopUp();
        DoorbellsPageView doorbellsPageView = mainPageView.clickDoorbellsCategory();
        ProductPageView productPageView = doorbellsPageView.clickBuyNowButton(2);

        Assert.assertEquals(productPageView.getProductName(), "Video Doorbell", "name of product isn't equal to expected");
        Assert.assertEquals(productPageView.getProductPrice(), 99.99, "current price isn't equal to expected");
    }

}
