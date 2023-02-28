import app.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FirstSimpleTest extends BaseTest {

    private static final String CITY = "";

    MainPage mainPage = new MainPage();

    @Test
    void basicTest() {
        mainPage.loadPage(driver);
        mainPage.checkPreview();
        mainPage.searchingByText(CITY);
        mainPage.clickOnResult(CITY);
        assertTrue(mainPage.checkSaveButton(), "Кнопка Save не видна.");
    }
}