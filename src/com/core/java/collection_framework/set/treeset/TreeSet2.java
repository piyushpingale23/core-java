package com.core.java.collection_framework.set.treeset;

import java.util.Set;
import java.util.TreeSet;

/*
========================================================
Problem Statement:
Create a TreeSet of String elements and insert both
uppercase and lowercase characters. Observe how TreeSet
sorts elements and how case affects ordering.

========================================================
Objective:
- Understand TreeSet natural ordering with Strings
- Learn how compareTo() handles uppercase vs lowercase
- Observe ASCII-based sorting behavior
========================================================
*/

public class TreeSet2 {

    public static void main(String[] args) {

        // TreeSet uses Red-Black Tree internally
        // Sorting is done using String.compareTo()
        // Comparison is ASCII/Unicode based

        Set<String> set = new TreeSet<>();

        set.add("A");
        set.add("C");
        set.add("E");
        set.add("B");
        set.add("F");
        set.add("a");
        set.add("b");

        System.out.println("TreeSet (Sorted Order): " + set);

        /*
        Key Observations:
        - Uppercase letters come before lowercase letters
          because ASCII value of 'A' (65) is less than 'a' (97)
        - TreeSet is case-sensitive by default
        - Sorting order is:
          Uppercase A-Z first, then lowercase a-z
        - Insertion order is ignored
        - Duplicate values are not allowed (not present here)
        */
    }
}