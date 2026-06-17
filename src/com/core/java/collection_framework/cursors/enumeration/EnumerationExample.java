package com.core.java.collection_framework.cursors.enumeration;

import java.util.Enumeration;
import java.util.Vector;

/*
========================================================
Problem Statement:
Demonstrate Enumeration interface with Vector and
explain its limitations.

========================================================
Objective:
- Understand Enumeration traversal
- Learn legacy iteration mechanism
- Identify limitations compared to Iterator
========================================================
*/

public class EnumerationExample {

    public static void main(String[] args) {

        /*
        Vector is used because Enumeration works only with:
        - Vector
        - Hashtable
        */

        Vector<Integer> vector = new Vector<>();

        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);

        System.out.println("Vector: " + vector);

        /*
        =========================
        Enumeration creation
        =========================
        */
        Enumeration<Integer> en = vector.elements();

        /*
        =========================
        Traversing using Enumeration
        =========================
        */
        System.out.println("\nUsing Enumeration:");

        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }
}

/*
========================================================
LIMITATIONS OF ENUMERATION
========================================================

1. Read-only traversal
   - Cannot add elements during iteration
   - Cannot remove elements during iteration

2. Only works with legacy classes
   - Vector
   - Stack
   - Hashtable
   (NOT supported by ArrayList, HashMap, etc.)

3. No fail-fast behavior
   - Does not detect concurrent modification

4. Less powerful than Iterator
   - Iterator has remove() method
   - Enumeration has no modification methods

*/