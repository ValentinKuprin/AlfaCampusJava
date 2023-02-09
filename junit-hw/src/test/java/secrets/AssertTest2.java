package secrets;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class  AssertTest2 {

    @Test
    void firstTest() {
        String token = login();
        String createPost = "{" +
                "    \"title\": \"9988717877\"," +
                "    \"body\": \"ЛолКекЧебурек\"" +
                "}";
        JsonPath jsonValidator = RestAssured.given()
                                            .header("Content-Type", "application/json")
                                            .header("Cookie", "token=" + token)
                                            .body(createPost)
                                            .post("/posts").jsonPath();

        assertEquals("Гари", jsonValidator.get("author"), jsonValidator.prettyPrint());
    }

    private static String login() {
        RestAssured.baseURI = "http://qa-games.ru:9000";
        String authData = "{" +
                "\"email\": \"user3@example.com\"," +
                "\"password\": \"Superbowl-recipe\" " +
                "}";

        return RestAssured.given()
                          .header("Content-Type", "application/json")
                          .body(authData).post("/users/login").getCookie("token");
    }
}

















/*
*
* Показывать логин, коллекцию с постмана и что там происходит. Показать куки из ответа, показать как это попадает в хедер следующих запросов
* Расказать больше про рестАшуред
* Когда буду показывать перегрузку ассертов, показать через структуру в самой идее
* Когда запускаю 2 раздельных теста, сделать посильнее акцент на том, что в assertAll суть проверок не поменялась
* ОБЯЗАТЕЛЬНО покаказать, как в ассертАлл 1 проверка падает, другая проходит
* Ещё раз объяснить, что такое лямбда выражения
* На 4 этапе прказать, что тело запроса на создание поста фун-о одинаковы, меняется ток заголовок для поста
* Подготовить заготовки для каждого класса. Доставать их для демонстрации того, что у нас эволюционирует
* Нестед - разделить 2 теста на создание у даление, НАПРИМЕР
* Вынести треугольник в main
* Разделить всё по ООП и метод на площадь
* */