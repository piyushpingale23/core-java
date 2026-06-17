package com.core.java.oops.polymorphism.overloading;

public class OverloadingExample1 {

    OverloadingExample1() {
        System.out.println("Default Constructor!");
    }

    OverloadingExample1 (String s) {
        System.out.println("String Parameterized Constructor!");
    }

    void m1() {
        System.out.println("No argument m1()");
    }

    void m1 (int i) {
        System.out.println("int argument m1() : " + i);
    }

    public static void main(String[] args) {

        OverloadingExample1 ol1 = new OverloadingExample1();
        OverloadingExample1 ol2 = new OverloadingExample1("OverloadingExample1");

        ol1.m1(10);
        ol2.m1();

    }
}
