import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {
    private final ElementsCollection productsListInCheckoutOverview = $$x("//div[@class='inventory_item_name']");
    private final SelenideElement finishButton = $x("//button[@id='finish']");

    public CheckoutCompletePage goToCompleteOrder() {
        finishButton.click();
        return new CheckoutCompletePage();
    }

    public void checkProductsListSizeInCheckoutOverview(int listSize) {
        productsListInCheckoutOverview.shouldHave(size(listSize));
    }
}
