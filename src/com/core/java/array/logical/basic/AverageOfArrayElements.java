package com.core.java.array.logical.basic;

public class AverageOfArrayElements {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};

        int sum = 0;

        for(int i = 0; i < array.length; i ++) {
            sum += array[i];
        }

        System.out.println("Average of array elements: " + (sum / array.length ));
    }
}
