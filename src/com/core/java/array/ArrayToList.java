package com.core.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5};

        // 1. Non-modifiable in size: Arrays.asList()
        List<Integer> fixedSizeList = Arrays.asList(array);
        System.out.println("Fixed-Size List: " + fixedSizeList);

        // Allowed: Update an existing element
        fixedSizeList.set(0, 10);
        System.out.println("After Update: " + fixedSizeList);

        // Not allowed: Add or remove elements
        // fixedSizeList.add(6);    // UnsupportedOperationException
        // fixedSizeList.remove(0); // UnsupportedOperationException


        // 2. Modifiable: ArrayList constructor
        List<Integer> modifiableList = new ArrayList<>(Arrays.asList(array));
        System.out.println("\nModifiable List: " + modifiableList);

        // Allowed: Update an existing element
        modifiableList.set(0, 100);

        // Allowed: Add a new element
        modifiableList.add(6);

        // Allowed: Remove an element by value
        modifiableList.remove(Integer.valueOf(2));

        System.out.println("After Modifications: " + modifiableList);

        // The original array remains unchanged by modifiableList changes
        System.out.println("Original Array: " + Arrays.toString(array));
    }
}