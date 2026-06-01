package com.core.java.collection_framework.map.treemap;

import java.util.TreeMap;

/*
========================================================
Problem Statement:
Demonstrate TreeMap with default natural sorting order.

========================================================
Objective:
- Understand TreeMap behavior
- Learn natural sorting of keys
- Understand restrictions on keys
========================================================
*/

public class TreeMap1 {

    public static void main(String[] args) {

        /*
        TreeMap:
        - Implements SortedMap and NavigableMap
        - Stores keys in sorted order (natural order by default)
        - Uses Comparable (compareTo internally)
        - Does NOT allow null keys (in natural ordering)
        */

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Adding key-value pairs (unordered insertion)
        treeMap.put(50, "A");
        treeMap.put(10, "B");
        treeMap.put(40, "C");
        treeMap.put(20, "D");
        treeMap.put(30, "E");

        /*
        NOTE:
        - Keys must be homogeneous (same type)
        - Otherwise ClassCastException at runtime (without generic) (NOT compile-time)
        */

        // treeMap.put("A", "F");
        // Runtime: ClassCastException (not compile-time)

        /*
        TreeMap does NOT allow null keys
        because comparison (compareTo) will fail
        */

        // treeMap.put(null, "F");
        // Runtime: NullPointerException

        /*
        Internally sorted based on keys:
        10, 20, 30, 40, 50
        */

        System.out.println("TreeMap (Natural Sorting): " + treeMap);

        /*
        Iteration (sorted order)
        */
        for (Integer key : treeMap.keySet()) {
            System.out.println("Key: " + key + " -> Value: " + treeMap.get(key));
        }
    }
}