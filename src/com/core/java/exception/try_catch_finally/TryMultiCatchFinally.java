package com.core.java.exception.try_catch_finally;

public class TryMultiCatchFinally {

    public static void main(String[] args) {

        try {
            int[] array = new int[2];
            array[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Catch Block");
        } finally {
            assert System.out != null;
            System.out.println("Cleanup done");
        }
    }
}
