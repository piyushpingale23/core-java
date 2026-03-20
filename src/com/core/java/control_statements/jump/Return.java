package com.core.java.control_statements.jump;

public class Return {

    public static void main(String[] args) {

        int sum = add(10, 20);
        System.out.println("Sum : " + sum);

    }

    public static int add(int a, int b) {
        return a + b;
    }
}
