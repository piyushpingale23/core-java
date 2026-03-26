package com.core.java.local_global;

public class LocalGlobalExample {

    String name;  // global variable
    int age;      // global variable

    private LocalGlobalExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayStudent() {

        String message = "Local Variable Details"; // local variable

        System.out.println(message);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

    }

    public static void main(String[] args) {

        LocalGlobalExample student = new LocalGlobalExample("Local_Global", 22);

//        LocalGlobalExample student = new LocalGlobalExample();
//
//        student.name = "Local_Global";
//        student.age = 22;

        student.displayStudent();

    }

}