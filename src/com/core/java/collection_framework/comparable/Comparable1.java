package com.core.java.collection_framework.comparable;

import java.util.Set;
import java.util.TreeSet;

/*
========================================================
Problem Statement:
Demonstrate how Comparable works with Integer values.
Show:
- compareTo() behavior
- natural ordering concept
- how TreeSet uses Comparable internally for sorting

========================================================
Objective:
- Understand Comparable interface
- Learn natural ordering for Integer
- Understand TreeSet internal sorting using compareTo()
========================================================
*/

public class Comparable1 {

    public static void main(String[] args) {

        Integer a = 50;
        Integer b = 30;

        /*
        Integer already implements Comparable<Integer>

        compareTo rules:
        - positive → first object is greater
        - negative → first object is smaller
        - 0        → both are equal
        */

        System.out.println("a.compareTo(b): " + a.compareTo(b));
        System.out.println("b.compareTo(a): " + b.compareTo(a));

        /*
        ========================================================
        TreeSet Example (Real-world usage of Comparable)
        ========================================================
        */

        Set<Integer> set = new TreeSet<>();

        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(40);

        /*
        TreeSet internally:
        - uses Red-Black Tree
        - uses compareTo() for positioning elements
        - automatically maintains sorted order
        */

        System.out.println("TreeSet (Sorted Order): " + set);
    }
}