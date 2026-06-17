package com.core.java.collection_framework.utility.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
========================================================
Class Name: ArraysConversion

Problem Statement:
Demonstrate Arrays conversion utility methods:
1. toArray()   -> List to Array conversion
2. asList()    -> Array to List conversion

========================================================
Key Concepts:
1. Arrays.toArray() creates a new array from List
2. Arrays.asList() creates a FIXED-SIZE list backed by array
3. asList() list DOES NOT support add/remove operations
4. Changes reflect both ways in asList() (array ↔ list)

========================================================
*/

public class ArraysConversion {

    public static void main(String[] args) {

        /*
        ========================================================
        1. List -> Array using toArray()
        ========================================================
        */

        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");

        System.out.println("Original List:");
        System.out.println(list);

        // Convert List to Array
        String[] array = list.toArray(new String[0]);

        System.out.println("\nConverted Array using toArray():");
        System.out.println(Arrays.toString(array));


        /*
        ========================================================
        2. Array -> List using asList()
        ========================================================
        */

        String[] names = {"Amit", "Rahul", "Neha"};

        System.out.println("\nOriginal Array:");
        System.out.println(Arrays.toString(names));

        // Convert Array to List
        List<String> listFromArray = Arrays.asList(names);

        System.out.println("\nList created using Arrays.asList():");
        System.out.println(listFromArray);


        /*
        ========================================================
        3. IMPORTANT: asList() behavior (FIXED SIZE LIST)
        ========================================================
        */

        System.out.println("\nTrying to modify asList() result...");

        try {

            // Allowed operation (replaces element)
            listFromArray.set(1, "VK");

            System.out.println("After set(): " + listFromArray);
            System.out.println("Array also changed: " + Arrays.toString(names));

            // NOT allowed operations (will throw exception)
            listFromArray.add("New Name"); // UnsupportedOperationException

        } catch (UnsupportedOperationException e) {
            System.out.println("\nException Occurred: " + e);
            System.out.println("Reason: Arrays.asList() returns fixed-size list backed by array");
        }

        /*
        ========================================================
        WHY add/remove NOT allowed in asList():
        ========================================================
        - It is backed by original array
        - Array size is fixed
        - So list size cannot be changed
        - Only element replacement is allowed (set)
        ========================================================
        */
    }
}