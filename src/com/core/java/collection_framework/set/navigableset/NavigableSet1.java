package com.core.java.collection_framework.set.navigableset;

import java.util.NavigableSet;
import java.util.TreeSet;

/*
========================================================
Problem Statement:
Demonstrate NavigableSet (TreeSet implementation) and
its navigation methods.

Methods covered:
- lower()
- floor()
- higher()
- ceiling()
- descendingSet()

========================================================
Objective:
- Understand NavigableSet interface
- Learn range-based navigation methods
- Understand behavior of TreeSet ordering
========================================================
*/

public class NavigableSet1 {

    public static void main(String[] args) {

        /*
        NavigableSet:
        - Extends SortedSet
        - Provides navigation methods
        - Implemented by TreeSet
        - Maintains sorted order (natural ordering by default)
        */

        NavigableSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        System.out.println("Original Set: " + set);

        /*
        =========================
        lower(E)
        =========================
        - Returns greatest element STRICTLY LESS than given element
        */

        System.out.println("lower(30): " + set.lower(30)); // 20

        /*
        =========================
        floor(E)
        =========================
        - Returns greatest element LESS THAN OR EQUAL to given element
        */

        System.out.println("floor(30): " + set.floor(30)); // 30
        System.out.println("floor(35): " + set.floor(35)); // 30

        /*
        =========================
        higher(E)
        =========================
        - Returns smallest element STRICTLY GREATER than given element
        */

        System.out.println("higher(30): " + set.higher(30)); // 40

        /*
        =========================
        ceiling(E)
        =========================
        - Returns smallest element GREATER THAN OR EQUAL to given element
        */

        System.out.println("ceiling(30): " + set.ceiling(30)); // 30
        System.out.println("ceiling(35): " + set.ceiling(35)); // 40

        /*
        =========================
        descendingSet()
        =========================
        - Returns reverse order view of the set
        */

        System.out.println("descendingSet(): " + set.descendingSet());

        /*
        ========================================================
        KEY DIFFERENCE SUMMARY
        ========================================================

        lower   -> < (strictly less)
        floor   -> <= (less or equal)
        higher  -> > (strictly greater)
        ceiling -> >= (greater or equal)

        descendingSet:
        - Reverses natural sorting order
        */
    }
}