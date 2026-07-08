# Design Patterns – Complete Understanding Notes

Design patterns are **standard solutions to common software design problems**. They help in making code more **reusable, scalable, maintainable, and loosely coupled**.

---

# 1. Singleton Pattern

## Purpose

Ensure that **only one instance of a class exists** in the entire application and provide a **global access point** to it.

## Problem It Solves

Multiple objects of a class can cause:

* inconsistent state
* unnecessary memory usage
* synchronization issues

## When to Use

* Logger
* Configuration Manager
* Cache Manager
* Database Connection Pool
* Spring Beans (default scope)

## Benefits

* Single shared instance
* Controlled access
* Saves memory

## Key Idea

“One object, shared everywhere”

---

# 2. Factory Pattern

## Purpose

Provide a way to **create objects without exposing the creation logic to the client**.

## Problem It Solves

Client code becomes tightly coupled with concrete classes using `new`.

## When to Use

* Multiple implementations of an interface exist
* Object creation depends on input or condition
* You want to centralize object creation logic

## Benefits

* Loose coupling
* Centralized object creation
* Easy to extend new implementations

## Key Idea

“Let factory decide which object to create”

---

# 3. Builder Pattern

## Purpose

Used to **construct complex objects step-by-step** in a readable way.

## Problem It Solves

Constructors become large and unclear when:

* many parameters exist
* many optional fields exist
* parameter order confusion occurs

## When to Use

* Many fields in a class
* Optional parameters exist
* Need readable object creation

## Benefits

* Improves readability
* Avoids telescoping constructors
* Flexible object creation

## Key Idea

“Build object step-by-step instead of big constructor”

---

# 4. Strategy Pattern

## Purpose

Define a **family of algorithms** and make them **interchangeable at runtime**.

## Problem It Solves

Large `if-else` or `switch` statements used to choose behavior.

## When to Use

* Same task has multiple ways to perform
* Behavior should change at runtime

## Benefits

* Removes conditional logic
* Easy to add new behavior
* Follows Open/Closed Principle

## Key Idea

“Same task, different behaviors, switch at runtime”

---

# 5. Observer Pattern

## Purpose

Establish a **one-to-many relationship** where multiple objects are notified when one object changes state.

## Problem It Solves

Manual notification logic between dependent objects.

## When to Use

* Event-driven systems
* Notifications
* Publish-subscribe systems

## Benefits

* Loose coupling
* Automatic updates to subscribers

## Key Idea

“One change → many automatic updates”

---

# 6. Adapter Pattern

## Purpose

Allows **two incompatible interfaces to work together**.

## Problem It Solves

Existing code cannot be changed but needs integration with new system.

## When to Use

* Third-party integration
* Legacy system integration

## Benefits

* Code reuse
* No modification of existing code

## Key Idea

“Convert one interface into another”

---

# 7. Decorator Pattern

## Purpose

Dynamically **add new behavior to an object without modifying its structure**.

## Problem It Solves

Inheritance leads to class explosion when features combine in many ways.

## When to Use

* Add features at runtime
* Avoid subclass explosion

## Benefits

* Flexible extension
* No modification of existing code

## Key Idea

“Wrap object to add behavior”

---

# 8. Proxy Pattern

## Purpose

Provide a **substitute object that controls access to another object**.

## Problem It Solves

Direct access may be expensive, insecure, or unnecessary.

## When to Use

* Security control
* Lazy loading
* Logging
* Remote access

## Benefits

* Access control
* Performance optimization

## Key Idea

“Middle layer controlling access”

---

# 9. Template Method Pattern

## Purpose

Define the **skeleton of an algorithm**, allowing subclasses to customize specific steps.

## Problem It Solves

Duplicate workflow logic across multiple classes.

## When to Use

* Common process with slight variations
* Standard workflow structure

## Benefits

* Code reuse
* Consistent workflow

## Key Idea

“Same steps, different implementation parts”

---

# 10. Prototype Pattern

## Purpose

Create new objects by **copying existing objects (cloning)**.

## Problem It Solves

Object creation is expensive or complex.

## When to Use

* Object creation is costly
* Similar objects are frequently needed

## Benefits

* Faster object creation
* Avoid repeated initialization cost

## Key Idea

“Clone existing object instead of creating new”

---

# Quick Interview Cheat Sheet

| Pattern   | Simple Meaning                          |
|-----------|-----------------------------------------|
| Singleton | Only one instance                       |
| Factory   | Creates objects for you                 |
| Builder   | Builds complex object step-by-step      |
| Strategy  | Switch behavior at runtime              |
| Observer  | One-to-many notifications               |
| Adapter   | Makes incompatible things work together |
| Decorator | Adds features dynamically               |
| Proxy     | Controls access to object               |
| Template  | Fixed steps, customizable parts         |
| Prototype | Copy existing object                    |

---
