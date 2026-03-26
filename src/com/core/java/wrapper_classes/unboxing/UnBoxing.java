package com.core.java.wrapper_classes.unboxing;

public class UnBoxing {

    public static void main(String[] args) {

        Integer i = 10;
        Long l = 20L;
        Float f = 30f;
        Double d = 40.0;

        int i1 = i; // automatic un-boxing
        int i2 = i.intValue(); // manual un-boxing

        long l1 = l;
        long l2 = l.longValue();

        float f1 = f;
        float f2 = f.floatValue();

        double d1 = d;
        double d2 = d.doubleValue();

        System.out.println("i1 -> " + i1);
        System.out.println("i2 -> " + i2);

        System.out.println("l1 -> " + l1);
        System.out.println("l2 -> " + l2);

        System.out.println("f1 -> " + f1);
        System.out.println("f2 -> " + f2);

        System.out.println("d1 -> " + d1);
        System.out.println("d2 -> " + d2);

    }

}
