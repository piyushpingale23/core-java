package com.core.java.collection_framework.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
========================================================
Problem Statement:
Create a HashMap and store key-value pairs of Integer
and String types.

Perform:
- insertion of entries
- display all entries
- iteration using keySet() with Iterator

========================================================
Objective:
- Understand HashMap key-value storage
- Learn insertion and retrieval operations
- Understand iteration using keySet() and Iterator
========================================================
*/

public class HashMap2 {

    public static void main(String[] args) {

        /*
        HashMap internally uses:
        - Hash table
        - Array of Nodes (buckets)

        Properties:
        - Stores data in key-value pair
        - Keys must be unique
        - Values can be duplicate
        - One null key allowed
        - Multiple null values allowed
        - Insertion order is NOT guaranteed
        */

        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs
        map.put(23, "A");
        map.put(46, "B");
        map.put(34, "C");
        map.put(18, "D");

        // Printing complete map
        System.out.println("Map : " + map);

        /*
        ========================================================
        Iteration using keySet() + Iterator
        ========================================================

        keySet():
        - returns Set of all keys from HashMap

        Iterator:
        - used to traverse collection safely
        - provides hasNext() and next()
        */

        Iterator<Integer> it = map.keySet().iterator();

        while (it.hasNext()) {

            Integer key = it.next();
            String value = map.get(key);

            System.out.println("Key : " + key + " -> Value : " + value);
        }

        /*
        Alternative (for-each loop):
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        Best Practice:
        - Use entrySet() for better performance in real applications
        */
    }
}