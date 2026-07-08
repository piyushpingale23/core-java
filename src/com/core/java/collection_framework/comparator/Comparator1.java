package com.core.java.collection_framework.comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
========================================================
Problem Statement:
Demonstrate different behaviors of Comparator using Integer
values in a TreeSet.

Show how compare() method affects:
- sorting order (ascending/descending)
- duplicate handling
- element insertion behavior

========================================================
Objective:
- Understand Comparator interface
- Learn custom sorting logic
- Understand impact of compare() return values on TreeSet
========================================================
*/

/*
========================================================
Custom Comparator implementation
========================================================
*/
public class Comparator1 implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {

        /*
        compare() return rules:
        - positive -> i1 > i2
        - negative -> i1 < i2
        - 0        -> both considered equal (duplicate in TreeSet)
        */

        // Ascending order
        // return (i1 - i2);

        // Descending order
        // return (i2 - i1);

        // Alternative descending
        // return - (i1 - i2);

        // Alternative ascending
        // return - (i2 - i1);

        /*
        IMPORTANT CASE:
        If we return 0:
        -> TreeSet treats all elements as duplicates
        -> only first inserted element will remain
        */
        return 0;
    }
}

/*
========================================================
Test class to demonstrate TreeSet + Comparator
========================================================
*/
class Test {

    public static void main(String[] args) {

        // TreeSet uses Comparator instead of Comparable
        // Sorting logic is defined by Comparator1.compare()

        Set<Integer> set = new TreeSet<>(new Comparator1());

        set.add(10);
        set.add(15);
        set.add(5);
        set.add(20);
        set.add(15); // duplicate value

        System.out.println("Final Set Output: " + set);

        /*
        Key Observations:

        CASE 1: ascending (i1 - i2)
        -> [5, 10, 15, 20]

        CASE 2: descending (i2 - i1)
        -> [20, 15, 10, 5]

        CASE 3: return 0
        -> [10]
        (all others treated as duplicates)
        */
    }
}