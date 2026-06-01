package com.core.java.collection_framework.concurrent_collection.copy_on_write_array_list.compliance;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListCompliance {

    public static void main(String[] args) {

        /*
         * COMPLIANCE CASE:
         * -----------------
         * CopyOnWriteArrayList is best suited for:
         * - Read-heavy operations
         * - Iteration during concurrent modification
         * - Listener / observer patterns
         *
         * Benefit:
         * Iterator works on snapshot → NO ConcurrentModificationException
         */

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("Java");
        list.add("Spring");
        list.add("Hibernate");

        // Safe iteration
        for (String tech : list) {

            System.out.println("Reading: " + tech);

            /*
             * COMPLIANT:
             * Adding elements during iteration is safe
             * because iterator works on snapshot copy.
             */
            list.add("Docker");
        }

        System.out.println("Final List: " + list);
    }
}
