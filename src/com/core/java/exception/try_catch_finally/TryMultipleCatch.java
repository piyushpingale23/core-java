package com.core.java.exception.try_catch_finally;

public class TryMultipleCatch {

    public static void main(String[] args) {

        try {
            String str = null;
            System.out.println(str.length());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic");
        } catch (NullPointerException e) {
            System.out.println("NullPointer");
        }
    }
}
