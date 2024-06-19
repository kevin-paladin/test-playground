package com.paladincloud;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        var policyResult = new AssetTypeGroupedVulnerabilitiesRule().execute(getRuleParams(), getResourceAttributes());
        System.out.println(STR."The policy; name=\{policyResult.getDesc()}; status=\{policyResult.getStatus()};");
    }

    public static Map<String, String> getRuleParams() { // made this public so that it can be tested
        Map<String, String> map = new HashMap<>();
        map.put("severity", "critical");
        map.put("severityMatchCriteria", "critical");
        map.put("policyCategory", "one");
        return map;
    }

    private static Map<String, String> getResourceAttributes() {
        Map<String, String> map = new HashMap<>();
        map.put("_resourceid", "iid-1");
        return map;
    }
}