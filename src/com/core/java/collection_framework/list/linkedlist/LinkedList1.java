package com.core.java.collection_framework.list.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/*
========================================================
Problem Statement:
Demonstrate LinkedList operations and iterate elements
using different approaches.

Iteration methods:
- for loop (index-based)
- for-each loop
- Iterator

========================================================
Objective:
- Understand LinkedList basics
- Learn different iteration techniques
- Understand internal structure difference vs ArrayList
========================================================
*/

public class LinkedList1 {

    public static void main(String[] args) {

        /*
        LinkedList:
        - Implements List and Deque interface
        - Doubly linked list internally
        - Maintains insertion order
        - Allows duplicates
        - Allows null values
        - Better for frequent insert/delete operations
        */

        LinkedList<Integer> list = new LinkedList<>();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("LinkedList: " + list);

        /*
        ========================================================
        1. Using for loop (index-based)
        ========================================================
        Note: LinkedList is slower for get(i) because traversal is O(n)
        */

        System.out.println("\nUsing for loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + " -> " + list.get(i));
        }

        /*
        ========================================================
        2. Using for-each loop
        ========================================================
        */

        System.out.println("\nUsing for-each loop:");
        for (Integer value : list) {
            System.out.println(value);
        }

        /*
        ========================================================
        3. Using Iterator
        ========================================================
        */

        System.out.println("\nUsing Iterator:");
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        /*
        Key Observations:
        ------------------------------------------------
        1. LinkedList supports all List operations
        2. Index-based access is slower than ArrayList
        3. Iterator and for-each are preferred for traversal
        */
    }
}