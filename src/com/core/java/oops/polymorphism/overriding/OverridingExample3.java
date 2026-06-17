package com.core.java.oops.polymorphism.overriding;

// Parent class
class Parent3 {

    // Method with primitive return type.
    // Return type must be SAME in overriding
    int getValue() {
        System.out.println("Parent method");
        return 10;
    }
}

// Child class
class Child3 extends Parent3 {

    // Overriding method
    // Return type is same (int)
    @Override
    int getValue() {
        System.out.println("Child method");
        return 20;
    }
}

public class OverridingExample3 {

    public static void main(String[] args) {

        // Runtime polymorphism
        Parent3 p = new Child3();

        // Child version will execute at runtime
        int value = p.getValue();

        System.out.println("Returned Value: " + value);
    }
}