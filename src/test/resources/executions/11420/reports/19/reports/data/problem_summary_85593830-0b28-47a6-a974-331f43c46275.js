MIGRATION_ISSUES_DETAILS["85593830-0b28-47a6-a974-331f43c46275"] = [
{description: "<p>This method lookups an object using a JNDI String. During the migration process, some entity JNDI bindings may change. Ensure that the JNDI Name does not need to change for JBoss EAP.<\/p><p><em>For Example:<\/em><\/p>\n<pre><code class=\"java\">(ConnectionFactory)initialContext.lookup(&quot;weblogic.jms.ConnectionFactory&quot;);\n<\/code><\/pre><p><em>should become:<\/em><\/p>\n<pre><code class=\"java\">(ConnectionFactory)initialContext.lookup(&quot;/ConnectionFactory&quot;);\n<\/code><\/pre>", ruleID: "environment-dependent-calls-02000", issueName: "Call of JNDI lookup",
problemSummaryID: "85593830-0b28-47a6-a974-331f43c46275", files: [
{l:"<a class='' href='ServiceLocator_java.html?project=3547224'>mx.com.bcm.banamex.ae.negocio.design.ServiceLocator<\/a>", oc:"1"},
], resourceLinks: [
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html-single/development_guide/#chap-Remote_JNDI_Lookup", t:"JBoss EAP 6 - JNDI Reference"},
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html-single/migration_guide/#sect-JNDI_Changes", t:"JNDI Changes"},
]},
];
onProblemSummaryLoaded("85593830-0b28-47a6-a974-331f43c46275");