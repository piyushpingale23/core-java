package com.core.java.typecasting.primitive;

public class DownCasting {

    public static void main(String[] args) {

        // Primitive Narrowing
        double balance = 15000.75;
        int balanceInt = (int) balance; // double → int (downcasting)
        byte balanceByte = (byte) balanceInt; // int → byte (downcasting)

        System.out.println("Double balance: " + balance);
        System.out.println("Int balanceInt: " + balanceInt);
        System.out.println("Byte balanceByte: " + balanceByte);

    }
}
