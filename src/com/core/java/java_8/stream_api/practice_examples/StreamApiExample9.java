package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Group Employees By Department
// Java -> [Piyush]
// C++ -> [Chang]
// Python -> [Piyush, Ingale]
public class StreamApiExample9 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Piyush", "Java", 10000.0);
        Employee e2 = new Employee(3, "Chang", "C++", 40000.0);
        Employee e3 = new Employee(2, "Piyush", "Python", 65000.0);
        Employee e4 = new Employee(4, "Ingale", "Python", 60000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        Map<String, List<String>> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        System.out.println(employeesByDepartment);


    }
}
