import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DoorbellsPageTest {
    private WebDriver driver;
    private DoorbellsPage doorbellsPage;
    private MainPage mainPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/igor/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ring.com");
        mainPage = new MainPage(driver);
        mainPage.closeWelcomePopUp();
        mainPage.clickDoorbellsCategory();
        doorbellsPage = new DoorbellsPage(driver);
    }

    @Test
    public void doorbellsPricesTest() {
        Assert.assertEquals(5, doorbellsPage.getDoorbellPrices().size(), "quantity of doorbells prices doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(1), 199.00, "the price of first doorbell price doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(2), 99.99, "the price of second doorbell price doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(3), 199.00, "the price of third doorbell price doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(4), 169.00, "the price of fourth doorbell price doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getPriceByNumber(5), 499.00, "the price of fifth doorbell price doesn't equal to expected");
    }

    @Test
    public void doorbellsNamesTest() {
        Assert.assertEquals(5, doorbellsPage.getDoorbellsNames().size(), "quantity of doorbells names doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(1), "Door View Cam", "name of first doorbell doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(2), "Video Doorbell", "name of second doorbell doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(3), "Video Doorbell 2", "name of third doorbell doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(4), "Video Doorbell Pro", "name of fourth doorbell doesn't equal to expected");
        Assert.assertEquals(doorbellsPage.getNameByNumber(5), "Video Doorbell Elite", "name of fifth doorbell doesn't equal to expected");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
