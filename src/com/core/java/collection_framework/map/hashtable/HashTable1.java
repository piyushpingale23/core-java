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

public class HashTable1 {

    public static void main(String[] args) {

        /*
        Hashtable:
        - Legacy class (Java 1.0)
        - Thread-safe (synchronized methods)
        - Does NOT allow null keys or null values
        - Uses hashing for bucket placement
        */

        Hashtable<Test1, String> hashtable = new Hashtable<>();

        /*
        Internal idea:
        - Default capacity = 11 (implementation dependent)
        - Index = hashCode % tableSize
        */

        hashtable.put(new Test1(5), "A");  // 5 % 11 = 5
        hashtable.put(new Test1(2), "B");  // 2 % 11 = 2
        hashtable.put(new Test1(6), "C");  // 6 % 11 = 6
        hashtable.put(new Test1(15), "D"); // 15 % 11 = 4
        hashtable.put(new Test1(23), "E"); // 23 % 11 = 1
        hashtable.put(new Test1(16), "F"); // 16 % 11 = 5 (collision with key 5)

        System.out.println("Hashtable: " + hashtable);

        /*
        Key Observations:
        ------------------------------------------------
        1. Hashtable uses hashCode() to compute bucket index
        2. Collisions are handled internally (linked list / tree in modern JVMs)
        3. Duplicate keys are checked using equals()
        4. No null keys or null values allowed
        */
    }
}

/*
========================================================
Custom Key Class
========================================================
*/

class Test1 {

    int i;

    Test1(int i) {
        this.i = i;
    }

    /*
    hashCode():
    - Used to decide bucket index
    - Here we directly return i
    */

    public int hashCode() {
        return i;
    }

    /*
    toString():
    - Used for printing key in output
    */
    public String toString() {
        return i + "";
    }

    /*
    NOTE (IMPORTANT):
    equals() is NOT overridden here

    So default Object.equals() is used:
    - compares memory reference
    - NOT logical equality

    */
}