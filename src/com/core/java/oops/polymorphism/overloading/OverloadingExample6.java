package com.core.java.oops.polymorphism.overloading;

// Parent class
class Animal { }

// Child class
class Monkey extends Animal { }

public class OverloadingExample6 {

    // Overloading method 1
    void m1(Animal animal) {
        System.out.println("Animal");
    }

    // Overloading method 2
    void m1(Monkey monkey) {
        System.out.println("Monkey");
    }

    public static void main(String[] args) {

        // Reference type = Animal
        // Object type = Monkey
        // IMPORTANT:
        // In overloading, method resolution is done by COMPILER.
        // Compiler only considers REFERENCE TYPE, not object type
        Animal animal = new Monkey();

        // Reference type = Monkey
        // So compiler sees both methods:
        // m1(Animal) and m1(Monkey)
        // Most specific match is selected at compile time
        Monkey monkey = new Monkey();

        OverloadingExample6 ol6 = new OverloadingExample6();

        // CASE 1:
        // Reference type is Animal
        // So compiler selects m1(Animal)
        // Runtime object (Monkey) is ignored in overloading
        ol6.m1(animal);

        // CASE 2:
        // Reference type is Monkey
        // Compiler finds exact match m1(Monkey)
        // So it calls m1(Monkey)
        ol6.m1(monkey);
    }
}