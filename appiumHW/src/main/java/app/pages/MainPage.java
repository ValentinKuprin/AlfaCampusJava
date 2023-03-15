package app.pages;

import app.ContextType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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

    public boolean switchContextToWebView() throws InterruptedException {
        Thread.sleep(1500);
        Set<String> contextNames = driver.getContextHandles();
        for (String context : contextNames) {
            if (context.contains(ContextType.WEBVIEW.getValue())) {
                driver.context(context);
                return true;
            }
        }
        return false;
    }

    public boolean switchContextToNative() throws InterruptedException {
        Thread.sleep(1500);
        Set<String> contextNames = driver.getContextHandles();
        for (String context : contextNames) {
            if (context.contains(ContextType.NATIVE.getValue())) {
                driver.context(context);
                return true;
            }
        }
        return false;
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