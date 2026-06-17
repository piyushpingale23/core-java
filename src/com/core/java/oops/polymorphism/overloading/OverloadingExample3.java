package com.core.java.oops.polymorphism.overloading;

public class OverloadingExample3 {

    void m1(int i) {
        System.out.println("int: " + i);
    }

    void m1(int... i) {
        // varargs internally treated as int[]
        System.out.println("varargs length: " + i.length);
    }

    public static void main(String[] args) {

        OverloadingExample3 ol3 = new OverloadingExample3();

        // Case 1: no arguments
        // only varargs method is applicable
        ol3.m1();   // i = empty array []

        // Case 2: exact match available
        // m1(int) is preferred over varargs
        ol3.m1(10);

        // Case 3:
        // no exact single int match for (10, 20)
        // so varargs method is called
        ol3.m1(10, 20);

        // Case 4:
        // 'd' is char → promoted to int
        // m1(int) is called (NOT varargs)
        ol3.m1('d');
    }
}