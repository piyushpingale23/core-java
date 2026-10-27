package com.core.java.design_pattern.behavioral.observer;

class MobileApp implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Mobile App received: " + message);
    }
}