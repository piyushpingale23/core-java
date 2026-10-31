package com.core.java.array.logical.basic;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementFromArray {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 3, 2, 2, 1};

        System.out.println("Original array: " + Arrays.toString(array));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to remove: ");
        int target = sc.nextInt();

        // Approach 1: Brute force
//        int targetOccurrence = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != target) targetOccurrence ++;
//        }
//
//        System.out.println(targetOccurrence);
//
//        int[] newArray = new int[targetOccurrence];
//
//        int newArraySize = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != target) {
//                newArray[newArraySize] = array[i];
//                newArraySize ++;
//            }
//        }

        // Approach 2: Two Pointers
        int[] newArray = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != target) {
                newArray[j] = array[i];
                j++;
            }
        }
        // Create a new array with the required size
        int[] resultArray = new int[j];
        for (int i = 0; i < j; i++) {
            resultArray[i] = newArray[i];
        }

        System.out.println("After removing " + target + " : " + Arrays.toString(resultArray));
        sc.close();
    }
}
