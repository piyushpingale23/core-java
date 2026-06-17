package com.core.java.collection_framework.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/*
========================================================
Problem Statement:
Demonstrate ArrayList operations and iterate elements
using different approaches.

Iteration methods:
- for loop (index-based)
- for-each loop
- Iterator

========================================================
Objective:
- Understand ArrayList basics
- Learn different iteration techniques
- Understand Iterator usage
========================================================
*/

public class ArrayList1 {

    public static void main(String[] args) {

        /*
        ArrayList:
        - Implements List interface
        - Maintains insertion order
        - Allows duplicates
        - Allows null values
        - Dynamic size (resizable array)
        */

        ArrayList<Integer> list = new ArrayList<>();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("ArrayList: " + list);

        /*
        ========================================================
        1. Using for loop (index-based)
           Here, no Iterator object is created by the loop itself.
           because elements are accessed directly by index.
        ========================================================
        */

        System.out.println("\nUsing for loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + " -> " + list.get(i));
        }

        /*
        ========================================================
        2. Using for-each loop
           for-each uses an Iterator internally for collections.
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
        ========================================================
        4. Using Lambda
        ========================================================
        */

        System.out.println("\nUsing Lambda:");
        list.forEach(System.out::println);

        /*
        Key Observations:
        ------------------------------------------------
        1. for loop -> best when index is needed
        2. for-each -> simple and readable
        3. Iterator -> safe removal + legacy-compatible traversal
        */
    }
}