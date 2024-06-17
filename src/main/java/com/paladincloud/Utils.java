package com.paladincloud;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Utils {

    public static String getHost(String envVariableName) {
        String host = null;
        if (!StringUtils.isEmpty(envVariableName)) {
            host = System.getenv(envVariableName);
        }
        return host;
    }

    public static boolean doesAllHaveValue(String... strings) {
        if (null == strings || strings.length == 0) {
            return false;
        }
        for (String str : strings) {
            if (StringUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static List<JsonObject> matchAssetAgainstSourceVulnerabilityIndex(String instanceId) {
        List<JsonObject> resourceVerified = new ArrayList<>();

        try {
            JsonArray resultJson = FakeSearchRepository.query(instanceId);
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
}
