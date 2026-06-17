package com.core.java.java_8.stream_api.practice_examples;

import java.util.*;
import java.util.stream.Collectors;

/*
Find Highest Salary Employee Name In Each Department
{
    Java=[Piyush],
    C++=[Chang],
    Python=[Ingale]
}
*/
public class StreamApiExample11 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Piyush", "Java", 10000.0);
        Employee e2 = new Employee(3, "Chang", "C++", 40000.0);
        Employee e3 = new Employee(2, "Piyush", "Python", 65000.0);
        Employee e4 = new Employee(4, "Ingale", "Python", 70000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        Map<String, String> highestSalaryEmployeeByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(Employee::getSalary)
                                ),
                                emp -> emp.map(Employee::getName).orElse(null)
                        )
                ));

        System.out.println(highestSalaryEmployeeByDept);



    }
}
