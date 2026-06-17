package com.core.java.java_8.functional_interface.pre_defined.two_argument.bifunction;

import java.util.function.BiFunction;

// Write a BiFunction that uses a constructor reference
// to create and return an Employee object from the given id and name.
class Employee {

    int id;
    String name;

    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
}

public class BiFunctionExample2 {

    public static void main(String[] args) {

//        BiFunction<Integer, String, Employee> biFunction = (a,b) -> new Employee(a, b);
        BiFunction<Integer, String, Employee> biFunction = Employee::new;
        System.out.println(biFunction.apply(1, "Piyush_Ingale"));


    }
}
