package secrets;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeparateCopy3 {

    private static final String EMAIL = "user3@example.com";
    private static final String PASSWORD = "Superbowl-recipe";

    @Test
    @DisplayName("Проверка имени автора и id")
    void separateTest1() {
        String token = login(EMAIL, PASSWORD);

        RestAssured.baseURI = "http://qa-games.ru:9000";
        String createPost = "{" +
                "    \"title\": \"112111324\"," +
                "    \"body\": \"ЛолКекЧебурек\"" +
                "}";
        JsonPath jsonValidator = RestAssured.given()
                                            .header("Content-Type", "application/json")
                                            .header("Cookie", "token=" + token)
                                            .body(createPost)
                                            .post("/posts").jsonPath();

        assertEquals("Гари", jsonValidator.get("author"), jsonValidator.prettyPrint());
        assertNotNull(jsonValidator.get("id"), jsonValidator.prettyPrint());
    }

    @Test
    @DisplayName("Проверка id")
    void separateTest2() {
        String token = login(EMAIL, PASSWORD);

        String createPost = "{\n" +
                "    \"title\": \"111111jh\"," +
                "    \"body\": \"ЛолКекЧеaaбурек\"" +
                "}";
        JsonPath jsonValidator = RestAssured.given()
                                            .header("Content-Type", "application/json")
                                            .header("Cookie", "token=" + token)
                                            .body(createPost)
                                            .post("/posts").jsonPath();


    }

    private String login(String email, String password) {
        RestAssured.baseURI = "http://qa-games.ru:9000";
        String authData = "{\n" +
                "\"email\": " + "\"" + email + "\"" + ",\n" +
                "\"password\": " + "\"" + password + "\"" + " \n" +
                "}";

        return RestAssured.given()
                          .header("Content-Type", "application/json")
                          .body(authData).post("/users/login").getCookie("token");
    }

}
