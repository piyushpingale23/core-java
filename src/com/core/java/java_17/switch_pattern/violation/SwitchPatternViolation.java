package com.core.java.java_17.switch_pattern.violation;

class Payment {
}

class UPIPayment extends Payment {

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }
}

class CardPayment extends Payment {

    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

public class SwitchPatternViolation {

    public static String processPayment(Payment payment) {

        if (payment instanceof UPIPayment) {
            UPIPayment upi = (UPIPayment) payment;
            return "UPI: " + upi.getUpiId();
        }

        if (payment instanceof CardPayment) {
            CardPayment card = (CardPayment) payment;
            return "Card: " + card.getCardNumber();
        }

        return "Unknown payment";
    }

    public static void main(String[] args) {

        Payment payment1 = new UPIPayment("piyush@upi");
        Payment payment2 = new CardPayment("1234567890123456");
        Payment payment3 = new Payment();

        System.out.println(processPayment(payment1));
        System.out.println(processPayment(payment2));
        System.out.println(processPayment(payment3));
    }
}

