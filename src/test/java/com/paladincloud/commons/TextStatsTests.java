package com.paladincloud.commons;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paladincloud.TextStats;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

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
}
