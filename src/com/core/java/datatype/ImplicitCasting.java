package com.core.java.datatype;

/**
 * This class demonstrates Implicit Type Casting (Widening Casting) in Java. <br>
 * <br>
 * Implicit casting occurs when a smaller data type is automatically converted
 * into a larger data type by the Java compiler. <br>
 * <br>
 * This conversion happens automatically because the destination data type
 * has a larger memory capacity than the source data type. <br>
 * <br>
 * In implicit casting, no manual casting syntax is required. <br>
 * <br>
 * In this example: <br>
 * A byte value is automatically converted into larger primitive types. <br>
 * <br>
 * Conversion hierarchy used: <br>
 * <br>
 * byte -> short -> int -> long -> float -> double <br>
 * <br>
 * Since all target types have larger storage capacity,
 * Java performs the conversion automatically.
 */
public class ImplicitCasting {

    public static void main(String[] args) {

        byte number = 10;

        System.out.println("Original byte value: " + number);
        System.out.println("Converted to short: " + (short) number);
        System.out.println("Converted to int: " + (int) number);
        System.out.println("Converted to long: " + (long) number);
        System.out.println("Converted to float: " + (float) number);
        System.out.println("Converted to double: " + (double) number);
    }
}