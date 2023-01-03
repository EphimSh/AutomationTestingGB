package SpoonacularAPITest;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

public class HomeWorkTest extends AbstractTest {

    //GET

    @Test
    void getRequestRiceTest() {
        given()
                .log().method()
                .when()
                .request(Method.GET, getBaseUrl() + "recipes/complexSearch?"
                        + "query={ingredient}"
                        + "&diet={diet}"
                        + "&apiKey={apiKey}", "rice", "vegetarian", getApiKey())
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void getVegetarianFoodTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query=", "rice")
                .queryParam("&diet", "vegetarian")
                .contentType(ContentType.JSON)
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(2000L))
                .expect()
                .body("results[0].title", containsString("Rice"))
                .log().body()
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch");
    }

    @Test
    void getPotatoSoyFreeFood() {
        given()
                .queryParam("apiKey", getApiKey())
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(2000L))
                .expect()
                .body("vegetarian", is(true))
                .body("veryHealthy", is(true))
                .log().body()
                .when()
                .get(getBaseUrl() + "recipes/715594/information");
    }

    @Test
    void getSomeSmoothie() {
        given()
                .queryParam("apiKey", getApiKey())
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(2000L))
                .expect()
                .body("vegan", is(false))
                .body("vegetarian", is(true))
                .body("healthScore", greaterThan(60))
                .log().body()
                .when()
                .get("https://api.spoonacular.com/recipes/715497/information");

    }

    @Test
    void getSomeRedBeanFood() {
        given()
                .queryParam("apiKey", getApiKey())
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(2000L))
                .expect()
                .body("vegetarian", is(true))
                .body("vegan", is(true))
                .body("healthScore", greaterThan(80))
                .log().body()
                .when()
                .get("https://api.spoonacular.com/recipes/782601/information");

    }


    //POST
    @Test
    void postSomeMeal() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("title", "Brown Rice For Dessert")
                .queryParam("ingredientList", "100 Bananas")
                .response()
                .contentType("application/json")
                .log().body()
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postSomeMeal2() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Brown Rice For Dessert")
                .formParam("ingredientList", "Bananas")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    void postSomeMeal3() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Lentil Rice Soup")
                .formParam("ingredientList", "Bananas")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    void postSomeMeal4() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Baked Rice Pudding")
                .formParam("ingredientList", "Bananas")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    void postSomeMeal5() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Fiesta Rice Salad with Honey Lime Dressing")
                .formParam("ingredientList", "Bananas")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .log().all()
                .statusCode(200);
    }


}
