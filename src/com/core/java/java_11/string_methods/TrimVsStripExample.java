package com.core.java.java_11.string_methods;

public class TrimVsStripExample {

    public static void main(String[] args) {

        // Normal spaces
        String value1 = "   Hello Java   ";

        System.out.println("trim:  [" + value1.trim() + "]");
        System.out.println("strip: [" + value1.strip() + "]");

        // Unicode em spaces
        String value2 = "\u2003Hello Java\u2003";

        System.out.println("trim:  [" + value2.trim() + "]");
        System.out.println("strip: [" + value2.strip() + "]");
    }
}
