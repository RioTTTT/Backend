import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class ImageDeleteTest extends BaseTest {
    private final String PATH_TO_IMAGE = "src/main/resources/1980x1320ru.jpg";
String imageDeleteHash;
@BeforeEach
    @DisplayName("Загрузка файла")
    @Test
    void uploadUrlImageTest() {
        imageDeleteHash = given()
                .headers("Authorization", token)
                .multiPart("image", new File(PATH_TO_IMAGE))
                .expect()
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");

    }
    @DisplayName("Удаление файла позитивная проверка")
    @Test
    void deleteImageTestPositive() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{deleteHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }


}
