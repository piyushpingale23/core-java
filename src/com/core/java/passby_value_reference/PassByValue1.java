package com.core.java.passby_value_reference;

public class PassByValue1 {

    public static void main(String[] args) {

        int i = 10;

        System.out.println("Before change: " + i);
        changeValue(i);
        System.out.println("After Change: " + i);
    }

    private static void changeValue(int i) {
        i = 20;
    }

}
