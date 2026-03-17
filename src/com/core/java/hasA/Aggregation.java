package com.core.java.hasA;

public class Aggregation {

    public static void main(String[] args) {

        Department d = new Department("Computer Science");
        University u = new University("XYZ University", d);

        u.showInfo();
    }
}

class Department {

    String name;

    Department(String name) {
        this.name = name;
    }
}

class University {

    String name;
    Department department; // University HAS-A Department (aggregation)

    University(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    void showInfo() {
        System.out.println("University: " + name + ", Department: " + department.name);
    }
}
