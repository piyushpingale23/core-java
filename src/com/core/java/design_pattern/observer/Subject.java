package com.core.java.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}