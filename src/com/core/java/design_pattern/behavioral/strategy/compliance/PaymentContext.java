package com.core.java.design_pattern.behavioral.strategy.compliance;

public class PaymentContext {

    private final Payment strategy;

    public PaymentContext(Payment strategy) {
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        strategy.pay(amount);
    }
}
