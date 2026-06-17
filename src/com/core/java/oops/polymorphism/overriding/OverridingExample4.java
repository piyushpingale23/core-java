package com.core.java.oops.polymorphism.overriding;

// Parent class
class Parent4 {

    // Object return type method
    // In overriding: Object type return is allowed, but child can return same or subclass type
    Object getValue() {
        System.out.println("Parent method");
        return new Object();
    }

    // String return type method
    String getMessage() {
        System.out.println("Parent message");
        return "Parent";
    }
}

// Child class
class Child4 extends Parent4 {

    // Overriding with Object return type
    // Allowed because return type is SAME
    @Override
    Object getValue() {
        System.out.println("Child method");
        return new Object();
    }

    // Overriding String method
    // String is a class, so same rule applies
    @Override
    String getMessage() {
        System.out.println("Child message");
        return "Child";
    }
}

public class OverridingExample4 {

    public static void main(String[] args) {

        Parent4 p = new Child4();

        // Runtime polymorphism → Child method executes
        Object obj = p.getValue();
        System.out.println(obj);

        String msg = p.getMessage();
        System.out.println(msg);
    }
}