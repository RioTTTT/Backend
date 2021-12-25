import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Data.Endpoints.FAVORITE;
import static io.restassured.RestAssured.given;


public class ImageFavoriteTest extends ImageBaseTest {

    @DisplayName("Добавление в избранное позитивная ")
    @Test
    void addToFavoriteImageTest() {
        given(requestSpecification, responseSpecification)
                .post(FAVORITE, imageHash);
    }
}