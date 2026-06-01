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

public class HashTable2 {

    public static void main(String[] args) {

        /*
        Hashtable:
        - Legacy class (Java 1.0)
        - Thread-safe (synchronized methods)
        - Does NOT allow null keys or null values
        - Uses hashing for bucket placement
        */

        Hashtable<Test2, String> hashtable = new Hashtable<>();

        /*
        Internal working:
        - Default capacity = 11 (initial bucket size)
        - Index calculation:
              index = hashCode % capacity
        */

        hashtable.put(new Test2(5), "A");   // 5 % 11 = 5
        hashtable.put(new Test2(2), "B");   // 2 % 11 = 2
        hashtable.put(new Test2(6), "C");   // 6 % 11 = 6
        hashtable.put(new Test2(15), "D");  // 15 % 11 = 4
        hashtable.put(new Test2(23), "E");  // 23 % 11 = 1
        hashtable.put(new Test2(16), "F");  // 16 % 11 = 5 → collision with key 5

        System.out.println("Hashtable: " + hashtable);

        /*
        Key Observations:
        ------------------------------------------------
        1. Hashtable uses hashCode() to decide bucket index
        2. Collisions occur when multiple keys map to same index
        3. Collision handling is done internally using linked list / tree (JDK dependent)
        4. Duplicate keys are checked using equals()
        5. If equals() is NOT overridden, object reference comparison is used
        */
    }
}

/*
========================================================
Custom Key Class
========================================================
*/

class Test2 {

    int i;

    Test2(int i) {
        this.i = i;
    }

    /*
    hashCode():
    - Controls bucket placement
    - Here custom logic is applied: i % 9

    IMPORTANT:
    This means actual bucket index depends on:
        (i % 9) % 11
    because Hashtable still applies % capacity internally
    */

    @Override
    public int hashCode() {
        return i % 9;
    }

    /*
    toString():
    - Used for readable output of key in print statement
    */
    @Override
    public String toString() {
        return String.valueOf(i);
    }

    /*
    IMPORTANT NOTE:
    equals() is NOT overridden.

    So:
    - Default Object.equals() is used
    - Comparison is based on reference (==)
    - Logical equality is NOT considered

    */
}