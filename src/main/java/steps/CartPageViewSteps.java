package steps;

import org.assertj.core.api.Assertions;
import ui.pageobject.CartPageView;
import web.ViewsHolder;

public class CartPageViewSteps extends AbstractWebSteps {
    private CartPageView cartPageView = ViewsHolder.getView(CartPageView.class);


    public void clickDownQuantityButton() {
        cartPageView.clickDownQuantityButton();
    }

    public void clickUpQuantityButton() {
        cartPageView.clickUpQuantityButton();
    }

    public void checkProductsName(String... names) {
        for (String name : names) {
            Assertions.assertThat(cartPageView.getProductName())
                    .as(cartPageView.getProductName() + " name of product isn't equal to " + name)
                    .isEqualToIgnoringCase(name);
        }
    }

    public void checkQuantityValue(int value) {
        Assertions.assertThat(cartPageView.getQuantityValue())
                .as(cartPageView.getQuantityValue() + " quantity of product isn't equal to " + value)
                .isEqualTo(value);

    }
}
