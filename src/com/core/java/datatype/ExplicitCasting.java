package com.core.java.datatype;

/**
 * This class demonstrates Explicit Type Casting (Narrowing Casting) in Java. <br>
 * <br>
 * Explicit casting occurs when a larger data type is converted into a <br>
 * smaller data type manually using casting syntax. <br>
 * <br>
 * Since smaller data types have less memory capacity, this conversion <br>
 * may cause data loss or precision loss. <br>
 * <br>
 * In this example: <br>
 * A double value is converted into multiple smaller primitive types. <br>
 * <br>
 * Conversion hierarchy used: <br>
 * <br>
 * double -> float -> long -> int -> short -> byte <br>
 * <br>
 * Each conversion requires explicit casting using (datatype). <br>
 */
public class ExplicitCasting {

    public static void main(String[] args) {

        double number = 123.99;

        float floatValue = (float) number;
        long longValue = (long) number;
        int intValue = (int) number;
        short shortValue = (short) number;
        byte byteValue = (byte) number;

        System.out.println("Original double value: " + number);
        System.out.println("Converted to float: " + floatValue);
        System.out.println("Converted to long: " + longValue);
        System.out.println("Converted to int: " + intValue);
        System.out.println("Converted to short: " + shortValue);
        System.out.println("Converted to byte: " + byteValue);
    }
}