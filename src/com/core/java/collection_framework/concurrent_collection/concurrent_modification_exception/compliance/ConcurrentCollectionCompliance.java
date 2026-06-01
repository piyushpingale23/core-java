package com.core.java.collection_framework.concurrent_collection.concurrent_modification_exception.compliance;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionCompliance {

    public static void main(String[] args) {

        /*
         * ==========================================================
         * CopyOnWriteArrayList (Fail-Safe Behavior)
         * ==========================================================
         *
         * CopyOnWriteArrayList is a Concurrent Collection.
         *
         * Unlike ArrayList, it does NOT use the Fail-Fast mechanism.
         *
         * Therefore:
         *
         * - No ConcurrentModificationException
         * - Safe for concurrent modifications during iteration
         *
         * ----------------------------------------------------------
         * How does CopyOnWriteArrayList work?
         * ----------------------------------------------------------
         *
         * Whenever a write operation occurs:
         *
         * add()
         * remove()
         * set()
         * clear()
         *
         * CopyOnWriteArrayList creates a NEW COPY of the
         * underlying array and performs the modification on
         * the new copy.
         *
         * Existing Iterators continue working on the OLD copy.
         *
         * Hence, no inconsistency occurs.
         *
         * ----------------------------------------------------------
         * Initial State
         * ----------------------------------------------------------
         */

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        /*
         * Current List:
         *
         * [10, 20, 30, 40]
         *
         * Internal Array Snapshot:
         *
         * Array-A
         * ----------------
         * [10,20,30,40]
         */

        /*
         * Enhanced for-loop internally creates an Iterator.
         *
         * Iterator<Integer> itr = list.iterator();
         *
         * IMPORTANT:
         *
         * The Iterator takes a SNAPSHOT of the collection
         * at the time it is created.
         *
         * Snapshot:
         *
         * [10,20,30,40]
         */

        for (Integer i : list) {

            /*
             * Iteration #1
             *
             * Snapshot:
             * [10,20,30,40]
             *
             * i = 10
             */

            if (i == 20) {

                /*
                 * Iteration #2
                 *
                 * i = 20
                 *
                 * Now we add 50.
                 */

                list.add(50);

                /*
                 * What happens internally?
                 *
                 * OLD ARRAY
                 * ----------------
                 * [10,20,30,40]
                 *
                 * NEW ARRAY CREATED
                 * ----------------
                 * [10,20,30,40,50]
                 *
                 * list reference now points
                 * to the NEW ARRAY.
                 *
                 * But the Iterator still points
                 * to the OLD SNAPSHOT:
                 *
                 * [10,20,30,40]
                 *
                 * Therefore:
                 *
                 * No ConcurrentModificationException
                 */
            }

            System.out.println("Element: " + i);
        }

        /*
         * Iterator completes traversal of OLD SNAPSHOT.
         *
         * Elements printed:
         *
         * 10
         * 20
         * 30
         * 40
         *
         * Notice:
         *
         * 50 is NOT printed because it was added
         * after the Iterator snapshot was created.
         */

        System.out.println("After iteration: " + list);

        /*
         * Final Output
         * ----------------------------------------------------------
         *
         * Element: 10
         * Element: 20
         * Element: 30
         * Element: 40
         *
         * After iteration: [10, 20, 30, 40, 50]
         *
         *
         * ----------------------------------------------------------
         * Visualization
         * ----------------------------------------------------------
         *
         * Iterator Snapshot
         * -----------------
         * [10,20,30,40]
         *
         *
         * list.add(50)
         *
         *
         * New Internal Array
         * ------------------
         * [10,20,30,40,50]
         *
         *
         * Iterator Still Reading
         * ----------------------
         * [10,20,30,40]
         *
         *
         * Therefore:
         *
         * No ConcurrentModificationException
         *
         * 50 not visible to current Iterator
         *
         * ==========================================================
         */
    }
}