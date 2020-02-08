import org.testng.Assert;
import org.testng.annotations.*;
import ui.pageobject.DoorbellsPageView;
import ui.pageobject.MainPageView;

public class DoorbellsPageViewTest extends BaseTest {

    @Test
    public void testDoorbellsPrices() {
        MainPageView mainPageView = new MainPageView(driver);
        mainPageView.closeWelcomePopUp();
        DoorbellsPageView doorbellsPageView = mainPageView.clickDoorbellsCategory();


        Assert.assertEquals(5, doorbellsPageView.getDoorbellPrices().size(), "quantity of doorbells prices isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getPriceByNumber(1), 199.00, "the price of first doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getPriceByNumber(2), 99.99, "the price of second doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getPriceByNumber(3), 199.00, "the price of third doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getPriceByNumber(4), 169.00, "the price of fourth doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getPriceByNumber(5), 499.00, "the price of fifth doorbell price isn't equal to expected");
    }

    @Test
    public void testDoorbellsNames() {
        MainPageView mainPageView = new MainPageView(driver);
        mainPageView.closeWelcomePopUp();
        DoorbellsPageView doorbellsPageView = mainPageView.clickDoorbellsCategory();

        Assert.assertEquals(5, doorbellsPageView.getDoorbellsNames().size(), "quantity of doorbells names isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getNameByNumber(1), "Door View Cam", "name of first doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getNameByNumber(2), "Video Doorbell", "name of second doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getNameByNumber(3), "Video Doorbell 2", "name of third doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getNameByNumber(4), "Video Doorbell Pro", "name of fourth doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPageView.getNameByNumber(5), "Video Doorbell Elite", "name of fifth doorbell isn't equal to expected");
    }

}
