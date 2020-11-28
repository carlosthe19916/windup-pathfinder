package org.jboss.windup.pathfinder.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.janusgraph.core.JanusGraph;
import org.jboss.windup.pathfinder.graph.Constants;
import org.jboss.windup.pathfinder.graph.models.ReportModel;
import org.jboss.windup.pathfinder.idm.LabelSetRepresentation;
import org.jboss.windup.pathfinder.services.ExecutionService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Path("/execution/{executionId}/labelsets")
@Produces("application/json")
@Consumes("application/json")
public class LabelsetsResource {

    @Inject
    ExecutionService executionService;

    @GET
    @Path("/")
    public List<LabelSetRepresentation> getLabelsets(
            @PathParam("executionId") String executionId
    ) {
        JanusGraph graph = executionService.getGraphById(executionId);

        Map<Object, Object> vertex = new GraphTraversalSource(graph).V()
                .has(Constants.TYPE, ReportModel.TYPE)
                .has(ReportModel.REPORT_NAME, "Application List")
                .out(ReportModel.REPORT_PROPERTIES)
                .valueMap()
                .next();

        try {
            List<String> targetRuntimes = (List) vertex.get("target_runtimes");
            if (targetRuntimes.isEmpty()) {
                return Collections.emptyList();
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(targetRuntimes.get(0), new TypeReference<>() {
            });

        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }

    }
}

