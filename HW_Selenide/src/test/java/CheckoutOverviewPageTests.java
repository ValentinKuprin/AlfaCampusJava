import org.junit.jupiter.api.Test;

public class CheckoutOverviewPageTests extends BaseTest {

    @Test
    void checkFinishCheckoutPossibility() {
        /*
         * Проверка что есть возможность нажать на кнопку FINISH
         * Проверить что после нажатия на кнопку заголовок на странице CheckoutCompletePage = THANK YOU FOR YOUR ORDER
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = authorizationPage.loginToSystem(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = headerBlock.goToCart();
        CheckoutInformationPage checkoutInformationPage = shoppingCartPage.goToCheckoutInformation();
        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage.addYourInformation(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.goToCompleteOrder();
        checkoutCompletePage.checkCompleteTitle();
    }
}
