package org.jboss.windup.pathfinder;

import com.sleepycat.je.LockMode;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Transaction;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.janusgraph.core.JanusGraph;
import org.janusgraph.core.JanusGraphFactory;
import org.janusgraph.core.JanusGraphTransaction;
import org.janusgraph.core.TransactionBuilder;
import org.janusgraph.diskstorage.berkeleyje.BerkeleyJEStoreManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/graph")
@Produces("application/json")
@Consumes("application/json")
public class GraphResource {

//    @Inject
//    GrapthInstance grapthInstance;

    /**
     * List companies for the authenticated user
     */
    @GET
    @Path("/test")
    public String testGraph() {
        java.nio.file.Path graphDir = Paths.get("/home/cferiavi/git/windup-pathfinder/1/graph");

        java.nio.file.Path lucene = graphDir.resolve("graphsearch");
        java.nio.file.Path berkeley = graphDir.resolve("titangraph");

        Configuration conf = new BaseConfiguration();

        conf.setProperty("graph.unique-instance-id", "windup_" + System.nanoTime() + "_" + RandomStringUtils.randomAlphabetic(6));
        conf.setProperty("storage.directory", berkeley.toAbsolutePath().toString());
        conf.setProperty("storage.backend", "berkeleyje");

        conf.setProperty("storage.berkeleydb.cache-percentage", 1);

        conf.setProperty("storage.berkeleydb.lock-mode", LockMode.READ_UNCOMMITTED);
        conf.setProperty("storage.berkeleydb.isolation-level", BerkeleyJEStoreManager.IsolationLevel.READ_UNCOMMITTED);

        conf.setProperty("storage.buffer-size", "4096");

        conf.setProperty("storage.transactions", false);

        conf.setProperty("ids.block-size", 25000);

        conf.setProperty("cache.db-cache", true);
        conf.setProperty("cache.db-cache-clean-wait", 0);
        conf.setProperty("cache.db-cache-size", .09);
        conf.setProperty("cache.db-cache-time", 0);

        conf.setProperty("index.search.backend", "lucene");
        conf.setProperty("index.search.directory", lucene.toAbsolutePath().toString());

        writeToPropertiesFile(conf, graphDir.resolve("TitanConfiguration.properties").toFile());
        JanusGraph janusGraph = JanusGraphFactory.open(conf);

        GraphTraversalSource g = new GraphTraversalSource(janusGraph);

        List<Vertex> vertexList = g.V()
                .has("w:winduptype", "PersistedProjectModelTraversal")
//                .has(PersistedProjectModelTraversalModel.TRAVERSAL_TYPE, persistedTraversalType.toString())
//                .has(PersistedProjectModelTraversalModel.ROOT, true)
                .toList();

        return "g.toString()";
    }

    private void writeToPropertiesFile(Configuration conf, File file) {
        try {
            PropertiesConfiguration propConf = new PropertiesConfiguration(file);
            propConf.append(conf);
            propConf.save();
        } catch (ConfigurationException ex) {
            throw new RuntimeException("Failed writing Titan config to " + file.getAbsolutePath() + ": " + ex.getMessage(), ex);
        }
    }

}

