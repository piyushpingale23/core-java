package com.core.java.collection_framework.comparable;

import java.util.Set;
import java.util.TreeSet;

/*
========================================================
Problem Statement:
Demonstrate how Comparable works with String values.
Show:
- compareTo() behavior for String
- natural (lexicographical) ordering
- TreeSet sorting using Comparable internally

========================================================
Objective:
- Understand Comparable interface with String
- Learn lexicographical ordering
- Understand TreeSet internal sorting using compareTo()
========================================================
*/

public class Comparable2 {

    public static void main(String[] args) {

        /*
        String class already implements Comparable<String>

        compareTo() behavior:
        - compares lexicographically (dictionary order)
        - based on Unicode values of characters
        */

        String s1 = "Apple";
        String s2 = "Banana";

        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));
        System.out.println("s2.compareTo(s1): " + s2.compareTo(s1));

        /*
        ========================================================
        TreeSet Example using String (Comparable in action)
        ========================================================
        */

        Set<String> set = new TreeSet<>();

        set.add("Banana");
        set.add("Apple");
        set.add("Mango");
        set.add("Orange");
        set.add("Grapes");

        /*
        TreeSet internally:
        - uses Red-Black Tree
        - uses String.compareTo() for ordering
        - maintains lexicographical sorted order
        */

        System.out.println("TreeSet (Sorted Order): " + set);
    }
}