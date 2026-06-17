package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.List;

// Find Employee names having salary greater than 50,000
public class StreamApiExample4 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "A", "A",10000.0);
        Employee e2 = new Employee(2, "B", "B",40000.0);
        Employee e3 = new Employee(1, "C", "C",65000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3);

        List<String> employeeNames = employeeList.stream()
                .filter(e -> e.getSalary() > 50000)
                .map(Employee::getName)
                .toList();

        System.out.println("Employee names whose salary > 50000: " + employeeNames);
    }
}
