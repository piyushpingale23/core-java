package com.core.java.collection_framework.concurrent_collection.concurrent_map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapMethods {

    public static void main(String[] args) {

        /*
         * ==========================================================
         * ConcurrentMap Special Methods
         * ==========================================================
         *
         * ConcurrentMap extends Map and provides additional
         * atomic operations for thread-safe updates.
         *
         * Important Methods:
         *
         * 1. putIfAbsent()
         * 2. remove(key, value)
         * 3. replace(key, oldValue, newValue)
         *
         * ==========================================================
         */

        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(101, "John");
        map.put(102, "David");

        System.out.println("Initial Map : " + map);

        /*
         * ==========================================================
         * 1. putIfAbsent()
         * ==========================================================
         *
         * Adds entry only if key is not already present.
         */

        System.out.println("\n---- putIfAbsent() ----");

        map.putIfAbsent(103, "Scott");

        System.out.println("After adding key 103 : " + map);

        /*
         * Key 101 already exists.
         * Therefore, entry will not be replaced.
         */

        map.putIfAbsent(101, "James");

        System.out.println("After putIfAbsent(101, James) : " + map);

        /*
         * Visualization:
         *
         * Before:
         * 101 -> John
         *
         * putIfAbsent(101, James)
         *
         * Since key 101 already exists,
         * value remains John.
         */

        /*
         * ==========================================================
         * 2. remove(key, value)
         * ==========================================================
         *
         * Removes entry only when both key and value match.
         */

        System.out.println("\n---- remove(key,value) ----");

        boolean removed1 = map.remove(102, "David");

        System.out.println("Removed ? " + removed1);
        System.out.println(map);

        /*
         * Key exists but value does not match.
         */

        boolean removed2 = map.remove(101, "James");

        System.out.println("Removed ? " + removed2);
        System.out.println(map);

        /*
         * Visualization:
         *
         * Map:
         * 101 -> John
         *
         * remove(101, James)
         *
         * Key matched
         * Value matched
         *
         * Therefore, not removed.
         */

        /*
         * ==========================================================
         * 3. replace(key, oldValue, newValue)
         * ==========================================================
         *
         * Replaces value only if key and oldValue match.
         */

        System.out.println("\n---- replace() ----");

        boolean replaced1 = map.replace(101, "John", "James");

        System.out.println("Replaced ? " + replaced1);
        System.out.println(map);

        /*
         * Old value does not match.
         */

        boolean replaced2 = map.replace(101, "David", "Mike");

        System.out.println("Replaced ? " + replaced2);
        System.out.println(map);

        /*
         * Visualization:
         *
         * Before:
         * 101 -> James
         *
         * replace(101, David, Mike)
         *
         * Key matched
         * Old value matched
         *
         * Therefore, replacement fails.
         */

        /*
         * ==========================================================
         * Final Map
         * ==========================================================
         */

        System.out.println("\nFinal Map : " + map);
    }
}