/*******************************************************************************
 * Copyright 2023 Paladin Cloud, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.paladincloud;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FunctionCaller {

    static final String VULNERABILITIES_FIELD_NAME = "vulnerabilities";
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

    public static Object getConvertedNodePools(String nodePools) {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> transformedItems = new ArrayList<>();

        try {
            JsonNode originalNode = mapper.readTree(nodePools);
            for (JsonNode itemNode : originalNode) {
                Map<String, Object> transformedItem = new HashMap<>();
                transformedItem.put(NAME_KEY, itemNode.get(NAME_KEY).asText());

                JsonNode managementNode = itemNode.get(MANAGEMENT_KEY);
                if (managementNode != null) {
                    transformedItem.put(AUTO_UPGRADE_NODE_KEY,
                        managementNode.get(AUTO_UPGRADE_KEY).asBoolean());
                    transformedItem.put(AUTO_REPAIR_NODE_KEY,
                        managementNode.get(AUTO_REPAIR_KEY).asBoolean());
                }

                JsonNode configNode = itemNode.get(CONFIG_KEY);
                if (configNode != null) {
                    JsonNode shieldedConfigNode = configNode.get(SHIELDED_INSTANCE_CONFIG_KEY);
                    if (shieldedConfigNode != null) {
                        transformedItem.put(ENABLE_INTEGRITY_NODE_KEY,
                            shieldedConfigNode.get(ENABLE_INTEGRITY_KEY).asBoolean());
                        transformedItem.put(ENABLE_SECURE_BOOT_NODE_KEY,
                            shieldedConfigNode.get(ENABLE_SECURE_BOOT_KEY).asBoolean());
                    }
                }

                transformedItems.add(transformedItem);
            }
            return mapper.convertValue(transformedItems, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String convertDateTimeFormat(String inputDateTimeString, String currentDateFormat,
        String expectedDateFormat) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(currentDateFormat);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(expectedDateFormat);

        // Parse input string to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTimeString, inputFormatter);

        // Format LocalDateTime to desired format
        return outputFormatter.format(localDateTime.atOffset(java.time.ZoneOffset.UTC));
    }

    public static Collection<Map<String, Object>> consolidateVulnerabilitiesByTitle(
        Collection<Map<String, Object>> vulnerabilities, String separator) {
        Map<String, Map<String, Object>> uniquePrefixes = new HashMap<>();

        for (Map<String, Object> vulnerability : vulnerabilities) {
            String fullTitle = vulnerability.get("title").toString();
            String shortTitle;
            if (separator == null) {
                shortTitle = fullTitle;
            } else {
                shortTitle = Collections.list(new StringTokenizer(fullTitle, separator)).stream()
                    .findFirst().orElse(fullTitle).toString();
            }
            if (!uniquePrefixes.containsKey(shortTitle)) {
                vulnerability.put(VULNERABILITIES_FIELD_NAME, new ArrayList<Map<String, String>>());
                vulnerability.put("title", shortTitle);
                uniquePrefixes.put(shortTitle, vulnerability);
            }

            Map<String, String> details = new HashMap<>();
            details.put("id", vulnerability.get("id").toString());
            details.put("url", vulnerability.get("referenceUrl").toString());

            ArrayList<Map<String, String>> vulnList = (ArrayList<Map<String, String>>) uniquePrefixes.get(
                shortTitle).get(VULNERABILITIES_FIELD_NAME);
            vulnList.add(details);
        }

        return uniquePrefixes.values();
    }
}
