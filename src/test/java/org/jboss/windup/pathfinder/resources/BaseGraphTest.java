package org.jboss.windup.pathfinder.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.jboss.windup.pathfinder.idm.ExecutionRepresentation;
import org.junit.jupiter.api.BeforeEach;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public abstract class BaseGraphTest {

    protected ExecutionRepresentation execution;

    @BeforeEach
    public void beforeEach() throws URISyntaxException, JsonProcessingException {
        String dbAbsolutePath = Paths.get(getClass().getResource("/executions/11420/reports/19/graph").toURI()).toFile().getAbsolutePath();
        ExecutionRepresentation rep = ExecutionRepresentation.Builder.anExecutionRepresentation()
                .withFolderPath(dbAbsolutePath)
                .build();
        String body = new ObjectMapper().writeValueAsString(rep);

        execution = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/api/executions")
                .then()
                .statusCode(200)
                .body(is(notNullValue()))
                .extract().as(ExecutionRepresentation.class);
    }
}
