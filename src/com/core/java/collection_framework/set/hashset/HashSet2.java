package com.core.java.collection_framework.set.hashset;

import java.util.HashSet;

/*
========================================================
Problem Statement:
Create a HashSet with initial capacity 30 and inset integers from 1 to 25.
Observe:
- When resizing happens
- Final size of the set
- Difference between capacity and size

========================================================
Objective:
- Understand custom capacity in HashSet
- Understand load factor threshold
- Learn resizing behavior
========================================================
*/

public class HashSet2 {

    public static void main(String[] args) {

        // Initial capacity = 30
        // Load factor = 0.75
        // Threshold = 22 (30 * 0.75)
        HashSet<Integer> hashSet = new HashSet<>(30);

        for (int i = 1; i <= 25; i++) {
            hashSet.add(i);
        }

        System.out.println("Size: " + hashSet.size());
        System.out.println("HashSet Elements: " + hashSet);

        /*
        Key Insight:
        - Capacity is internal bucket size (not visible directly)
        - Size = number of elements
        - HashSet automatically grows when threshold is exceeded
        */
    }
}