package com.core.java.typecasting.objects;

public class DownCasting {

    public static void main(String[] args) {
        Animal1 a = new Fox(); // Upcasting
        Fox f = (Fox) a;      // Downcasting
        f.bark();              // Now child method accessible
    }
}

class Animal1 {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Fox extends Animal1 {
    void bark() {
        System.out.println("Fox barks");
    }
}
