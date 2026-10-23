# Java 11 Features — HTTP Client API and String Methods

## 1. Standard HTTP Client API

### What is the HTTP Client API?

Java 11 standardized the HTTP Client API, which was introduced as an incubator feature in Java 9. It allows Java applications to send HTTP requests and receive responses without requiring an external HTTP client library.

Package: `java.net.http`

**Main classes**

| Class             | Purpose                                  |
|-------------------|------------------------------------------|
| `HttpClient`      | Sends HTTP requests                      |
| `HttpRequest`     | Represents the request                   |
| `HttpResponse<T>` | Represents the response                  |
| `BodyHandlers`    | Defines how the response body is handled |

### Synchronous HTTP Client Example

**Java11HttpClientExample.java**

```java
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Java11HttpClientExample {
    public static void main(String[] args) {

        // Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Build a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products"))
                .GET()
                .build();

        try {
            // Send the request synchronously
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print response details
            System.out.println("Status: " + response.statusCode());
            System.out.println("Body: " + response.body());

        } catch (IOException e) {
            System.err.println("Request failed: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Request interrupted.");
        }
    }
}
```

**Important methods**

| Method                       | Purpose                             |
|------------------------------|-------------------------------------|
| `HttpClient.newHttpClient()` | Creates an HTTP client              |
| `HttpRequest.newBuilder()`   | Starts building a request           |
| `URI.create(url)`            | Creates a URI                       |
| `.GET()`                     | Configures a GET request            |
| `client.send()`              | Sends a request synchronously       |
| `BodyHandlers.ofString()`    | Reads the response body as a String |
| `response.statusCode()`      | Returns the HTTP status code        |
| `response.body()`            | Returns the response body           |

`send()` blocks the calling thread until the response is available. Java 11 also provides `sendAsync()`, which returns a `CompletableFuture` for asynchronous processing.

---

## 2. New String Methods in Java 11

Java 11 introduced six useful String methods:

| Method            | Purpose                                                                 |
|-------------------|-------------------------------------------------------------------------|
| `isBlank()`       | Checks whether a String is empty or contains only recognized whitespace |
| `strip()`         | Removes leading and trailing recognized whitespace                      |
| `stripLeading()`  | Removes leading whitespace only                                         |
| `stripTrailing()` | Removes trailing whitespace only                                        |
| `lines()`         | Returns a `Stream<String>` of lines                                     |
| `repeat(int)`     | Repeats a String a specified number of times                            |

### `trim()` vs. `strip()`

- `trim()` removes leading and trailing characters whose values are less than or equal to `U+0020` (hexadecimal `20`, decimal `32`).
- `strip()` uses `Character.isWhitespace()` and recognizes additional Unicode whitespace characters.

For example, `U+0020` is a normal space, while `U+2003` is an em space.

```java
class TrimVsStrip {
    public static void main(String[] args) {
        String normalSpace = "   Java   ";
        String unicodeSpace = "\u2003Java\u2003";
        System.out.println("[" + normalSpace.trim() + "]");
        System.out.println("[" + unicodeSpace.trim() + "]");
        System.out.println("[" + unicodeSpace.strip() + "]");
    }
}
```

Output:

```text
[Java]
[ Java ]
[Java]
```

`trim()` leaves the em spaces because their code point exceeds `U+0020`. `strip()` removes them because `Character.isWhitespace()` recognizes them.

### Complete Example: Java11StringMethods.java

```java
public class Java11StringMethods {

    public static void main(String[] args) {

        // 1. isBlank(): empty or whitespace-only String
        System.out.println("".isBlank());       // true
        System.out.println("   ".isBlank());    // true
        System.out.println("Java".isBlank());   // false

        // 2. strip(): removes whitespace from both ends
        String value = "   Java 11   ";
        System.out.println("[" + value.strip() + "]");
        // [Java 11]

        // 3. stripLeading(): removes whitespace from the beginning
        System.out.println("[" + value.stripLeading() + "]");
        // [Java 11   ]

        // 4. stripTrailing(): removes whitespace from the end
        System.out.println("[" + value.stripTrailing() + "]");
        // [   Java 11]

        // 5. lines(): returns a stream of lines
        String languages = "Java\nPython\nJavaScript";

        languages.lines().forEach(System.out::println);
        // Java
        // Python
        // JavaScript

        // 6. repeat(int): repeats a String
        System.out.println("Java ".repeat(3));
        // Java Java Java

        // Difference between isEmpty() and isBlank()
        System.out.println("   ".isEmpty());    // false
        System.out.println("   ".isBlank());    // true

        // trim() vs strip() with Unicode whitespace
        String unicodeSpace = "\u2003Hello\u2003";

        System.out.println("[" + unicodeSpace.trim() + "]");
        // [ Hello ]

        System.out.println("[" + unicodeSpace.strip() + "]");
        // [Hello]
    }
}
```

### Important distinctions

| Method            | Key point                                                                                 |
|-------------------|-------------------------------------------------------------------------------------------|
| `isEmpty()`       | Checks whether the length is zero                                                         |
| `isBlank()`       | Checks whether the String is empty or all recognized whitespace                           |
| `trim()`          | Uses the `U+0020` character-value limit                                                   |
| `strip()`         | Uses `Character.isWhitespace()`                                                           |
| `stripLeading()`  | Preserves trailing whitespace                                                             |
| `stripTrailing()` | Preserves leading whitespace                                                              |
| `lines()`         | Produces a lazy stream of lines                                                           |
| `repeat(n)`       | Returns the String repeated `n` times; a negative count throws `IllegalArgumentException` |

All these methods preserve String immutability: they do not modify the original String.

---
