package com.core.java.collection_framework.map.hashtable;

import java.util.Hashtable;

/*
========================================================
Problem Statement:
Demonstrate working of Hashtable with custom key object
and observe hashing mechanism using hashCode().

========================================================
Objective:
- Understand Hashtable internal working
- Learn bucket indexing using hashCode()
- Understand collision handling concept
========================================================
*/

public class HashTable3 {

    public static void main(String[] args) {

        /*
        Hashtable:
        - Legacy class (Java 1.0)
        - Thread-safe (synchronized methods)
        - Does NOT allow null keys or null values
        - Uses hashing for bucket placement
        */

        Hashtable<Test3, String> hashtable = new Hashtable<>(25);

        /*
        IMPORTANT:
        Initial capacity = 25 (NOT 11)

        So actual index calculation is:

            index = hashCode % capacity
                  = hashCode % 25
        */

        hashtable.put(new Test3(5), "A");   // 5 % 25 = 5
        hashtable.put(new Test3(2), "B");   // 2 % 25 = 2
        hashtable.put(new Test3(6), "C");   // 6 % 25 = 6
        hashtable.put(new Test3(15), "D");  // 15 % 25 = 15
        hashtable.put(new Test3(23), "E");  // 23 % 25 = 23
        hashtable.put(new Test3(16), "F");  // 16 % 25 = 16

        System.out.println("Hashtable: " + hashtable);

        /*
        ========================================================
        Key Observations:
        ========================================================

        1. Hashtable uses hashCode() to compute bucket index
        2. Formula:
                index = hashCode % capacity
        3. Collisions occur only if two keys produce same index
        4. Collision handling is internal (linked list / tree)
        5. Duplicate keys are checked using equals()
        6. If equals() is NOT overridden:
                → reference comparison (==) is used
        */
    }
}

/*
========================================================
Custom Key Class
========================================================
*/

class Test3 {

    int i;

    Test3(int i) {
        this.i = i;
    }

    /*
    hashCode():
    - Used for bucket selection
    - Here custom logic: i % 9

    FINAL INDEX FLOW:
        step 1: hashCode = i % 9
        step 2: index = hashCode % 25

    Example:
        i = 16
        hashCode = 16 % 9 = 7
        index = 7 % 25 = 7
    */

    @Override
    public int hashCode() {
        return i % 9;
    }

    /*
    toString():
    - Used for readable output in print statements
    */
    @Override
    public String toString() {
        return String.valueOf(i);
    }

    /*
    IMPORTANT NOTE:
    equals() is NOT overridden.

    So default Object.equals() is used:
    - compares memory reference (==)
    - NOT logical equality

    This means:
    - Two objects with same value are still different keys
      unless they are same reference
    */
}