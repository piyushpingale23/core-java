package com.core.java.collection_framework.generics;

/*
========================================================
GENERIC CLASS (UNBOUNDED TYPE PARAMETER)
========================================================

Concept: Generics<T>

This is called an "Unbounded Generic Type".

--------------------------------------------------------
WHAT DOES IT MEAN?
--------------------------------------------------------

T is a placeholder type.

It can accept ANY type:
- Integer
- String
- Double
- Custom classes (Student, Employee, etc.)

There is NO restriction on T.

--------------------------------------------------------
HOW IT WORKS?
--------------------------------------------------------

At compile time:
- Java replaces T with actual type provided

Example:

Generics1<Integer>  → T becomes Integer
Generics1<String>   → T becomes String

--------------------------------------------------------
WHY WE USE GENERICS?
--------------------------------------------------------

1. Type safety (no runtime ClassCastException)
2. Code reusability
3. No need for type casting
4. Works with any object type

--------------------------------------------------------
IMPORTANT POINTS
--------------------------------------------------------

- T is not a real class
- It is a compile-time placeholder
- Actual type is decided when object is created

========================================================
*/

public class GenericClassUnboundExample<T> {

    // Generic type variable
    T obj;

    // Constructor
    GenericClassUnboundExample(T obj) {
        this.obj = obj;
    }

    // Display runtime type of object
    public void show() {
        System.out.println("The type of Object: " + obj.getClass().getName());
    }

    // Return stored object
    public T getObject() {
        return obj;
    }

    public static void main(String[] args) {

        /*
         * Integer type example
         * T becomes Integer
         */
        GenericClassUnboundExample<Integer> g1 = new GenericClassUnboundExample<>(100);
        g1.show();

        /*
         * String type example
         * T becomes String
         */
        GenericClassUnboundExample<String> g2 = new GenericClassUnboundExample<>("PPI");
        g2.show();

        /*
         * No casting needed while retrieving values
         */
        System.out.println(g1.getObject());
        System.out.println(g2.getObject());
    }
}