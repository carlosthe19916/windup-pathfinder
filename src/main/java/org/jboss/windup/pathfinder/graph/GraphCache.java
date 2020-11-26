package org.jboss.windup.pathfinder.graph;

import com.sleepycat.je.LockMode;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.janusgraph.core.JanusGraph;
import org.janusgraph.core.JanusGraphFactory;
import org.janusgraph.diskstorage.berkeleyje.BerkeleyJEStoreManager;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class GraphCache {

    private Map<Path, JanusGraph> graphMap = new ConcurrentHashMap<>();

    @PreDestroy()
    public void preDestroy() {
        closeAll();
    }

    public JanusGraph getGraph(Path graphDir) {
        if (!graphMap.containsKey(graphDir)) {
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
            conf.setProperty("storage.transactions", true);
            conf.setProperty("ids.block-size", 25000);

            conf.setProperty("cache.db-cache", true);
            conf.setProperty("cache.db-cache-clean-wait", 0);
            conf.setProperty("cache.db-cache-size", .09);
            conf.setProperty("cache.db-cache-time", 0);

            conf.setProperty("index.search.backend", "lucene");
            conf.setProperty("index.search.directory", lucene.toAbsolutePath().toString());

            JanusGraph janusGraph = JanusGraphFactory.open(conf);
            graphMap.put(graphDir, janusGraph);
        }

        JanusGraph janusGraph = graphMap.get(graphDir);
        boolean open = janusGraph.isOpen();
        return janusGraph;
    }

    public void closeGraph(Path graphPath) {
        graphMap.get(graphPath).close();
    }

    public void closeAll() {
        graphMap.values().forEach(JanusGraph::close);
    }

}
