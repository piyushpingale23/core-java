# Java 12 — String Methods

## 1. `indent(int n)` and `transform(Function)`

- `indent(int n)`: Adds or removes leading spaces from each line. It also normalizes line endings and ensures each line ends with a newline.
- `transform(Function)`: Applies a function to a string and returns the result, which can be a different data type.

## Example

```java
import java.util.function.Function;

public class Java12StringMethods {
    public static void main(String[] args) {
        // indent(): Add 2 spaces to each line
        String text = "Java\nSpring Boot";
        System.out.print(text.indent(2));

        // transform(): Transform the string
        String name = "  java  ";
        String result = name.transform(value -> value.strip().toUpperCase());
        System.out.println(result);

        // transform(): Convert String to Integer
        int number = "100".transform(Integer::parseInt);
        System.out.println(number + 50);
    }
}
```

## Output

```text
  Java
  Spring Boot
JAVA
150
```

## Quick Revision

| Method                | Purpose                                                  |
|-----------------------|----------------------------------------------------------|
| `indent(2)`           | Adds two spaces to each line                             |
| `indent(-2)`          | Removes up to two leading whitespace characters per line |
| `transform(Function)` | Applies a function and returns its result                |
