import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ProductPageTest {
    private WebDriver driver;
    private ProductPage productPage;
    private DoorbellsPage doorbellsPage;

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
    public void changeQuantityTest() {
        doorbellsPage.clickBuyNowButton(1);
        productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getQuantityValue(), 1, "quantity doesn't equal to expected");

        productPage.clickUpQuantityButton();
        Assert.assertEquals(productPage.getQuantityValue(), 2, "quantity doesn't equal to expected");

        productPage.clickDownQuantityButton();
        Assert.assertEquals(productPage.getQuantityValue(), 1, "quantity doesn't equal to expected");
    }

    @Test
    public void priceNameOfDoorViewCamTest() {
        doorbellsPage.clickBuyNowButton(1);
        productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductName(), "Door View Cam", "name of product doesn't equal to expected");
        Assert.assertEquals(productPage.getProductPrice(), 199.00, "current price doesn't equal to expected");
    }

    @Test
    public void priceNameOfVideoDoorbellTest() {
        doorbellsPage.clickBuyNowButton(2);
        productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductName(), "Video Doorbell", "name of product doesn't equal to expected");
        Assert.assertEquals(productPage.getProductPrice(), 99.99, "current price doesn't equal to expected");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
