package org.jboss.windup.pathfinder.graph.models;

import com.syncleus.ferma.AbstractVertexFrame;

public class ApplicationModel extends AbstractVertexFrame {

    public static final String TYPE = "ApplicationModel";

    public String getApplicationName() {
        return getProperty("applicationName");
    }

}
