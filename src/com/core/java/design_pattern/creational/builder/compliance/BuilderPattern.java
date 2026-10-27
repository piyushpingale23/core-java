package com.core.java.design_pattern.creational.builder.compliance;

import com.core.java.design_pattern.creational.builder.Employee;

public class BuilderPattern {

    public static void main(String[] args) {

        Employee employee = Employee.builder()
                .firstName("Piyush")
                .email("piyushingale@gmail.com")
                .build();

        System.out.println(employee);

    }
}
