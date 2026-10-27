package com.core.java.design_pattern.behavioral.strategy.compliance;

public class CardPayment implements Payment {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}
