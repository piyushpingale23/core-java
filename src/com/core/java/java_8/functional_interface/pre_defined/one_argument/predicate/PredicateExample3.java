package com.core.java.java_8.functional_interface.pre_defined.one_argument.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Write a Predicate to check Student id > 5 is existing or not.
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class PredicateExample3 {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A"));
        list.add(new Student(2, "B"));
        list.add(new Student(3, "C"));
        list.add(new Student(3, "D"));
        list.add(new Student(6, "E"));

        Predicate<Student> predicate = s -> s.id > 5;

        for (Student s : list) {

            if (predicate.test(s)) {
                System.out.println(s.name);
            }

        }
    }

}
