package com.core.java.collection_framework.concurrent_collection.copy_on_write_array_list.violation;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListViolation {

    public static void main(String[] args) {

        /*
         * VIOLATION CASE:
         * ----------------
         * CopyOnWriteArrayList is NOT suitable for:
         * - Frequent writes (add/remove inside loop)
         * - High mutation operations
         *
         * Reason:
         * Every write creates a NEW COPY of the internal array.
         * This leads to:
         * - High memory usage
         * - Poor performance (O(n) per write)
         */

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        for (Integer i : list) {

            System.out.println("Reading: " + i);

            /*
             * VIOLATION:
             * Writing inside iteration causes repeated copying.
             * Iterator works on snapshot, so logic becomes confusing.
             */
            list.add(40);
        }

        System.out.println("Final List: " + list);
    }
}
