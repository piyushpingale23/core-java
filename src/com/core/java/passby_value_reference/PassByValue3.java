package com.core.java.passby_value_reference;

class Student3 {
    String name;
}

public class PassByValue3 {

    public static void main(String[] args) {

        Student3 student3 = new Student3();
        student3.name = "A";

        System.out.println("Before: " + student3.name);
        changeStudentName(student3);
        System.out.println("After: " + student3.name);

    }

    private static void changeStudentName(Student3 s) {
        s = new Student3();
        s.name = "B";
    }

}
