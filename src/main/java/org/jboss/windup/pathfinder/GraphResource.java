package org.jboss.windup.pathfinder;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.janusgraph.core.JanusGraph;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
@Path("/graph")
@Produces("application/json")
@Consumes("application/json")
public class GraphResource {

    @Inject
    GraphCache graphCache;

    @ConfigProperty(name = "windup.graph.path")
    Optional<String> graphPath;

    @GET
    @Path("/test")
    public List<Map<Object, Object>> testGraph() {
        String path = graphPath.orElseThrow(() -> new BadRequestException("You must provider a path to your DB"));
        java.nio.file.Path graphDir = Paths.get(path);

        JanusGraph graph = graphCache.getGraph(graphDir);
        GraphTraversalSource g = new GraphTraversalSource(graph);

        List<Map<Object, Object>> applicationModel = g.V()
                .has("w:winduptype", "ApplicationModel")
                .valueMap()
                .toList();

        return applicationModel;
    }
}

