package ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPageView extends AbstractWebView<MainPageView> {

    @FindBy(xpath = "//a[@class='close']")
    private WebElement closeButtonWelcomePopUp;

    @FindBy(xpath = "//a[@class='nav-link'][@data-metric='Products']")
    private WebElement productCategory;

    @FindBy(xpath = "//div[contains(@class,'products')]//a[contains(@title,'Doorbells')]")
    private WebElement doorbellsCategory;

    public MainPageView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isActive() {
        return closeButtonWelcomePopUp.isDisplayed();
    }

    public void closeWelcomePopUp() {
        if (closeButtonWelcomePopUp.isDisplayed()) {
            closeButtonWelcomePopUp.click();
        }
    }

    public DoorbellsPageView clickDoorbellsCategory() {
        Actions action = new Actions(driver);
        if (!doorbellsCategory.isDisplayed()) {
            action.moveToElement(productCategory).perform();
        }
        doorbellsCategory.click();
        return new DoorbellsPageView(driver);
    }
}
