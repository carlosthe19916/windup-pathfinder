MIGRATION_ISSUES_DETAILS["cab9e88b-f2da-4068-b90d-0abdef7ba60d"] = [
{description: "<p>The value of JSF constant <code>FaceletContext.FACELET_CONTEXT_KEY<\/code> has changed between JSF 2.1 and 2.2. The variable is a compile-time constant expression, so when the program was originally compiled, the reference to <code>FACELET_CONTEXT_KEY<\/code> was replaced by its value during compilation. The application must be recompiled so that the reference to <code>FACELET_CONTEXT_KEY<\/code> is replaced by its new value.<\/p>", ruleID: "eap6-11000", issueName: "JSF FaceletContext.FACELET_CONTEXT_KEY changed value",
problemSummaryID: "cab9e88b-f2da-4068-b90d-0abdef7ba60d", files: [
{l:"<a class='' href='AjaxBehaviorHandler_java.html?project=2117704'>org.primefaces.component.behavior.ajax.AjaxBehaviorHandler<\/a>", oc:"1"},
], resourceLinks: [
{h:"https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.0/single/migration_guide/#compatibility_issue_between_jsf_2_1_and_jsf_2_2", t:"Compatibility Issue Between JSF 2.1 and JSF 2.2"},
{h:"https://java.net/jira/browse/JAVASERVERFACES_SPEC_PUBLIC-1257", t:"JAVASERVERFACES_SPEC_PUBLIC-1257"},
]},
];
onProblemSummaryLoaded("cab9e88b-f2da-4068-b90d-0abdef7ba60d");