import org.junit.jupiter.api.Test;

public class AuthorizationTests extends BaseTest{

    @Test
    void checkSuccessLogin() {
        /*
        * Проверка успешной авторизации
        * После авторизации под пользователем standard_user проверить что на странице ProductPage размер списка товаров = 6
        * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = authorizationPage.loginToSystem(USERNAME, PASSWORD);
        productsPage.checkProductsListSize(6);
    }

    @Test
    void checkFailedLogin() {
        /*
         * Проверка неуспешной авторизации
         * Здесь два пути:
         * 1. Ввести несуществующие данные и попробовать авторизоваться
         * 2. Взять заблокированного пользователя и попробовать авторизоваться
         * В любом случае проверка заключается в том что в нотификации о неуспешной авторизации выводится соответствующий текст
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.loginToSystem(LOCKED_OUT_USER, PASSWORD);
        authorizationPage.checkErrorMessageFailedLogin();
    }
}
