package com.core.java.collection_framework.map.hashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Problem Statement:
 *
 * Write a Java program to demonstrate different ways of iterating
 * through a HashMap and printing its key-value pairs.
 *
 * Requirements:
 *
 * 1. Create a HashMap<Integer, String>.
 * 2. Insert the following entries:
 *      1 -> A
 *      2 -> B
 *      3 -> C
 *      4 -> D
 *
 * 3. Iterate and print the map entries using:
 *      a) keySet() + Iterator
 *      b) keySet() + Enhanced For Loop
 *      c) keySet() + Lambda Expression (forEach)
 *      d) entrySet() + Enhanced For Loop
 *
 * Expected Learning:
 *
 * - How HashMap stores key-value pairs.
 * - How to retrieve keys using keySet().
 * - How to retrieve key-value pairs using entrySet().
 * - How to use Iterator for traversal.
 * - How to use Lambda Expressions with collections.
 * - Why entrySet() is generally preferred when both key and value are needed.
 */
public class HashMap {

    public static void main(String[] args) {

        Map<Integer, String> map = new java.util.HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");

        System.out.println("Map: " + map);
        System.out.println("---------------------------");

        Set<Integer> keys = map.keySet();

        Iterator<Integer> itr = keys.iterator();
        while ((itr.hasNext())) {
            Integer key = itr.next();
            String value = map.get(key);
            System.out.println("Key1: " + key + " | value1: " + value);
        }
        System.out.println("---------------------------");

        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println("Key2: " + key + " | value2: " + value);
        }
        System.out.println("---------------------------");


        keys.forEach(k -> {
            String value = map.get(k);
            System.out.println("Key3: " + k + " | value3: " + value);
        });
        System.out.println("---------------------------");


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key4: " + entry.getKey() + " | value4: " + entry.getValue());
        }
    }
}
