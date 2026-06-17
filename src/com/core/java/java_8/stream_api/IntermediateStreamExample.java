package com.core.java.java_8.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateStreamExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("A", "X", "P", "A", "D", "B");
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 1, 10, 12);

        // =====================================================
        // filter()
        // Used to select elements matching a condition.
        // =====================================================
        System.out.println("filter() example: (starts with P)");
        names.stream()
                .filter(name -> name.startsWith("P"))
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // map()
        // Used to transform each element into another form.
        // =====================================================
        System.out.println("map() example: (transform to loweCase)");
        names.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // sorted()
        // Used to sort elements in natural order.
        // =====================================================
        System.out.println("sorted() example: (Default Natural Sorting)");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("Ascending Sorting List : " + numbers);

        System.out.println("------------------------------");

        System.out.println("sorted() example: (Descending Order)");
        numbers.stream()
                .sorted((a,b) -> a > b ? -1 : a < b ? 1 : 0)
//                .sorted((a,b) -> b.compareTo(a))
                .forEach(System.out::println);
        System.out.println("Descending Sorting List : " + numbers);

        System.out.println("--------------------");


        // =====================================================
        // distinct()
        // Used to remove duplicate elements.
        // =====================================================
        System.out.println("distinct() example:");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // limit()
        // Used to restrict the number of elements.
        // =====================================================
        System.out.println("limit() example:");
        names.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // skip()
        // Used to skip first N elements.
        // =====================================================
        System.out.println("skip() example:");
        names.stream()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // flatMap()
        // Used to flatten nested collections/streams.
        // =====================================================
        System.out.println("flatMap() example:");
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Java", "Spring"),
                Arrays.asList("Hibernate", "Kafka")
        );

        listOfLists.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // sorted(Comparator)
        // Used for custom sorting logic.
        // =====================================================
        System.out.println("sorted(Comparator) Example: ");
        names.stream()
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // takeWhile() (Java 9+)
        // Takes elements until condition becomes false.
        // =====================================================

        numbers.stream()
                .takeWhile(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // dropWhile() (Java 9+)
        // Skips elements until condition becomes false.
        // =====================================================
        numbers.stream()
                .dropWhile(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // Stream.concat()
        // Combines two streams into one stream.
        // =====================================================
        Stream<String> stream1 = Stream.of("Java", "Spring");
        Stream<String> stream2 = Stream.of("Kafka", "Docker");

        Stream.concat(stream1, stream2)
                .forEach(System.out::println);
    }
}
//
//        | Intermediate Operation | Purpose                     |
//        | ---------------------- | --------------------------- |
//        | `filter()`             | Select matching elements    |
//        | `map()`                | Transform elements          |
//        | `flatMap()`            | Flatten nested structures   |
//        | `sorted()`             | Sort elements               |
//        | `distinct()`           | Remove duplicates           |
//        | `limit()`              | Restrict number of elements |
//        | `skip()`               | Ignore first N elements     |
//        | `peek()`               | Debug stream processing     |
//        | `takeWhile()`          | Take until condition fails  |
//        | `dropWhile()`          | Skip until condition fails  |
//        | `Stream.concat()`      | Merge two streams           |

