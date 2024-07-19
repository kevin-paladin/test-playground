package com.paladincloud.Diffblue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.paladincloud.Utils;
import org.junit.jupiter.api.Test;

class UtilsDiffblueTest {
    /**
     * Method under test: {@link Utils#getHost(String)}
     */
    @Test
    void testGetHost() {
        // Arrange, Act and Assert
        assertNull(Utils.getHost("Env Variable Name"));
        assertNull(Utils.getHost(null));
        assertNull(Utils.getHost(""));
    }

    /**
     * Method under test: {@link Utils#doesAllHaveValue(String[])}
     */
    @Test
    void testDoesAllHaveValue() {
        // Arrange, Act and Assert
        assertTrue(Utils.doesAllHaveValue("Strings"));
        assertFalse(Utils.doesAllHaveValue(""));
        assertFalse(Utils.doesAllHaveValue());
    }

}
