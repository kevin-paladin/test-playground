package CoPilotTesting;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestCases {

    static final String NAME_KEY = "name";
    static final String MANAGEMENT_KEY = "management";
    static final String AUTO_UPGRADE_NODE_KEY = "auto_upgrade_node";
    static final String AUTO_UPGRADE_KEY = "auto_upgrade";
    static final String AUTO_REPAIR_NODE_KEY = "auto_repair_node";
    static final String AUTO_REPAIR_KEY = "auto_repair";
    static final String CONFIG_KEY = "config";
    static final String SHIELDED_INSTANCE_CONFIG_KEY = "shielded_instance_config";
    static final String ENABLE_INTEGRITY_NODE_KEY = "enable_integrity_node";
    static final String ENABLE_INTEGRITY_KEY = "enable_integrity";
    static final String ENABLE_SECURE_BOOT_NODE_KEY = "enable_secure_boot_node";
    static final String ENABLE_SECURE_BOOT_KEY = "enable_secure_boot";

    // test 1:
    // successful output
    @org.junit.Test
    public void testIndependentAdd() {
        int result = BasicFunctions.BasicFunctions.independentAdd(3, 5);
        assertEquals(8, result);
    }

    //test 2:
    //successful output
    @org.junit.Test
    public void testSortArray() {
        int[] inputArray = {5, 2, 9, 1, 5}; // Example input array
        int[] expectedSortedArray = {1, 2, 5, 5, 9}; // Expected sorted array

        int[] result = BasicFunctions.BasicFunctions.sortArray(inputArray);
        assertArrayEquals(expectedSortedArray, result);
    }

    @org.junit.Test
    public void testGetRuleParams() {
        Map<String, String> expectedParams = new HashMap<>();
        expectedParams.put("severity", "critical");
        expectedParams.put("severityMatchCriteria", "critical");
        expectedParams.put("policyCategory", "one");

        Map<String, String> result = com.paladincloud.Main.getRuleParams();
        assertEquals(expectedParams, result);
    }

    @org.junit.Test
    public void testGetConvertedNodePools() {
        String nodePoolsJson = "[{\"name\":\"pool1\",\"management\":{\"auto_upgrade\":true,\"auto_repair\":false},\"config\":{\"shielded_instance_config\":{\"enable_integrity\":true,\"enable_secure_boot\":false}}}]";
        ObjectMapper mapper = new ObjectMapper();

        Object result = com.paladincloud.FunctionCaller.getConvertedNodePools(nodePoolsJson);

        // Add assertions based on your expected transformed items
        // For example:
        // assertEquals(expectedTransformedItems, result);
    }

    public static void main(String[] args) {

    }
}
