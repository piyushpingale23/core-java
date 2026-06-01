package com.core.java.collection_framework.generics;

/*
========================================================
TYPE PARAMETER WITH CLASS
========================================================

Concept:
Generic class uses type parameter at class level.

Syntax:
class ClassName<T>

Here:
- T becomes available to entire class
- Fields, constructors, methods can use T

========================================================
*/

class Box<T> {

    /*
     * T is used as data type
     */
    private T item;

    /*
     * Constructor accepts T type
     */
    Box(T item) {
        this.item = item;
    }

    /*
     * Method returns T type
     */
    public T getItem() {
        return item;
    }

    /*
     * Display runtime type
     */
    public void showType() {
        System.out.println("Type: " +
                item.getClass().getName());
    }
}

public class GenericClassExample {

    public static void main(String[] args) {

        /*
         * T becomes Integer
         */
        Box<Integer> b1 = new Box<>(100);

        /*
         * T becomes String
         */
        Box<String> b2 = new Box<>("PPI");

        b1.showType();
        b2.showType();

        System.out.println(b1.getItem());
        System.out.println(b2.getItem());
    }
}