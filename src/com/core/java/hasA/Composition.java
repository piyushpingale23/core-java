package com.core.java.hasA;

public class Composition {

    public static void main(String[] args) {

        Car c = new Car();
        c.startCar();
    }
}

class Engine {

    void start() {

    }
}

class Car {

    private final Engine engine;

    public Car() {
        engine = new Engine(); // Car creates Engine
    }

    void startCar() {
        engine.start();
    }
}

