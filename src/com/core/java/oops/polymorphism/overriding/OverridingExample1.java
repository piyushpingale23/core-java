package com.core.java.oops.polymorphism.overriding;

// Parent class
class Animal {

    // Method to be overridden
    void sound() {
        System.out.println("Animal makes sound");
    }
}

// Child class
class Dog extends Animal {

    // Method Overriding
    // Same method name, same parameters, same return type
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class OverridingExample1 {

    public static void main(String[] args) {

        // Parent reference, child object
        // Runtime polymorphism
        Animal a = new Dog();

        // Method call decided at RUNTIME based on object type
        a.sound();
    }
}