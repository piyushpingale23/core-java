package com.core.java.collection_framework.generics;

import java.util.ArrayList;
import java.util.List;

/*
========================================================
WILDCARD CHARACTER (?) IN GENERICS
========================================================

Concept:
? is called Wildcard Character in Java Generics.

It represents:
"Unknown Type"

--------------------------------------------------------
WHY WE USE WILDCARD?
--------------------------------------------------------

Suppose we have:

List<Integer>
List<String>
List<Double>

If method should accept ALL types of lists,
then using specific type is not possible.

Example:
void show(List<Integer> list)

This accepts only Integer list.

To make method generic for all list types:

void show(List<?> list)

Now method accepts:
- List<Integer>
- List<String>
- List<Double>
- List<Boolean>

--------------------------------------------------------
IMPORTANT POINT
--------------------------------------------------------

? means:
"I don't know the exact type"

So:
- Reading is allowed
- Adding objects is mostly NOT allowed

Because compiler does not know actual type.

========================================================
*/

public class WildCardExample {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);

        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("B");

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(11.5);
        doubleList.add(22.5);

        /*
         * Same method accepts all list types
         */
        show(intList);
        show(strList);
        show(doubleList);
    }

    /*
     * Wildcard method
     * Accepts any type of List
     */
    public static void show(List<?> list) {

        System.out.println(list);

        /*
         * Allowed:
         * Reading objects
         */
        for (Object obj : list) {
            System.out.println(obj);
        }

        /*
         * NOT allowed:
         * list.add(10);
         * list.add("A");
         *
         * Reason:
         * Actual type is unknown
         */
    }
}