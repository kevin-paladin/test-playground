package com.paladincloud.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.paladincloud.HardCodedAssetLookup;
import com.paladincloud.Utils;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

public class UtilsTests {
    @Test
    public void testDoesAllHaveValue() {
        // Test with null input
        assertFalse(Utils.doesAllHaveValue(null));

        // Test with empty array
        assertFalse(Utils.doesAllHaveValue());

        // Test with array containing empty string
        assertFalse(Utils.doesAllHaveValue("", "test"));

        // Test with array containing null
        assertFalse(Utils.doesAllHaveValue(null, "test"));

        // Test with array containing all non-empty strings
        assertTrue(Utils.doesAllHaveValue("test", "test2"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForDoesAllHaveValue")
    public void testDoesAllHaveValue(String[] input, boolean expected) {
        Assertions.assertEquals(expected, Utils.doesAllHaveValue(input));
    }

    private static Stream<Arguments> provideStringsForDoesAllHaveValue() {
        return Stream.of(
                Arguments.of(new String[]{null}, false),
                Arguments.of(new String[]{}, false),
                Arguments.of(new String[]{"", "test"}, false),
                Arguments.of(new String[]{null, "test"}, false),
                Arguments.of(new String[]{"test", "test2"}, true)
        );
    }

}
