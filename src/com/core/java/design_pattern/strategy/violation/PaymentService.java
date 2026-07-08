package com.core.java.design_pattern.strategy.violation;

/*
 * VIOLATION: Strategy Pattern / Open-Closed Principle (OCP)
 *
 * Problems in this design:
 *
 * 1. Tight Coupling:
 *    - PaymentService is directly dependent on all payment types.
 *
 * 2. Violation of Open-Closed Principle:
 *    - If a new payment method (e.g., CRYPTO) is added,
 *      we must MODIFY this class.
 *
 * 3. Hard to Maintain:
 *    - Multiple if-else conditions increase complexity.
 *
 * 4. Poor Scalability:
 *    - Every new payment type requires changes here.
 *
 * 5. Code Duplication Risk:
 *    - Similar logic may get copied in other services.
 *
 * 6. Not Following Single Responsibility Principle:
 *    - This class is responsible for BOTH:
 *        a) Payment logic decision
 *        b) Payment execution
 */

public class PaymentService {

    public void pay(String type) {

        if (type.equalsIgnoreCase("UPI")) {
            System.out.println("Pay using UPI");

        } else if (type.equalsIgnoreCase("CARD")) {
            System.out.println("Pay using Card");

        } else if (type.equalsIgnoreCase("PAYPAL")) {
            System.out.println("Pay using PayPal");
        }
    }

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        paymentService.pay("upi");
    }
}