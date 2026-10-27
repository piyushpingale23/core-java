package com.core.java.design_pattern.structural.decorator;


interface Coffee {
    String getDescription();
    double getCost();
}

// Original object
class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 100;
    }
}

// Base decorator
abstract class CoffeeDecorator implements Coffee {

    protected final Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// Decorator 1: Adds milk
class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 20;
    }
}

// Decorator 2: Adds chocolate
class ChocolateDecorator extends CoffeeDecorator {

    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Chocolate";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 30;
    }
}

public class DecoratorPatternExample {

    public static void main(String[] args) {

        // Order 1: Simple coffee
        Coffee coffee1 = new SimpleCoffee();

        System.out.println(coffee1.getDescription());
        System.out.println("Cost: Rs. " + coffee1.getCost());

        // Order 2: Coffee with milk
        Coffee coffee2 = new MilkDecorator(new SimpleCoffee());

        System.out.println("\n" + coffee2.getDescription());
        System.out.println("Cost: Rs. " + coffee2.getCost());

        // Order 3: Coffee with milk and chocolate
        Coffee coffee3 = new ChocolateDecorator(new MilkDecorator(new SimpleCoffee()));

        System.out.println("\n" + coffee3.getDescription());
        System.out.println("Cost: Rs. " + coffee3.getCost());
    }
}

