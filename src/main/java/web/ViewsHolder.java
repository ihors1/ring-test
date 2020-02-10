package web;

import driver.WebDriverProvider;
import exception.FrameworkException;
import org.openqa.selenium.WebDriver;
import ui.pageobject.AbstractWebView;

import java.util.HashMap;
import java.util.Map;

public class ViewsHolder {

    private static ThreadLocal<Map<Class, AbstractWebView<AbstractWebView>>> viewsMap =
            ThreadLocal.withInitial(HashMap::new);

    public static <T extends AbstractWebView> T getView(final Class<T> viewClass) {
        T view = (T) viewsMap.get().get(viewClass);
        if (view == null) {
            view = getInstance(viewClass);
            viewsMap.get().put(viewClass, view);
        }
        return view;
    }

    private static <T extends AbstractWebView> T getInstance(final Class<T> viewClass) {
        try {
            return viewClass.getDeclaredConstructor(WebDriver.class)
                    .newInstance(WebDriverProvider.get().getDriver());
        } catch (Exception e) {
            throw new FrameworkException("Failed to create instance of view: " + viewClass.getName(), e);
        }
    }
}
