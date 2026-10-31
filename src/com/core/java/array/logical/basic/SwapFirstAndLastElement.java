package com.core.java.array.logical.basic;

import java.util.Arrays;

public class SwapFirstAndLastElement {

    public static void main(String[] args) {

        int[] array = {1, 0, 0, 2, 0, 5};

        System.out.println("Original array: " + Arrays.toString(array));

        int first = 0;
        int last = array.length - 1;

        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;

        System.out.println("After swapping first & last element: " + Arrays.toString(array));
    }
}
