# Lombok Annotations

## Introduction

Lombok is a Java library that reduces boilerplate code by generating common methods like getters, setters, constructors, builders, and logging code at compile time.

It works using **annotation processing** during compilation.

---

# 1. @Data

## Purpose

Generates complete boilerplate code for a class.

## Includes:

* Getters
* Setters
* toString()
* equals()
* hashCode()
* RequiredArgsConstructor (for final/@NonNull fields)

## Example:

```java id="d1"
import lombok.Data;

@Data
public class Employee {
    private String name;
    private String email;
}
```

## Use Case:

* DTO classes
* Simple POJOs

## Caution:

* Not recommended for JPA entities (equals/hashCode issues)

---

# 2. @Getter and @Setter

## Purpose

Generates getter and setter methods individually.

## Example:

```java id="d2"
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String name;
    private String email;
}
```

## Use Case:

* When you need selective control instead of @Data

---

# 3. @NoArgsConstructor

## Purpose

Generates a no-argument constructor.

## Example:

```java id="d3"
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Employee {
    private String name;
}
```

## Equivalent:

```java id="d4"
public Employee() {}
```

## Use Case:

* Jackson (JSON deserialization) - When Jackson converts JSON -> Java object, it works like this:Creates an empty object first ,then sets values using setters or reflection
* Hibernate/JPA

---

# 4. @AllArgsConstructor

## Purpose

Generates a constructor with all fields.

## Example:

```java id="d5"
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Employee {
    private String name;
    private String email;
}
```

## Equivalent:

```java id="d6"
public Employee(String name, String email) {
    this.name = name;
    this.email = email;
}
```

## Use Case:

* DTO mapping
* Test data creation

---

# 5. @RequiredArgsConstructor

## Purpose

Generates constructor for:

* final fields
* @NonNull fields

## Example:

```java id="d7"
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Employee {
    private final String name;
    private final String email;
}
```

## Use Case:

* Dependency injection (Spring)

---

# 6. @Builder

## Purpose

Implements Builder Pattern for step-by-step object creation.

## Example:

```java id="d8"
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String name;
    private String email;
    private String department;
}
```

## Usage:

```java id="d9"
Employee emp = Employee.builder()
        .name("Piyush")
        .email("piyush@gmail.com")
        .department("IT")
        .build();
```

## Use Case:

* Complex objects
* Many optional fields
* Readable object creation

---

# 7. @ToString

## Purpose

Generates toString() method.

## Example:

```java id="d10"
import lombok.ToString;

@ToString
public class Employee {
    private String name;
}
```

---

# 8. @EqualsAndHashCode

## Purpose

Generates equals() and hashCode().

## Example:

```java id="d11"
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Employee {
    private String id;
}
```

## Use Case:

* HashMap / HashSet
* Object comparison

---

# 9. @NonNull

## Purpose

Adds null-check validation.

## Example:

```java id="d12"
import lombok.NonNull;

public class Employee {

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
```

## Behavior:

Throws NullPointerException if value is null.

---

# 10. @Slf4j

## Purpose

Auto-generates logger.

## Example:

```java id="d13"
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeService {

    public void process() {
        log.info("Processing employee");
    }
}
```

## Equivalent:

```java id="d14"
private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
```

---

# 11. @Value

## Purpose

Creates immutable class.

## Example:

```java id="d15"
import lombok.Value;

@Value
public class Employee {
    String name;
    String email;
}
```

## Features:

* final fields
* getters only
* no setters
* all-args constructor

---

# Summary Table

| Annotation               | Purpose                         |
|--------------------------|---------------------------------|
| @Data                    | Full boilerplate generation     |
| @Getter/@Setter          | Accessor methods                |
| @NoArgsConstructor       | Empty constructor               |
| @AllArgsConstructor      | Full constructor                |
| @RequiredArgsConstructor | Constructor for required fields |
| @Builder                 | Builder pattern                 |
| @ToString                | String representation           |
| @EqualsAndHashCode       | Object comparison               |
| @NonNull                 | Null validation                 |
| @Slf4j                   | Logger generation               |
| @Value                   | Immutable class                 |

---

# Key Takeaways

* Lombok reduces boilerplate code significantly.
* `@Data` is convenient but should be used carefully in entities.
* `@Builder` is best for complex object creation.
* `@Slf4j` removes manual logger creation.
* Constructors are automatically generated based on annotations.

---
