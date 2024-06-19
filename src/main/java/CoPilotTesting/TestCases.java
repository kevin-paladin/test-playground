package CoPilotTesting;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.paladincloud.FakeSearchRepository;

import com.paladincloud.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


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
    @Test
    public void testIndependentAdd() {
        int result = BasicFunctions.BasicFunctions.independentAdd(3, 5);
        assertEquals(8, result);
    }

    //test 2:
    //successful output
    @Test
    public void testSortArray() {
        int[] inputArray = {5, 2, 9, 1, 5}; // Example input array
        int[] expectedSortedArray = {1, 2, 5, 5, 9}; // Expected sorted array

        int[] result = BasicFunctions.BasicFunctions.sortArray(inputArray);
        assertArrayEquals(expectedSortedArray, result);
    }

    @Test
    public void testGetRuleParams() {
        Map<String, String> expectedParams = new HashMap<>();
        expectedParams.put("severity", "critical");
        expectedParams.put("severityMatchCriteria", "critical");
        expectedParams.put("policyCategory", "one");

        Map<String, String> result = com.paladincloud.Main.getRuleParams();
        assertEquals(expectedParams, result);
    }

    @Test
    public void testGetConvertedNodePools() {
        String nodePoolsJson = "[{\"name\":\"pool1\",\"management\":{\"auto_upgrade\":true,\"auto_repair\":false},\"config\":{\"shielded_instance_config\":{\"enable_integrity\":true,\"enable_secure_boot\":false}}}]";
        ObjectMapper mapper = new ObjectMapper();

        Object result = com.paladincloud.FunctionCaller.getConvertedNodePools(nodePoolsJson);

        // Add assertions based on your expected transformed items
        // For example:
        // assertEquals(expectedTransformedItems, result);
    }

    @Test
    public void testDoesAllHaveValue() {
        // Test with null input
        assertFalse(Utils.doesAllHaveValue(null));

        // Test with empty array
        assertFalse(Utils.doesAllHaveValue());

        // Test with array containing empty string
        assertFalse(Utils.doesAllHaveValue("", "test"));

        // Test with array containing null
        assertFalse(Utils.doesAllHaveValue(null, "test"));

        // Test with array containing all non-empty strings
        assertTrue(Utils.doesAllHaveValue("test", "test2"));
    }

    @Test
    public void testMatchAssetAgainstSourceVulnerabilityIndex() {
        // Mock the FakeSearchRepository.query method
        FakeSearchRepository mockRepository = Mockito.mock(FakeSearchRepository.class);
        JsonArray mockArray = new JsonArray();
        JsonObject mockObject = new JsonObject();
        mockObject.addProperty("testKey", "testValue");
        mockArray.add(mockObject);
        when(mockRepository.query("testInstanceId")).thenReturn(mockArray);

        // Call the method to test
        List<JsonObject> result = com.paladincloud.Utils.matchAssetAgainstSourceVulnerabilityIndex("testInstanceId");

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("testValue", result.get(0).get("testKey").getAsString());
    }

    public static void main(String[] args) {

    }
}
