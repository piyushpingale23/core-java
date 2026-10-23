package com.core.java.java_9.factory_method;


import java.util.List;
import java.util.Set;
import java.util.Map;

public class CollectionFactoryMethods {

    public static void main(String[] args) {

        // 1. List.of() - Creates an unmodifiable List
        List<String> languages = List.of("Java", "Python", "JavaScript");

        System.out.println("List: " + languages);
        System.out.println("First language: " + languages.getFirst());


        // 2. Set.of() - Creates an unmodifiable Set
        Set<String> technologies = Set.of("Spring Boot", "Kafka", "Docker");

        System.out.println("Set: " + technologies);
        System.out.println("Contains Kafka: " + technologies.contains("Kafka"));


        // 3. Map.of() - Creates an unmodifiable Map
        Map<Integer, String> employees = Map.of(
                101, "Amit",
                102, "Piyush",
                103, "Rahul"
        );

        System.out.println("Map: " + employees);
        System.out.println("Employee 102: " + employees.get(102));


        // 4. Map.ofEntries() - Creates a Map from entries
        Map<Integer, String> departments = Map.ofEntries(
                Map.entry(1, "Engineering"),
                Map.entry(2, "Finance"),
                Map.entry(3, "HR")
        );

        System.out.println("Departments: " + departments);
        System.out.println("Department 1: " + departments.get(1));


        // 5. Factory-created collections are unmodifiable
        // languages.add("Go"); // Throws UnsupportedOperationException
        // technologies.add("Redis"); // Throws UnsupportedOperationException
        // employees.put(104, "Neha"); // Throws UnsupportedOperationException
    }
}

