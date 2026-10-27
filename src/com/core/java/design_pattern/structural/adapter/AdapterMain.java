package com.core.java.design_pattern.structural.adapter;

public class AdapterMain {

    public static void main(String[] args) {

        PaymentProcessor payment = new UpiAdapter();

        payment.pay();
    }
}
