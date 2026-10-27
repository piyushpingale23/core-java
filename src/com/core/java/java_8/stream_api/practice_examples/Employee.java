package com.core.java.java_8.stream_api.practice_examples;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private String department;
    private Double salary;

    @Override
    public int compareTo(Employee employee) {
        return this.salary.compareTo(employee.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
