import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsPageTests extends BaseTest {

    @BeforeEach
    void login() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.loginToSystem(USERNAME, PASSWORD);
    }

    @Test
    void checkAddToCartAllProductsPossibility() {
        /*
         * Проверка что добавленные товары отображаются в счетчике корзины
         * Нужно добавить все товары в корзину и проверить что счетчик корзины = 6
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        headerBlock.checkProductsCounterIsDisplayed();
    }

    @Test
    void checkRemoveAllAddedProductsPossibility() {
        /*
         * Проверка что добавленные товары можно удалить на странице продуктов
         * Нужно удалить все товары на странице продуктов и проверить что счетчик корзины не отображается
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        productsPage.removeAllProductsFromCart();
        HeaderBlock headerBlock = new HeaderBlock();
        headerBlock.checkProductsCounterIsNotDisplayed();
    }
}
