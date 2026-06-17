package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Find highest and lowest paid employee name
public class StreamApiExample5 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "A", "A",10000.0);
        Employee e2 = new Employee(3, "C", "C",40000.0);
        Employee e3 = new Employee(2, "B", "B",65000.0);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3);

        Employee lowestPaidEmployeeName = employeeList.stream()
//                .sorted((a, b) -> Double.compare(a.getSalary(), b.getSalary()))
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList()
                .getFirst();
        System.out.println("Lowest paid employee: " + lowestPaidEmployeeName.getName());


        Employee highestPaidEmployeeName = employeeList.stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .toList()
                .getFirst();
        System.out.println("Highest paid employee: " + highestPaidEmployeeName.getName());

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing((a,b) -> Double.compare(a.getSalary(), b.getSalary())))
                .forEach(e -> {
                    System.out.println(e.getName());
                    System.out.println(e.getSalary());
                });

    }
}

/*

1. Sort by Salary Ascending:
List<Employee> ascendingSalary = employeeList.stream()
        .sorted(Comparator.comparing(Employee::getSalary))
        .toList();
System.out.println(ascendingSalary);

2. Sort by Salary Descending:
List<Employee> descendingSalary = employeeList.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .toList();
System.out.println(descendingSalary);

3. Sort by Name:
List<Employee> ascendingName = employeeList.stream()
        .sorted(Comparator.comparing(Employee::getName))
        .forEach(System.out::println);

4. Sort by Name, then Salary:
employeeList.stream()
        .sorted(
            Comparator.comparing(Employee::getName)
                      .thenComparing(Employee::getSalary)
        )
        .forEach(System.out::println);

5. Highest Salary Employee:
Employee highestSalaryEmp = employeeList.stream()
        .max(Comparator.comparing(Employee::getSalary))
        .orElse(null);
System.out.println(highestSalaryEmp);


6. Lowest Salary Employee:
Employee lowestSalaryEmp = employeeList.stream()
        .min(Comparator.comparing(Employee::getSalary))
        .orElse(null);
System.out.println(lowestSalaryEmp);

7. Second-Highest Salary:
Employee secondHighest = employeeList.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .skip(1)
        .findFirst()
        .orElse(null);
System.out.println(secondHighest);


8. Top 3 Highest Salaries:
employeeList.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .limit(3)
        .forEach(System.out::println);

9. Sort by Salary Desc, then Name Asc
employeeList.stream()
        .sorted(
            Comparator.comparing(Employee::getSalary)
                      .reversed()
                      .thenComparing(Employee::getName)
        )
        .forEach(System.out::println);



*/
