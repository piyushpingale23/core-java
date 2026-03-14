package com.core.java.datatype;

public class NonPrimitiveDataType {

    public static void main(String[] args) {

        // String
        String name = "Jack";

        // Array
        int[] numbers = {10, 20, 30, 40};

        // Object
        Student student = new Student();
        student.name = "Rahul";
        student.age = 22;

        System.out.println("Name: " + name);

        System.out.println("Array values:");
        for (int num : numbers) {
            System.out.println(num);
        }

        System.out.println("Student Name: " + student.name);
        System.out.println("Student Age: " + student.age);

    }
}

class Student {

    String name;
    int age;

}