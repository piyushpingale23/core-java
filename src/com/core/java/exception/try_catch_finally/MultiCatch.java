package com.core.java.exception.try_catch_finally;

public class MultiCatch {

    public static void main(String[] args) {

        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic issue");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException issue");
        } catch (Exception e) {
            System.out.println("Generic exception");
        }

    }

}
