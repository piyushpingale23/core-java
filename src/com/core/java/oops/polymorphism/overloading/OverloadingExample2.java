package com.core.java.oops.polymorphism.overloading;

// Automatic Type Promotion in Method Overloading
// Java automatically promotes smaller data types to larger compatible types
// when exact method match is not found.

public class OverloadingExample2 {

    void m1(int i) {
        System.out.println("int: " + i);
    }

    void m1(float f) {
        System.out.println("float: " + f);
    }

    public static void main(String[] args) {

        OverloadingExample2 ol2 = new OverloadingExample2();

        // 10 is int literal → exact match found → m1(int) called
        ol2.m1(10);

        // 20.2f is float literal → exact match found → m1(float) called
        ol2.m1(20.2f);

        // 'd' is char → no m1(char) method available
        // So Java applies Automatic Type Promotion:
        // char → int (ASCII value) → m1(int) is called
        ol2.m1('d');
    }

}
