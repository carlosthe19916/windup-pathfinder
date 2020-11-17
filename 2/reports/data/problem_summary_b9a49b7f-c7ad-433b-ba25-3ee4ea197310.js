MIGRATION_ISSUES_DETAILS["b9a49b7f-c7ad-433b-ba25-3ee4ea197310"] = [
{description: "<p>If you migrate your application to JBoss EAP 7.3 (or later), and want to ensure its Maven building, running or testing works as expected, use instead the Jakarta EE dependency with groupId <code>jakarta.validation<\/code>, and artifactId <code>jakarta.validation-api<\/code>.<\/p>", ruleID: "maven-javax-to-jakarta-00009", issueName: "Move to Jakarta EE Maven Artifacts - javax.validation:validation-api",
problemSummaryID: "b9a49b7f-c7ad-433b-ba25-3ee4ea197310", files: [
{l:"<a class='' href='pom_xml.66.html?project=2117704'>META-INF/maven/org.hibernate/hibernate-validator/pom.xml<\/a>", oc:"1"},
], resourceLinks: [
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.3/html-single/migration_guide/index#maven-artifact-changes-for-jakarta-ee_default", t:"Red Hat JBoss EAP 7.3 Migration Guide: Maven Artifact Changes for Jakarta EE"},
]},
];
onProblemSummaryLoaded("b9a49b7f-c7ad-433b-ba25-3ee4ea197310");