package org.jboss.windup.pathfinder.utils;

import org.jboss.windup.pathfinder.graph.models.ApplicationModel;
import org.jboss.windup.pathfinder.idm.ApplicationRepresentation;

public class ModelToRepresentation {
    private ModelToRepresentation() {
        // Only static methods
    }

    public static ApplicationRepresentation toRepresentation(ApplicationModel model) {
        ApplicationRepresentation rep = new ApplicationRepresentation();

        rep.setApplicationName(model.getApplicationName());

        return rep;
    }
}
