MIGRATION_ISSUES_DETAILS["3b3c4c5d-69cc-43f3-a971-11175212aee6"] = [
{description: "<p>If the application uses Hibernate, please define <code>hibernate.default_schema<\/code> or <code>hibernate.default_catalog<\/code> (whichever is used by the selected dialect), or, alternatively, set <code>hibernate.hbm2ddl.jdbc_metadata_extraction_strategy=individually<\/code>.<\/p>", ruleID: "hibernate51-53-01001", issueName: "Hibernate 5.3 - default_schema or default_catalog must be defined or set jdbc_metadata_extraction_strategy",
problemSummaryID: "3b3c4c5d-69cc-43f3-a971-11175212aee6", files: [
{l:"<a class='' href='persistence_xml.html?project=3838192'>META-INF/persistence.xml<\/a>", oc:"1"},
], resourceLinks: [
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.2/html-single/migration_guide/#schema_management_tooling_changes_71", t:"Red Hat JBoss EAP 7.2: Migrating from Hibernate ORM 5.1 to Hibernate ORM 5.3"},
]},
];
onProblemSummaryLoaded("3b3c4c5d-69cc-43f3-a971-11175212aee6");