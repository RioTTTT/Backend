import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.Base64;

import static Data.Endpoints.UPLOAD;
import static io.restassured.RestAssured.given;

public class ImageBaseTest extends BaseTest{
    protected byte[] byteArray;
    protected static String encodedFile;
    protected static RequestSpecification uploadImageBase64;
    protected MultiPartSpecification headerEncodedImage;
    protected static RequestSpecification uploadImageUrl;
    protected Response responseUploadInfo;
    protected String imageHash;
    protected String deleteHash;



    @BeforeEach
    void beforeTest() {
        byteArray = getFileContent();
        encodedFile = Base64.getEncoder().encodeToString(byteArray);

        headerEncodedImage = new MultiPartSpecBuilder(encodedFile)
                .controlName("image")
                .build();

        uploadImageBase64 = new RequestSpecBuilder()
                .addHeader("Authorization", clientId)
                .addMultiPart(headerEncodedImage)
                .build();

        uploadImageUrl = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .addMultiPart("image", URL)
                .build();

        responseUploadInfo = given()
                .header("Authorization", token)
                .multiPart("image", new File(PATH_TO_IMAGE))
                .when()
                .post(UPLOAD)
                .prettyPeek()
                .then()
                .extract()
                .response();

        imageHash  = responseUploadInfo.jsonPath().getString("data.id");
        deleteHash = responseUploadInfo.jsonPath().getString("data.deletehash");

    }
}
