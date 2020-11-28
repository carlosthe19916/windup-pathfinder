package org.jboss.windup.pathfinder.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LabelsetsResourceTest extends BaseGraphTest {

    @Test
    public void getLabelsets() throws URISyntaxException, JsonProcessingException {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("/api/execution/" + execution.getId() + "/labelsets")
                .then()
                .statusCode(200)
                .body("size()", is(4));
    }
}
