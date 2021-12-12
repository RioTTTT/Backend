import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ImageUpdateTest extends BaseTest{
    private final String PATH_TO_IMAGE = "http://s2.fotokto.ru/photo/full/226/2262378.jpg";
    String updateImageTest;
    String uploadedImageId;

    @DisplayName("Загрузка файла в формате JPG")
    @Test
    void uploadFileImageTest() {
        uploadedImageId = given()
                .headers("Authorization", token)
                .multiPart("image", PATH_TO_IMAGE)
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

    @DisplayName("Обвновление заголовка и описания файла")
    @Test
    void updateImageTestPositive() {
        given()
                .headers("Authorization", token)
                .multiPart("title", "Unbelievable Space")
                .expect()
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image/{imageDeleteHash}", uploadedImageId)
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response();

    }


//    @AfterEach
//     void tearDown() {
//        given()
//                .headers("Authorization", token)
//                .when()
//                .delete("https://api.imgur.com/3/account/{username}/image/{deleteHash}", uploadedImageId)
//                .prettyPeek()
//                .then()
//                .statusCode(200);
//    }
}
