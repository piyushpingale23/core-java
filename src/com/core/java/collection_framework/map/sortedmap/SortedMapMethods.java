package com.core.java.collection_framework.map.sortedmap;

import java.util.SortedMap;
import java.util.TreeMap;

/*
========================================================
Problem Statement:
Demonstrate SortedMap operations using TreeMap.

Methods covered:
- firstKey()
- lastKey()
- headMap()
- tailMap()
- subMap()
- comparator()

========================================================
Objective:
- Understand SortedMap interface
- Learn navigation methods in TreeMap
- Understand natural sorting behavior
========================================================
*/

public class SortedMapMethods {

    public static void main(String[] args) {

        /*
        TreeMap implements SortedMap
        - stores keys in sorted (natural order) by default
        */

        SortedMap<Integer, String> map = new TreeMap<>();

        map.put(50, "A");
        map.put(10, "B");
        map.put(30, "C");
        map.put(20, "D");
        map.put(40, "E");

        System.out.println("Full Map: " + map);

        /*
        =========================
        firstKey()
        =========================
        Returns smallest key
        */
        System.out.println("First Key: " + map.firstKey());

        /*
        =========================
        lastKey()
        =========================
        Returns largest key
        */
        System.out.println("Last Key: " + map.lastKey());

        /*
        =========================
        headMap(key)
        =========================
        Returns keys strictly less than given key
        */
        System.out.println("HeadMap (keys < 30): " + map.headMap(30));

        /*
        =========================
        tailMap(key)
        =========================
        Returns keys greater than or equal to given key
        */
        System.out.println("TailMap (keys >= 30): " + map.tailMap(30));

        /*
        =========================
        subMap(fromKey, toKey)
        =========================
        Returns keys in range:
        fromKey (inclusive) to toKey (exclusive)
        */
        System.out.println("SubMap (20 to 50): " + map.subMap(20, 50));

        /*
        =========================
        comparator()
        =========================
        Returns comparator if custom sorting is used
        Returns null for natural ordering
        */
        System.out.println("Comparator: " + map.comparator());
    }
}