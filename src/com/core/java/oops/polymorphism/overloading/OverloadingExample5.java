package com.core.java.oops.polymorphism.overloading;

public class OverloadingExample5 {

    // Static method
    // Belongs to class level, not object level
    public static void m1() {
        System.out.println("static m1()");
    }

    // Private method
    // Accessible only within this class
    private void m2() {
        System.out.println("private m2()");
    }

    // Final method
    // Cannot be overridden in child class but can be overloaded
    final void m3() {
        System.out.println("final m3()");
    }

    // Overloaded instance method
    public void m1(int i) {
        System.out.println("int argument m1()");
    }

    // Overloaded method with String parameter
    public void m2(String s) {
        System.out.println("String argument m2()");
    }

    // Overloaded method with two parameters
    public void m3(int i, String s) {
        System.out.println("int String argument m3()");
    }

    public static void main(String[] args) {

        OverloadingExample5 ol5 = new OverloadingExample5();

        // Static method can be called directly inside same class
        m1();

        // Private method can be accessed inside same class only
        ol5.m2();

        // final method can also be called normally
        ol5.m3();

        // Overloaded methods based on parameters
        ol5.m1(10);
        ol5.m2("Overloading");
        ol5.m3(10, "Overloading");
    }
}