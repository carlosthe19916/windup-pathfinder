package org.jboss.windup.pathfinder.graph.models;

import com.syncleus.ferma.AbstractVertexFrame;

public class ReportModel extends AbstractVertexFrame {

    public static final String TYPE = "ReportModel";

    public static final String REPORT_NAME = "reportName";
    public static final String DESCRIPTION = "reportDescription";
    public static final String REPORT_PROPERTIES = "reportProperties";

    public int getReportName() {
        return getProperty(REPORT_NAME);
    }

    public int getDescription() {
        return getProperty(DESCRIPTION);
    }
}
