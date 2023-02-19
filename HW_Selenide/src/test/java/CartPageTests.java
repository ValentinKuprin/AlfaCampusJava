import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartPageTests extends BaseTest {

    @BeforeEach
    void login() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.loginToSystem(USERNAME, PASSWORD);
    }

    @Test
    void checkGoodsAddedIsPresentInCart() {
        /*
         * Проверка что добавленные товары отображаются в корзине
         * Нужно добавить все товары в корзину и проверить что на странице корзины размер списка товаров = 6
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = headerBlock.goToCart();
        shoppingCartPage.checkLProductsListSizeInCart(6);
    }

    @Test
    void checkDeleteGoodsFromCartPossibility() {
        /*
         * Проверка что есть возможность удалить добавленные товары из корзины
         * Удалить добавленные товары (пререквизит к тесту - товары должны быть добавлены в корзину) и проверить что счетчик в блоке
         * HeaderBlock не отображается
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = headerBlock.goToCart();
        shoppingCartPage.removeAllProductsInCart();
        headerBlock.checkRemoveAllProductsCounterIsNotDisplayed();
    }
}
