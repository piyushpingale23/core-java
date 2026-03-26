package com.core.java.type_casting.primitive;

// DownCasting = Narrowing = Explicit
// double -> float -> long -> int -> short -> byte
// need to do manually, chances data loss
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
