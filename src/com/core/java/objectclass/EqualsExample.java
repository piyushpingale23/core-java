package com.core.java.objectclass;

public class EqualsExample {

    public static void main(String[] args) {

        Person p1 = new Person(1, "John");
        Person p2 = new Person(1, "Cena");

        System.out.println(p1.equals(p2));

    }

}
