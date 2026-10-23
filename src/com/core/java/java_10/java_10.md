# Java 10 — Local Variable Type Inference (`var`)

## 1. Definition

Java 10 introduced Local Variable Type Inference using the `var` keyword.

It allows the compiler to infer the type of local variable from its initializer, reducing repetitive type declarations.

### Before Java 10

```java
String name = "Piyush";
int age = 25;
List<String> languages = new ArrayList<>();
```

### Java 10 onwards

```java
var name = "Piyush";
var age = 25;
var languages = new ArrayList<String>();
```

The compiler infers the types as `String`, `int`, and `ArrayList<String>`, respectively.

## 2. Why was `var` introduced?

Before Java 10, developers had to explicitly declare the type of every local variable.

In some declarations, the type information was repeated, making the code unnecessarily verbose.

Java 10 introduced `var` to:
- Reduce repetitive type declarations.
- Improve code readability when the initializer makes the type obvious.
- Simplify declarations involving generic types.
- Preserve Java's compile-time type safety.

**Important:** `var` does not make Java dynamically typed. The compiler determines the variable's type at compile time, and that type remains fixed.

## 3. How does `var` work?

Example:

```java
var name = "Piyush";
var age = 25;
var price = 99.5;
```

The compiler infers the following types:

| Declaration            | Inferred type |
|------------------------|---------------|
| `var name = "Piyush";` | `String`      |
| `var age = 25;`        | `int`         |
| `var price = 99.5;`    | `double`      |

Conceptually, the declarations are equivalent to:

```java
String name = "Piyush";
int age = 25;
double price = 99.5;
```

The compiler determines these types before the program executes.

## 4. Complete Example in a Single Class

The following example demonstrates the main uses of `var` in one Java source file.

```java
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class VarExample {

    public static void main(String[] args) {

        // Primitive types
        var number = 100;
        var price = 99.5;
        var isActive = true;
        var character = 'A';

        System.out.println("Number: " + number);
        System.out.println("Price: " + price);
        System.out.println("Active: " + isActive);
        System.out.println("Character: " + character);

        // String
        var name = "Piyush";
        System.out.println("Name: " + name);

        // Collection
        var languages = new ArrayList<String>();

        languages.add("Java");
        languages.add("Python");

        System.out.println("Languages: " + languages);

        // List factory method
        var numbers = List.of(10, 20, 30);
        System.out.println("Numbers: " + numbers);

        // Custom object
        var employee = new Employee("Piyush");
        System.out.println("Employee: " + employee.getName());

        // Enhanced for loop
        for (var language : languages) {
            System.out.println("Language: " + language);
        }

        // Traditional for loop
        for (var i = 0; i < 3; i++) {
            System.out.println("Index: " + i);
        }

        // Reassignment with a compatible type
        var age = 25;
        age = 26;

        System.out.println("Age: " + age);

        // age = "Java"; // Compilation error
    }

    // Nested class keeps the example in one source file.
    @Getter
    static class Employee {
        private final String name;
        Employee(String name) {
            this.name = name;
        }

    }
}
```

## 5. Where can `var` be used?

| Declaration                           | Allowed? | Reason                                                                          |
|---------------------------------------|----------|---------------------------------------------------------------------------------|
| `var name = "Java";`                  | Yes      | Type can be inferred.                                                           |
| `var number = 10;`                    | Yes      | Type can be inferred.                                                           |
| `var list = new ArrayList<String>();` | Yes      | Type can be inferred.                                                           |
| `var name;`                           | No       | Initializer is missing.                                                         |
| `var value = null;`                   | No       | Type cannot be inferred from `null` alone.                                      |
| `var a = 10, b = 20;`                 | No       | Multiple declarators are not allowed.                                           |
| `var` for a class field               | No       | `var` is restricted to local variable declarations.                             |
| `var` as a method return type         | No       | It is not a general replacement for a declared type.                            |
| `var` as a normal method parameter    | No       | Local variable type inference does not apply to ordinary parameters in Java 10. |

## 6. Violation Examples

### 6.1 Missing initializer

```java
var name;
```

Compilation error: the compiler cannot infer the variable's type.

### 6.2 Initializer is `null`

```java
var value = null;
```

Compilation error: `null` does not identify a specific variable type.

### 6.3 Using `var` for a field

```java
class Employee {
    var name = "Piyush";
}
```

Compilation error: `var` cannot declare instance fields.

### 6.4 Using `var` as a method return type

```java
public var getName() {
    return "Piyush";
}
```

Compilation error: `var` cannot be used as a method return type.

### 6.5 Multiple variables in one declaration

```java
var first = 10, second = 20;
```

Compilation error: a `var` declaration cannot declare multiple variables.

## 7. `var` Does Not Mean Dynamic Typing

```java
class Test {
    var number = 10;
    number = 20;        // Valid
    // number = "Java"; // Compilation error  
}

```

The compiler infers `number` as `int`. Its type cannot change after reassignment.

| Java with `var`               | Dynamic typing                                                                    |
|-------------------------------|-----------------------------------------------------------------------------------|
| Type inferred at compile time | Variable types may be determined or changed at runtime, depending on the language |
| Variable type remains fixed   | A variable may accept values of different types, depending on the language        |
| Java remains statically typed | Behavior depends on the language                                                  |


## 7. Quick Interview Revision

1. **Which Java version introduced `var`?** Java 10.
2. **What is local variable type inference?** The compiler determines a local variable's type from its initializer.
3. **Does `var` make Java dynamically typed?** No.
4. **Can `var` declare class fields?** No.
5. **Can `var` be used as a method return type?** No.
6. **Can a variable declared with `var` be reassigned?** Yes, with a value compatible with its inferred type.
7. **Can `var` be initialized with `null` alone?** No.
8. **Can `var` be used in enhanced `for` loops?** Yes.
9. **Can `var` be used for lambda parameters in Java 10?** No. Lambda parameter support using `var` was introduced in Java 11.
10. **Does `var` exist as a special runtime type?** No. The compiler infers the actual type.

## Summary

Java 10 introduced local variable type inference through `var` to reduce repetitive type declarations. It improves readability while retaining compile-time type safety.

Remember: `var` is a way to infer a type, not a replacement for Java's type system.