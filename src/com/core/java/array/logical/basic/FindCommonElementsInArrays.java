package com.core.java.array.logical.basic;

import java.util.Arrays;

public class FindCommonElementsInArrays {

    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {2, 4};
        System.out.println("First array: " + Arrays.toString(array1));
        System.out.println("First array: " + Arrays.toString(array2));

        // Approach 1: Brute force
//        for (int i = 0; i < array1.length; i++) {
//            System.out.print("Common elements: ");
//            for (int j = 0; j < array2.length; j++) {
//                if (array1[i] == array2[j]) {
//                    System.out.print(array1[i] + " ");
//                }
//            }
//        }

        int i = 0;
        int j = 0;

        System.out.print("Common elements: ");

        while (i < array1.length && j < array2.length) {

            if (array1[i] == array2[j]) {
                System.out.print(array1[i] + " ");
                i++;
                j++;
            } else if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}
