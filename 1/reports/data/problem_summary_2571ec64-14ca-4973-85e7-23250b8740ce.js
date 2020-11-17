MIGRATION_ISSUES_DETAILS["2571ec64-14ca-4973-85e7-23250b8740ce"] = [
{description: "<p>The class is dynamically loaded within application. During the migration, multiple classes that are provided on classpath by a different server may not be present anymore.<\/p><p>Please review the class-loading mechanisms and ensure that the dynamically loaded class is available in JBoss EAP.<\/p>", ruleID: "environment-dependent-calls-01000", issueName: "Dynamic class instantiation",
problemSummaryID: "2571ec64-14ca-4973-85e7-23250b8740ce", files: [
{l:"<a class='' href='Executable_java.html?project=3838192'>com.lowagie.tools.Executable<\/a>", oc:"1"},
{l:"<a class='' href='ToolboxAvailable_java.html?project=3838192'>com.lowagie.tools.ToolboxAvailable<\/a>", oc:"1"},
], resourceLinks: [
{h:"https://access.redhat.com/solutions/361343", t:"Article about Classloading in JBoss EAP 6"},
{h:"https://access.redhat.com/documentation/en-US/JBoss_Enterprise_Application_Platform/6.4/html-single/Development_Guide/index.html#chap-Class_Loading_and_Modules", t:"Class Loading and Modules in JBoss EAP 6"},
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.0/html-single/development_guide/#class_loading_and_modules", t:"Class Loading and Modules in JBoss EAP 7"},
]},
];
onProblemSummaryLoaded("2571ec64-14ca-4973-85e7-23250b8740ce");