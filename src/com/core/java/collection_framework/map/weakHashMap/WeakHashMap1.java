package com.core.java.collection_framework.map.weakHashMap;

import java.util.HashMap;
import java.util.WeakHashMap;

/*
========================================================
Problem Statement:
Demonstrate difference between HashMap and WeakHashMap
based on garbage collection behavior of keys.

========================================================
Objective:
- Understand strong vs weak references
- Observe GC-based removal in WeakHashMap
========================================================
*/

public class WeakHashMap1 {

    public static void main(String[] args) throws InterruptedException {

        hashMapDemo();

        weakHashMapDemo();
    }

    private static void hashMapDemo() throws InterruptedException {

        Test t = new Test();

        HashMap<Test, Integer> map = new HashMap<>();
        map.put(t, 10);

        System.out.println("HashMap before null: " + map);

        t = null;

        System.gc();
        Thread.sleep(2000);

        System.out.println("HashMap after GC: " + map);
    }

    private static void weakHashMapDemo() throws InterruptedException {

        Test t = new Test();

        WeakHashMap<Test, Integer> map = new WeakHashMap<>();
        map.put(t, 10);

        System.out.println("WeakHashMap before null: " + map);

        // IMPORTANT: remove strong reference completely (make Test object eligible for GC)
        t = null;

        System.gc();
        Thread.sleep(2000);

        System.out.println("WeakHashMap after GC: " + map);
    }
}

/*
========================================================
WHY WeakHashMap IS WEAK COMPARED TO HashMap
========================================================

We are comparing how HashMap and WeakHashMap handle KEYS
in terms of reference strength and garbage collection.

========================================================
1. HashMap (STRONG REFERENCE)
========================================================

When we do:

    map.put(key, value);

HashMap internally stores a STRONG reference to the key.

Memory concept:

    HashMap  ----->  Key Object  (STRONG REFERENCE)

========================================================
WHAT DOES THIS MEAN?
========================================================

Even if we do:

    t = null;
    System.gc();

The object is STILL NOT eligible for garbage collection
because HashMap is still holding a strong reference.

========================================================
RESULT:
========================================================

- Object stays in memory
- Entry stays in HashMap
- GC will NOT remove it

========================================================
2. WeakHashMap (WEAK REFERENCE)
========================================================

WeakHashMap stores keys using WEAK REFERENCES internally.

Memory concept:

    WeakHashMap ---> WeakReference ---> Key Object

========================================================
WHAT DOES THIS MEAN?
========================================================

If there is NO strong reference pointing to the object:

    t = null;

Then only WeakReference exists.

========================================================
GC BEHAVIOR:
========================================================

When GC runs:

- It detects object is only weakly reachable
- It removes the object from memory
- It automatically removes entry from WeakHashMap

========================================================
RESULT:
========================================================

- Object is eligible for GC
- Entry is removed automatically from map
- Map becomes empty after GC (if no strong reference exists)

========================================================
CORE DIFFERENCE SUMMARY
========================================================

HashMap:
- Uses STRONG references
- Prevents GC
- Manual removal required (map.remove)

WeakHashMap:
- Uses WEAK references
- Does NOT prevent GC
- Auto removal after GC

========================================================
ONE-LINE SUMMARY
========================================================

HashMap holds strong references to keys, so objects
are not garbage collected, while WeakHashMap holds
weak references, allowing GC to automatically remove
entries when keys are no longer strongly reachable.
========================================================
*/