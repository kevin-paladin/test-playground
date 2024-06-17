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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.paladincloud.models.Annotation;
import com.paladincloud.models.CveDetails;
import com.paladincloud.models.PolicyResult;
import com.paladincloud.models.VulnerabilityInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class AssetTypeGroupedVulnerabilitiesRule {

    /**
     * @param ruleParam          ************* Following are the Rule Parameters********* <br><br>
     *                           <p>
     *                           ruleKey : check-vm-vulnerabilities-scanned-by-plugin-grouped
     *                           <br><br>
     *                           <p>
     *                           target : Enter the target days <br><br>
     *                           <p>
     *                           discoveredDaysRange : Enter the discovered days Range <br><br>
     *                           <p>
     *                           vulnIndex : Enter the Plugin URL <br><br>
     * @param resourceAttributes this is a resource in context which needs to be scanned this is
     *                           provided by execution engine
     * @return the rule result
     */
    public PolicyResult execute(Map<String, String> ruleParam,
        Map<String, String> resourceAttributes) {
        String category = ruleParam.get(Constants.CATEGORY);
        String severity = ruleParam.get(Constants.SEVERITY);
        String severityMatchCriteria = ruleParam.get(Constants.SEVERITY_MATCH_CRITERIA);
        /* this param determines the asset key in source index. for eg. for azure_virtualmachine asset key is vmId  */
        String srcAssetKey = ruleParam.get(Constants.SRC_ASSET_KEY);
        if (!Utils.doesAllHaveValue(category, severity)) {
            throw new RuntimeException(Constants.MISSING_CONFIGURATION);
        }
        PolicyResult policyResult = null;
        if (resourceAttributes != null) {
            String instanceId = StringUtils.trim(
                ObjectUtils.firstNonNull(resourceAttributes.get(srcAssetKey),
                    resourceAttributes.get(Constants.RESOURCE_ID)));
            List<JsonObject> vulnerabilityInfoList = new ArrayList<>();
            try {
                vulnerabilityInfoList = Utils.matchAssetAgainstSourceVulnerabilityIndex(instanceId);
            } catch (Exception e) {
                throw new RuntimeException("unable to determine", e);
            }

            if (!(vulnerabilityInfoList == null || vulnerabilityInfoList.isEmpty())) {
                String vulnerabilityDetails = getVMVulnerabilityDetails(vulnerabilityInfoList,
                    severityMatchCriteria);
                if (!vulnerabilityDetails.equals("[]")) {
                    Annotation annotation = Annotation.buildAnnotation(ruleParam,
                        Annotation.Type.ISSUE);
                    annotation.put(Constants.DESCRIPTION,
                        "VM Instance with " + severity + " vulnerabilities found");
                    annotation.put(Constants.SEVERITY, severity);
                    annotation.put(Constants.CATEGORY, category);
                    annotation.put("vulnerabilityDetails", vulnerabilityDetails);

                    policyResult = new PolicyResult(Constants.STATUS_FAILURE,
                        Constants.FAILURE_MESSAGE, annotation);
                }
            }

            if (policyResult == null) {
                policyResult = new PolicyResult(Constants.STATUS_SUCCESS,
                    Constants.SUCCESS_MESSAGE);
            }
        }
        return policyResult;
    }

    private String getVMVulnerabilityDetails(List<JsonObject> vulnerabilityInfoList,
        String severity) {
        List<VulnerabilityInfo> vulnerabilityList = new ArrayList<>();
        for (JsonObject vulnerability : vulnerabilityInfoList) {
            for (JsonElement cveDetails : vulnerability.get(severity).getAsJsonArray()) {
                List<CveDetails> cveList = new ArrayList<>();
                for (JsonElement vulnerabilityItem : cveDetails.getAsJsonObject()
                    .get("vulnerabilities").getAsJsonArray()) {
                    String cveId = vulnerabilityItem.getAsJsonObject().get("id").getAsString();
                    String referenceUrl = vulnerabilityItem.getAsJsonObject().get("url")
                        .getAsString();
                    CveDetails cve = new CveDetails(cveId, referenceUrl);
                    cveList.add(cve);
                }
                VulnerabilityInfo vul = new VulnerabilityInfo();
                vul.setCveList(cveList);
                vul.setVulnerabilityUrl(cveDetails.getAsJsonObject().get("url").getAsString());
                vul.setTitle(cveDetails.getAsJsonObject().get("title").getAsString());
                vulnerabilityList.add(vul);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(vulnerabilityList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
