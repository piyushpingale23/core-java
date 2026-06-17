package com.core.java.oops.abstraction.interface_class;

public class UpiPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }

}