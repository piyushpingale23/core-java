package com.core.java.collection_framework.list.linkedlist;

import java.util.LinkedList;

/*
========================================================
Problem Statement:
Demonstrate important LinkedList methods with examples.

Methods covered:
- add()
- addFirst()
- addLast()
- get()
- getFirst()
- getLast()
- remove()
- removeFirst()
- removeLast()
- contains()
- size()
- clear()

========================================================
Objective:
- Understand LinkedList as List + Deque
- Learn frequently used methods
- Understand behavior of head/tail operations
========================================================
*/

public class LinkedListMethods {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        /*
        =========================
        add()
        =========================
        */
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("After add(): " + list);

        /*
        =========================
        addFirst() / addLast()
        =========================
        */
        list.addFirst(5);   // insert at beginning
        list.addLast(40);   // insert at end

        System.out.println("After addFirst & addLast: " + list);

        /*
        =========================
        get(), getFirst(), getLast()
        =========================
        */
        System.out.println("get(2): " + list.get(2));
        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast(): " + list.getLast());

        /*
        =========================
        remove()
        =========================
        */
        list.remove(); // removes first element

        System.out.println("After remove(): " + list);

        /*
        =========================
        removeFirst(), removeLast()
        =========================
        */
        list.removeFirst();
        list.removeLast();

        System.out.println("After removeFirst & removeLast: " + list);

        /*
        =========================
        contains()
        =========================
        */
        System.out.println("Contains 20? " + list.contains(20));

        /*
        =========================
        size()
        =========================
        */
        System.out.println("Size: " + list.size());

        /*
        =========================
        clear()
        =========================
        */
        list.clear();

        System.out.println("After clear(): " + list);
    }
}