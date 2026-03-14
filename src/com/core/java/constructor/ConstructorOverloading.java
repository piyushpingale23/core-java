package com.core.java.constructor;

public class ConstructorOverloading {

    int id;
    String name;

    // Default constructor
    ConstructorOverloading() {
        System.out.println("Default constructor called");
    }

    // Parameterized constructor
    ConstructorOverloading(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        ConstructorOverloading co1 = new ConstructorOverloading();
        ConstructorOverloading co2 = new ConstructorOverloading(101, "Jack");

        co2.display();
    }
}