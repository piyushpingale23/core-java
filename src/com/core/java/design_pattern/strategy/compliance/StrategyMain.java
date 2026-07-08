package com.core.java.design_pattern.strategy.compliance;

public class StrategyMain {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext(new UpiPayment());
        context.executePayment(1000);

        context = new PaymentContext(new CardPayment());
        context.executePayment(2000);
    }
}