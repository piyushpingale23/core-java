package com.core.java.java_8.functional_interface.pre_defined.two_argument.biconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

// Write a BiConsumer<Employee, Double> that accepts an Employee object
// and an increment amount, and increases the employee's salary.
class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class BiConsumerExample1 {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Piyush", 1000));
        employeeList.add(new Employee("Ingale", 2000));

        BiConsumer<Employee, Double> biConsumer = (e, d) -> {
            double incrementedSalary = e.salary + d;

            System.out.println("Employee Name: " + e.name);
            System.out.println("Previous Salary: " + e.salary);
            System.out.println("Incremented Salary: " + incrementedSalary);
            System.out.println();
        };

        for (Employee employee : employeeList) {
            biConsumer.accept(employee, 500.0);
        }



    }
}
