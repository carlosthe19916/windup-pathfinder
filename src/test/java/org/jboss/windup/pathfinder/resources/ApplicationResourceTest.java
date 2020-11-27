package org.jboss.windup.pathfinder.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.jboss.windup.pathfinder.idm.ExecutionRepresentation;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ApplicationResourceTest {

    @Test
    public void getApplications() throws URISyntaxException {
        // Given
        ExecutionRepresentation execution = ExecutionRepresentation.Builder.anExecutionRepresentation()
                .withFolderPath(Paths.get(getClass().getResource("/executions/11420/reports/19/graph").toURI()).toFile().getAbsolutePath())
                .build();

        execution = given()
                .header("Content-Type", "application/json")
                .when()
                .body(execution)
                .post("/api/executions")
                .then()
                .statusCode(200)
                .body("id", is(notNullValue()),
                        "folderPath", is(notNullValue())
                )
                .extract().as(ExecutionRepresentation.class);

        // When
        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/api/execution/" + execution.getId() + "/applications")
                .then()
                .statusCode(200)
                .body("size()", is(2),
                        "data[0].applicationName", is("AdministracionEfectivo.ear"),
                        "data[1].applicationName", is("1111-1.0-SNAPSHOT.ear")
                );
    }
}
