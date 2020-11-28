package org.jboss.windup.pathfinder.graph.models;

import java.util.Map;

public class ApplicationReportModel extends ReportModel {

    public static final String TYPE = "ApplicationReportModel";

    public String REPORT_PRIORITY = "reportPriority";
    public String REPORT_PROPERTIES = "reportProperties";

    public int getReportPriority() {
        return getProperty(REPORT_PRIORITY);
    }

    public int getReportProperties() {
        traverse(g -> g.out(REPORT_PROPERTIES)).toList(Map.class);
        return getProperty(REPORT_PRIORITY);
    }

}
