package com.paladincloud;

import java.util.ArrayList;
import java.util.StringTokenizer;
import com.paladincloud.AssetLookup;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
public class StringExtras {

    private static final String charactersToRemove = "\n\t?!,;.{}[]()";

    private StringExtras() {
    }

    public static String removeNonSpaceAndCharacters(String str) {
        var result = new ArrayList<String>();
        var tokenizer = new StringTokenizer(str, charactersToRemove);
        while (tokenizer.hasMoreTokens()) {
            result.add(tokenizer.nextToken());
        }
        return String.join(" ", result);
    }
}
