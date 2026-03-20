# SOLID Principles

---

## What is SOLID?

SOLID is a set of 5 design principles used to write:

* Clean code
* Maintainable code
* Scalable systems

---

## SOLID = 5 Principles

| Letter | Principle                       |
|--------|---------------------------------|
| S      | Single Responsibility Principle |
| O      | Open/Closed Principle           |
| L      | Liskov Substitution Principle   |
| I      | Interface Segregation Principle |
| D      | Dependency Inversion Principle  |

---

# 1. Single Responsibility Principle (SRP)

## Definition

A class should have only one reason to change.

---

## Bad Example

```java
class UserService {
    void saveUser() { }
    void sendEmail() { }
}
```

### Problem

* Handles business logic and email
* Multiple responsibilities

---

## Good Example

```java
class UserService {
    void saveUser() { }
}

class EmailService {
    void sendEmail() { }
}
```

---

## One-line

One class = One responsibility

---

# 2. Open/Closed Principle (OCP)

## Definition

Software should be open for extension but closed for modification.

---

## Bad Example

```java
class PaymentService {
    void pay(String type) {
        if (type.equals("UPI")) {
            System.out.println("UPI");
        }
        else if (type.equals("CARD")) {
            System.out.println("CARD");
        }
    }
}
```

### Problem

Adding a new type requires modifying existing code.

---

## Good Example

```java
interface Payment {
    void pay();
}

class UpiPayment implements Payment {
    public void pay() { }
}

class CardPayment implements Payment {
    public void pay() { }
}
```

---

## One-line

Add new features without changing existing code.

---

# 3. Liskov Substitution Principle (LSP)

## Definition

Subclasses should be able to replace parent classes without breaking behavior.

---

## Bad Example

```java
class Bird {
    void fly() { }
}

class Penguin extends Bird {
    void fly() {
        throw new RuntimeException("Cannot fly");
    }
}
```

### Problem

Breaks expected behavior.

---

## Good Example

```java
interface Bird { }

interface FlyingBird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() { }
}
```

---

## One-line

Child class should behave like parent.

---

# 4. Interface Segregation Principle (ISP)

## Definition

Clients should not depend on methods they do not use. <br>
Do not crete big interfaces, create small and specific interface

---

## Bad Example

```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void eat() { }
}
```

### Problem

Robot is forced to implement unnecessary method.

---

## Good Example

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}
```

---

## One-line

Keep interfaces small and specific.

---

# 5. Dependency Inversion Principle (DIP)

## Definition

High level module should not depend on low level module <br>
both should depend on abstraction <br>
DI principle achieve loose coupling. <br>
Depend on abstractions, not concrete classes.

---

## Bad Example

```java
class OrderService {
    PaymentService paymentService = new PaymentService();
}
```

### Problem

Tight coupling between classes.

---

## Good Example

```java
interface PaymentService {
    void pay();
}

class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

---

## One-line

Use interfaces, not concrete implementations.

---

# Easy Way to Remember

```
S → Single responsibility  
O → Open for extension  
L → Replace safely  
I → Small interfaces  
D → Depend on abstraction  
```

---
