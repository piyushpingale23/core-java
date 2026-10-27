package com.core.java.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ListToArray {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // 1. List to Integer[] array
        Integer[] array = list.toArray(new Integer[0]);

        System.out.println("Array: " + Arrays.toString(array));

        // Updating the array does not modify the original list
        array[0] = 10;
        System.out.println("After Array Update: " + Arrays.toString(array));
        System.out.println("Original List: " + list);


        // 2. List to primitive int[] array
        int[] primitiveArray = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("\nPrimitive Array: " + Arrays.toString(primitiveArray));


        // 3. List to non-modifiable array reference?
        // Arrays themselves are always mutable; the following is a
        // separate array created from the list.
        Integer[] anotherArray = list.toArray(Integer[]::new);

        System.out.println("Another Array: " + Arrays.toString(anotherArray));
    }
}