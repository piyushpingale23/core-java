# Type Casting in Java

## 1. What is Type Casting?

Type Casting is the **conversion of one data type into another** in Java.  
It is used when we want to **assign a value of one type to a variable of another type**.

- Java supports **two types of type casting**:
    1. **Primitive Type Casting** (int, float, double, char, etc.)
    2. **Reference Type Casting** (Objects and Classes)

---

## 2. Primitive Type Casting

### a) Widening Casting (Implicit / Upcasting)
- Converts **smaller type to larger type**.
- Done automatically by Java.
- Example: `byte → short → int → long → float → double`

```
int i = 100;
double d = i; // int automatically converted to double
System.out.println(d); // Output: 100.0
```

### b) Narrowing Casting (Explicit / Downcasting)
- Converts larger type to smaller type.
- Must be done manually using parentheses.
- Example: double → float → long → int → short → byte

```
double d = 100.99;
int i = (int) d; // double explicitly cast to int
System.out.println(i); // Output: 100
```

---

## 3. Reference Type Casting (Objects)

- Used to convert objects of one class type into another.
- Works in inheritance hierarchies.

### a) Upcasting (Implicit / Widening)
- Converting child object to parent type.
- Safe and implicit.
- `When we use a parent class reference to hold a child class object, it is called Upcasting.`
- Example:

````java
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal a = dog; // Upcasting
        a.eat(); // Can access parent methods
        // a.bark(); // Error: cannot access child method
    }
}
````

### b) Downcasting (Explicit / Narrowing)
- Converting parent reference back to child type.
- Must be done explicitly.
- Example:

````
Animal a = new Dog(); // Upcasting
Dog d = (Dog) a;      // Downcasting
d.bark();              // Now child method accessible
````