package com.core.java.java_8.functional_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Collection Framework (Comparator Interface)
public class FunctionalInterface1 {

    public static void main(String[] args) {

        // ----------------------------------------------------
        // Problem Statement:
        // Create a list of integers and perform sorting operations:
        // 1. Sort the list in ascending order using default sorting
        // 2. Sort the same list in descending order using Lambda/Comparator
        // ----------------------------------------------------

        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(15);
        list.add(30);
        list.add(10);
        list.add(0);
        list.add(5);

        System.out.println("Before Sorting: " + list);

        // Ascending order (default natural sorting)
        Collections.sort(list);
        System.out.println("Ascending Sorting: " + list);

        // -------------------------------------------
        // Descending order using Comparator (Lambda)
        // -------------------------------------------
        Comparator<Integer> desc = Comparator.reverseOrder();
        list.sort(desc);

//        Comparator<Integer> desc = (a, b) -> (a > b) ? -1 : (a < b) ? 1 : 0;
//        Collections.sort(list, desc);

        System.out.println("Descending Sorting: " + list);
    }
}