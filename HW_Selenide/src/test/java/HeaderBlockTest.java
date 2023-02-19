import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeaderBlockTest extends BaseTest {

    @BeforeEach
    void login() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.loginToSystem(USERNAME, PASSWORD);
    }

    @Test
    void checkSuccessLogout() {
        HeaderBlock headerBlock = new HeaderBlock();
        headerBlock.openMenu();
        headerBlock.logoutFromSystem();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.checkLoginButtonIsDisplayed();
    }

    @Test
    void checkResetAppState() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart();
        HeaderBlock headerBlock = new HeaderBlock();
        headerBlock.openMenu();
        headerBlock.resetAllAppState();
        headerBlock.checkRemoveAllProductsCounterIsNotDisplayed();
    }
}
