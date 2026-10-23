# Java 9 Features

## 1. Module System (JPMS)

### Definition

The Java Platform Module System (JPMS) was introduced in Java 9 to organize packages into modules, declare dependencies explicitly, and control which packages are accessible to other modules.

A module is a group of packages and resources described by a `module-info.java` file.

### Why was it introduced?

Before Java 9, packages helped organize classes, but they did not provide a complete mechanism for declaring module dependencies or exposing selected packages to other modules.

The Module System provides:
- Explicit dependencies between modules.
- Better encapsulation of internal packages.
- Controlled access to public APIs.
- Support for creating custom Java runtime images using `jlink`.

---

## 2. JShell

### Definition

JShell is an interactive Java shell introduced in Java 9. It allows developers to execute Java expressions, statements, variable declarations, and method declarations without creating a complete Java source file.

JShell is a REPL:

- Read
- Evaluate
- Print
- Loop

### Why was it introduced?

Before Java 9, testing a simple Java expression generally required a class and a `main()` method when running a normal Java program.

JShell makes it easier to experiment with Java syntax and APIs without that boilerplate.

### How to start JShell

Run this command in the terminal:

```bash
jshell
```

### Example 1: Execute expressions

```
jshell> 10 + 20
$1 ==> 30

jshell> "java".toUpperCase()
$2 ==> "JAVA"
```

JShell evaluates the expressions and displays their results.

### Example 2: Declare variables

```
jshell> int a = 10;
jshell> int b = 20;
jshell> int sum = a + b;
jshell> sum
sum ==> 30
```

Variables declared in a JShell session remain available in subsequent snippets.

### Example 3: Declare a method

```
jshell> int square(int number) {
   ...>     return number * number;
   ...> }
```

Call the method:

```
jshell> square(5)
$1 ==> 25
```

A class declaration and `main()` method are not required for this snippet.

### Useful JShell commands

| Command    | Purpose                      |
|------------|------------------------------|
| `/help`    | Displays help.               |
| `/list`    | Lists entered snippets.      |
| `/vars`    | Displays declared variables. |
| `/methods` | Displays declared methods.   |
| `/reset`   | Resets the session.          |
| `/exit`    | Exits JShell.                |

### Important points

- JShell is a development and learning tool.
- It supports expressions, statements, variable declarations, and method declarations.
- It is useful for quickly testing Java APIs, Streams, collections, and algorithms.
- JShell does not eliminate the need for classes in ordinary Java application code.

---

## 3. Factory Methods for Collections

### Definition

Java 9 introduced static factory methods to create small, unmodifiable collections with concise syntax.

The main methods are:

- `List.of()`
- `Set.of()`
- `Map.of()`
- `Map.ofEntries()`
- `Map.entry()`

### Why were they introduced?

Before Java 9, creating a collection often required creating an object and inserting elements individually.

Java 9 provides a shorter way to declare collections containing predefined values.

### 3.1 List.of()

Creates an unmodifiable list.

```java
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Python", "JavaScript");
        System.out.println(languages);
        System.out.println(languages.getFirst());
    }
}
```

Output:

```text
[Java, Python, JavaScript]
Java
```

Important points:
- Preserves insertion order.
- Allows duplicate elements.
- Rejects `null` elements.
- Does not support adding, removing, or replacing elements.

### 3.2 Set.of()

Creates an unmodifiable set.

```java
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> languages = Set.of("Java", "Python", "JavaScript");
        System.out.println(languages);
        System.out.println(languages.contains("Java"));
    }
}
```

Example output:

```text
[Java, Python, JavaScript]
true
```

The iteration order is not guaranteed.

Important points:
- Stores unique elements.
- Duplicate elements cause `IllegalArgumentException`.
- Rejects `null` elements.
- Does not support adding or removing elements.

### 3.3 Map.of()

Creates an unmodifiable map from key-value pairs.

```java
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> employees = Map.of(
                101, "Amit",
                102, "Piyush",
                103, "Rahul"
        );
        System.out.println(employees);
        System.out.println(employees.get(102));
    }
}
```

Output of the second statement:

