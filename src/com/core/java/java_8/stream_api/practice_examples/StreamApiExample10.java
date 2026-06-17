package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/*
Count Employees In Each Department
{
    Java=1,
    C++=1,
    Python=1
}
*/
public class StreamApiExample10 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Piyush", "Java", 10000.0);
        Employee e2 = new Employee(3, "Chang", "C++", 40000.0);
        Employee e3 = new Employee(2, "Piyush", "Python", 65000.0);
        Employee e4 = new Employee(4, "Ingale", "Python", 60000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        Map<String, Long> employeesCountByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.counting())));

        System.out.println(employeesCountByDepartment);



    }
}
