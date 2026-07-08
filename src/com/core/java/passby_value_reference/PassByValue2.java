package com.core.java.passby_value_reference;

class Student2 {
    String name;
}

public class PassByValue2 {

    public static void main(String[] args) {

        Student2 student2 = new Student2();
        student2.name = "Spring";

        System.out.println("Before Change: " + student2.name);
        changeObject(student2);
        System.out.println("After Change: " + student2.name);

    }

    private static void changeObject(Student2 student2) {
        student2.name = "Spring-Boot";
    }

}
