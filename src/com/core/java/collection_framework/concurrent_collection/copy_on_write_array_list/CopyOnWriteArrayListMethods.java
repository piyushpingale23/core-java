package com.core.java.collection_framework.concurrent_collection.copy_on_write_array_list;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListMethods {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Initial List : " + list);

        /*
         * addIfAbsent(E e)
         * ----------------
         * Adds the element only if it is not already present.
         *
         * Returns:
         * true  -> element added
         * false -> element already exists
         */

        boolean result1 = list.addIfAbsent("D");
        boolean result2 = list.addIfAbsent("A");

        System.out.println("\nAfter addIfAbsent()");
        System.out.println("Added D : " + result1);
        System.out.println("Added A : " + result2);
        System.out.println("List    : " + list);

        /*
         * addAllAbsent(Collection<? extends E> c)
         * ---------------------------------------
         * Adds all elements that are not already
         * present in the list.
         *
         * Returns:
         * Number of elements actually added.
         */

        int addedCount = list.addAllAbsent(Arrays.asList("A", "B", "E", "F", "G", "E"));

        System.out.println("\nAfter addAllAbsent()");
        System.out.println("Elements Added : " + addedCount);
        System.out.println("List           : " + list);
    }
}