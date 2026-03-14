# Scanner Class in Java

## 1. Introduction

The **Scanner class** in Java is used to **read input from different sources**, such as:

* Keyboard input (System.in)
* Files
* Strings

To use the Scanner class, we must **import it**.

```java
import java.util.Scanner;
```

The Scanner class is commonly used to **take user input from the keyboard** in Java programs.

---

# 2. Creating a Scanner Object

To read input from the keyboard, we create a Scanner object using `System.in`.

```java
Scanner scanner = new Scanner(System.in);
```

Example:

```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Name: " + name);
        scanner.close();
    }
}
```

---

# 3. Common Scanner Methods

| Method        | Description               |
|---------------|---------------------------|
| nextLine()    | Reads a full line of text |
| next()        | Reads a single word       |
| nextInt()     | Reads an integer value    |
| nextDouble()  | Reads a double value      |
| nextBoolean() | Reads a boolean value     |

---

# 4. Example: Reading String Input

```java
import java.util.Scanner;

public class ReadStringExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        scanner.close();
    }
}
```

---

# 5. Example: Reading Integer Input

```java
import java.util.Scanner;

public class ReadIntegerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        System.out.println("You entered: " + number);
        scanner.close();
    }
}
```

---

# 6. Example: Addition Using Scanner

```java
import java.util.Scanner;

public class AdditionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number:");
        int num2 = scanner.nextInt();
        int sum = num1 + num2;
        System.out.println("Sum = " + sum);
        scanner.close();
    }
}
```

---

# 7. Example: Multiple Inputs

```java
import java.util.Scanner;

public class StudentInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        System.out.println("Enter student age:");
        int age = scanner.nextInt();
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        scanner.close();
    }
}
```

---

# 8. Important Points

* Scanner class is used for **reading user input**.
* It belongs to the **java.util package**.
* It supports reading **different data types**.
* The Scanner object should be **closed after use** using:

```
scanner.close();
```

---

# 9. Difference Between next() and nextLine()

| Method     | Description                            |
|------------|----------------------------------------|
| next()     | Reads a single word                    |
| nextLine() | Reads the entire line including spaces |

Example:

Input

```
Java Programming
```

```
next() → Java
nextLine() → Java Programming
```

---

# 10. Package Structure Example

```
core-java
│
└── src
    └── main
        └── java
            └── scanner
                ├── ScannerExample.java
                ├── ReadStringExample.java
                ├── ReadIntegerExample.java
                ├── AdditionExample.java
                └── ArrayExample.java
```

---

# 11. Conclusion

The **Scanner class** is one of the most commonly used classes in Java for reading user input.

It provides easy methods to read:

* Strings
* Numbers
* Boolean values

Scanner is widely used in:

* Beginner Java programs
* Console-based applications
* Input handling in learning programs
