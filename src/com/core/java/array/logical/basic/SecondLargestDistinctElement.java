package com.core.java.array.logical.basic;

public class SecondLargestDistinctElement {

    public static void main(String[] args) {

        int[] array = {10, 5, 20, 8, 20};

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = array[i];
            } else if (array[i] > secondLargest && array[i] != firstLargest) {
                secondLargest = array[i];
            }

        }

        System.out.println(firstLargest);
        System.out.println(secondLargest);
    }
}
