import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Data.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;


public class ImageUploadTests extends ImageBaseTest{
    protected static String encodedFile;
    protected static String uploadedImageId;

    @DisplayName("Загрузка файла в формате Base64")
    @Test
    void uploadBase64ImageTest() {
        given(uploadImageBase64,responseSpecification)
                .post(IMAGE);
    }

    @DisplayName("Загрузка файла в формате URL")
    @Test
    void uploadURLImageTest() {
        given(uploadImageUrl,responseSpecification)
                .post(IMAGE);
    }



}