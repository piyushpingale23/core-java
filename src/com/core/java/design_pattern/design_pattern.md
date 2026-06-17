# Design Patterns

## 1. Singleton Pattern

### Purpose
Ensures that only one instance of a class exists throughout the application and provides a global access point to it.

### Problem It Solves
Sometimes multiple objects of a class can create inconsistency, waste memory, or cause synchronization issues.

### When to Use
- Configuration Manager
- Logger
- Cache Manager
- Database Connection Pool
- Spring Singleton Beans

### Benefits
- Controlled access to a single instance
- Reduced memory consumption
- Global access point

### Drawbacks
- Difficult to unit test
- Can become a global variable if overused

---

## 2. Factory Pattern

### Purpose
Creates objects without exposing object creation logic to the client.

### Problem It Solves
Client code becomes tightly coupled with concrete classes when using `new` everywhere.

### When to Use
- Multiple implementations of an interface exist.
- Object creation logic is complex.
- Object type is determined at runtime.

### Benefits
- Loose coupling
- Easier maintenance
- Easier extension

### Real-World Examples
- Spring BeanFactory
- JDBC DriverManager

---

## 3. Builder Pattern

### Purpose
Constructs complex objects step-by-step.

### Problem It Solves
Constructors become huge and difficult to manage when many parameters are required.

### When to Use
- Large number of constructor parameters
- Optional fields
- Immutable objects

### Benefits
- Improves readability
- Avoids telescoping constructors
- Supports immutability

### Real-World Examples
- Lombok @Builder
- StringBuilder
- Spring UriComponentsBuilder

---

## 4. Strategy Pattern

### Purpose
Defines a family of algorithms and allows selecting one at runtime.

### Problem It Solves
Large if-else or switch statements used to select behavior.

### When to Use
- Multiple algorithms perform the same task differently.
- Algorithm selection is dynamic.

### Benefits
- Open/Closed Principle
- Easy addition of new strategies
- Reduces conditional logic

### Real-World Examples
- Payment Processing
- Authentication Mechanisms
- Java Comparator

---

## 5. Observer Pattern

### Purpose
Establishes a one-to-many dependency between objects.

### Problem It Solves
Objects need to be notified automatically when another object's state changes.

### When to Use
- Event-driven systems
- Notifications
- Publish-Subscribe mechanisms

### Benefits
- Loose coupling
- Easy addition of subscribers
- Supports event-driven architecture

### Real-World Examples
- Spring Event Publishing
- GUI Event Handling
- YouTube Subscriber Notifications

---

## 6. Adapter Pattern

### Purpose
Allows incompatible interfaces to work together.

### Problem It Solves
Existing classes cannot be modified but must integrate with new systems.

### When to Use
- Integrating third-party libraries
- Legacy system integration
- Interface conversion

### Benefits
- Reuse existing code
- Avoid modifying legacy systems
- Improves compatibility

### Real-World Examples
- Payment Gateway Integration
- Legacy API Integration

---

## 7. Decorator Pattern

### Purpose
Adds new functionality to objects dynamically without modifying existing code.

### Problem It Solves
Subclass explosion caused by adding many combinations of features.

### When to Use
- Functionality needs to be added dynamically.
- Inheritance becomes difficult to manage.

### Benefits
- Flexible alternative to inheritance
- Runtime behavior modification
- Follows Open/Closed Principle

### Real-World Examples
- Java I/O Streams
- Spring Bean Wrappers

---

## 8. Proxy Pattern

### Purpose
Provides a placeholder or representative object that controls access to another object.

### Problem It Solves
Direct access to an object may be expensive, insecure, or undesirable.

### When to Use
- Security checks
- Lazy loading
- Remote service access
- Logging

### Benefits
- Access control
- Improved performance
- Additional functionality without changing original object

### Real-World Examples
- Spring AOP
- Hibernate Lazy Loading
- Security Proxies

---

## 9. Template Method Pattern

### Purpose
Defines the skeleton of an algorithm while allowing subclasses to customize specific steps.

### Problem It Solves
Common algorithm logic is duplicated across multiple classes.

### When to Use
- Multiple classes follow the same workflow.
- Some workflow steps vary.

### Benefits
- Code reuse
- Consistent workflow
- Reduces duplication

### Real-World Examples
- Spring JdbcTemplate
- Spring RestTemplate
- Servlet Lifecycle

---

## 10. Prototype Pattern

### Purpose
Creates new objects by cloning existing objects.

### Problem It Solves
Object creation is expensive or complex.

### When to Use
- Object initialization takes significant time.
- Similar objects are created frequently.

### Benefits
- Faster object creation
- Reduces initialization cost
- Simplifies object creation

### Real-World Examples
- Cloneable Interface
- Document Templates
- Game Character Cloning

---

# Quick Interview Summary

| Pattern         | Problem Solved                            |
|-----------------|-------------------------------------------|
| Singleton       | Need only one object in application       |
| Factory         | Hide object creation logic                |
| Builder         | Construct complex objects easily          |
| Strategy        | Remove large if-else logic for algorithms |
| Observer        | Notify multiple objects on state change   |
| Adapter         | Connect incompatible interfaces           |
| Decorator       | Add behavior dynamically                  |
| Proxy           | Control access to an object               |
| Template Method | Reuse common workflow structure           |
| Prototype       | Create objects by cloning                 |
