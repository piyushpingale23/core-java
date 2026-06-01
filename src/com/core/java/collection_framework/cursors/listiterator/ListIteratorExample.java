package com.core.java.collection_framework.cursors.listiterator;

import java.util.ArrayList;
import java.util.ListIterator;

/*
========================================================
Problem Statement:
Demonstrate ListIterator interface using ArrayList and
show its capabilities compared to Iterator.

========================================================
Objective:
- Understand ListIterator traversal
- Learn forward and backward iteration
- Learn modification during iteration
========================================================
*/

public class ListIteratorExample {

    public static void main(String[] args) {

        /*
        ListIterator works only with List implementations:
        - ArrayList
        - LinkedList
        - Vector
        */

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original List: " + list);

        /*
        =========================
        Creating ListIterator
        =========================
        */
        ListIterator<Integer> it = list.listIterator();

        /*
        =========================
        Forward Traversal
        =========================
        */
        System.out.println("\nForward Traversal:");

        while (it.hasNext()) {
            Integer value = it.next();
            System.out.println(value);

            /*
            Example modification:
            Replace 20 with 200
            */
            if (value == 20) {
                it.set(200);
            }
        }

        System.out.println("\nAfter forward iteration: " + list);

        /*
        =========================
        Backward Traversal
        =========================
        */
        System.out.println("\nBackward Traversal:");

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }

        /*
        =========================
        Insertion using ListIterator
        =========================
        */
        it = list.listIterator();

        while (it.hasNext()) {
            Integer value = it.next();

            if (value == 30) {
                it.add(35);
            }
        }

        System.out.println("\nAfter insertion: " + list);
    }
}