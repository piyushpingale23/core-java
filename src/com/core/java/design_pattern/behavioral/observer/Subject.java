package com.core.java.design_pattern.behavioral.observer;

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}