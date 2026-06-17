package com.core.java.java_8.functional_interface.pre_defined.one_argument.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// Write a Function to determine the grade of a student based on the following criteria:
//
// Marks >= 90  -> A (Distinction)
// Marks >= 70  -> B (First Class)
// Marks >= 50  -> C (Second Class)
// Marks >= 35  -> D (Third Class)
// Marks < 35   -> F (Failed)

// Also print Distinction Students list.
class Student {
    int id;
    double marks;

    Student (int id, double marks) {
        this.id = id;
        this.marks = marks;
    }
}

public class FunctionExample3 {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, 90.5));
        studentList.add(new Student(2, 85.55));
        studentList.add(new Student(3, 65));
        studentList.add(new Student(4, 45.5));
        studentList.add(new Student(5, 34.90));

        Predicate<Double> predicate = d -> d >= 90.0;

        Function<Student, String> function = student -> {

            double marks = student.marks;

            if (marks >= 90) return "A: [Distinction]";
            else if (marks >= 70) return "B: First Class";
            else if (marks >= 50) return "C: Second Class";
            else if (marks >= 35) return "D: Third Class";
            else return "F: Failed";
        };

        System.out.println("All Student Id, Marks and its Grades");
        for (Student student : studentList) {

            System.out.println("Id: " + student.id);
            System.out.println("Marks: " + student.marks);
            System.out.println("Grade: " + function.apply(student));
            System.out.println("-------------------------------------");
        }

        System.out.println("===========================================");
        System.out.println("Distinction Student List: ");
        for (Student student : studentList) {

            if (predicate.test(student.marks)) {
                System.out.println("Id: " + student.id);
                System.out.println("Marks: " + student.marks);
                System.out.println("Grade: " + function.apply(student));
                System.out.println("-------------------------------------");
            }
        }


    }
}