```text
Piyush
```

Important points:
- Accepts up to 10 key-value pairs.
- Keys must be unique.
- Keys and values cannot be `null`.
- The resulting map is unmodifiable.
- Map iteration order is not guaranteed.

### 3.4 Map.ofEntries() and Map.entry()

`Map.ofEntries()` creates a map from entry objects. It supports a variable number of entries.

```java
import java.util.Map;

public class MapEntriesExample {
    public static void main(String[] args) {
        Map<Integer, String> departments = Map.ofEntries(
                Map.entry(1, "Engineering"),
                Map.entry(2, "Finance"),
                Map.entry(3, "HR")
        );
        System.out.println(departments);
        System.out.println(departments.get(1));
    }
}
```

Output of the second statement:

```text
Engineering
```

Important points:
- `Map.entry(key, value)` creates an unmodifiable entry.
- `Map.ofEntries()` combines entries into an unmodifiable map.
- Duplicate keys cause `IllegalArgumentException`.
- Null keys and values are not allowed.

### Unmodifiable versus immutable

A collection created using these factory methods cannot have its structure modified through its collection API.

However, this does not make mutable objects stored inside the collection immutable.

```java
import java.util.List;

public class UnmodifiableExample {
    public static void main(String[] args) {
        List<StringBuilder> values = List.of(new StringBuilder("Java"));
        values.getFirst().append(" 9");
        System.out.println(values);
    }
}
```

Output:

```text
[Java 9]
```

The list structure remains unmodifiable, but the contained `StringBuilder` object is mutable.

### Creating a modifiable collection

If modification is required, create a separate `ArrayList`.

```java
import java.util.ArrayList;
import java.util.List;

public class ModifiableListExample {
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>(List.of("Java", "Python"));
        languages.add("JavaScript");
        System.out.println(languages);
    }
}
```

Output:

```text
[Java, Python, JavaScript]
```

---

## 4. Private Interface Methods

### Definition

Java 9 introduced private methods in interfaces to allow default and static methods to share internal implementation logic.

These methods reduce code duplication without exposing helper methods as part of the interface's public API.

### Why were they introduced?

Java 8 introduced default and static methods in interfaces.

However, multiple interface methods could require the same internal logic. Without private interface methods, developers often had to duplicate that logic.

Java 9 allows the shared logic to be placed in private helper methods.

### 4.1 Private instance method

```java
interface NotificationService {

    private void validateNotification() {
        System.out.println("Validating notification");
    }

    default void sendEmail() {
        validateNotification();
        System.out.println("Sending email");
    }

    default void sendSMS() {
        validateNotification();
        System.out.println("Sending SMS");
    }
}

class NotificationServiceImpl implements NotificationService {
}

public class PrivateInterfaceMethodDemo {
    public static void main(String[] args) {
        NotificationService service = new NotificationServiceImpl();
        service.sendEmail();
        service.sendSMS();
    }
}
```

Output:

```text
Validating notification
Sending email
Validating notification
Sending SMS
```

Explanation:
- `validateNotification()` is private and can be called from permitted method bodies within the interface.
- `sendEmail()` and `sendSMS()` are default methods.
- The implementing class inherits the default methods.
- The implementing class cannot call the private helper directly.

### 4.2 Private static method

Private static methods allow static interface methods to share common logic.

```java
interface UtilityService {

    private static void logOperation() {
        System.out.println("Logging operation");
    }

    static void operationA() {
        logOperation();
        System.out.println("Executing operation A");
    }

    static void operationB() {
        logOperation();
        System.out.println("Executing operation B");
    }
}

public class PrivateStaticInterfaceMethodDemo {
    public static void main(String[] args) {
        UtilityService.operationA();
        UtilityService.operationB();
    }
}
```

Output:

```text
Logging operation
Executing operation A
Logging operation
Executing operation B
```

### Rules for private interface methods

- Private interface methods must have a method body.
- They cannot be `abstract`, `default`, or `protected`.
- Private instance methods can be called by suitable instance method bodies in the interface.
- Private static methods can be called by suitable static method bodies in the interface