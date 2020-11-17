package org.jboss.windup.pathfinder;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.janusgraph.core.JanusGraph;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
@Path("/graph")
@Produces("application/json")
@Consumes("application/json")
public class GraphResource {

    @Inject
    GraphCache graphCache;

    /**
     * List companies for the authenticated user
     */
    @GET
    @Path("/test")
    public String testGraph() {
        java.nio.file.Path graphDir = Paths.get("/home/cferiavi/git/windup-pathfinder/1/graph");

        JanusGraph graph = graphCache.getGraph(graphDir);
        GraphTraversalSource g = new GraphTraversalSource(graph);

        String result = g
                .V()
                .hasLabel("vertex")
                .propertyMap()
                .toStream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return result;
    }

}

