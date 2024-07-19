package com.paladincloud.Diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.paladincloud.AssetLookup;
import com.paladincloud.AssetTypeGroupedVulnerabilitiesRule;
import com.paladincloud.Constants;
import com.paladincloud.models.PolicyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssetTypeGroupedVulnerabilitiesRuleDiffblueTest {
    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    void testExecute() {
        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();
        AssetLookup assetLookup = mock(AssetLookup.class);
        HashMap<String, String> ruleParam = new HashMap<>();

        // Act and Assert
        assertThrows(RuntimeException.class,
                () -> assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, new HashMap<>()));
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    void testExecute2() {
        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();
        AssetLookup assetLookup = mock(AssetLookup.class);

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "Rule Param");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act and Assert
        assertNull(assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, null));
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    void testExecute3() {
        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();
        AssetLookup assetLookup = mock(AssetLookup.class);
        when(assetLookup.findMatchingAssetsWithVulnerabilities(Mockito.<String>any())).thenReturn(new ArrayList<>());

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "Rule Param");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act
        PolicyResult actualExecuteResult = assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam,
                new HashMap<>());

        // Assert
        verify(assetLookup).findMatchingAssetsWithVulnerabilities(isNull());
        assertEquals(Constants.STATUS_SUCCESS, actualExecuteResult.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, actualExecuteResult.getDesc());
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute4() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.google.gson.JsonElement.getAsJsonArray()" because the return value of "com.google.gson.JsonObject.get(String)" is null
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.getVMVulnerabilityDetails(AssetTypeGroupedVulnerabilitiesRule.java:100)
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.execute(AssetTypeGroupedVulnerabilitiesRule.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();

        ArrayList<JsonObject> jsonObjectList = new ArrayList<>();
        jsonObjectList.add(new JsonObject());
        AssetLookup assetLookup = mock(AssetLookup.class);
        when(assetLookup.findMatchingAssetsWithVulnerabilities(Mockito.<String>any())).thenReturn(jsonObjectList);

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "Rule Param");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act
        assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, new HashMap<>());
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    void testExecute5() {
        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();
        AssetLookup assetLookup = mock(AssetLookup.class);

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act and Assert
        assertThrows(RuntimeException.class,
                () -> assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, new HashMap<>()));
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    void testExecute6() {
        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();
        AssetLookup assetLookup = mock(AssetLookup.class);
        when(assetLookup.findMatchingAssetsWithVulnerabilities(Mockito.<String>any()))
                .thenThrow(new RuntimeException(Constants.CATEGORY));

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "Rule Param");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act and Assert
        assertThrows(RuntimeException.class,
                () -> assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, new HashMap<>()));
        verify(assetLookup).findMatchingAssetsWithVulnerabilities(isNull());
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute7() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.google.gson.JsonObject.get(String)" because "vulnerability" is null
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.getVMVulnerabilityDetails(AssetTypeGroupedVulnerabilitiesRule.java:100)
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.execute(AssetTypeGroupedVulnerabilitiesRule.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();

        ArrayList<JsonObject> jsonObjectList = new ArrayList<>();
        jsonObjectList.add(null);
        AssetLookup assetLookup = mock(AssetLookup.class);
        when(assetLookup.findMatchingAssetsWithVulnerabilities(Mockito.<String>any())).thenReturn(jsonObjectList);

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "Rule Param");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act
        assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, new HashMap<>());
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute8() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.google.gson.JsonElement.getAsJsonArray()" because the return value of "com.google.gson.JsonObject.get(String)" is null
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.getVMVulnerabilityDetails(AssetTypeGroupedVulnerabilitiesRule.java:100)
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.execute(AssetTypeGroupedVulnerabilitiesRule.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();

        JsonObject jsonObject = new JsonObject();
        jsonObject.add(Constants.CATEGORY, new JsonArray(3));

        ArrayList<JsonObject> jsonObjectList = new ArrayList<>();
        jsonObjectList.add(jsonObject);
        AssetLookup assetLookup = mock(AssetLookup.class);
        when(assetLookup.findMatchingAssetsWithVulnerabilities(Mockito.<String>any())).thenReturn(jsonObjectList);

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "Rule Param");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act
        assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, new HashMap<>());
    }

    /**
     * Method under test:
     * {@link AssetTypeGroupedVulnerabilitiesRule#execute(AssetLookup, Map, Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute9() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.google.gson.JsonElement.getAsJsonArray()" because the return value of "com.google.gson.JsonObject.get(String)" is null
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.getVMVulnerabilityDetails(AssetTypeGroupedVulnerabilitiesRule.java:100)
        //       at com.paladincloud.AssetTypeGroupedVulnerabilitiesRule.execute(AssetTypeGroupedVulnerabilitiesRule.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetTypeGroupedVulnerabilitiesRule assetTypeGroupedVulnerabilitiesRule = new AssetTypeGroupedVulnerabilitiesRule();

        JsonObject jsonObject = new JsonObject();
        jsonObject.add(Constants.SEVERITY, new JsonArray(3));
        jsonObject.add(Constants.CATEGORY, new JsonArray(3));

        ArrayList<JsonObject> jsonObjectList = new ArrayList<>();
        jsonObjectList.add(jsonObject);
        AssetLookup assetLookup = mock(AssetLookup.class);
        when(assetLookup.findMatchingAssetsWithVulnerabilities(Mockito.<String>any())).thenReturn(jsonObjectList);

        HashMap<String, String> ruleParam = new HashMap<>();
        ruleParam.put(Constants.CATEGORY, "Rule Param");
        ruleParam.put(Constants.SEVERITY, "Rule Param");
        ruleParam.put(Constants.SEVERITY_MATCH_CRITERIA, "Rule Param");
        ruleParam.put(Constants.SRC_ASSET_KEY, "Rule Param");
        ruleParam.put(Constants.POLICY_DISPLAY_NAME, "Rule Param");
        ruleParam.put(Constants.POLICY_ID, "Rule Param");
        ruleParam.put(Constants.POLICY_VERSION, "Rule Param");
        ruleParam.put(Constants.RESOURCE_ID, "Rule Param");

        // Act
        assetTypeGroupedVulnerabilitiesRule.execute(assetLookup, ruleParam, new HashMap<>());
    }
}
