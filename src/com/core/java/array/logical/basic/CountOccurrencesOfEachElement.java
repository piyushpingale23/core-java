package com.core.java.array.logical.basic;

// Problem: Count Occurrences of each Element in an Array
public class CountOccurrencesOfEachElement {

    public static void main(String[] args) {

        int[] array = {10, 20, 10, 30, 10, 20};

        // Approach 1: Brute force
//        for (int i = 0; i < array.length - 1; i++) {
//            int count = 0;
//            for (int j = 0; j < array.length; j++) {
//                if (array[i] == array[j]) {
//                    count ++;
//                }
//            }
//            System.out.println(array[i] + " element occurred " + count + " times.");
//        }

        // Approach 2:
        boolean[] isVisited = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count ++;
                    isVisited[j] = true;
                }
            }
            System.out.println(array[i] + " element occurred " + count + " times.");
        }

    }
}
