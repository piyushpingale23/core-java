package com.core.java.array.logical.basic;

import java.util.*;

public class ReverseAnArray {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original Array: " + Arrays.toString(array));

        // Approach 1:
//        int[] reverseArray = new int[array.length];
//        int reverseArrayIndex = 0;
//
//        for (int i = array.length - 1; i >= 0; i--) {
//            reverseArray[reverseArrayIndex] = array[i];
//            reverseArrayIndex ++;
//        }
//        System.out.println("Reversed Array: " + Arrays.toString(reverseArray));

        // Approach 2: Two Pointers Technique
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left ++;
            right --;
        }

        System.out.println("Reversed Array: " + Arrays.toString(array));

    }
}
