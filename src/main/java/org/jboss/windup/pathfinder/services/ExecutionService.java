package org.jboss.windup.pathfinder.services;

import org.janusgraph.core.JanusGraph;

import java.nio.file.Path;

public interface ExecutionService {

    String create(Path executionPath);

    JanusGraph getGraphById(String executionId);

}
