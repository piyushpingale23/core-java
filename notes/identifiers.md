# Identifiers and Naming Conventions in Java

## 1. Introduction

In Java, an **Identifier** is the name given to a variable, method, class, package, or interface.

Identifiers are used to **identify program elements uniquely** within a program.

Examples of identifiers:

```
int age;
String studentName;
class Person
void calculateSum()
```

Here:

* `age` → variable identifier
* `studentName` → variable identifier
* `Person` → class identifier
* `calculateSum` → method identifier

---

# 2. Rules for Identifiers in Java

Java defines several rules for naming identifiers.

1. An identifier can contain:

    * Letters (`A-Z`, `a-z`)
    * Digits (`0-9`)
    * Underscore (`_`)
    * Dollar sign (`$`)

2. An identifier **cannot start with a digit**.
    * 1name

3. Identifiers **cannot be Java keywords**.
    * int class
    * int public

4. Identifiers **cannot contain spaces**.
    * student name

5. Identifiers are **case-sensitive**.
    * age
    * Age
    * AGE
    * All three are treated as **different identifiers**.

---

# 3. Valid Identifier Examples

```
studentName
totalMarks
count
user1
_salary
$amount
```

---

# 4. Invalid Identifier Examples

```
1value
class
total marks
#price
```

---

# 5. Naming Conventions in Java

Although Java allows many naming styles, developers follow **standard naming conventions** to make code readable and maintainable.

Common naming styles include:

* Camel Case
* Pascal Case
* Snake Case
* Upper Snake Case

---

# 6. Camel Case

Camel Case is the **most common naming convention for variables and methods in Java**.

Rules:

* First letter is **lowercase**
* Every new word starts with **uppercase**

Example:

```
studentName
totalMarks
calculateSum
getUserData
```

Example in Java:

```java
int studentAge;
double totalPrice;

void calculateTotal() {

}
```

---

# 7. Pascal Case

Pascal Case is used mainly for **Class names and Interface names**.

Rules:

* First letter of **each word is uppercase**
* No spaces between words

Example:

```
Student
BankAccount
EmployeeDetails
OrderService
```

Example in Java:

```java
class StudentDetails {

}

class BankAccount {

}
```

---

# 8. Snake Case

Snake Case uses **underscores to separate words**.

Example:

```
student_name
total_marks
user_age
```

Snake case is **not commonly used in Java variables**, but it is sometimes used in:

* Database column names
* Configuration files

---

# 9. Upper Snake Case

Upper Snake Case is used for **constants (final variables)**.

Rules:

* All letters are **uppercase**
* Words are separated by **underscore**

Example:

```
MAX_SIZE
DEFAULT_TIMEOUT
MIN_BALANCE
PI_VALUE
```

Example in Java:

```java
public class Constants {

    public static final int MAX_USERS = 100;

}
```

---

# 10. Java Naming Convention Summary

| Element   | Naming Style     | Example            |
|-----------|------------------|--------------------|
| Class     | PascalCase       | `StudentDetails`   |
| Interface | PascalCase       | `RunnableTask`     |
| Method    | camelCase        | `calculateTotal()` |
| Variable  | camelCase        | `studentAge`       |
| Constant  | UPPER_SNAKE_CASE | `MAX_LIMIT`        |
| Package   | lowercase        | `com.core.java`    |

---

# 11. Example Program Using Naming Conventions

```java
package com.core.java.identifiers;

public class StudentDetails {

    int studentAge;

    public void displayStudentAge() {
        System.out.println("Age: " + studentAge);
    }

    public static void main(String[] args) {

        StudentDetails student = new StudentDetails();

        student.studentAge = 20;

        student.displayStudentAge();

    }
}
```

---

# 12. Conclusion

Identifiers are used to **name elements in a Java program** such as variables, methods, classes, and packages.

Following proper naming conventions like:

* **camelCase for variables and methods**
* **PascalCase for classes**
* **UPPER_SNAKE_CASE for constants**

makes code **clean, readable, and easier to maintain**.

Using proper naming conventions is considered a **best practice in professional Java development**.
