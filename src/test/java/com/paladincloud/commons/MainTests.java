package com.paladincloud.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MainTests {

    @Test
    public void testGetRuleParams() {
        Map<String, String> expectedParams = new HashMap<>();
        expectedParams.put("severity", "critical");
        expectedParams.put("severityMatchCriteria", "critical");
        expectedParams.put("policyCategory", "one");

        Map<String, String> result = com.paladincloud.Main.getRuleParams();
        assertEquals(expectedParams, result);
    }

}
