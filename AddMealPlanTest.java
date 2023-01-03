package SpoonacularAPITest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddMealPlanTest extends AbstractTest {

    @Test
    void addMealSomething() {
        given()
                .queryParam("apiKey", getApiKey())
                .log().body()
                .body("{\n"
                        + " \"day\": 1,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"RECIPE\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "},\n"
                        + "{\n"
                        + " \"day\": 2,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"RECIPE\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "},\n")

                .post(getBaseUrl() + "mealplanner/ephimizm/templates");

    }
}
