import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderBlock {
    private final SelenideElement productsCounter = $x("//span[@class='shopping_cart_badge']");
    private final SelenideElement cartButton = $x("//a[@class='shopping_cart_link']");
    private final SelenideElement menuButton = $x("//button[@id='react-burger-menu-btn']");
    private final SelenideElement logoutButton = $x("//a[@id='logout_sidebar_link']");
    private final SelenideElement resetAppState = $x("//a[@id='reset_sidebar_link']");

    public ShoppingCartPage goToCart() {
        cartButton.click();
        return new ShoppingCartPage();
    }

    public void openMenu() {
        menuButton.click();
    }

    public AuthorizationPage logoutFromSystem() {
        logoutButton.click();
        return new AuthorizationPage();
    }

    public void resetAllAppState() {
        resetAppState.click();
    }

    public void checkProductsCounterIsDisplayed() {
        productsCounter.shouldBe(visible).shouldHave(exactText("6"));
    }

    public void checkProductsCounterIsNotDisplayed() {
        productsCounter.shouldNotBe(visible);
    }
}
