package com.core.java.type_casting.objects;

public class UpCasting {

    public static void main(String[] args) {
//        Dog dog = new Dog();
//        Animal a = dog; // Upcasting
//        OR

        Animal a = new Dog();
        a.eat(); // Can access parent methods

        // instanceof -> instanceof is a relational operator used to check whether an object is an instance of
        // a specified class, subclass, or implements a particular interface.
        Animal a1 = new Dog();
        System.out.println(a1 instanceof Animal); // true
        System.out.println(a1 instanceof Dog);    // true

        Animal a2 = new Dog();
        System.out.println(a2 instanceof Animal); // true
        System.out.println(a2 instanceof Dog);    // false

        //a.bark(); // Error: cannot access child method
    }
}

// parent class
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

// child class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
