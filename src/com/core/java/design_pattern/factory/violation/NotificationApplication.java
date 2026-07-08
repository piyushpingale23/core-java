package com.core.java.design_pattern.factory.violation;

public class NotificationApplication {

    public static void main(String[] args) {

        String notificationType = "EMAIL";
        String message = "Welcome to our home!";

        if ("EMAIL".equalsIgnoreCase(notificationType)) {

            EmailNotificationService service = new EmailNotificationService();
            service.send(message);

        } else if ("SMS".equalsIgnoreCase(notificationType)) {

            SmsNotificationService service = new SmsNotificationService();
            service.send(message);

        } else if ("WHATSAPP".equalsIgnoreCase(notificationType)) {

            WhatsappNotificationService service = new WhatsappNotificationService();
            service.send(message);

        } else {
            throw new IllegalArgumentException("Invalid Notification Type");
        }
    }
}

class EmailNotificationService {

    public void send(String message) {
        System.out.println("Email Sent: " + message);
    }
}

class SmsNotificationService {

    public void send(String message) {
        System.out.println("SMS Sent: " + message);
    }
}

class WhatsappNotificationService {

    public void send(String message) {
        System.out.println("WhatsApp Sent: " + message);
    }
}
