package com.core.java.array.logical.basic;

public class LargestElementInArray {

    public static void main(String[] args) {

        int[] array = {10, 40, 20, 60};

        int largestElement = array[0];

        for (int i = 1; i < array.length; i++) {
            if (largestElement < array[i]) {
                largestElement = array[i];
            }
        }

        System.out.println("Largest element in the array: " + largestElement);

    }

}

// Time complexity - o(n)
