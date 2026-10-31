
package com.core.java.array.logical.basic;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] array = {1, 2, 2};
        System.out.println("Original array: " + Arrays.toString(array));

        // Approach 1 : Brute force
//        int newArrayIndexCount = 0;
//        int[] newArray = new int[array.length];
//
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] != array[i + 1]) {
//                newArray[newArrayIndexCount] = array[i];
//                newArrayIndexCount++;
//            }
//        }
//        // Add the last element because the loop stops at array.length - 1.
//        newArray[newArrayIndexCount] = array[array.length - 1];
//        newArrayIndexCount++;
//
//        int[] sortedArrayWithoutDuplicate = new int[newArrayIndexCount];
//        for (int i = 0; i < newArrayIndexCount; i++) {
//            sortedArrayWithoutDuplicate[i] = newArray[i];
//        }
//        System.out.println("Array after removing duplicates: " + Arrays.toString(sortedArrayWithoutDuplicate));

        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[j]) {
                j++;
                array[j] = array[i];
            }
        }
        for (int i = 0; i <= j; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
