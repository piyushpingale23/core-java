# Java 21 — Virtual Threads and Sequenced Collections

## 1. Virtual Threads

- Lightweight threads managed by the JVM.
- Designed to support high concurrency, especially for I/O-heavy tasks.
- Useful for tasks waiting on database calls, HTTP requests, or other blocking operations.
- Improve scalability and throughput, not CPU-bound execution speed.
- Became permanent in Java 21.

```java
public class Java21VirtualThreadsExample {

    public static void main(String[] args) throws InterruptedException {

        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println(
                    "Is virtual thread: "
                            + Thread.currentThread().isVirtual()
            );
            System.out.println("Task executed");
        });

        virtualThread.join();
    }
}
```

Output:

```text
Is virtual thread: true
Task executed
```

## 2. Sequenced Collections

- Introduced a consistent API for collections with a defined encounter order.
- `getFirst()` and `getLast()` retrieve the first and last elements.
- `addFirst()` and `addLast()` add elements at either end when supported.
- `removeFirst()` and `removeLast()` remove elements from either end.
- `reversed()` provides a reverse-ordered view of the collection.

```java
import java.util.ArrayList;
import java.util.List;

public class Java21SequencedCollectionsExample {

    public static void main(String[] args) {

        List<String> languages = new ArrayList<>(
                List.of("Java", "Python", "SQL")
        );

        System.out.println("Original: " + languages);

        System.out.println("First: " + languages.getFirst());
        System.out.println("Last: " + languages.getLast());

        languages.addFirst("C");
        languages.addLast("JavaScript");

        System.out.println("After adding: " + languages);
        System.out.println("Reversed: " + languages.reversed());

        languages.removeFirst();
        languages.removeLast();

        System.out.println("Final list: " + languages);
    }
}
```

Output:

```text
Original: [Java, Python, SQL]
First: Java
Last: SQL
After adding: [C, Java, Python, SQL, JavaScript]
Reversed: [JavaScript, SQL, Python, Java, C]
Final list: [Java, Python, SQL]
```
