package com.core.java.collection_framework.logical;

import java.util.*;

/*
 * ===========================
 * CONCEPT: equals() in Java
 * ===========================
 *
 * 1. LIST
 * ---------------------------
 * - Ordered collection
 * - Allows duplicates
 *
 * equals() checks:
 * -> Size must be same
 * -> Elements must be same
 * -> Order must be same
 *
 * Example:
 * [1,2,3] != [1,3,2]
 *
 *
 * 2. SET
 * ---------------------------
 * - Unordered collection (generally)
 * - Stores unique elements only
 *
 * equals() checks:
 * -> Same elements only
 * -> Order does NOT matter
 *
 * Example:
 * [1,2,3] == [3,2,1]
 *
 *
 * 3. MAP
 * ---------------------------
 * - Stores key-value pairs
 *
 * equals() checks:
 * -> Same keys
 * -> Same values for each key
 * -> Order does NOT matter
 *
 * Example:
 * {1=A,2=B,3=C} == {3=C,1=A,2=B}
 *
 */
public class CollectionFramework5 {

    public static void main(String[] args) {

        // ===========================
        // LIST
        // ===========================

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 3, 2);

        System.out.println("======= LIST =======");

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);

        System.out.println("Using equals(): " + list1.equals(list2));

        List<Integer> sortedList1 = new ArrayList<>(list1);
        List<Integer> sortedList2 = new ArrayList<>(list2);

        Collections.sort(sortedList1);
        Collections.sort(sortedList2);

        System.out.println("After Sorting: " + sortedList1.equals(sortedList2));

        // ===========================
        // SET
        // ===========================

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));

        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("\n======= SET =======");

        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);

        System.out.println("Using equals(): " + set1.equals(set2));

        // ===========================
        // MAP
        // ===========================

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");

        System.out.println("\n======= MAP    =======");

        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);

        System.out.println("Using equals(): " + map1.equals(map2));
    }
}