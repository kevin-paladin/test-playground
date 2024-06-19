package CoPilotTesting;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.paladincloud.FakeSearchRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
/*import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
*/

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

    @Test
    public void testDoesAllHaveValue() {
        // Test with null input
        Assert.assertFalse(StringUtils.com.paladincloud.Utils.doesAllHaveValue(null));

        // Test with empty array
        Assert.assertFalse(StringUtils.com.paladincloud.Utils.doesAllHaveValue());

        // Test with array containing empty string
        Assert.assertFalse(StringUtils.com.paladincloud.Utils.doesAllHaveValue("", "test"));

        // Test with array containing null
        Assert.assertFalse(StringUtils.com.paladincloud.Utils.doesAllHaveValue(null, "test"));

        // Test with array containing all non-empty strings
        Assert.assertTrue(StringUtils.com.paladincloud.Utils.doesAllHaveValue("test", "test2"));
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
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("testValue", result.get(0).get("testKey").getAsString());
    }

    public static void main(String[] args) {

    }
}
