package com.core.java.oops.polymorphism.overriding;

// Parent class
class Parent {

    // static method
    static void m1() {
        System.out.println("Parent static m1()");
    }

    // final method
    final void m2() {
        System.out.println("Parent final m2()");
    }

    // private method
    private void m3() {
        System.out.println("Parent private m3()");
    }

    public void m4() {
        System.out.println("Parent m4()");
    }

    // helper method to show private method inside same class
    public void accessPrivate() {
        m3();
    }
}

// Child class
class Child extends Parent {

    // This is NOT overriding, it is method hiding (static)
    static void m1() {
        System.out.println("Child static m1()");
    }

    // ERROR: cannot override final method
    // void m2() {
    //     System.out.println("Child final m2()");
    // }

    // This is a new method, not overriding (because private method is not inherited)
    void m3() {
        System.out.println("Child m3()");
    }

    public void m4() {
        System.out.println("Child m4()");
    }
}

public class OverridingExample2 {

    public static void main(String[] args) {

        Parent p = new Child();
        Child c = new Child();

        // static method -> depends on reference type (method hiding)
        p.m1();   // Parent static m1()
        c.m1();   // Child static m1()

        System.out.println("----------------");

        // final method -> cannot be overridden, parent version only runs
        p.m2();
        c.m2();

        System.out.println("----------------");

        // private method -> not accessible outside parent class
        p.accessPrivate();

        // Child m3() is a separate method (NOT overriding)
        c.m3();

        System.out.println("----------------");

        p.m4();
    }
}