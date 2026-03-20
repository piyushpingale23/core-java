package com.core.java.type_casting.objects;

public class UpCasting {

    public static void main(String[] args) {
//        Dog dog = new Dog();
//        Animal a = dog; // Upcasting
//        OR

        Animal a = new Dog();
        a.eat(); // Can access parent methods
        //a.bark(); // Error: cannot access child method
    }
}

class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
