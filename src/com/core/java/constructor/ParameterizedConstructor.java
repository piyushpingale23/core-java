package com.core.java.constructor;

public class ParameterizedConstructor {

    int id;
    String name;

    // Parameterized constructor
    ParameterizedConstructor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {

        ParameterizedConstructor pc = new ParameterizedConstructor(1, "Jack");
        pc.display();

    }
}