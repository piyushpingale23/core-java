package com.core.java.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

class NewsAgency implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void publishNews(String news) {
        System.out.println("News Published: " + news);
        notifyObservers(news);
    }
}
