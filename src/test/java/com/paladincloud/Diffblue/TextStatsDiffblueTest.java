package com.paladincloud.Diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import com.paladincloud.TextStats;
import org.junit.jupiter.api.Test;

class TextStatsDiffblueTest {
    /**
     * Method under test: {@link TextStats#process(String)}
     */
    @Test
    void testProcess() {
        // Arrange and Act
        Map<String, Integer> actualProcessResult = TextStats.process("Text");

        // Assert
        assertEquals(1, actualProcessResult.size());
        assertEquals(1, actualProcessResult.get("text").intValue());
    }

    /**
     * Method under test: {@link TextStats#process(String)}
     */
    @Test
    void testProcess2() {
        // Arrange and Act
        Map<String, Integer> actualProcessResult = TextStats.process(null);

        // Assert
        assertTrue(actualProcessResult.isEmpty());
    }

    /**
     * Method under test: {@link TextStats#process(String)}
     */
    @Test
    void testProcess3() {
        // Arrange and Act
        Map<String, Integer> actualProcessResult = TextStats.process("Text\n\t?!,;.{}[]()Text");

        // Assert
        assertEquals(1, actualProcessResult.size());
        assertEquals(2, actualProcessResult.get("text").intValue());
    }
}
