package com.core.java.local_global;

public class GlobalVariableExample {

    // No need to initialize compulsory, it is done by constructor also.
    int number = 50; // global (instance) variable

    public void display() {

        System.out.println("Global variable value: " + number);

    }

    public static void main(String[] args) {

        GlobalVariableExample obj = new GlobalVariableExample();
        obj.display();

    }

}
