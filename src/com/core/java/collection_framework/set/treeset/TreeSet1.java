package com.core.java.collection_framework.set.treeset;

import java.util.Set;
import java.util.TreeSet;

/*
========================================================
Problem Statement:
Insert integers into a TreeSet and observe:
- Automatic sorting (natural ordering)
- Internal use of Comparable.compareTo()
- Restrictions like null and heterogeneous types

========================================================
Objective:
- Understand TreeSet sorting behavior
- Learn Red-Black Tree concept (internally)
- Identify runtime exceptions in invalid cases
========================================================
*/

public class TreeSet1 {

    public static void main(String[] args) {

        // TreeSet internally uses Red-Black Tree
        // Sorting is done using compareTo() (natural ordering)
        Set<Integer> set = new TreeSet<>();

        set.add(40);
        set.add(20);
        set.add(50);
        set.add(10);
        set.add(30);

        // Not allowed:
        // set.add(null); → NullPointerException
        // set.add("A");  → ClassCastException (heterogeneous types)

        System.out.println("TreeSet (Sorted Order): " + set);

        /*
        Key Insights:
        - TreeSet = Sorted Set
        - Uses Red-Black Tree internally
        - Maintains order during insertion
        - No duplicates allowed
        - No null allowed
        */
    }
}