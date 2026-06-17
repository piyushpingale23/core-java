package com.core.java.oops.abstraction.abstract_class;

public class Car extends Vehicle {

    Car(String name) {
        super(name);
    }

    @Override
    void start() {
        System.out.println(name + " starts with key ignition");
    }
}
