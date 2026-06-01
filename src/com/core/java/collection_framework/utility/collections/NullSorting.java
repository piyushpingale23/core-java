package com.core.java.collection_framework.utility.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
========================================================
Problem Statement:
Demonstrate sorting of list containing null values and
handle NullPointerException using Comparator.
========================================================
*/

public class NullSorting {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(null);
        list.add(30);
        list.add(20);
        list.add(null);

        System.out.println("Original List: " + list);

        /*
        =========================
        NULL LAST SORT
        =========================
        */

        Collections.sort(list, Comparator.nullsLast(Comparator.naturalOrder()));

        System.out.println("Nulls Last Sorted: " + list);

        /*
        =========================
        NULL FIRST SORT
        =========================
        */

        Collections.sort(list, Comparator.nullsFirst(Comparator.naturalOrder()));

        System.out.println("Nulls First Sorted: " + list);
    }
}