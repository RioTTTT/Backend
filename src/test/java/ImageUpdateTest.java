import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Data.Endpoints.UPDATE;
import static io.restassured.RestAssured.given;

public class ImageUpdateTest extends ImageBaseTest {

    @DisplayName("Обновление заголовка и описания файла")
    @Test
    void updateImageTestPositive() {
        given(requestSpecification,responseSpecification)
                .post(UPDATE, imageHash);
// так и не понял куда передавать параметр который хотим обновить.

    }
}
