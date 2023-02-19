import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartPage {
    private final ElementsCollection productsListInCart = $$x("//div[@class='inventory_item_name']");
    private final ElementsCollection removeButtonList = $$x("//button[contains(@id, 'remove')]");
    private final SelenideElement checkoutButton = $x("//button[@id='checkout']");

    public void removeAllProductsInCart() {
        for (SelenideElement removeButton : removeButtonList) {
            removeButton.click();
        }
    }

    public CheckoutInformationPage goToCheckoutInformation() {
        checkoutButton.click();
        return new CheckoutInformationPage();
    }

    public void checkLProductsListSizeInCart(int listSize) {
        productsListInCart.shouldHave(size(listSize));
    }
}
