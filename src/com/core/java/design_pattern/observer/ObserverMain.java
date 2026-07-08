package com.core.java.design_pattern.observer;

public class ObserverMain {

    public static void main(String[] args) {

        NewsAgency newsAgency = new NewsAgency();

        Observer mobile = new MobileApp();
        Observer email = new EmailService();

        newsAgency.addObserver(mobile);
        newsAgency.addObserver(email);

        newsAgency.publishNews("Java 21 Released!");
    }
}
