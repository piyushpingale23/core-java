package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// Calculate total salary
public class StreamApiExample6 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "A", "A",10000.0);
        Employee e2 = new Employee(3, "C", "C",40000.0);
        Employee e3 = new Employee(2, "B", "B",65000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3);

        Double totalSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println(totalSalary);

    }
}
