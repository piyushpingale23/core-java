package com.core.java.design_pattern.strategy.compliance;

public class CardPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}
