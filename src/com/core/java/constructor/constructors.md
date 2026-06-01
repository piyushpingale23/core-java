# Constructors in Java

## 1. Introduction

A **Constructor** in Java is a special type of method that is used to **initialize objects**.

It is called **automatically when an object of a class is created**.

Constructors are mainly used to:

* Initialize object variables
* Set initial values for fields
* Prepare an object before it is used

Example:

```java
class Person {
    Person() {
        System.out.println("Constructor called");
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        Person p = new Person();
    }
}
```

Output:

```
Constructor called
```

---

# 2. Characteristics of Constructors

* Constructor name must be **same as the class name**
* Constructors **do not have a return type**
* They are **called automatically when an object is created**
* Used to **initialize object state**

Example object creation:

```java
Person p = new Person();
```

Here:

* `new` → creates object
* `Person()` → constructor is executed

---

# 3. Types of Constructors

Java provides **three common types of constructors**:

1. Default Constructor
2. Parameterized Constructor
3. Copy Constructor (user-defined concept)

---

# 4. Default Constructor

A **Default Constructor** is a constructor that **does not take any parameters**.

If a class does not define any constructor, Java automatically provides a **default constructor**.

Example:

```java
public class DefaultConstructorExample {
    int number;
    DefaultConstructorExample() {
        number = 10;
        System.out.println("Default constructor executed");
    }

    public static void main(String[] args) {
        DefaultConstructorExample obj = new DefaultConstructorExample();
        System.out.println("Number: " + obj.number);
    }
}
```

Output:

```
Default constructor executed
Number: 10
```

---

# 5. Parameterized Constructor

A **Parameterized Constructor** accepts **arguments during object creation**.

This allows objects to be initialized with **different values**.

Example:

```java
public class ParameterizedConstructorExample {
    int id;
    String name;
    ParameterizedConstructorExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        ParameterizedConstructorExample p = new ParameterizedConstructorExample(1, "Jack");
        System.out.println("Id: " + p.id);
        System.out.println("Name: " + p.name);
    }
}
```

Output:

```
Id: 1
Name: Jack
```

---

# 6. Copy Constructor

Java does not provide a built-in copy constructor like C++, but we can create one manually.

A **Copy Constructor** creates a **new object by copying values from another object**.

Example:

```java
public class CopyConstructorExample {
    int id;
    String name;
    CopyConstructorExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Copy constructor
    CopyConstructorExample(CopyConstructorExample obj) {
        this.id = obj.id;
        this.name = obj.name;
    }

    public static void main(String[] args) {
        CopyConstructorExample p1 = new CopyConstructorExample(1, "Jack");
        CopyConstructorExample p2 = new CopyConstructorExample(p1);
        System.out.println(p1.id + " " + p1.name);
        System.out.println(p2.id + " " + p2.name);
    }
}
```

Output:

```
1 Jack
1 Jack
```

---

# 7. Constructor Overloading

A class can have **multiple constructors with different parameters**.

This is called **Constructor Overloading**.

Example:

```java
public class ConstructorOverloadingExample {
    int id;
    String name;
    ConstructorOverloadingExample() {
        System.out.println("Default constructor");
    }

    ConstructorOverloadingExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        ConstructorOverloadingExample obj1 = new ConstructorOverloadingExample();
        ConstructorOverloadingExample obj2 = new ConstructorOverloadingExample(1, "Jack");
        System.out.println(obj2.id + " " + obj2.name);
    }
}
```

---

# 8. Difference Between Constructor and Method

| Feature     | Constructor          | Method                |
|-------------|----------------------|-----------------------|
| Name        | Same as class        | Any name              |
| Return Type | No return type       | Must have return type |
| Purpose     | Initialize object    | Perform operations    |
| Invocation  | Called automatically | Called manually       |

---

# 9. Real World Example

Example of a `Person` class using constructor:

```java
public class Person {
    int id;
    String name;
    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Person p = new Person(101, "Jack");
        p.display();
    }
}
```

---

# 10. Important Points

* Constructors are used to **initialize objects**
* They are **called automatically when an object is created**
* A class can have **multiple constructors**
* Constructors support **overloading**
* If no constructor is defined, Java provides a **default constructor**

---

# 11. Package Structure Example

```
core-java
│
└── src
    └── com
        └── core
            └── java
                └── constructor
                    ├── DefaultConstructorExample.java
                    ├── ParameterizedConstructorExample.java
                    ├── CopyConstructorExample.java
                    └── ConstructorOverloadingExample.java
```

---
