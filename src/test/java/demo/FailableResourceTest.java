package demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class FailableResourceTest {

    /**
     * This test is returning the 404 from the REST Client, whereas I would expect it to be handled by the ExceptionMapper
     */
    @Test
    public void failingTest() {
        given()
          .when().get("/failable/bug")
          .then()
             .statusCode(200);
    }

    @Test
    public void passingTestButManualWorkInControllerRequired() {
        given()
                .when().get("/failable/works1")
                .then()
                .statusCode(200);
    }

    @Test
    public void passingTestWhenIThrowWAE() {
        given()
                .when().get("/failable/works2")
                .then()
                .statusCode(200);
    }

    @Test
    public void passingTest() {
        given()
                .when().get("/failable/works3")
                .then()
                .statusCode(200);
    }
}