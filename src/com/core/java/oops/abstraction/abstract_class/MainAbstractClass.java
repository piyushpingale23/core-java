package com.core.java.oops.abstraction.abstract_class;

public class MainAbstractClass {

    public static void main(String[] args) {

        Vehicle car = new Car("Honda City");
        car.showInfo();
        car.start();

        System.out.println("----------------");

        Vehicle bike = new Bike("Yamaha R15");
        bike.showInfo();
        bike.start();
    }

}
