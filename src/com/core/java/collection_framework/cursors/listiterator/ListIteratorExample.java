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
        ListIterator<Integer> itr = list.listIterator();

        /*
        =========================
        Forward Traversal
        =========================
        */
        System.out.println("\nForward Traversal:");

        while (itr.hasNext()) {
            Integer value = itr.next();
            System.out.println(value);

            /*
            Example modification:
            Replace 20 with 200
            */
            if (value == 20) {
                itr.set(200);
            }
        }

        System.out.println("\nAfter forward iteration: " + list);

        /*
        =========================
        Backward Traversal
        =========================
        */
        System.out.println("\nBackward Traversal:");

        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }

        /*
        =========================
        Insertion using ListIterator
        =========================
        */
        itr = list.listIterator();

        while (itr.hasNext()) {
            Integer value = itr.next();

            if (value == 30) {
                itr.add(35);
            }
        }

        System.out.println("\nAfter insertion: " + list);
    }
}