# Sealed Classes in Java 17

## 1. What Are Sealed Classes?

A **sealed class** or **sealed interface** restricts which classes or interfaces are allowed to extend or implement it.

Sealed classes became a permanent Java language feature in **Java 17** (JEP 409).

They are useful when a domain model has a known set of valid subtypes and the developer wants Java to enforce that inheritance hierarchy.

```java
public sealed class Payment
        permits UPIPayment, CardPayment, CashPayment {
}

public final class UPIPayment extends Payment {
}

public final class CardPayment extends Payment {
}

public final class CashPayment extends Payment {
}
```

Here, only `UPIPayment`, `CardPayment`, and `CashPayment` may directly extend `Payment`.

An unlisted class such as `CryptoPayment` cannot directly extend `Payment`.

---

## 2. Why Were Sealed Classes Introduced?

### The problem with ordinary inheritance

In Java, an ordinary non-final class can generally be extended by other classes, subject to normal access and inheritance rules.

Consider a banking application that supports only UPI, card, and cash payments.

```java
class Payment {
}

class UPIPayment extends Payment {
}

class CardPayment extends Payment {
}

class CashPayment extends Payment {
}

// An unwanted subtype can also extend Payment.
class CryptoPayment extends Payment {
}
```

The compiler allows `CryptoPayment` to extend `Payment` because the base class does not restrict its subclasses.

This can create a problem when the application expects only a specific set of payment types.

### Problems with unrestricted inheritance

1. **Uncontrolled extension:** Other developers can introduce additional subclasses.
2. **Unclear domain model:** The intended set of valid subtypes is not enforced by the type declaration.
3. **Difficult exhaustive handling:** Code that processes different subtypes cannot always assume it knows every possible subtype.
4. **More defensive code:** Developers may need additional checks or fallback handling for unexpected types.

Before sealed classes, developers could use techniques such as package-private constructors or access restrictions in certain designs. However, Java did not provide a direct language feature for explicitly declaring a permitted set of subclasses across the supported package or module boundaries.

### The solution

Sealed classes allow developers to declare which direct subclasses are permitted.

```java
public sealed class Payment
        permits UPIPayment, CardPayment, CashPayment {
}
```

The compiler enforces the permitted inheritance relationship.

**Key idea:** Sealed classes provide controlled inheritance rather than completely open inheritance or completely prohibited inheritance.

---

## 3. Understanding the `sealed` Keyword

The `sealed` keyword declares that a class or interface has restricted inheritance.

```java
public sealed class Payment
        permits UPIPayment, CardPayment {
}
```

This declaration means:

- `Payment` is allowed to have subclasses.
- Only the declared permitted types may directly extend it.
- Each permitted direct subclass must define its own inheritance policy.

The permitted subclasses can be `final`, `sealed`, or `non-sealed`.

---

## 4. Understanding the `permits` Keyword

The `permits` clause specifies which classes may directly extend a sealed class or which interfaces may directly extend or implement a sealed interface, as applicable.

```java
public sealed class Payment
        permits UPIPayment, CardPayment {
}
```

In this example:

- `UPIPayment` is permitted.
- `CardPayment` is permitted.
- `CryptoPayment` is not permitted to directly extend `Payment`.

```java
public final class UPIPayment extends Payment {
}

public final class CardPayment extends Payment {
}

// Compilation error: CryptoPayment is not permitted.
public final class CryptoPayment extends Payment {
}
```

The compiler rejects the unauthorized inheritance relationship.

### Is `permits` always required?

No.

If the permitted subclasses are declared in the same compilation unit as the sealed class, Java can infer the permitted subclasses, so the `permits` clause may be omitted.

For example:

```java
public sealed class Payment {
}

final class UPIPayment extends Payment {
}

final class CardPayment extends Payment {
}
```

Here, both direct subclasses are declared in the same compilation unit.

For clarity, explicitly writing `permits` is often useful when learning the feature or documenting the intended hierarchy.

---

## 5. The Three Permitted Subclass Modifiers

Every direct subclass of a sealed class must declare one of these three inheritance policies:

1. `final`
2. `sealed`
3. `non-sealed`

### 5.1 `final` — No class can extend it

When inheritance must be completely prohibited.

```java
public sealed class Payment
        permits UPIPayment {
}

public final class UPIPayment extends Payment {
}
```

The inheritance hierarchy stops at `UPIPayment`.

```java
// Compilation error: UPIPayment is final.
class SpecialUPIPayment extends UPIPayment {
}
```

**When to use it:** Use `final` when the permitted subtype should be the last class in that inheritance branch.

### 5.2 `sealed` — Only specified classes can extend it

When you want to allow inheritance but restrict who can inherit.

```java
public sealed class Payment
        permits CardPayment {
}

public sealed class CardPayment extends Payment
        permits CreditCardPayment, DebitCardPayment {
}

public final class CreditCardPayment extends CardPayment {
}

public final class DebitCardPayment extends CardPayment {
}
```

The hierarchy is:

```text
Payment (sealed)
    |
    v
CardPayment (sealed)
    |
    +-- CreditCardPayment (final)
    |
    +-- DebitCardPayment (final)
```

Only the declared direct subclasses are allowed at each sealed level.

**When to use it:** Use `sealed` when you need multiple controlled levels of inheritance.

### 5.3 `non-sealed` — Allow further inheritance

