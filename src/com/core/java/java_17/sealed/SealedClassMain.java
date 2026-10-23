package com.core.java.java_17.sealed;

sealed class Payment permits CardPayment, CashPayment, UpiPayment {

    void process() {
        System.out.println("Processing payment");
    }
}

// Inheritance stops here
final class CardPayment extends Payment {

    @Override
    void process() {
        System.out.println("Processing card payment");
    }
}

// Inheritance remains restricted
sealed class CashPayment extends Payment permits CashOnDelivery {

    @Override
    void process() {
        System.out.println("Processing cash payment");
    }
}

final class CashOnDelivery extends CashPayment {

    @Override
    void process() {
        System.out.println("Processing cash on delivery");
    }
}

// Inheritance is reopened
non-sealed class UpiPayment extends Payment {

    @Override
    void process() {
        System.out.println("Processing UPI payment");
    }
}

// Allowed because UpiPayment is non-sealed
class GooglePay extends UpiPayment {

    @Override
    void process() {
        System.out.println("Processing Google Pay payment");
    }
}

public class SealedClassMain {

    public static void main(String[] args) {

        Payment p1 = new CardPayment();
        Payment p2 = new CashOnDelivery();
        Payment p3 = new GooglePay();

        p1.process();
        p2.process();
        p3.process();
    }
}
