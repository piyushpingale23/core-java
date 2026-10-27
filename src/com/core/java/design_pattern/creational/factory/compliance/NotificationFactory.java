package com.core.java.design_pattern.creational.factory.compliance;

class NotificationFactory {

    public static NotificationService getService(String type) {

        return switch (type) {
            case "email" -> new EmailNotificationService();
            case "sms" -> new SmsNotificationService();
            default -> throw new IllegalArgumentException();
        };
    }
}
