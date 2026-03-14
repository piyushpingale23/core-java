package com.core.java.localglobal;

public class GlobalVariableExample {

    int number = 50; // global (instance) variable

    public void display() {

        System.out.println("Global variable value: " + number);

    }

    public static void main(String[] args) {

        GlobalVariableExample obj = new GlobalVariableExample();
        obj.display();

    }

}
