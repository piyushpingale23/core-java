# Object Class in Java

## 1. Introduction

In Java, the **Object class** is the root (parent) of the entire class hierarchy.

Every class in Java **directly or indirectly inherits from the Object class**.

The Object class is present in the package:

```
java.lang.Object
```

Since `java.lang` is automatically imported, we do not need to import it manually.

Example:

```java
public class Student {

}
```

Even though we did not extend any class, Java internally treats it as:

```java
public class Student extends Object {

}
```

---

# 2. Importance of Object Class

The Object class provides **common methods** that are available to every Java class.

These methods help perform operations such as:

* Object comparison
* Hash code generation
* String representation of objects
* Object cloning
* Thread synchronization

---

# 3. Common Methods of Object Class

| Method      | Description                             |
| ----------- | --------------------------------------- |
| toString()  | Returns string representation of object |
| equals()    | Compares two objects                    |
| hashCode()  | Returns hash code value                 |
| getClass()  | Returns runtime class information       |
| clone()     | Creates copy of object                  |
| finalize()  | Called before garbage collection        |
| wait()      | Causes thread to wait                   |
| notify()    | Wakes up waiting thread                 |
| notifyAll() | Wakes up all waiting threads            |

---

# 4. toString() Method

The `toString()` method returns a **string representation of an object**.

### Example

```java
package objectclass;

class Student {

    int id;
    String name;

    public String toString() {
        return id + " " + name;
    }

}

public class ToStringExample {

    public static void main(String[] args) {

        Student s = new Student();
        s.id = 101;
        s.name = "Jack";

        System.out.println(s);

    }

}
```

Output:

```
101 Piyush
```

---

# 5. equals() Method

The `equals()` method compares **two objects for equality**.

### Example

```java
package objectclass;

class Person {

    int id;

    Person(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {

        Person p = (Person) obj;
        return this.id == p.id;

    }

}

public class EqualsExample {

    public static void main(String[] args) {

        Person p1 = new Person(10);
        Person p2 = new Person(10);

        System.out.println(p1.equals(p2));

    }

}
```

Output

```
true
```

---

# 6. hashCode() Method

The `hashCode()` method returns a **unique integer value for the object**.

It is commonly used in:

* HashMap
* HashSet
* HashTable

### Example

```java
package objectclass;

public class HashCodeExample {

    public static void main(String[] args) {

        String name1 = "Java";
        String name2 = "Java";

        System.out.println(name1.hashCode());
        System.out.println(name2.hashCode());

    }

}
```

---

# 7. getClass() Method

The `getClass()` method returns the **runtime class information of an object**.

### Example

```java
package objectclass;

public class GetClassExample {

    public static void main(String[] args) {

        String name = "Java Programming";

        System.out.println(name.getClass());

    }

}
```

Output

```
class java.lang.String
```

---

# 8. clone() Method

The `clone()` method creates a **copy of an object**.

### Example

```java
package objectclass;

class Student implements Cloneable {

    int id;

    Student(int id) {
        this.id = id;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

public class CloneExample {

    public static void main(String[] args) throws Exception {

        Student s1 = new Student(100);

        Student s2 = (Student) s1.clone();

        System.out.println(s1.id);
        System.out.println(s2.id);

    }

}
```

---

# 9. Real World Example

Consider a `Student` object:

```java
package objectclass;

public class Student {

    int id;
    String name;

    Student(int id, String name) {

        this.id = id;
        this.name = name;

    }

    public static void main(String[] args) {

        Student s = new Student(1, "Jack");

        System.out.println(s);
        System.out.println(s.hashCode());
        System.out.println(s.getClass());

    }

}
```

---

# 10. Important Points

* Object class is the **superclass of all classes in Java**
* It belongs to **java.lang package**
* Every Java object inherits its methods
* Common methods include:

    * `toString()`
    * `equals()`
    * `hashCode()`
    * `getClass()`
    * `clone()`

---

# 11. Package Structure Example

Example structure for your repository:

```
core-java
│
└── src
    └── main
        └── java
            └── objectclass
                ├── ToStringExample.java
                ├── EqualsExample.java
                ├── HashCodeExample.java
                ├── GetClassExample.java
                └── CloneExample.java
```

---

# 12. Conclusion

The **Object class** is the most fundamental class in Java.

It provides common methods that allow objects to:

* Compare themselves
* Represent themselves as strings
* Provide unique hash codes
* Clone objects
* Access runtime class information

Understanding the Object class is important for learning advanced topics such as:

* Collections Framework
* Multithreading
* Object comparison
* Java frameworks like Spring and Hibernate
