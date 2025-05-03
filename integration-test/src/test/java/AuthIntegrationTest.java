import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AuthIntegrationTest {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:4004";
    }

    /* Happy Case (Test) */
    @Test
    public void shouldReturnOKWithValidToken(){
        // 1. Arrange
        // 2. Act
        // 3. Assert

        String loginPayload = """
                {
                    "email": "testuser@test.com",
                    "password": "password123"
                }
                """;

        Response response = given()                     //Arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()                                 //Act
                .post("/auth/login")
                .then()                                 //Assert
                .statusCode(200)
                .body("token",notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token: " + response.jsonPath().getString("token"));
    }

    /* Negative Test */
    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin(){
        // 1. Arrange
        // 2. Act
        // 3. Assert

        String loginPayload = """
                {
                    "email": "invalid_testuser@test.com",
                    "password": "wrongpassword"
                }
                """;

            given()                                       //Arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()                                  //Act
                .post("/auth/login")
                .then()                                   //Assert
                .statusCode(401);

    }
}
