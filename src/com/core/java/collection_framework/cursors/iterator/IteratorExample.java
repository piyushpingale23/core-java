package com.core.java.collection_framework.cursors.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/*
========================================================
Problem Statement:
Demonstrate Iterator interface with ArrayList and
explain its limitations.

========================================================
Objective:
- Understand Iterator traversal
- Learn fail-fast behavior
- Identify limitations of Iterator
========================================================
*/

public class IteratorExample {

    public static void main(String[] args) {

        /*
        Iterator works with all Collection classes:
        - ArrayList
        - LinkedList
        - HashSet
        - etc.
        */

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("List: " + list);

        /*
        =========================
        Creating Iterator
        =========================
        */
        Iterator<Integer> it = list.iterator();

        /*
        =========================
        Traversing using Iterator
        =========================
        */
        System.out.println("\nUsing Iterator:");

        while (it.hasNext()) {
            Integer value = it.next();

            System.out.println(value);

            /*
            Example of safe removal:
            Removes element 20 during iteration
            */
            if (value == 20) {
                it.remove();
            }
        }

        System.out.println("\nAfter iteration (after remove): " + list);
    }
}

/*
========================================================
LIMITATIONS OF ITERATOR
========================================================

1. Single-direction traversal
   - Only forward movement
   - Cannot move backward (no previous())

2. Only one-time use
   - Once iterator completes, it cannot be reused

3. No index access
   - Cannot access elements by index (like get(i))

4. No replacement/update method
   - Cannot directly replace elements (no set() method)

5. Fail-fast behavior
   - If collection is modified outside iterator,
     it throws ConcurrentModificationException

========================================================
MODERN ALTERNATIVE
========================================================

- ListIterator (for bidirectional traversal)
- forEach loop (simpler but less control)
*/