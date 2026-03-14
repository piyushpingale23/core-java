# Data Types in Java

## 1. Introduction

A **Data Type** in Java defines the **type of value that a variable can store**.
It also determines:

* The **size of memory** allocated to the variable
* The **range of values** that can be stored
* The **operations** that can be performed on the variable

Example:

```java
int age = 25;
```

Here:

* `int` → Data Type
* `age` → Variable
* `25` → Value

Java is a **strongly typed language**, meaning every variable must have a defined data type before it is used.

---

# 2. Categories of Data Types in Java

Java data types are divided into **two main categories**.

```
Data Types
│
├── Primitive Data Types
│
└── Non-Primitive Data Types
```

---

# 3. Primitive Data Types

Primitive data types are **built-in data types provided by Java**.
They store **actual values directly in memory**.

Java has **8 primitive data types**.

| Data Type | Size    | Description                     | Example |
|-----------|---------|---------------------------------|---------|
| byte      | 1 byte  | Stores small integer values     | 10      |
| short     | 2 bytes | Stores medium integer values    | 100     |
| int       | 4 bytes | Most commonly used integer type | 1000    |
| long      | 8 bytes | Stores large integer values     | 100000L |
| float     | 4 bytes | Stores decimal numbers          | 10.5f   |
| double    | 8 bytes | Stores large decimal numbers    | 20.99   |
| char      | 2 bytes | Stores a single character       | 'A'     |
| boolean   | 1 bit   | Stores true or false values     | true    |

---

# 4. Example of Primitive Data Types

```java
public class PrimitiveExample {

    public static void main(String[] args) {

        byte age = 25;
        short year = 2025;
        int salary = 50000;
        long population = 7800000000L;

        float price = 10.5f;
        double balance = 15000.75;

        char grade = 'A';

        boolean isJavaFun = true;

        System.out.println(age);
        System.out.println(year);
        System.out.println(salary);
        System.out.println(population);
        System.out.println(price);
        System.out.println(balance);
        System.out.println(grade);
        System.out.println(isJavaFun);
    }
}
```

---

# 5. Non-Primitive Data Types

Non-primitive data types are also known as **Reference Types**.

Instead of storing actual values, they **store references (memory addresses)** of objects.

Examples of non-primitive data types include:

* String
* Arrays
* Classes
* Objects
* Interfaces

These types are created by the programmer or provided by Java libraries.

---

# 6. Example of Non-Primitive Data Types

```java
public class NonPrimitiveExample {

    public static void main(String[] args) {

        // String example
        String name = "Jack";

        // Array example
        int[] numbers = {10, 20, 30, 40};

        System.out.println(name);

        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
```

---

# 7. Primitive vs Non-Primitive Data Types

| Feature        | Primitive           | Non-Primitive        |
|----------------|---------------------|----------------------|
| Memory Storage | Stores actual value | Stores reference     |
| Size           | Fixed               | Not fixed            |
| Created By     | Java Language       | Programmer           |
| Examples       | int, char, boolean  | String, Array, Class |

---

# 8. Use Cases of Data Types

### Storing Age

```java
int age = 30;
```

### Storing Price

```java
double price = 199.99;
```

### Storing a Character

```java
char grade = 'A';
```

### Storing True / False

```java
boolean isLoggedIn = true;
```

### Storing Text

```java
String message = "Welcome to Java";
```

---

# 9. Important Points

* Java has **8 primitive data types**.
* Primitive types store **actual values**.
* Non-primitive types store **references to objects**.
* Data types help Java **manage memory efficiently**.
* Choosing the correct data type improves **performance and readability**.

---

# 10. Conclusion

Data types are one of the **fundamental concepts in Java programming**.
They define how data is stored, processed, and manipulated within a program.

Understanding data types is essential before learning advanced Java concepts such as:

* Classes and Objects
* Collections
* Multithreading
* File Handling
