package com.core.java.design_pattern.behavioral.observer;

class EmailService implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Email sent: " + message);
    }
}
