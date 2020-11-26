package org.jboss.windup.pathfinder.services;

import org.janusgraph.core.JanusGraph;
import org.jboss.windup.pathfinder.graph.GraphCache;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class EphemeralExecutionService implements ExecutionService {

    @Inject
    GraphCache graphCache;

    private Map<String, JanusGraph> executionMap = new ConcurrentHashMap<>();

    @Override
    public String create(Path executionPath) {
        JanusGraph graph = graphCache.getGraph(executionPath);
        String executionId = String.valueOf(graph.hashCode());
        executionMap.putIfAbsent(executionId, graph);
        return executionId;
    }

    @Override
    public JanusGraph getGraphById(String executionId) {
        return executionMap.get(executionId);
    }

}
