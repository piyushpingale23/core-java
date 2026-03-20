# Enums in Java

## 1. Introduction

An **Enum (Enumeration)** in Java is a special data type used to define a **fixed set of constants**.

Enums are useful when a variable should only take **one value from a predefined list**.

For example:

* Days of the week
* Months of the year
* Directions (NORTH, SOUTH, EAST, WEST)
* Status values (SUCCESS, FAILED, PENDING)

Instead of using numbers or strings, enums allow us to use **meaningful constant names**, which improves **code readability and safety**.

---

# 2. Syntax of Enum

```java
enum EnumName {
    CONSTANT1,
    CONSTANT2,
    CONSTANT3
}
```

Example:

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

---

# 3. Simple Enum Example Without Constructor

```java
public class WithoutConstructorEnum {
    
    enum Day {
        MONDAY, 
        TUESDAY, 
        WEDNESDAY
    }
    
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);
    }
    
}
```

Output:

```
Today is: MONDAY
```

---


# 4. Enum with Fields and Constructor

Enums can also have **variables, constructors, and methods**.

Example:

```java
enum WithConstructorEnum {
    LOW(1),
    MEDIUM(2),
    HIGH(3);
    
    private int value;
    
    Level(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
```

Usage:

```java
public class EnumTest {
    
    public static void main(String[] args) {
        Level level = Level.HIGH;
        System.out.println("Level value: " + level.getValue());
    }
    
}
```

---

# 5. Important Enum Methods

Java automatically provides some useful methods for enums.

| Method      | Description                       |
|-------------|-----------------------------------|
| `values()`  | Returns all enum constants        |
| `valueOf()` | Converts string to enum constant  |
| `ordinal()` | Returns position of enum constant |
| `name()`    | Returns name of constant          |

---

# 6. Enum Example with values()

```java
public class EnumValuesExample {
    enum Day {
        MONDAY, 
        TUESDAY, 
        WEDNESDAY
    }
    public static void main(String[] args) {

        for(Day d : Day.values()) {
            System.out.println(d);
        }
    }
}
```

---

# 7. When to Use Enums

Enums should be used when:

* The variable should have **limited fixed values**
* Constants are **related to each other**

---

# 8. Summary

Enums in Java are used to represent **a group of fixed constants**.

Key points:

* Declared using the `enum` keyword
* Improves code readability
* Provides type safety
* Can contain variables, constructors, and methods
* Frequently used with switch statements

---

# 9. Points to Remember

Enum constants are public static final.

Enum constructor is always private or package private, because enum define fix set of instances, java automatically creates exactly these instances once when enum class is loaded.

We cannot create more instances of enum at runtime. If constructor in public then anyone can create object of enum.