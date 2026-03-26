# this, super, static in Java

---

## 1. this

* `this` refers to the **current object of the class**

* `this` used to differentiate **instance variables and local variables**

* `this` used to pass the current object as a parameter

* `this` used to return the current object

* `this()` used to call another constructor in the same class

* `this()` must be the **first statement in a constructor**

---

## Difference Between `this` and `this()`

---

### `this` (Keyword)

* Refers to the **current object instance**
* Used inside **methods and constructors (to differentiate instance variables and local variables)**

#### Uses:

* Access instance variables
* Call current class methods
* Pass current object

#### Example:

```java id="7obg8c"
class Student {
    int age;

    Student(int age) {
        this.age = age;
    }

    void m1() {
        this.m2();
    }

    void m2() {}
}
```

---

### `this()` (Constructor Call)

* Used to **call another constructor** of the same class
* Must be the **first statement** inside a constructor

#### Example:

```java id="4nhs0z"
class Student {
    int age;

    Student() {
        this(10);
    }

    Student(int age) {
        this.age = age;
    }
}
```

---

### Key Differences

| Feature  | `this`                | `this()`                  |
|----------|-----------------------|---------------------------|
| Type     | Keyword               | Constructor call          |
| Purpose  | Refers current object | Calls another constructor |
| Usage    | Variables / methods   | Only inside constructor   |
| Position | Anywhere              | Must be first statement   |

---

### Additional Difference

#### `this.methodCall()` vs `t.methodCall()`

* `this.methodCall()`:

    * Calls method on **current object**
    * Optional (implicitly added by compiler)

* `t.methodCall()`:

    * Calls method using **object reference variable**
    * Used outside or inside class

---

## 2. super

* `super` refers to the **immediate parent class object**
* `super` used to access parent class members
* `super()` is used to call the parent class constructor
* `super()` must be the **first statement** in constructor
* Cannot use both `this()` and `super()` together

---

## Difference Between `super` and `super()`

---

### `super` (Keyword)

* Refers to the **parent class object**
* Used to access parent members

#### Example:

```java id="z63bnq"
class Parent {
    int x = 10;
}

class Child extends Parent {
    int x = 20;

    void show() {
        System.out.println(super.x);
    }
}
```

---

### `super()` (Constructor Call)

* Calls parent class constructor
* Must be first statement

#### Example:

```java id="1p10zl"
class Parent {
    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {
    Child() {
        super();
        System.out.println("Child Constructor");
    }
}
```

---

### Key Differences

| Feature  | `super`               | `super()`               |
|----------|-----------------------|-------------------------|
| Type     | Keyword               | Constructor call        |
| Purpose  | Access parent members | Call parent constructor |
| Usage    | Variables / methods   | Only inside constructor |
| Position | Anywhere              | Must be first statement |

---

## 3. static

* `static` belongs to the **class, not objects**
* Memory is allocated **once in Method Area (MetaSpace)**

---

### Uses of `static`

* Static variables (shared across all objects)
* Static methods
* Static blocks (executed once at class loading time)

---

### Static Variable

```java id="a4eijb"
class Student {
    static int count = 0;
}
```

* Shared among all objects
* Only one copy exists

---

### Static Method

```java id="0uh68k"
class Student {
    static void show() {
        System.out.println("Static method");
    }
}
```

* Can be called using class name
* Cannot access non-static members directly

---

### Static Block

```java id="2mwn2y"
class Student {
    static {
        System.out.println("Static block executed");
    }
}
```

* Executes **once when class is loaded**

---

### Static Access Rules

* From a **static method**:

    * Can access **only static members**
    * Cannot access non-static members directly

* From a **non-static method**:

    * Can access **both static and non-static members**

---

### Example

```java id="33xsn3"
class Test {

    static int x = 10;
    int y = 20;

    static void staticMethod() {
        System.out.println(x);   // allowed
        // System.out.println(y); // not allowed
    }

    void nonStaticMethod() {
        System.out.println(x); // allowed
        System.out.println(y); // allowed
    }
}
```

---

### One-Line Summary

`static` belongs to the class and can be accessed without creating an object; static methods can access only static members, while non-static methods can access both.

---
