package com.core.java.design_pattern.observer;

class EmailService implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Email sent: " + message);
    }
}
