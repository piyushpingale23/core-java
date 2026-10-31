package com.core.java.array.logical.basic;

import java.util.Arrays;

public class CheckArrayEquality {

    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {1, 2};
        System.out.println("First array: " + Arrays.toString(array1));
        System.out.println("First array: " + Arrays.toString(array2));

        boolean isEqual = true;
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] != array2[j]) {
                isEqual = false;
                break;
            }
            i++;
            j++;
        }

        if (isEqual) {
            System.out.println("Both array are equal.");
        } else {
            System.out.println("Both array are not equal.");
        }
    }
}
