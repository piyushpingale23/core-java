package com.core.java.collection_framework.list.arraylist;

import java.util.ArrayList;

/*
========================================================
Problem Statement:
Demonstrate important ArrayList methods with examples.

Methods covered:
- add()
- add(index, element)
- get()
- set()
- remove(index)
- remove(Object)
- contains()
- indexOf()
- lastIndexOf()
- size()
- isEmpty()
- clear()

========================================================
Objective:
- Understand common ArrayList operations
- Learn element manipulation methods
- Understand dynamic array behavior
========================================================
*/

public class ArrayListMethods {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

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
        add(index, element)
        =========================
        */
        list.add(1, 15); // insert at index 1

        System.out.println("After add(1,15): " + list);

        /*
        =========================
        get()
        =========================
        */
        System.out.println("get(2): " + list.get(2));

        /*
        =========================
        set()
        =========================
        */
        list.set(2, 25); // replace element at index 2

        System.out.println("After set(2,25): " + list);

        /*
        =========================
        remove(index)
        =========================
        */
        list.remove(1); // removes element at index 1

        System.out.println("After remove(index 1): " + list);

        /*
        =========================
        remove(Object)
        =========================
        */
        list.remove(Integer.valueOf(25)); // removes value 25

        System.out.println("After remove(Object 25): " + list);

        /*
        =========================
        contains()
        =========================
        */
        System.out.println("Contains 20? :  " + list.contains(20));

        /*
        =========================
        indexOf() / lastIndexOf()
        =========================
        */
        list.add(20);
        list.add(20);

        System.out.println("List after duplicates: " + list);
        System.out.println("indexOf(20): " + list.indexOf(20));
        System.out.println("lastIndexOf(20): " + list.lastIndexOf(20));

        /*
        =========================
        size()
        =========================
        */
        System.out.println("Size: " + list.size());

        /*
        =========================
        isEmpty()
        =========================
        */
        System.out.println("Is Empty? " + list.isEmpty());

        /*
        =========================
        clear()
        =========================
        */
        list.clear();

        System.out.println("After clear(): " + list);
    }
}