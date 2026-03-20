package com.core.java.local_global;

public class LocalVariableExample {

    public void showNumber() {

        int number = 10; // local variable

        System.out.println("Local variable value: " + number);

    }

    public static void main(String[] args) {

        LocalVariableExample obj = new LocalVariableExample();
        obj.showNumber();

    }

}