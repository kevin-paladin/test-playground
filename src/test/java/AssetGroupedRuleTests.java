import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paladincloud.AssetGroupedRule;
import com.paladincloud.AssetGroupedRule.SeverityLevel;
import com.paladincloud.Constants;
import java.util.List;
import org.junit.jupiter.api.Test;

class AssetGroupedRuleTests {

    @Test
    void verifyVulnerabilitiesResultsInFailingPolicy() throws JsonProcessingException {
        var assets = getCriticalFailures();
        var ruleParameters = new AssetGroupedRule.RuleParameters("category", SeverityLevel.CRITICAL,
            SeverityLevel.CRITICAL, "policy", "p-id", "type");
        var resourceAttributes = new AssetGroupedRule.ResourceAttributes("iid-1");

        var policyResult = new AssetGroupedRule().execute(assets, ruleParameters,
            resourceAttributes);

        assertEquals(Constants.STATUS_FAILURE, policyResult.getStatus());
        // TBD: This should also verify the vulnerabilities & maybe the CVEs
    }


    private List<AssetGroupedRule.Asset> getCriticalFailures() {
        return List.of(
            new AssetGroupedRule.Asset("iid-1", List.of(), List.of(
                new AssetGroupedRule.Asset.Vulnerability(
                    SeverityLevel.CRITICAL,
                    "libwebp 0.3.0-10.amzn2",
                    "https://example.com",
                    "https://nvd.nist.gov/vuln/detail/CVE-2020-36330",
                    List.of(
                        new AssetGroupedRule.Asset.Vulnerability.FindingDetail(
                            "CVE-2020-36330",
                        "https://nvd.nist.gov/vuln/detail/CVE-2020-36330"))))),
            new AssetGroupedRule.Asset("iid-2", List.of(), List.of()));
    }
}
