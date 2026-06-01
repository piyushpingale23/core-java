package com.core.java.collection_framework.utility.arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
========================================================
Problem Statement:
Demonstrate Arrays utility class binarySearch() methods.

========================================================
Objective:
1. binarySearch(primitive[] array, target)
2. binarySearch(Object[] array, target)
3. binarySearch(Object[] array, target, Comparator c)

========================================================
Important:
- Array MUST be sorted before binarySearch()
- If element found:
      returns index
- If element not found:
      returns -(insertionPoint + 1)

========================================================
*/

class Employee implements Comparable<Employee> {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Natural sorting based on id
    @Override
    public int compareTo(Employee e) {
        return this.id - e.id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class EmployeeNameComparator implements Comparator<Employee> {

    // Custom sorting based on name
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}

public class ArraysSearching {

    public static void main(String[] args) {

        /*
        ========================================================
        1. binarySearch(primitive[] array, target)
        ========================================================
        */

        int[] numbers = {40, 10, 50, 20, 30};

        // Array must be sorted
        Arrays.sort(numbers);

        System.out.println("Primitive Array: " + Arrays.toString(numbers));

        int index1 = Arrays.binarySearch(numbers, 30);

        System.out.println("30 found at index: " + index1);



        /*
        ========================================================
        2. binarySearch(Object[] array, target)
        ========================================================
        Uses Comparable interface
        ========================================================
        */

        Employee[] employees = {
                new Employee(103, "Rahul"),
                new Employee(101, "Amit"),
                new Employee(102, "Neha")
        };

        // Sort using Comparable
        Arrays.sort(employees);

        System.out.println("\nEmployee Array Sorted By ID: " + Arrays.toString(employees));

        int index2 = Arrays.binarySearch(employees, new Employee(102, "Neha"));

        System.out.println("Neha Employee found at index: " + index2);



        /*
        ========================================================
        3. binarySearch(Object[] array, target, Comparator c)
        ========================================================
        Uses Comparator interface
        ========================================================
        */

        // Sort using Comparator
        Arrays.sort(employees, new EmployeeNameComparator());

        System.out.println("\nEmployee Array Sorted By Name: " + Arrays.toString(employees));

        int index3 = Arrays.binarySearch(employees, new Employee(101, "Amit"), new EmployeeNameComparator());

        System.out.println("Amit Employee found at index: " + index3);
    }
}
