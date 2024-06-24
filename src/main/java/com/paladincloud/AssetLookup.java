package com.paladincloud;

import com.google.gson.JsonObject;
import java.util.List;

public interface AssetLookup {
    List<JsonObject> findMatchingAssetsWithVulnerabilities(String instanceId);
}
