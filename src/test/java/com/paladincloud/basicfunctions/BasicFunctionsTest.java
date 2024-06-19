package com.paladincloud.basicfunctions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BasicFunctionsTest {

    // test 1:
    // successful output
    @Test
    public void testIndependentAdd() {
        int result = BasicFunctions.independentAdd(3, 5);
        assertEquals(8, result);
    }

    //test 2:
    //successful output
    @Test
    public void testSortArray() {
        int[] inputArray = {5, 2, 9, 1, 5}; // Example input array
        int[] expectedSortedArray = {1, 2, 5, 5, 9}; // Expected sorted array

        int[] result = BasicFunctions.sortArray(inputArray);
        assertArrayEquals(expectedSortedArray, result);
    }
}
