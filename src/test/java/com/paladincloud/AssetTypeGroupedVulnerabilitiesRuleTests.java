package com.paladincloud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paladincloud.models.PolicyResult;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class AssetTypeGroupedVulnerabilitiesRuleTests {

    @Test
    public void verifyVulnerabilitiesResultsInFailingPolicy() {
        // Arrange
        Map<String, String> policyParam = new HashMap<>();
        policyParam.put(Constants.CATEGORY, "category");
        policyParam.put(Constants.SEVERITY, "severity");
        policyParam.put("severityMatchCriteria", "critical");
        policyParam.put(Constants.SRC_ASSET_KEY, "srcAssetKey");

        Map<String, String> resourceAttributes = new HashMap<>();
        resourceAttributes.put("srcAssetKey", "instanceId");
        resourceAttributes.put(Constants.RESOURCE_ID, "resourceId");

        var assetRule = new AssetTypeGroupedVulnerabilitiesRule();
        // Act
        PolicyResult result = assetRule.execute(TestAssetLookup.createFailingInstance(), policyParam, resourceAttributes);

        // Assert
        assertEquals(Constants.STATUS_FAILURE, result.getStatus());
        // TBD: This should also verify the vulnerabilities & maybe the CVEs
    }

    @Test
    public void verifyVulnerabilitiesResultsInSuccessfulPolicy() {
        // Arrange
        Map<String, String> policyParam = new HashMap<>();
        policyParam.put(Constants.CATEGORY, "category");
        policyParam.put(Constants.SEVERITY, "severity");
        policyParam.put("severityMatchCriteria", "low"); // Change this to a lower severity
        policyParam.put(Constants.SRC_ASSET_KEY, "srcAssetKey");

        Map<String, String> resourceAttributes = new HashMap<>();
        resourceAttributes.put("srcAssetKey", "instanceId");
        resourceAttributes.put(Constants.RESOURCE_ID, "resourceId");

        var assetRule = new AssetTypeGroupedVulnerabilitiesRule();

        // Act
        PolicyResult result = assetRule.execute(TestAssetLookup.createPassingInstance(), policyParam, resourceAttributes); // Use a passing instance

        // Assert
        assertEquals(Constants.STATUS_SUCCESS, result.getStatus());
    }

}
