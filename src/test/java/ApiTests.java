import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {


    @Test
    public void firstTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        given()
                .log().all()
                .when()
                .get("/pet/10")
                .then()
                .log().all()
                .statusCode(200);


    }

    @Test
    public void validateResponseBodyFromGet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        given()
                .log().all()
                .when()
                .get("/pet/10")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(101));

    }

    @Test
    public void validateCreatingPet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 13658945,\n" +
                        "  \"name\": \"Berta\",\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(13658945))
                .body("name", equalTo("Berta"))
                .body("status", equalTo("available"));

    }

    @Test
    public void validateUpdatePet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 13658945,\n" +
                        "  \"name\": \"Marta\",\n" +
                        "  \"status\": \"sold\"\n" +
                        "}")
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(13658945))
                .body("name", equalTo("Marta"))
                .body("status", equalTo("sold"));

    }

    @Test
    public void validateDeletePet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .log().all()
                .when()
                .delete("/pet/13658945")
                .then()
                .log().all()
                .statusCode(200);
    }
}


