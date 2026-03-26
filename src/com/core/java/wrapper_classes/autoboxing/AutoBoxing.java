package com.core.java.wrapper_classes.autoboxing;

public class AutoBoxing {

    public static void main(String[] args) {

        int i = 10;
        long l = 20L;
        float f = 30;
        double d = 40.0;

        Integer i1 = Integer.valueOf(i); // manual auto-boxing
        Integer i2 = i; // automatic auto-boxing

        Long l1 = Long.valueOf(l);
        Long l2 = l;

        Float f1 = Float.valueOf(f);
        Float f2 = f;

        Double d1 = Double.valueOf(d);
        Double d2 = d;

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