A permitted subclass can use `non-sealed` to reopen its inheritance branch.

```java
public sealed class Payment
        permits CashPayment {
}

public non-sealed class CashPayment extends Payment {
}

public class VoucherPayment extends CashPayment {
}

public class GiftCardPayment extends CashPayment {
}
```

`VoucherPayment` and `GiftCardPayment` are allowed because `CashPayment` is `non-sealed`.

However, an unrelated class still cannot directly extend `Payment` unless it is added to the permitted hierarchy.

**When to use it:** Use `non-sealed` when the base class should control its immediate subclasses but a particular branch should remain extensible.

---

## 6. Visualizing the Three Inheritance Policies

```text
                    Payment
                    (sealed)
                       |
          +------------+------------+
          |            |            |
          v            v            v
       UPI           Card          Cash
      (final)       (sealed)    (non-sealed)
                       |            |
                 +-----+-----+      +--------+
                 |           |      |        |
                 v           v      v        v
              Credit       Debit  Voucher  GiftCard
              (final)      (final)
```

Interpretation:

- `UPI`: No further inheritance.
- `Card`: Only the explicitly permitted card subtypes can extend it directly.
- `Cash`: Further inheritance is open because it is `non-sealed`.

This design gives developers control over each branch rather than forcing the entire hierarchy to be either open or closed.

---

## 7. Sealed Classes and Sealed Interfaces

Sealed inheritance works with both classes and interfaces.

### Sealed class

```java
public sealed class Payment
        permits UPIPayment, CardPayment {
}

public final class UPIPayment extends Payment {
}

public final class CardPayment extends Payment {
}
```

A class can extend only one class, as required by Java's normal class inheritance rules.

### Sealed interface

```java
public sealed interface Payment
        permits UPIPayment, CardPayment {
}

public final class UPIPayment implements Payment {
}

public final class CardPayment implements Payment {
}
```

An interface can restrict which classes directly implement it and which interfaces directly extend it.

A class may implement multiple interfaces, including sealed interfaces, provided it satisfies the rules of each one.

### When should you choose a sealed class or interface?

- Choose a **sealed class** when you need a common superclass with shared state or implementation.
- Choose a **sealed interface** when you want to define a common contract for multiple permitted implementations, including classes that may extend another class.

---

## 8. Important Rules and Restrictions

### Rule 1: Every direct subclass must be permitted

A class cannot directly extend a sealed class unless it is a permitted subclass.

### Rule 2: Every permitted direct subclass needs an inheritance modifier

It must be declared `final`, `sealed`, or `non-sealed`.

### Rule 3: Permitted subclasses must satisfy package or module restrictions

In an unnamed module, permitted subclasses must be in the same package. In a named module, they must be in the same module, subject to Java's normal package and module rules.

### Rule 4: Sealed classes can be abstract

A sealed class may be abstract if it represents a common concept that should not be instantiated directly.

```java
public abstract sealed class Payment
        permits UPIPayment, CardPayment {
}
```

### Rule 5: Sealed classes do not make objects immutable

Sealed classes restrict inheritance. They do not automatically prevent fields from changing or validate business rules.

### Rule 6: `final` and `sealed` are different

- `final`: No subclass is allowed.
- `sealed`: Only permitted direct subclasses are allowed.
- `non-sealed`: The inheritance restriction is lifted for that branch.

---

## 9. Common Interview Questions

### Q1. What problem do sealed classes solve?

They provide a language-level way to restrict which classes can directly extend a class or which classes and interfaces can directly extend or implement a sealed type.

### Q2. In which Java version were sealed classes finalized?

Java 17.

### Q3. What is the purpose of `permits`?

It declares the permitted direct subclasses or sub interfaces of a sealed type. It can be omitted when Java can infer the permitted subclasses from declarations in the same compilation unit.

### Q4. What are the three modifiers a permitted direct subclass can use?

`final`, `sealed`, and `non-sealed`.

### Q5. Can an interface be sealed?

Yes. A sealed interface can restrict which classes directly implement it and which interfaces directly extend it.

### Q6. Can a sealed class be abstract?

Yes. An abstract sealed class can define a controlled hierarchy without allowing direct instantiation.

### Q7. Does `non-sealed` make the original sealed parent open to every class?

No. It opens only the inheritance branch of that permitted subclass. Unrelated classes still cannot directly extend the original sealed parent.

### Q8. Are sealed classes the same as immutable classes?

No. Sealed classes restrict inheritance; immutability concerns whether an object's state can change.

### Q9. Why are sealed classes useful with pattern matching?

They provide a known set of permitted subtypes, helping the compiler check whether pattern-matching branches cover the required alternatives.

---

## 10. Summary

- Sealed classes and interfaces were finalized in Java 17.
- They solve the problem of unrestricted inheritance when a domain needs a controlled set of subtypes.
- The `sealed` keyword declares a restricted hierarchy.
- The `permits` clause identifies the permitted direct subclasses or sub interfaces.
- Each permitted direct subclass must use `final`, `sealed`, or `non-sealed`.
- `final` stops inheritance, `sealed` continues controlled inheritance, and `non-sealed` opens that branch.
- Sealed types are useful for payment models, API results, domain events, and other closed type hierarchies.
- They work particularly well with pattern matching, but do not themselves make objects immutable or validate business rules.
