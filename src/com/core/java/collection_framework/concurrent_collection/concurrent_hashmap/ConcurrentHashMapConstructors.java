package com.core.java.collection_framework.concurrent_collection.concurrent_hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapConstructors {

    public static void main(String[] args) {

        /*
         * ==========================================================
         * ConcurrentHashMap Constructors
         * ==========================================================
         *
         * ConcurrentHashMap is a thread-safe implementation of
         * ConcurrentMap.
         *
         * It allows multiple threads to perform read and write
         * operations concurrently with better performance than
         * Hashtable.
         *
         * Commonly used constructors:
         *
         * 1. ConcurrentHashMap()
         * 2. ConcurrentHashMap(int initialCapacity)
         * 3. ConcurrentHashMap(int initialCapacity,
         *                      float loadFactor)
         * 4. ConcurrentHashMap(Map<? extends K, ? extends V> m)
         *
         * NOTE:
         * Older Java versions also had:
         *
         * ConcurrentHashMap(int initialCapacity,
         *                   float loadFactor,
         *                   int concurrencyLevel)
         *
         * In modern Java versions, concurrencyLevel is mostly
         * ignored internally and is retained mainly for
         * backward compatibility.
         *
         * ==========================================================
         */


        /*
         * ==========================================================
         * 1. Default Constructor
         * ==========================================================
         *
         * Creates an empty ConcurrentHashMap with default settings.
         *
         * Syntax:
         *
         * ConcurrentHashMap()
         */

        ConcurrentHashMap<Integer, String> map1 =
                new ConcurrentHashMap<>();

        map1.put(101, "John");
        map1.put(102, "David");

        System.out.println("Default Constructor");
        System.out.println(map1);


        /*
         * ==========================================================
         * 2. Constructor with Initial Capacity
         * ==========================================================
         *
         * Syntax:
         *
         * ConcurrentHashMap(int initialCapacity)
         *
         * Creates a map with specified initial capacity.
         *
         * Useful when we know approximately how many entries
         * will be inserted.
         *
         * This helps reduce resizing operations.
         */

        ConcurrentHashMap<Integer, String> map2 =
                new ConcurrentHashMap<>(100);

        map2.put(201, "Scott");
        map2.put(202, "Martin");

        System.out.println("\nInitial Capacity Constructor");
        System.out.println(map2);


        /*
         * ==========================================================
         * 3. Constructor with Initial Capacity and Load Factor
         * ==========================================================
         *
         * Syntax:
         *
         * ConcurrentHashMap(int initialCapacity,
         *                   float loadFactor)
         *
         * initialCapacity
         *      Initial storage size.
         *
         * loadFactor
         *      Determines when resizing should occur.
         *
         * Default load factor in most hash-based collections:
         *
         *      0.75
         *
         * Example:
         *
         * Capacity = 100
         * Load Factor = 0.75
         *
         * Resize Threshold:
         *
         * 100 × 0.75 = 75
         *
         * After 75 entries, resizing may occur.
         */

        ConcurrentHashMap<Integer, String> map3 =
                new ConcurrentHashMap<>(100, 0.75f);

        map3.put(301, "A");
        map3.put(302, "B");

        System.out.println("\nInitial Capacity + Load Factor");
        System.out.println(map3);


        /*
         * ==========================================================
         * 4. Constructor with Existing Map
         * ==========================================================
         *
         * Syntax:
         *
         * ConcurrentHashMap(Map<? extends K,
         *                   ? extends V> m)
         *
         * Creates a ConcurrentHashMap and copies all entries
         * from the supplied map.
         */

        Map<Integer, String> existingMap =
                new HashMap<>();

        existingMap.put(401, "Ravi");
        existingMap.put(402, "Priya");

        ConcurrentHashMap<Integer, String> map4 =
                new ConcurrentHashMap<>(existingMap);

        System.out.println("\nConstructor with Existing Map");
        System.out.println(map4);


        /*
         * ==========================================================
         * 5. Constructor with Initial Capacity,
         *    Load Factor and Concurrency Level
         * ==========================================================
         *
         * Syntax:
         *
         * ConcurrentHashMap(int initialCapacity,
         *                   float loadFactor,
         *                   int concurrencyLevel)
         *
         * concurrencyLevel:
         * -----------------
         * Indicates expected number of threads that may update
         * the map concurrently.
         *
         * Historical Background:
         * ----------------------
         * Before Java 8, ConcurrentHashMap internally used
         * Segmented Locking.
         *
         * Example:
         *
         * concurrencyLevel = 16
         *
         * Internally:
         *
         * Segment-1
         * Segment-2
         * Segment-3
         * ...
         * Segment-16
         *
         * Different threads could lock different segments
         * simultaneously.
         *
         * Java 8+:
         * --------
         * Segment architecture was removed.
         *
         * CAS + synchronized bucket locking is used internally.
         *
         * Therefore concurrencyLevel has very little practical
         * effect in modern Java versions.
         */

        ConcurrentHashMap<Integer, String> map5 =
                new ConcurrentHashMap<>(100, 0.75f, 16);

        map5.put(501, "X");
        map5.put(502, "Y");

        System.out.println("\nInitial Capacity + Load Factor + Concurrency Level");
        System.out.println(map5);


        /*
         * ==========================================================
         * Summary
         * ==========================================================
         *
         * 1. ConcurrentHashMap()
         *    -> Default constructor
         *
         * 2. ConcurrentHashMap(int initialCapacity)
         *    -> Specify initial capacity
         *
         * 3. ConcurrentHashMap(int initialCapacity,
         *                      float loadFactor)
         *    -> Specify capacity and load factor
         *
         * 4. ConcurrentHashMap(Map m)
         *    -> Create map from existing map
         *
         * 5. ConcurrentHashMap(int initialCapacity,
         *                      float loadFactor,
         *                      int concurrencyLevel)
         *    -> Legacy constructor
         *    -> Important mainly for Java 7 and earlier
         *
         * ==========================================================
         */
    }
}