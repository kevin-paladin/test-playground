package com.paladincloud.Sapient;

import com.paladincloud.AssetGroupedRule;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Disabled;
import java.util.List;
import com.paladincloud.models.Annotation;
import org.mockito.MockedStatic;
import java.util.ArrayList;
import com.paladincloud.models.PolicyResult;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.hamcrest.Matchers.is;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class AssetGroupedRuleSapientCodelessTest {

    private final AssetGroupedRule.RuleParameters assetGroupedRuleRuleParametersMock = mock(AssetGroupedRule.RuleParameters.class);

    //Sapient generated method id: ${executeWhenMatchingAssetsIsEmpty}, hash: 03C4ED9734E203617694F6FBA25F800F
    @Test()
    void executeWhenMatchingAssetsIsEmpty() throws JsonProcessingException {
        /* Branches:
         * (branch expression (line 17)) : false
         * (!matchingAssets.isEmpty()) : false
         */
         //Arrange Statement(s)
        AssetGroupedRule target = new AssetGroupedRule();
        List list = new ArrayList<>();
        List list2 = new ArrayList<>();
        AssetGroupedRule.Asset assetGroupedRuleAsset = new AssetGroupedRule.Asset("A", list, list2);
        List<AssetGroupedRule.Asset> assetGroupedRuleAssetList = new ArrayList<>();
        assetGroupedRuleAssetList.add(assetGroupedRuleAsset);
        AssetGroupedRule.ResourceAttributes assetGroupedRuleResourceAttributes = new AssetGroupedRule.ResourceAttributes("B");
        
        //Act Statement(s)
        PolicyResult result = target.execute(assetGroupedRuleAssetList, assetGroupedRuleRuleParametersMock, assetGroupedRuleResourceAttributes);
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, is(nullValue())));
    }

    //Sapient generated method id: ${executeWhenVulnerabilitiesIsEmptyAndPolicyResultIsNull}, hash: 9F4C8600EA34B5D3C5E60E9231100E57
    @Disabled()
    @Test()
    void executeWhenVulnerabilitiesIsEmptyAndPolicyResultIsNull() throws JsonProcessingException {
        /* Branches:
         * (branch expression (line 17)) : true
         * (!matchingAssets.isEmpty()) : true
         * (for-each(assets)) : true  #  inside getVulnerabilities method
         * (switch(severityLevel) = CRITICAL) : true  #  inside getVulnerabilities method
         * (!vulnerabilities.isEmpty()) : false
         * (policyResult == null) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        AssetGroupedRule target = new AssetGroupedRule();
        List list = new ArrayList<>();
        List<AssetGroupedRule.Asset.Vulnerability> assetGroupedRuleAssetVulnerabilityList = new ArrayList<>();
        AssetGroupedRule.Asset assetGroupedRuleAsset = new AssetGroupedRule.Asset("F", list, assetGroupedRuleAssetVulnerabilityList);
        List<AssetGroupedRule.Asset> assetGroupedRuleAssetList = new ArrayList<>();
        assetGroupedRuleAssetList.add(assetGroupedRuleAsset);
        AssetGroupedRule.ResourceAttributes assetGroupedRuleResourceAttributes = new AssetGroupedRule.ResourceAttributes("F");
        
        //Act Statement(s)
        PolicyResult result = target.execute(assetGroupedRuleAssetList, assetGroupedRuleRuleParametersMock, assetGroupedRuleResourceAttributes);
        
        //Assert statement(s)
        //TODO: Please implement equals method in PolicyResult for verification of the entire object or you need to adjust respective assertion statements
        assertAll("result", () -> assertThat(result, is(notNullValue())));
    }

    //Sapient generated method id: ${executeWhenPolicyResultIsNotNull}, hash: BB83692E7A6E8C0DBE89F107F03357AF
    @Disabled()
    @Test()
    void executeWhenPolicyResultIsNotNull() throws JsonProcessingException {
        /* Branches:
         * (branch expression (line 17)) : true
         * (!matchingAssets.isEmpty()) : true
         * (for-each(assets)) : true  #  inside getVulnerabilities method
         * (switch(severityLevel) = LOW) : true  #  inside getVulnerabilities method
         * (!vulnerabilities.isEmpty()) : true
         * (policyResult == null) : false
         *
         * TODO: Help needed! This method is not unit testable!
         *  A variable could not be isolated/mocked when calling a method - Variable name: object of type ObjectMapper - Method: writeValueAsString
         *  Suggestions:
         *  You can pass them as constructor arguments or create a setter for them (avoid new operator)
         *  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        try (MockedStatic<Annotation> annotation = mockStatic(Annotation.class)) {
            Annotation annotation2 = new Annotation();
            annotation2.put("desc", "VM Instance with LOW vulnerabilities found");
            annotation2.put("severity", "LOW");
            annotation2.put("vulnerabilityDetails", "return_of_createItem3Value1");
            annotation.when(() -> Annotation.create("string6", "string8", "string10")).thenReturn(annotation2);
            AssetGroupedRule target = new AssetGroupedRule();
            List<AssetGroupedRule.Asset.Vulnerability> assetGroupedRuleAssetVulnerabilityList = new ArrayList<>();
            List list = new ArrayList<>();
            AssetGroupedRule.Asset assetGroupedRuleAsset = new AssetGroupedRule.Asset("", assetGroupedRuleAssetVulnerabilityList, list);
            List<AssetGroupedRule.Asset> assetGroupedRuleAssetList = new ArrayList<>();
            assetGroupedRuleAssetList.add(assetGroupedRuleAsset);
            AssetGroupedRule.ResourceAttributes assetGroupedRuleResourceAttributes = new AssetGroupedRule.ResourceAttributes("");
            //Act Statement(s)
            PolicyResult result = target.execute(assetGroupedRuleAssetList, assetGroupedRuleRuleParametersMock, assetGroupedRuleResourceAttributes);
            //Assert statement(s)
            //TODO: Please implement equals method in PolicyResult for verification of the entire object or you need to adjust respective assertion statements
            assertAll("result", () -> {
                assertThat(result, is(notNullValue()));
                annotation.verify(() -> Annotation.create("string6", "string8", "string10"), atLeast(1));
            });
        }
    }
}
