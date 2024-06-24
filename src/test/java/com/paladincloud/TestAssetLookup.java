package com.paladincloud;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

public class TestAssetLookup implements AssetLookup {

    private final String data;

    public TestAssetLookup(String data) {
        this.data = data;
    }

    public static TestAssetLookup createFailingInstance() {
        return new TestAssetLookup(TestData.FAILING_DATA);
    }

    @Override
    public List<JsonObject> findMatchingAssetsWithVulnerabilities(String instanceId) {
        List<JsonObject> resourceVerified = new ArrayList<>();

        try {
            JsonArray resultJson = JsonParser.parseString(String.format(data, instanceId))
                .getAsJsonArray();
            if (resultJson != null && !resultJson.isEmpty()) {
                for (JsonElement element : resultJson) {
                    resourceVerified.add(element.getAsJsonObject());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return resourceVerified;
    }

    static class TestData {

        private static final String SUCCEEDING_DATA = """
            [
            {
                "instanceId": "iid-1",
                "medium": [],
                "low": [],
                "critical": []
            }]""";

        private static final String FAILING_DATA = """
            [
            {
                "instanceId": "iid-1",
                "medium": [],
                "low": [],
                "critical": [
                    {
                        "severity": "critical",
                        "vulnerabilities": [
                            {
                                "id": "CVE-2020-36330",
                                "url": "https://nvd.nist.gov/vuln/detail/CVE-2020-36330"
                            },
                            {
                                "id": "CVE-2018-25014",
                                "url": "https://nvd.nist.gov/vuln/detail/CVE-2018-25014"
                            },
                            {
                                "id": "CVE-2018-25013",
                                "url": "https://nvd.nist.gov/vuln/detail/CVE-2018-25013"
                            },
                            {
                                "id": "CVE-2020-36331",
                                "url": "https://nvd.nist.gov/vuln/detail/CVE-2020-36331"
                            }
                        ],
                        "title": "libwebp 0.3.0-10.amzn2",
                        "url": "https://example.com",
                        "referenceUrl": "https://nvd.nist.gov/vuln/detail/CVE-2020-36330"
                    },
                    {
                        "severity": "critical",
                        "vulnerabilities": [
                            {
                                "id": "CVE-2015-8394",
                                "url": "https://nvd.nist.gov/vuln/detail/CVE-2015-8394"
                            },
                            {
                                "id": "CVE-2015-8390",
                                "url": "https://nvd.nist.gov/vuln/detail/CVE-2015-8390"
                            }
                        ],
                        "title": "pcre 8.32-17.amzn2.0.2",
                        "url": "https://example.com",
                        "referenceUrl": "https://nvd.nist.gov/vuln/detail/CVE-2015-8394"
                    }
                ]
            }]""";

    }
}
