package app.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPage extends Page {


    @AndroidFindBy(id = "org.wikipedia:id/search_container")
    private MobileElement searchField;

    @AndroidFindBy(id = "org.wikipedia:id/view_onboarding_page_indicator")
    private MobileElement onboardingScreen;

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private MobileElement inputText;

    @AndroidFindBy(id = "org.wikipedia:id/page_list_item_title")
    private List<MobileElement> searchingResults;

    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_skip_button")
    private MobileElement skipButton;

    @AndroidFindBy(id = "org.wikipedia:id/article_menu_bookmark")
    private MobileElement saveButton;


    public void swtichContext() {
        Set<String> contextNames = driver.getContextHandles();
        driver.context((String) contextNames.toArray()[1]);
    }


    public void searchingByText(String text) {
        searchField.click();
        inputText.setValue(text);
    }

    public void checkPreview() {
        try {
            onboardingScreen.isDisplayed();
            skipButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickOnResult(String value) {
        searchingResults.stream()
                        .filter(t -> t.getText().equals(value))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException(
                                String.format("Результата с именем '%s' не найдено на странице", value))).click();
    }

    public boolean checkSaveButton() {
        return saveButton.isDisplayed();
    }
}