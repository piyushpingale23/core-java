package com.core.java.collection_framework.list.vector;

import java.util.Vector;

/*
========================================================
Problem Statement:
Demonstrate important Vector methods with examples.

Methods covered:
- add()
- addElement()
- insertElementAt()
- get()
- elementAt()
- set()
- setElementAt()
- remove()
- removeElement()
- removeElementAt()
- contains()
- size()
- capacity()
- isEmpty()
- clear()

========================================================
Objective:
- Understand Vector (legacy synchronized List)
- Learn common Vector operations
- Understand capacity vs size concept
========================================================
*/

public class VectorMethods {

    public static void main(String[] args) {

        /*
        Vector:
        - Legacy class (Java 1.0)
        - Implements List interface
        - Synchronized (thread-safe)
        - Dynamic array with capacity growth
        */

        Vector<Integer> vector = new Vector<>();

        /*
        =========================
        add() / addElement()
        =========================
        */
        vector.add(10);
        vector.addElement(20);
        vector.addElement(30);

        System.out.println("After add/addElement: " + vector);

        /*
        =========================
        insertElementAt()
        =========================
        */
        vector.insertElementAt(15, 1);

        System.out.println("After insertElementAt(15,1): " + vector);

        /*
        =========================
        get() / elementAt()
        =========================
        */
        System.out.println("get(2): " + vector.get(2));
        System.out.println("elementAt(2): " + vector.elementAt(2));

        /*
        =========================
        set() / setElementAt()
        =========================
        */
        vector.set(2, 25);
        vector.setElementAt(35, 3);

        System.out.println("After set/setElementAt: " + vector);

        /*
        =========================
        remove()
        =========================
        */
        vector.remove(1); // index based removal

        System.out.println("After remove(1): " + vector);

        /*
        =========================
        removeElement()
        =========================
        */
        vector.removeElement(25);

        System.out.println("After removeElement(25): " + vector);

        /*
        =========================
        removeElementAt()
        =========================
        */
        vector.removeElementAt(0);

        System.out.println("After removeElementAt(0): " + vector);

        /*
        =========================
        contains()
        =========================
        */
        System.out.println("Contains 30? " + vector.contains(30));

        /*
        =========================
        size() & capacity()
        =========================
        */
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());

        /*
        =========================
        isEmpty()
        =========================
        */
        System.out.println("Is Empty? " + vector.isEmpty());

        /*
        =========================
        clear()
        =========================
        */
        vector.clear();

        System.out.println("After clear: " + vector);
        System.out.println("Size after clear: " + vector.size());
        System.out.println("Capacity after clear: " + vector.capacity());
    }
}