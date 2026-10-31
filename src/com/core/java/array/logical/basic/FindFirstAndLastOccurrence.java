package com.core.java.array.logical.basic;

public class FindFirstAndLastOccurrence {

    public static void main(String[] args) {
        int[] array = {10, 20, 40, 10, 20, 10, 4, 30};

        // Approach 1: Brute force
        int startIndex = 0;
        int endIndex = array.length - 1;

        int firstElementOccurrence = 1;
        int lastElementOccurrence = 1;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[startIndex] == array[i+ 1]) {
                firstElementOccurrence ++;
            }
        }

        for (int i = array.length - 1; i > 0; i--) {
            if (array[endIndex] == array[i - 1]) {
                lastElementOccurrence ++;
            }
        }

        // Approach 2:
        int firstElement = array[0];
        int lastElement = array[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                firstElementOccurrence++;
            }
            if (array[i] == lastElement) {
                lastElementOccurrence++;
            }
        }


        System.out.println(array[startIndex] + " element occurred " + firstElementOccurrence + " times in array");
        System.out.println(array[endIndex] + " element occurred " + lastElementOccurrence + " times in array");
    }

}
