package org.jboss.windup.pathfinder.resources;

import com.syncleus.ferma.DelegatingFramedGraph;
import com.syncleus.ferma.FramedGraph;
import org.janusgraph.core.JanusGraph;
import org.jboss.windup.pathfinder.graph.Constants;
import org.jboss.windup.pathfinder.graph.models.ApplicationModel;
import org.jboss.windup.pathfinder.idm.ApplicationRepresentation;
import org.jboss.windup.pathfinder.services.ExecutionService;
import org.jboss.windup.pathfinder.utils.ModelToRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/applications")
@Produces("application/json")
@Consumes("application/json")
public class ApplicationResource {

    @Inject
    ExecutionService executionService;

    @GET
    @Path("/{executionId}")
    public List<ApplicationRepresentation> getApplications(
            @PathParam("executionId") String executionId
    ) {
        JanusGraph graph = executionService.getGraphById(executionId);

        FramedGraph fg = new DelegatingFramedGraph<>(graph);
        List<? extends ApplicationModel> applications = fg.traverse(
                (f) -> f.V().has(Constants.TYPE, ApplicationModel.TYPE)
        ).toList(ApplicationModel.class);

        return applications.stream()
                .map(ModelToRepresentation::toRepresentation)
                .collect(Collectors.toList());
    }
}

