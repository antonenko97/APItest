package APItest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class LoginPasswordTest extends AbstractTest {

    @Test
    void postTest_1() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", getNoValidLogin())
                .formParam("password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then()
                .statusCode(401);

    }

    @Test
    void postTest_2() {
        String mess = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Username", getNoValidLogin())
                .formParam("Password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then().extract()
                .jsonPath()
                .get("message")
                .toString();
        assertThat(mess, equalTo("The key \"username\" must be provided."));

    }

    @Test
    void postTest_3Fail() {
        String mess = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Username", getNoValidLogin())
                .formParam("Password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then().extract()
                .jsonPath()
                .get("message")
                .toString();
        assertThat(mess, equalTo("The key \"username\" must be painted."));

    }
}
