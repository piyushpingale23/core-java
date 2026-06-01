package com.core.java.design_principle.solid.open_close.violation;

class PaymentService {

    void pay(String type) {

        if (type.equals("UPI")) {
            System.out.println("UPI");
        } else if (type.equals("CARD")) {
            System.out.println("CARD");
        }

        /*
         * Problem:
         * The logic depends on conditional statements (if-else) for different payment types.
         *
         * If a new payment method (e.g., NET_BANKING, WALLET) is introduced,
         * we must modify this existing method.
         *
         * Open/Closed Principle (OCP) Violation:
         * The class is NOT closed for modification because we keep changing it
         * whenever a new payment type is added.
         *
         * Correct Approach:
         * We should use abstraction (interface or polymorphism) so that
         * new payment types can be added without modifying this class.
         */

    }

}
