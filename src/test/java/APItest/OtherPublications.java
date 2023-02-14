package APItest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import org.apache.http.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
public class OtherPublications extends AbstractTest{
    @Test
    void getTest_6() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page","1")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(401);
    }

    @Test
    void getTest_7() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page","1")
                .when()
                .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);
    }
    @Test
    void getTest_8() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page","1")
                .when()
                .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);

    }
    @Test
    void getTest_9() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page","8")
                .when()
                .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);
    }
    @Test
    void getTest_10() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page","null")
                .when()
                .header("X-Auth-Token", "890f331ef8dbaae2827018f884dc96a0")
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);
    }
}
