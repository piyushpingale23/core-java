# Java Record Class

## Introduction

A **Record** is a special type of class introduced in **Java 14 (preview)** and standardized in **Java 16**. It is used to create **immutable data carrier classes** with minimal boilerplate code.

Records are mainly used for **DTOs (Data Transfer Objects)**.

---

# Syntax

```java id="r1"
public record Employee(String name, String email) {
}
```

---

# What Java Generates Automatically

For the above record, Java internally generates:

## 1. Final Fields

```java id="r2"
private final String name;
private final String email;
```

---

## 2. Constructor

```java id="r3"
public Employee(String name, String email) {
    this.name = name;
    this.email = email;
}
```

---

## 3. Getter Methods (No setters)

```java id="r4"
public String name() { return name; }

public String email() { return email; }
```

---

## 4. equals(), hashCode(), toString()

All generated automatically.

---

# Example Usage

```java id="r5"
public record Employee(String name, String email) {}

public class Test {
    public static void main(String[] args) {

        Employee emp = new Employee("Piyush", "piyush@gmail.com");

        System.out.println(emp.name());
        System.out.println(emp.email());
        System.out.println(emp);
    }
}
```

---

# Key Features of Record

## 1. Immutable by Default

* All fields are `final`
* No setters allowed

---

## 2. Compact Syntax

No need to write:

* constructor
* getters
* equals/hashCode
* toString

---

## 3. Built-in Methods

Automatically generated:

* constructor
* accessor methods
* equals()
* hashCode()
* toString()

---

## 4. Cleaner Code

Reduces boilerplate significantly for DTO classes.

---

# Record vs Normal Class

| Feature          | Class         | Record         |
|------------------|---------------|----------------|
| Boilerplate code | High          | Very low       |
| Mutability       | Mutable       | Immutable      |
| Getters          | getName()     | name()         |
| Setters          | Yes           | No             |
| equals/hashCode  | Manual/Lombok | Auto-generated |
| Constructor      | Manual        | Auto-generated |

---

# Limitations of Record

Records are NOT suitable for:

* Complex business logic classes
* JPA Entities (generally not recommended)
* Mutable objects
* Class inheritance (records are implicitly final)

---

# When to Use Record

Use records when:

* DTOs (Request/Response objects)
* API data transfer
* Immutable data models
* Simple data containers

---

# Record vs Lombok @Data

| Feature       | Record           | @Data           |
|---------------|------------------|-----------------|
| Boilerplate   | None             | Low             |
| Mutability    | Immutable        | Mutable         |
| Setters       | No               | Yes             |
| Dependency    | No Lombok needed | Lombok required |
| Best use case | DTO replacement  | General POJO    |

---