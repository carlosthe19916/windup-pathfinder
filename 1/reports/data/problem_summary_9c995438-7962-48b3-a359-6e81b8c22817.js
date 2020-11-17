MIGRATION_ISSUES_DETAILS["9c995438-7962-48b3-a359-6e81b8c22817"] = [
{description: "<p>If you migrate your application to JBoss EAP 7.3 (or later), and want to ensure its Maven building, running or testing works as expected, use instead the Jakarta EE dependency with groupId <code>jakarta.validation<\/code>, and artifactId <code>jakarta.validation-api<\/code>.<\/p>", ruleID: "maven-javax-to-jakarta-00009", issueName: "Move to Jakarta EE Maven Artifacts - javax.validation:validation-api",
problemSummaryID: "9c995438-7962-48b3-a359-6e81b8c22817", files: [
{l:"<a class='' href='pom_xml.89.html?project=3838192'>META-INF/maven/org.hibernate/hibernate-validator/pom.xml<\/a>", oc:"1"},
], resourceLinks: [
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.3/html-single/migration_guide/index#maven-artifact-changes-for-jakarta-ee_default", t:"Red Hat JBoss EAP 7.3 Migration Guide: Maven Artifact Changes for Jakarta EE"},
]},
];
onProblemSummaryLoaded("9c995438-7962-48b3-a359-6e81b8c22817");