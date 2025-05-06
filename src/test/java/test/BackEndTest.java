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
    private static final String TOKEN = "abc123";
    private int BOOKING_ID = 129; // как вытащить из ответа первого запроса?

    @BeforeEach
    public void setBaseUrl() {
        RestAssured.baseURI = BASE_URL;
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
                .header("Authorization", "Bearer " + TOKEN)
                .body(requestBody)
                .when()
                .put("/booking" + BOOKING_ID)
                .then()
                .statusCode(200) // Проверяем статус код
                .body("booking.firstname", equalTo("James"))
                .body("booking.lastname", equalTo("Brown"))
                .body("booking.totalprice", equalTo(150))
                .body("booking.depositpaid", equalTo(false))
                .extract().response();

        String newName = response.jsonPath().getString("firstname");
        System.out.println("Имя обновлено. Новое имя: " + newName);
    }

    @Test
    public void getBookingCheck() {
        int bookingId = 1;
        // Отправляем GET-запрос для получения конкретного бронирования по ID
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(200) // Проверяем статус код
                .body("booking.firstname", equalTo("James"))
                .body("booking.lastname", equalTo("Brown"))
                .body("booking.totalprice", equalTo(150))
                .body("booking.depositpaid", equalTo(false));
    }



    @Test
    public void deleteBookingCheck() {
        given()
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .get("/booking/" + BOOKING_ID)
                .then()
                .statusCode(200); // Проверяем, что бронирование существует

        // Отправляем DELETE-запрос для удаления бронирования
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .delete("/booking/" + BOOKING_ID)
                .then()
                .statusCode(201) // Проверяем статус код успешного удаления 201
                .extract().response();

        System.out.println("Удалено бронирование ID: " + BOOKING_ID);

        given()
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .get("/booking/" + BOOKING_ID)
                .then()
                .statusCode(404);

    }


}
