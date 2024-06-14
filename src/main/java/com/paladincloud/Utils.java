package com.paladincloud;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Utils {

    public static String getHost(String envVariableName) {
        String host = null;
        if (!StringUtils.isEmpty(envVariableName)) {
            host = System.getenv(envVariableName);
        }
        return host;
    }

    public static Boolean doesAllHaveValue(String... strings) {
        if (null == strings || strings.length == 0) {
            return Boolean.FALSE;
        }
        for (String str : strings) {
            if (StringUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static String convertAttributetoKeyword(String attributeName) {
        return attributeName + ".keyword";
    }

    public static List<JsonObject> matchAssetAgainstSourceVulnIndex(String instanceId,
        String esEndpoint, String attributeName, String severityVulnValue) {
        JsonParser jsonParser = new JsonParser();
        List<JsonObject> resourceVerified = new ArrayList<>();

        try {
            Map<String, Object> mustFilter = new HashMap<>();
            mustFilter.put(convertAttributetoKeyword(attributeName), instanceId);
            if (null != severityVulnValue) {
                mustFilter.put(convertAttributetoKeyword(Constants.SEVERITY), severityVulnValue);
            }

            JsonObject resultJson = RulesElasticSearchRepositoryUtil.getQueryDetailsFromES(
                esEndpoint + "?size=10000", mustFilter, new HashMap<>(), null, null, 0,
                new HashMap<>(), null, null);
            if (resultJson != null && resultJson.has(Constants.HITS)) {
                String hitsJsonString = resultJson.get(Constants.HITS).toString();
                JsonObject hitsJson = (JsonObject) jsonParser.parse(hitsJsonString);
                JsonArray jsonArray = hitsJson.getAsJsonObject().get(Constants.HITS)
                    .getAsJsonArray();
                if (!jsonArray.isEmpty()) {
                    for (JsonElement element : jsonArray) {
                        JsonObject firstObject = (JsonObject) element;
                        JsonObject sourceJson = (JsonObject) firstObject.get(Constants.SOURCE);
                        if ((null != sourceJson)) {
                            resourceVerified.add(sourceJson);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return resourceVerified;
    }
}
