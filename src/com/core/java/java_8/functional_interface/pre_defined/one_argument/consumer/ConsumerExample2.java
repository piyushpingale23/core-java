package com.core.java.java_8.functional_interface.pre_defined.one_argument.consumer;

import java.util.function.Consumer;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class ConsumerExample2 {

    public static void main(String[] args) {

        Student student = new Student(1, "Piyush Ingale");

        Consumer<Student> consumer = s -> {
            System.out.println("Id: " + s.id);
            System.out.println("Name: " + s.name);
        };
        consumer.accept(student);
    }

}
