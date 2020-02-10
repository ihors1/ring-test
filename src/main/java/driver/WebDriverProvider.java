package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    private static ThreadLocal<WebDriverProvider> instance = ThreadLocal.withInitial(WebDriverProvider::new);
    private WebDriver webDriver;

    private WebDriverProvider() {
        this.webDriver = new ChromeDriver();
    }

    public static WebDriverProvider get() {
        return instance.get();
    }

    public WebDriver getDriver() {
        return webDriver;
    }

}
