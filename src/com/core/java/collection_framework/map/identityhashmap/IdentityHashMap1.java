package com.core.java.collection_framework.map.identityhashmap;

import java.util.HashMap;
import java.util.IdentityHashMap;

/*
========================================================
Problem Statement:
Demonstrate:
- duplicate key handling in HashMap
- duplicate key handling in IdentityHashMap
- return value of put() method

Observe:
- how old values are replaced
- how put() behaves when duplicate keys are inserted

========================================================
Objective:
- Understand HashMap and IdentityHashMap behavior
- Learn put() method return value
- Understand equals() vs == comparison
========================================================
*/

public class IdentityHashMap1 {

    public static void main(String[] args) {

        Integer i1 = 10;
        Integer i2 = 10;

        /*
        ========================================================
        HashMap Example
        ========================================================

        HashMap uses:
        - equals()
        - hashCode()

        for duplicate key identification
        */

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(i1, "A");

        /*
        Duplicate key insertion:
        key = 23 already exists

        Old value: "A"
        New value: "C"

        put() returns:
        - previous(old) value associated with key
        */

        Object cObj = hashMap.put(i2, "C");

        // old value returned
        System.out.println("Returned Old Value : " + cObj);

        // updated map
        System.out.println("HashMap : " + hashMap);

        /*
        ========================================================
        IdentityHashMap Example
        ========================================================

        IdentityHashMap uses:
        - == operator

        for key comparison
        */

        IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();

        identityHashMap.put(i1, "A");

        /*
        Integer caching:
        Values between -128 to 127 are cached.

        So:
        23 == 23 → true

        Hence, old value "A" is replaced with "C"
        */

        identityHashMap.put(i2, "C");

        System.out.println("IdentityHashMap : " + identityHashMap);



        /*
        Key Observations:
        ------------------------------------------------
        HashMap:
        - uses equals()
        - duplicate key replaces old value
        - put() returns old value

        IdentityHashMap:
        - uses ==
        - compares memory references
        - behaves same here due to Integer caching
        */
    }
}