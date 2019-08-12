import org.testng.Assert;
import org.testng.annotations.*;

public class DoorbellsPageTest extends BaseTest {

    @Test
    public void doorbellsPricesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        DoorbellsPage doorbellsPage = mainPage.clickDoorbellsCategory();

        Assert.assertEquals(5, doorbellsPage.getDoorbellPrices().size(), "quantity of doorbells prices isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(1), 199.00, "the price of first doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(2), 99.99, "the price of second doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(3), 199.00, "the price of third doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(4), 169.00, "the price of fourth doorbell price isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(5), 499.00, "the price of fifth doorbell price isn't equal to expected");
    }

    @Test
    public void doorbellsNamesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        DoorbellsPage doorbellsPage = mainPage.clickDoorbellsCategory();

        Assert.assertEquals(5, doorbellsPage.getDoorbellsNames().size(), "quantity of doorbells names isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(1), "Door View Cam", "name of first doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(2), "Video Doorbell", "name of second doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(3), "Video Doorbell 2", "name of third doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(4), "Video Doorbell Pro", "name of fourth doorbell isn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(5), "Video Doorbell Elite", "name of fifth doorbell isn't equal to expected");
    }

}
