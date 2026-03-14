# Methods in Java

## 1. Introduction

A **method in Java** is a block of code that performs a specific task.
Methods help in **organizing code**, **reducing repetition**, and **improving readability**.

Instead of writing the same code multiple times, we can place that logic inside a method and **call it whenever needed**.

Example:

```java
public class MethodExample {
    public static void greet() {
        System.out.println("Hello, Welcome to Java!");
    }
    public static void main(String[] args) {
        greet();
    }
}
```

Output:

```
Hello, Welcome to Java!
```

---

# 2. Advantages of Methods

Methods provide several benefits:

* **Code Reusability** – Write once, use multiple times
* **Better Readability** – Code becomes easier to understand
* **Modularity** – Large programs can be divided into smaller parts
* **Easy Debugging** – Errors can be located easily

---

# 3. Syntax of a Method

```
accessModifier returnType methodName(parameters) {
    // method body
}
```

Example:

```java
public static int add(int a, int b) {
    return a + b;
}
```

Explanation:

| Part             | Description      |
|------------------|------------------|
| `public`         | Access modifier  |
| `static`         | Belongs to class |
| `int`            | Return type      |
| `add`            | Method name      |
| `(int a, int b)` | Parameters       |
| `return`         | Returns result   |

---

# 4. Types of Methods in Java

Methods are mainly categorized into **two types**:

1. Predefined Methods
2. User-defined Methods

---

## 4.1 Predefined Methods

These methods are **already defined in Java libraries**.

Example:

```java
class PreDefinedMethods {
    public static void main(String[] args) {
        System.out.println("Hello");
        Math.sqrt(25);
    }
}
```

Here:

* `println()` is a predefined method
* `sqrt()` is a predefined method

---

## 4.2 User-defined Methods

Methods created by programmers to perform specific tasks.

Example:

```java
public class AddExample {
    public static int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        int result = add(10, 20);
        System.out.println("Sum: " + result);
    }
}
```

---

# 5. Method with No Return Value

A method that does not return anything uses the **void** keyword.

Example:

```java
public static void displayMessage() {
    System.out.println("Learning Java Methods");
}
```

---

# 6. Method with Return Value

A method can return a value using the **return** statement.

Example:

```java
public static int multiply(int a, int b) {
    return a * b;
}
```

---

# 7. Method with Parameters

Parameters allow methods to **receive values**.

Example:

```java
class MethodWithParameter {
    public static void greet(String name) {
        System.out.println("Hello " + name);
    }
}
```

Calling the method:

```
greet("Piyush");
```

Output:

```
Hello Piyush
```

---

# 8. Method Overloading

Method overloading means **multiple methods with the same name but different parameters**.

Example:

```java
public class MethodOverloading {
    static int add(int a, int b) {
        return a + b;
    }
    static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        System.out.println(add(5, 10));
        System.out.println(add(5, 10, 15));
    }
}
```

Output:

```
15
30
```

---

# 9. Method Calling

A method can be called from another method.

Example:

```java
public class MethodCallExample {
    static void display() {
        System.out.println("Inside display method");
    }
    public static void main(String[] args) {
        display();
    }
}
```

---

# 10. Important Points

* A method performs a **specific task**
* Methods help in **code reuse**
* Methods can **return values**
* Methods can **accept parameters**
* Multiple methods with the same name can exist using **method overloading**
