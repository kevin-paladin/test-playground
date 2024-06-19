package com.paladincloud.basicfunctions;

public class BasicFunctions {

    public static int independentAdd(int a, int b) {
        return a + b;
    } // Test 1: An independent add function

    public static int[] sortArray(int[] array) { // Test 2: An independent more complex function that sorts an array of integers into least to greatest value
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int intra_classDependentAdd(int a, int b, int c) { // Test 3: A dependent add function that relies on independentAdd() which exists within the same class
        return a + b + independentAdd(a, c);
    }

    public static int inter_classDependentAdd(int a, int b, int c) { // Test 4: A dependent add function that relies on dependencyAdd() which exists within a separate class BasicFunctionDependencies
        return a + b + BasicFunctionDependencies.dependencyAdd(a, c);
    }

    public static int objectDependentAdd(int a, int b) { //test 7: An Add function that is dependent on an object
        BasicCalculator myCalc = new BasicCalculator("My Calculator");
        return myCalc.calcAdd(a, b);
    }

}
