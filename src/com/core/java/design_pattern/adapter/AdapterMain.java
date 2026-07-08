package com.core.java.design_pattern.adapter;

public class AdapterMain {

    public static void main(String[] args) {

        PaymentProcessor payment = new UpiAdapter();

        payment.pay();
    }
}
