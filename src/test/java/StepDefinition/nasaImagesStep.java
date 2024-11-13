package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class nasaImagesStep {

    private Response response;

    @Given("I make a GET request to NASA's image API with the query {string}")
    public void makeApiRequest(String query){
        response = given()
                .baseUri("https://images-api.nasa.gov/search")
                .queryParam("q", query)
                .when()
                .get();
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @And("the response should contain the word {string}")
    public void verifyResponseContainsWord(String word) {
        assertTrue(response.body().asString().contains(word), "Response should contain the word" + word);
    }
}
