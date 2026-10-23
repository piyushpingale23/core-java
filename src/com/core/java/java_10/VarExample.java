package com.core.java.java_10;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class VarExample {

    public static void main(String[] args) {

        // 1. Primitive types
        var number = 100;          // int
        var price = 99.5;          // double
        var isActive = true;       // boolean
        var character = 'A';       // char

        System.out.println("Number: " + number);
        System.out.println("Price: " + price);
        System.out.println("Active: " + isActive);
        System.out.println("Character: " + character);


        // 2. String
        var name = "Piyush";       // String
        System.out.println("Name: " + name);


        // 3. Collection
        var languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Python");
        System.out.println("Languages: " + languages);


        // 4. List factory method
        var numbers = List.of(10, 20, 30);
        System.out.println("Numbers: " + numbers);


        // 5. Custom object
        var employee = new Employee("Piyush");
        System.out.println("Employee: " + employee.getName());


        // 6. Enhanced for loop
        for (var language : languages) {
            System.out.println("Language: " + language);
        }


        // 7. Traditional for loop
        for (var i = 0; i < 3; i++) {
            System.out.println("Index: " + i);
        }


        // 8. Reassignment is allowed if the type matches
        var age = 25;              // int
        age = 26;
        System.out.println("Age: " + age);
        // age = "Java";           // Compilation error
    }

    // Nested class keeps the entire example in one Java source file.
    @Getter
    static class Employee {

        private final String name;

        Employee(String name) {
            this.name = name;
        }

    }
}
