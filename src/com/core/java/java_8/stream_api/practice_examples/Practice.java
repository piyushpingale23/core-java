package com.core.java.java_8.stream_api.practice_examples;

import java.util.*;

public class Practice {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "A", "A",10000.0);
        Employee e2 = new Employee(3, "C", "C",40000.0);
        Employee e3 = new Employee(2, "B", "B",65000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3);

        List<Integer> numbers = Arrays.asList(10, 60, 70, 20, 90, 60, 70);

        List<String> name = Arrays.asList("a", "c", "e", "b", "d");

        Set<Integer> set = new HashSet<>();
        List<Integer> duplicate = numbers.stream()
                .filter(n -> !set.add(n))
                .toList();
        System.out.println(duplicate);
    }
}
