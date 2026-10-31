package com.core.java.array.logical.basic;

import java.util.Arrays;

public class MergeTwoArrays {

    public static void main(String[] args) {

        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        int[] newArray = new int[array1.length + array2.length];

        System.out.println("First array: " + Arrays.toString(array1));
        System.out.println("First array: " + Arrays.toString(array2));

        int n = 0;
        for (int i = 0; i <array1.length; i++) {
            newArray[n] = array1[i];
            n ++;
        }
        for (int i = 0; i <array2.length; i++) {
            newArray[n] = array2[i];
            n ++;
        }

        System.out.println("Merged array: " + Arrays.toString(newArray));
    }
}
