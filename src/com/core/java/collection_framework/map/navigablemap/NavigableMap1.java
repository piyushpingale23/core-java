package com.core.java.collection_framework.map.navigablemap;

import java.util.NavigableMap;
import java.util.TreeMap;

/*
========================================================
Problem Statement:
Demonstrate NavigableMap (TreeMap implementation) and
its navigation methods.

Methods covered:
- lowerKey()
- floorKey()
- higherKey()
- ceilingKey()
- descendingMap()

========================================================
Objective:
- Understand NavigableMap interface
- Learn key navigation methods
- Understand sorted map behavior
========================================================
*/

public class NavigableMap1 {

    public static void main(String[] args) {

        /*
        NavigableMap:
        - Extends SortedMap
        - Provides navigation methods for keys
        - Implemented by TreeMap
        - Maintains sorted order (natural ordering by default)
        */

        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");
        map.put(50, "E");

        System.out.println("Original Map: " + map);

        /*
        =========================
        lowerKey(K)
        =========================
        - Returns greatest key strictly less than given key
        */

        System.out.println("lowerKey(30): " + map.lowerKey(30)); // 20

        /*
        =========================
        floorKey(K)
        =========================
        - Returns greatest key less than or equal to given key
        */

        System.out.println("floorKey(30): " + map.floorKey(30)); // 30
        System.out.println("floorKey(35): " + map.floorKey(35)); // 30

        /*
        =========================
        higherKey(K)
        =========================
        - Returns smallest key strictly greater than given key
        */

        System.out.println("higherKey(30): " + map.higherKey(30)); // 40

        /*
        =========================
        ceilingKey(K)
        =========================
        - Returns smallest key greater than or equal to given key
        */

        System.out.println("ceilingKey(30): " + map.ceilingKey(30)); // 30
        System.out.println("ceilingKey(35): " + map.ceilingKey(35)); // 40

        /*
        =========================
        descendingMap()
        =========================
        - Returns reverse order view of the map
        */

        System.out.println("descendingMap(): " + map.descendingMap());

        /*
        ========================================================
        KEY DIFFERENCE SUMMARY
        ========================================================

        lowerKey   -> < (strictly less)
        floorKey   -> <= (less or equal)
        higherKey  -> > (strictly greater)
        ceilingKey -> >= (greater or equal)

        descendingMap:
        - Reverses key ordering of TreeMap
        */
    }
}