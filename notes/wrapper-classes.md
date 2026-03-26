# Wrapper Classes in Java

## Introduction

> **Wrapper classes in Java are used to convert primitive data types into objects.**

Java provides a wrapper class for each primitive type so that they can be used in object-based operations like collections, generics, and APIs.

---

## Primitive Types and Their Wrapper Classes

| Primitive Type | Wrapper Class |
|----------------|---------------|
| `byte`         | `Byte`        |
| `short`        | `Short`       |
| `int`          | `Integer`     |
| `long`         | `Long`        |
| `float`        | `Float`       |
| `double`       | `Double`      |
| `char`         | `Character`   |
| `boolean`      | `Boolean`     |

---

## Why Wrapper Classes?

1. **Collections Framework**

    * Collections (like `ArrayList`) work only with objects
    * Cannot store primitive types directly

2. **Utility Methods**

    * Wrapper classes provide useful methods like parsing, comparison, etc.

3. **Object Representation**

    * Needed when working with APIs that require objects

---

## Autoboxing and Unboxing

### Autoboxing

> Automatic conversion of primitive → wrapper object by java compiler

```java
int a = 10;
Integer obj = a; // Autoboxing
```

```
- Autoboxing internally uses Integer.valueOf().
- But since you didn’t write it explicitly, it's called autoboxing.
- Autoboxing is automatic, while valueOf() is manual boxing.
- valueOf() method is available in all wrapper classes in Java.
```

### Unboxing

> Automatic conversion of wrapper object → primitive

```java
Integer obj = 20;
int b = obj; // Unboxing
```

````
- Unboxing internally uses methods like intValue(), doubleValue(), floatValue(), longValue(), etc.
- But since you didn’t write it explicitly, it's called autoboxing.
````

---

## Creating Wrapper Objects

### 1. Using Constructor (Deprecated in modern Java)

```
Integer obj = new Integer(10);
```

### 2. Using `valueOf()` (Recommended)

```
Integer obj = Integer.valueOf(10);
```

| Wrapper Class | Example                    |
|---------------|----------------------------|
| `Integer`     | `Integer.valueOf(10)`      |
| `Double`      | `Double.valueOf(10.5)`     |
| `Float`       | `Float.valueOf(10.5f)`     |
| `Long`        | `Long.valueOf(100L)`       |
| `Short`       | `Short.valueOf((short)10)` |
| `Byte`        | `Byte.valueOf((byte)1)`    |
| `Boolean`     | `Boolean.valueOf(true)`    |
| `Character`   | `Character.valueOf('A')`   |


---

## Important Methods

### Parsing Methods

```java
int num = Integer.parseInt("123");
double d = Double.parseDouble("10.5");
```

### toString()

```java
Integer obj = 100;
String str = obj.toString();
```

### compareTo()

```
Integer a = 10, b = 20;
System.out.println(a.compareTo(b)); // -1
```

---

## Immutability

> Wrapper classes are **immutable** (once created, their value cannot be changed)

```
Integer a = 10;
a = 20; // New object is created
```

---

## Null Handling

```java
Integer a = null;
int b = a; // NullPointerException (during unboxing)
```

---

## Advantages

* Enables use of primitives in collections
* Provides utility methods
* Supports object-oriented features

---

## Disadvantages

* Extra memory overhead
* Slight performance cost compared to primitives

---

## 1-Line Summary

> **Wrapper classes convert primitive data types into objects, so they can be used in object-oriented features like collections and APIs.**

---

## Example Program

```java
import java.util.*;

public class WrapperExample {
    public static void main(String[] args) {

        // Autoboxing
        int a = 10;
        Integer obj = a;

        // Unboxing
        int b = obj;

        // Using in Collection
        List<Integer> list = new ArrayList<>();
        list.add(10); // Autoboxing

        // Parsing
        int num = Integer.parseInt("123");

        System.out.println(obj);
        System.out.println(b);
        System.out.println(list);
        System.out.println(num);
    }
}
```
