package com.paladincloud.commons;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.paladincloud.TextStats;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class TextStatsTests {

    @Test
    void oneWordIsReturnsCount() {
        var actual = TextStats.process("hello");
        var expected = new HashMap<>(Map.ofEntries(entry("hello", 1)));
        assertEquals(expected, actual);
    }

    @Test
    void multiLineTextReturnsCount() {
        var actual = TextStats.process("""
            Hello!
            How are you doing?
            What are you doing today?""");
        var expected = new HashMap<>(
            Map.ofEntries(entry("hello", 1), entry("how", 1), entry("doing", 2), entry("what", 1),
                entry("are", 2), entry("today", 1), entry("you", 2)));
        assertEquals(expected, actual);
    }

    @Test
    void nullReturnsNothing() {
        var actual = TextStats.process(null);
        var expected = new HashMap<String, Integer>();
        assertEquals(expected, actual);
    }

    @Test
    void emptyStringReturnsNothing() {
        var actual = TextStats.process("");
        var expected = new HashMap<String, Integer>();
        assertEquals(expected, actual);
    }

    @Test
    void punctuationReturnsNothing() {
        var actual = TextStats.process("[ ] { , .");
        var expected = new HashMap<String, Integer>();
        assertEquals(expected, actual);
    }

    //first attempt with asking copilot for a unit test for TextStats.process (It does not attempt to mock StringExtras)
    //Can also ask to split this up into four separate tests, each with its own assert
    // the first AssertEquals was originally wrong
    @Test
    public void testProcess() {
        String text = "Hello world! Hello everyone.";
        Map<String, Integer> result = TextStats.process(text);

        assertEquals(3, result.size(), "The size of the map should be 3 as there are 3 distinct words.");
        assertEquals(2, result.get("hello"), "The word 'hello' appears twice.");
        assertEquals(1, result.get("world"), "The word 'world' appears once.");
        assertEquals(1, result.get("everyone"), "The word 'everyone' appears once.");
    }

    // asked for 5 negative test cases
    @Test
    void testProcessNull() {
        Map<String, Integer> expected = new HashMap<>();
        assertEquals(expected, TextStats.process(null));
    }

    @Test
    void testProcessEmpty() {
        Map<String, Integer> expected = new HashMap<>();
        assertEquals(expected, TextStats.process(""));
    }

    @Test
    void testProcessSingleWord() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 1);
        assertEquals(expected, TextStats.process("word"));
    }

    @Test
    void testProcessMultipleWords() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 2);
        assertEquals(expected, TextStats.process("word word"));
    }

    @Test
    void testProcessMixedCase() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 2);
        assertEquals(expected, TextStats.process("Word word"));
    }

    // Negative test cases
    @Test
    void testProcessNullNegative() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("null", 1);
        assertNotEquals(expected, TextStats.process(null));
    }

    @Test
    void testProcessEmptyNegative() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("empty", 1);
        assertNotEquals(expected, TextStats.process(""));
    }

    @Test
    void testProcessSingleWordNegative() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 2);
        assertNotEquals(expected, TextStats.process("word"));
    }

    @Test
    void testProcessMultipleWordsNegative() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 1);
        assertNotEquals(expected, TextStats.process("word word"));
    }

    @Test
    void testProcessMixedCaseNegative() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Word", 1);
        expected.put("word", 1);
        assertNotEquals(expected, TextStats.process("Word word"));
    }

}
