package com.paladincloud.commons;

import com.paladincloud.StringExtras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringExtrasTests {

    @Test
    void testRemoveNonSpaceAndCharactersNull() {
        assertNull(StringExtras.removeNonSpaceAndCharacters(null));
    }

    @Test
    void testRemoveNonSpaceAndCharactersEmpty() {
        assertEquals("", StringExtras.removeNonSpaceAndCharacters(""));
    }

    @Test
    void testRemoveNonSpaceAndCharactersSingleWord() {
        assertEquals("word", StringExtras.removeNonSpaceAndCharacters("word"));
    }

    @Test
    void testRemoveNonSpaceAndCharactersMultipleWords() {
        assertEquals("word word", StringExtras.removeNonSpaceAndCharacters("word word"));
    }

    @Test
    void testRemoveNonSpaceAndCharactersMixedCase() {
        assertEquals("Word word", StringExtras.removeNonSpaceAndCharacters("Word word"));
    }

    // Negative test cases
    @Test
    void testRemoveNonSpaceAndCharactersNullNegative() {
        assertNotNull(StringExtras.removeNonSpaceAndCharacters(null));
    }

    @Test
    void testRemoveNonSpaceAndCharactersEmptyNegative() {
        assertNotEquals("empty", StringExtras.removeNonSpaceAndCharacters(""));
    }

    @Test
    void testRemoveNonSpaceAndCharactersSingleWordNegative() {
        assertNotEquals("words", StringExtras.removeNonSpaceAndCharacters("word"));
    }

    @Test
    void testRemoveNonSpaceAndCharactersMultipleWordsNegative() {
        assertNotEquals("word", StringExtras.removeNonSpaceAndCharacters("word word"));
    }

    @Test
    void testRemoveNonSpaceAndCharactersMixedCaseNegative() {
        assertNotEquals("word word", StringExtras.removeNonSpaceAndCharacters("Word word"));
    }

}
