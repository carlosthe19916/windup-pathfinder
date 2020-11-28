package org.jboss.windup.pathfinder.resources;

import org.jboss.windup.pathfinder.idm.ExecutionRepresentation;
import org.jboss.windup.pathfinder.services.ExecutionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.io.File;
import java.nio.file.Paths;

@Path("/executions")
@Produces("application/json")
@Consumes("application/json")
public class ExecutionResource {

    @Inject
    ExecutionService executionService;

    @POST
    @Path("/")
    public ExecutionRepresentation registerExecution(ExecutionRepresentation rep) {
        java.nio.file.Path path = Paths.get(rep.getFolderPath());
        File file = path.toFile();

        if (!file.exists()) {
            throw new BadRequestException("Folder does not exists");
        }

        File[] configFile = file.listFiles((dir, name) -> name.equals("TitanConfiguration.properties") ||
                name.equals("graphsearch") ||
                name.equals("titangraph"));
        if (configFile != null && configFile.length != 3) {
            throw new BadRequestException("Invalid folder");
        }

        return ExecutionRepresentation.Builder.anExecutionRepresentation()
                .withId(executionService.create(path))
                .build();
    }

}
