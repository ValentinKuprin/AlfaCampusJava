import app.pages.ArticlePage;
import app.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticlePageTest extends BaseTest {

    private static final String CITY = "Solnechnogorsk";

    MainPage mainPage = new MainPage();

    @Test
    void basicTest() {
        mainPage.loadPage(driver);
        mainPage.checkPreview();
        mainPage.searchingByText(CITY);
        mainPage.clickOnResult(CITY);
        assertTrue(mainPage.checkSaveButton(), "Кнопка Save не видна.");
    }

    @Test
    void displayAllWordsWithLink() throws InterruptedException {
        mainPage.loadPage(driver);
        mainPage.checkPreview();
        mainPage.searchingByText(CITY);
        mainPage.clickOnResult(CITY);
        mainPage.switchContextToWebView();
        ArticlePage articlePage = new ArticlePage();
        articlePage.loadPage(driver);
        articlePage.clickSectionHeaderButtons();
        articlePage.getDescribeLinks();
        mainPage.switchContextToNative();
    }
}