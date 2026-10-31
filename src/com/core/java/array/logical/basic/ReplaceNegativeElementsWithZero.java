package com.core.java.array.logical.basic;

import java.util.Arrays;

public class ReplaceNegativeElementsWithZero {

    public static void main(String[] args) {

        int[] array = {1, -2, 3, -4};

        System.out.println("Original array: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }

        System.out.println("Replaced zero array: " + Arrays.toString(array));

    }
}
