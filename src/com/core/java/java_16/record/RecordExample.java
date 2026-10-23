package com.core.java.java_16.record;

public class RecordExample {

    record Employee(int id, String name) {}

    public static void main(String[] args) {

        Employee employee = new Employee(101, "Piyush");

        // Generated accessor methods
        System.out.println(employee.id());
        System.out.println(employee.name());

        // Generated toString()
        System.out.println(employee);

        // Generated equals()
        Employee another = new Employee(101, "Piyush");
        System.out.println(employee.equals(another));
    }
}
