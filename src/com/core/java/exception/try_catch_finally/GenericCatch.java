package com.core.java.exception.try_catch_finally;

public class GenericCatch {

    public static void main(String[] args) {

        try {
            int x = 10 / 0;
        } catch (Exception e) {
            System.out.println("Handled by generic catch");
        }
    }
}
