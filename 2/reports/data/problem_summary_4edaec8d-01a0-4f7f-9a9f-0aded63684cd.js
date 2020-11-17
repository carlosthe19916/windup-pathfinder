MIGRATION_ISSUES_DETAILS["4edaec8d-01a0-4f7f-9a9f-0aded63684cd"] = [
{description: "<p>The application has a Hibernate library embedded. Red Hat JBoss EAP includes Hibernate as a module with a version that has been tested and supported by Red Hat. There are two options for using the Hibernate library:<\/p>\n<ol>\n <li>Keep it embedded as it is now. This approach is low effort but the application will not use a tested and supported library.<\/li>\n <li>Switch to use the Hibernate library in the EAP module. This will require effort to remove the embedded library and configure the application to use the module\'s library but then the application will rely on a tested and supported version of the Hibernate library.<\/li>\n<\/ol><p>In the links below there are the instructions to enable alternative versions for both EAP 6 and 7.<\/p>", ruleID: "embedded-framework-libraries-02000", issueName: "Hibernate embedded library",
problemSummaryID: "4edaec8d-01a0-4f7f-9a9f-0aded63684cd", files: [
{l:"AdministracionEfectivo.ear/AdministracionEfectivo-web-0.0.1-SNAPSHOT.war/WEB-INF/lib/hibernate-commons-annotations-4.0.1.Final.jar", oc:"1"},
{l:"AdministracionEfectivo.ear/AdministracionEfectivo-web-0.0.1-SNAPSHOT.war/WEB-INF/lib/hibernate-validator-4.1.0.Final.jar", oc:"1"},
{l:"AdministracionEfectivo.ear/AdministracionEfectivo-web-0.0.1-SNAPSHOT.war/WEB-INF/lib/hibernate-core-4.1.4.Final.jar", oc:"1"},
{l:"AdministracionEfectivo.ear/AdministracionEfectivo-web-0.0.1-SNAPSHOT.war/WEB-INF/lib/hibernate-jpa-2.0-api-1.0.1.Final.jar", oc:"1"},
], resourceLinks: [
{h:"https://access.redhat.com/articles/112673", t:"Red Hat JBoss EAP: Component Details"},
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html-single/migration_guide/#sect-Hibernate_and_JPA_Changes", t:"Red Hat JBoss EAP 6: Hibernate and JPA Migration Changes"},
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.0/html/migration_guide/application_migration_changes#hibernate_and_jpa_migration_changes", t:"Red Hat JBoss EAP 7: Hibernate and JPA Migration Changes"},
]},
];
onProblemSummaryLoaded("4edaec8d-01a0-4f7f-9a9f-0aded63684cd");