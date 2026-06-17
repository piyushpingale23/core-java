package com.core.java.java_8.stream_api;

import java.util.List;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        List<Integer> num = List.of(1, 2, 3, 4, 5);
        System.out.println(num);

        Stream<Integer> s = num.stream();
        System.out.println(s);
    }
}
