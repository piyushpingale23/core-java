package com.core.java.java_17.switch_pattern.compliance;

class Payment {
}

class UPIPayment extends Payment {

    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }
}

class CardPayment extends Payment {

    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

public class SwitchPatternCompliance {

    public static String processPayment(Payment payment) {

        return switch (payment) {
            case UPIPayment upi ->
                    "UPI: " + upi.getUpiId();

            case CardPayment card ->
                    "Card: " + card.getCardNumber();

            case null ->
                    "Payment is null";

            default ->
                    "Unknown payment";
        };
    }

    public static void main(String[] args) {

        Payment payment1 = new UPIPayment("piyush@upi");
        Payment payment2 = new CardPayment("1234567890123456");
        Payment payment3 = new Payment();

        System.out.println(processPayment(payment1));
        System.out.println(processPayment(payment2));
        System.out.println(processPayment(payment3));
        System.out.println(processPayment(null));
    }
}
