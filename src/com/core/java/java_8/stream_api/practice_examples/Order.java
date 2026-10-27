package com.core.java.java_8.stream_api.practice_examples;

import lombok.*;
import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Comparable<Order> {
    Integer id;
    String name;
    double amount;

    public int compareTo(Order order) {
        return this.id.compareTo(order.id);
    }
}

class Main {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(2, 4, 1, 3, 5);
        List<Integer> ascNumbers = numbers.stream()
                .sorted()
                .toList();
        List<Integer> descNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Original: " + numbers);
        System.out.println("Ascending: " + ascNumbers);
        System.out.println("Descending: " + descNumbers);
        System.out.println("--------------------------------------------");


        Order o1 = new Order(1, "b", 10.2);
        Order o2 = new Order(3, "a", 1.5);
        Order o3 = new Order(2, "a", 10.1);

        List<Order> orderList = List.of(o1, o2, o3);

        // Sort by id
        List<Integer> sortAscById = orderList.stream()
                .sorted()
                .map(Order::getId)
                .toList();
        System.out.println("Sort Asc by Id: " + sortAscById);

        List<Integer> sortDescById = orderList.stream()
                .sorted((a, b) -> b.getId().compareTo(a.getId()))
                .map(Order::getId)
                .toList();
        System.out.println("Sort Desc by Id: " + sortDescById);

        // sort by name
        List<String> sortAscByName = orderList.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .map(Order::getName)
                .toList();
        System.out.println("Sort Asc by Name: " + sortAscByName);

        List<String> sortDescByName = orderList.stream()
                .sorted((a, b) -> b.getName().compareTo(a.getName()))
                .map(Order::getName)
                .toList();
        System.out.println("Sort Desc by Name: " + sortDescByName);

        // sort by amount
        List<Double> sortAscByAmount = orderList.stream()
//                .sorted((a, b) -> a.getAmount().compareTo(b.getAmount()))
                .sorted(Comparator.comparing(Order::getAmount))
                .map(Order::getAmount)
                .toList();
        System.out.println("Sort Asc by Amount: " + sortAscByAmount);

        List<Double> sortDescByAmount = orderList.stream()
//                .sorted((a, b) -> b.getAmount().compareTo(a.getAmount())) // applicable when we uses Double
                .sorted(Comparator.comparing(Order::getAmount).reversed())
                .map(Order::getAmount)
                .toList();
        System.out.println("Sort Desc by Amount: " + sortDescByAmount);
        System.out.println("--------------------------------------------");

        // sum of id
        int sumOdIds = orderList.stream()
                .mapToInt(Order::getId)
                .sum();
        System.out.println("Sum of Ids: " + sumOdIds);

        // avg of id
        double avgOfIds = orderList.stream()
                .mapToDouble(Order::getId)
                .average().getAsDouble();
        System.out.println("Average of Ids: " + avgOfIds);

        // sum of amount
        double sumOfAmounts = orderList.stream()
                .mapToDouble(Order::getAmount)
                .sum();
        System.out.println("Sum of Amounts: " + sumOfAmounts);

        //average of amount
        double avgOfAmounts = orderList.stream()
                .mapToDouble(Order::getAmount)
                .average().getAsDouble();
        System.out.println("Average of Amounts: " + avgOfAmounts);

    }

}

