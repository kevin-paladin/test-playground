package com.paladincloud.Sapient;

import com.paladincloud.AssetLookup;
import com.paladincloud.AssetTypeGroupedVulnerabilitiesRule;
import com.paladincloud.Utils;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paladincloud.models.Annotation;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.HashMap;
import org.mockito.MockedStatic;
import java.util.ArrayList;
import com.paladincloud.models.PolicyResult;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mockStatic;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class AssetTypeGroupedVulnerabilitiesRuleSapientCodelessTest {

    private final AssetLookup assetLookupMock = mock(AssetLookup.class);

    //Sapient generated method id: ${executeWhenUtilsNotDoesAllHaveValueCategorySeverityThrowsRuntimeException}, hash: A2ADF0BBF54D3DAA6F17425151D89DA7
    @Test()
    void executeWhenUtilsNotDoesAllHaveValueCategorySeverityThrowsRuntimeException() {
        /* Branches:
         * (!Utils.doesAllHaveValue(category, severity)) : true
         */
         //Arrange Statement(s)
        try (MockedStatic<Utils> utils = mockStatic(Utils.class)) {
            String[] stringArray = new String[] { "ruleParamItem3Value1", "ruleParamItem4Value1" };
            utils.when(() -> Utils.doesAllHaveValue(stringArray)).thenReturn(false);
            AssetTypeGroupedVulnerabilitiesRule target = new AssetTypeGroupedVulnerabilitiesRule();
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("src_asset_key", "ruleParamItem1Value1");
            stringStringMap.put("severityMatchCriteria", "ruleParamItem2Value1");
            stringStringMap.put("policyCategory", "ruleParamItem3Value1");
            stringStringMap.put("severity", "ruleParamItem4Value1");
            Map<String, String> stringStringMap2 = new HashMap<>();
            //Act Statement(s)
            final RuntimeException result = assertThrows(RuntimeException.class, () -> {
                target.execute(assetLookupMock, stringStringMap, stringStringMap2);
            });
            RuntimeException runtimeException = new RuntimeException("Missing value in rule configuration, cannot execute the rule");
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
                utils.verify(() -> Utils.doesAllHaveValue(stringArray), atLeast(1));
            });
        }
    }

    //Sapient generated method id: ${executeWhenCaughtExceptionThrowsRuntimeException}, hash: 1E7B63B862E8A2680E3C866CE792AB1F
    @Disabled()
    @Test()
    void executeWhenCaughtExceptionThrowsRuntimeException() {
        /* Branches:
         * (!Utils.doesAllHaveValue(category, severity)) : false
         * (resourceAttributes != null) : true
         * (catch-exception (Exception)) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        try (MockedStatic<Utils> utils = mockStatic(Utils.class)) {
            List<JsonObject> jsonObjectList = new ArrayList<>();
            doReturn(jsonObjectList).when(assetLookupMock).findMatchingAssetsWithVulnerabilities("A");
            String[] stringArray = new String[] { "ruleParamItem1Value1", "ruleParamItem5Value1" };
            utils.when(() -> Utils.doesAllHaveValue(stringArray)).thenReturn(true);
            AssetTypeGroupedVulnerabilitiesRule target = new AssetTypeGroupedVulnerabilitiesRule();
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("policyCategory", "ruleParamItem1Value1");
            stringStringMap.put("ruleParamItem2Key1", "ruleParamItem2Value1");
            stringStringMap.put("ruleParamItem3Key1", "ruleParamItem3Value1");
            stringStringMap.put("src_asset_key", "ruleParamItem4Value1");
            stringStringMap.put("severity", "ruleParamItem5Value1");
            stringStringMap.put("severityMatchCriteria", "ruleParamItem6Value1");
            Map<String, String> stringStringMap2 = new HashMap<>();
            stringStringMap2.put("_resourceid", "resourceAttributesItem1Value1");
            stringStringMap2.put("resourceAttributesItem2Key1", "resourceAttributesItem2Value1");
            stringStringMap2.put("resourceAttributesItem3Key1", "resourceAttributesItem3Value1");
            stringStringMap2.put("ruleParamItem4Value1", "resourceAttributesItem4Value1");
            //Act Statement(s)
            final RuntimeException result = assertThrows(RuntimeException.class, () -> {
                target.execute(assetLookupMock, stringStringMap, stringStringMap2);
            });
            Exception exception = new Exception();
            RuntimeException runtimeException = new RuntimeException("unable to determine", exception);
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
                verify(assetLookupMock).findMatchingAssetsWithVulnerabilities("A");
                utils.verify(() -> Utils.doesAllHaveValue(stringArray), atLeast(1));
            });
        }
    }

    //Sapient generated method id: ${executeWhenCveDetailsGetAsJsonObjectGetVulnerabilitiesGetAsJsonArrayIsNotEmptyAndCaughtJsonProcesThrowsRuntimeException}, hash: 7BB4DAF128B57F5DA7E03AEF9D19F5C3
    @Disabled()
    @Test()
    void executeWhenCveDetailsGetAsJsonObjectGetVulnerabilitiesGetAsJsonArrayIsNotEmptyAndCaughtJsonProcesThrowsRuntimeException() {
        /* Branches:
         * (!Utils.doesAllHaveValue(category, severity)) : false
         * (resourceAttributes != null) : true
         * (!(vulnerabilityInfoList == null || vulnerabilityInfoList.isEmpty())) : true
         * (vulnerabilityInfoList == null) : true
         * (for-each(vulnerabilityInfoList)) : true  #  inside getVMVulnerabilityDetails method
         * (for-each(vulnerability.get(severity).getAsJsonArray())) : true  #  inside getVMVulnerabilityDetails method
         * (for-each(cveDetails.getAsJsonObject().get("vulnerabilities").getAsJsonArray())) : true  #  inside getVMVulnerabilityDetails method
         * (catch-exception (JsonProcessingException)) : true  #  inside getVMVulnerabilityDetails method
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        JsonProcessingException jsonProcessingExceptionMock = mock(JsonProcessingException.class);
        try (MockedStatic<Utils> utils = mockStatic(Utils.class)) {
            JsonObject jsonObject = new JsonObject();
            List<JsonObject> jsonObjectList = new ArrayList<>();
            jsonObjectList.add(jsonObject);
            doReturn(jsonObjectList).when(assetLookupMock).findMatchingAssetsWithVulnerabilities("");
            String[] stringArray = new String[] { "ruleParamItem1Value1", "ruleParamItem6Value1" };
            utils.when(() -> Utils.doesAllHaveValue(stringArray)).thenReturn(true);
            AssetTypeGroupedVulnerabilitiesRule target = new AssetTypeGroupedVulnerabilitiesRule();
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("policyCategory", "ruleParamItem1Value1");
            stringStringMap.put("ruleParamItem2Key1", "ruleParamItem2Value1");
            stringStringMap.put("src_asset_key", "ruleParamItem3Value1");
            stringStringMap.put("ruleParamItem4Key1", "ruleParamItem4Value1");
            stringStringMap.put("severityMatchCriteria", "ruleParamItem5Value1");
            stringStringMap.put("severity", "ruleParamItem6Value1");
            Map<String, String> stringStringMap2 = new HashMap<>();
            stringStringMap2.put("ruleParamItem3Value1", "resourceAttributesItem1Value1");
            stringStringMap2.put("_resourceid", "resourceAttributesItem2Value1");
            //Act Statement(s)
            final RuntimeException result = assertThrows(RuntimeException.class, () -> {
                target.execute(assetLookupMock, stringStringMap, stringStringMap2);
            });
            RuntimeException runtimeException = new RuntimeException("return_of_getMessage1", jsonProcessingExceptionMock);
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
                verify(assetLookupMock).findMatchingAssetsWithVulnerabilities("");
                utils.verify(() -> Utils.doesAllHaveValue(stringArray), atLeast(1));
            });
        }
    }

    //Sapient generated method id: ${executeWhenVulnerabilityGetSeverityGetAsJsonArrayIsEmptyAndVulnerabilityDetailsEquals__AndPolicyResultIsNull}, hash: D8A668E7DA428E690531D43EA39E77F6
    @Disabled()
    @Test()
    void executeWhenVulnerabilityGetSeverityGetAsJsonArrayIsEmptyAndVulnerabilityDetailsEquals__AndPolicyResultIsNull() {
        /* Branches:
         * (!Utils.doesAllHaveValue(category, severity)) : false
         * (resourceAttributes != null) : true
         * (!(vulnerabilityInfoList == null || vulnerabilityInfoList.isEmpty())) : true
         * (vulnerabilityInfoList == null) : true
         * (for-each(vulnerabilityInfoList)) : true  #  inside getVMVulnerabilityDetails method
         * (for-each(vulnerability.get(severity).getAsJsonArray())) : false  #  inside getVMVulnerabilityDetails method
         * (!vulnerabilityDetails.equals("[]")) : false
         * (policyResult == null) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        try (MockedStatic<Utils> utils = mockStatic(Utils.class)) {
            JsonObject jsonObject = new JsonObject();
            List<JsonObject> jsonObjectList = new ArrayList<>();
            jsonObjectList.add(jsonObject);
            doReturn(jsonObjectList).when(assetLookupMock).findMatchingAssetsWithVulnerabilities("A");
            String[] stringArray = new String[] { "ruleParamItem2Value1", "ruleParamItem4Value1" };
            utils.when(() -> Utils.doesAllHaveValue(stringArray)).thenReturn(true);
            AssetTypeGroupedVulnerabilitiesRule target = new AssetTypeGroupedVulnerabilitiesRule();
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("src_asset_key", "ruleParamItem1Value1");
            stringStringMap.put("policyCategory", "ruleParamItem2Value1");
            stringStringMap.put("severityMatchCriteria", "ruleParamItem3Value1");
            stringStringMap.put("severity", "ruleParamItem4Value1");
            Map<String, String> stringStringMap2 = new HashMap<>();
            stringStringMap2.put("_resourceid", "resourceAttributesItem1Value1");
            stringStringMap2.put("resourceAttributesItem2Key1", "resourceAttributesItem2Value1");
            stringStringMap2.put("resourceAttributesItem3Key1", "resourceAttributesItem3Value1");
            stringStringMap2.put("ruleParamItem1Value1", "resourceAttributesItem4Value1");
            //Act Statement(s)
            PolicyResult result = target.execute(assetLookupMock, stringStringMap, stringStringMap2);
            //Assert statement(s)
            //TODO: Please implement equals method in PolicyResult for verification of the entire object or you need to adjust respective assertion statements
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                verify(assetLookupMock).findMatchingAssetsWithVulnerabilities("A");
                utils.verify(() -> Utils.doesAllHaveValue(stringArray), atLeast(1));
            });
        }
    }

    //Sapient generated method id: ${executeWhenPolicyResultIsNotNull}, hash: 605FEBB10281570C45330AF0A244235E
    @Disabled()
    @Test()
    void executeWhenPolicyResultIsNotNull() {
        /* Branches:
         * (!Utils.doesAllHaveValue(category, severity)) : false
         * (resourceAttributes != null) : true
         * (!(vulnerabilityInfoList == null || vulnerabilityInfoList.isEmpty())) : true
         * (vulnerabilityInfoList == null) : true
         * (for-each(vulnerabilityInfoList)) : true  #  inside getVMVulnerabilityDetails method
         * (for-each(vulnerability.get(severity).getAsJsonArray())) : true  #  inside getVMVulnerabilityDetails method
         * (for-each(cveDetails.getAsJsonObject().get("vulnerabilities").getAsJsonArray())) : true  #  inside getVMVulnerabilityDetails method
         * (!vulnerabilityDetails.equals("[]")) : true
         * (policyResult == null) : false
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        try (MockedStatic<Utils> utils = mockStatic(Utils.class);
            MockedStatic<Annotation> annotation = mockStatic(Annotation.class)) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            List<JsonObject> jsonObjectList = new ArrayList<>();
            jsonObjectList.add(jsonObject);
            jsonObjectList.add(jsonObject2);
            doReturn(jsonObjectList).when(assetLookupMock).findMatchingAssetsWithVulnerabilities("A");
            Annotation annotation2 = new Annotation();
            annotation2.put("desc", "VM Instance with  vulnerabilities found");
            annotation2.put("severity", "");
            annotation2.put("policyCategory", "ruleParamItem6Value1");
            annotation2.put("vulnerabilityDetails", "[{\"title\":null,\"vulnerabilityUrl\":null,\"cveList\":null}]");
            annotation.when(() -> Annotation.buildAnnotation(anyMap(), eq(Annotation.Type.ISSUE))).thenReturn(annotation2);
            String[] stringArray = new String[] { "ruleParamItem6Value1", "" };
            utils.when(() -> Utils.doesAllHaveValue(stringArray)).thenReturn(true);
            AssetTypeGroupedVulnerabilitiesRule target = new AssetTypeGroupedVulnerabilitiesRule();
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("severity", "");
            stringStringMap.put("ruleParamItem2Key1", "ruleParamItem2Value1");
            stringStringMap.put("ruleParamItem3Key1", "ruleParamItem3Value1");
            stringStringMap.put("severityMatchCriteria", "ruleParamItem4Value1");
            stringStringMap.put("src_asset_key", "ruleParamItem5Value1");
            stringStringMap.put("policyCategory", "ruleParamItem6Value1");
            Map<String, String> stringStringMap2 = new HashMap<>();
            stringStringMap2.put("ruleParamItem5Value1", "resourceAttributesItem1Value1");
            stringStringMap2.put("resourceAttributesItem2Key1", "resourceAttributesItem2Value1");
            stringStringMap2.put("_resourceid", "resourceAttributesItem3Value1");
            //Act Statement(s)
            PolicyResult result = target.execute(assetLookupMock, stringStringMap, stringStringMap2);
            //Assert statement(s)
            //TODO: Please implement equals method in PolicyResult for verification of the entire object or you need to adjust respective assertion statements
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                verify(assetLookupMock).findMatchingAssetsWithVulnerabilities("A");
                annotation.verify(() -> Annotation.buildAnnotation(anyMap(), eq(Annotation.Type.ISSUE)));
                utils.verify(() -> Utils.doesAllHaveValue(stringArray), atLeast(1));
            });
        }
    }
}
