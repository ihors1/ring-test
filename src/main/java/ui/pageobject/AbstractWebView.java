package ui.pageobject;

import org.openqa.selenium.WebDriver;

public abstract class AbstractWebView<V extends AbstractWebView> {
    protected WebDriver driver;

    public AbstractWebView(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isActive();
}
