package com.core.java.collection_framework.concurrent_collection.copy_on_write_array_list;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample2 {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Initial List: " + list);

        /*
         * ITERATOR BEHAVIOR IN CopyOnWriteArrayList:
         * ------------------------------------------
         * 1. When iterator is created, it takes a SNAPSHOT COPY of the array.
         *
         *    snapshot = [10, 20, 30, 40]
         *
         * 2. Iterator always works on this snapshot only.
         *
         * 3. Any modification (add/remove) on original list:
         *    - Creates a NEW array internally
         *    - Does NOT affect existing iterator snapshot
         *
         * 4. Therefore:
         *    - Iterator does NOT see modifications
         *    - No ConcurrentModificationException occurs
         */

        for (Integer i : list) {

            System.out.println("Reading: " + i);

            if (i == 20) {

                /*
                 * REMOVE OPERATION:
                 * ------------------
                 * Removes element from current list by creating a NEW array.
                 *
                 * old array: [10, 20, 30, 40]
                 * new array: [10, 30, 40]
                 *
                 * Iterator still uses OLD snapshot:
                 * [10, 20, 30, 40]
                 */
                list.remove(i);

                /*
                 * ADD OPERATION:
                 * --------------
                 * Adds element 50 by creating another NEW array internally.
                 *
                 * previous array: [10, 30, 40]
                 * new array:      [10, 30, 40, 50]
                 *
                 * IMPORTANT:
                 * Iterator does NOT see this change because it is
                 * working on the SNAPSHOT created before iteration started.
                 */
                list.add(50);

                System.out.println("Removed: " + i);
            }
        }

        System.out.println("Final List: " + list);
    }
}