package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Sort Employees By Salary Descending
public class StreamApiExample8 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Piyush", "Java", 10000.0);
        Employee e2 = new Employee(3, "Chang", "C++", 40000.0);
        Employee e3 = new Employee(2, "Piyush", "Python", 65000.0);
        Employee e4 = new Employee(4, "Ingale", "Python", 60000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        employeeList.stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(e -> System.out.println(e.getName()));

        employeeList.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }
}
