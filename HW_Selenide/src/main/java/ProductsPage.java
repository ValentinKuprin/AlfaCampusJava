import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;

public class ProductsPage {
    private final ElementsCollection productsList = $$x("//div[@class='inventory_item_name']");
    private final ElementsCollection addToCartButtonsList = $$x("//button[contains(@id, 'add-to-cart')]");
    private final ElementsCollection removeButtonsList = $$x("//button[contains(@id,'remove')]");


    public void addAllProductsToCart() {
        for (SelenideElement addToCartButton : addToCartButtonsList) {
            addToCartButton.click();
        }
    }

    public void removeAllProductsFromCart() {
        for (SelenideElement removeButton : removeButtonsList) {
            removeButton.click();
        }
    }

    public void checkProductsListSize(int listSize) {
        productsList.shouldHave(size(listSize));
    }
}
