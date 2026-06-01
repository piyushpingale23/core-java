package com.core.java.collection_framework.utility.arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
========================================================
Problem Statement:
Demonstrate Arrays utility class sorting methods.

========================================================
Objective:
1. sort(primitive[] p)
2. sort(Object[] o)
3. sort(Object[] o, Comparator c)

========================================================
*/

class Student implements Comparable<Student> {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Natural sorting based on id
    @Override
    public int compareTo(Student s) {
        return this.id - s.id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class StudentNameComparator implements Comparator<Student> {

    // Custom sorting based on name
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

public class ArraysSorting {

    public static void main(String[] args) {

        /*
        ========================================================
        1. sort(primitive[] p)
        ========================================================
        */

        int[] numbers = {50, 10, 40, 20, 30};

        System.out.println("Before primitive sorting: " + Arrays.toString(numbers));

        Arrays.sort(numbers);

        System.out.println("After primitive sorting: " + Arrays.toString(numbers));
        System.out.println();



        /*
        ========================================================
        2. sort(Object[] o)
        ========================================================
        Uses Comparable interface
        ========================================================
        */

        Student[] students = {
                new Student(103, "Rahul"),
                new Student(101, "Amit"),
                new Student(102, "Neha")
        };

        System.out.println("\nBefore object sorting: " + Arrays.toString(students));

        Arrays.sort(students);

        System.out.println("After object sorting (by id): " + Arrays.toString(students));



        /*
        ========================================================
        3. sort(Object[] o, Comparator c)
        ========================================================
        Uses Comparator interface
        ========================================================
        */

        Arrays.sort(students, new StudentNameComparator());

        System.out.println("After object sorting (by name): " + Arrays.toString(students));
    }
}
