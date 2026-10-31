package com.core.java.array.logical.basic;

public class SmallestElementInArray {

    public static void main(String[] args) {

        int[] array = {10, 40, 5, 20, 60};

        int smallestElement = array[0];

        for (int i = 1; i < array.length; i++) {

            if (smallestElement > array[i]) {
                smallestElement = array[i];
            }
        }

        System.out.println("Smallest element in the array: " + smallestElement);

    }
}
