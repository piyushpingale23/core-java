# Operators in Java

## 1. Introduction

In Java, **operators** are special symbols used to perform operations on variables and values.
They are used to manipulate data and perform calculations or logical comparisons.

Example:

```java
int a = 10;
int b = 5;
int result = a + b;
```

In the above example, `+` is an **operator** used to add two numbers.

---

# 2. Types of Operators in Java

Java provides several types of operators:

1. Arithmetic Operators
2. Relational Operators
3. Logical Operators
4. Assignment Operators
5. Unary Operators
6. Ternary Operator
7. Bitwise Operators

---

# 3. Arithmetic Operators

Arithmetic operators are used to perform **mathematical calculations**.

| Operator | Description         | Example |
|----------|---------------------|---------|
| +        | Addition            | a + b   |
| -        | Subtraction         | a - b   |
| *        | Multiplication      | a * b   |
| /        | Division            | a / b   |
| %        | Modulus (remainder) | a % b   |

Example:

```java
class Arithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first element -> ");
        int a = sc.nextInt();
        System.out.print("Enter second element -> ");
        int b = sc.nextInt();

        System.out.println(a + b); // 13
        System.out.println(a - b); // 7
        System.out.println(a * b); // 30
        System.out.println(a / b); // 3
        System.out.println(a % b); // 1
    }
}
```

---

# 4. Relational Operators

Relational operators are used to **compare two values**.
They return a **boolean value (true or false)**.

| Operator | Description              |
|----------|--------------------------|
| ==       | Equal to                 |
| !=       | Not equal to             |
| >        | Greater than             |
| <        | Less than                |
| >=       | Greater than or equal to |
| <=       | Less than or equal to    |

Example:

```java
class Relational {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first element -> ");
        int a = sc.nextInt();
        System.out.print("Enter second element -> ");
        int b = sc.nextInt();

        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
    }
}
```

---

# 5. Logical Operators

Logical operators are used to **combine multiple conditions**.

| Operator | Description |
|----------|-------------|
| &&       | Logical AND |
|          |             |       | Logical OR  |
| !        | Logical NOT |

Example:

```java
class Logical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age -> ");
        int age = sc.nextInt();

        System.out.println(age > 18 && age < 30);
        System.out.println(age > 18 || age < 10);
        System.out.println(!(age > 18));
    }
}
```

---

# 6. Assignment Operators

Assignment operators are used to **assign values to variables**.

| Operator | Example | Meaning      |
|----------|---------|--------------|
| =        | a = 10  | Assign value |
| +=       | a += 5  | a = a + 5    |
| -=       | a -= 5  | a = a - 5    |
| *=       | a *= 5  | a = a * 5    |
| /=       | a /= 5  | a = a / 5    |
| %=       | a %= 5  | a = a % 5    |

Example:

```java
class Assignment {
    public static void main(String[] args) {
        int a = 10;

        a += 5;
        a -= 3;
        a *= 2;
    }
}
```

---

# 7. Unary Operators

Unary operators operate on **a single operand**.

| Operator | Description |
|----------|-------------|
| +        | Unary plus  |
| -        | Unary minus |
| ++       | Increment   |
| --       | Decrement   |
| !        | Logical NOT |

Example:

```java
class Unary {
    public static void main(String[] args) {
        int a = 10;
        a++;
        a--;
        System.out.println(a);
    }
}
```

---

# 8. Ternary Operator

The ternary operator is a **short form of the if-else statement**.

Syntax:

```
condition ? expression1 : expression2
```

Example:

```java
import java.util.Scanner;

class Ternary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age -> ");
        int age = sc.nextInt();
        String result = (age >= 18) ? "Eligible" : "Not Eligible";
        System.out.println(result);
    }
}
```

---

# 9. Bitwise Operators

Bitwise operators perform operations on **binary bits of integers**.

| Operator | Description        |
|----------|--------------------|
| &        | Bitwise AND        |
|          |                    | Bitwise OR         |
| ^        | Bitwise XOR        |
| ~        | Bitwise Complement |
| <<       | Left shift         |
| >>       | Right shift        |

Example:

```java
class Bitwise {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
    }
}
```

---

# 10. Operator Precedence Table (High → Low)

| Precedence | Operators                   | Description               |   |            |
|------------|-----------------------------|---------------------------|---|------------|
| Highest    | `()`                        | Parentheses               |   |            |
|            | `++`, `--`, `!`             | Unary operators           |   |            |
|            | `*`, `/`, `%`               | Multiplication / Division |   |            |
|            | `+`, `-`                    | Addition / Subtraction    |   |            |
|            | `<`, `>`, `<=`, `>=`        | Relational                |   |            |
|            | `==`, `!=`                  | Equality                  |   |            |
|            | `&&`                        | Logical AND               |   |            |
|            | `                           |                           | ` | Logical OR |
|            | `?:`                        | Ternary                   |   |            |
| Lowest     | `=`, `+=`, `-=`, `*=`, `/=` | Assignment                |   |            |


---

# 11. Summary

Operators are essential in Java for performing calculations, comparisons, and logical operations.
Understanding different types of operators helps in writing efficient and readable programs.

Main operator categories include:

* Arithmetic operators
* Relational operators
* Logical operators
* Assignment operators
* Unary operators
* Ternary operator
* Bitwise operators

These operators are widely used in **conditions, loops, calculations, and decision-making in Java programs**.
