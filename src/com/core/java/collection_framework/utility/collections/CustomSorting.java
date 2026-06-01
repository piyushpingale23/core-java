package com.core.java.collection_framework.utility.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
========================================================
Problem Statement:
Demonstrate custom sorting using Comparator.
========================================================
*/

public class CustomSorting {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(40);
        list.add(10);
        list.add(30);
        list.add(20);

        System.out.println("Original: " + list);

        /*
        Ascending Order //by default
        */
        Collections.sort(list);
        System.out.println("Ascending: " + list);

        /*
        Descending Order
        */
        Collections.sort(list, (a, b) -> b - a);
        System.out.println("Descending: " + list);
    }
}