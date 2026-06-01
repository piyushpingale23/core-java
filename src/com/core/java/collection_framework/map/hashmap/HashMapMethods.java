package com.core.java.collection_framework.map.hashmap;

import java.util.HashMap;

/*
Problem Statement:
Demonstrate important HashMap methods with examples.

Covered Methods:
- put()
- putIfAbsent()
- get()
- getOrDefault()
- containsKey()
- containsValue()
- remove()
- replace()
- size()
- isEmpty()
- clear()

========================================================
Objective:
- Understand commonly used HashMap methods
- Learn behavior of each method
- Practice real-world usage
========================================================
*/

public class HashMapMethods {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        /*
        =========================
        put()
        =========================
        Returns:
        - old value if key exists
        - null if new key
        */
        System.out.println("put(1,A): " + map.put(1, "A"));
        System.out.println("put(2,B): " + map.put(2, "B"));
        System.out.println("put(3,C): " + map.put(3, "C"));

        /*
        Duplicate key example
        */
        System.out.println("put(3,X): " + map.put(3, "X"));

        System.out.println("Map: " + map);
        System.out.println("-------------------------------------");

        /*
        =========================
        putIfAbsent()
        =========================
        */
        System.out.println("putIfAbsent(3,Z): " + map.putIfAbsent(3, "Z")); // ignored
        System.out.println("putIfAbsent(4,D): " + map.putIfAbsent(4, "D"));
        System.out.println("Map: " + map);// added
        System.out.println("-------------------------------------");

        /*
        =========================
        get()
        =========================
        */
        System.out.println("get(2): " + map.get(2));
        System.out.println("-------------------------------------");

        /*
        =========================
        getOrDefault()
        =========================
        */
        System.out.println("getOrDefault(10,NotFound): " +
                map.getOrDefault(10, "Not Found"));
        System.out.println("-------------------------------------");

        /*
        =========================
        containsKey()
        =========================
        */
        System.out.println("containsKey(1): " + map.containsKey(1));
        System.out.println("-------------------------------------");

        /*
        =========================
        containsValue()
        =========================
        */
        System.out.println("containsValue(B): " + map.containsValue("B"));
        System.out.println("-------------------------------------");

        /*
        =========================
        remove()
        =========================
        */
        System.out.println("remove(2): " + map.remove(2));
        System.out.println("Map: " + map);
        System.out.println("-------------------------------------");

        /*
        =========================
        replace()
        =========================
        */
        System.out.println("replace(3, Y): " + map.replace(3, "Y"));
        System.out.println("Map: " + map);
        System.out.println("-------------------------------------");

        /*
        =========================
        size() & isEmpty()
        =========================
        */
        System.out.println("size: " + map.size());
        System.out.println("isEmpty: " + map.isEmpty());
        System.out.println("-------------------------------------");

        /*
        =========================
        clear()
        =========================
        */
        map.clear();
        System.out.println("After clear: " + map);
    }
}