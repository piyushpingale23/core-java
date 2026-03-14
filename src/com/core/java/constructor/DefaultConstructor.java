package com.core.java.constructor;

public class DefaultConstructor {

    int number;

    // Default constructor
    DefaultConstructor() {
        number = 100;
        System.out.println("Default constructor executed");
    }

    public void display() {
        System.out.println("Number: " + number);
    }

    public static void main(String[] args) {

        DefaultConstructor dc = new DefaultConstructor();
        dc.display();

    }
}