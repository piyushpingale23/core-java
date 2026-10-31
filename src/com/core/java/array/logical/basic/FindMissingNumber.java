package com.core.java.array.logical.basic;

// Given numbers from 1 to n with one missing number, find the missing number.
public class FindMissingNumber {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15};

        int n = array.length + 1;
        int targetSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int i = 0; i < array.length; i++) {
            actualSum += array[i];
        }

        System.out.println("Target sum    : " + targetSum);
        System.out.println("Actual sum    : " + actualSum);
        System.out.println("Missing number: " + (targetSum - actualSum));

    }
}
