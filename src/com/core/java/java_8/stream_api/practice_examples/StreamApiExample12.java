package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Find Second Highest Salary Employee
Employee{
        name='Piyush',
        salary=65000
    }
*/
public class StreamApiExample12 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Piyush", "Java", 10000.0);
        Employee e2 = new Employee(3, "Chang", "C++", 40000.0);
        Employee e3 = new Employee(2, "Piyush", "Python", 65000.0);
        Employee e4 = new Employee(4, "Ingale", "Python", 70000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        Employee secondHighestSalary = employeeList.stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .skip(1)
                .toList()
                .getFirst();

        System.out.println("Second Highest Salary : " + secondHighestSalary);


    }
}
