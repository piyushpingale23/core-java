package com.core.java.exception.try_catch_finally;

public class WrongCatchOrder {

    public static void main(String[] args) {

        try {
            int x = 10 / 0;
        }
        // Compile-time error
        catch (Exception e) {
            System.out.println("Generic");
        }
//        catch (ArithmeticException e) {
//            System.out.println("Specific");
//        }
    }
}
