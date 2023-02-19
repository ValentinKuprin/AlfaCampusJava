import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class BaseTest {
    protected static final String USERNAME = "standard_user";
    protected static final String LOCKED_OUT_USER = "locked_out_user";
    protected static final String PASSWORD = "secret_sauce";
    protected static final String FIRST_NAME = "Сан-Мартин";
    protected static final String LAST_NAME = "Zakharov";
    protected static final String ZIP_POSTAL_CODE = "124578";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browser = CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
    }

    @BeforeEach
    void beforeTest() {
        if (hasWebDriverStarted()) {
            getWebDriver().manage().deleteAllCookies();
        }
        open("");
    }

    @AfterEach
    void afterTest() {
        getWebDriver().manage().deleteAllCookies();
    }
}
