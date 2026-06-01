package com.core.java.hasA;

public class Composition {

    public static void main(String[] args) {

        Car c = new Car(new Engine());
        c.startCar();
    }
}

class Engine {

    void start() {
        System.out.println("Engine started!");
    }
}

class Car {

    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine; // Car creates Engine
    }

    void startCar() {
        engine.start();
    }
}

