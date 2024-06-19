package com.paladincloud;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TextStats {

    private TextStats() {}

    public static Map<String, Integer> process(String text) {
        var response = new HashMap<String, Integer>();
        if (text == null) {
            return response;
        }

        var cleanedText = StringExtras.removeNonSpaceAndCharacters(text);
        var tokenizer = new StringTokenizer(cleanedText, " ");
        while (tokenizer.hasMoreTokens()) {
            var token = tokenizer.nextToken().toLowerCase();
            if (response.containsKey(token)) {
                response.put(token, response.get(token) + 1);
            } else {
                response.put(token, 1);
            }
        }
        return response;
    }
}
