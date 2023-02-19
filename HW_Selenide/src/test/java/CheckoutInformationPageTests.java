import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutInformationPageTests extends BaseTest {

    @BeforeEach
    void login() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.loginToSystem(USERNAME, PASSWORD);
    }

    @Test
    void checkCheckoutPossibility() {
        /*
         * Проверка что есть возможность заполнить форму и продолжить оформление заказа
         * Нужно заполнить поля формы и выполнить нажатие на кнопку continue
         * Проверить что на странице CheckoutOverviewPage размер списка товаров = 6 (в пререквизите добавьте все 6 товаров)
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = headerBlock.goToCart();
        CheckoutInformationPage checkoutInformationPage = shoppingCartPage.goToCheckoutInformation();
        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage.addYourInformation(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);
        checkoutOverviewPage.checkProductsListSizeInCheckoutOverview(6);
    }

    @Test
    void checkErrorDueToBlankFirstNameInForm() {
        /*
         * Проверка что при пустом поле FirstName отдается соответствующая ошибка
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = headerBlock.goToCart();
        CheckoutInformationPage checkoutInformationPage = shoppingCartPage.goToCheckoutInformation();
        checkoutInformationPage.addYourInformationWithoutFirstName(LAST_NAME, ZIP_POSTAL_CODE);
        checkoutInformationPage.checkErrorMessageDueToBlankFirstNameInForm();
    }

    @Test
    void checkErrorDueToBlankLastNameInForm() {
        /*
         * Проверка что при пустом поле LastName отдается соответствующая ошибка
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = headerBlock.goToCart();
        CheckoutInformationPage checkoutInformationPage = shoppingCartPage.goToCheckoutInformation();
        checkoutInformationPage.addYourInformationWithoutLastName(FIRST_NAME, ZIP_POSTAL_CODE);
        checkoutInformationPage.checkErrorMessageDueToBlankLastNameInForm();
    }

    @Test
    void checkErrorDueToBlankPostalCodeInForm() {
        /*
         * Проверка что при пустом поле PostalCode отдается соответствующая ошибка
         * */
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = headerBlock.goToCart();
        CheckoutInformationPage checkoutInformationPage = shoppingCartPage.goToCheckoutInformation();
        checkoutInformationPage.addYourInformationWithoutZipPostalCode(FIRST_NAME, LAST_NAME);
        checkoutInformationPage.checkErrorMessageDueToBlankZipPostalCodeInForm();
    }
}
