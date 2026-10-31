package com.core.java.array.logical.basic;

import java.util.Arrays;

public class CopyArrayElements {

    public static void main(String[] args) {

        int[] originalArray = {10, 20, 10, 30, 10, 20};
        int[] copyArray = new int[originalArray.length];

        // Approach 1: Brute force technique
//        for (int i = 0; i < originalArray.length; i++) {
//            copyArray[i] = originalArray[i];
//        }

        // Approach 2: 2 Pointers technique
        int left = 0;
        int right = originalArray.length - 1;
        while (left < right) {
            copyArray[left] = originalArray[left];
            copyArray[right] = originalArray[right];

            left ++;
            right --;
        }

        // Common
        System.out.println("Original array : " + Arrays.toString(originalArray));
        System.out.println("Copy array     : " + Arrays.toString(copyArray));
    }
}
