package com.core.java.collection_framework.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
========================================================
Problem Statement:
Create a HashMap and store key-value pairs of Integer
and String types.

Perform:
- insertion of entries
- display all entries
- iteration using entrySet()

========================================================
Objective:
- Understand HashMap key-value storage
- Learn entrySet() iteration (best performance way)
- Understand Map.Entry usage
========================================================
*/

public class HashMap3 {

    public static void main(String[] args) {

        /*
        HashMap internally uses:
        - Hash table (array of buckets)
        - Node<K,V> objects

        Properties:
        - Key must be unique
        - Value can be duplicate
        - One null key allowed
        - Multiple null values allowed
        - No ordering guarantee
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
        Iteration using entrySet() (BEST APPROACH)
        ========================================================

        entrySet():
        - returns Set of Map.Entry objects
        - each Entry contains key + value together
        - avoids extra get(key) call (more efficient)
        */

        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println("Key : " + key + " -> Value : " + value);
        }

        /*
        Key Advantages of entrySet():
        --------------------------------
        1. Faster than keySet() + get()
        2. Direct access to key-value pair
        3. Recommended in real-world applications
        */
    }
}