package com.core.java.typecasting.primitive;

public class UpCasting {

    public static void main(String[] args) {

        // Primitive Widening
        byte age = 25;
        int ageInt = age;          // byte → int (upcasting)
        double ageDouble = ageInt; // int → double (upcasting)

        System.out.println("Byte age: " + age);
        System.out.println("Int ageInt: " + ageInt);
        System.out.println("Double ageDouble: " + ageDouble);

    }
}
