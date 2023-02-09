package secrets;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.Objects;


public class FakeTest1 {


    public static void main(String[] args) {
        justTest();
    }

    public static void justTest() {
        String token = login();

        String createPost = "{" +
                "    \"title\": \"888777666555444123\"," +
                "    \"body\": \"ЛолКекЧебурек\"" +
                "}";

        JsonPath jsonValidator = RestAssured.given()
                                            .header("Content-Type", "application/json")
                                            .header("Cookie", "token=" + token)
                                            .body(createPost)
                                            .post("/posts").jsonPath();

        if (Objects.equals(jsonValidator.get("author"), "Гари")) {
            System.out.println("SUCCEESS!");

        } else {
            System.out.println("FAILED " + "Автор не Гари!");
        }
    }

    private static String login() {
        RestAssured.baseURI = "http://qa-games.ru:9000";
        String authData = "{" +
                "\"email\": \"user3@example.com\"," +
                "\"password\": \"Superbowl-recipe\" " +
                "}";

        return RestAssured.given().header("Content-Type", "application/json")
                          .body(authData).post("/users/login").getCookie("token");
    }
}