# String, StringBuffer, StringBuilder in Java - Complete Notes

---

# 1. String in Java

---

## What is String?

* String is a **class** present in `java.lang` package.
* Used to represent **sequence of characters**.
* String objects are **immutable**.

---

## What is Immutability?

* Once a String object is created, its value **cannot be changed**.
* Any modification creates a **new object**.

---

## Example

```java
class Example {
   public static void main(String[] args) {
      String s = "Steve";
      s.concat(" Smith");

      System.out.println(s); // Steve

   }
}
```

```java
class Example {
   public static void main(String[] args) {
      String s = "Steve";
      s = s.concat(" Smith");
      System.out.println(s); // Steve Smith
   }
}
```

---

## Memory Concept (String Pool)

* Strings are stored in **String Constant Pool (SCP)** inside heap.
* Duplicate values are **not created again**.

```java
String s1 = "Java";
String s2 = "Java";
```

✔ Both refer to same object in SCP

---

## Creating String Objects

### 1. Using Literal

```java
String s = "Java";
```

---

### 2. Using new Keyword

```java
String s = new String("Java");
```

✔ Creates object in heap (not SCP)

---

## Important Methods

```java
class StringMethods {
   public static void main(String[] args) {
      String s = "Java Programming";

      s.length();
      s.toUpperCase();
      s.toLowerCase();
      s.charAt(0);
      s.substring(0, 4);
      s.contains("Java");
      s.equals("Java");
   }
}
```

---

## Why String is Immutable?

* Security (used in URLs, file paths)
* Thread-safe
* Caching (String Pool)
* Performance optimization

---

## String is Non-Synchronized

* No internal locking
* Thread-safe due to immutability
* Faster performance

---

# 2. StringBuffer in Java

---

## What is StringBuffer?

* Mutable class (can change value)
* Thread-safe
* Methods are **synchronized**

---

## Example

```java
class StringBufferExample {
   public static void main(String[] args) {
      StringBuilder stringBuffer = new StringBuilder("Hello");
      stringBuffer.append(" Jack");

      System.out.println(stringBuffer); // Hello Jack
   }
}
```

---

## Synchronization Concept

```java
public synchronized StringBuffer append(String str);
```

* Only one thread can access method at a time
* Other threads go to **BLOCKED state**

---

## Important Methods

```java
class StringBufferMethods {
   public static void main(String[] args) {
      sb.append("text");
      sb.insert(1, "A");
      sb.delete(1, 3);
      sb.reverse();
      sb.replace(1, 3, "XX");
   }
}
```

---

## Advantages

* Thread-safe
* Safe in multi-threading environment

---

## Disadvantages

* Slower due to synchronization

---

# 3. StringBuilder in Java

---

## What is StringBuilder?

* Mutable class
* Not thread-safe
* Not synchronized

---

## Example

```java
class StringBuilderExample {
   public static void main(String[] args) {
      StringBuilder sb = new StringBuilder("Hello");
      sb.append(" Java");

      System.out.println(sb); // Hello Java
   }
}
```

---

## Key Point

* Same as StringBuffer but **no synchronization**
* Faster performance

---

## When to Use?

* Single-threaded environment
* High performance required

---

# Difference Between String, StringBuffer, StringBuilder

| Feature         | String          | StringBuffer       | StringBuilder |
|-----------------|-----------------|--------------------|---------------|
| Nature          | Immutable       | Mutable            | Mutable       |
| Thread Safety   | Yes (immutable) | Yes (synchronized) | No            |
| Performance     | Fast            | Slow               | Fastest       |
| Synchronization | No              | Yes                | No            |
| Memory          | SCP + Heap      | Heap               | Heap          |

---

# Internal Working Summary

---

## String

* Stored in SCP
* Immutable → new object created on modification

---

## StringBuffer

* Uses synchronized methods
* Lock applied → thread-safe

---

## StringBuilder

* No locking
* Direct modification → faster

---

# Example Showing Difference

```java
public class Test {
    public static void main(String[] args) {

        String s = "Hello";
        s.concat(" World"); // new object created

        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World"); // same object modified

        StringBuilder sb2 = new StringBuilder("Hello");
        sb2.append(" World"); // same object modified

        System.out.println(s);   // Hello
        System.out.println(sb);  // Hello World
        System.out.println(sb2);// Hello World
    }
}
```

---

# Memory Visualization (Conceptual)

---

## String

```text
SCP:
"Java" ← s1, s2
```

---

## StringBuffer / StringBuilder

```text
Heap:
sb → Hello
(modified directly)
```

---

# When to Use What?

---

## Use String

* When data is fixed
* Read-only operations
* Security-sensitive data

---

## Use StringBuffer

* Multi-threaded environment
* Thread safety required

---

## Use StringBuilder

* Single-threaded environment
* Performance critical operations

---

# One-Line Summary

**String is immutable and safe, StringBuffer is mutable and synchronized, and StringBuilder is mutable but not synchronized (fastest).**

---

# Final Conclusion

* String → Safe + Immutable
* StringBuffer → Safe + Mutable (Slow)
* StringBuilder → Fast + Mutable (Not Safe)

---
