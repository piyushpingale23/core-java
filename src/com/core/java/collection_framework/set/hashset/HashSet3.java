package com.core.java.collection_framework.set.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
========================================================
Problem Statement:
Create a List containing:
- duplicate values
- multiple null values
Convert it into a HashSet and observe:
- removal of duplicates
- handling of null values

========================================================
Objective:
- Understand List vs Set difference
- Learn HashSet duplicate elimination
- Understand null handling in HashSet
========================================================
*/

public class HashSet3 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        // List allows duplicates and multiple nulls
        list.add(null);
        list.add(8);

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // duplicates again
        list.add(null);
        list.add(8);

        System.out.println("Original List: " + list);

        // HashSet removes duplicates automatically
        Set<Integer> set = new HashSet<>(list);

        System.out.println("Converted Set: " + set);

        /*
        Key Insights:
        - List allows duplicates and multiple nulls
        - HashSet allows only unique values
        - HashSet allows only one null
        - Order is not guaranteed
        */
    }
}