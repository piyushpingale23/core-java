package com.core.java.oops.abstraction.interface_class;

public class MainInterfaceClass {

    public static void main(String[] args) {

        Payment upi = new UpiPayment();
        upi.pay(500);

        Payment card = new CardPayment();
        card.pay(1000);

        System.out.println(upi.s);
        System.out.println(card.s);
    }
}
