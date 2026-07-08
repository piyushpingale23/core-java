package com.core.java.design_pattern.factory.compliance;

/*
 * Factory Pattern is used when object creation
 * depends on some condition, and we want to
 * centralize that creation logic in one place
 * instead of scattering new ClassName()
 * throughout the application.
 */
public class FactoryMain {

    public static void main(String[] args) {

        NotificationService emailService = NotificationFactory.getService("email");
        emailService.send("Email sent successfully!");

        NotificationService smsService = NotificationFactory.getService("sms");
        smsService.send("SMS sent successfully!");
    }
}
