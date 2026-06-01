package com.core.java.collection_framework.utility.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
========================================================
Problem Statement:
Sort Employee objects using custom Comparator.
========================================================
*/

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}

public class CustomSortingObject {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(2, "Z"));
        list.add(new Employee(1, "A"));
        list.add(new Employee(3, "M"));

        System.out.println("Original: " + list);

        /*
        =========================
        Sort by ID (Ascending)
        =========================
        */
        Collections.sort(list, Comparator.comparingInt(e -> e.id));
//        list.sort(Comparator.comparingInt(e -> e.id));
        System.out.println("Sort by ID Asc: " + list);

        /*
        =========================
        Sort by Name (Ascending)
        =========================
        */
        Collections.sort(list, Comparator.comparing(e -> e.name));
//        list.sort(Comparator.comparing(e -> e.name));
        System.out.println("Sort by Name Asc: " + list);

        /*
        =========================
        Sort by ID (Descending)
        =========================
        */
        Collections.sort(list, (e1, e2) -> e2.id - e1.id);
//        list.sort((e1, e2) -> e2.id - e1.id);
        System.out.println("Sort by ID Desc: " + list);

        /*
        =========================
        Sort by Name (Descending)
        =========================
        */
        Collections.sort(list, (e1, e2) -> (e2.name).compareTo(e1.name));
//        list.sort((e1, e2) -> (e2.name).compareTo(e1.name));
        System.out.println("Sort by Name Desc: " + list);
    }
}