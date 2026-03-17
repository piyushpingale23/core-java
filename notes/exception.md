# Java Exception Handling

---

# What is an Exception?

An **Exception** is an **unexpected event** that occurs during program execution and **disrupts the normal flow** of the program.

### Example

```java
int x = 10 / 0; // ArithmeticException
```

---

# Why Exception Handling?

Without handling:

* Program **terminates abruptly**
* Remaining code **won’t execute**

With handling:

* Program **continues execution**
* We can **log, recover, or notify**

---

# How We Can Handle Exceptions?

### Using `try-catch-finally`

```java
class TryCatchFinally {
    public static void main(String[] args) {
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Handled");
        } finally {
            System.out.println("Always executes");
        }
    }
}
```

---

# Runtime Stack Mechanism (Step-by-Step)

## Example

```java
public class StackFlow {
    static void method3() {
        int x = 10 / 0; // Exception here
    }
    static void method2() {
        method3();
    }
    static void method1() {
        method2();
    }
    public static void main(String[] args) {
        method1();
    }
}
```

---

## Execution Flow

### Step 1: Stack Creation

```
main()
```

### Step 2: method1() called

```
main()
 └── method1()
```

### Step 3: method2() called

```
main()
 └── method1()
      └── method2()
```

### Step 4: method3() called

```
main()
 └── method1()
      └── method2()
           └── method3()
```

### Step 5: Exception occurs

```
method3() → ArithmeticException
```

---

## Stack Unwinding (Propagation)

* method3() → no handling → goes to method2()
* method2() → no handling → goes to method1()
* method1() → no handling → goes to main()
* main() → no handling → JVM handles

---

# Default Exception Handler (JVM)

If no `catch` block handles the exception:

JVM's **Default Exception Handler** does:

1. Prints exception message
2. Prints stack trace
3. Terminates program

---

## Example

```java
public class DefaultHandlerDemo {

    public static void main(String[] args) {
        int x = 10 / 0;
    }
}
```

---

## Output

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at DefaultHandlerDemo.main(DefaultHandlerDemo.java:5)
```

---

# Exception Hierarchy

```
java.lang.Object
   └── Throwable
         ├── Exception
         │     ├── Checked Exceptions
         │     │     ├── IOException
         │     │     ├── SQLException
         │     │ 
         │     └── Unchecked Exceptions (RuntimeException)
         │           ├── ArithmeticException
         │           ├── NullPointerException
         │           ├── ArrayIndexOutOfBoundsException
         │           └── ...
         └── Error
               ├── OutOfMemoryError
               ├── StackOverflowError
               └── ...
```

---

# Checked vs Unchecked Exception

## Checked Exception (Compile-Time)

* Checked at **compile time**
* Must be handled using `try-catch` OR `throws`

### Example:

```java
FileReader file = new FileReader("test.txt"); // IOException
```

---

## Unchecked Exception (Runtime)

* Occurs at **runtime**
* Handling is **optional**

### Example:

```java
int x = 10 / 0; // ArithmeticException
```

---

## Difference Table

| Feature           | Checked      | Unchecked            |
|-------------------|--------------|----------------------|
| Checked at        | Compile time | Runtime              |
| Handling required | Yes          | No                   |
| Examples          | IOException  | NullPointerException |

---

# Exception vs Error

| Feature   | Exception          | Error                 |
|-----------|--------------------|-----------------------|
| Type      | Recoverable        | Non-recoverable       |
| Handling  | Can handle         | Cannot handle usually |
| Caused by | Application issues | JVM/System issues     |
| Example   | IOException        | OutOfMemoryError      |

---

# throw vs throws

## throw

* Used to **explicitly throw exception**
* Used inside method

```
throw new RuntimeException("Error occurred");
```

---

## throws

* Used in **method signature**
* Declares exception

```java
void readFile() throws IOException {
}
```

---

## Difference

| Feature | throw           | throws              |
|---------|-----------------|---------------------|
| Usage   | Inside method   | Method signature    |
| Purpose | Throw exception | Declare exception   |
| Count   | One object      | Multiple exceptions |

---

# Key Rules

✔ `try` must be followed by `catch` or `finally`
✔ `finally` always executes (except JVM shutdown)
✔ Specific catch → before generic catch
✔ Only **Throwable** types can be thrown
✔ Checked exceptions must be handled or declared

---

# Final Summary

* Exception = runtime disruption
* Use `try-catch-finally` to handle
* JVM handles if you don’t (default handler)
* Stack unwinding = exception propagation
* Checked → compile-time
* Unchecked → runtime
* Error ≠ Exception
* `throw` → create exception
* `throws` → declare exception

---
