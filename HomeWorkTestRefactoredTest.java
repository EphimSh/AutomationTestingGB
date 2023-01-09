package SpoonacularAPIExtraRestAssuredTest;

import SpoonacularAPI.AddMealRequest;
import SpoonacularAPI.Response;


import org.hamcrest.comparator.ComparatorMatcherBuilder;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;


public class HomeWorkTestRefactoredTest extends AbstractTest {


    @Test
    void getRiceTest() {
        Response response = given().spec(requestSpecification)
                .queryParam("query", "rice")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch").prettyPeek()
                .then()
                .extract().response().body()
                .as(Response.class);
        for (int i = 0; i < response.getResults().size(); i++) {
            assertThat(response.getResults().get(i).getTitle(), containsString("Rice"));
        }

    }

    @Test
    void getVegetarianMealListTest() {
        Response response = given().spec(requestSpecification)
                .queryParam("diet", "vegetarian")
                .queryParam("addRecipeInformation", "true")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch").prettyPeek()
                .then()
                .extract().response().body()
                .as(Response.class);
        assertThat(response.getResults().iterator().next().getVegetarian(), is(true));
    }

    //    766453
    @Test
    void getHummusZaatarRecipe() {
        Response response = given().spec(requestSpecification)
                .when()
                .get(getBaseUrl() + "recipes/766453/information").prettyPeek()
                .then()
                .extract().response().body()
                .as(Response.class);
        assertThat(response.getTitle(), containsString("Hummus and Za'atar"));
        assertThat(response.getVegetarian(), is(true));
        assertThat(response.getCuisines().iterator().next(), containsString("Middle Eastern"));
    }

    @Test
    void getHummusZaatarRecipeIsReadyInFortyFiveMinutes() {
        Response response = given().spec(requestSpecification)
                .when()
                .get(getBaseUrl() + "recipes/766453/information").prettyPeek()
                .then()
                .extract().response().body()
                .as(Response.class);
        assertThat(response.getTitle(), containsString("Hummus and Za'atar"));
        assertThat(response.getVegetarian(), is(true));
        assertThat(response.getCuisines().iterator().next(), containsString("Middle Eastern"));
        assertThat(response.getReadyInMinutes(), equalTo(45));
    }

    @Test
    void getHummusZaatarRecipeIsGlutenFree() {
        Response response = given().spec(requestSpecification)
                .when()
                .get(getBaseUrl() + "recipes/766453/information").prettyPeek()
                .then()
                .extract().response().body()
                .as(Response.class);
        assertThat(response.getTitle(), containsString("Hummus and Za'atar"));
        assertThat(response.getVegetarian(), is(true));
        assertThat(response.getGlutenFree(), is(true));
        assertThat(response.getReadyInMinutes(), equalTo(45));
    }

    @Test
    void getHummusZaatarRecipeIsDairyFree() {
        Response response = given().spec(requestSpecification)
                .when()
                .get(getBaseUrl() + "recipes/766453/information").prettyPeek()
                .then()
                .extract().response().body()
                .as(Response.class);
        assertThat(response.getTitle(), containsString("Hummus and Za'atar"));
        assertThat(response.getVegetarian(), is(true));
        assertThat(response.getDairyFree(), is(true));
        assertThat(response.getReadyInMinutes(), equalTo(45));
    }


    @Test
    void postSpecifyCuisineHummusZaatar() {
        Response response = given().spec(requestSpecification)
                .formParam("title", "Hummus and Za'atar")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .log().body()
                .extract().response().body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("Middle Eastern"));
        assertThat(response.getConfidence(), ComparatorMatcherBuilder.<Double>usingNaturalOrdering().greaterThan(0.70));

    }

    @Test
    void postSpecifyCuisineRedKidneyBeanJambalaya() {
        Response response = given().spec(requestSpecification)
                .formParam("title", "Red Kidney Bean Jambalaya")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .log().body()
                .extract().response().body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("Creole"));
        assertThat(response.getConfidence(), ComparatorMatcherBuilder.<Double>usingNaturalOrdering().greaterThan(0.70));
    }

    private String body = "{\n" +
            "    \"date\": 1589500800,\n" +
            "    \"slot\": 1,\n" +
            "    \"position\": 0,\n" +
            "    \"type\": \"INGREDIENTS\",\n" +
            "    \"value\": {\n" +
            "        \"ingredients\": [\n" +
            "            {\n" +
            "                \"name\": \"10000 banana\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    @Test
    void test() {
        AddMealRequest request = given().spec(requestSpecification)
                .queryParam("hash", "f8b34e738885f31a7505b1453c7d39bd24b5b9a2")
                .body(body)
                .when()
                .post(getBaseUrl() + "mealplanner/ephimizm/templates")
                .then()
                .log().body()
                .extract().response().body()
                .as(AddMealRequest.class);
        assertThat(request.getStatus(), containsString("success"));

    }
}
