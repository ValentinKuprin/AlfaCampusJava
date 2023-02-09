package secrets;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Random;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BeforAfter5 {


    private static final String EMAIL = "user3@example.com";
    private static final String PASSWORD = "Superbowl-recipe";

    private String token;

    ArrayList<String> idList = new ArrayList<>();

    @BeforeAll
    public void beforAll() {
        System.out.println("Я before all. Исполняюсь один раз ПЕРЕД ВСЕХ тестов");
        token = login(EMAIL, PASSWORD);
    }

    @AfterAll
    public void afterAll() {
        deletePostById(idList, token);
        System.out.println("Я after all. Исполняюсь один раз ПОСЛЕ ВСЕХ тестов");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Я before each. Исполняюсь ПЕРЕД КАЖДЫМ тестом");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Я after each. Исполняюсь ПОСЛЕ КАЖДОГО теста");
    }


    @Test
    @DisplayName("Проверка имени автора")
    void separateTest1() {
        String createPost = "{" +
                "    \"title\": " + "\"" + generateRandomString() + "\"" + "," +
                "    \"body\": " + "\"" + generateRandomString() + "\"" + "" +
                "}";
        JsonPath jsonValidator = RestAssured.given()
                                            .header("Content-Type", "application/json")
                                            .header("Cookie", "token=" + token)
                                            .body(createPost)
                                            .post("/posts").then().statusCode(HTTP_OK).extract().jsonPath();

        assertEquals("Гари", jsonValidator.get("author"), "Автор не Гари");
        idList.add(jsonValidator.get("id"));
        System.out.println("Я тест 1");
    }

    @Test
    @DisplayName("Проверка id")
    void separateTest2() {
        String createPost = "{" +
                "    \"title\": " + "\"" + generateRandomString() + "\"" + "," +
                "    \"body\": " + "\"" + generateRandomString() + "\"" + "" +
                "}";
        JsonPath jsonValidator = RestAssured.given()
                                            .header("Content-Type", "application/json")
                                            .header("Cookie", "token=" + token)
                                            .body(createPost)
                                            .post("/posts").then().statusCode(HTTP_OK).extract().jsonPath();

        assertNotNull(jsonValidator.get("id"));

        idList.add(jsonValidator.get("id"));
        System.out.println("Я тест 2");
    }


    private String login(String email, String password) {
        RestAssured.baseURI = "http://qa-games.ru:9000";
        String authData = "{" +
                "\"email\": " + "\"" + email + "\"" + "," +
                "\"password\": " + "\"" + password + "\"" + " " +
                "}";

        return RestAssured.given()
                          .header("Content-Type", "application/json")
                          .body(authData).post("/users/login").getCookie("token");
    }

    private String generateRandomString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
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


    private void deletePostById(ArrayList<String> idList, String token) {
        for (int i = 0; i < idList.size(); i++) {
            RequestSpecification httpRequestDelete = RestAssured.given();
            httpRequestDelete.header("Content-Type", "application/json");
            httpRequestDelete.header("Cookie", "token=" + token);

            httpRequestDelete.delete("/posts/" + idList.get(i)).then().statusCode(200);
        }
    }

}
