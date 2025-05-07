package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import settings.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BackEndTest extends BaseTest {

    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static final String TOKEN = "6623524bc4385e5";


    @BeforeEach
    public void setBaseUrl() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void createToken() {
        String requestBody = "{\n" +
                "  \"username\" : \"admin\",\n" +
                "  \"password\" : \"password123\"\n" +
                "}";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/auth")
                .then()
                .statusCode(200) // Проверяем статус код
                .extract().response();

        String token = response.jsonPath().getString("token");
        System.out.println("Привет! Я токен авторизации. Положи меня в переменную, чтобы выполнить следующий запрос! " + token);
    }



    @Test
    public void createBookingCheck() {
        String requestBody = "{\n" +
                "  \"firstname\" : \"Jim\",\n" +
                "  \"lastname\" : \"Brown\",\n" +
                "  \"totalprice\" : 150,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2025-05-01\",\n" +
                "    \"checkout\" : \"2025-05-10\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .statusCode(200) // Проверяем статус код
                .body("booking.firstname", equalTo("Jim")) // Проверяем имя
                .body("booking.lastname", equalTo("Brown")) // Проверяем фамилию
                .body("booking.totalprice", equalTo(150)) // Проверяем общую цену
                .body("booking.depositpaid", equalTo(true)) // Проверяем, что депозит оплачен
                .extract().response();

        int bookingId = response.jsonPath().getInt("bookingid");
        System.out.println("Бронирование создано! ID записи: " + bookingId);
    }

    @Test
    public void updateBookingCheck() {
        String requestBody = "{\n" +
                "  \"firstname\" : \"James\",\n" +
                "  \"lastname\" : \"Brown\",\n" +
                "  \"totalprice\" : 150,\n" +
                "  \"depositpaid\" : false,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2025-05-01\",\n" +
                "    \"checkout\" : \"2025-05-10\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        Response response = given()
                .contentType(ContentType.JSON)
                .cookie("token", TOKEN)
                .pathParam("bookingId", 747)
                .body(requestBody)
                .when()
                .log().all()
                .put("/booking/{bookingId}")
                .then()
                .log().all()
                .statusCode(200) // Проверяем статус код
                .body("firstname", equalTo("James"))
                .body("lastname", equalTo("Brown"))
                .body("totalprice", equalTo(150))
                .body("depositpaid", equalTo(false))
                .extract().response();

        String newName = response.jsonPath().getString("firstname");
        System.out.println("Имя обновлено. Новое имя: " + newName);
    }

    @Test
    public void getBookingCheck() {
        // Отправляем GET-запрос для получения конкретного бронирования по ID
        given()
                .contentType(ContentType.JSON)
                .cookie("token", TOKEN)
                .pathParam("bookingId", 747)
                .when()
                .log().all()
                .get("/booking/{bookingId}")
                .then()
                .log().all()
                .statusCode(200) // Проверяем статус код
                .body("firstname", equalTo("James"))
                .body("lastname", equalTo("Brown"))
                .body("totalprice", equalTo(150))
                .body("depositpaid", equalTo(false));
    }



    @Test
    public void deleteBookingCheck() {
        Response response = given()
                .cookie("token", TOKEN)
                .pathParam("bookingId", 747)
                .when()
                .log().all()
                .delete("/booking/{bookingId}")
                .then()
                .log().all()
                .statusCode(201) // Проверяем статус код успешного удаления 201
                .extract().response();

        System.out.println("Бронирование удалено! Приходите к нам еще!");

        given()
                .cookie("token", TOKEN)
                .pathParam("bookingId", 747)
                .when()
                .log().all()
                .get("/booking/{bookingId}")
                .then()
                .log().all()
                .statusCode(404);

    }


}
