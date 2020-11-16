package org.jboss.windup.pathfinder;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.janusgraph.core.JanusGraph;
import org.janusgraph.core.JanusGraphFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;

@Singleton
public class GrapthInstance {

//    private GraphTraversalSource g;
//
//    @PostConstruct
//    void init() {
//        JanusGraph janusGraph = JanusGraphFactory.open("/home/cferiavi/git/forks/windup-web-distribution/target/mta-web-distribution-5.1.0-SNAPSHOT/standalone/data/windup/2458/reports/1/graph/TitanConfiguration.properties");
//        g = new GraphTraversalSource(janusGraph);
//    }
//
//    @PreDestroy
//    void preDestroy() {
//        try {
//            g.close();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
//
//    public GraphTraversalSource getTraversal() {
//        return g;
//    }
}
