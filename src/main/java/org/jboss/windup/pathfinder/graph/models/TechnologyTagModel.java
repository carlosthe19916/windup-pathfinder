package org.jboss.windup.pathfinder.graph.models;

import com.syncleus.ferma.AbstractVertexFrame;

public class TechnologyTagModel extends AbstractVertexFrame {

    public static final String TYPE = "TechnologyTagModel";

    public String getName() {
        return getProperty("name");
    }

    public String getVersion() {
        return getProperty("version");
    }

    public String getLevel() {
        return getProperty("level");
    }

}
