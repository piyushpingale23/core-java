package com.core.java.collection_framework.generics;

/*
========================================================
TYPE PARAMETER WITH METHOD
========================================================

Concept:
Generic method uses type parameter only for method.

Syntax:
<T> returnType methodName(T value)

--------------------------------------------------------
IMPORTANT POINT
--------------------------------------------------------

Class itself is NOT generic.

Only method becomes generic.

========================================================
*/

public class GenericMethodExample {

    /*
     * Generic Method
     *
     * <T> declares type parameter
     */
    public static <T> void show(T value) {

        System.out.println("Value: " + value);

        System.out.println("Type: " +
                value.getClass().getName());
    }

    public static void main(String[] args) {

        /*
         * Compiler automatically detects type
         */
        show(100);

        show("PPI");

        show(11.5);

        show(true);
    }
}