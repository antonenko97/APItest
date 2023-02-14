package APItest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import org.apache.http.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
public class MyPublications extends AbstractTest{

    @Test
void getTest_1() {
    given()
            .queryParam("sort", "createdAt")
            .queryParam("order", "ASC")
            .queryParam("page","1")
            .when()
            .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
            .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC&page=1")
            .then()
            .statusCode(200);
    }

    @Test
    void getTest_2() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page","1")
                .when()
                .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(401);
    }
    @Test
    void getTest_3() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "3")
                .when()
                .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
                .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC&page=1")
                .then()
                .toString();

    }
    @Test
    void getTest_4() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "1")
                .when()
                .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
                .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);
    }
    @Test
    void getTest_5() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "null")
                .when()
                .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
                .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);
    }
}
