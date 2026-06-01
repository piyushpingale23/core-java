package com.core.java.collection_framework.set.hashset;

import java.util.HashSet;

/*
========================================================
Problem Statement:
Insert integers from 1 to 17 into a HashSet and observe:
- Default capacity behavior (initial capacity = 16)
- Resizing behavior after threshold is crossed
- Final size of the set

========================================================
Objective:
- Understand HashSet size vs capacity
- Understand internal resizing (rehashing)
- Observe duplicate-free storage
========================================================
*/

public class HashSet1 {

    public static void main(String[] args) {

        // Default HashSet:
        // Initial capacity = 16
        // Load factor = 0.75
        // Threshold = 12 (16 * 0.75)
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 1; i <= 17; i++) {
            hashSet.add(i);
        }

        // Size = actual number of elements stored
        System.out.println("Size: " + hashSet.size());

        // Order is not guaranteed
        System.out.println("HashSet Elements: " + hashSet);
    }
}