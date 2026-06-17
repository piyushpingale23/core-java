package com.core.java.oops.abstraction.interface_class;

public class CardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}
