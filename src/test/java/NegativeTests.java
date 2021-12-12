import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class NegativeTests extends BaseTest {

    static ValidatableResponse uploadedImageId;
    ValidatableResponse uploadedImage;
    String imageDeleteHash = "failed";
    String updateImageTest = "somePath";


    @DisplayName("Загрузка файла негативная проверка")
    @Test
    void uploadImageTestNegative() {
        uploadedImage = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/main/resources/test.txt"))
                .expect()
                .body("success", is(false))
                .when()
                .post("https://api.imgur.com/3/image")
                .then()
                .statusCode(400);

    }

    @DisplayName("Проверка загруженного файла")
    @Test
    void chekUploadImageTestNegative() {
        given()
                .headers("Authorization", token)
                .expect()
                .body("success", is(false))
                .when()
                .get("https://api.imgur.com/3/upload/{updateImageTest}", updateImageTest)
                .then()
                .statusCode(400);
    }

    @DisplayName("Добавление в избранное негативная ")
    @Test
    void addToFavoriteImageTestNegative() {
        given()
                .headers("Authorization", token)
                .when()
                .post("https://api.imgur.com/3/uploaded")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
    
    @DisplayName("Удаление файла негативная проверка")
    @Test
    void deleteImageTestNegative() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{deleteHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

}
