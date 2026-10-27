package com.core.java.design_pattern.structural.adapter;

public class UpiAdapter implements PaymentProcessor {

    private final UpiService upiService = new UpiService();

    @Override
    public void pay() {
        upiService.makeUpiPayment();
    }
}
