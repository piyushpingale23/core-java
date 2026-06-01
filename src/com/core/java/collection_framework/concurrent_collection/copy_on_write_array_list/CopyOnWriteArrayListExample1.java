package com.core.java.collection_framework.concurrent_collection.copy_on_write_array_list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample1 {

    public static void main(String[] args) {

        /*
         * CopyOnWriteArrayList Concept:
         * -----------------------------
         * 1. Iterator works on SNAPSHOT copy of the array.
         * 2. Iterator is READ-ONLY.
         * 3. Any structural modification via iterator is NOT allowed.
         * 4. Hence itr.remove() throws UnsupportedOperationException.
         */

        CopyOnWriteArrayList<Integer> list =
                new CopyOnWriteArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("List: " + list);

        /*
         * Iterator created on SNAPSHOT:
         * snapshot = [10, 20, 30]
         */
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {

            Integer i = itr.next();
            System.out.println("Reading: " + i);

            /*
             * NOT SUPPORTED IN CopyOnWriteArrayList
             *
             * Reason:
             * Iterator is read-only and works on snapshot copy.
             * It does not modify actual list or snapshot.
             *
             * So calling remove() is forbidden.
             */
            if (i == 20) {
                itr.remove();  // Throws UnsupportedOperationException
            }
        }

        System.out.println("Final List: " + list);
    }
}