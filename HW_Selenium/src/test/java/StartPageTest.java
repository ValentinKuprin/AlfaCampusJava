import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class StartPageTest extends BaseTest {
    private static final String EMAIL = "user3@example.com";
    private static final String PASSWORD = "Superbowl-recipe";
    private static final String TITLE = "Создаю новый пост " + generateRandomString();
    private static final String BODY = "Текст поста " + generateRandomString();
    private static final String EDIT_TITLE = "Меняю заголовок поста " + generateRandomString();

    @Test
    public void openBaseUrlTest() {
        String h1Header = driver.findElement(By.tagName("h1")).getText();

        assertEquals("Кампус", h1Header);
    }

    @Test
    public void inputTextFieldTest() {
        String expectedResult = "Рагнар";

        WebElement firstNameField = driver.findElement(By.xpath("//input[@name= 'firstName']"));
        firstNameField.sendKeys(expectedResult);

        assertEquals(expectedResult, firstNameField.getAttribute("value"));
    }

    @Test
    public void loginEmptyEmailEmptyPasswordNotificationTest() {
        WebElement authorizationButton = driver.findElement(By.xpath("//span[text()= 'Авторизация']"));
        authorizationButton.click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));

        assertEquals("alert", alert.getAttribute("role"));
    }

    @Test
    public void loginTest() {
        login();

        WebElement buttonAddNewPost = driver.findElement(
                By.xpath("//span[text() = 'Добавить новый пост']"));

        assertTrue(buttonAddNewPost.isDisplayed());
    }

    @Test
    public void createPostTest() throws InterruptedException {
        createPost();

        List<WebElement> titlePosts = driver.findElements(
                By.xpath("//div[contains(@class, 'post_postContent')]//div[text()]"));

        List<String> titleList = new ArrayList<>();
        titlePosts.forEach(title -> titleList.add(title.getText()));
        titleList.forEach(System.out::println);

        assertTrue(titleList.contains(TITLE));

        deletePost(TITLE);
    }

    @Test
    public void deleteYourPostTest() throws InterruptedException {
        createPost();
        deletePost(TITLE);

        List<WebElement> titlePosts = driver.findElements(
                By.xpath("//div[contains(@class, 'post_postContent')]//div[text()]"));

        List<String> titleList = new ArrayList<>();
        titlePosts.forEach(title -> titleList.add(title.getText()));

        assertFalse(titleList.contains(TITLE));
    }

    @Test
    public void editTitleYourPostTest() throws InterruptedException {
        createPost();

        String oldBodyPost = driver.findElement(
                By.xpath("//div[text() = '" + TITLE + "']/..//span[text() = '" + BODY + "']")).getText();

        editTitleYourPost();

        List<WebElement> titlePosts = driver.findElements(
                By.xpath("//div[contains(@class, 'post_postContent')]//div[text()]"));
        List<String> titleList = new ArrayList<>();
        titlePosts.forEach(title -> titleList.add(title.getText()));
        String bodyPostAfterEdit = driver.findElement(
                By.xpath("//div[text() = '" + EDIT_TITLE + "']/..//span[text() = '" + BODY + "']")).getText();

        assertAll(
                () -> assertTrue(titleList.contains(EDIT_TITLE)),
                () -> assertEquals(oldBodyPost, bodyPostAfterEdit)
        );

        deletePost(EDIT_TITLE);
    }

    @Test
    public void cancelPostDeletionTest() throws InterruptedException {
        createPost();

        WebElement deleteButton = driver.findElement(By.xpath(
                "//div[text() = '" + TITLE + "']/../div//span[text() = 'Удалить']"));
        deleteButton.click();
        Thread.sleep(500);
        WebElement cancelButton = driver.findElement(By.xpath("//span[text() = 'Отмена']"));
        cancelButton.click();
        driver.navigate().refresh();

        List<WebElement> titlePosts = driver.findElements(
                By.xpath("//div[contains(@class, 'post_postContent')]//div[text()]"));
        List<String> titleList = new ArrayList<>();
        titlePosts.forEach(title -> titleList.add(title.getText()));

        assertTrue(titleList.contains(TITLE));
    }

    @Test
    public void createPostEmptyTitleFilledBodyNotificationTest() throws InterruptedException {
        login();
        WebElement buttonAddNewPost = driver.findElement(By.xpath("//span[text() = 'Добавить новый пост']"));
        buttonAddNewPost.click();
        Thread.sleep(500);
        WebElement inputPostBody = driver.findElement(By.xpath("//div[@class = 'scrollbar__offset_b0coh']//textarea"));
        inputPostBody.sendKeys(BODY);
        WebElement buttonCreatePost = driver.findElement(By.xpath("//span[text() = 'Создать']/.."));
        buttonCreatePost.click();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));

        assertEquals("alert", alert.getAttribute("role"));
    }

    @Test
    public void createPostFilledTitleEmptyBodyNotificationTest() throws InterruptedException {
        login();
        WebElement buttonAddNewPost = driver.findElement(By.xpath("//span[text() = 'Добавить новый пост']"));
        buttonAddNewPost.click();
        Thread.sleep(500);
        WebElement inputPostName = driver.findElement(By.xpath("//input[@aria-label = 'Название поста']"));
        inputPostName.sendKeys(TITLE);
        WebElement buttonCreatePost = driver.findElement(By.xpath("//span[text() = 'Создать']/.."));
        buttonCreatePost.click();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));

        assertEquals("alert", alert.getAttribute("role"));
    }

    @Test
    public void createPostEmptyTitleEmptyBodyNotificationTest() throws InterruptedException {
        login();
        WebElement buttonAddNewPost = driver.findElement(By.xpath("//span[text() = 'Добавить новый пост']"));
        buttonAddNewPost.click();
        Thread.sleep(500);
        WebElement buttonCreatePost = driver.findElement(By.xpath("//span[text() = 'Создать']/.."));
        buttonCreatePost.click();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));

        assertEquals("alert", alert.getAttribute("role"));
    }

    @Test
    public void loginInvalidEmailValidPasswordNotificationTest() {
        WebElement authorizationButton = driver.findElement(By.xpath("//span[text()= 'Авторизация']"));
        authorizationButton.click();
        WebElement inputEmail = driver.findElement(By.xpath("//input[@aria-label = 'Email']"));
        inputEmail.sendKeys("user3@exemple.com");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@aria-label = 'Пароль']"));
        inputPassword.sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));

        assertEquals("alert", alert.getAttribute("role"));
    }

    @Test
    public void loginValidEmailInvalidPasswordNotificationTest() {
        WebElement authorizationButton = driver.findElement(By.xpath("//span[text()= 'Авторизация']"));
        authorizationButton.click();
        WebElement inputEmail = driver.findElement(By.xpath("//input[@aria-label = 'Email']"));
        inputEmail.sendKeys(EMAIL);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@aria-label = 'Пароль']"));
        inputPassword.sendKeys("Superbowl-rec");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));

        assertEquals("alert", alert.getAttribute("role"));
    }

    private void login() {
        WebElement authorizationButton = driver.findElement(By.xpath("//span[text()= 'Авторизация']"));
        authorizationButton.click();
        WebElement inputEmail = driver.findElement(By.xpath("//input[@aria-label = 'Email']"));
        inputEmail.sendKeys(EMAIL);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@aria-label = 'Пароль']"));
        inputPassword.sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();
    }

    private static String generateRandomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private void createPost() throws InterruptedException {
        login();
        WebElement buttonAddNewPost = driver.findElement(By.xpath("//span[text() = 'Добавить новый пост']"));
        buttonAddNewPost.click();
        Thread.sleep(500);
        WebElement inputPostName = driver.findElement(By.xpath("//input[@aria-label = 'Название поста']"));
        inputPostName.sendKeys(TITLE);
        WebElement inputPostBody = driver.findElement(By.xpath("//div[@class = 'scrollbar__offset_b0coh']//textarea"));
        inputPostBody.sendKeys(BODY);
        WebElement buttonCreatePost = driver.findElement(By.xpath("//span[text() = 'Создать']/.."));
        buttonCreatePost.click();
        driver.navigate().refresh();
    }

    private void deletePost(String name) {
        WebElement deleteButtonListPosts = driver.findElement(By.xpath(
                "//div[text() = '" + name + "']/../div//span[text() = 'Удалить']"));
        deleteButtonListPosts.click();
        WebElement deleteButtonConfirm = driver.findElement(By.xpath(
                "//div[text() = 'Удаление поста']/../..//button/span[text() = 'Удалить']"));
        deleteButtonConfirm.click();
        driver.navigate().refresh();
    }

    private void editTitleYourPost() {
        WebElement editButton = driver.findElement(By.xpath(
                "//div[text() = '" + TITLE + "']/following-sibling::div/button/span[text() = 'Редактировать']"));
        editButton.click();
        WebElement inputTitle = driver.findElement(By.xpath("//input[@aria-label = 'Название поста']"));
        inputTitle.sendKeys(Keys.CONTROL + "A");
        inputTitle.sendKeys(Keys.BACK_SPACE);
        inputTitle.sendKeys(EDIT_TITLE);
        WebElement saveButton = driver.findElement(By.xpath("//span[text() = 'Сохранить']/.."));
        saveButton.click();
        driver.navigate().refresh();
    }
}
