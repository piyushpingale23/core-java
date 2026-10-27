package com.core.java.design_pattern.creational.factory.compliance;

class EmailNotificationService implements NotificationService {

    public void send(String message) {
        System.out.println(message);
    }
}
