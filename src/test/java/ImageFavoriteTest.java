import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class ImageFavoriteTest extends BaseTest {
    String imageHash;
    String encodedFile;

    @BeforeEach
    void beforeTest() {
        byte[] byteArray = getFileContent();
        encodedFile = Base64.getEncoder().encodeToString(byteArray);
    }

    @DisplayName("Загрузка файла в формате Base64")
    @Test
    void uploadBase64ImageTest() {
        imageHash = given()
                .headers("Authorization", token)
                .multiPart("image", encodedFile)
                .expect()
                .body("success", is(true))
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.id");
    }

    @DisplayName("Добавление в избранное позитивная ")
    @Test
    void addToFavoriteImageTest() {
        given()
                .headers("Authorization", token)
                .when()
                .post("https://api.imgur.com/3/image/{imageHash}",imageHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }



    private byte[] getFileContent() {
        byte[] byteArray = new byte[0];
        try {
            byteArray = FileUtils.readFileToByteArray(new File("src/main/resources/1980x1320ru.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }


//    @AfterAll
//    public static void tearDown() {
//        given()
//                .headers("Authorization", token)
//                .when()
//                .delete("https://api.imgur.com/3/image/{DeleteHash}", favoriteImage)
//                .prettyPeek()
//                .then()
//                .statusCode(200);
//    }
}


