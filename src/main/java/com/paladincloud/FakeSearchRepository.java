package com.paladincloud;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class FakeSearchRepository {

    private static final String RESOURCE_TEMPLATE = """
        [
        {
            "instanceId": "iid-1",
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

    public static JsonArray query(String instanceId) {
        return JsonParser.parseString(String.format(RESOURCE_TEMPLATE, instanceId)).getAsJsonArray();
    }
}
