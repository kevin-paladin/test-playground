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

import com.google.gson.JsonObject;
import com.paladincloud.models.Annotation;
import com.paladincloud.models.PolicyResult;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class AssetTypeScannedBySourceRule {

    private static final String VULN_ASSET_LOOKUP_KEY = "asset_lookup_key";
    private static final String SRC_ASSET_KEY = "src_asset_key";
    private static final String ASSET_LOOKUP_INDEX = "asset_lookup_index";

    /**
     * @param policyParam        ************* Following are the Rule Parameters********* <br><br>
     *                           <p>
     *                           ruleKey : check-asset-scanned-by-source <br><br>
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
    public PolicyResult execute(Map<String, String> policyParam,
        Map<String, String> resourceAttributes) {
        String category = policyParam.get(Constants.CATEGORY);
        String severity = policyParam.get(Constants.SEVERITY);
        /* this param determines the asset key in source index. for eg. for azure_virtualmachine asset key is vmId  */
        String srcAssetKey = policyParam.get(SRC_ASSET_KEY);
        if (!Utils.doesAllHaveValue(category, severity)) {
            throw new RuntimeException(Constants.MISSING_CONFIGURATION);
        }
        PolicyResult policyResult = null;
        if (resourceAttributes != null) {
            String instanceId = StringUtils.trim(
                ObjectUtils.firstNonNull(resourceAttributes.get(srcAssetKey),
                    resourceAttributes.get(Constants.RESOURCE_ID)));
            List<JsonObject> vulAssetList;
            try {
                vulAssetList = Utils.matchAssetAgainstSourceVulnerabilityIndex(instanceId);
            } catch (Exception e) {
                throw new RuntimeException("unable to determine" + e);
            }

            if (!vulAssetList.isEmpty()) {
                Annotation annotation = Annotation.buildAnnotation(policyParam,
                    Annotation.Type.ISSUE);
                annotation.put(Constants.DESCRIPTION,
                    policyParam.get("targetTypeDisplayName") + " is not been scanned by "
                        + policyParam.get("pluginName"));
                annotation.put(Constants.SEVERITY, severity);
                annotation.put(Constants.CATEGORY, category);
                policyResult = new PolicyResult(Constants.STATUS_FAILURE, Constants.FAILURE_MESSAGE,
                    annotation);

            }

            if (policyResult == null) {
                policyResult = new PolicyResult(Constants.STATUS_SUCCESS,
                    Constants.SUCCESS_MESSAGE);
            }
        }
        return policyResult;
    }
}
