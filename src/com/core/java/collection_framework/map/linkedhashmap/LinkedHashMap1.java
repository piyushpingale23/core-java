package com.core.java.collection_framework.map.linkedhashmap;

import java.util.LinkedHashMap;

/*
========================================================
Problem Statement:
Create a LinkedHashMap and store key-value pairs of
Integer and String types.

Perform:
- insertion of entries
- display all entries
- iteration using keySet()

Observe:
- insertion order maintenance
- key-value storage behavior

========================================================
Objective:
- Understand LinkedHashMap behavior
- Learn insertion and retrieval operations
- Compare LinkedHashMap with HashMap
========================================================
*/

public class LinkedHashMap1 {

    public static void main(String[] args) {

        /*
        LinkedHashMap internally uses:
        - Hash table
        - Doubly Linked List

        Properties:
        - Stores data in key-value pairs
        - Maintains insertion order
        - Keys must be unique
        - Values can be duplicate
        - One null key allowed
        - Multiple null values allowed
        */

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        // Adding key-value pairs
        map.put(23, "A");
        map.put(46, "B");
        map.put(34, "C");
        map.put(18, "D");

        // Printing complete map
        System.out.println("Map : " + map);

        /*
        Iterating using keySet()

        keySet():
        - returns all keys from LinkedHashMap
        - values are fetched using get(key)
        */

        for (Integer key : map.keySet()) {

            // Fetching value using key
            String value = map.get(key);

            System.out.println("Key : " + key + " -> Value : " + value);
        }

        /*
        Key Observations:
        - LinkedHashMap maintains insertion order
        - Keys are unique
        - Values can be duplicate
        - Faster lookup using hashing
        - Slightly slower than HashMap due to linked list maintenance
        */
    }
}