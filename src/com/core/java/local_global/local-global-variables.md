# Local and Global Variables in Java

## 1. Introduction

In Java, variables are used to **store data values**.
Based on where they are declared and how they are accessed, variables can be categorized as:

* **Local Variables**
* **Global Variables (Instance Variables)**
* **Static Variables (Class Variables)**

Understanding variable scope is important because it determines **where a variable can be accessed and modified** in a program.

---

# 2. Local Variables

A **local variable** is declared **inside a method, constructor, or block**.

It can **only be accessed within that specific method or block** where it is declared.

### Characteristics of Local Variables

* Declared inside a **method or block**
* Accessible **only within that method**
* Must be **initialized before use**
* Created when the **method starts**
* Destroyed when the **method finishes**

### Example of Local Variable

```java
public class LocalVariableExample {
    public void display() {
        int number = 10; // local variable
        System.out.println("Local Variable: " + number);
    }

    public static void main(String[] args) {
        LocalVariableExample obj = new LocalVariableExample();
        obj.display();
    }
}
```

### Explanation

* `number` is declared inside the `display()` method.
* It **cannot be accessed outside this method**.

---

# 3. Global Variables (Instance Variables)

In Java, **global variables are called instance variables**.

They are declared **inside a class but outside any method**.

Each object of the class has its **own copy of instance variables**.

### Characteristics of Instance Variables

* Declared **inside a class but outside methods**
* Accessible **through objects**
* Each object has its **own separate copy**
* Automatically gets **default values**

### Example of Global (Instance) Variable

```java
public class GlobalVariableExample {
    int number = 50; // global (instance) variable
    public void display() {
        System.out.println("Global Variable: " + number);
    }

    public static void main(String[] args) {
        GlobalVariableExample obj = new GlobalVariableExample();
        obj.display();
    }
}
```

### Explanation

* `number` is declared **inside the class but outside methods**
* It is accessible by **all methods in the class**

---

# 4. Static Variables (Class Variables)

A **static variable** belongs to the **class rather than objects**.

All objects share **the same copy of the static variable**.

### Characteristics

* Declared using the `static` keyword
* Only **one copy exists for the entire class**
* Shared by all objects
* Accessed using **ClassName.variableName**

### Example of Static Variable

```java
public class StaticVariableExample {

    static int count = 0;

    public StaticVariableExample() {
        count++;
        System.out.println("Object Count: " + count);
    }

    public static void main(String[] args) {
        StaticVariableExample();
    }
}
```

### Output

```
Object Count: 1
```

---

# 5. Difference Between Local and Global Variables

| Feature       | Local Variable           | Global (Instance) Variable |
|---------------|--------------------------|----------------------------|
| Declaration   | Inside method            | Inside class               |
| Scope         | Only within method       | Entire class               |
| Memory        | Created when method runs | Created with object        |
| Default Value | No default value         | Gets default value         |

---

# 6. Default Values of Instance Variables

| Data Type | Default Value |
|-----------|---------------|
| int       | 0             |
| double    | 0.0           |
| boolean   | false         |
| char      | '\u0000'      |
| Object    | null          |

Local variables **do not get default values** and must be initialized before use.

---

# 7. Real-World Example

Consider a **Student class**:

```java
public class Student {
    String name; // global variable
    int age;     // global variable
    
    public void display() {

        String message = "Student Details"; // local variable

        System.out.println(message);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

    }

    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Jack";
        s.age = 22;
        s.display();
    }
}
```

### Explanation

* `name` and `age` are **global variables**
* `message` is a **local variable**

---

# 8. Important Points

* **Local variables exist only inside methods**
* **Instance variables belong to objects**
* **Static variables belong to the class**
* Local variables **must be initialized**
* Instance variables **get default values**

---