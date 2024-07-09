package com.paladincloud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paladincloud.models.Annotation;
import com.paladincloud.models.PolicyResult;
import java.util.ArrayList;
import java.util.List;

public class AssetGroupedRule {

    public PolicyResult execute(List<Asset> assets, RuleParameters ruleParameters,
        ResourceAttributes resourceAttributes) throws JsonProcessingException {

        PolicyResult policyResult = null;
        var matchingAssets = assets.stream()
            .filter(a -> a.instanceId.equalsIgnoreCase(resourceAttributes.resourceId)).toList();
        if (!matchingAssets.isEmpty()) {
            var vulnerabilities = getVulnerabilities(matchingAssets,
                ruleParameters.severityMatchCriteria);
            if (!vulnerabilities.isEmpty()) {
                var annotation = Annotation.create(ruleParameters.policyName,
                    ruleParameters.policyId, ruleParameters.type);
                annotation.put(Constants.DESCRIPTION,
                    "VM Instance with " + ruleParameters.severity + " vulnerabilities found");
                annotation.put(Constants.SEVERITY, ruleParameters.severity.toString());

                annotation.put(Constants.VULNERABILITY_DETAILS,
                    new ObjectMapper().writeValueAsString(vulnerabilities));
                policyResult = new PolicyResult(Constants.STATUS_FAILURE, Constants.FAILURE_MESSAGE,
                    annotation);
            }

            if (policyResult == null) {
                policyResult = new PolicyResult(Constants.STATUS_SUCCESS,
                    Constants.SUCCESS_MESSAGE);
            }
        }

        return policyResult;
    }

    private List<Asset.Vulnerability> getVulnerabilities(List<Asset> assets,
        SeverityLevel severityLevel) {
        List<Asset.Vulnerability> vulnerabilities = new ArrayList<>();
        for (Asset asset : assets) {
            switch (severityLevel) {
                case LOW -> vulnerabilities.addAll(asset.low);
                case CRITICAL -> vulnerabilities.addAll(asset.critical);
            }
        }
        return vulnerabilities;
    }

    public enum SeverityLevel {
        LOW, MEDIUM, CRITICAL
    }

    public record Asset(String instanceId, List<Vulnerability> low, List<Vulnerability> critical) {

        public record Vulnerability(SeverityLevel severity, String title, String url, String referenceUrl,
                             List<FindingDetail> details) {

            public record FindingDetail(String id, String url) {

            }
        }
    }

    public record RuleParameters(String category, SeverityLevel severity,
                                 SeverityLevel severityMatchCriteria, String policyName,
                                 String policyId, String type) {

    }

    public record ResourceAttributes(String resourceId) {

    }
}
