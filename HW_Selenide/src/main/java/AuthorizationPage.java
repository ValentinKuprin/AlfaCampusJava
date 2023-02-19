import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    private final SelenideElement userNameInput = $x("//input[@id='user-name']");
    private final SelenideElement passwordInput = $x("//input[@id='password']");
    private final SelenideElement loginButton = $x("//input[@id='login-button']");
    private final SelenideElement errorMessage = $x("//h3[@data-test='error']");

    private AuthorizationPage setUsername(String username) {
        this.userNameInput.setValue(username);
        return this;
    }

    private AuthorizationPage setPassword(String password) {
        this.passwordInput.setValue(password);
        return this;
    }

    private void clickLoginButton() {
        this.loginButton.click();
    }

    public ProductsPage loginToSystem(String userName, String password) {
        this.setUsername(userName)
                .setPassword(password)
                .clickLoginButton();
        return new ProductsPage();
    }

    public void checkErrorMessageFailedLogin() {
        errorMessage.shouldBe(visible).shouldHave(exactText("Epic sadface: Sorry, this user has been locked out."));
    }

    public void checkLoginButtonIsDisplayed() {
        loginButton.shouldBe(visible);
    }
}
