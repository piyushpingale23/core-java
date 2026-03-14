# Control Statements in Java

## 1. Introduction

Control statements in Java are used to **control the flow of program execution**.

Normally, a Java program executes statements **sequentially (top to bottom)**.
However, control statements allow the program to:

* Make decisions
* Repeat tasks
* Jump to other parts of the program

Control statements are mainly divided into **three categories**:

1. Conditional Statements
2. Looping Statements
3. Jump Statements

---

# 2. Conditional Statements

Conditional statements are used to **execute code based on a condition**.

If the condition is **true**, a specific block of code is executed.
If the condition is **false**, another block may be executed.

## Types of Conditional Statements

* if
* if-else
* nested if
* switch

---

## 2.1 if Statement

The **if statement** executes a block of code **only if the condition is true**.

### Syntax

```
if(condition) {
    // code to execute
}
```

### Example

```java
class If {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age -> ");
        int age = sc.nextInt();
        if(age >= 18) {
            System.out.println("Eligible to vote");
        }
    }
}
```

---

## 2.2 if-else Statement

The **if-else statement** allows execution of one block if the condition is true
and another block if the condition is false.

### Syntax

```
if(condition) {
    // executes if condition is true
} else {
    // executes if condition is false
}
```

### Example

```java
class IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number -> ");
        int number = sc.nextInt();

        if(number % 2 == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
}
```

---

## 2.3 Nested if Statement

A **nested if** means an **if statement inside another if statement**.

This is used when multiple conditions must be checked.

### Example

```java
class NestedIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age -> ");
        int age = sc.nextInt();
        boolean hasLicense = true;
        if(age >= 18) {
            System.out.println("Allowed to drive");
        }
    }
}
```

---

## 2.4 switch Statement

The **switch statement** is used to select one block of code from multiple options.

It is commonly used when there are **multiple fixed values**.

### Syntax

```
switch(expression) {

    case value1:
        // code
        break;

    case value2:
        // code
        break;

    default:
        // default code
}
```

### Example

```java
import java.util.Scanner;

class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter day -> ");
        int day = sc.nextInt();

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
```

---

# 3. Looping Statements

Looping statements are used to **repeat a block of code multiple times** until a condition becomes false.

## Types of Loops

* for loop
* while loop
* do-while loop

---

## 3.1 for Loop

The **for loop** is commonly used when the number of iterations is known.

### Syntax

```
for(initialization; condition; update) {
    // code block
}
```

### Example

```java
class ForLoop {
    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}
```

---

## 3.2 while Loop

The **while loop** executes a block of code **while the condition is true**.

### Syntax

```
while(condition) {
    // code
}
```

### Example

```java
class WhileLoop {
    public static void main(String[] args) {
        int i = 1;
        while(i <= 5) {
            System.out.println(i);
            i++;
        }
    }
}
```

---

## 3.3 do-while Loop

The **do-while loop** executes the block of code **at least once**, even if the condition is false.

### Syntax

```
do {
    // code
} while(condition);
```

### Example

```java
class DoWhileLoop {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while(i <= 5);
    }
}
```

---

# 4. Jump Statements

Jump statements are used to **transfer control to another part of the program**.

Types of jump statements:

* break
* continue
* return

---

## 4.1 break Statement

The **break statement** is used to **exit a loop or switch statement immediately**.

### Example

```java
class Break {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            if(i == 5) {
                break;
            }
            System.out.println(i);
        }
    }
}
```

Output:

```
1
2
3
4
```

---

## 4.2 continue Statement

The **continue statement** skips the **current iteration of the loop** and moves to the next iteration.

### Example

```java
class Continue {
    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++) {
            if(i == 3) {
                continue;
            }
            System.out.println(i);
        }
    }
}
```

Output:

```
1
2
4
5
```

---

## 4.3 return Statement

The **return statement** is used to **exit from a method** and optionally return a value.

### Example

```java
public static int add(int a, int b) {
    return a + b;
}
```

---

# 5. Summary

Control statements are essential for building logical and dynamic programs in Java.

They help to:

* Make decisions using **conditional statements**
* Repeat tasks using **loops**
* Control execution using **jump statements**

Main categories include:

* Conditional Statements (`if`, `if-else`, `nested if`, `switch`)
* Looping Statements (`for`, `while`, `do-while`)
* Jump Statements (`break`, `continue`, `return`)

Understanding control statements is important for writing **efficient and structured Java programs**.
