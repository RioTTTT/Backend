import org.junit.jupiter.api.AfterEach;

import static io.restassured.RestAssured.given;

public  class DeteleBaseTest extends ImageBaseTest {
    @AfterEach
    public void tearDown() {
        given()
                .when()
                .delete("/image/{imageHash}", deleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}