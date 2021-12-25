import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Data.Endpoints.DELETE;
import static io.restassured.RestAssured.given;


public class ImageDeleteTest extends ImageBaseTest {

    @DisplayName("Удаление файла позитивная проверка")
    @Test
    void deleteImageTestPositive() {
        given(requestSpecification,responseSpecification)
                .delete(DELETE, deleteHash);
    }


}