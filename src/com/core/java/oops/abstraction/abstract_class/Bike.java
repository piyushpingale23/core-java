package com.core.java.oops.abstraction.abstract_class;

public class Bike extends Vehicle {

    Bike(String name) {
        super(name);
    }

    @Override
    void start() {
        System.out.println(name + " starts with self kick");
    }
}
