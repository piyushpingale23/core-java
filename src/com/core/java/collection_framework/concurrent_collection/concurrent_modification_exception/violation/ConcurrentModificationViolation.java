package com.core.java.collection_framework.concurrent_collection.concurrent_modification_exception.violation;

import java.util.ArrayList;

public class ConcurrentModificationViolation {

    public static void main(String[] args) {

        /*
         * ==========================================================
         * ConcurrentModificationException (Fail-Fast Behavior)
         * ==========================================================
         *
         * ArrayList is a Fail-Fast Collection.
         *
         * Enhanced for-loop internally uses an Iterator.
         *
         * Internally:
         *
         * Iterator<Integer> itr = list.iterator();
         * while (itr.hasNext()) {
         *     Integer i = itr.next();
         * }
         *
         * ----------------------------------------------------------
         * What is modCount?
         * ----------------------------------------------------------
         *
         * modCount = Modification Count
         *
         * It is an internal counter maintained by ArrayList.
         *
         * Every structural modification increments modCount.
         *
         * Structural Modifications:
         * ------------------------
         * add()
         * remove()
         * clear()
         * addAll()
         *
         * Example:
         *
         * list.add(10);  modCount = 1
         * list.add(20);  modCount = 2
         * list.add(30);  modCount = 3
         * list.add(40);  modCount = 4
         *
         * ----------------------------------------------------------
         * What happens when Iterator is created?
         * ----------------------------------------------------------
         *
         * Iterator stores current modCount value in its own variable:
         *
         * expectedModCount = modCount;
         *
         * Example:
         *
         * List = [10,20,30,40]
         * modCount = 4
         *
         * Iterator created:
         *
         * expectedModCount = 4
         *
         * Current State:
         *
         * ArrayList               Iterator
         * ---------               --------
         * modCount = 4       ==   expectedModCount = 4
         *
         * Both are synchronized.
         *
         * ----------------------------------------------------------
         * Runtime Flow
         * ----------------------------------------------------------
         *
         * Iteration #1
         *
         * i = 10
         *
         * check:
         * modCount = 4
         * expectedModCount = 4
         *
         * 4 == 4  --> Continue
         *
         * Output:
         * Element: 10
         *
         *
         * ----------------------------------------------------------
         * Iteration #2
         * ----------------------------------------------------------
         *
         * i = 20
         *
         * check:
         * modCount = 4
         * expectedModCount = 4
         *
         * 4 == 4 --> Continue
         *
         * Output:
         * Element: 20
         *
         *
         * ----------------------------------------------------------
         * Structural Modification
         * ----------------------------------------------------------
         *
         * list.add(50);
         *
         * List becomes:
         *
         * [10,20,30,40,50]
         *
         * modCount increases:
         *
         * modCount = 5
         *
         * But Iterator is unaware of this change.
         *
         * expectedModCount remains:
         *
         * expectedModCount = 4
         *
         * Current State:
         *
         * ArrayList               Iterator
         * ---------               --------
         * modCount = 5       !=   expectedModCount = 4
         *
         * OUT OF SYNC !!!
         *
         *
         * ----------------------------------------------------------
         * Next Iteration
         * ----------------------------------------------------------
         *
         * Before returning next element,
         * Iterator performs:
         *
         * if (modCount != expectedModCount)
         *      throw new ConcurrentModificationException();
         *
         * Check:
         *
         * modCount = 5
         * expectedModCount = 4
         *
         * 5 != 4
         *
         * Result:
         *
         * ConcurrentModificationException
         *
         *
         * ----------------------------------------------------------
         * Output
         * ----------------------------------------------------------
         *
         * Element: 10
         * Element: 20
         *
         * Exception in thread "main"
         * java.util.ConcurrentModificationException
         *
         *
         * ----------------------------------------------------------
         * Important Interview Point
         * ----------------------------------------------------------
         *
         * ConcurrentModificationException can occur even
         * in a SINGLE-THREADED environment.
         *
         * Multiple threads are NOT required.
         *
         * The exception occurs because:
         *
         * Iterator expected:
         * expectedModCount = 4
         *
         * Actual collection state:
         * modCount = 5
         *
         * Iterator detects inconsistency and fails immediately.
         *
         * This behavior is called FAIL-FAST.
         *
         * Rule:
         *
         * expectedModCount == modCount  --> Continue
         *
         * expectedModCount != modCount  --> CME
         *
         * ==========================================================
         */

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        for (Integer i : list) {

            System.out.println("Element: " + i);

            if (i == 20) {
                list.add(50); // Structural modification
            }
        }
    }
}