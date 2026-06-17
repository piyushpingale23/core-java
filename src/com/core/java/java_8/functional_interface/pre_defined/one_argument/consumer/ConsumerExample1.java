package com.core.java.java_8.functional_interface.pre_defined.one_argument.consumer;

import java.util.function.Consumer;

public class ConsumerExample1 {

    public static void main(String[] args) {

        Consumer<String> consumer = System.out::println;
        consumer.accept("Consumer example");
    }
}
