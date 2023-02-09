package secrets;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssertAll4 {

    private static final String EMAIL = "user3@example.com";
    private static final String PASSWORD = "Superbowl-recipe";

    @Test
    @DisplayName("Проверка имени автора и id")
    void allFieldsTestPassed() {
        String token = login(EMAIL, PASSWORD);

        String createPost = "{" +
                "    \"title\": \"1815551\"," +
                "    \"body\": \"ЛолКекЧебурек\"" +
                "}";
        JsonPath jsonValidator = RestAssured.given()
                                            .header("Content-Type", "application/json")
                                            .header("Cookie", "token=" + token)
                                            .body(createPost)
                                            .post("/posts").then().statusCode(HTTP_OK).extract().jsonPath();
        assertAll(
                () -> assertEquals("Гари", jsonValidator.get("author"), jsonValidator.prettyPrint()),
                () -> assertNotNull(jsonValidator.get("id"))
        );

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

}
