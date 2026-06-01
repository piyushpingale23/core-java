package com.core.java.collection_framework.set.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;

/*
========================================================
Problem Statement:
Create a LinkedHashSet and insert:
- null values
- duplicate values
- sequential integers

Observe:
- insertion order maintenance
- duplicate removal
- handling of null values

========================================================
Objective:
- Understand LinkedHashSet behavior
- Compare with HashSet and TreeSet
- Learn how insertion order is preserved
========================================================
*/

public class LinkedHashSet1 {

    public static void main(String[] args) {

        // LinkedHashSet internally uses:
        // HashMap + doubly linked list
        // So it maintains insertion order

        Set<Integer> set = new LinkedHashSet<>();

        // First insertion
        set.add(null);  // allowed (only one null)
        set.add(1);

        // Adding elements 1 to 10
        for (int i = 1; i <= 10; i++) {
            set.add(i);
        }

        // Duplicate insertions
        set.add(null); // ignored (already present)
        set.add(10);   // ignored (duplicate)

        System.out.println("LinkedHashSet Output: " + set);

        /*
        Key Observations:
        - Maintains insertion order
        - Allows only one null value
        - Removes duplicates automatically
        - Faster than TreeSet (no sorting overhead)
        - Slight overhead compared to HashSet (linked list maintenance)
        */
    }
}