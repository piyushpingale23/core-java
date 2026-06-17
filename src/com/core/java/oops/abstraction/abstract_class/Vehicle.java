package com.core.java.oops.abstraction.abstract_class;

public abstract class Vehicle {

    String name;

    Vehicle(String name) {
        this.name = name;
    }

    // abstract method (must be implemented)
    abstract void start();

    // concrete method (already defined)
    public void showInfo() {
        System.out.println("Vehicle: " + name);
    }
}
