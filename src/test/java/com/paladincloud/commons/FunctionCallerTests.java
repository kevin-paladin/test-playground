package com.paladincloud.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class FunctionCallerTests {

    @Test
    public void testGetConvertedNodePools() {
        String nodePoolsJson = "[{\"name\":\"pool1\",\"management\":{\"auto_upgrade\":true,\"auto_repair\":false},\"config\":{\"shielded_instance_config\":{\"enable_integrity\":true,\"enable_secure_boot\":false}}}]";
        ObjectMapper mapper = new ObjectMapper();

        Object result = com.paladincloud.FunctionCaller.getConvertedNodePools(nodePoolsJson);

        // Add assertions based on your expected transformed items
        // For example:
        // assertEquals(expectedTransformedItems, result);
    }

}
