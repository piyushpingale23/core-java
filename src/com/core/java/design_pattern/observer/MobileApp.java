package com.core.java.design_pattern.observer;

class MobileApp implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Mobile App received: " + message);
    }
}