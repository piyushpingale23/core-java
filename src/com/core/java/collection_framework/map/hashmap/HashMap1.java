package com.core.java.collection_framework.map.hashmap;

import java.util.HashMap;

/*
========================================================
Problem Statement:
Create a HashMap and store key-value pairs of Integer
and String types.

Perform:
- insertion of entries
- display all entries
- iteration using keySet()

========================================================
Objective:
- Understand HashMap key-value storage
- Learn insertion and retrieval operations
- Understand iteration using keySet()
========================================================
*/

public class HashMap1 {

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
        Iterating through map using keySet()

        keySet():
        - returns all keys from HashMap
        - using each key, value is fetched using get()
        */

        for (Integer key : map.keySet()) {

            // Fetching value using key
            String value = map.get(key);

            System.out.println("Key : " + key + " -> Value : " + value);
        }

        /*
        Key Observations:
        - HashMap stores data as key-value pairs
        - Keys are unique
        - Values can be duplicate
        - Iteration order is not guaranteed
        - get(key) retrieves value using key
        */
    }
}