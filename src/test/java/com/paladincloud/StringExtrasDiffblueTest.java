package com.paladincloud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringExtrasDiffblueTest {

    /**
     * Method under test: {@link StringExtras#removeNonSpaceAndCharacters(String)}
     */
    @Test
    void testRemoveNonSpaceAndCharacters() {
        // Arrange, Act and Assert
        assertEquals("w o r l d", StringExtras.removeNonSpaceAndCharacters("w;o]r l{d}"));
    }

}
