package com.core.java.collection_framework.comparable;

import java.util.Set;
import java.util.TreeSet;

/*
========================================================
Problem Statement:
Create a TreeSet of Employee objects and sort them using
Comparable interface based on id and name.

Observe:
- sorting behavior
- duplicate handling based on compareTo()
- TreeSet internal working using Comparable

========================================================
Objective:
- Understand Comparable with custom class
- Learn TreeSet sorting mechanism
- Understand how compareTo affects uniqueness
========================================================
*/

public class Comparable3 {

    public static void main(String[] args) {

        // TreeSet internally uses Red-Black Tree
        // Sorting is done using compareTo() method

        Set<Employee> set = new TreeSet<>();

        Employee e1 = new Employee(1, "A");
        Employee e2 = new Employee(4, "X");
        Employee e3 = new Employee(7, "B");
        Employee e4 = new Employee(2, "W");
        Employee e5 = new Employee(1, "L");

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        // Printing final TreeSet
        System.out.println(set);

        /*
        Key Observations:
        - TreeSet stores elements in sorted order
        - Sorting is based on compareTo() logic
        - Duplicate detection is also based on compareTo()
        - If compareTo() returns 0 → treated as duplicate
        */
    }
}

/*
========================================================
Employee class implementing Comparable
========================================================
*/

class Employee implements Comparable<Employee> {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    compareTo logic:
    - returns positive → this object is smaller (for descending order)
    - returns negative → this object is greater
    - 0 → considered duplicate in TreeSet
    */

    public int compareTo(Employee e) {

        // Ascending order based on id
        return (this.id - e.id);

//        // Descending order based on id
//        return (e.id - this.id);

//        // Ascending order based on name
//        return ((this.name).compareTo(e.name));

//        // Descending order based on name
//        return ((e.name).compareTo(this.name));
    }

    public String toString() {
        return "Id: " + id + " & Name: " + name;
    }
}