package org.jboss.windup.pathfinder.resources;

import org.jboss.windup.pathfinder.idm.ExecutionRepresentation;
import org.jboss.windup.pathfinder.services.ExecutionService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.nio.file.Paths;

@Path("/executions")
@Produces("application/json")
@Consumes("application/json")
public class ExecutionResource {

    @Inject
    ExecutionService executionService;

    @POST
    @Path("/")
    public ExecutionRepresentation registerExecution(String folderPath) {
        java.nio.file.Path path = Paths.get(folderPath);
        String executionId = executionService.create(path);

        return ExecutionRepresentation.Builder.anExecutionRepresentation()
                .withId(executionId)
                .withFolderPath(folderPath)
                .build();
    }

}
